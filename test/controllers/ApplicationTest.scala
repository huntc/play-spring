package controllers

import org.specs2.mock.Mockito
import org.specs2.mutable._

import play.api.test._
import play.api.test.Helpers._
import services.TextGenerator

/**
 * Add your spec here.
 * We focus here on testing the controller only - not the infrastructure in front or behind it. Using dependency
 * injection allows the application controller to become testable. It is conceivable that you might have a unit
 * test for the controller if there is enough logic contained in the method that makes it worth testing - the
 * integration test might offer a more useful test if there is not given that you are then testing that the
 * route is configured properly.
 */
class ApplicationTest extends Specification with Mockito {
  
  "Application" should {
    
    "invoke the text generator" in {
      val textGenerator = mock[TextGenerator]
      val application = new controllers.Application(textGenerator)

      textGenerator.welcomeText returns ""

      application.index(FakeRequest())

      there was one(textGenerator).welcomeText
    }
  }
}