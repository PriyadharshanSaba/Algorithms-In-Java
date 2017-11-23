import java.util.*;
public class LeakyBucket
{
    public static void main(String [] args)
    {
        Scanner PD = new Scanner(System.in);
        int no_groups, bucket_size;
        System.out.println("Enter the bucket size");
        bucket_size=PD.nextInt();
        System.out.println("Enter the no of groups");
        no_groups=PD.nextInt();
        int no_packets [] = new int[no_groups];
        int in_bw [] = new int[no_groups];
        int out_bw, regd_bw = 0, tot_packets = 0;
        
        for(int i=0;i<no_groups;i++)
        {
            System.out.println("Enter the no of packets for group "+(i+1)+"\t");
            no_packets[i] = PD.nextInt();
            System.out.println("Enter the input bandwidth for group "+(i+1));
            in_bw[i] = PD.nextInt();
            
            if((tot_packets)+no_packets[i] <= bucket_size)
            {
                tot_packets += no_packets[i];
            }
            else
            {
                do
                {
                    System.out.println("Bucket overflow");
                    System.out.println("Enter the values less than "+ (bucket_size - tot_packets ));
                    no_packets[i]=PD.nextInt();
                }
                while((tot_packets + no_packets[i]) > bucket_size);
   
                tot_packets +=no_packets[i];
            }
            regd_bw += (no_packets[i] * in_bw[i]);
        }
        
        System.out.println("The total required bandwidth: "+regd_bw);
        System.out.println("Enter output bandwidth");
        out_bw=PD.nextInt();
        int temp = regd_bw;
        int rem_pkts = tot_packets;
        
        while((out_bw <= temp) && (rem_pkts>0))
        {
            System.out.println("Data sent \n"+(--rem_pkts)+" remaining");
            System.out.println("Remaining bandwidth: "+(temp-=out_bw));
            if((out_bw>temp) && (rem_pkts > 0))
                System.out.println(rem_pkts+" packets discovered due to insufficient bandwidth");
        }
    }
}
