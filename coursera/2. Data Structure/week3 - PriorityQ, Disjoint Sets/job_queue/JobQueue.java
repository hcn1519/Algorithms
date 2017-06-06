/**
 * Created by changnam on 2017. 5. 28..
 */
import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class WorkerComparator implements Comparator<Worker> {

    public int compare(Worker a, Worker b) {
        if (a.startWorkTime > b.startWorkTime) {
            return 1;
        } else if (a.startWorkTime < b.startWorkTime) {
            return -1;
        }

        return a.index > b.index ? 1 : -1;
    }
}
class Worker {
    int index;
    long startWorkTime;

    Worker(int index, long startWorkTime) {
        this.index = index;
        this.startWorkTime = startWorkTime;
    }
}
public class JobQueue {
    private int numWorkers;
    private int[] jobs;

    private int[] assignedWorker;
    private long[] startTime;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new JobQueue().solve();
    }

    private void readData() throws IOException {
        numWorkers = in.nextInt();
        int m = in.nextInt();
        jobs = new int[m];
        for (int i = 0; i < m; ++i) {
            jobs[i] = in.nextInt();
        }

    }

    private void writeResponse() {
        for (int i = 0; i < jobs.length; ++i) {
            out.println(assignedWorker[i] + " " + startTime[i]);
        }
    }


    private void assignJobs() {
        // TODO: replace this code with a faster algorithm.
        assignedWorker = new int[jobs.length];
        startTime = new long[jobs.length];

        Comparator<Worker> comparator = new WorkerComparator();

        PriorityQueue<Worker> JobQ = new PriorityQueue<>(comparator);

        for(int i=0; i<numWorkers; i++) {
            Worker w = new Worker(i, 0);
            JobQ.add(w);
        }

        if (jobs.length == 0) {
            for(int i=0; i<numWorkers; i++) {
                System.out.println(i + " " + 0);
            }
            return;
        }

        for (int i = 0; i < jobs.length; i++) {
            Worker current = JobQ.poll();

            System.out.println(current.index + " " +current.startWorkTime);

            current.startWorkTime += jobs[i];

            JobQ.add(current);
        }

    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        assignJobs();
//        writeResponse();
        out.close();
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
