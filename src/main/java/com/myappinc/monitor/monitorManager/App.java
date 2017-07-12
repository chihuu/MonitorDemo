package com.myappinc.monitor.monitorManager;

import java.io.IOException;

import com.spikeify.ffmpeg.FFmpeg;
import com.spikeify.ffmpeg.FFmpegExecutor;
import com.spikeify.ffmpeg.FFprobe;
import com.spikeify.ffmpeg.builder.FFmpegBuilder;
import com.spikeify.ffmpeg.probe.FFmpegFormat;
import com.spikeify.ffmpeg.probe.FFmpegProbeResult;
import com.spikeify.ffmpeg.probe.FFmpegStream;



/**
 * Hello world!
 *
 */
public class App 
{   
	String b;
	public void getb(String s){
		this.b =s;
	}
	
    public boolean runMonitor(String linkAddress) throws IOException
    { 
    	   	
    	    String s = "http://origin.onworldtv.com:1935/live/sbtn/index.m3u8";
        
 
        System.out.println( "Hello World!" );
        FFmpeg ffmpeg = new FFmpeg("/usr/local/Cellar/ffmpeg/3.3.2/bin/ffmpeg");
        FFprobe ffprobe = new FFprobe("/usr/local/Cellar/ffmpeg/3.3.2/bin/ffprobe");
        FFmpegProbeResult probeResult = ffprobe.probe(linkAddress);
        FFmpegFormat format = probeResult.getFormat();
        if(format.start_time > 0) {
        		return true;
        }
        return false;
//        System.out.format("%nFile: '%s' ; Format: '%s' ; Duration: %.3fs", 
//        	format.filename, 
//        	format.format_long_name,
//        	format.duration
//        );
//
//        FFmpegStream stream = probeResult.getStreams().get(0);
//        System.out.format("%nCodec: '%s' ; Width: %dpx ; Height: %dpx",
//        	stream.codec_long_name,
//        	stream.width,
//        	stream.height
//        );
      
    }
   
}
