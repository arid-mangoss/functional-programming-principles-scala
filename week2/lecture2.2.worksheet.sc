  
  
def product(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 
        1
    else 
        f(a)*product(f)(a+1, b)
}

product(x => x*x)(1,5)

def factorial(n:Int): Int = product(x=>x)(1, n)

def mapReduce(f: Int => Int)(combine: (Int, Int) => Int)(a: Int, b: Int, base: Int): Int = {
    if (a > b) 
        base
    else 
        combine(f(a), mapReduce(f)(combine)(a+1, b, base))
}

def mapReduce2(f: Int => Int, combine: (Int, Int) => Int, base: Int)(a: Int, b: Int): Int = {
    def recur(a: Int): Int = { 
        if (a > b)  
            return base
        else 
            return combine(f(a), recur(a+1))
    }
    return recur(a)
}

def product2(f:Int => Int)(a:Int, b:Int): Int = mapReduce(f)((x,y) => x*y)(a, b, 1)
def product3(f:Int => Int)(a:Int, b:Int): Int = mapReduce2(f, (x,y) => x*y, 1)(a, b)

product2(x=>x)(1,4)
product3(x=>x)(1,4)

 