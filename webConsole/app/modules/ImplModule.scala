package modules

import java.time.Clock

import com.github.sample.daos.{MyDao, MyDaoImpl}
import com.github.sample.services.{MyService, MyServiceImpl}
import com.google.inject.AbstractModule
import modules.samples.ApplicationTimer

class ImplModule extends AbstractModule {

  override def configure() = {
    bind(classOf[MyService]).to(classOf[MyServiceImpl])
    bind(classOf[MyDao]).to(classOf[MyDaoImpl])

    bind(classOf[ApplicationTimer]).asEagerSingleton()
    bind(classOf[Clock]).toInstance(Clock.systemDefaultZone)
  }

}
