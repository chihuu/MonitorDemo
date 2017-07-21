package com.myappinc.monitor.monitorManager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.spikeify.ffmpeg.FFmpeg;
import com.spikeify.ffmpeg.FFmpegExecutor;
import com.spikeify.ffmpeg.FFprobe;
import com.spikeify.ffmpeg.builder.FFmpegBuilder;
import com.spikeify.ffmpeg.probe.FFmpegFormat;
import com.spikeify.ffmpeg.probe.FFmpegProbeResult;

import com.spikeify.ffmpeg.probe.FFmpegStream;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;

import javax.media.bean.playerbean.MediaPlayer;

/**
 * Hello world!
 *
 */
public class App {
	String b;
	String a;
	String c;
	String linkFFmpeg;
	String linkFFprobe;

	public void getb(String s) {
		this.b = s;
	}

	public String getUrlFFmeg(String urlFFmpeg) {
		this.a = urlFFmpeg;
		return a;
	}

	public String getUrlFFprobe(String urlFFprobe) {
		this.c = urlFFprobe;
		return c;
	}

	public boolean runMonitor(String linkAddress) throws IOException {
		App app = new App();
		String s = "http://origin.onworldtv.com:1935/live/sbtn/index.m3u8";
		String a = null;

		// System.out.println( "Hello World!" );
		// FFmpeg ffmpeg = new FFmpeg("/usr/local/Cellar/ffmpeg/3.3.2/bin/ffmpeg");
		// FFprobe ffprobe = new FFprobe("/usr/local/Cellar/ffmpeg/3.3.2/bin/ffprobe");
		FFmpeg ffmpeg = new FFmpeg(app.getUrlFFmeg(a));
		FFprobe ffprobe = new FFprobe(app.getUrlFFprobe(c));
		System.out.println(a + "a :");
		FFmpegProbeResult probeResult = ffprobe.probe(linkAddress);
		FFmpegFormat format = probeResult.getFormat();
		if (format.start_time > 0) {
			return true;
		}
		return false;
		// System.out.format("%nFile: '%s' ; Format: '%s' ; Duration: %.3fs",
		// format.filename,
		// format.format_long_name,
		// format.duration
		// );
		//
		// FFmpegStream stream = probeResult.getStreams().get(0);
		// System.out.format("%nCodec: '%s' ; Width: %dpx ; Height: %dpx",
		// stream.codec_long_name,
		// stream.width,
		// stream.height
		// );

	}

	public boolean runMonitor1(String linkAddress) throws IOException {

		String s = "http://origin.onworldtv.com:1935/live/sbtn/index.m3u8";

		MonitorJSONWriteFile monitor = new MonitorJSONWriteFile();
		linkFFmpeg = monitor.readConfigFFmpeg();
		linkFFprobe = monitor.readConfigFFmprobe();

		FFmpeg ffmpeg = new FFmpeg(linkFFmpeg);
		FFprobe ffprobe = new FFprobe(linkFFprobe);
		FFmpegProbeResult probeResult = ffprobe.probe(linkAddress);
		FFmpegFormat format = probeResult.getFormat();
		if (format.start_time > 0) {
			return true;
		}
		return false;
	}

}
