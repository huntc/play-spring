import org.springframework.context.annotation.AnnotationConfigApplicationContext
import play.api.{Application, GlobalSettings}

/**
 * Set up general configuration for the application. In particular we set up the Spring application context.
 */
object Global extends GlobalSettings {

  /**
   * Declare the application context to be used.
   */
  val ctx = new AnnotationConfigApplicationContext

  /**
   * Configure the application context - tell it what packages to scan and then to refresh itself.
   * @param app
   */
  override def onStart(app: Application) {
    ctx.scan("controllers", "services")
    ctx.refresh()
  }

  /**
   * Tidy up by closing down the application context.
   * @param app
   */
  override def onStop(app: Application) {
    ctx.stop()
  }

  /**
   * Controllers must be resolved through the application context. There is a special method of GlobalSettings
   * that we can override to resolve a given controller. This resolution is required by the Play router.
   * @param controllerClass
   * @tparam A
   * @return
   */
  override def getControllerInstance[A](controllerClass: Class[A]): A = ctx.getBean(controllerClass)
}
