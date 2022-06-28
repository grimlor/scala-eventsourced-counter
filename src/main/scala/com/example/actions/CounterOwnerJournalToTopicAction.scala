package com.example.actions

import com.example.domain.CounterOwnerAdded
import com.google.protobuf.any.{ Any => ScalaPbAny }
import com.google.protobuf.empty.Empty
import kalix.scalasdk.action.Action
import kalix.scalasdk.action.ActionCreationContext

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class CounterOwnerJournalToTopicAction(creationContext: ActionCreationContext) extends AbstractCounterOwnerJournalToTopicAction {

  override def add(counterOwnerAdded: CounterOwnerAdded): Action.Effect[Added] = {
    effects.reply(Added(counterOwnerAdded.name))
  }
  override def ignore(any: ScalaPbAny): Action.Effect[Empty] = {
    effects.reply(Empty.defaultInstance)
  }
}

