package com.oskarro.reactive

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.kotlin.toObservable
import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.subjects.Subject
import org.junit.jupiter.api.Test

//@SpringBootTest
class ReactiveTest {

    @Test
    fun traditionalIterator() {
        val list: List<Any> = listOf("One", 2, "Three", 4, 4.5, "Five", "Six", 7.0f)
        val iterator: Iterator<Any> = list.iterator()
        while (iterator.hasNext()) {
            println(iterator.next())
        }
    }

    @Test
    fun reactiveObservation() {
        val subject: Subject<Int> = PublishSubject.create()
        subject.map { isEven(it) }.subscribe {
            println("The number is ${ (if (it) "Even" else "Odd") }")
        }

        subject.onNext(44)
        subject.onNext(65)
    }

    private fun isEven(n:Int):Boolean = ((n % 2) == 0)
}