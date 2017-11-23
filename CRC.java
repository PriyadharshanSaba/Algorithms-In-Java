import java.io.*;
class CRC
{
    public static void main(String[]args) throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int [] message;
        int [] gen;
        int [] app_message;
        int [] rem;
        int [] trans_message;
        int message_bits, gen_bits,total_bits;
        
        System.out.println("\n Enter the no. of bits");
        
        message_bits = Integer.parseInt(br.readLine());
        message = new int [message_bits];
        System.out.println("Enter message in bits");
        for(int i=0;i<message_bits;i++)
        {
            message[i]=Integer.parseInt(br.readLine());
        }
        System.out.println("Enter the no of bits of gen");
        gen_bits = Integer.parseInt(br.readLine());
        gen = new int[gen_bits];
        System.out.println("Enter the gen bits");
        for(int i=0;i<gen_bits;i++)
        {
            gen[i]=Integer.parseInt(br.readLine());
        }
        total_bits = message_bits+gen_bits-1;
        app_message = new int[total_bits];
        rem = new int[total_bits];
        trans_message = new int[total_bits];
        
        for(int i=0;i<message.length;i++)
        {
            app_message[i]=message[i];
        }
        System.out.println("Msg bits are");
        for(int i=0;i<message_bits;i++)
        {
            System.out.println( message[i] );
        }
        
        System.out.println("Generator bits are: ");
        for (int i=0;i<gen_bits;i++)
        {
            System.out.println(gen[i]);
        }
        System.out.println("Appended msg is:");
        
        for(int i=0;i<app_message.length;i++)
        {
            System.out.println(app_message[i]);
        }
        
        for(int j=0;j<app_message.length;j++)
        {
            rem[j]=app_message[j];
        }
        
        rem = computecrc(app_message,gen,rem);
        for(int i=0;i<app_message.length;i++)
        {
            trans_message[i]=(app_message[i]^rem[i]);
        }
        
        System.out.println("Transmitted msg from transmitter is: ");
        for(int i=0;i<trans_message.length;i++)
        {
            System.out.println(trans_message[i]);
        }
        
        System.out.println("Enter msg of "+total_bits+" bits recieved");
        for(int i=0;i<trans_message.length;i++)
        {
            trans_message[i]=Integer.parseInt(br.readLine());
        }
        
        for(int j=0;j<trans_message.length;j++)
        {
            rem[j]=trans_message[j];
        }
        rem = computecrc(trans_message,gen,rem);
        
        for(int i=0;i<rem.length;i++)
        {
            if(rem[i]!=0)
            {
                System.out.println("Error");
                break;
            }
            if(i == rem.length-1)
            {
                System.out.println("No error");
            }
        }
    }
    
    static int[] computecrc(int app_message[],int gen[],int rem[])
    {
        int current = 0;
        while(true)
        {
            for(int i=0;i<gen.length;i++)
                rem[current+i] = (int)(rem[current+i]^gen[i]);
            
            while(rem[current]==0 && current!=rem.length-1)
                current++;
            
            if ((rem.length-current)<gen.length)
                break;
        };
        return rem;
    }
}
