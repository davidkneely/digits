package models;

/**
 * Creates an image from the Contact Form on NewContact.scala.html
 */
public class Image {
  private String name;
  private byte[] data;

  /**
   * Gets the image name.
   * @return The image name.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the image name.
   * @param name The image name.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the data.
   * @return The data.
   */
  public byte[] getData() {
    return data;
  }

  /**
   * Sets the data.
   * @param data The data.
   */
  public void setData(byte[] data) {
    this.data = data;
  }

  /**
   * Creates a new instance of an image with the name and data parameters.
   * @param name The name.
   * @param data The data.
   */
  public Image(String name, byte[] data) {
    this.name = name;
    this.data = data;
  }
}
