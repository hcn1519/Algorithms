import Foundation

protocol StandardInput {
    mutating func read() -> String
    mutating func readInt() -> Int
    mutating func readDouble() -> Double
    mutating func readLineToArray() -> [String]
}

struct ReadInput: StandardInput {

    private var currentIndex: Int = 0
    private var inputArray: [String] = []

    // 데이터를 배열로 변환
    public mutating func readLineToArray() -> [String] {
        let result = readLine()!
        let resultArray = result.components(separatedBy: " ")
        return resultArray
    }

    // 띄어쓰기 단위로 String 읽기
    public mutating func read() -> String {
        if inputArray.count == 0 {
            inputArray = self.readLineToArray()
        }
        let result = inputArray[inputArray.index(after: currentIndex-1)]
        currentIndex += 1

        if currentIndex == inputArray.count {
            self.inputArray.removeAll()
            self.currentIndex = 0
        }
        return result
    }

    // Int 데이터 읽기
    public mutating func readInt() -> Int {
        guard let result = Int(self.read()) else {
            fatalError("Int형 데이터가 아닙니다.")
        }

        return result
    }

    // Double 데이터 읽기
    public mutating func readDouble() -> Double {
        guard let result = Double(self.read()) else {
            fatalError("Double형 데이터가 아닙니다.")
        }

        return result
    }

}

func fib(n: Int) -> (Int, Int) {
  if n == 0 {
    return (1, 0)
  } else if n == 1 {
    return (0, 1)
  }

  var countArr: [(Int, Int)] = [(1, 0), (0, 1)]
  // 2 = 0 + 1
  // 3 = 2 + 1
  for i in 2...n {
    let zero = countArr[i-1].0 + countArr[i-2].0
    let one = countArr[i-1].1 + countArr[i-2].1
    countArr.append((zero, one))
  }

  return countArr[n]
}


var ri = ReadInput()
let count = ri.readInt()

for i  in 1...count {
  let x = ri.readInt()


  let fibX = fib(n: x)

  print("\(fibX.0) \(fibX.1)")
}