import Foundation

while true {
    let x = Double(arc4random_uniform(UInt32(10000)))
    
    let uc: Double = x * x * 3.1415926535897932384
    let taxi: Double = 2 * x * x
    
    print(String(format: "%.6f\n%.6f", uc, taxi))
}
//if let x = Double(readLine()!) {
//    let uc: Double = x * x * 3.1415926535897932384
//    let taxi: Double = 2 * x * x
//    
//    print(String(format: "%.6f\n%.6f", uc, taxi))
//}

