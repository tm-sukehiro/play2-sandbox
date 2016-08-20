package com.github.sample.services

import scala.concurrent.Future

trait MyService {
  def exec(str: String): Future[String]
}
