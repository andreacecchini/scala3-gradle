package org.example

/** This module contains the entrypoint of the program.
  */
object Main:
  /** @return
    *   a simple greeting message.
    */
  def greeting: String = "Welcome from Scala 3 and Gradle!"

  /** The entrypoint of the program.
    * @param args
    *   unused
    */
  def main(args: Array[String]): Unit = println:
    greeting
