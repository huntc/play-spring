package services

import javax.inject._

/**
 * A simple POJO service to return a string. Created purely to illustrate how beans can be declared using @Named.
 */
@Named
class TextGenerator {

  val welcomeText = "Your new application is ready."
}
