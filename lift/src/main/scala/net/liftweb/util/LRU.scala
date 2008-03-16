package net.liftweb.util

/*                                                *\
 (c) 2006-2007 WorldWide Conferencing, LLC
 Distributed under an Apache License
 http://www.apache.org/licenses/LICENSE-2.0
 \*                                                 */

import org.apache.commons.collections.map.{LRUMap, AbstractLinkedMap}
import org.apache.commons.collections.map.AbstractLinkedMap.LinkEntry
  
/**
 * LRU Cache wrapping {@link org.apache.commons.collections.map.LRUMap}
 *
 * @param size the maximum number of Elements allowed in the LRU map
 * @param loadFactor the Load Factor to construct our LRU with.
 */
class LRU[KeyType, ValueType](size: Int, loadFactor: Can[Float]) {
  private val map = loadFactor match {
    case Full(lf) => new LRUMap(size, lf)
    case Empty => new LRUMap(size)
  }
  
  def update(k: KeyType, v: ValueType) {
    map.put(k, v)
  }

  def apply(k: KeyType): ValueType = map.get(k).asInstanceOf[ValueType]
  def contains(k: KeyType): Boolean = map.containsKey(k)
}
