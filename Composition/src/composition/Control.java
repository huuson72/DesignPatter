package composition;

class Control implements IControl {
    private MyColor backColor;
    public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public MyColor getBackColor() {
		return backColor;
	}

	private String text;

    public Control(String text, MyColor backColor) {
        this.text = text;
        this.backColor = backColor;
    }

    @Override
    public void setBackColor(MyColor color) {
        this.backColor = color;
    }
}