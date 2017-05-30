import Foundation

func getPrimeSet(range: Int) -> [Bool] {
    var resultArr: [Bool] = Array(repeating: true, count: range+1)

    // 각각의 숫자 담긴 배열 생성
    var list: [Int] = []
    var i = 2
    while i < resultArr.count {
        list.append(i)
        i += 1
    }

    var x = 2
    while x*x <= range {

        if resultArr[x] {
            var k = x * x
            while k <= range {
                resultArr[k] = false
                k += x
            }
        }
        x += 1
    }
    return resultArr
}

let primes = getPrimeSet(range: 123456*2+1)

while true {
  if let input = Int(readLine()!) {
    if input == 0 {
      break
    }

    var counter = 0
    let range = input+1..<input*2+1

    for i in range {
      if primes[i] {
        counter += 1
      }
    }

    print(counter)
  }

}
