package uz.devazimjon.sample.mover.core.domain

import kotlin.jvm.Throws

class Queue<T>(list: MutableList<T> = mutableListOf()) {
    private val items: MutableList<T> = list

    fun isEmpty(): Boolean = items.isEmpty()

    fun count(): Int = items.count()

    override fun toString() = items.toString()

    fun add(element: T) {
        items.add(element)
    }

    @Throws(Exception::class)
    fun remove(): T {
        return if (items.isEmpty()) {
            throw Exception("Nothing to remove from collection")
        } else {
            items.removeAt(0)
        }
    }

    fun remove(element: T): Boolean {
        return items.remove(element)
    }

    @Throws(Exception::class)
    fun element(): T {
        return if (items.isEmpty()) {
            throw Exception("Nothing to return from collection")
        } else {
            items[0]
        }
    }

    fun offer(element: T): Boolean {
        try {
            items.add(element)
        } catch (e: Exception) {
            return false
        }
        return true
    }

    fun poll(): T? {
        if (items.isEmpty()) return null
        return items.removeAt(0)
    }

    fun peek(): T? {
        if (isEmpty()) return null
        return items[0]
    }

    fun addAll(queue: Queue<T>) {
        items.addAll(queue.items)
    }

    fun clear() {
        items.removeAll { true }
    }
}
