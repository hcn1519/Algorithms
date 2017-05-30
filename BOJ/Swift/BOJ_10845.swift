import Foundation

struct Queue {
    fileprivate var dataArr: [Int] = []
    fileprivate var head = 0
    fileprivate var tail = 0

    public var size: Int {
        return dataArr.count
    }
    
    public var isEmpty: Bool {
        return dataArr.isEmpty
    }
    public var front: Int {
        if self.isEmpty {
            return -1
        }
        return dataArr[head]
    }
    public var back: Int {
        if self.isEmpty {
            return -1
        }
        return dataArr[tail-1]
    }

    mutating func enQueue(_ input: Int) {
        dataArr.append(input)
        tail += 1
    }
    mutating func deQueue() -> Int {
        if self.isEmpty {
            return -1
        }
        let result = dataArr[head]
        dataArr.remove(at:head)
        tail -= 1
        
        return result
    }
}

var q = Queue()


if let number = Int(readLine()!) {
    for i in 1...number {
        if let input = readLine() {
            let inputArr : [String] = input.components(separatedBy: " ")
            
            switch inputArr[0] {
            case "push":
                q.enQueue(Int(inputArr[1])!)
            case "pop":
                print(q.deQueue())
            case "front":
                print(q.front)
            case "back":
                print(q.back)
            case "size":
                print(q.size)
            case "empty":
                print(q.isEmpty ? 1 : 0)
            default:
                fatalError()
                break
            }
            
        }
    }
}
