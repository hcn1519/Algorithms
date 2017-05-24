import Foundation

struct MinHeap {
    var dataArr: [Int] = []
    var size: Int = 0
    
    private func parent(_ i: Int) -> (Int) {
        return i/2
    }
    private func child(_ i: Int, _ isLeft: Bool) -> (Int) {
        return (isLeft ? 2*i : 2*i+1)
    }
    
    private mutating func swap(_ parentIndex: Int, _ childIndex: Int) {
        let temp = dataArr[parentIndex]
        dataArr[parentIndex] = dataArr[childIndex]
        dataArr[childIndex] = temp
    }
    
    private mutating func siftUp(_ i: Int) {
        var i = i
        
        while i > 1 && dataArr[parent(i)-1] > dataArr[i-1] {
            swap(parent(i)-1, i-1)
            i = parent(i)
        }
    }
    
    private mutating func siftDown(_ i: Int) {
        var i = i
        var minIndex = i
        
        while minIndex*2 < size {
            if dataArr[minIndex-1] > dataArr[child(minIndex, true)-1] || dataArr[minIndex-1] > dataArr[child(minIndex, false)-1]  {
                
                if dataArr[child(minIndex, true)-1] < dataArr[child(minIndex, false)-1] {
                    minIndex = child(minIndex, true)
                } else {
                    minIndex = child(minIndex, false)
                }
            }
            
            if minIndex != i {
                swap(minIndex-1, i-1)
                i = minIndex
            } else {
                break
            }
        }
        
    }
    
    mutating func extractMax() -> (Int) {
        if size == 0 {
            return 0
        }
        
        // 최솟값 추출
        let result = dataArr[0]
        dataArr[0] = dataArr[size-1]
        
        // 마지막 값 자리 찾아가기
        siftDown(1)
        
        dataArr.remove(at: size-1)
        size -= 1
        
        return result
    }
    
    mutating func insert(_ input: Int) {
        size += 1
        dataArr.append(input)

        // 마지막 자리에 insert 후, 자리 찾아가기
        siftUp(size)
    }
}

let count = readLine()
var minHeap = MinHeap()

for i in 0..<Int(count!)! {
    if let input = Int(readLine()!) {
        if input == 0 {
            print(minHeap.extractMax())
        } else {
            minHeap.insert(input)
//            print(minHeap.dataArr)
        }
    }
    
}
