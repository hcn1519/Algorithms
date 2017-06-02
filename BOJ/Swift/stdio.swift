import Foundation

struct ReadInput {

    public var readLineToArray: [String] {
      let result = readLine()!
      let resultArray = result.components(separatedBy: " ")
      return resultArray
    }

    public var readInt: Int {
        guard let result = Int(readLine()!) else {
            fatalError("Int형 데이터가 아닙니다.")
        }

        return result
    }

    public var readDouble: Double {
      guard let result = Double(readLine()!) else {
          fatalError("Double형 데이터가 아닙니다.")
      }

      return result
    }
}


var ri = ReadInput()


let resultArr: [String] = ri.readLineToArray
let num1 = ri.readInt
let num2 = ri.readDouble

print(resultArr)
print(num1)
print(num2)
