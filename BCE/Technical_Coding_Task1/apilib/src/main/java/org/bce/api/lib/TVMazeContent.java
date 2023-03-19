package org.bce.api.lib;

/**
 * TVMazeContent within the most important data chunks: 
 *                              the title, the year, its rating, plus added it
 *
 * @see https://www.tvmaze.com/api#show-search</a>
 */
public class TVMazeContent {
  
  @SuppressWarnings("unused")
  private final String VERSION = "0.0.1";
  
  private String id;
  // @JsonProperty("name")
  private String title;
  //@JsonProperty("premiered")
  private String year;
  //@JsonProperty("average")
  private String rating;
  
  public TVMazeContent(String anID, String aTitle, String aYear, String aRating) {
    this.setId(anID);
    this.setTitle(aTitle);
    this.setYear(aYear);
    this.setRating(aRating);
  }

  /**
   * @param anID id
   **/
  public void setId(String anID) {
    this.id = anID;
  }

  /**
   * @return id
   **/
  public String getId() {
    return this.id;
  }

  /**
   * @param aYear year
   **/
  public void setYear(String aYear) {
    this.year = aYear;
  }

  /**
   * @return premiered year
   **/
  public String getYear() {
    return this.year;
  }

  /**
   * @param aTitle film name
   **/
  public void setTitle(String aTitle) {
    this.title = aTitle;
  }

  /**
   * @return film name
   **/
  public String getTitle() {
    return this.title;
  }


  /**
   * @param aRating average rating
   **/
  public void setRating(String aRating) {
    this.rating = aRating;
  }

  /**
   * @return average rating
   **/
  public String getRating() {
    return this.rating;
  }
  
} // TVMazeContent
