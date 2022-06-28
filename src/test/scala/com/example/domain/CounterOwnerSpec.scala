package com.example.domain

import com.example
import com.google.protobuf.empty.Empty
import kalix.scalasdk.eventsourcedentity.EventSourcedEntity
import kalix.scalasdk.testkit.EventSourcedResult
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class CounterOwnerSpec extends AnyWordSpec with Matchers {
  "The CounterOwner" should {
    "correctly process commands of type Add" in {
      val testOwner = "test owner"
      val testKit = CounterOwnerTestKit(new CounterOwner(_))
      val result: EventSourcedResult[Empty] = testKit.add(example.AddCounterOwner("id1", testOwner))
      val actualEvent = result.nextEvent[CounterOwnerAdded]
      actualEvent shouldBe CounterOwnerAdded(testOwner)
    }

    "correctly process commands of type Delete" in {
      val testKit = CounterOwnerTestKit(new CounterOwner(_))
      pending
      // val result: EventSourcedResult[Empty] = testKit.delete(example.DeleteCounterOwner(...))
    }

    "correctly process commands of type GetOwner" in {
      val testKit = CounterOwnerTestKit(new CounterOwner(_))
      pending
      // val result: EventSourcedResult[example.CounterOwner] = testKit.getOwner(example.GetCounterOwner(...))
    }
  }
}
