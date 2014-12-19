/*
 * Copyright 2014 IBM Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ibm.spark.kernel.protocol.v5.content

import com.ibm.spark.kernel.protocol.v5.KernelMessageContent
import play.api.libs.json._

case class InspectRequest(
  code: String,
  cursor_pos: Int,
  detail_level: Int // TODO: This is currently either 0 or 1... should we
                    // TODO: look into enforcing that in our schema?
) extends KernelMessageContent {
  override def content : String =
    Json.toJson(this)(InspectRequest.inspectRequestWrites).toString
}

object InspectRequest {
  implicit val inspectRequestReads = Json.reads[InspectRequest]
  implicit val inspectRequestWrites = Json.writes[InspectRequest]
}

