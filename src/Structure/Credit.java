package Structure;
public class Credit {

	private String type;
    private String item;
    private String source;
    private String license;

    public Credit() {
        type = "No Type";
        item = "Empty Constructor";
        source = "No Source";
        license = "No License";
    }

	public Credit(String inputType, String inputItem, String inputSource, String inputLicense) {
        type = inputType;
        item = inputItem;
        source = inputSource;
        license = inputLicense;
	}

    public String type(){
        return type;
    }

    public String source(){
        return source;
    }

    public String license(){
        return license;
    }

    public String item(){
        return item;
    }
}