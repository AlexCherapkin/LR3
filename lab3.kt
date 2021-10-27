import java.util.

sealed class ResultT
class SuccessT(val data  T)  ResultT()
class ErrorT(val message   String = Unknown error)  ResultT()

enum class Operation{
    SORT_ASC 
    {
        override fun T  ComparableT invoke(list ListT)  ListT
        {
            return list.sorted()
        }
    },
    
    SORT_DESC 
    {
        override fun T  ComparableT invoke(list ListT)  ListT
        {
            return list.sortedDescending()
        }
    },
    
    SHUFFLE 
    {
        override fun T  ComparableT invoke(list ListT)  ListT
        {
            return list.shuffled()
        }
    };
    
    abstract operator fun T  ComparableT invoke(list ListT) ListT
}

fun T  ComparableT ListT.operate(operation Operation) ResultListT
    {
        if (this.isEmpty()) return Error(Empty)
        
        when (operation)
        {
            Operation.SORT_ASC - return Success(Operation.SORT_ASC(this))
            Operation.SORT_DESC - return Success(Operation.SORT_DESC(this))
            Operation.SHUFFLE - return Success(Operation.SHUFFLE(this))
    	}
    
}   

fun generateStrings(stringsLenght Int, length  Int)  ListString
{
    val allowedChars = ('A'..'Z') + ('a'..'z')
    var answer = mutableListOfString()
    for(i in 1..length) answer.add((1..stringsLenght)
            				  .map { allowedChars.random() }
            				  .joinToString())
    return answer
}


fun generateIntegers(length  Int)  ListInt
{
    return (-1000..1000).shuffled().take(length)
}
    
fun T  ComparableT ResultListT.print() Unit
{
    if (this is Error) println(this.message)
    	else if (this is Success) println(this.data)
}

fun main() {   
    generateStrings(6,4).operate(Operation.SORT_ASC).print()
    generateStrings(5,8).operate(Operation.SORT_DESC).print()
    generateStrings(3,3).operate(Operation.SHUFFLE).print()
    generateIntegers(5).operate(Operation.SORT_ASC).print()
    generateIntegers(3).operate(Operation.SORT_DESC).print()
    generateIntegers(9).operate(Operation.SHUFFLE).print()
}
