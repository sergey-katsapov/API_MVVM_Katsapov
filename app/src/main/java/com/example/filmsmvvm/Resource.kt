/*
//TODO add this realization
typealias SimpleResource = Resource<Unit>

sealed class Resource<T>(val data: T? = null, val message: UiText? = null, val additionalMessages: List<UiText>? = null) {
    class Success<T>(data: T? = null) : Resource<T>(data = data)
    class Error<T>(message: UiText, additionalMessages: List<UiText>? = null,  data: T? = null) : Resource<T>(data = data, message =  message, additionalMessages = additionalMessages)
}
*/
