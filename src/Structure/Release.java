package Structure;

import javax.swing.ImageIcon;

public class Release {

	private String versionNumber;
    private String releaseDate;
    private String summary;
    private ImageIcon descriptiveImage;
    private int imageW, imageH;
    private ImageIcon bannerImage;
    String [] patches = {};
    String [] features = {};

    public Release() {
        versionNumber = "-1";
        releaseDate = "No Date";
    }

	public Release(String inputVersionNumber, String inputReleaseDate, String inputSummary, String [] inputPatches, String [] inputFeatures) {
        versionNumber = inputVersionNumber;
        releaseDate = inputReleaseDate;
        summary = inputSummary;
        patches = inputPatches;
        features = inputFeatures;
        bannerImage = new ImageIcon("FIRSTMate-Assets\\R\\"+ inputVersionNumber + ".png");
	}

    public Release(String inputVersionNumber, String inputReleaseDate, String inputSummary, String [] inputPatches, String [] inputFeatures, ImageIcon inputDescriptiveImage, int inputImageW, int inputImageH) {
        versionNumber = inputVersionNumber;
        releaseDate = inputReleaseDate;
        summary = inputSummary;
        patches = inputPatches;
        features = inputFeatures;
        descriptiveImage = inputDescriptiveImage;
        imageW = inputImageW;
        imageH = inputImageH;
        bannerImage = new ImageIcon("FIRSTMate-Assets\\R\\"+ inputVersionNumber + ".png");
	}

    public String versionNumber(){
        return versionNumber;
    }

    public String releaseDate(){
        return releaseDate;
    }

    public String summary(){
        return summary;
    }

    public String [] patches(){
        return patches;
    }

    public String [] features(){
        return features;
    }

    public ImageIcon bannerImage(){
        return bannerImage;
    }

    public ImageIcon descriptiveImage(){
        return descriptiveImage;
    }

    public int imageW(){
        return imageW;
    }

    public int imageH(){
        return imageH;
    }
}