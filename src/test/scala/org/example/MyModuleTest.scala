package org.example

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class MyModuleTest extends AnyFlatSpec with Matchers:
  behavior of "MyModule"

  it should "have f() function which returns 42" in:
    MyModule.f() shouldBe 42
