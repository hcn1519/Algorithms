import Foundation

func numSelf(_ n: Int) -> Int {
  let str = String(n)

  var result = n
  for item in str.characters {
    result += Int(String(item))!
  }

  return result
}

var resultArr = Array(repeating: false, count: 10001)

for i in 1...10000 {
  if numSelf(i) <= 10000 {
      resultArr[numSelf(i)] = true
  }
}

for (index, value) in resultArr.enumerated() {
  if index == 0 {
    continue
  }
  if !value {
    print(index)
  }
}
