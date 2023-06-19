package com.demoapp.cleanarchdemo.common

/**
 * Репрезентует результат сети.
 */
sealed class Resource<T>(val data: T? = null, val message: String? = null) {

    /**
     * Результат, который успешно получил ответ, содержащий данные
     */
    class Success<T>(data: T) : Resource<T>(data)

    /**
     * Результат, который успешно получил ответ, содержащий сообщение об ошибке
     */
    class Error<T>(message: String?, data: T? = null) : Resource<T>(data, message)

    /**
     * Состояние загрузки, т.е. еще не был получен ни один результат
     */
    class Loading<T>(data: T? = null) : Resource<T>(data)
}