import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Principal {
        public static void main(String[] args){
                Document doc = Jsoup.connect("https://www.reddit.com/r/programming").get();
                Elements repositories = doc.getElementsByClass("repo-item");


                for (Element repository : repositories) {
                    String repositoryTitle = repository.getElementsByClass("repo-item-title").text();

                    String repositoryIssues = repository.getElementsByClass("repo-item-issues").text();

                    String repositoryDescription = repository.getElementsByClass("repo-item-description").text();

                    String repositoryGithubName = repository.getElementsByClass("repo-item-full-name").text();

                    String repositoryGithubLink = "https://github.com/" + repositoryGithubName.replaceAll("[()]", "");


                }
        }

    }


