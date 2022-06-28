package com.example.domain

import com.example
import com.google.protobuf.empty.Empty
import kalix.scalasdk.eventsourcedentity.EventSourcedEntity
import kalix.scalasdk.eventsourcedentity.EventSourcedEntityContext

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class CounterOwner(context: EventSourcedEntityContext) extends AbstractCounterOwner {
  override def emptyState: CounterOwnerState = CounterOwnerState()

  override def add(currentState: CounterOwnerState, addCounterOwner: example.AddCounterOwner): EventSourcedEntity.Effect[Empty] =
    effects.emitEvent(CounterOwnerAdded(addCounterOwner.name)).thenReply(_ => Empty())

  override def delete(currentState: CounterOwnerState, deleteCounterOwner: example.DeleteCounterOwner): EventSourcedEntity.Effect[Empty] =
    effects.emitEvent(CounterOwnerDeleted()).thenReply(_ => Empty())

  override def getOwner(currentState: CounterOwnerState, getCounterOwner: example.GetCounterOwner): EventSourcedEntity.Effect[example.CounterOwner] =
    effects.reply(example.CounterOwner(currentState.name))

  override def counterOwnerAdded(currentState: CounterOwnerState, counterOwnerAdded: CounterOwnerAdded): CounterOwnerState =
    currentState.copy(name = currentState.name)

  override def counterOwnerDeleted(currentState: CounterOwnerState, counterOwnerDeleted: CounterOwnerDeleted): CounterOwnerState =
    emptyState

}
