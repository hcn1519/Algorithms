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

func checkSeq(_ n: Int) -> Bool {
  let str = String(n)

  // 한자리 수는 true
  if str.characters.count == 1 {
    return true
  }

  var result = true
  let dif = Int(String(str[str.startIndex]))! - Int(String(str[str.index(after: str.startIndex)]))!
  // print("diff \(dif)")
  for (i, _ ) in str.characters.enumerated() {

    var v1: Int!
    var v2: Int!
    if i+1 != str.characters.count {
      v1 = Int(String(str[str.index(str.startIndex, offsetBy: i)]))!
      v2 = Int(String(str[str.index(str.startIndex, offsetBy: i+1)]))!

      // print(v1)
      // print(v2)
      if dif != v1 - v2 {
        result = false
        break
      }
    }


  }
  return result

}


var ri = ReadInput()

let bound = ri.readInt()

var result = 0
for i in 1...bound {
  if checkSeq(i) {
    result += 1
  }
}

print(result)
