package services

import org.specs2.mutable._

/**
  * Unit tests for the service itself. We would expect that the majority of unit tests would be on components like
  * this.
  */
class TextGeneratorTest extends Specification {

   "TextGenerator" should {

     "generate some text" in {
       val textGenerator = new TextGenerator

       textGenerator.welcomeText mustEqual("Your new application is ready.")
     }
   }
 }