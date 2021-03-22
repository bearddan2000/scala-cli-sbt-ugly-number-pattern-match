object MyApp {
/*This function divides a by greatest divisible power of b*/
def maxDivide(a: Int, b :Int):Int = a match
{
    case a if(a%b != 0) => return a;
    case _ => return maxDivide(a/b, b);
}

/* Function to check if a number is ugly or not */
def isUgly(no: Int): Int =
{
    var a:Int = maxDivide(no, 2);
    var b:Int = maxDivide(a, 3);
    var c:Int = maxDivide(b, 5);

    if(c == 1) return 1 else return 0;
}

/* Function to get the nth ugly number*/
def getNthUglyNo(n: Int, i: Int, count: Int /* ugly number count */): Int = n match
{
    /*Check for all integers untill ugly count becomes n*/
    case n if (n < count) => return i-1;
    case _ => if (isUgly(i) == 1) return getNthUglyNo(n, i+1, count+1);
              else return getNthUglyNo(n, i+1, count);
}

def main(args: Array[String]): Unit = {
var i:Int = 10;
println("[INPUT] "+ i);
var o:Int = getNthUglyNo(i,1,1);
println("[OUTPUT] "+ o);
}
}
