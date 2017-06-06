import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Request {
    public Request(int arrival_time, int process_time) {
        this.arrival_time = arrival_time;
        this.process_time = process_time;
    }

    public int arrival_time;
    public int process_time;
}

class Response {
    public Response(boolean dropped, int start_time) {
        this.dropped = dropped;
        this.start_time = start_time;
    }

    public boolean dropped;
    public int start_time;
}

class Buffer {
    // init
    public Buffer(int size) {
        this.size_ = size;
        this.finish_time_ = new ArrayList<Integer>();

        this.head = -1;
        this.tail = -1;
        this.howMany = 0;
    }

    public Response Process(Request request) {
        // request 정보 : 도착시간, 처리시간
        // response를 리턴
        int finishTime = request.arrival_time + request.process_time;

        if (this.howMany == 0) {
          if (this.size_ == 0) {
            return new Response(true, -1);
          }

          // 빈 버퍼
          this.finish_time_.add(finishTime);
          head++;
          tail++;
          howMany = 1;

          return new Response(false, request.arrival_time);

        } else {

          while (this.finish_time_.get(head) <= request.arrival_time && head != tail) {
            // 앞에 있는 것 처리 후 버퍼에서 제거
                howMany--;
                head++;
          }

          int prev = this.finish_time_.get(tail);
          // tail--;


          if (prev > request.arrival_time) {
            // 아직 기존 것 미처리 상태
            if (this.size_ > howMany) {
              // 처리 가능, 버퍼에 추가
              howMany++;
              this.finish_time_.add(prev + request.process_time);
              tail++;

              // System.out.println("미처리 상태" + (prev + request.process_time));
              return new Response(false, prev);
            } else {
              // 처리 불가능
              return new Response(true, -1);
            }
          } else {
            // 기존 것 처리 후 도착
            if (this.size_ >= howMany) {
              this.finish_time_.add(request.arrival_time + request.process_time);
              howMany++;
              tail++;
              // System.out.println("처리후 도착");
              return new Response(false, request.arrival_time);
            } else {
              // 처리 불가능
              return new Response(true, -1);
            }
          }

        }


    }

    private int size_;
    private ArrayList<Integer> finish_time_;

    private int head;
    private int tail;

    private int howMany;

}

class process_packages {
    // 도착 시간과 처리 시간을 requests 리스트에 저장
    private static ArrayList<Request> ReadQueries(Scanner scanner) throws IOException {
        int requests_count = scanner.nextInt();
        ArrayList<Request> requests = new ArrayList<Request>();
        for (int i = 0; i < requests_count; ++i) {
            int arrival_time = scanner.nextInt();
            int process_time = scanner.nextInt();
            requests.add(new Request(arrival_time, process_time));
        }
        return requests;
    }

    private static ArrayList<Response> ProcessRequests(ArrayList<Request> requests, Buffer buffer) {
        ArrayList<Response> responses = new ArrayList<Response>();
        for (int i = 0; i < requests.size(); ++i) {
            // 각각의 request에서 도착시간과 처리시간 정보 제공
            // 그 결과를 기준으로 response 객체의 정보 저장
            responses.add(buffer.Process(requests.get(i)));
        }
        return responses;
    }

    private static void PrintResponses(ArrayList<Response> responses) {
        for (int i = 0; i < responses.size(); ++i) {
            Response response = responses.get(i);
            if (response.dropped) {
                System.out.println(-1);
            } else {
                System.out.println(response.start_time);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int buffer_max_size = scanner.nextInt();
        Buffer buffer = new Buffer(buffer_max_size);
        ArrayList<Request> requests = ReadQueries(scanner);

        // 각각의 결과에 대해 저장
        ArrayList<Response> responses = ProcessRequests(requests, buffer);
        PrintResponses(responses);
    }
}
