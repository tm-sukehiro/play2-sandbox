package com.github.sample.daos

trait MyDao {
  def exec(): Option[String]
}
