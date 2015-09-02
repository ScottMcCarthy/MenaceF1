package crawl;

public class RegexTest {
	
	public static final String RESULT_URL = ".*/results/([0-9A-F]+).*$";

	public static void main(String[] args) {
		
		String broken  = "/results/F8110A90D334454DPQ/1/$7b$22limiters$22:$5b$5d,$22mqlversion$22:$221.0$22,$22additionalnavs$22:$5b$5d,$22v$22:$221$22,$22sort$22:$22relevance$22,$22param$22:$7b$22NAVIGATORS$22:$22navsummarynav,sourcetypenav,decadenav$28filter$3d110$2f0$2f*,sort$3dname$2fascending$29,yearnav$28filter$3d1100$2f0$2f*,sort$3dname$2fascending$29,yearmonthnav$28filter$3d120$2f0$2f*,sort$3dname$2fascending$29,monthnav$28sort$3dname$2fascending$29,daynav$28sort$3dname$2fascending$29,pubtitlenav,objecttypenav,languagenav$28filter$3d200$2f0$2f*$29$22,$22RS$22:$22OP$22,$22chunkSize$22:$2220$22,$22instance$22:$22preprod.academic$22,$22ftblock$22:$220+194216+216+660848+194000$22,$22removeDuplicates$22:$22true$22$7d,$22serializer$22:$22std1.4$22,$22searchterms$22:$5b$7b$22name$22:$22$22,$22qry$22:$22golden+boy$22,$22fld$22:$22citationBody$22,$22top$22:$22AND$22$7d$5d,$22meta$22:$7b$22UsageSearchMode$22:$22Basic$22,$22dbselections$22:$22unassigned$7carts$7chealth$7cnews$7chistory$7csocialsciences$7cscience$7cliterature$7cbusiness$7cdissertations$22,$22SEARCH_ID_TIMESTAMP$22:$221432302022628$22$7d,$22querytype$22:$22basic:OS$22$7d";
		String working = "/results/5D24AAD50F874393PQ/1/$7b$22limiters$22:$5b$5d,$22mqlversion$22:$221.0$22,$22additionalnavs$22:$5b$5d,$22v$22:$221$22,$22sort$22:$22relevance$22,$22param$22:$7b$22NAVIGATORS$22:$22navsummarynav,sourcetypenav,decadenav$28filter$3d110$2f0$2f*,sort$3dname$2fascending$29,yearnav$28filter$3d1100$2f0$2f*,sort$3dname$2fascending$29,yearmonthnav$28filter$3d120$2f0$2f*,sort$3dname$2fascending$29,monthnav$28sort$3dname$2fascending$29,daynav$28sort$3dname$2fascending$29,pubtitlenav,objecttypenav,languagenav$28filter$3d200$2f0$2f*$29$22,$22RS$22:$22OP$22,$22chunkSize$22:$2220$22,$22instance$22:$22preprod.academic$22,$22ftblock$22:$220+194216+216+660848+194000$22,$22removeDuplicates$22:$22true$22$7d,$22serializer$22:$22std1.4$22,$22searchterms$22:$5b$7b$22name$22:$22$22,$22qry$22:$22golden+boy$22,$22fld$22:$22citationBody$22,$22top$22:$22AND$22$7d$5d,$22meta$22:$7b$22UsageSearchMode$22:$22Basic$22,$22dbselections$22:$22unassigned$7carts$7chealth$7cnews$7chistory$7csocialsciences$7cscience$7cliterature$7cbusiness$7cdissertations$22,$22SEARCH_ID_TIMESTAMP$22:$221432302244132$22$7d,$22querytype$22:$22basic:OS$22$7d";
		
		System.out.println("Checking Regex");
		
		System.out.println("broken:  "+broken.matches(RESULT_URL));
		System.out.println("working: "+working.matches(RESULT_URL));

	}

}
