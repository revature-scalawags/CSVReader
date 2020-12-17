package csvreader

import org.mongodb.scala.bson.codecs.Macros._

import org.mongodb.scala.MongoClient
import org.bson.codecs.configuration.CodecRegistries.{fromProviders, fromRegistries}
import org.mongodb.scala.MongoCollection
import scala.concurrent.Await
import org.mongodb.scala.Observable
import scala.concurrent.duration.{Duration, SECONDS}
import org.mongodb.scala.model.Filters.equal

class StatesDao(mongoClient: MongoClient) {
  val codecRegistry = fromRegistries(
    fromProviders(classOf[States]),
    MongoClient.DEFAULT_CODEC_REGISTRY
  )
  val db = mongoClient.getDatabase("statesdb").withCodecRegistry(codecRegistry)
  val collection: MongoCollection[States] = db.getCollection("states")

  private def getResults[T](obs: Observable[T]): Seq[T] = {
      Await.result(obs.toFuture(), Duration(10, SECONDS))
  }

  def getAll(): Seq[States] = getResults(collection.find())

  def getByName(name: String): Seq[States] = {
      getResults(collection.find(equal("name", name)))
  }
}
