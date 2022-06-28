package com.example.actions

import com.google.protobuf.empty.Empty
import kalix.scalasdk.action.Action
import kalix.scalasdk.action.ActionCreationContext
import org.slf4j.LoggerFactory

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class CounterOwnerTopicSubscriptionAction(creationContext: ActionCreationContext) extends AbstractCounterOwnerTopicSubscriptionAction {

  private val logger = LoggerFactory.getLogger(getClass())
  
  override def add(added: Added): Action.Effect[Empty] = {
    logger.info(s"Received add event: $added")
    effects.reply(Empty.defaultInstance)
  }
}
