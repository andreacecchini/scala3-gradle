package org.example

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class MainSuite extends AnyFlatSpec with Matchers:
  "Main" should "have a greeting message" in:
    Main.greeting shouldBe "Welcome from Scala 3 and Gradle!"
