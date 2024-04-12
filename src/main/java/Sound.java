import java.util.*;
public class Sound
{
  /** the array of values in this sound; guaranteed not to be null */
  int[] samples;



  /** Changes those values in this sound that have an amplitude greater than limit.
   *  Values greater than limit are changed to limit.
   *  Values less than -limit are changed to -limit.
   *  @param limit the amplitude limit
   *         Precondition: limit >= 0
   *  @return the number of values in this sound that this method changed
   */
  public int limitAmplitude(int limit)
  {  
    int change = 0;
    for(int i = 0; i < samples.length; i++){
      if(samples[i] < -limit){
        samples[i] = -limit;
        change++;
      }
      else if(samples[i] > limit){
        samples[i] = limit;
        change++;
      }
    }
    return change;
  }



  /** Removes all silence from the beginning of this sound.
   *  Silence is represented by a value of 0.
   *  Precondition: samples contains at least one nonzero value
   *  Postcondition: the length of samples reflects the removal of starting silence
   */
  public void trimSilenceFromBeginning()
  {
    int a = 0;
    while(samples[a] == 0){
      a++;
    }
    int[] arr = new int[samples.length-a];
    for(int r = 0; r < samples.length; r++){
      arr[r] = samples[r+a];
    }
    samples = arr;
  }
}
