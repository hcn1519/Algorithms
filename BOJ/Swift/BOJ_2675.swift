import Foundation

protocol StandardInput {
    mutating func readLineToArray() -> [String]
    mutating func read() -> String
    mutating func readInt() -> Int
    mutating func readDouble() -> Double
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


var ri = ReadInput()

let num = ri.readInt()

for i in 1...num {
  let iter = ri.readInt()
  let str = ri.read()

  for item in str.characters {
    for p in 1...iter {
      print(item, terminator:"")
    }
  }
  print("")
}
