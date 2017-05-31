import Foundation

var dict: [Int: Int] = [:]

for _ in 1...10 {
    if let x = Int(readLine()!) {
        dict.updateValue(1, forKey: x%42)
    }
}

print(dict.count)
