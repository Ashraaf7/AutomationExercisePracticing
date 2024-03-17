package com.automationexercise.Utilities;

import org.monte.media.Format;
import org.monte.media.FormatKeys;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.Registry;
import org.monte.media.math.Rational;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static org.monte.media.VideoFormatKeys.*;

public class ScreenRecorderUtils extends org.monte.screenrecorder.ScreenRecorder {
    public final static String RECORDINGS_PATH = "test-outputs/screen-records/";
    private static ScreenRecorderUtils screenRecorderUtils;
    private final String filename;

    public ScreenRecorderUtils(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat,
                               Format screenFormat, Format mouseFormat, Format audioFormat, File movieFolder, String name)
            throws IOException, AWTException {
        super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);
        filename = name;
    }

    public static void startRecording(String fileName) throws Exception {
        try {
            File file = new File(RECORDINGS_PATH);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle captureSize = new Rectangle(0, 0, screenSize.width, screenSize.height);


            screenRecorderUtils = new ScreenRecorderUtils(GraphicsEnvironment.getLocalGraphicsEnvironment().
                    getDefaultScreenDevice()
                    .getDefaultConfiguration(), captureSize,
                    new Format(FormatKeys.MediaTypeKey, MediaType.FILE, FormatKeys.MimeTypeKey, FormatKeys.MIME_AVI),
                    new Format(FormatKeys.MediaTypeKey, MediaType.VIDEO, FormatKeys.EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                            CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FormatKeys.FrameRateKey,
                            Rational.valueOf(15), QualityKey, 0.0f, FormatKeys.KeyFrameIntervalKey, 15 * 60),
                    new Format(FormatKeys.MediaTypeKey, MediaType.VIDEO, FormatKeys.EncodingKey, "black", FormatKeys.FrameRateKey, Rational.valueOf(30)),
                    null, file, fileName);

            screenRecorderUtils.start();
        } catch (Exception e) {
            LogUtils.error(e.getMessage());
        }


    }

    public static void stopRecording() throws Exception {
        try {
            screenRecorderUtils.stop();
        } catch (Exception e) {
            LogUtils.error(e.getMessage());
        }

    }

    @Override
    protected File createMovieFile(Format fileFormat) throws IOException {
        try {
            if (!movieFolder.exists()) {
                movieFolder.mkdirs();
            } else if (!movieFolder.isDirectory()) {
                throw new IOException("\"" + movieFolder + "\" is not a directory.");
            }
            //TODO: Adding timestamp to video name
            return new File(movieFolder,
                    filename + "-" + "." +
                            Registry.getInstance().getExtension(fileFormat));

        } catch (Exception e) {
            LogUtils.error(e.getMessage());
            return null;
        }

    }
}
