package io.github.jhipster.jdl.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import io.github.jhipster.jdl.services.JDLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalJDLParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'mapstruct'", "'pager'", "'pagination'", "'Integer'", "'Long'", "'BigDecimal'", "'Float'", "'Double'", "'Blob'", "'AnyBlob'", "'ImageBlob'", "'OneToMany'", "'ManyToOne'", "'OneToOne'", "'ManyToMany'", "'serviceClass'", "'serviceImpl'", "'entity'", "'{'", "'}'", "','", "'minlength'", "'('", "')'", "'maxlength'", "'pattern'", "'min'", "'max'", "'minbytes'", "'maxbytes'", "'relationship'", "'to'", "'enum'", "'with'", "'except'", "'String'", "'Boolean'", "'LocalDate'", "'ZonedDateTime'", "'required'", "'service'", "'microservice'", "'search'", "'dto'", "'paginate'", "'angularSuffix'", "'*'", "'all'", "'infinite-scroll'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalJDLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalJDLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalJDLParser.tokenNames; }
    public String getGrammarFileName() { return "InternalJDL.g"; }


    	private JDLGrammarAccess grammarAccess;

    	public void setGrammarAccess(JDLGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleJdlDomainModel"
    // InternalJDL.g:53:1: entryRuleJdlDomainModel : ruleJdlDomainModel EOF ;
    public final void entryRuleJdlDomainModel() throws RecognitionException {
        try {
            // InternalJDL.g:54:1: ( ruleJdlDomainModel EOF )
            // InternalJDL.g:55:1: ruleJdlDomainModel EOF
            {
             before(grammarAccess.getJdlDomainModelRule()); 
            pushFollow(FOLLOW_1);
            ruleJdlDomainModel();

            state._fsp--;

             after(grammarAccess.getJdlDomainModelRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJdlDomainModel"


    // $ANTLR start "ruleJdlDomainModel"
    // InternalJDL.g:62:1: ruleJdlDomainModel : ( ( rule__JdlDomainModel__FeaturesAssignment )* ) ;
    public final void ruleJdlDomainModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:66:2: ( ( ( rule__JdlDomainModel__FeaturesAssignment )* ) )
            // InternalJDL.g:67:2: ( ( rule__JdlDomainModel__FeaturesAssignment )* )
            {
            // InternalJDL.g:67:2: ( ( rule__JdlDomainModel__FeaturesAssignment )* )
            // InternalJDL.g:68:3: ( rule__JdlDomainModel__FeaturesAssignment )*
            {
             before(grammarAccess.getJdlDomainModelAccess().getFeaturesAssignment()); 
            // InternalJDL.g:69:3: ( rule__JdlDomainModel__FeaturesAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==28||LA1_0==41||LA1_0==43||(LA1_0>=51 && LA1_0<=56)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalJDL.g:69:4: rule__JdlDomainModel__FeaturesAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__JdlDomainModel__FeaturesAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getJdlDomainModelAccess().getFeaturesAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlDomainModel"


    // $ANTLR start "entryRuleJdlFeature"
    // InternalJDL.g:78:1: entryRuleJdlFeature : ruleJdlFeature EOF ;
    public final void entryRuleJdlFeature() throws RecognitionException {
        try {
            // InternalJDL.g:79:1: ( ruleJdlFeature EOF )
            // InternalJDL.g:80:1: ruleJdlFeature EOF
            {
             before(grammarAccess.getJdlFeatureRule()); 
            pushFollow(FOLLOW_1);
            ruleJdlFeature();

            state._fsp--;

             after(grammarAccess.getJdlFeatureRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJdlFeature"


    // $ANTLR start "ruleJdlFeature"
    // InternalJDL.g:87:1: ruleJdlFeature : ( ( rule__JdlFeature__Alternatives ) ) ;
    public final void ruleJdlFeature() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:91:2: ( ( ( rule__JdlFeature__Alternatives ) ) )
            // InternalJDL.g:92:2: ( ( rule__JdlFeature__Alternatives ) )
            {
            // InternalJDL.g:92:2: ( ( rule__JdlFeature__Alternatives ) )
            // InternalJDL.g:93:3: ( rule__JdlFeature__Alternatives )
            {
             before(grammarAccess.getJdlFeatureAccess().getAlternatives()); 
            // InternalJDL.g:94:3: ( rule__JdlFeature__Alternatives )
            // InternalJDL.g:94:4: rule__JdlFeature__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__JdlFeature__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getJdlFeatureAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlFeature"


    // $ANTLR start "entryRuleJdlEntity"
    // InternalJDL.g:103:1: entryRuleJdlEntity : ruleJdlEntity EOF ;
    public final void entryRuleJdlEntity() throws RecognitionException {
        try {
            // InternalJDL.g:104:1: ( ruleJdlEntity EOF )
            // InternalJDL.g:105:1: ruleJdlEntity EOF
            {
             before(grammarAccess.getJdlEntityRule()); 
            pushFollow(FOLLOW_1);
            ruleJdlEntity();

            state._fsp--;

             after(grammarAccess.getJdlEntityRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJdlEntity"


    // $ANTLR start "ruleJdlEntity"
    // InternalJDL.g:112:1: ruleJdlEntity : ( ( rule__JdlEntity__Group__0 ) ) ;
    public final void ruleJdlEntity() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:116:2: ( ( ( rule__JdlEntity__Group__0 ) ) )
            // InternalJDL.g:117:2: ( ( rule__JdlEntity__Group__0 ) )
            {
            // InternalJDL.g:117:2: ( ( rule__JdlEntity__Group__0 ) )
            // InternalJDL.g:118:3: ( rule__JdlEntity__Group__0 )
            {
             before(grammarAccess.getJdlEntityAccess().getGroup()); 
            // InternalJDL.g:119:3: ( rule__JdlEntity__Group__0 )
            // InternalJDL.g:119:4: rule__JdlEntity__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JdlEntity__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJdlEntityAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlEntity"


    // $ANTLR start "entryRuleJdlEntityField"
    // InternalJDL.g:128:1: entryRuleJdlEntityField : ruleJdlEntityField EOF ;
    public final void entryRuleJdlEntityField() throws RecognitionException {
        try {
            // InternalJDL.g:129:1: ( ruleJdlEntityField EOF )
            // InternalJDL.g:130:1: ruleJdlEntityField EOF
            {
             before(grammarAccess.getJdlEntityFieldRule()); 
            pushFollow(FOLLOW_1);
            ruleJdlEntityField();

            state._fsp--;

             after(grammarAccess.getJdlEntityFieldRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJdlEntityField"


    // $ANTLR start "ruleJdlEntityField"
    // InternalJDL.g:137:1: ruleJdlEntityField : ( ( rule__JdlEntityField__Group__0 ) ) ;
    public final void ruleJdlEntityField() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:141:2: ( ( ( rule__JdlEntityField__Group__0 ) ) )
            // InternalJDL.g:142:2: ( ( rule__JdlEntityField__Group__0 ) )
            {
            // InternalJDL.g:142:2: ( ( rule__JdlEntityField__Group__0 ) )
            // InternalJDL.g:143:3: ( rule__JdlEntityField__Group__0 )
            {
             before(grammarAccess.getJdlEntityFieldAccess().getGroup()); 
            // InternalJDL.g:144:3: ( rule__JdlEntityField__Group__0 )
            // InternalJDL.g:144:4: rule__JdlEntityField__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JdlEntityField__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJdlEntityFieldAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlEntityField"


    // $ANTLR start "entryRuleJdlFieldType"
    // InternalJDL.g:153:1: entryRuleJdlFieldType : ruleJdlFieldType EOF ;
    public final void entryRuleJdlFieldType() throws RecognitionException {
        try {
            // InternalJDL.g:154:1: ( ruleJdlFieldType EOF )
            // InternalJDL.g:155:1: ruleJdlFieldType EOF
            {
             before(grammarAccess.getJdlFieldTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleJdlFieldType();

            state._fsp--;

             after(grammarAccess.getJdlFieldTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJdlFieldType"


    // $ANTLR start "ruleJdlFieldType"
    // InternalJDL.g:162:1: ruleJdlFieldType : ( ( rule__JdlFieldType__Alternatives ) ) ;
    public final void ruleJdlFieldType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:166:2: ( ( ( rule__JdlFieldType__Alternatives ) ) )
            // InternalJDL.g:167:2: ( ( rule__JdlFieldType__Alternatives ) )
            {
            // InternalJDL.g:167:2: ( ( rule__JdlFieldType__Alternatives ) )
            // InternalJDL.g:168:3: ( rule__JdlFieldType__Alternatives )
            {
             before(grammarAccess.getJdlFieldTypeAccess().getAlternatives()); 
            // InternalJDL.g:169:3: ( rule__JdlFieldType__Alternatives )
            // InternalJDL.g:169:4: rule__JdlFieldType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__JdlFieldType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getJdlFieldTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlFieldType"


    // $ANTLR start "entryRuleJdlEnumField"
    // InternalJDL.g:178:1: entryRuleJdlEnumField : ruleJdlEnumField EOF ;
    public final void entryRuleJdlEnumField() throws RecognitionException {
        try {
            // InternalJDL.g:179:1: ( ruleJdlEnumField EOF )
            // InternalJDL.g:180:1: ruleJdlEnumField EOF
            {
             before(grammarAccess.getJdlEnumFieldRule()); 
            pushFollow(FOLLOW_1);
            ruleJdlEnumField();

            state._fsp--;

             after(grammarAccess.getJdlEnumFieldRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJdlEnumField"


    // $ANTLR start "ruleJdlEnumField"
    // InternalJDL.g:187:1: ruleJdlEnumField : ( ( rule__JdlEnumField__Group__0 ) ) ;
    public final void ruleJdlEnumField() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:191:2: ( ( ( rule__JdlEnumField__Group__0 ) ) )
            // InternalJDL.g:192:2: ( ( rule__JdlEnumField__Group__0 ) )
            {
            // InternalJDL.g:192:2: ( ( rule__JdlEnumField__Group__0 ) )
            // InternalJDL.g:193:3: ( rule__JdlEnumField__Group__0 )
            {
             before(grammarAccess.getJdlEnumFieldAccess().getGroup()); 
            // InternalJDL.g:194:3: ( rule__JdlEnumField__Group__0 )
            // InternalJDL.g:194:4: rule__JdlEnumField__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JdlEnumField__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJdlEnumFieldAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlEnumField"


    // $ANTLR start "entryRuleJdlStringField"
    // InternalJDL.g:203:1: entryRuleJdlStringField : ruleJdlStringField EOF ;
    public final void entryRuleJdlStringField() throws RecognitionException {
        try {
            // InternalJDL.g:204:1: ( ruleJdlStringField EOF )
            // InternalJDL.g:205:1: ruleJdlStringField EOF
            {
             before(grammarAccess.getJdlStringFieldRule()); 
            pushFollow(FOLLOW_1);
            ruleJdlStringField();

            state._fsp--;

             after(grammarAccess.getJdlStringFieldRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJdlStringField"


    // $ANTLR start "ruleJdlStringField"
    // InternalJDL.g:212:1: ruleJdlStringField : ( ( rule__JdlStringField__Group__0 ) ) ;
    public final void ruleJdlStringField() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:216:2: ( ( ( rule__JdlStringField__Group__0 ) ) )
            // InternalJDL.g:217:2: ( ( rule__JdlStringField__Group__0 ) )
            {
            // InternalJDL.g:217:2: ( ( rule__JdlStringField__Group__0 ) )
            // InternalJDL.g:218:3: ( rule__JdlStringField__Group__0 )
            {
             before(grammarAccess.getJdlStringFieldAccess().getGroup()); 
            // InternalJDL.g:219:3: ( rule__JdlStringField__Group__0 )
            // InternalJDL.g:219:4: rule__JdlStringField__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JdlStringField__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJdlStringFieldAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlStringField"


    // $ANTLR start "entryRuleJdlNumericField"
    // InternalJDL.g:228:1: entryRuleJdlNumericField : ruleJdlNumericField EOF ;
    public final void entryRuleJdlNumericField() throws RecognitionException {
        try {
            // InternalJDL.g:229:1: ( ruleJdlNumericField EOF )
            // InternalJDL.g:230:1: ruleJdlNumericField EOF
            {
             before(grammarAccess.getJdlNumericFieldRule()); 
            pushFollow(FOLLOW_1);
            ruleJdlNumericField();

            state._fsp--;

             after(grammarAccess.getJdlNumericFieldRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJdlNumericField"


    // $ANTLR start "ruleJdlNumericField"
    // InternalJDL.g:237:1: ruleJdlNumericField : ( ( rule__JdlNumericField__Group__0 ) ) ;
    public final void ruleJdlNumericField() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:241:2: ( ( ( rule__JdlNumericField__Group__0 ) ) )
            // InternalJDL.g:242:2: ( ( rule__JdlNumericField__Group__0 ) )
            {
            // InternalJDL.g:242:2: ( ( rule__JdlNumericField__Group__0 ) )
            // InternalJDL.g:243:3: ( rule__JdlNumericField__Group__0 )
            {
             before(grammarAccess.getJdlNumericFieldAccess().getGroup()); 
            // InternalJDL.g:244:3: ( rule__JdlNumericField__Group__0 )
            // InternalJDL.g:244:4: rule__JdlNumericField__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JdlNumericField__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJdlNumericFieldAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlNumericField"


    // $ANTLR start "entryRuleJdlBooleanField"
    // InternalJDL.g:253:1: entryRuleJdlBooleanField : ruleJdlBooleanField EOF ;
    public final void entryRuleJdlBooleanField() throws RecognitionException {
        try {
            // InternalJDL.g:254:1: ( ruleJdlBooleanField EOF )
            // InternalJDL.g:255:1: ruleJdlBooleanField EOF
            {
             before(grammarAccess.getJdlBooleanFieldRule()); 
            pushFollow(FOLLOW_1);
            ruleJdlBooleanField();

            state._fsp--;

             after(grammarAccess.getJdlBooleanFieldRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJdlBooleanField"


    // $ANTLR start "ruleJdlBooleanField"
    // InternalJDL.g:262:1: ruleJdlBooleanField : ( ( rule__JdlBooleanField__Group__0 ) ) ;
    public final void ruleJdlBooleanField() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:266:2: ( ( ( rule__JdlBooleanField__Group__0 ) ) )
            // InternalJDL.g:267:2: ( ( rule__JdlBooleanField__Group__0 ) )
            {
            // InternalJDL.g:267:2: ( ( rule__JdlBooleanField__Group__0 ) )
            // InternalJDL.g:268:3: ( rule__JdlBooleanField__Group__0 )
            {
             before(grammarAccess.getJdlBooleanFieldAccess().getGroup()); 
            // InternalJDL.g:269:3: ( rule__JdlBooleanField__Group__0 )
            // InternalJDL.g:269:4: rule__JdlBooleanField__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JdlBooleanField__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJdlBooleanFieldAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlBooleanField"


    // $ANTLR start "entryRuleJdlDateField"
    // InternalJDL.g:278:1: entryRuleJdlDateField : ruleJdlDateField EOF ;
    public final void entryRuleJdlDateField() throws RecognitionException {
        try {
            // InternalJDL.g:279:1: ( ruleJdlDateField EOF )
            // InternalJDL.g:280:1: ruleJdlDateField EOF
            {
             before(grammarAccess.getJdlDateFieldRule()); 
            pushFollow(FOLLOW_1);
            ruleJdlDateField();

            state._fsp--;

             after(grammarAccess.getJdlDateFieldRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJdlDateField"


    // $ANTLR start "ruleJdlDateField"
    // InternalJDL.g:287:1: ruleJdlDateField : ( ( rule__JdlDateField__Group__0 ) ) ;
    public final void ruleJdlDateField() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:291:2: ( ( ( rule__JdlDateField__Group__0 ) ) )
            // InternalJDL.g:292:2: ( ( rule__JdlDateField__Group__0 ) )
            {
            // InternalJDL.g:292:2: ( ( rule__JdlDateField__Group__0 ) )
            // InternalJDL.g:293:3: ( rule__JdlDateField__Group__0 )
            {
             before(grammarAccess.getJdlDateFieldAccess().getGroup()); 
            // InternalJDL.g:294:3: ( rule__JdlDateField__Group__0 )
            // InternalJDL.g:294:4: rule__JdlDateField__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JdlDateField__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJdlDateFieldAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlDateField"


    // $ANTLR start "entryRuleJdlBlobField"
    // InternalJDL.g:303:1: entryRuleJdlBlobField : ruleJdlBlobField EOF ;
    public final void entryRuleJdlBlobField() throws RecognitionException {
        try {
            // InternalJDL.g:304:1: ( ruleJdlBlobField EOF )
            // InternalJDL.g:305:1: ruleJdlBlobField EOF
            {
             before(grammarAccess.getJdlBlobFieldRule()); 
            pushFollow(FOLLOW_1);
            ruleJdlBlobField();

            state._fsp--;

             after(grammarAccess.getJdlBlobFieldRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJdlBlobField"


    // $ANTLR start "ruleJdlBlobField"
    // InternalJDL.g:312:1: ruleJdlBlobField : ( ( rule__JdlBlobField__Group__0 ) ) ;
    public final void ruleJdlBlobField() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:316:2: ( ( ( rule__JdlBlobField__Group__0 ) ) )
            // InternalJDL.g:317:2: ( ( rule__JdlBlobField__Group__0 ) )
            {
            // InternalJDL.g:317:2: ( ( rule__JdlBlobField__Group__0 ) )
            // InternalJDL.g:318:3: ( rule__JdlBlobField__Group__0 )
            {
             before(grammarAccess.getJdlBlobFieldAccess().getGroup()); 
            // InternalJDL.g:319:3: ( rule__JdlBlobField__Group__0 )
            // InternalJDL.g:319:4: rule__JdlBlobField__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JdlBlobField__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJdlBlobFieldAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlBlobField"


    // $ANTLR start "entryRuleJdlStringValidators"
    // InternalJDL.g:328:1: entryRuleJdlStringValidators : ruleJdlStringValidators EOF ;
    public final void entryRuleJdlStringValidators() throws RecognitionException {
        try {
            // InternalJDL.g:329:1: ( ruleJdlStringValidators EOF )
            // InternalJDL.g:330:1: ruleJdlStringValidators EOF
            {
             before(grammarAccess.getJdlStringValidatorsRule()); 
            pushFollow(FOLLOW_1);
            ruleJdlStringValidators();

            state._fsp--;

             after(grammarAccess.getJdlStringValidatorsRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJdlStringValidators"


    // $ANTLR start "ruleJdlStringValidators"
    // InternalJDL.g:337:1: ruleJdlStringValidators : ( ( rule__JdlStringValidators__Group__0 ) ) ;
    public final void ruleJdlStringValidators() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:341:2: ( ( ( rule__JdlStringValidators__Group__0 ) ) )
            // InternalJDL.g:342:2: ( ( rule__JdlStringValidators__Group__0 ) )
            {
            // InternalJDL.g:342:2: ( ( rule__JdlStringValidators__Group__0 ) )
            // InternalJDL.g:343:3: ( rule__JdlStringValidators__Group__0 )
            {
             before(grammarAccess.getJdlStringValidatorsAccess().getGroup()); 
            // InternalJDL.g:344:3: ( rule__JdlStringValidators__Group__0 )
            // InternalJDL.g:344:4: rule__JdlStringValidators__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JdlStringValidators__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJdlStringValidatorsAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlStringValidators"


    // $ANTLR start "entryRuleJdlNumericValidators"
    // InternalJDL.g:353:1: entryRuleJdlNumericValidators : ruleJdlNumericValidators EOF ;
    public final void entryRuleJdlNumericValidators() throws RecognitionException {
        try {
            // InternalJDL.g:354:1: ( ruleJdlNumericValidators EOF )
            // InternalJDL.g:355:1: ruleJdlNumericValidators EOF
            {
             before(grammarAccess.getJdlNumericValidatorsRule()); 
            pushFollow(FOLLOW_1);
            ruleJdlNumericValidators();

            state._fsp--;

             after(grammarAccess.getJdlNumericValidatorsRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJdlNumericValidators"


    // $ANTLR start "ruleJdlNumericValidators"
    // InternalJDL.g:362:1: ruleJdlNumericValidators : ( ( rule__JdlNumericValidators__Group__0 ) ) ;
    public final void ruleJdlNumericValidators() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:366:2: ( ( ( rule__JdlNumericValidators__Group__0 ) ) )
            // InternalJDL.g:367:2: ( ( rule__JdlNumericValidators__Group__0 ) )
            {
            // InternalJDL.g:367:2: ( ( rule__JdlNumericValidators__Group__0 ) )
            // InternalJDL.g:368:3: ( rule__JdlNumericValidators__Group__0 )
            {
             before(grammarAccess.getJdlNumericValidatorsAccess().getGroup()); 
            // InternalJDL.g:369:3: ( rule__JdlNumericValidators__Group__0 )
            // InternalJDL.g:369:4: rule__JdlNumericValidators__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JdlNumericValidators__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJdlNumericValidatorsAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlNumericValidators"


    // $ANTLR start "entryRuleJdlBlobValidators"
    // InternalJDL.g:378:1: entryRuleJdlBlobValidators : ruleJdlBlobValidators EOF ;
    public final void entryRuleJdlBlobValidators() throws RecognitionException {
        try {
            // InternalJDL.g:379:1: ( ruleJdlBlobValidators EOF )
            // InternalJDL.g:380:1: ruleJdlBlobValidators EOF
            {
             before(grammarAccess.getJdlBlobValidatorsRule()); 
            pushFollow(FOLLOW_1);
            ruleJdlBlobValidators();

            state._fsp--;

             after(grammarAccess.getJdlBlobValidatorsRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJdlBlobValidators"


    // $ANTLR start "ruleJdlBlobValidators"
    // InternalJDL.g:387:1: ruleJdlBlobValidators : ( ( rule__JdlBlobValidators__Group__0 ) ) ;
    public final void ruleJdlBlobValidators() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:391:2: ( ( ( rule__JdlBlobValidators__Group__0 ) ) )
            // InternalJDL.g:392:2: ( ( rule__JdlBlobValidators__Group__0 ) )
            {
            // InternalJDL.g:392:2: ( ( rule__JdlBlobValidators__Group__0 ) )
            // InternalJDL.g:393:3: ( rule__JdlBlobValidators__Group__0 )
            {
             before(grammarAccess.getJdlBlobValidatorsAccess().getGroup()); 
            // InternalJDL.g:394:3: ( rule__JdlBlobValidators__Group__0 )
            // InternalJDL.g:394:4: rule__JdlBlobValidators__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JdlBlobValidators__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJdlBlobValidatorsAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlBlobValidators"


    // $ANTLR start "entryRuleJdlRequiredValidator"
    // InternalJDL.g:403:1: entryRuleJdlRequiredValidator : ruleJdlRequiredValidator EOF ;
    public final void entryRuleJdlRequiredValidator() throws RecognitionException {
        try {
            // InternalJDL.g:404:1: ( ruleJdlRequiredValidator EOF )
            // InternalJDL.g:405:1: ruleJdlRequiredValidator EOF
            {
             before(grammarAccess.getJdlRequiredValidatorRule()); 
            pushFollow(FOLLOW_1);
            ruleJdlRequiredValidator();

            state._fsp--;

             after(grammarAccess.getJdlRequiredValidatorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJdlRequiredValidator"


    // $ANTLR start "ruleJdlRequiredValidator"
    // InternalJDL.g:412:1: ruleJdlRequiredValidator : ( ( rule__JdlRequiredValidator__RequiredAssignment ) ) ;
    public final void ruleJdlRequiredValidator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:416:2: ( ( ( rule__JdlRequiredValidator__RequiredAssignment ) ) )
            // InternalJDL.g:417:2: ( ( rule__JdlRequiredValidator__RequiredAssignment ) )
            {
            // InternalJDL.g:417:2: ( ( rule__JdlRequiredValidator__RequiredAssignment ) )
            // InternalJDL.g:418:3: ( rule__JdlRequiredValidator__RequiredAssignment )
            {
             before(grammarAccess.getJdlRequiredValidatorAccess().getRequiredAssignment()); 
            // InternalJDL.g:419:3: ( rule__JdlRequiredValidator__RequiredAssignment )
            // InternalJDL.g:419:4: rule__JdlRequiredValidator__RequiredAssignment
            {
            pushFollow(FOLLOW_2);
            rule__JdlRequiredValidator__RequiredAssignment();

            state._fsp--;


            }

             after(grammarAccess.getJdlRequiredValidatorAccess().getRequiredAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlRequiredValidator"


    // $ANTLR start "entryRuleJdlMinLengthValidator"
    // InternalJDL.g:428:1: entryRuleJdlMinLengthValidator : ruleJdlMinLengthValidator EOF ;
    public final void entryRuleJdlMinLengthValidator() throws RecognitionException {
        try {
            // InternalJDL.g:429:1: ( ruleJdlMinLengthValidator EOF )
            // InternalJDL.g:430:1: ruleJdlMinLengthValidator EOF
            {
             before(grammarAccess.getJdlMinLengthValidatorRule()); 
            pushFollow(FOLLOW_1);
            ruleJdlMinLengthValidator();

            state._fsp--;

             after(grammarAccess.getJdlMinLengthValidatorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJdlMinLengthValidator"


    // $ANTLR start "ruleJdlMinLengthValidator"
    // InternalJDL.g:437:1: ruleJdlMinLengthValidator : ( ( rule__JdlMinLengthValidator__Group__0 ) ) ;
    public final void ruleJdlMinLengthValidator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:441:2: ( ( ( rule__JdlMinLengthValidator__Group__0 ) ) )
            // InternalJDL.g:442:2: ( ( rule__JdlMinLengthValidator__Group__0 ) )
            {
            // InternalJDL.g:442:2: ( ( rule__JdlMinLengthValidator__Group__0 ) )
            // InternalJDL.g:443:3: ( rule__JdlMinLengthValidator__Group__0 )
            {
             before(grammarAccess.getJdlMinLengthValidatorAccess().getGroup()); 
            // InternalJDL.g:444:3: ( rule__JdlMinLengthValidator__Group__0 )
            // InternalJDL.g:444:4: rule__JdlMinLengthValidator__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JdlMinLengthValidator__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJdlMinLengthValidatorAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlMinLengthValidator"


    // $ANTLR start "entryRuleJdlMaxLengthValidator"
    // InternalJDL.g:453:1: entryRuleJdlMaxLengthValidator : ruleJdlMaxLengthValidator EOF ;
    public final void entryRuleJdlMaxLengthValidator() throws RecognitionException {
        try {
            // InternalJDL.g:454:1: ( ruleJdlMaxLengthValidator EOF )
            // InternalJDL.g:455:1: ruleJdlMaxLengthValidator EOF
            {
             before(grammarAccess.getJdlMaxLengthValidatorRule()); 
            pushFollow(FOLLOW_1);
            ruleJdlMaxLengthValidator();

            state._fsp--;

             after(grammarAccess.getJdlMaxLengthValidatorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJdlMaxLengthValidator"


    // $ANTLR start "ruleJdlMaxLengthValidator"
    // InternalJDL.g:462:1: ruleJdlMaxLengthValidator : ( ( rule__JdlMaxLengthValidator__Group__0 ) ) ;
    public final void ruleJdlMaxLengthValidator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:466:2: ( ( ( rule__JdlMaxLengthValidator__Group__0 ) ) )
            // InternalJDL.g:467:2: ( ( rule__JdlMaxLengthValidator__Group__0 ) )
            {
            // InternalJDL.g:467:2: ( ( rule__JdlMaxLengthValidator__Group__0 ) )
            // InternalJDL.g:468:3: ( rule__JdlMaxLengthValidator__Group__0 )
            {
             before(grammarAccess.getJdlMaxLengthValidatorAccess().getGroup()); 
            // InternalJDL.g:469:3: ( rule__JdlMaxLengthValidator__Group__0 )
            // InternalJDL.g:469:4: rule__JdlMaxLengthValidator__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JdlMaxLengthValidator__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJdlMaxLengthValidatorAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlMaxLengthValidator"


    // $ANTLR start "entryRuleJdlPatternValidator"
    // InternalJDL.g:478:1: entryRuleJdlPatternValidator : ruleJdlPatternValidator EOF ;
    public final void entryRuleJdlPatternValidator() throws RecognitionException {
        try {
            // InternalJDL.g:479:1: ( ruleJdlPatternValidator EOF )
            // InternalJDL.g:480:1: ruleJdlPatternValidator EOF
            {
             before(grammarAccess.getJdlPatternValidatorRule()); 
            pushFollow(FOLLOW_1);
            ruleJdlPatternValidator();

            state._fsp--;

             after(grammarAccess.getJdlPatternValidatorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJdlPatternValidator"


    // $ANTLR start "ruleJdlPatternValidator"
    // InternalJDL.g:487:1: ruleJdlPatternValidator : ( ( rule__JdlPatternValidator__Group__0 ) ) ;
    public final void ruleJdlPatternValidator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:491:2: ( ( ( rule__JdlPatternValidator__Group__0 ) ) )
            // InternalJDL.g:492:2: ( ( rule__JdlPatternValidator__Group__0 ) )
            {
            // InternalJDL.g:492:2: ( ( rule__JdlPatternValidator__Group__0 ) )
            // InternalJDL.g:493:3: ( rule__JdlPatternValidator__Group__0 )
            {
             before(grammarAccess.getJdlPatternValidatorAccess().getGroup()); 
            // InternalJDL.g:494:3: ( rule__JdlPatternValidator__Group__0 )
            // InternalJDL.g:494:4: rule__JdlPatternValidator__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JdlPatternValidator__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJdlPatternValidatorAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlPatternValidator"


    // $ANTLR start "entryRuleJdlMinValidator"
    // InternalJDL.g:503:1: entryRuleJdlMinValidator : ruleJdlMinValidator EOF ;
    public final void entryRuleJdlMinValidator() throws RecognitionException {
        try {
            // InternalJDL.g:504:1: ( ruleJdlMinValidator EOF )
            // InternalJDL.g:505:1: ruleJdlMinValidator EOF
            {
             before(grammarAccess.getJdlMinValidatorRule()); 
            pushFollow(FOLLOW_1);
            ruleJdlMinValidator();

            state._fsp--;

             after(grammarAccess.getJdlMinValidatorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJdlMinValidator"


    // $ANTLR start "ruleJdlMinValidator"
    // InternalJDL.g:512:1: ruleJdlMinValidator : ( ( rule__JdlMinValidator__Group__0 ) ) ;
    public final void ruleJdlMinValidator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:516:2: ( ( ( rule__JdlMinValidator__Group__0 ) ) )
            // InternalJDL.g:517:2: ( ( rule__JdlMinValidator__Group__0 ) )
            {
            // InternalJDL.g:517:2: ( ( rule__JdlMinValidator__Group__0 ) )
            // InternalJDL.g:518:3: ( rule__JdlMinValidator__Group__0 )
            {
             before(grammarAccess.getJdlMinValidatorAccess().getGroup()); 
            // InternalJDL.g:519:3: ( rule__JdlMinValidator__Group__0 )
            // InternalJDL.g:519:4: rule__JdlMinValidator__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JdlMinValidator__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJdlMinValidatorAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlMinValidator"


    // $ANTLR start "entryRuleJdlMaxValidator"
    // InternalJDL.g:528:1: entryRuleJdlMaxValidator : ruleJdlMaxValidator EOF ;
    public final void entryRuleJdlMaxValidator() throws RecognitionException {
        try {
            // InternalJDL.g:529:1: ( ruleJdlMaxValidator EOF )
            // InternalJDL.g:530:1: ruleJdlMaxValidator EOF
            {
             before(grammarAccess.getJdlMaxValidatorRule()); 
            pushFollow(FOLLOW_1);
            ruleJdlMaxValidator();

            state._fsp--;

             after(grammarAccess.getJdlMaxValidatorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJdlMaxValidator"


    // $ANTLR start "ruleJdlMaxValidator"
    // InternalJDL.g:537:1: ruleJdlMaxValidator : ( ( rule__JdlMaxValidator__Group__0 ) ) ;
    public final void ruleJdlMaxValidator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:541:2: ( ( ( rule__JdlMaxValidator__Group__0 ) ) )
            // InternalJDL.g:542:2: ( ( rule__JdlMaxValidator__Group__0 ) )
            {
            // InternalJDL.g:542:2: ( ( rule__JdlMaxValidator__Group__0 ) )
            // InternalJDL.g:543:3: ( rule__JdlMaxValidator__Group__0 )
            {
             before(grammarAccess.getJdlMaxValidatorAccess().getGroup()); 
            // InternalJDL.g:544:3: ( rule__JdlMaxValidator__Group__0 )
            // InternalJDL.g:544:4: rule__JdlMaxValidator__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JdlMaxValidator__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJdlMaxValidatorAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlMaxValidator"


    // $ANTLR start "entryRuleJdlMinBytesValidator"
    // InternalJDL.g:553:1: entryRuleJdlMinBytesValidator : ruleJdlMinBytesValidator EOF ;
    public final void entryRuleJdlMinBytesValidator() throws RecognitionException {
        try {
            // InternalJDL.g:554:1: ( ruleJdlMinBytesValidator EOF )
            // InternalJDL.g:555:1: ruleJdlMinBytesValidator EOF
            {
             before(grammarAccess.getJdlMinBytesValidatorRule()); 
            pushFollow(FOLLOW_1);
            ruleJdlMinBytesValidator();

            state._fsp--;

             after(grammarAccess.getJdlMinBytesValidatorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJdlMinBytesValidator"


    // $ANTLR start "ruleJdlMinBytesValidator"
    // InternalJDL.g:562:1: ruleJdlMinBytesValidator : ( ( rule__JdlMinBytesValidator__Group__0 ) ) ;
    public final void ruleJdlMinBytesValidator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:566:2: ( ( ( rule__JdlMinBytesValidator__Group__0 ) ) )
            // InternalJDL.g:567:2: ( ( rule__JdlMinBytesValidator__Group__0 ) )
            {
            // InternalJDL.g:567:2: ( ( rule__JdlMinBytesValidator__Group__0 ) )
            // InternalJDL.g:568:3: ( rule__JdlMinBytesValidator__Group__0 )
            {
             before(grammarAccess.getJdlMinBytesValidatorAccess().getGroup()); 
            // InternalJDL.g:569:3: ( rule__JdlMinBytesValidator__Group__0 )
            // InternalJDL.g:569:4: rule__JdlMinBytesValidator__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JdlMinBytesValidator__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJdlMinBytesValidatorAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlMinBytesValidator"


    // $ANTLR start "entryRuleJdlMaxBytesValidator"
    // InternalJDL.g:578:1: entryRuleJdlMaxBytesValidator : ruleJdlMaxBytesValidator EOF ;
    public final void entryRuleJdlMaxBytesValidator() throws RecognitionException {
        try {
            // InternalJDL.g:579:1: ( ruleJdlMaxBytesValidator EOF )
            // InternalJDL.g:580:1: ruleJdlMaxBytesValidator EOF
            {
             before(grammarAccess.getJdlMaxBytesValidatorRule()); 
            pushFollow(FOLLOW_1);
            ruleJdlMaxBytesValidator();

            state._fsp--;

             after(grammarAccess.getJdlMaxBytesValidatorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJdlMaxBytesValidator"


    // $ANTLR start "ruleJdlMaxBytesValidator"
    // InternalJDL.g:587:1: ruleJdlMaxBytesValidator : ( ( rule__JdlMaxBytesValidator__Group__0 ) ) ;
    public final void ruleJdlMaxBytesValidator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:591:2: ( ( ( rule__JdlMaxBytesValidator__Group__0 ) ) )
            // InternalJDL.g:592:2: ( ( rule__JdlMaxBytesValidator__Group__0 ) )
            {
            // InternalJDL.g:592:2: ( ( rule__JdlMaxBytesValidator__Group__0 ) )
            // InternalJDL.g:593:3: ( rule__JdlMaxBytesValidator__Group__0 )
            {
             before(grammarAccess.getJdlMaxBytesValidatorAccess().getGroup()); 
            // InternalJDL.g:594:3: ( rule__JdlMaxBytesValidator__Group__0 )
            // InternalJDL.g:594:4: rule__JdlMaxBytesValidator__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JdlMaxBytesValidator__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJdlMaxBytesValidatorAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlMaxBytesValidator"


    // $ANTLR start "entryRuleJdlRelationships"
    // InternalJDL.g:603:1: entryRuleJdlRelationships : ruleJdlRelationships EOF ;
    public final void entryRuleJdlRelationships() throws RecognitionException {
        try {
            // InternalJDL.g:604:1: ( ruleJdlRelationships EOF )
            // InternalJDL.g:605:1: ruleJdlRelationships EOF
            {
             before(grammarAccess.getJdlRelationshipsRule()); 
            pushFollow(FOLLOW_1);
            ruleJdlRelationships();

            state._fsp--;

             after(grammarAccess.getJdlRelationshipsRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJdlRelationships"


    // $ANTLR start "ruleJdlRelationships"
    // InternalJDL.g:612:1: ruleJdlRelationships : ( ( rule__JdlRelationships__Group__0 ) ) ;
    public final void ruleJdlRelationships() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:616:2: ( ( ( rule__JdlRelationships__Group__0 ) ) )
            // InternalJDL.g:617:2: ( ( rule__JdlRelationships__Group__0 ) )
            {
            // InternalJDL.g:617:2: ( ( rule__JdlRelationships__Group__0 ) )
            // InternalJDL.g:618:3: ( rule__JdlRelationships__Group__0 )
            {
             before(grammarAccess.getJdlRelationshipsAccess().getGroup()); 
            // InternalJDL.g:619:3: ( rule__JdlRelationships__Group__0 )
            // InternalJDL.g:619:4: rule__JdlRelationships__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JdlRelationships__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJdlRelationshipsAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlRelationships"


    // $ANTLR start "entryRuleJdlRelationship"
    // InternalJDL.g:628:1: entryRuleJdlRelationship : ruleJdlRelationship EOF ;
    public final void entryRuleJdlRelationship() throws RecognitionException {
        try {
            // InternalJDL.g:629:1: ( ruleJdlRelationship EOF )
            // InternalJDL.g:630:1: ruleJdlRelationship EOF
            {
             before(grammarAccess.getJdlRelationshipRule()); 
            pushFollow(FOLLOW_1);
            ruleJdlRelationship();

            state._fsp--;

             after(grammarAccess.getJdlRelationshipRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJdlRelationship"


    // $ANTLR start "ruleJdlRelationship"
    // InternalJDL.g:637:1: ruleJdlRelationship : ( ( rule__JdlRelationship__Group__0 ) ) ;
    public final void ruleJdlRelationship() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:641:2: ( ( ( rule__JdlRelationship__Group__0 ) ) )
            // InternalJDL.g:642:2: ( ( rule__JdlRelationship__Group__0 ) )
            {
            // InternalJDL.g:642:2: ( ( rule__JdlRelationship__Group__0 ) )
            // InternalJDL.g:643:3: ( rule__JdlRelationship__Group__0 )
            {
             before(grammarAccess.getJdlRelationshipAccess().getGroup()); 
            // InternalJDL.g:644:3: ( rule__JdlRelationship__Group__0 )
            // InternalJDL.g:644:4: rule__JdlRelationship__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JdlRelationship__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJdlRelationshipAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlRelationship"


    // $ANTLR start "entryRuleJdlRelationshipName"
    // InternalJDL.g:653:1: entryRuleJdlRelationshipName : ruleJdlRelationshipName EOF ;
    public final void entryRuleJdlRelationshipName() throws RecognitionException {
        try {
            // InternalJDL.g:654:1: ( ruleJdlRelationshipName EOF )
            // InternalJDL.g:655:1: ruleJdlRelationshipName EOF
            {
             before(grammarAccess.getJdlRelationshipNameRule()); 
            pushFollow(FOLLOW_1);
            ruleJdlRelationshipName();

            state._fsp--;

             after(grammarAccess.getJdlRelationshipNameRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJdlRelationshipName"


    // $ANTLR start "ruleJdlRelationshipName"
    // InternalJDL.g:662:1: ruleJdlRelationshipName : ( ( rule__JdlRelationshipName__Group__0 ) ) ;
    public final void ruleJdlRelationshipName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:666:2: ( ( ( rule__JdlRelationshipName__Group__0 ) ) )
            // InternalJDL.g:667:2: ( ( rule__JdlRelationshipName__Group__0 ) )
            {
            // InternalJDL.g:667:2: ( ( rule__JdlRelationshipName__Group__0 ) )
            // InternalJDL.g:668:3: ( rule__JdlRelationshipName__Group__0 )
            {
             before(grammarAccess.getJdlRelationshipNameAccess().getGroup()); 
            // InternalJDL.g:669:3: ( rule__JdlRelationshipName__Group__0 )
            // InternalJDL.g:669:4: rule__JdlRelationshipName__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JdlRelationshipName__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJdlRelationshipNameAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlRelationshipName"


    // $ANTLR start "entryRuleJdlEnumType"
    // InternalJDL.g:678:1: entryRuleJdlEnumType : ruleJdlEnumType EOF ;
    public final void entryRuleJdlEnumType() throws RecognitionException {
        try {
            // InternalJDL.g:679:1: ( ruleJdlEnumType EOF )
            // InternalJDL.g:680:1: ruleJdlEnumType EOF
            {
             before(grammarAccess.getJdlEnumTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleJdlEnumType();

            state._fsp--;

             after(grammarAccess.getJdlEnumTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJdlEnumType"


    // $ANTLR start "ruleJdlEnumType"
    // InternalJDL.g:687:1: ruleJdlEnumType : ( ( rule__JdlEnumType__Group__0 ) ) ;
    public final void ruleJdlEnumType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:691:2: ( ( ( rule__JdlEnumType__Group__0 ) ) )
            // InternalJDL.g:692:2: ( ( rule__JdlEnumType__Group__0 ) )
            {
            // InternalJDL.g:692:2: ( ( rule__JdlEnumType__Group__0 ) )
            // InternalJDL.g:693:3: ( rule__JdlEnumType__Group__0 )
            {
             before(grammarAccess.getJdlEnumTypeAccess().getGroup()); 
            // InternalJDL.g:694:3: ( rule__JdlEnumType__Group__0 )
            // InternalJDL.g:694:4: rule__JdlEnumType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JdlEnumType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJdlEnumTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlEnumType"


    // $ANTLR start "entryRuleJdlGenerationSetting"
    // InternalJDL.g:703:1: entryRuleJdlGenerationSetting : ruleJdlGenerationSetting EOF ;
    public final void entryRuleJdlGenerationSetting() throws RecognitionException {
        try {
            // InternalJDL.g:704:1: ( ruleJdlGenerationSetting EOF )
            // InternalJDL.g:705:1: ruleJdlGenerationSetting EOF
            {
             before(grammarAccess.getJdlGenerationSettingRule()); 
            pushFollow(FOLLOW_1);
            ruleJdlGenerationSetting();

            state._fsp--;

             after(grammarAccess.getJdlGenerationSettingRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJdlGenerationSetting"


    // $ANTLR start "ruleJdlGenerationSetting"
    // InternalJDL.g:712:1: ruleJdlGenerationSetting : ( ( rule__JdlGenerationSetting__Group__0 ) ) ;
    public final void ruleJdlGenerationSetting() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:716:2: ( ( ( rule__JdlGenerationSetting__Group__0 ) ) )
            // InternalJDL.g:717:2: ( ( rule__JdlGenerationSetting__Group__0 ) )
            {
            // InternalJDL.g:717:2: ( ( rule__JdlGenerationSetting__Group__0 ) )
            // InternalJDL.g:718:3: ( rule__JdlGenerationSetting__Group__0 )
            {
             before(grammarAccess.getJdlGenerationSettingAccess().getGroup()); 
            // InternalJDL.g:719:3: ( rule__JdlGenerationSetting__Group__0 )
            // InternalJDL.g:719:4: rule__JdlGenerationSetting__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JdlGenerationSetting__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJdlGenerationSettingAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlGenerationSetting"


    // $ANTLR start "entryRuleJdlGenerationSettingType"
    // InternalJDL.g:728:1: entryRuleJdlGenerationSettingType : ruleJdlGenerationSettingType EOF ;
    public final void entryRuleJdlGenerationSettingType() throws RecognitionException {
        try {
            // InternalJDL.g:729:1: ( ruleJdlGenerationSettingType EOF )
            // InternalJDL.g:730:1: ruleJdlGenerationSettingType EOF
            {
             before(grammarAccess.getJdlGenerationSettingTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleJdlGenerationSettingType();

            state._fsp--;

             after(grammarAccess.getJdlGenerationSettingTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJdlGenerationSettingType"


    // $ANTLR start "ruleJdlGenerationSettingType"
    // InternalJDL.g:737:1: ruleJdlGenerationSettingType : ( ( rule__JdlGenerationSettingType__Alternatives ) ) ;
    public final void ruleJdlGenerationSettingType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:741:2: ( ( ( rule__JdlGenerationSettingType__Alternatives ) ) )
            // InternalJDL.g:742:2: ( ( rule__JdlGenerationSettingType__Alternatives ) )
            {
            // InternalJDL.g:742:2: ( ( rule__JdlGenerationSettingType__Alternatives ) )
            // InternalJDL.g:743:3: ( rule__JdlGenerationSettingType__Alternatives )
            {
             before(grammarAccess.getJdlGenerationSettingTypeAccess().getAlternatives()); 
            // InternalJDL.g:744:3: ( rule__JdlGenerationSettingType__Alternatives )
            // InternalJDL.g:744:4: rule__JdlGenerationSettingType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__JdlGenerationSettingType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getJdlGenerationSettingTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlGenerationSettingType"


    // $ANTLR start "entryRuleJdlServiceGenerationSetting"
    // InternalJDL.g:753:1: entryRuleJdlServiceGenerationSetting : ruleJdlServiceGenerationSetting EOF ;
    public final void entryRuleJdlServiceGenerationSetting() throws RecognitionException {
        try {
            // InternalJDL.g:754:1: ( ruleJdlServiceGenerationSetting EOF )
            // InternalJDL.g:755:1: ruleJdlServiceGenerationSetting EOF
            {
             before(grammarAccess.getJdlServiceGenerationSettingRule()); 
            pushFollow(FOLLOW_1);
            ruleJdlServiceGenerationSetting();

            state._fsp--;

             after(grammarAccess.getJdlServiceGenerationSettingRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJdlServiceGenerationSetting"


    // $ANTLR start "ruleJdlServiceGenerationSetting"
    // InternalJDL.g:762:1: ruleJdlServiceGenerationSetting : ( ( rule__JdlServiceGenerationSetting__Group__0 ) ) ;
    public final void ruleJdlServiceGenerationSetting() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:766:2: ( ( ( rule__JdlServiceGenerationSetting__Group__0 ) ) )
            // InternalJDL.g:767:2: ( ( rule__JdlServiceGenerationSetting__Group__0 ) )
            {
            // InternalJDL.g:767:2: ( ( rule__JdlServiceGenerationSetting__Group__0 ) )
            // InternalJDL.g:768:3: ( rule__JdlServiceGenerationSetting__Group__0 )
            {
             before(grammarAccess.getJdlServiceGenerationSettingAccess().getGroup()); 
            // InternalJDL.g:769:3: ( rule__JdlServiceGenerationSetting__Group__0 )
            // InternalJDL.g:769:4: rule__JdlServiceGenerationSetting__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JdlServiceGenerationSetting__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJdlServiceGenerationSettingAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlServiceGenerationSetting"


    // $ANTLR start "entryRuleJdlMicroserviceGenerationSetting"
    // InternalJDL.g:778:1: entryRuleJdlMicroserviceGenerationSetting : ruleJdlMicroserviceGenerationSetting EOF ;
    public final void entryRuleJdlMicroserviceGenerationSetting() throws RecognitionException {
        try {
            // InternalJDL.g:779:1: ( ruleJdlMicroserviceGenerationSetting EOF )
            // InternalJDL.g:780:1: ruleJdlMicroserviceGenerationSetting EOF
            {
             before(grammarAccess.getJdlMicroserviceGenerationSettingRule()); 
            pushFollow(FOLLOW_1);
            ruleJdlMicroserviceGenerationSetting();

            state._fsp--;

             after(grammarAccess.getJdlMicroserviceGenerationSettingRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJdlMicroserviceGenerationSetting"


    // $ANTLR start "ruleJdlMicroserviceGenerationSetting"
    // InternalJDL.g:787:1: ruleJdlMicroserviceGenerationSetting : ( ( rule__JdlMicroserviceGenerationSetting__Group__0 ) ) ;
    public final void ruleJdlMicroserviceGenerationSetting() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:791:2: ( ( ( rule__JdlMicroserviceGenerationSetting__Group__0 ) ) )
            // InternalJDL.g:792:2: ( ( rule__JdlMicroserviceGenerationSetting__Group__0 ) )
            {
            // InternalJDL.g:792:2: ( ( rule__JdlMicroserviceGenerationSetting__Group__0 ) )
            // InternalJDL.g:793:3: ( rule__JdlMicroserviceGenerationSetting__Group__0 )
            {
             before(grammarAccess.getJdlMicroserviceGenerationSettingAccess().getGroup()); 
            // InternalJDL.g:794:3: ( rule__JdlMicroserviceGenerationSetting__Group__0 )
            // InternalJDL.g:794:4: rule__JdlMicroserviceGenerationSetting__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JdlMicroserviceGenerationSetting__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJdlMicroserviceGenerationSettingAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlMicroserviceGenerationSetting"


    // $ANTLR start "entryRuleJdlSearchGenerationSetting"
    // InternalJDL.g:803:1: entryRuleJdlSearchGenerationSetting : ruleJdlSearchGenerationSetting EOF ;
    public final void entryRuleJdlSearchGenerationSetting() throws RecognitionException {
        try {
            // InternalJDL.g:804:1: ( ruleJdlSearchGenerationSetting EOF )
            // InternalJDL.g:805:1: ruleJdlSearchGenerationSetting EOF
            {
             before(grammarAccess.getJdlSearchGenerationSettingRule()); 
            pushFollow(FOLLOW_1);
            ruleJdlSearchGenerationSetting();

            state._fsp--;

             after(grammarAccess.getJdlSearchGenerationSettingRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJdlSearchGenerationSetting"


    // $ANTLR start "ruleJdlSearchGenerationSetting"
    // InternalJDL.g:812:1: ruleJdlSearchGenerationSetting : ( ( rule__JdlSearchGenerationSetting__Group__0 ) ) ;
    public final void ruleJdlSearchGenerationSetting() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:816:2: ( ( ( rule__JdlSearchGenerationSetting__Group__0 ) ) )
            // InternalJDL.g:817:2: ( ( rule__JdlSearchGenerationSetting__Group__0 ) )
            {
            // InternalJDL.g:817:2: ( ( rule__JdlSearchGenerationSetting__Group__0 ) )
            // InternalJDL.g:818:3: ( rule__JdlSearchGenerationSetting__Group__0 )
            {
             before(grammarAccess.getJdlSearchGenerationSettingAccess().getGroup()); 
            // InternalJDL.g:819:3: ( rule__JdlSearchGenerationSetting__Group__0 )
            // InternalJDL.g:819:4: rule__JdlSearchGenerationSetting__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JdlSearchGenerationSetting__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJdlSearchGenerationSettingAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlSearchGenerationSetting"


    // $ANTLR start "entryRuleJdlDtoGenerationSetting"
    // InternalJDL.g:828:1: entryRuleJdlDtoGenerationSetting : ruleJdlDtoGenerationSetting EOF ;
    public final void entryRuleJdlDtoGenerationSetting() throws RecognitionException {
        try {
            // InternalJDL.g:829:1: ( ruleJdlDtoGenerationSetting EOF )
            // InternalJDL.g:830:1: ruleJdlDtoGenerationSetting EOF
            {
             before(grammarAccess.getJdlDtoGenerationSettingRule()); 
            pushFollow(FOLLOW_1);
            ruleJdlDtoGenerationSetting();

            state._fsp--;

             after(grammarAccess.getJdlDtoGenerationSettingRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJdlDtoGenerationSetting"


    // $ANTLR start "ruleJdlDtoGenerationSetting"
    // InternalJDL.g:837:1: ruleJdlDtoGenerationSetting : ( ( rule__JdlDtoGenerationSetting__Group__0 ) ) ;
    public final void ruleJdlDtoGenerationSetting() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:841:2: ( ( ( rule__JdlDtoGenerationSetting__Group__0 ) ) )
            // InternalJDL.g:842:2: ( ( rule__JdlDtoGenerationSetting__Group__0 ) )
            {
            // InternalJDL.g:842:2: ( ( rule__JdlDtoGenerationSetting__Group__0 ) )
            // InternalJDL.g:843:3: ( rule__JdlDtoGenerationSetting__Group__0 )
            {
             before(grammarAccess.getJdlDtoGenerationSettingAccess().getGroup()); 
            // InternalJDL.g:844:3: ( rule__JdlDtoGenerationSetting__Group__0 )
            // InternalJDL.g:844:4: rule__JdlDtoGenerationSetting__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JdlDtoGenerationSetting__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJdlDtoGenerationSettingAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlDtoGenerationSetting"


    // $ANTLR start "entryRuleJdlPaginateGenerationSetting"
    // InternalJDL.g:853:1: entryRuleJdlPaginateGenerationSetting : ruleJdlPaginateGenerationSetting EOF ;
    public final void entryRuleJdlPaginateGenerationSetting() throws RecognitionException {
        try {
            // InternalJDL.g:854:1: ( ruleJdlPaginateGenerationSetting EOF )
            // InternalJDL.g:855:1: ruleJdlPaginateGenerationSetting EOF
            {
             before(grammarAccess.getJdlPaginateGenerationSettingRule()); 
            pushFollow(FOLLOW_1);
            ruleJdlPaginateGenerationSetting();

            state._fsp--;

             after(grammarAccess.getJdlPaginateGenerationSettingRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJdlPaginateGenerationSetting"


    // $ANTLR start "ruleJdlPaginateGenerationSetting"
    // InternalJDL.g:862:1: ruleJdlPaginateGenerationSetting : ( ( rule__JdlPaginateGenerationSetting__Group__0 ) ) ;
    public final void ruleJdlPaginateGenerationSetting() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:866:2: ( ( ( rule__JdlPaginateGenerationSetting__Group__0 ) ) )
            // InternalJDL.g:867:2: ( ( rule__JdlPaginateGenerationSetting__Group__0 ) )
            {
            // InternalJDL.g:867:2: ( ( rule__JdlPaginateGenerationSetting__Group__0 ) )
            // InternalJDL.g:868:3: ( rule__JdlPaginateGenerationSetting__Group__0 )
            {
             before(grammarAccess.getJdlPaginateGenerationSettingAccess().getGroup()); 
            // InternalJDL.g:869:3: ( rule__JdlPaginateGenerationSetting__Group__0 )
            // InternalJDL.g:869:4: rule__JdlPaginateGenerationSetting__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JdlPaginateGenerationSetting__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJdlPaginateGenerationSettingAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlPaginateGenerationSetting"


    // $ANTLR start "entryRuleJdlAngularSuffixGenerationSetting"
    // InternalJDL.g:878:1: entryRuleJdlAngularSuffixGenerationSetting : ruleJdlAngularSuffixGenerationSetting EOF ;
    public final void entryRuleJdlAngularSuffixGenerationSetting() throws RecognitionException {
        try {
            // InternalJDL.g:879:1: ( ruleJdlAngularSuffixGenerationSetting EOF )
            // InternalJDL.g:880:1: ruleJdlAngularSuffixGenerationSetting EOF
            {
             before(grammarAccess.getJdlAngularSuffixGenerationSettingRule()); 
            pushFollow(FOLLOW_1);
            ruleJdlAngularSuffixGenerationSetting();

            state._fsp--;

             after(grammarAccess.getJdlAngularSuffixGenerationSettingRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJdlAngularSuffixGenerationSetting"


    // $ANTLR start "ruleJdlAngularSuffixGenerationSetting"
    // InternalJDL.g:887:1: ruleJdlAngularSuffixGenerationSetting : ( ( rule__JdlAngularSuffixGenerationSetting__Group__0 ) ) ;
    public final void ruleJdlAngularSuffixGenerationSetting() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:891:2: ( ( ( rule__JdlAngularSuffixGenerationSetting__Group__0 ) ) )
            // InternalJDL.g:892:2: ( ( rule__JdlAngularSuffixGenerationSetting__Group__0 ) )
            {
            // InternalJDL.g:892:2: ( ( rule__JdlAngularSuffixGenerationSetting__Group__0 ) )
            // InternalJDL.g:893:3: ( rule__JdlAngularSuffixGenerationSetting__Group__0 )
            {
             before(grammarAccess.getJdlAngularSuffixGenerationSettingAccess().getGroup()); 
            // InternalJDL.g:894:3: ( rule__JdlAngularSuffixGenerationSetting__Group__0 )
            // InternalJDL.g:894:4: rule__JdlAngularSuffixGenerationSetting__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JdlAngularSuffixGenerationSetting__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJdlAngularSuffixGenerationSettingAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlAngularSuffixGenerationSetting"


    // $ANTLR start "entryRuleJdlEntityInclusion"
    // InternalJDL.g:903:1: entryRuleJdlEntityInclusion : ruleJdlEntityInclusion EOF ;
    public final void entryRuleJdlEntityInclusion() throws RecognitionException {
        try {
            // InternalJDL.g:904:1: ( ruleJdlEntityInclusion EOF )
            // InternalJDL.g:905:1: ruleJdlEntityInclusion EOF
            {
             before(grammarAccess.getJdlEntityInclusionRule()); 
            pushFollow(FOLLOW_1);
            ruleJdlEntityInclusion();

            state._fsp--;

             after(grammarAccess.getJdlEntityInclusionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJdlEntityInclusion"


    // $ANTLR start "ruleJdlEntityInclusion"
    // InternalJDL.g:912:1: ruleJdlEntityInclusion : ( ( rule__JdlEntityInclusion__Group__0 ) ) ;
    public final void ruleJdlEntityInclusion() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:916:2: ( ( ( rule__JdlEntityInclusion__Group__0 ) ) )
            // InternalJDL.g:917:2: ( ( rule__JdlEntityInclusion__Group__0 ) )
            {
            // InternalJDL.g:917:2: ( ( rule__JdlEntityInclusion__Group__0 ) )
            // InternalJDL.g:918:3: ( rule__JdlEntityInclusion__Group__0 )
            {
             before(grammarAccess.getJdlEntityInclusionAccess().getGroup()); 
            // InternalJDL.g:919:3: ( rule__JdlEntityInclusion__Group__0 )
            // InternalJDL.g:919:4: rule__JdlEntityInclusion__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JdlEntityInclusion__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJdlEntityInclusionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlEntityInclusion"


    // $ANTLR start "entryRuleJdlEntityExclusion"
    // InternalJDL.g:928:1: entryRuleJdlEntityExclusion : ruleJdlEntityExclusion EOF ;
    public final void entryRuleJdlEntityExclusion() throws RecognitionException {
        try {
            // InternalJDL.g:929:1: ( ruleJdlEntityExclusion EOF )
            // InternalJDL.g:930:1: ruleJdlEntityExclusion EOF
            {
             before(grammarAccess.getJdlEntityExclusionRule()); 
            pushFollow(FOLLOW_1);
            ruleJdlEntityExclusion();

            state._fsp--;

             after(grammarAccess.getJdlEntityExclusionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJdlEntityExclusion"


    // $ANTLR start "ruleJdlEntityExclusion"
    // InternalJDL.g:937:1: ruleJdlEntityExclusion : ( ( rule__JdlEntityExclusion__Group__0 ) ) ;
    public final void ruleJdlEntityExclusion() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:941:2: ( ( ( rule__JdlEntityExclusion__Group__0 ) ) )
            // InternalJDL.g:942:2: ( ( rule__JdlEntityExclusion__Group__0 ) )
            {
            // InternalJDL.g:942:2: ( ( rule__JdlEntityExclusion__Group__0 ) )
            // InternalJDL.g:943:3: ( rule__JdlEntityExclusion__Group__0 )
            {
             before(grammarAccess.getJdlEntityExclusionAccess().getGroup()); 
            // InternalJDL.g:944:3: ( rule__JdlEntityExclusion__Group__0 )
            // InternalJDL.g:944:4: rule__JdlEntityExclusion__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JdlEntityExclusion__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJdlEntityExclusionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlEntityExclusion"


    // $ANTLR start "entryRuleJdlWildcardPredicate"
    // InternalJDL.g:953:1: entryRuleJdlWildcardPredicate : ruleJdlWildcardPredicate EOF ;
    public final void entryRuleJdlWildcardPredicate() throws RecognitionException {
        try {
            // InternalJDL.g:954:1: ( ruleJdlWildcardPredicate EOF )
            // InternalJDL.g:955:1: ruleJdlWildcardPredicate EOF
            {
             before(grammarAccess.getJdlWildcardPredicateRule()); 
            pushFollow(FOLLOW_1);
            ruleJdlWildcardPredicate();

            state._fsp--;

             after(grammarAccess.getJdlWildcardPredicateRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJdlWildcardPredicate"


    // $ANTLR start "ruleJdlWildcardPredicate"
    // InternalJDL.g:962:1: ruleJdlWildcardPredicate : ( ( rule__JdlWildcardPredicate__Alternatives ) ) ;
    public final void ruleJdlWildcardPredicate() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:966:2: ( ( ( rule__JdlWildcardPredicate__Alternatives ) ) )
            // InternalJDL.g:967:2: ( ( rule__JdlWildcardPredicate__Alternatives ) )
            {
            // InternalJDL.g:967:2: ( ( rule__JdlWildcardPredicate__Alternatives ) )
            // InternalJDL.g:968:3: ( rule__JdlWildcardPredicate__Alternatives )
            {
             before(grammarAccess.getJdlWildcardPredicateAccess().getAlternatives()); 
            // InternalJDL.g:969:3: ( rule__JdlWildcardPredicate__Alternatives )
            // InternalJDL.g:969:4: rule__JdlWildcardPredicate__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__JdlWildcardPredicate__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getJdlWildcardPredicateAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlWildcardPredicate"


    // $ANTLR start "entryRuleJdlPaginateType"
    // InternalJDL.g:978:1: entryRuleJdlPaginateType : ruleJdlPaginateType EOF ;
    public final void entryRuleJdlPaginateType() throws RecognitionException {
        try {
            // InternalJDL.g:979:1: ( ruleJdlPaginateType EOF )
            // InternalJDL.g:980:1: ruleJdlPaginateType EOF
            {
             before(grammarAccess.getJdlPaginateTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleJdlPaginateType();

            state._fsp--;

             after(grammarAccess.getJdlPaginateTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJdlPaginateType"


    // $ANTLR start "ruleJdlPaginateType"
    // InternalJDL.g:987:1: ruleJdlPaginateType : ( ( rule__JdlPaginateType__Alternatives ) ) ;
    public final void ruleJdlPaginateType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:991:2: ( ( ( rule__JdlPaginateType__Alternatives ) ) )
            // InternalJDL.g:992:2: ( ( rule__JdlPaginateType__Alternatives ) )
            {
            // InternalJDL.g:992:2: ( ( rule__JdlPaginateType__Alternatives ) )
            // InternalJDL.g:993:3: ( rule__JdlPaginateType__Alternatives )
            {
             before(grammarAccess.getJdlPaginateTypeAccess().getAlternatives()); 
            // InternalJDL.g:994:3: ( rule__JdlPaginateType__Alternatives )
            // InternalJDL.g:994:4: rule__JdlPaginateType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__JdlPaginateType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getJdlPaginateTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlPaginateType"


    // $ANTLR start "ruleJdlNumericFieldType"
    // InternalJDL.g:1003:1: ruleJdlNumericFieldType : ( ( rule__JdlNumericFieldType__Alternatives ) ) ;
    public final void ruleJdlNumericFieldType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1007:1: ( ( ( rule__JdlNumericFieldType__Alternatives ) ) )
            // InternalJDL.g:1008:2: ( ( rule__JdlNumericFieldType__Alternatives ) )
            {
            // InternalJDL.g:1008:2: ( ( rule__JdlNumericFieldType__Alternatives ) )
            // InternalJDL.g:1009:3: ( rule__JdlNumericFieldType__Alternatives )
            {
             before(grammarAccess.getJdlNumericFieldTypeAccess().getAlternatives()); 
            // InternalJDL.g:1010:3: ( rule__JdlNumericFieldType__Alternatives )
            // InternalJDL.g:1010:4: rule__JdlNumericFieldType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__JdlNumericFieldType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getJdlNumericFieldTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlNumericFieldType"


    // $ANTLR start "ruleJdlBlobFieldType"
    // InternalJDL.g:1019:1: ruleJdlBlobFieldType : ( ( rule__JdlBlobFieldType__Alternatives ) ) ;
    public final void ruleJdlBlobFieldType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1023:1: ( ( ( rule__JdlBlobFieldType__Alternatives ) ) )
            // InternalJDL.g:1024:2: ( ( rule__JdlBlobFieldType__Alternatives ) )
            {
            // InternalJDL.g:1024:2: ( ( rule__JdlBlobFieldType__Alternatives ) )
            // InternalJDL.g:1025:3: ( rule__JdlBlobFieldType__Alternatives )
            {
             before(grammarAccess.getJdlBlobFieldTypeAccess().getAlternatives()); 
            // InternalJDL.g:1026:3: ( rule__JdlBlobFieldType__Alternatives )
            // InternalJDL.g:1026:4: rule__JdlBlobFieldType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__JdlBlobFieldType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getJdlBlobFieldTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlBlobFieldType"


    // $ANTLR start "ruleJdlCardinality"
    // InternalJDL.g:1035:1: ruleJdlCardinality : ( ( rule__JdlCardinality__Alternatives ) ) ;
    public final void ruleJdlCardinality() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1039:1: ( ( ( rule__JdlCardinality__Alternatives ) ) )
            // InternalJDL.g:1040:2: ( ( rule__JdlCardinality__Alternatives ) )
            {
            // InternalJDL.g:1040:2: ( ( rule__JdlCardinality__Alternatives ) )
            // InternalJDL.g:1041:3: ( rule__JdlCardinality__Alternatives )
            {
             before(grammarAccess.getJdlCardinalityAccess().getAlternatives()); 
            // InternalJDL.g:1042:3: ( rule__JdlCardinality__Alternatives )
            // InternalJDL.g:1042:4: rule__JdlCardinality__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__JdlCardinality__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getJdlCardinalityAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlCardinality"


    // $ANTLR start "ruleJdlServiceType"
    // InternalJDL.g:1051:1: ruleJdlServiceType : ( ( rule__JdlServiceType__Alternatives ) ) ;
    public final void ruleJdlServiceType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1055:1: ( ( ( rule__JdlServiceType__Alternatives ) ) )
            // InternalJDL.g:1056:2: ( ( rule__JdlServiceType__Alternatives ) )
            {
            // InternalJDL.g:1056:2: ( ( rule__JdlServiceType__Alternatives ) )
            // InternalJDL.g:1057:3: ( rule__JdlServiceType__Alternatives )
            {
             before(grammarAccess.getJdlServiceTypeAccess().getAlternatives()); 
            // InternalJDL.g:1058:3: ( rule__JdlServiceType__Alternatives )
            // InternalJDL.g:1058:4: rule__JdlServiceType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__JdlServiceType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getJdlServiceTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlServiceType"


    // $ANTLR start "ruleJdlDtoType"
    // InternalJDL.g:1067:1: ruleJdlDtoType : ( ( 'mapstruct' ) ) ;
    public final void ruleJdlDtoType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1071:1: ( ( ( 'mapstruct' ) ) )
            // InternalJDL.g:1072:2: ( ( 'mapstruct' ) )
            {
            // InternalJDL.g:1072:2: ( ( 'mapstruct' ) )
            // InternalJDL.g:1073:3: ( 'mapstruct' )
            {
             before(grammarAccess.getJdlDtoTypeAccess().getMapstructEnumLiteralDeclaration()); 
            // InternalJDL.g:1074:3: ( 'mapstruct' )
            // InternalJDL.g:1074:4: 'mapstruct'
            {
            match(input,11,FOLLOW_2); 

            }

             after(grammarAccess.getJdlDtoTypeAccess().getMapstructEnumLiteralDeclaration()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJdlDtoType"


    // $ANTLR start "rule__JdlFeature__Alternatives"
    // InternalJDL.g:1082:1: rule__JdlFeature__Alternatives : ( ( ruleJdlEntity ) | ( ruleJdlEnumType ) | ( ruleJdlRelationships ) | ( ruleJdlGenerationSetting ) );
    public final void rule__JdlFeature__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1086:1: ( ( ruleJdlEntity ) | ( ruleJdlEnumType ) | ( ruleJdlRelationships ) | ( ruleJdlGenerationSetting ) )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt2=1;
                }
                break;
            case 43:
                {
                alt2=2;
                }
                break;
            case 41:
                {
                alt2=3;
                }
                break;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalJDL.g:1087:2: ( ruleJdlEntity )
                    {
                    // InternalJDL.g:1087:2: ( ruleJdlEntity )
                    // InternalJDL.g:1088:3: ruleJdlEntity
                    {
                     before(grammarAccess.getJdlFeatureAccess().getJdlEntityParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleJdlEntity();

                    state._fsp--;

                     after(grammarAccess.getJdlFeatureAccess().getJdlEntityParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalJDL.g:1093:2: ( ruleJdlEnumType )
                    {
                    // InternalJDL.g:1093:2: ( ruleJdlEnumType )
                    // InternalJDL.g:1094:3: ruleJdlEnumType
                    {
                     before(grammarAccess.getJdlFeatureAccess().getJdlEnumTypeParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleJdlEnumType();

                    state._fsp--;

                     after(grammarAccess.getJdlFeatureAccess().getJdlEnumTypeParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalJDL.g:1099:2: ( ruleJdlRelationships )
                    {
                    // InternalJDL.g:1099:2: ( ruleJdlRelationships )
                    // InternalJDL.g:1100:3: ruleJdlRelationships
                    {
                     before(grammarAccess.getJdlFeatureAccess().getJdlRelationshipsParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleJdlRelationships();

                    state._fsp--;

                     after(grammarAccess.getJdlFeatureAccess().getJdlRelationshipsParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalJDL.g:1105:2: ( ruleJdlGenerationSetting )
                    {
                    // InternalJDL.g:1105:2: ( ruleJdlGenerationSetting )
                    // InternalJDL.g:1106:3: ruleJdlGenerationSetting
                    {
                     before(grammarAccess.getJdlFeatureAccess().getJdlGenerationSettingParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleJdlGenerationSetting();

                    state._fsp--;

                     after(grammarAccess.getJdlFeatureAccess().getJdlGenerationSettingParserRuleCall_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlFeature__Alternatives"


    // $ANTLR start "rule__JdlFieldType__Alternatives"
    // InternalJDL.g:1115:1: rule__JdlFieldType__Alternatives : ( ( ruleJdlEnumField ) | ( ruleJdlStringField ) | ( ruleJdlNumericField ) | ( ruleJdlBooleanField ) | ( ruleJdlDateField ) | ( ruleJdlBlobField ) );
    public final void rule__JdlFieldType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1119:1: ( ( ruleJdlEnumField ) | ( ruleJdlStringField ) | ( ruleJdlNumericField ) | ( ruleJdlBooleanField ) | ( ruleJdlDateField ) | ( ruleJdlBlobField ) )
            int alt3=6;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt3=1;
                }
                break;
            case 46:
                {
                alt3=2;
                }
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                {
                alt3=3;
                }
                break;
            case 47:
                {
                alt3=4;
                }
                break;
            case 48:
            case 49:
                {
                alt3=5;
                }
                break;
            case 19:
            case 20:
            case 21:
                {
                alt3=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalJDL.g:1120:2: ( ruleJdlEnumField )
                    {
                    // InternalJDL.g:1120:2: ( ruleJdlEnumField )
                    // InternalJDL.g:1121:3: ruleJdlEnumField
                    {
                     before(grammarAccess.getJdlFieldTypeAccess().getJdlEnumFieldParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleJdlEnumField();

                    state._fsp--;

                     after(grammarAccess.getJdlFieldTypeAccess().getJdlEnumFieldParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalJDL.g:1126:2: ( ruleJdlStringField )
                    {
                    // InternalJDL.g:1126:2: ( ruleJdlStringField )
                    // InternalJDL.g:1127:3: ruleJdlStringField
                    {
                     before(grammarAccess.getJdlFieldTypeAccess().getJdlStringFieldParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleJdlStringField();

                    state._fsp--;

                     after(grammarAccess.getJdlFieldTypeAccess().getJdlStringFieldParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalJDL.g:1132:2: ( ruleJdlNumericField )
                    {
                    // InternalJDL.g:1132:2: ( ruleJdlNumericField )
                    // InternalJDL.g:1133:3: ruleJdlNumericField
                    {
                     before(grammarAccess.getJdlFieldTypeAccess().getJdlNumericFieldParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleJdlNumericField();

                    state._fsp--;

                     after(grammarAccess.getJdlFieldTypeAccess().getJdlNumericFieldParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalJDL.g:1138:2: ( ruleJdlBooleanField )
                    {
                    // InternalJDL.g:1138:2: ( ruleJdlBooleanField )
                    // InternalJDL.g:1139:3: ruleJdlBooleanField
                    {
                     before(grammarAccess.getJdlFieldTypeAccess().getJdlBooleanFieldParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleJdlBooleanField();

                    state._fsp--;

                     after(grammarAccess.getJdlFieldTypeAccess().getJdlBooleanFieldParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalJDL.g:1144:2: ( ruleJdlDateField )
                    {
                    // InternalJDL.g:1144:2: ( ruleJdlDateField )
                    // InternalJDL.g:1145:3: ruleJdlDateField
                    {
                     before(grammarAccess.getJdlFieldTypeAccess().getJdlDateFieldParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleJdlDateField();

                    state._fsp--;

                     after(grammarAccess.getJdlFieldTypeAccess().getJdlDateFieldParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalJDL.g:1150:2: ( ruleJdlBlobField )
                    {
                    // InternalJDL.g:1150:2: ( ruleJdlBlobField )
                    // InternalJDL.g:1151:3: ruleJdlBlobField
                    {
                     before(grammarAccess.getJdlFieldTypeAccess().getJdlBlobFieldParserRuleCall_5()); 
                    pushFollow(FOLLOW_2);
                    ruleJdlBlobField();

                    state._fsp--;

                     after(grammarAccess.getJdlFieldTypeAccess().getJdlBlobFieldParserRuleCall_5()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlFieldType__Alternatives"


    // $ANTLR start "rule__JdlDateField__Alternatives_0"
    // InternalJDL.g:1160:1: rule__JdlDateField__Alternatives_0 : ( ( ( rule__JdlDateField__LocalDateTypeAssignment_0_0 ) ) | ( ( rule__JdlDateField__ZonedDateTimeTypeAssignment_0_1 ) ) );
    public final void rule__JdlDateField__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1164:1: ( ( ( rule__JdlDateField__LocalDateTypeAssignment_0_0 ) ) | ( ( rule__JdlDateField__ZonedDateTimeTypeAssignment_0_1 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==48) ) {
                alt4=1;
            }
            else if ( (LA4_0==49) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalJDL.g:1165:2: ( ( rule__JdlDateField__LocalDateTypeAssignment_0_0 ) )
                    {
                    // InternalJDL.g:1165:2: ( ( rule__JdlDateField__LocalDateTypeAssignment_0_0 ) )
                    // InternalJDL.g:1166:3: ( rule__JdlDateField__LocalDateTypeAssignment_0_0 )
                    {
                     before(grammarAccess.getJdlDateFieldAccess().getLocalDateTypeAssignment_0_0()); 
                    // InternalJDL.g:1167:3: ( rule__JdlDateField__LocalDateTypeAssignment_0_0 )
                    // InternalJDL.g:1167:4: rule__JdlDateField__LocalDateTypeAssignment_0_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__JdlDateField__LocalDateTypeAssignment_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getJdlDateFieldAccess().getLocalDateTypeAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalJDL.g:1171:2: ( ( rule__JdlDateField__ZonedDateTimeTypeAssignment_0_1 ) )
                    {
                    // InternalJDL.g:1171:2: ( ( rule__JdlDateField__ZonedDateTimeTypeAssignment_0_1 ) )
                    // InternalJDL.g:1172:3: ( rule__JdlDateField__ZonedDateTimeTypeAssignment_0_1 )
                    {
                     before(grammarAccess.getJdlDateFieldAccess().getZonedDateTimeTypeAssignment_0_1()); 
                    // InternalJDL.g:1173:3: ( rule__JdlDateField__ZonedDateTimeTypeAssignment_0_1 )
                    // InternalJDL.g:1173:4: rule__JdlDateField__ZonedDateTimeTypeAssignment_0_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__JdlDateField__ZonedDateTimeTypeAssignment_0_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getJdlDateFieldAccess().getZonedDateTimeTypeAssignment_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlDateField__Alternatives_0"


    // $ANTLR start "rule__JdlGenerationSettingType__Alternatives"
    // InternalJDL.g:1181:1: rule__JdlGenerationSettingType__Alternatives : ( ( ruleJdlServiceGenerationSetting ) | ( ruleJdlMicroserviceGenerationSetting ) | ( ruleJdlSearchGenerationSetting ) | ( ruleJdlDtoGenerationSetting ) | ( ruleJdlPaginateGenerationSetting ) | ( ruleJdlAngularSuffixGenerationSetting ) );
    public final void rule__JdlGenerationSettingType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1185:1: ( ( ruleJdlServiceGenerationSetting ) | ( ruleJdlMicroserviceGenerationSetting ) | ( ruleJdlSearchGenerationSetting ) | ( ruleJdlDtoGenerationSetting ) | ( ruleJdlPaginateGenerationSetting ) | ( ruleJdlAngularSuffixGenerationSetting ) )
            int alt5=6;
            switch ( input.LA(1) ) {
            case 51:
                {
                alt5=1;
                }
                break;
            case 52:
                {
                alt5=2;
                }
                break;
            case 53:
                {
                alt5=3;
                }
                break;
            case 54:
                {
                alt5=4;
                }
                break;
            case 55:
                {
                alt5=5;
                }
                break;
            case 56:
                {
                alt5=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalJDL.g:1186:2: ( ruleJdlServiceGenerationSetting )
                    {
                    // InternalJDL.g:1186:2: ( ruleJdlServiceGenerationSetting )
                    // InternalJDL.g:1187:3: ruleJdlServiceGenerationSetting
                    {
                     before(grammarAccess.getJdlGenerationSettingTypeAccess().getJdlServiceGenerationSettingParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleJdlServiceGenerationSetting();

                    state._fsp--;

                     after(grammarAccess.getJdlGenerationSettingTypeAccess().getJdlServiceGenerationSettingParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalJDL.g:1192:2: ( ruleJdlMicroserviceGenerationSetting )
                    {
                    // InternalJDL.g:1192:2: ( ruleJdlMicroserviceGenerationSetting )
                    // InternalJDL.g:1193:3: ruleJdlMicroserviceGenerationSetting
                    {
                     before(grammarAccess.getJdlGenerationSettingTypeAccess().getJdlMicroserviceGenerationSettingParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleJdlMicroserviceGenerationSetting();

                    state._fsp--;

                     after(grammarAccess.getJdlGenerationSettingTypeAccess().getJdlMicroserviceGenerationSettingParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalJDL.g:1198:2: ( ruleJdlSearchGenerationSetting )
                    {
                    // InternalJDL.g:1198:2: ( ruleJdlSearchGenerationSetting )
                    // InternalJDL.g:1199:3: ruleJdlSearchGenerationSetting
                    {
                     before(grammarAccess.getJdlGenerationSettingTypeAccess().getJdlSearchGenerationSettingParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleJdlSearchGenerationSetting();

                    state._fsp--;

                     after(grammarAccess.getJdlGenerationSettingTypeAccess().getJdlSearchGenerationSettingParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalJDL.g:1204:2: ( ruleJdlDtoGenerationSetting )
                    {
                    // InternalJDL.g:1204:2: ( ruleJdlDtoGenerationSetting )
                    // InternalJDL.g:1205:3: ruleJdlDtoGenerationSetting
                    {
                     before(grammarAccess.getJdlGenerationSettingTypeAccess().getJdlDtoGenerationSettingParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleJdlDtoGenerationSetting();

                    state._fsp--;

                     after(grammarAccess.getJdlGenerationSettingTypeAccess().getJdlDtoGenerationSettingParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalJDL.g:1210:2: ( ruleJdlPaginateGenerationSetting )
                    {
                    // InternalJDL.g:1210:2: ( ruleJdlPaginateGenerationSetting )
                    // InternalJDL.g:1211:3: ruleJdlPaginateGenerationSetting
                    {
                     before(grammarAccess.getJdlGenerationSettingTypeAccess().getJdlPaginateGenerationSettingParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleJdlPaginateGenerationSetting();

                    state._fsp--;

                     after(grammarAccess.getJdlGenerationSettingTypeAccess().getJdlPaginateGenerationSettingParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalJDL.g:1216:2: ( ruleJdlAngularSuffixGenerationSetting )
                    {
                    // InternalJDL.g:1216:2: ( ruleJdlAngularSuffixGenerationSetting )
                    // InternalJDL.g:1217:3: ruleJdlAngularSuffixGenerationSetting
                    {
                     before(grammarAccess.getJdlGenerationSettingTypeAccess().getJdlAngularSuffixGenerationSettingParserRuleCall_5()); 
                    pushFollow(FOLLOW_2);
                    ruleJdlAngularSuffixGenerationSetting();

                    state._fsp--;

                     after(grammarAccess.getJdlGenerationSettingTypeAccess().getJdlAngularSuffixGenerationSettingParserRuleCall_5()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlGenerationSettingType__Alternatives"


    // $ANTLR start "rule__JdlEntityInclusion__Alternatives_0"
    // InternalJDL.g:1226:1: rule__JdlEntityInclusion__Alternatives_0 : ( ( ( rule__JdlEntityInclusion__PredicateAssignment_0_0 ) ) | ( ( rule__JdlEntityInclusion__Group_0_1__0 ) ) );
    public final void rule__JdlEntityInclusion__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1230:1: ( ( ( rule__JdlEntityInclusion__PredicateAssignment_0_0 ) ) | ( ( rule__JdlEntityInclusion__Group_0_1__0 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=57 && LA6_0<=58)) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_ID) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalJDL.g:1231:2: ( ( rule__JdlEntityInclusion__PredicateAssignment_0_0 ) )
                    {
                    // InternalJDL.g:1231:2: ( ( rule__JdlEntityInclusion__PredicateAssignment_0_0 ) )
                    // InternalJDL.g:1232:3: ( rule__JdlEntityInclusion__PredicateAssignment_0_0 )
                    {
                     before(grammarAccess.getJdlEntityInclusionAccess().getPredicateAssignment_0_0()); 
                    // InternalJDL.g:1233:3: ( rule__JdlEntityInclusion__PredicateAssignment_0_0 )
                    // InternalJDL.g:1233:4: rule__JdlEntityInclusion__PredicateAssignment_0_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__JdlEntityInclusion__PredicateAssignment_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getJdlEntityInclusionAccess().getPredicateAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalJDL.g:1237:2: ( ( rule__JdlEntityInclusion__Group_0_1__0 ) )
                    {
                    // InternalJDL.g:1237:2: ( ( rule__JdlEntityInclusion__Group_0_1__0 ) )
                    // InternalJDL.g:1238:3: ( rule__JdlEntityInclusion__Group_0_1__0 )
                    {
                     before(grammarAccess.getJdlEntityInclusionAccess().getGroup_0_1()); 
                    // InternalJDL.g:1239:3: ( rule__JdlEntityInclusion__Group_0_1__0 )
                    // InternalJDL.g:1239:4: rule__JdlEntityInclusion__Group_0_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__JdlEntityInclusion__Group_0_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getJdlEntityInclusionAccess().getGroup_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntityInclusion__Alternatives_0"


    // $ANTLR start "rule__JdlWildcardPredicate__Alternatives"
    // InternalJDL.g:1247:1: rule__JdlWildcardPredicate__Alternatives : ( ( ( rule__JdlWildcardPredicate__WildcardAssignment_0 ) ) | ( ( rule__JdlWildcardPredicate__AllAssignment_1 ) ) );
    public final void rule__JdlWildcardPredicate__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1251:1: ( ( ( rule__JdlWildcardPredicate__WildcardAssignment_0 ) ) | ( ( rule__JdlWildcardPredicate__AllAssignment_1 ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==57) ) {
                alt7=1;
            }
            else if ( (LA7_0==58) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalJDL.g:1252:2: ( ( rule__JdlWildcardPredicate__WildcardAssignment_0 ) )
                    {
                    // InternalJDL.g:1252:2: ( ( rule__JdlWildcardPredicate__WildcardAssignment_0 ) )
                    // InternalJDL.g:1253:3: ( rule__JdlWildcardPredicate__WildcardAssignment_0 )
                    {
                     before(grammarAccess.getJdlWildcardPredicateAccess().getWildcardAssignment_0()); 
                    // InternalJDL.g:1254:3: ( rule__JdlWildcardPredicate__WildcardAssignment_0 )
                    // InternalJDL.g:1254:4: rule__JdlWildcardPredicate__WildcardAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__JdlWildcardPredicate__WildcardAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getJdlWildcardPredicateAccess().getWildcardAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalJDL.g:1258:2: ( ( rule__JdlWildcardPredicate__AllAssignment_1 ) )
                    {
                    // InternalJDL.g:1258:2: ( ( rule__JdlWildcardPredicate__AllAssignment_1 ) )
                    // InternalJDL.g:1259:3: ( rule__JdlWildcardPredicate__AllAssignment_1 )
                    {
                     before(grammarAccess.getJdlWildcardPredicateAccess().getAllAssignment_1()); 
                    // InternalJDL.g:1260:3: ( rule__JdlWildcardPredicate__AllAssignment_1 )
                    // InternalJDL.g:1260:4: rule__JdlWildcardPredicate__AllAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__JdlWildcardPredicate__AllAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getJdlWildcardPredicateAccess().getAllAssignment_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlWildcardPredicate__Alternatives"


    // $ANTLR start "rule__JdlPaginateType__Alternatives"
    // InternalJDL.g:1268:1: rule__JdlPaginateType__Alternatives : ( ( ( rule__JdlPaginateType__PaginationAssignment_0 ) ) | ( ( rule__JdlPaginateType__InfiniteScrollAssignment_1 ) ) );
    public final void rule__JdlPaginateType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1272:1: ( ( ( rule__JdlPaginateType__PaginationAssignment_0 ) ) | ( ( rule__JdlPaginateType__InfiniteScrollAssignment_1 ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=12 && LA8_0<=13)) ) {
                alt8=1;
            }
            else if ( (LA8_0==59) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalJDL.g:1273:2: ( ( rule__JdlPaginateType__PaginationAssignment_0 ) )
                    {
                    // InternalJDL.g:1273:2: ( ( rule__JdlPaginateType__PaginationAssignment_0 ) )
                    // InternalJDL.g:1274:3: ( rule__JdlPaginateType__PaginationAssignment_0 )
                    {
                     before(grammarAccess.getJdlPaginateTypeAccess().getPaginationAssignment_0()); 
                    // InternalJDL.g:1275:3: ( rule__JdlPaginateType__PaginationAssignment_0 )
                    // InternalJDL.g:1275:4: rule__JdlPaginateType__PaginationAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__JdlPaginateType__PaginationAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getJdlPaginateTypeAccess().getPaginationAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalJDL.g:1279:2: ( ( rule__JdlPaginateType__InfiniteScrollAssignment_1 ) )
                    {
                    // InternalJDL.g:1279:2: ( ( rule__JdlPaginateType__InfiniteScrollAssignment_1 ) )
                    // InternalJDL.g:1280:3: ( rule__JdlPaginateType__InfiniteScrollAssignment_1 )
                    {
                     before(grammarAccess.getJdlPaginateTypeAccess().getInfiniteScrollAssignment_1()); 
                    // InternalJDL.g:1281:3: ( rule__JdlPaginateType__InfiniteScrollAssignment_1 )
                    // InternalJDL.g:1281:4: rule__JdlPaginateType__InfiniteScrollAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__JdlPaginateType__InfiniteScrollAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getJdlPaginateTypeAccess().getInfiniteScrollAssignment_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlPaginateType__Alternatives"


    // $ANTLR start "rule__JdlPaginateType__PaginationAlternatives_0_0"
    // InternalJDL.g:1289:1: rule__JdlPaginateType__PaginationAlternatives_0_0 : ( ( 'pager' ) | ( 'pagination' ) );
    public final void rule__JdlPaginateType__PaginationAlternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1293:1: ( ( 'pager' ) | ( 'pagination' ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==12) ) {
                alt9=1;
            }
            else if ( (LA9_0==13) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalJDL.g:1294:2: ( 'pager' )
                    {
                    // InternalJDL.g:1294:2: ( 'pager' )
                    // InternalJDL.g:1295:3: 'pager'
                    {
                     before(grammarAccess.getJdlPaginateTypeAccess().getPaginationPagerKeyword_0_0_0()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getJdlPaginateTypeAccess().getPaginationPagerKeyword_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalJDL.g:1300:2: ( 'pagination' )
                    {
                    // InternalJDL.g:1300:2: ( 'pagination' )
                    // InternalJDL.g:1301:3: 'pagination'
                    {
                     before(grammarAccess.getJdlPaginateTypeAccess().getPaginationPaginationKeyword_0_0_1()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getJdlPaginateTypeAccess().getPaginationPaginationKeyword_0_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlPaginateType__PaginationAlternatives_0_0"


    // $ANTLR start "rule__JdlNumericFieldType__Alternatives"
    // InternalJDL.g:1310:1: rule__JdlNumericFieldType__Alternatives : ( ( ( 'Integer' ) ) | ( ( 'Long' ) ) | ( ( 'BigDecimal' ) ) | ( ( 'Float' ) ) | ( ( 'Double' ) ) );
    public final void rule__JdlNumericFieldType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1314:1: ( ( ( 'Integer' ) ) | ( ( 'Long' ) ) | ( ( 'BigDecimal' ) ) | ( ( 'Float' ) ) | ( ( 'Double' ) ) )
            int alt10=5;
            switch ( input.LA(1) ) {
            case 14:
                {
                alt10=1;
                }
                break;
            case 15:
                {
                alt10=2;
                }
                break;
            case 16:
                {
                alt10=3;
                }
                break;
            case 17:
                {
                alt10=4;
                }
                break;
            case 18:
                {
                alt10=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalJDL.g:1315:2: ( ( 'Integer' ) )
                    {
                    // InternalJDL.g:1315:2: ( ( 'Integer' ) )
                    // InternalJDL.g:1316:3: ( 'Integer' )
                    {
                     before(grammarAccess.getJdlNumericFieldTypeAccess().getIntegerEnumLiteralDeclaration_0()); 
                    // InternalJDL.g:1317:3: ( 'Integer' )
                    // InternalJDL.g:1317:4: 'Integer'
                    {
                    match(input,14,FOLLOW_2); 

                    }

                     after(grammarAccess.getJdlNumericFieldTypeAccess().getIntegerEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalJDL.g:1321:2: ( ( 'Long' ) )
                    {
                    // InternalJDL.g:1321:2: ( ( 'Long' ) )
                    // InternalJDL.g:1322:3: ( 'Long' )
                    {
                     before(grammarAccess.getJdlNumericFieldTypeAccess().getLongEnumLiteralDeclaration_1()); 
                    // InternalJDL.g:1323:3: ( 'Long' )
                    // InternalJDL.g:1323:4: 'Long'
                    {
                    match(input,15,FOLLOW_2); 

                    }

                     after(grammarAccess.getJdlNumericFieldTypeAccess().getLongEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalJDL.g:1327:2: ( ( 'BigDecimal' ) )
                    {
                    // InternalJDL.g:1327:2: ( ( 'BigDecimal' ) )
                    // InternalJDL.g:1328:3: ( 'BigDecimal' )
                    {
                     before(grammarAccess.getJdlNumericFieldTypeAccess().getBigDecimalEnumLiteralDeclaration_2()); 
                    // InternalJDL.g:1329:3: ( 'BigDecimal' )
                    // InternalJDL.g:1329:4: 'BigDecimal'
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getJdlNumericFieldTypeAccess().getBigDecimalEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalJDL.g:1333:2: ( ( 'Float' ) )
                    {
                    // InternalJDL.g:1333:2: ( ( 'Float' ) )
                    // InternalJDL.g:1334:3: ( 'Float' )
                    {
                     before(grammarAccess.getJdlNumericFieldTypeAccess().getFloatEnumLiteralDeclaration_3()); 
                    // InternalJDL.g:1335:3: ( 'Float' )
                    // InternalJDL.g:1335:4: 'Float'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getJdlNumericFieldTypeAccess().getFloatEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalJDL.g:1339:2: ( ( 'Double' ) )
                    {
                    // InternalJDL.g:1339:2: ( ( 'Double' ) )
                    // InternalJDL.g:1340:3: ( 'Double' )
                    {
                     before(grammarAccess.getJdlNumericFieldTypeAccess().getDoubleEnumLiteralDeclaration_4()); 
                    // InternalJDL.g:1341:3: ( 'Double' )
                    // InternalJDL.g:1341:4: 'Double'
                    {
                    match(input,18,FOLLOW_2); 

                    }

                     after(grammarAccess.getJdlNumericFieldTypeAccess().getDoubleEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlNumericFieldType__Alternatives"


    // $ANTLR start "rule__JdlBlobFieldType__Alternatives"
    // InternalJDL.g:1349:1: rule__JdlBlobFieldType__Alternatives : ( ( ( 'Blob' ) ) | ( ( 'AnyBlob' ) ) | ( ( 'ImageBlob' ) ) );
    public final void rule__JdlBlobFieldType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1353:1: ( ( ( 'Blob' ) ) | ( ( 'AnyBlob' ) ) | ( ( 'ImageBlob' ) ) )
            int alt11=3;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt11=1;
                }
                break;
            case 20:
                {
                alt11=2;
                }
                break;
            case 21:
                {
                alt11=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalJDL.g:1354:2: ( ( 'Blob' ) )
                    {
                    // InternalJDL.g:1354:2: ( ( 'Blob' ) )
                    // InternalJDL.g:1355:3: ( 'Blob' )
                    {
                     before(grammarAccess.getJdlBlobFieldTypeAccess().getBlobEnumLiteralDeclaration_0()); 
                    // InternalJDL.g:1356:3: ( 'Blob' )
                    // InternalJDL.g:1356:4: 'Blob'
                    {
                    match(input,19,FOLLOW_2); 

                    }

                     after(grammarAccess.getJdlBlobFieldTypeAccess().getBlobEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalJDL.g:1360:2: ( ( 'AnyBlob' ) )
                    {
                    // InternalJDL.g:1360:2: ( ( 'AnyBlob' ) )
                    // InternalJDL.g:1361:3: ( 'AnyBlob' )
                    {
                     before(grammarAccess.getJdlBlobFieldTypeAccess().getAnyBlobEnumLiteralDeclaration_1()); 
                    // InternalJDL.g:1362:3: ( 'AnyBlob' )
                    // InternalJDL.g:1362:4: 'AnyBlob'
                    {
                    match(input,20,FOLLOW_2); 

                    }

                     after(grammarAccess.getJdlBlobFieldTypeAccess().getAnyBlobEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalJDL.g:1366:2: ( ( 'ImageBlob' ) )
                    {
                    // InternalJDL.g:1366:2: ( ( 'ImageBlob' ) )
                    // InternalJDL.g:1367:3: ( 'ImageBlob' )
                    {
                     before(grammarAccess.getJdlBlobFieldTypeAccess().getImageBlobEnumLiteralDeclaration_2()); 
                    // InternalJDL.g:1368:3: ( 'ImageBlob' )
                    // InternalJDL.g:1368:4: 'ImageBlob'
                    {
                    match(input,21,FOLLOW_2); 

                    }

                     after(grammarAccess.getJdlBlobFieldTypeAccess().getImageBlobEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlBlobFieldType__Alternatives"


    // $ANTLR start "rule__JdlCardinality__Alternatives"
    // InternalJDL.g:1376:1: rule__JdlCardinality__Alternatives : ( ( ( 'OneToMany' ) ) | ( ( 'ManyToOne' ) ) | ( ( 'OneToOne' ) ) | ( ( 'ManyToMany' ) ) );
    public final void rule__JdlCardinality__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1380:1: ( ( ( 'OneToMany' ) ) | ( ( 'ManyToOne' ) ) | ( ( 'OneToOne' ) ) | ( ( 'ManyToMany' ) ) )
            int alt12=4;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt12=1;
                }
                break;
            case 23:
                {
                alt12=2;
                }
                break;
            case 24:
                {
                alt12=3;
                }
                break;
            case 25:
                {
                alt12=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalJDL.g:1381:2: ( ( 'OneToMany' ) )
                    {
                    // InternalJDL.g:1381:2: ( ( 'OneToMany' ) )
                    // InternalJDL.g:1382:3: ( 'OneToMany' )
                    {
                     before(grammarAccess.getJdlCardinalityAccess().getOneToManyEnumLiteralDeclaration_0()); 
                    // InternalJDL.g:1383:3: ( 'OneToMany' )
                    // InternalJDL.g:1383:4: 'OneToMany'
                    {
                    match(input,22,FOLLOW_2); 

                    }

                     after(grammarAccess.getJdlCardinalityAccess().getOneToManyEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalJDL.g:1387:2: ( ( 'ManyToOne' ) )
                    {
                    // InternalJDL.g:1387:2: ( ( 'ManyToOne' ) )
                    // InternalJDL.g:1388:3: ( 'ManyToOne' )
                    {
                     before(grammarAccess.getJdlCardinalityAccess().getManyToOneEnumLiteralDeclaration_1()); 
                    // InternalJDL.g:1389:3: ( 'ManyToOne' )
                    // InternalJDL.g:1389:4: 'ManyToOne'
                    {
                    match(input,23,FOLLOW_2); 

                    }

                     after(grammarAccess.getJdlCardinalityAccess().getManyToOneEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalJDL.g:1393:2: ( ( 'OneToOne' ) )
                    {
                    // InternalJDL.g:1393:2: ( ( 'OneToOne' ) )
                    // InternalJDL.g:1394:3: ( 'OneToOne' )
                    {
                     before(grammarAccess.getJdlCardinalityAccess().getOneToOneEnumLiteralDeclaration_2()); 
                    // InternalJDL.g:1395:3: ( 'OneToOne' )
                    // InternalJDL.g:1395:4: 'OneToOne'
                    {
                    match(input,24,FOLLOW_2); 

                    }

                     after(grammarAccess.getJdlCardinalityAccess().getOneToOneEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalJDL.g:1399:2: ( ( 'ManyToMany' ) )
                    {
                    // InternalJDL.g:1399:2: ( ( 'ManyToMany' ) )
                    // InternalJDL.g:1400:3: ( 'ManyToMany' )
                    {
                     before(grammarAccess.getJdlCardinalityAccess().getManyToManyEnumLiteralDeclaration_3()); 
                    // InternalJDL.g:1401:3: ( 'ManyToMany' )
                    // InternalJDL.g:1401:4: 'ManyToMany'
                    {
                    match(input,25,FOLLOW_2); 

                    }

                     after(grammarAccess.getJdlCardinalityAccess().getManyToManyEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlCardinality__Alternatives"


    // $ANTLR start "rule__JdlServiceType__Alternatives"
    // InternalJDL.g:1409:1: rule__JdlServiceType__Alternatives : ( ( ( 'serviceClass' ) ) | ( ( 'serviceImpl' ) ) );
    public final void rule__JdlServiceType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1413:1: ( ( ( 'serviceClass' ) ) | ( ( 'serviceImpl' ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==26) ) {
                alt13=1;
            }
            else if ( (LA13_0==27) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalJDL.g:1414:2: ( ( 'serviceClass' ) )
                    {
                    // InternalJDL.g:1414:2: ( ( 'serviceClass' ) )
                    // InternalJDL.g:1415:3: ( 'serviceClass' )
                    {
                     before(grammarAccess.getJdlServiceTypeAccess().getServiceClassEnumLiteralDeclaration_0()); 
                    // InternalJDL.g:1416:3: ( 'serviceClass' )
                    // InternalJDL.g:1416:4: 'serviceClass'
                    {
                    match(input,26,FOLLOW_2); 

                    }

                     after(grammarAccess.getJdlServiceTypeAccess().getServiceClassEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalJDL.g:1420:2: ( ( 'serviceImpl' ) )
                    {
                    // InternalJDL.g:1420:2: ( ( 'serviceImpl' ) )
                    // InternalJDL.g:1421:3: ( 'serviceImpl' )
                    {
                     before(grammarAccess.getJdlServiceTypeAccess().getServiceImplEnumLiteralDeclaration_1()); 
                    // InternalJDL.g:1422:3: ( 'serviceImpl' )
                    // InternalJDL.g:1422:4: 'serviceImpl'
                    {
                    match(input,27,FOLLOW_2); 

                    }

                     after(grammarAccess.getJdlServiceTypeAccess().getServiceImplEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlServiceType__Alternatives"


    // $ANTLR start "rule__JdlEntity__Group__0"
    // InternalJDL.g:1430:1: rule__JdlEntity__Group__0 : rule__JdlEntity__Group__0__Impl rule__JdlEntity__Group__1 ;
    public final void rule__JdlEntity__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1434:1: ( rule__JdlEntity__Group__0__Impl rule__JdlEntity__Group__1 )
            // InternalJDL.g:1435:2: rule__JdlEntity__Group__0__Impl rule__JdlEntity__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__JdlEntity__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlEntity__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntity__Group__0"


    // $ANTLR start "rule__JdlEntity__Group__0__Impl"
    // InternalJDL.g:1442:1: rule__JdlEntity__Group__0__Impl : ( 'entity' ) ;
    public final void rule__JdlEntity__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1446:1: ( ( 'entity' ) )
            // InternalJDL.g:1447:1: ( 'entity' )
            {
            // InternalJDL.g:1447:1: ( 'entity' )
            // InternalJDL.g:1448:2: 'entity'
            {
             before(grammarAccess.getJdlEntityAccess().getEntityKeyword_0()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getJdlEntityAccess().getEntityKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntity__Group__0__Impl"


    // $ANTLR start "rule__JdlEntity__Group__1"
    // InternalJDL.g:1457:1: rule__JdlEntity__Group__1 : rule__JdlEntity__Group__1__Impl rule__JdlEntity__Group__2 ;
    public final void rule__JdlEntity__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1461:1: ( rule__JdlEntity__Group__1__Impl rule__JdlEntity__Group__2 )
            // InternalJDL.g:1462:2: rule__JdlEntity__Group__1__Impl rule__JdlEntity__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__JdlEntity__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlEntity__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntity__Group__1"


    // $ANTLR start "rule__JdlEntity__Group__1__Impl"
    // InternalJDL.g:1469:1: rule__JdlEntity__Group__1__Impl : ( ( rule__JdlEntity__NameAssignment_1 ) ) ;
    public final void rule__JdlEntity__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1473:1: ( ( ( rule__JdlEntity__NameAssignment_1 ) ) )
            // InternalJDL.g:1474:1: ( ( rule__JdlEntity__NameAssignment_1 ) )
            {
            // InternalJDL.g:1474:1: ( ( rule__JdlEntity__NameAssignment_1 ) )
            // InternalJDL.g:1475:2: ( rule__JdlEntity__NameAssignment_1 )
            {
             before(grammarAccess.getJdlEntityAccess().getNameAssignment_1()); 
            // InternalJDL.g:1476:2: ( rule__JdlEntity__NameAssignment_1 )
            // InternalJDL.g:1476:3: rule__JdlEntity__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__JdlEntity__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getJdlEntityAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntity__Group__1__Impl"


    // $ANTLR start "rule__JdlEntity__Group__2"
    // InternalJDL.g:1484:1: rule__JdlEntity__Group__2 : rule__JdlEntity__Group__2__Impl ;
    public final void rule__JdlEntity__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1488:1: ( rule__JdlEntity__Group__2__Impl )
            // InternalJDL.g:1489:2: rule__JdlEntity__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JdlEntity__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntity__Group__2"


    // $ANTLR start "rule__JdlEntity__Group__2__Impl"
    // InternalJDL.g:1495:1: rule__JdlEntity__Group__2__Impl : ( ( rule__JdlEntity__Group_2__0 )? ) ;
    public final void rule__JdlEntity__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1499:1: ( ( ( rule__JdlEntity__Group_2__0 )? ) )
            // InternalJDL.g:1500:1: ( ( rule__JdlEntity__Group_2__0 )? )
            {
            // InternalJDL.g:1500:1: ( ( rule__JdlEntity__Group_2__0 )? )
            // InternalJDL.g:1501:2: ( rule__JdlEntity__Group_2__0 )?
            {
             before(grammarAccess.getJdlEntityAccess().getGroup_2()); 
            // InternalJDL.g:1502:2: ( rule__JdlEntity__Group_2__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==29) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalJDL.g:1502:3: rule__JdlEntity__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__JdlEntity__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getJdlEntityAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntity__Group__2__Impl"


    // $ANTLR start "rule__JdlEntity__Group_2__0"
    // InternalJDL.g:1511:1: rule__JdlEntity__Group_2__0 : rule__JdlEntity__Group_2__0__Impl rule__JdlEntity__Group_2__1 ;
    public final void rule__JdlEntity__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1515:1: ( rule__JdlEntity__Group_2__0__Impl rule__JdlEntity__Group_2__1 )
            // InternalJDL.g:1516:2: rule__JdlEntity__Group_2__0__Impl rule__JdlEntity__Group_2__1
            {
            pushFollow(FOLLOW_6);
            rule__JdlEntity__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlEntity__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntity__Group_2__0"


    // $ANTLR start "rule__JdlEntity__Group_2__0__Impl"
    // InternalJDL.g:1523:1: rule__JdlEntity__Group_2__0__Impl : ( '{' ) ;
    public final void rule__JdlEntity__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1527:1: ( ( '{' ) )
            // InternalJDL.g:1528:1: ( '{' )
            {
            // InternalJDL.g:1528:1: ( '{' )
            // InternalJDL.g:1529:2: '{'
            {
             before(grammarAccess.getJdlEntityAccess().getLeftCurlyBracketKeyword_2_0()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getJdlEntityAccess().getLeftCurlyBracketKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntity__Group_2__0__Impl"


    // $ANTLR start "rule__JdlEntity__Group_2__1"
    // InternalJDL.g:1538:1: rule__JdlEntity__Group_2__1 : rule__JdlEntity__Group_2__1__Impl rule__JdlEntity__Group_2__2 ;
    public final void rule__JdlEntity__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1542:1: ( rule__JdlEntity__Group_2__1__Impl rule__JdlEntity__Group_2__2 )
            // InternalJDL.g:1543:2: rule__JdlEntity__Group_2__1__Impl rule__JdlEntity__Group_2__2
            {
            pushFollow(FOLLOW_6);
            rule__JdlEntity__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlEntity__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntity__Group_2__1"


    // $ANTLR start "rule__JdlEntity__Group_2__1__Impl"
    // InternalJDL.g:1550:1: rule__JdlEntity__Group_2__1__Impl : ( ( rule__JdlEntity__Group_2_1__0 )? ) ;
    public final void rule__JdlEntity__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1554:1: ( ( ( rule__JdlEntity__Group_2_1__0 )? ) )
            // InternalJDL.g:1555:1: ( ( rule__JdlEntity__Group_2_1__0 )? )
            {
            // InternalJDL.g:1555:1: ( ( rule__JdlEntity__Group_2_1__0 )? )
            // InternalJDL.g:1556:2: ( rule__JdlEntity__Group_2_1__0 )?
            {
             before(grammarAccess.getJdlEntityAccess().getGroup_2_1()); 
            // InternalJDL.g:1557:2: ( rule__JdlEntity__Group_2_1__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_ID) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalJDL.g:1557:3: rule__JdlEntity__Group_2_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__JdlEntity__Group_2_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getJdlEntityAccess().getGroup_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntity__Group_2__1__Impl"


    // $ANTLR start "rule__JdlEntity__Group_2__2"
    // InternalJDL.g:1565:1: rule__JdlEntity__Group_2__2 : rule__JdlEntity__Group_2__2__Impl ;
    public final void rule__JdlEntity__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1569:1: ( rule__JdlEntity__Group_2__2__Impl )
            // InternalJDL.g:1570:2: rule__JdlEntity__Group_2__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JdlEntity__Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntity__Group_2__2"


    // $ANTLR start "rule__JdlEntity__Group_2__2__Impl"
    // InternalJDL.g:1576:1: rule__JdlEntity__Group_2__2__Impl : ( '}' ) ;
    public final void rule__JdlEntity__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1580:1: ( ( '}' ) )
            // InternalJDL.g:1581:1: ( '}' )
            {
            // InternalJDL.g:1581:1: ( '}' )
            // InternalJDL.g:1582:2: '}'
            {
             before(grammarAccess.getJdlEntityAccess().getRightCurlyBracketKeyword_2_2()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getJdlEntityAccess().getRightCurlyBracketKeyword_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntity__Group_2__2__Impl"


    // $ANTLR start "rule__JdlEntity__Group_2_1__0"
    // InternalJDL.g:1592:1: rule__JdlEntity__Group_2_1__0 : rule__JdlEntity__Group_2_1__0__Impl rule__JdlEntity__Group_2_1__1 ;
    public final void rule__JdlEntity__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1596:1: ( rule__JdlEntity__Group_2_1__0__Impl rule__JdlEntity__Group_2_1__1 )
            // InternalJDL.g:1597:2: rule__JdlEntity__Group_2_1__0__Impl rule__JdlEntity__Group_2_1__1
            {
            pushFollow(FOLLOW_7);
            rule__JdlEntity__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlEntity__Group_2_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntity__Group_2_1__0"


    // $ANTLR start "rule__JdlEntity__Group_2_1__0__Impl"
    // InternalJDL.g:1604:1: rule__JdlEntity__Group_2_1__0__Impl : ( ( rule__JdlEntity__FieldsAssignment_2_1_0 ) ) ;
    public final void rule__JdlEntity__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1608:1: ( ( ( rule__JdlEntity__FieldsAssignment_2_1_0 ) ) )
            // InternalJDL.g:1609:1: ( ( rule__JdlEntity__FieldsAssignment_2_1_0 ) )
            {
            // InternalJDL.g:1609:1: ( ( rule__JdlEntity__FieldsAssignment_2_1_0 ) )
            // InternalJDL.g:1610:2: ( rule__JdlEntity__FieldsAssignment_2_1_0 )
            {
             before(grammarAccess.getJdlEntityAccess().getFieldsAssignment_2_1_0()); 
            // InternalJDL.g:1611:2: ( rule__JdlEntity__FieldsAssignment_2_1_0 )
            // InternalJDL.g:1611:3: rule__JdlEntity__FieldsAssignment_2_1_0
            {
            pushFollow(FOLLOW_2);
            rule__JdlEntity__FieldsAssignment_2_1_0();

            state._fsp--;


            }

             after(grammarAccess.getJdlEntityAccess().getFieldsAssignment_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntity__Group_2_1__0__Impl"


    // $ANTLR start "rule__JdlEntity__Group_2_1__1"
    // InternalJDL.g:1619:1: rule__JdlEntity__Group_2_1__1 : rule__JdlEntity__Group_2_1__1__Impl ;
    public final void rule__JdlEntity__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1623:1: ( rule__JdlEntity__Group_2_1__1__Impl )
            // InternalJDL.g:1624:2: rule__JdlEntity__Group_2_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JdlEntity__Group_2_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntity__Group_2_1__1"


    // $ANTLR start "rule__JdlEntity__Group_2_1__1__Impl"
    // InternalJDL.g:1630:1: rule__JdlEntity__Group_2_1__1__Impl : ( ( rule__JdlEntity__Group_2_1_1__0 )* ) ;
    public final void rule__JdlEntity__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1634:1: ( ( ( rule__JdlEntity__Group_2_1_1__0 )* ) )
            // InternalJDL.g:1635:1: ( ( rule__JdlEntity__Group_2_1_1__0 )* )
            {
            // InternalJDL.g:1635:1: ( ( rule__JdlEntity__Group_2_1_1__0 )* )
            // InternalJDL.g:1636:2: ( rule__JdlEntity__Group_2_1_1__0 )*
            {
             before(grammarAccess.getJdlEntityAccess().getGroup_2_1_1()); 
            // InternalJDL.g:1637:2: ( rule__JdlEntity__Group_2_1_1__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==31) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalJDL.g:1637:3: rule__JdlEntity__Group_2_1_1__0
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__JdlEntity__Group_2_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getJdlEntityAccess().getGroup_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntity__Group_2_1__1__Impl"


    // $ANTLR start "rule__JdlEntity__Group_2_1_1__0"
    // InternalJDL.g:1646:1: rule__JdlEntity__Group_2_1_1__0 : rule__JdlEntity__Group_2_1_1__0__Impl rule__JdlEntity__Group_2_1_1__1 ;
    public final void rule__JdlEntity__Group_2_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1650:1: ( rule__JdlEntity__Group_2_1_1__0__Impl rule__JdlEntity__Group_2_1_1__1 )
            // InternalJDL.g:1651:2: rule__JdlEntity__Group_2_1_1__0__Impl rule__JdlEntity__Group_2_1_1__1
            {
            pushFollow(FOLLOW_4);
            rule__JdlEntity__Group_2_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlEntity__Group_2_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntity__Group_2_1_1__0"


    // $ANTLR start "rule__JdlEntity__Group_2_1_1__0__Impl"
    // InternalJDL.g:1658:1: rule__JdlEntity__Group_2_1_1__0__Impl : ( ',' ) ;
    public final void rule__JdlEntity__Group_2_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1662:1: ( ( ',' ) )
            // InternalJDL.g:1663:1: ( ',' )
            {
            // InternalJDL.g:1663:1: ( ',' )
            // InternalJDL.g:1664:2: ','
            {
             before(grammarAccess.getJdlEntityAccess().getCommaKeyword_2_1_1_0()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getJdlEntityAccess().getCommaKeyword_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntity__Group_2_1_1__0__Impl"


    // $ANTLR start "rule__JdlEntity__Group_2_1_1__1"
    // InternalJDL.g:1673:1: rule__JdlEntity__Group_2_1_1__1 : rule__JdlEntity__Group_2_1_1__1__Impl ;
    public final void rule__JdlEntity__Group_2_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1677:1: ( rule__JdlEntity__Group_2_1_1__1__Impl )
            // InternalJDL.g:1678:2: rule__JdlEntity__Group_2_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JdlEntity__Group_2_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntity__Group_2_1_1__1"


    // $ANTLR start "rule__JdlEntity__Group_2_1_1__1__Impl"
    // InternalJDL.g:1684:1: rule__JdlEntity__Group_2_1_1__1__Impl : ( ( rule__JdlEntity__FieldsAssignment_2_1_1_1 ) ) ;
    public final void rule__JdlEntity__Group_2_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1688:1: ( ( ( rule__JdlEntity__FieldsAssignment_2_1_1_1 ) ) )
            // InternalJDL.g:1689:1: ( ( rule__JdlEntity__FieldsAssignment_2_1_1_1 ) )
            {
            // InternalJDL.g:1689:1: ( ( rule__JdlEntity__FieldsAssignment_2_1_1_1 ) )
            // InternalJDL.g:1690:2: ( rule__JdlEntity__FieldsAssignment_2_1_1_1 )
            {
             before(grammarAccess.getJdlEntityAccess().getFieldsAssignment_2_1_1_1()); 
            // InternalJDL.g:1691:2: ( rule__JdlEntity__FieldsAssignment_2_1_1_1 )
            // InternalJDL.g:1691:3: rule__JdlEntity__FieldsAssignment_2_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__JdlEntity__FieldsAssignment_2_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getJdlEntityAccess().getFieldsAssignment_2_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntity__Group_2_1_1__1__Impl"


    // $ANTLR start "rule__JdlEntityField__Group__0"
    // InternalJDL.g:1700:1: rule__JdlEntityField__Group__0 : rule__JdlEntityField__Group__0__Impl rule__JdlEntityField__Group__1 ;
    public final void rule__JdlEntityField__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1704:1: ( rule__JdlEntityField__Group__0__Impl rule__JdlEntityField__Group__1 )
            // InternalJDL.g:1705:2: rule__JdlEntityField__Group__0__Impl rule__JdlEntityField__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__JdlEntityField__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlEntityField__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntityField__Group__0"


    // $ANTLR start "rule__JdlEntityField__Group__0__Impl"
    // InternalJDL.g:1712:1: rule__JdlEntityField__Group__0__Impl : ( ( rule__JdlEntityField__NameAssignment_0 ) ) ;
    public final void rule__JdlEntityField__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1716:1: ( ( ( rule__JdlEntityField__NameAssignment_0 ) ) )
            // InternalJDL.g:1717:1: ( ( rule__JdlEntityField__NameAssignment_0 ) )
            {
            // InternalJDL.g:1717:1: ( ( rule__JdlEntityField__NameAssignment_0 ) )
            // InternalJDL.g:1718:2: ( rule__JdlEntityField__NameAssignment_0 )
            {
             before(grammarAccess.getJdlEntityFieldAccess().getNameAssignment_0()); 
            // InternalJDL.g:1719:2: ( rule__JdlEntityField__NameAssignment_0 )
            // InternalJDL.g:1719:3: rule__JdlEntityField__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__JdlEntityField__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getJdlEntityFieldAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntityField__Group__0__Impl"


    // $ANTLR start "rule__JdlEntityField__Group__1"
    // InternalJDL.g:1727:1: rule__JdlEntityField__Group__1 : rule__JdlEntityField__Group__1__Impl ;
    public final void rule__JdlEntityField__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1731:1: ( rule__JdlEntityField__Group__1__Impl )
            // InternalJDL.g:1732:2: rule__JdlEntityField__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JdlEntityField__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntityField__Group__1"


    // $ANTLR start "rule__JdlEntityField__Group__1__Impl"
    // InternalJDL.g:1738:1: rule__JdlEntityField__Group__1__Impl : ( ( rule__JdlEntityField__TypeAssignment_1 ) ) ;
    public final void rule__JdlEntityField__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1742:1: ( ( ( rule__JdlEntityField__TypeAssignment_1 ) ) )
            // InternalJDL.g:1743:1: ( ( rule__JdlEntityField__TypeAssignment_1 ) )
            {
            // InternalJDL.g:1743:1: ( ( rule__JdlEntityField__TypeAssignment_1 ) )
            // InternalJDL.g:1744:2: ( rule__JdlEntityField__TypeAssignment_1 )
            {
             before(grammarAccess.getJdlEntityFieldAccess().getTypeAssignment_1()); 
            // InternalJDL.g:1745:2: ( rule__JdlEntityField__TypeAssignment_1 )
            // InternalJDL.g:1745:3: rule__JdlEntityField__TypeAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__JdlEntityField__TypeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getJdlEntityFieldAccess().getTypeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntityField__Group__1__Impl"


    // $ANTLR start "rule__JdlEnumField__Group__0"
    // InternalJDL.g:1754:1: rule__JdlEnumField__Group__0 : rule__JdlEnumField__Group__0__Impl rule__JdlEnumField__Group__1 ;
    public final void rule__JdlEnumField__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1758:1: ( rule__JdlEnumField__Group__0__Impl rule__JdlEnumField__Group__1 )
            // InternalJDL.g:1759:2: rule__JdlEnumField__Group__0__Impl rule__JdlEnumField__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__JdlEnumField__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlEnumField__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEnumField__Group__0"


    // $ANTLR start "rule__JdlEnumField__Group__0__Impl"
    // InternalJDL.g:1766:1: rule__JdlEnumField__Group__0__Impl : ( ( rule__JdlEnumField__EnumTypeAssignment_0 ) ) ;
    public final void rule__JdlEnumField__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1770:1: ( ( ( rule__JdlEnumField__EnumTypeAssignment_0 ) ) )
            // InternalJDL.g:1771:1: ( ( rule__JdlEnumField__EnumTypeAssignment_0 ) )
            {
            // InternalJDL.g:1771:1: ( ( rule__JdlEnumField__EnumTypeAssignment_0 ) )
            // InternalJDL.g:1772:2: ( rule__JdlEnumField__EnumTypeAssignment_0 )
            {
             before(grammarAccess.getJdlEnumFieldAccess().getEnumTypeAssignment_0()); 
            // InternalJDL.g:1773:2: ( rule__JdlEnumField__EnumTypeAssignment_0 )
            // InternalJDL.g:1773:3: rule__JdlEnumField__EnumTypeAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__JdlEnumField__EnumTypeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getJdlEnumFieldAccess().getEnumTypeAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEnumField__Group__0__Impl"


    // $ANTLR start "rule__JdlEnumField__Group__1"
    // InternalJDL.g:1781:1: rule__JdlEnumField__Group__1 : rule__JdlEnumField__Group__1__Impl ;
    public final void rule__JdlEnumField__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1785:1: ( rule__JdlEnumField__Group__1__Impl )
            // InternalJDL.g:1786:2: rule__JdlEnumField__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JdlEnumField__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEnumField__Group__1"


    // $ANTLR start "rule__JdlEnumField__Group__1__Impl"
    // InternalJDL.g:1792:1: rule__JdlEnumField__Group__1__Impl : ( ( rule__JdlEnumField__ValidatorsAssignment_1 )? ) ;
    public final void rule__JdlEnumField__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1796:1: ( ( ( rule__JdlEnumField__ValidatorsAssignment_1 )? ) )
            // InternalJDL.g:1797:1: ( ( rule__JdlEnumField__ValidatorsAssignment_1 )? )
            {
            // InternalJDL.g:1797:1: ( ( rule__JdlEnumField__ValidatorsAssignment_1 )? )
            // InternalJDL.g:1798:2: ( rule__JdlEnumField__ValidatorsAssignment_1 )?
            {
             before(grammarAccess.getJdlEnumFieldAccess().getValidatorsAssignment_1()); 
            // InternalJDL.g:1799:2: ( rule__JdlEnumField__ValidatorsAssignment_1 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==50) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalJDL.g:1799:3: rule__JdlEnumField__ValidatorsAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__JdlEnumField__ValidatorsAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getJdlEnumFieldAccess().getValidatorsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEnumField__Group__1__Impl"


    // $ANTLR start "rule__JdlStringField__Group__0"
    // InternalJDL.g:1808:1: rule__JdlStringField__Group__0 : rule__JdlStringField__Group__0__Impl rule__JdlStringField__Group__1 ;
    public final void rule__JdlStringField__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1812:1: ( rule__JdlStringField__Group__0__Impl rule__JdlStringField__Group__1 )
            // InternalJDL.g:1813:2: rule__JdlStringField__Group__0__Impl rule__JdlStringField__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__JdlStringField__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlStringField__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlStringField__Group__0"


    // $ANTLR start "rule__JdlStringField__Group__0__Impl"
    // InternalJDL.g:1820:1: rule__JdlStringField__Group__0__Impl : ( ( rule__JdlStringField__StringTypeAssignment_0 ) ) ;
    public final void rule__JdlStringField__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1824:1: ( ( ( rule__JdlStringField__StringTypeAssignment_0 ) ) )
            // InternalJDL.g:1825:1: ( ( rule__JdlStringField__StringTypeAssignment_0 ) )
            {
            // InternalJDL.g:1825:1: ( ( rule__JdlStringField__StringTypeAssignment_0 ) )
            // InternalJDL.g:1826:2: ( rule__JdlStringField__StringTypeAssignment_0 )
            {
             before(grammarAccess.getJdlStringFieldAccess().getStringTypeAssignment_0()); 
            // InternalJDL.g:1827:2: ( rule__JdlStringField__StringTypeAssignment_0 )
            // InternalJDL.g:1827:3: rule__JdlStringField__StringTypeAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__JdlStringField__StringTypeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getJdlStringFieldAccess().getStringTypeAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlStringField__Group__0__Impl"


    // $ANTLR start "rule__JdlStringField__Group__1"
    // InternalJDL.g:1835:1: rule__JdlStringField__Group__1 : rule__JdlStringField__Group__1__Impl ;
    public final void rule__JdlStringField__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1839:1: ( rule__JdlStringField__Group__1__Impl )
            // InternalJDL.g:1840:2: rule__JdlStringField__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JdlStringField__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlStringField__Group__1"


    // $ANTLR start "rule__JdlStringField__Group__1__Impl"
    // InternalJDL.g:1846:1: rule__JdlStringField__Group__1__Impl : ( ( rule__JdlStringField__ValidatorsAssignment_1 )? ) ;
    public final void rule__JdlStringField__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1850:1: ( ( ( rule__JdlStringField__ValidatorsAssignment_1 )? ) )
            // InternalJDL.g:1851:1: ( ( rule__JdlStringField__ValidatorsAssignment_1 )? )
            {
            // InternalJDL.g:1851:1: ( ( rule__JdlStringField__ValidatorsAssignment_1 )? )
            // InternalJDL.g:1852:2: ( rule__JdlStringField__ValidatorsAssignment_1 )?
            {
             before(grammarAccess.getJdlStringFieldAccess().getValidatorsAssignment_1()); 
            // InternalJDL.g:1853:2: ( rule__JdlStringField__ValidatorsAssignment_1 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==50) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalJDL.g:1853:3: rule__JdlStringField__ValidatorsAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__JdlStringField__ValidatorsAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getJdlStringFieldAccess().getValidatorsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlStringField__Group__1__Impl"


    // $ANTLR start "rule__JdlNumericField__Group__0"
    // InternalJDL.g:1862:1: rule__JdlNumericField__Group__0 : rule__JdlNumericField__Group__0__Impl rule__JdlNumericField__Group__1 ;
    public final void rule__JdlNumericField__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1866:1: ( rule__JdlNumericField__Group__0__Impl rule__JdlNumericField__Group__1 )
            // InternalJDL.g:1867:2: rule__JdlNumericField__Group__0__Impl rule__JdlNumericField__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__JdlNumericField__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlNumericField__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlNumericField__Group__0"


    // $ANTLR start "rule__JdlNumericField__Group__0__Impl"
    // InternalJDL.g:1874:1: rule__JdlNumericField__Group__0__Impl : ( ( rule__JdlNumericField__NumericFieldTypeAssignment_0 ) ) ;
    public final void rule__JdlNumericField__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1878:1: ( ( ( rule__JdlNumericField__NumericFieldTypeAssignment_0 ) ) )
            // InternalJDL.g:1879:1: ( ( rule__JdlNumericField__NumericFieldTypeAssignment_0 ) )
            {
            // InternalJDL.g:1879:1: ( ( rule__JdlNumericField__NumericFieldTypeAssignment_0 ) )
            // InternalJDL.g:1880:2: ( rule__JdlNumericField__NumericFieldTypeAssignment_0 )
            {
             before(grammarAccess.getJdlNumericFieldAccess().getNumericFieldTypeAssignment_0()); 
            // InternalJDL.g:1881:2: ( rule__JdlNumericField__NumericFieldTypeAssignment_0 )
            // InternalJDL.g:1881:3: rule__JdlNumericField__NumericFieldTypeAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__JdlNumericField__NumericFieldTypeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getJdlNumericFieldAccess().getNumericFieldTypeAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlNumericField__Group__0__Impl"


    // $ANTLR start "rule__JdlNumericField__Group__1"
    // InternalJDL.g:1889:1: rule__JdlNumericField__Group__1 : rule__JdlNumericField__Group__1__Impl ;
    public final void rule__JdlNumericField__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1893:1: ( rule__JdlNumericField__Group__1__Impl )
            // InternalJDL.g:1894:2: rule__JdlNumericField__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JdlNumericField__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlNumericField__Group__1"


    // $ANTLR start "rule__JdlNumericField__Group__1__Impl"
    // InternalJDL.g:1900:1: rule__JdlNumericField__Group__1__Impl : ( ( rule__JdlNumericField__ValidatorsAssignment_1 )? ) ;
    public final void rule__JdlNumericField__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1904:1: ( ( ( rule__JdlNumericField__ValidatorsAssignment_1 )? ) )
            // InternalJDL.g:1905:1: ( ( rule__JdlNumericField__ValidatorsAssignment_1 )? )
            {
            // InternalJDL.g:1905:1: ( ( rule__JdlNumericField__ValidatorsAssignment_1 )? )
            // InternalJDL.g:1906:2: ( rule__JdlNumericField__ValidatorsAssignment_1 )?
            {
             before(grammarAccess.getJdlNumericFieldAccess().getValidatorsAssignment_1()); 
            // InternalJDL.g:1907:2: ( rule__JdlNumericField__ValidatorsAssignment_1 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==50) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalJDL.g:1907:3: rule__JdlNumericField__ValidatorsAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__JdlNumericField__ValidatorsAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getJdlNumericFieldAccess().getValidatorsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlNumericField__Group__1__Impl"


    // $ANTLR start "rule__JdlBooleanField__Group__0"
    // InternalJDL.g:1916:1: rule__JdlBooleanField__Group__0 : rule__JdlBooleanField__Group__0__Impl rule__JdlBooleanField__Group__1 ;
    public final void rule__JdlBooleanField__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1920:1: ( rule__JdlBooleanField__Group__0__Impl rule__JdlBooleanField__Group__1 )
            // InternalJDL.g:1921:2: rule__JdlBooleanField__Group__0__Impl rule__JdlBooleanField__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__JdlBooleanField__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlBooleanField__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlBooleanField__Group__0"


    // $ANTLR start "rule__JdlBooleanField__Group__0__Impl"
    // InternalJDL.g:1928:1: rule__JdlBooleanField__Group__0__Impl : ( ( rule__JdlBooleanField__BooleanTypeAssignment_0 ) ) ;
    public final void rule__JdlBooleanField__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1932:1: ( ( ( rule__JdlBooleanField__BooleanTypeAssignment_0 ) ) )
            // InternalJDL.g:1933:1: ( ( rule__JdlBooleanField__BooleanTypeAssignment_0 ) )
            {
            // InternalJDL.g:1933:1: ( ( rule__JdlBooleanField__BooleanTypeAssignment_0 ) )
            // InternalJDL.g:1934:2: ( rule__JdlBooleanField__BooleanTypeAssignment_0 )
            {
             before(grammarAccess.getJdlBooleanFieldAccess().getBooleanTypeAssignment_0()); 
            // InternalJDL.g:1935:2: ( rule__JdlBooleanField__BooleanTypeAssignment_0 )
            // InternalJDL.g:1935:3: rule__JdlBooleanField__BooleanTypeAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__JdlBooleanField__BooleanTypeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getJdlBooleanFieldAccess().getBooleanTypeAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlBooleanField__Group__0__Impl"


    // $ANTLR start "rule__JdlBooleanField__Group__1"
    // InternalJDL.g:1943:1: rule__JdlBooleanField__Group__1 : rule__JdlBooleanField__Group__1__Impl ;
    public final void rule__JdlBooleanField__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1947:1: ( rule__JdlBooleanField__Group__1__Impl )
            // InternalJDL.g:1948:2: rule__JdlBooleanField__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JdlBooleanField__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlBooleanField__Group__1"


    // $ANTLR start "rule__JdlBooleanField__Group__1__Impl"
    // InternalJDL.g:1954:1: rule__JdlBooleanField__Group__1__Impl : ( ( rule__JdlBooleanField__ValidatorsAssignment_1 )? ) ;
    public final void rule__JdlBooleanField__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1958:1: ( ( ( rule__JdlBooleanField__ValidatorsAssignment_1 )? ) )
            // InternalJDL.g:1959:1: ( ( rule__JdlBooleanField__ValidatorsAssignment_1 )? )
            {
            // InternalJDL.g:1959:1: ( ( rule__JdlBooleanField__ValidatorsAssignment_1 )? )
            // InternalJDL.g:1960:2: ( rule__JdlBooleanField__ValidatorsAssignment_1 )?
            {
             before(grammarAccess.getJdlBooleanFieldAccess().getValidatorsAssignment_1()); 
            // InternalJDL.g:1961:2: ( rule__JdlBooleanField__ValidatorsAssignment_1 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==50) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalJDL.g:1961:3: rule__JdlBooleanField__ValidatorsAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__JdlBooleanField__ValidatorsAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getJdlBooleanFieldAccess().getValidatorsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlBooleanField__Group__1__Impl"


    // $ANTLR start "rule__JdlDateField__Group__0"
    // InternalJDL.g:1970:1: rule__JdlDateField__Group__0 : rule__JdlDateField__Group__0__Impl rule__JdlDateField__Group__1 ;
    public final void rule__JdlDateField__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1974:1: ( rule__JdlDateField__Group__0__Impl rule__JdlDateField__Group__1 )
            // InternalJDL.g:1975:2: rule__JdlDateField__Group__0__Impl rule__JdlDateField__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__JdlDateField__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlDateField__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlDateField__Group__0"


    // $ANTLR start "rule__JdlDateField__Group__0__Impl"
    // InternalJDL.g:1982:1: rule__JdlDateField__Group__0__Impl : ( ( rule__JdlDateField__Alternatives_0 ) ) ;
    public final void rule__JdlDateField__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:1986:1: ( ( ( rule__JdlDateField__Alternatives_0 ) ) )
            // InternalJDL.g:1987:1: ( ( rule__JdlDateField__Alternatives_0 ) )
            {
            // InternalJDL.g:1987:1: ( ( rule__JdlDateField__Alternatives_0 ) )
            // InternalJDL.g:1988:2: ( rule__JdlDateField__Alternatives_0 )
            {
             before(grammarAccess.getJdlDateFieldAccess().getAlternatives_0()); 
            // InternalJDL.g:1989:2: ( rule__JdlDateField__Alternatives_0 )
            // InternalJDL.g:1989:3: rule__JdlDateField__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__JdlDateField__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getJdlDateFieldAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlDateField__Group__0__Impl"


    // $ANTLR start "rule__JdlDateField__Group__1"
    // InternalJDL.g:1997:1: rule__JdlDateField__Group__1 : rule__JdlDateField__Group__1__Impl ;
    public final void rule__JdlDateField__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2001:1: ( rule__JdlDateField__Group__1__Impl )
            // InternalJDL.g:2002:2: rule__JdlDateField__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JdlDateField__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlDateField__Group__1"


    // $ANTLR start "rule__JdlDateField__Group__1__Impl"
    // InternalJDL.g:2008:1: rule__JdlDateField__Group__1__Impl : ( ( rule__JdlDateField__ValidatorsAssignment_1 )? ) ;
    public final void rule__JdlDateField__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2012:1: ( ( ( rule__JdlDateField__ValidatorsAssignment_1 )? ) )
            // InternalJDL.g:2013:1: ( ( rule__JdlDateField__ValidatorsAssignment_1 )? )
            {
            // InternalJDL.g:2013:1: ( ( rule__JdlDateField__ValidatorsAssignment_1 )? )
            // InternalJDL.g:2014:2: ( rule__JdlDateField__ValidatorsAssignment_1 )?
            {
             before(grammarAccess.getJdlDateFieldAccess().getValidatorsAssignment_1()); 
            // InternalJDL.g:2015:2: ( rule__JdlDateField__ValidatorsAssignment_1 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==50) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalJDL.g:2015:3: rule__JdlDateField__ValidatorsAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__JdlDateField__ValidatorsAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getJdlDateFieldAccess().getValidatorsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlDateField__Group__1__Impl"


    // $ANTLR start "rule__JdlBlobField__Group__0"
    // InternalJDL.g:2024:1: rule__JdlBlobField__Group__0 : rule__JdlBlobField__Group__0__Impl rule__JdlBlobField__Group__1 ;
    public final void rule__JdlBlobField__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2028:1: ( rule__JdlBlobField__Group__0__Impl rule__JdlBlobField__Group__1 )
            // InternalJDL.g:2029:2: rule__JdlBlobField__Group__0__Impl rule__JdlBlobField__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__JdlBlobField__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlBlobField__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlBlobField__Group__0"


    // $ANTLR start "rule__JdlBlobField__Group__0__Impl"
    // InternalJDL.g:2036:1: rule__JdlBlobField__Group__0__Impl : ( ( rule__JdlBlobField__BlobFieldTypeAssignment_0 ) ) ;
    public final void rule__JdlBlobField__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2040:1: ( ( ( rule__JdlBlobField__BlobFieldTypeAssignment_0 ) ) )
            // InternalJDL.g:2041:1: ( ( rule__JdlBlobField__BlobFieldTypeAssignment_0 ) )
            {
            // InternalJDL.g:2041:1: ( ( rule__JdlBlobField__BlobFieldTypeAssignment_0 ) )
            // InternalJDL.g:2042:2: ( rule__JdlBlobField__BlobFieldTypeAssignment_0 )
            {
             before(grammarAccess.getJdlBlobFieldAccess().getBlobFieldTypeAssignment_0()); 
            // InternalJDL.g:2043:2: ( rule__JdlBlobField__BlobFieldTypeAssignment_0 )
            // InternalJDL.g:2043:3: rule__JdlBlobField__BlobFieldTypeAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__JdlBlobField__BlobFieldTypeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getJdlBlobFieldAccess().getBlobFieldTypeAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlBlobField__Group__0__Impl"


    // $ANTLR start "rule__JdlBlobField__Group__1"
    // InternalJDL.g:2051:1: rule__JdlBlobField__Group__1 : rule__JdlBlobField__Group__1__Impl ;
    public final void rule__JdlBlobField__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2055:1: ( rule__JdlBlobField__Group__1__Impl )
            // InternalJDL.g:2056:2: rule__JdlBlobField__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JdlBlobField__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlBlobField__Group__1"


    // $ANTLR start "rule__JdlBlobField__Group__1__Impl"
    // InternalJDL.g:2062:1: rule__JdlBlobField__Group__1__Impl : ( ( rule__JdlBlobField__ValidatorsAssignment_1 )? ) ;
    public final void rule__JdlBlobField__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2066:1: ( ( ( rule__JdlBlobField__ValidatorsAssignment_1 )? ) )
            // InternalJDL.g:2067:1: ( ( rule__JdlBlobField__ValidatorsAssignment_1 )? )
            {
            // InternalJDL.g:2067:1: ( ( rule__JdlBlobField__ValidatorsAssignment_1 )? )
            // InternalJDL.g:2068:2: ( rule__JdlBlobField__ValidatorsAssignment_1 )?
            {
             before(grammarAccess.getJdlBlobFieldAccess().getValidatorsAssignment_1()); 
            // InternalJDL.g:2069:2: ( rule__JdlBlobField__ValidatorsAssignment_1 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==50) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalJDL.g:2069:3: rule__JdlBlobField__ValidatorsAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__JdlBlobField__ValidatorsAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getJdlBlobFieldAccess().getValidatorsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlBlobField__Group__1__Impl"


    // $ANTLR start "rule__JdlStringValidators__Group__0"
    // InternalJDL.g:2078:1: rule__JdlStringValidators__Group__0 : rule__JdlStringValidators__Group__0__Impl rule__JdlStringValidators__Group__1 ;
    public final void rule__JdlStringValidators__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2082:1: ( rule__JdlStringValidators__Group__0__Impl rule__JdlStringValidators__Group__1 )
            // InternalJDL.g:2083:2: rule__JdlStringValidators__Group__0__Impl rule__JdlStringValidators__Group__1
            {
            pushFollow(FOLLOW_11);
            rule__JdlStringValidators__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlStringValidators__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlStringValidators__Group__0"


    // $ANTLR start "rule__JdlStringValidators__Group__0__Impl"
    // InternalJDL.g:2090:1: rule__JdlStringValidators__Group__0__Impl : ( ( rule__JdlStringValidators__RequiredAssignment_0 ) ) ;
    public final void rule__JdlStringValidators__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2094:1: ( ( ( rule__JdlStringValidators__RequiredAssignment_0 ) ) )
            // InternalJDL.g:2095:1: ( ( rule__JdlStringValidators__RequiredAssignment_0 ) )
            {
            // InternalJDL.g:2095:1: ( ( rule__JdlStringValidators__RequiredAssignment_0 ) )
            // InternalJDL.g:2096:2: ( rule__JdlStringValidators__RequiredAssignment_0 )
            {
             before(grammarAccess.getJdlStringValidatorsAccess().getRequiredAssignment_0()); 
            // InternalJDL.g:2097:2: ( rule__JdlStringValidators__RequiredAssignment_0 )
            // InternalJDL.g:2097:3: rule__JdlStringValidators__RequiredAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__JdlStringValidators__RequiredAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getJdlStringValidatorsAccess().getRequiredAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlStringValidators__Group__0__Impl"


    // $ANTLR start "rule__JdlStringValidators__Group__1"
    // InternalJDL.g:2105:1: rule__JdlStringValidators__Group__1 : rule__JdlStringValidators__Group__1__Impl rule__JdlStringValidators__Group__2 ;
    public final void rule__JdlStringValidators__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2109:1: ( rule__JdlStringValidators__Group__1__Impl rule__JdlStringValidators__Group__2 )
            // InternalJDL.g:2110:2: rule__JdlStringValidators__Group__1__Impl rule__JdlStringValidators__Group__2
            {
            pushFollow(FOLLOW_11);
            rule__JdlStringValidators__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlStringValidators__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlStringValidators__Group__1"


    // $ANTLR start "rule__JdlStringValidators__Group__1__Impl"
    // InternalJDL.g:2117:1: rule__JdlStringValidators__Group__1__Impl : ( ( rule__JdlStringValidators__MinLengthAssignment_1 )? ) ;
    public final void rule__JdlStringValidators__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2121:1: ( ( ( rule__JdlStringValidators__MinLengthAssignment_1 )? ) )
            // InternalJDL.g:2122:1: ( ( rule__JdlStringValidators__MinLengthAssignment_1 )? )
            {
            // InternalJDL.g:2122:1: ( ( rule__JdlStringValidators__MinLengthAssignment_1 )? )
            // InternalJDL.g:2123:2: ( rule__JdlStringValidators__MinLengthAssignment_1 )?
            {
             before(grammarAccess.getJdlStringValidatorsAccess().getMinLengthAssignment_1()); 
            // InternalJDL.g:2124:2: ( rule__JdlStringValidators__MinLengthAssignment_1 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==32) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalJDL.g:2124:3: rule__JdlStringValidators__MinLengthAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__JdlStringValidators__MinLengthAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getJdlStringValidatorsAccess().getMinLengthAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlStringValidators__Group__1__Impl"


    // $ANTLR start "rule__JdlStringValidators__Group__2"
    // InternalJDL.g:2132:1: rule__JdlStringValidators__Group__2 : rule__JdlStringValidators__Group__2__Impl rule__JdlStringValidators__Group__3 ;
    public final void rule__JdlStringValidators__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2136:1: ( rule__JdlStringValidators__Group__2__Impl rule__JdlStringValidators__Group__3 )
            // InternalJDL.g:2137:2: rule__JdlStringValidators__Group__2__Impl rule__JdlStringValidators__Group__3
            {
            pushFollow(FOLLOW_11);
            rule__JdlStringValidators__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlStringValidators__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlStringValidators__Group__2"


    // $ANTLR start "rule__JdlStringValidators__Group__2__Impl"
    // InternalJDL.g:2144:1: rule__JdlStringValidators__Group__2__Impl : ( ( rule__JdlStringValidators__MaxlengthAssignment_2 )? ) ;
    public final void rule__JdlStringValidators__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2148:1: ( ( ( rule__JdlStringValidators__MaxlengthAssignment_2 )? ) )
            // InternalJDL.g:2149:1: ( ( rule__JdlStringValidators__MaxlengthAssignment_2 )? )
            {
            // InternalJDL.g:2149:1: ( ( rule__JdlStringValidators__MaxlengthAssignment_2 )? )
            // InternalJDL.g:2150:2: ( rule__JdlStringValidators__MaxlengthAssignment_2 )?
            {
             before(grammarAccess.getJdlStringValidatorsAccess().getMaxlengthAssignment_2()); 
            // InternalJDL.g:2151:2: ( rule__JdlStringValidators__MaxlengthAssignment_2 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==35) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalJDL.g:2151:3: rule__JdlStringValidators__MaxlengthAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__JdlStringValidators__MaxlengthAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getJdlStringValidatorsAccess().getMaxlengthAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlStringValidators__Group__2__Impl"


    // $ANTLR start "rule__JdlStringValidators__Group__3"
    // InternalJDL.g:2159:1: rule__JdlStringValidators__Group__3 : rule__JdlStringValidators__Group__3__Impl ;
    public final void rule__JdlStringValidators__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2163:1: ( rule__JdlStringValidators__Group__3__Impl )
            // InternalJDL.g:2164:2: rule__JdlStringValidators__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JdlStringValidators__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlStringValidators__Group__3"


    // $ANTLR start "rule__JdlStringValidators__Group__3__Impl"
    // InternalJDL.g:2170:1: rule__JdlStringValidators__Group__3__Impl : ( ( rule__JdlStringValidators__PatternAssignment_3 )? ) ;
    public final void rule__JdlStringValidators__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2174:1: ( ( ( rule__JdlStringValidators__PatternAssignment_3 )? ) )
            // InternalJDL.g:2175:1: ( ( rule__JdlStringValidators__PatternAssignment_3 )? )
            {
            // InternalJDL.g:2175:1: ( ( rule__JdlStringValidators__PatternAssignment_3 )? )
            // InternalJDL.g:2176:2: ( rule__JdlStringValidators__PatternAssignment_3 )?
            {
             before(grammarAccess.getJdlStringValidatorsAccess().getPatternAssignment_3()); 
            // InternalJDL.g:2177:2: ( rule__JdlStringValidators__PatternAssignment_3 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==36) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalJDL.g:2177:3: rule__JdlStringValidators__PatternAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__JdlStringValidators__PatternAssignment_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getJdlStringValidatorsAccess().getPatternAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlStringValidators__Group__3__Impl"


    // $ANTLR start "rule__JdlNumericValidators__Group__0"
    // InternalJDL.g:2186:1: rule__JdlNumericValidators__Group__0 : rule__JdlNumericValidators__Group__0__Impl rule__JdlNumericValidators__Group__1 ;
    public final void rule__JdlNumericValidators__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2190:1: ( rule__JdlNumericValidators__Group__0__Impl rule__JdlNumericValidators__Group__1 )
            // InternalJDL.g:2191:2: rule__JdlNumericValidators__Group__0__Impl rule__JdlNumericValidators__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__JdlNumericValidators__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlNumericValidators__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlNumericValidators__Group__0"


    // $ANTLR start "rule__JdlNumericValidators__Group__0__Impl"
    // InternalJDL.g:2198:1: rule__JdlNumericValidators__Group__0__Impl : ( ( rule__JdlNumericValidators__RequiredAssignment_0 ) ) ;
    public final void rule__JdlNumericValidators__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2202:1: ( ( ( rule__JdlNumericValidators__RequiredAssignment_0 ) ) )
            // InternalJDL.g:2203:1: ( ( rule__JdlNumericValidators__RequiredAssignment_0 ) )
            {
            // InternalJDL.g:2203:1: ( ( rule__JdlNumericValidators__RequiredAssignment_0 ) )
            // InternalJDL.g:2204:2: ( rule__JdlNumericValidators__RequiredAssignment_0 )
            {
             before(grammarAccess.getJdlNumericValidatorsAccess().getRequiredAssignment_0()); 
            // InternalJDL.g:2205:2: ( rule__JdlNumericValidators__RequiredAssignment_0 )
            // InternalJDL.g:2205:3: rule__JdlNumericValidators__RequiredAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__JdlNumericValidators__RequiredAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getJdlNumericValidatorsAccess().getRequiredAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlNumericValidators__Group__0__Impl"


    // $ANTLR start "rule__JdlNumericValidators__Group__1"
    // InternalJDL.g:2213:1: rule__JdlNumericValidators__Group__1 : rule__JdlNumericValidators__Group__1__Impl rule__JdlNumericValidators__Group__2 ;
    public final void rule__JdlNumericValidators__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2217:1: ( rule__JdlNumericValidators__Group__1__Impl rule__JdlNumericValidators__Group__2 )
            // InternalJDL.g:2218:2: rule__JdlNumericValidators__Group__1__Impl rule__JdlNumericValidators__Group__2
            {
            pushFollow(FOLLOW_12);
            rule__JdlNumericValidators__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlNumericValidators__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlNumericValidators__Group__1"


    // $ANTLR start "rule__JdlNumericValidators__Group__1__Impl"
    // InternalJDL.g:2225:1: rule__JdlNumericValidators__Group__1__Impl : ( ( rule__JdlNumericValidators__MinlengthAssignment_1 )? ) ;
    public final void rule__JdlNumericValidators__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2229:1: ( ( ( rule__JdlNumericValidators__MinlengthAssignment_1 )? ) )
            // InternalJDL.g:2230:1: ( ( rule__JdlNumericValidators__MinlengthAssignment_1 )? )
            {
            // InternalJDL.g:2230:1: ( ( rule__JdlNumericValidators__MinlengthAssignment_1 )? )
            // InternalJDL.g:2231:2: ( rule__JdlNumericValidators__MinlengthAssignment_1 )?
            {
             before(grammarAccess.getJdlNumericValidatorsAccess().getMinlengthAssignment_1()); 
            // InternalJDL.g:2232:2: ( rule__JdlNumericValidators__MinlengthAssignment_1 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==37) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalJDL.g:2232:3: rule__JdlNumericValidators__MinlengthAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__JdlNumericValidators__MinlengthAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getJdlNumericValidatorsAccess().getMinlengthAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlNumericValidators__Group__1__Impl"


    // $ANTLR start "rule__JdlNumericValidators__Group__2"
    // InternalJDL.g:2240:1: rule__JdlNumericValidators__Group__2 : rule__JdlNumericValidators__Group__2__Impl ;
    public final void rule__JdlNumericValidators__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2244:1: ( rule__JdlNumericValidators__Group__2__Impl )
            // InternalJDL.g:2245:2: rule__JdlNumericValidators__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JdlNumericValidators__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlNumericValidators__Group__2"


    // $ANTLR start "rule__JdlNumericValidators__Group__2__Impl"
    // InternalJDL.g:2251:1: rule__JdlNumericValidators__Group__2__Impl : ( ( rule__JdlNumericValidators__MaxlengthAssignment_2 )? ) ;
    public final void rule__JdlNumericValidators__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2255:1: ( ( ( rule__JdlNumericValidators__MaxlengthAssignment_2 )? ) )
            // InternalJDL.g:2256:1: ( ( rule__JdlNumericValidators__MaxlengthAssignment_2 )? )
            {
            // InternalJDL.g:2256:1: ( ( rule__JdlNumericValidators__MaxlengthAssignment_2 )? )
            // InternalJDL.g:2257:2: ( rule__JdlNumericValidators__MaxlengthAssignment_2 )?
            {
             before(grammarAccess.getJdlNumericValidatorsAccess().getMaxlengthAssignment_2()); 
            // InternalJDL.g:2258:2: ( rule__JdlNumericValidators__MaxlengthAssignment_2 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==38) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalJDL.g:2258:3: rule__JdlNumericValidators__MaxlengthAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__JdlNumericValidators__MaxlengthAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getJdlNumericValidatorsAccess().getMaxlengthAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlNumericValidators__Group__2__Impl"


    // $ANTLR start "rule__JdlBlobValidators__Group__0"
    // InternalJDL.g:2267:1: rule__JdlBlobValidators__Group__0 : rule__JdlBlobValidators__Group__0__Impl rule__JdlBlobValidators__Group__1 ;
    public final void rule__JdlBlobValidators__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2271:1: ( rule__JdlBlobValidators__Group__0__Impl rule__JdlBlobValidators__Group__1 )
            // InternalJDL.g:2272:2: rule__JdlBlobValidators__Group__0__Impl rule__JdlBlobValidators__Group__1
            {
            pushFollow(FOLLOW_13);
            rule__JdlBlobValidators__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlBlobValidators__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlBlobValidators__Group__0"


    // $ANTLR start "rule__JdlBlobValidators__Group__0__Impl"
    // InternalJDL.g:2279:1: rule__JdlBlobValidators__Group__0__Impl : ( ( rule__JdlBlobValidators__RequiredAssignment_0 ) ) ;
    public final void rule__JdlBlobValidators__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2283:1: ( ( ( rule__JdlBlobValidators__RequiredAssignment_0 ) ) )
            // InternalJDL.g:2284:1: ( ( rule__JdlBlobValidators__RequiredAssignment_0 ) )
            {
            // InternalJDL.g:2284:1: ( ( rule__JdlBlobValidators__RequiredAssignment_0 ) )
            // InternalJDL.g:2285:2: ( rule__JdlBlobValidators__RequiredAssignment_0 )
            {
             before(grammarAccess.getJdlBlobValidatorsAccess().getRequiredAssignment_0()); 
            // InternalJDL.g:2286:2: ( rule__JdlBlobValidators__RequiredAssignment_0 )
            // InternalJDL.g:2286:3: rule__JdlBlobValidators__RequiredAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__JdlBlobValidators__RequiredAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getJdlBlobValidatorsAccess().getRequiredAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlBlobValidators__Group__0__Impl"


    // $ANTLR start "rule__JdlBlobValidators__Group__1"
    // InternalJDL.g:2294:1: rule__JdlBlobValidators__Group__1 : rule__JdlBlobValidators__Group__1__Impl rule__JdlBlobValidators__Group__2 ;
    public final void rule__JdlBlobValidators__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2298:1: ( rule__JdlBlobValidators__Group__1__Impl rule__JdlBlobValidators__Group__2 )
            // InternalJDL.g:2299:2: rule__JdlBlobValidators__Group__1__Impl rule__JdlBlobValidators__Group__2
            {
            pushFollow(FOLLOW_13);
            rule__JdlBlobValidators__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlBlobValidators__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlBlobValidators__Group__1"


    // $ANTLR start "rule__JdlBlobValidators__Group__1__Impl"
    // InternalJDL.g:2306:1: rule__JdlBlobValidators__Group__1__Impl : ( ( rule__JdlBlobValidators__MinbytesAssignment_1 )? ) ;
    public final void rule__JdlBlobValidators__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2310:1: ( ( ( rule__JdlBlobValidators__MinbytesAssignment_1 )? ) )
            // InternalJDL.g:2311:1: ( ( rule__JdlBlobValidators__MinbytesAssignment_1 )? )
            {
            // InternalJDL.g:2311:1: ( ( rule__JdlBlobValidators__MinbytesAssignment_1 )? )
            // InternalJDL.g:2312:2: ( rule__JdlBlobValidators__MinbytesAssignment_1 )?
            {
             before(grammarAccess.getJdlBlobValidatorsAccess().getMinbytesAssignment_1()); 
            // InternalJDL.g:2313:2: ( rule__JdlBlobValidators__MinbytesAssignment_1 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==39) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalJDL.g:2313:3: rule__JdlBlobValidators__MinbytesAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__JdlBlobValidators__MinbytesAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getJdlBlobValidatorsAccess().getMinbytesAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlBlobValidators__Group__1__Impl"


    // $ANTLR start "rule__JdlBlobValidators__Group__2"
    // InternalJDL.g:2321:1: rule__JdlBlobValidators__Group__2 : rule__JdlBlobValidators__Group__2__Impl ;
    public final void rule__JdlBlobValidators__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2325:1: ( rule__JdlBlobValidators__Group__2__Impl )
            // InternalJDL.g:2326:2: rule__JdlBlobValidators__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JdlBlobValidators__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlBlobValidators__Group__2"


    // $ANTLR start "rule__JdlBlobValidators__Group__2__Impl"
    // InternalJDL.g:2332:1: rule__JdlBlobValidators__Group__2__Impl : ( ( rule__JdlBlobValidators__MaxbytesAssignment_2 )? ) ;
    public final void rule__JdlBlobValidators__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2336:1: ( ( ( rule__JdlBlobValidators__MaxbytesAssignment_2 )? ) )
            // InternalJDL.g:2337:1: ( ( rule__JdlBlobValidators__MaxbytesAssignment_2 )? )
            {
            // InternalJDL.g:2337:1: ( ( rule__JdlBlobValidators__MaxbytesAssignment_2 )? )
            // InternalJDL.g:2338:2: ( rule__JdlBlobValidators__MaxbytesAssignment_2 )?
            {
             before(grammarAccess.getJdlBlobValidatorsAccess().getMaxbytesAssignment_2()); 
            // InternalJDL.g:2339:2: ( rule__JdlBlobValidators__MaxbytesAssignment_2 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==40) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalJDL.g:2339:3: rule__JdlBlobValidators__MaxbytesAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__JdlBlobValidators__MaxbytesAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getJdlBlobValidatorsAccess().getMaxbytesAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlBlobValidators__Group__2__Impl"


    // $ANTLR start "rule__JdlMinLengthValidator__Group__0"
    // InternalJDL.g:2348:1: rule__JdlMinLengthValidator__Group__0 : rule__JdlMinLengthValidator__Group__0__Impl rule__JdlMinLengthValidator__Group__1 ;
    public final void rule__JdlMinLengthValidator__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2352:1: ( rule__JdlMinLengthValidator__Group__0__Impl rule__JdlMinLengthValidator__Group__1 )
            // InternalJDL.g:2353:2: rule__JdlMinLengthValidator__Group__0__Impl rule__JdlMinLengthValidator__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__JdlMinLengthValidator__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlMinLengthValidator__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMinLengthValidator__Group__0"


    // $ANTLR start "rule__JdlMinLengthValidator__Group__0__Impl"
    // InternalJDL.g:2360:1: rule__JdlMinLengthValidator__Group__0__Impl : ( 'minlength' ) ;
    public final void rule__JdlMinLengthValidator__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2364:1: ( ( 'minlength' ) )
            // InternalJDL.g:2365:1: ( 'minlength' )
            {
            // InternalJDL.g:2365:1: ( 'minlength' )
            // InternalJDL.g:2366:2: 'minlength'
            {
             before(grammarAccess.getJdlMinLengthValidatorAccess().getMinlengthKeyword_0()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getJdlMinLengthValidatorAccess().getMinlengthKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMinLengthValidator__Group__0__Impl"


    // $ANTLR start "rule__JdlMinLengthValidator__Group__1"
    // InternalJDL.g:2375:1: rule__JdlMinLengthValidator__Group__1 : rule__JdlMinLengthValidator__Group__1__Impl rule__JdlMinLengthValidator__Group__2 ;
    public final void rule__JdlMinLengthValidator__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2379:1: ( rule__JdlMinLengthValidator__Group__1__Impl rule__JdlMinLengthValidator__Group__2 )
            // InternalJDL.g:2380:2: rule__JdlMinLengthValidator__Group__1__Impl rule__JdlMinLengthValidator__Group__2
            {
            pushFollow(FOLLOW_15);
            rule__JdlMinLengthValidator__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlMinLengthValidator__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMinLengthValidator__Group__1"


    // $ANTLR start "rule__JdlMinLengthValidator__Group__1__Impl"
    // InternalJDL.g:2387:1: rule__JdlMinLengthValidator__Group__1__Impl : ( '(' ) ;
    public final void rule__JdlMinLengthValidator__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2391:1: ( ( '(' ) )
            // InternalJDL.g:2392:1: ( '(' )
            {
            // InternalJDL.g:2392:1: ( '(' )
            // InternalJDL.g:2393:2: '('
            {
             before(grammarAccess.getJdlMinLengthValidatorAccess().getLeftParenthesisKeyword_1()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getJdlMinLengthValidatorAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMinLengthValidator__Group__1__Impl"


    // $ANTLR start "rule__JdlMinLengthValidator__Group__2"
    // InternalJDL.g:2402:1: rule__JdlMinLengthValidator__Group__2 : rule__JdlMinLengthValidator__Group__2__Impl rule__JdlMinLengthValidator__Group__3 ;
    public final void rule__JdlMinLengthValidator__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2406:1: ( rule__JdlMinLengthValidator__Group__2__Impl rule__JdlMinLengthValidator__Group__3 )
            // InternalJDL.g:2407:2: rule__JdlMinLengthValidator__Group__2__Impl rule__JdlMinLengthValidator__Group__3
            {
            pushFollow(FOLLOW_16);
            rule__JdlMinLengthValidator__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlMinLengthValidator__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMinLengthValidator__Group__2"


    // $ANTLR start "rule__JdlMinLengthValidator__Group__2__Impl"
    // InternalJDL.g:2414:1: rule__JdlMinLengthValidator__Group__2__Impl : ( ( rule__JdlMinLengthValidator__ValueAssignment_2 ) ) ;
    public final void rule__JdlMinLengthValidator__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2418:1: ( ( ( rule__JdlMinLengthValidator__ValueAssignment_2 ) ) )
            // InternalJDL.g:2419:1: ( ( rule__JdlMinLengthValidator__ValueAssignment_2 ) )
            {
            // InternalJDL.g:2419:1: ( ( rule__JdlMinLengthValidator__ValueAssignment_2 ) )
            // InternalJDL.g:2420:2: ( rule__JdlMinLengthValidator__ValueAssignment_2 )
            {
             before(grammarAccess.getJdlMinLengthValidatorAccess().getValueAssignment_2()); 
            // InternalJDL.g:2421:2: ( rule__JdlMinLengthValidator__ValueAssignment_2 )
            // InternalJDL.g:2421:3: rule__JdlMinLengthValidator__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__JdlMinLengthValidator__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getJdlMinLengthValidatorAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMinLengthValidator__Group__2__Impl"


    // $ANTLR start "rule__JdlMinLengthValidator__Group__3"
    // InternalJDL.g:2429:1: rule__JdlMinLengthValidator__Group__3 : rule__JdlMinLengthValidator__Group__3__Impl ;
    public final void rule__JdlMinLengthValidator__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2433:1: ( rule__JdlMinLengthValidator__Group__3__Impl )
            // InternalJDL.g:2434:2: rule__JdlMinLengthValidator__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JdlMinLengthValidator__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMinLengthValidator__Group__3"


    // $ANTLR start "rule__JdlMinLengthValidator__Group__3__Impl"
    // InternalJDL.g:2440:1: rule__JdlMinLengthValidator__Group__3__Impl : ( ')' ) ;
    public final void rule__JdlMinLengthValidator__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2444:1: ( ( ')' ) )
            // InternalJDL.g:2445:1: ( ')' )
            {
            // InternalJDL.g:2445:1: ( ')' )
            // InternalJDL.g:2446:2: ')'
            {
             before(grammarAccess.getJdlMinLengthValidatorAccess().getRightParenthesisKeyword_3()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getJdlMinLengthValidatorAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMinLengthValidator__Group__3__Impl"


    // $ANTLR start "rule__JdlMaxLengthValidator__Group__0"
    // InternalJDL.g:2456:1: rule__JdlMaxLengthValidator__Group__0 : rule__JdlMaxLengthValidator__Group__0__Impl rule__JdlMaxLengthValidator__Group__1 ;
    public final void rule__JdlMaxLengthValidator__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2460:1: ( rule__JdlMaxLengthValidator__Group__0__Impl rule__JdlMaxLengthValidator__Group__1 )
            // InternalJDL.g:2461:2: rule__JdlMaxLengthValidator__Group__0__Impl rule__JdlMaxLengthValidator__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__JdlMaxLengthValidator__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlMaxLengthValidator__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMaxLengthValidator__Group__0"


    // $ANTLR start "rule__JdlMaxLengthValidator__Group__0__Impl"
    // InternalJDL.g:2468:1: rule__JdlMaxLengthValidator__Group__0__Impl : ( 'maxlength' ) ;
    public final void rule__JdlMaxLengthValidator__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2472:1: ( ( 'maxlength' ) )
            // InternalJDL.g:2473:1: ( 'maxlength' )
            {
            // InternalJDL.g:2473:1: ( 'maxlength' )
            // InternalJDL.g:2474:2: 'maxlength'
            {
             before(grammarAccess.getJdlMaxLengthValidatorAccess().getMaxlengthKeyword_0()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getJdlMaxLengthValidatorAccess().getMaxlengthKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMaxLengthValidator__Group__0__Impl"


    // $ANTLR start "rule__JdlMaxLengthValidator__Group__1"
    // InternalJDL.g:2483:1: rule__JdlMaxLengthValidator__Group__1 : rule__JdlMaxLengthValidator__Group__1__Impl rule__JdlMaxLengthValidator__Group__2 ;
    public final void rule__JdlMaxLengthValidator__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2487:1: ( rule__JdlMaxLengthValidator__Group__1__Impl rule__JdlMaxLengthValidator__Group__2 )
            // InternalJDL.g:2488:2: rule__JdlMaxLengthValidator__Group__1__Impl rule__JdlMaxLengthValidator__Group__2
            {
            pushFollow(FOLLOW_15);
            rule__JdlMaxLengthValidator__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlMaxLengthValidator__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMaxLengthValidator__Group__1"


    // $ANTLR start "rule__JdlMaxLengthValidator__Group__1__Impl"
    // InternalJDL.g:2495:1: rule__JdlMaxLengthValidator__Group__1__Impl : ( '(' ) ;
    public final void rule__JdlMaxLengthValidator__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2499:1: ( ( '(' ) )
            // InternalJDL.g:2500:1: ( '(' )
            {
            // InternalJDL.g:2500:1: ( '(' )
            // InternalJDL.g:2501:2: '('
            {
             before(grammarAccess.getJdlMaxLengthValidatorAccess().getLeftParenthesisKeyword_1()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getJdlMaxLengthValidatorAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMaxLengthValidator__Group__1__Impl"


    // $ANTLR start "rule__JdlMaxLengthValidator__Group__2"
    // InternalJDL.g:2510:1: rule__JdlMaxLengthValidator__Group__2 : rule__JdlMaxLengthValidator__Group__2__Impl rule__JdlMaxLengthValidator__Group__3 ;
    public final void rule__JdlMaxLengthValidator__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2514:1: ( rule__JdlMaxLengthValidator__Group__2__Impl rule__JdlMaxLengthValidator__Group__3 )
            // InternalJDL.g:2515:2: rule__JdlMaxLengthValidator__Group__2__Impl rule__JdlMaxLengthValidator__Group__3
            {
            pushFollow(FOLLOW_16);
            rule__JdlMaxLengthValidator__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlMaxLengthValidator__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMaxLengthValidator__Group__2"


    // $ANTLR start "rule__JdlMaxLengthValidator__Group__2__Impl"
    // InternalJDL.g:2522:1: rule__JdlMaxLengthValidator__Group__2__Impl : ( ( rule__JdlMaxLengthValidator__ValueAssignment_2 ) ) ;
    public final void rule__JdlMaxLengthValidator__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2526:1: ( ( ( rule__JdlMaxLengthValidator__ValueAssignment_2 ) ) )
            // InternalJDL.g:2527:1: ( ( rule__JdlMaxLengthValidator__ValueAssignment_2 ) )
            {
            // InternalJDL.g:2527:1: ( ( rule__JdlMaxLengthValidator__ValueAssignment_2 ) )
            // InternalJDL.g:2528:2: ( rule__JdlMaxLengthValidator__ValueAssignment_2 )
            {
             before(grammarAccess.getJdlMaxLengthValidatorAccess().getValueAssignment_2()); 
            // InternalJDL.g:2529:2: ( rule__JdlMaxLengthValidator__ValueAssignment_2 )
            // InternalJDL.g:2529:3: rule__JdlMaxLengthValidator__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__JdlMaxLengthValidator__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getJdlMaxLengthValidatorAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMaxLengthValidator__Group__2__Impl"


    // $ANTLR start "rule__JdlMaxLengthValidator__Group__3"
    // InternalJDL.g:2537:1: rule__JdlMaxLengthValidator__Group__3 : rule__JdlMaxLengthValidator__Group__3__Impl ;
    public final void rule__JdlMaxLengthValidator__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2541:1: ( rule__JdlMaxLengthValidator__Group__3__Impl )
            // InternalJDL.g:2542:2: rule__JdlMaxLengthValidator__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JdlMaxLengthValidator__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMaxLengthValidator__Group__3"


    // $ANTLR start "rule__JdlMaxLengthValidator__Group__3__Impl"
    // InternalJDL.g:2548:1: rule__JdlMaxLengthValidator__Group__3__Impl : ( ')' ) ;
    public final void rule__JdlMaxLengthValidator__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2552:1: ( ( ')' ) )
            // InternalJDL.g:2553:1: ( ')' )
            {
            // InternalJDL.g:2553:1: ( ')' )
            // InternalJDL.g:2554:2: ')'
            {
             before(grammarAccess.getJdlMaxLengthValidatorAccess().getRightParenthesisKeyword_3()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getJdlMaxLengthValidatorAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMaxLengthValidator__Group__3__Impl"


    // $ANTLR start "rule__JdlPatternValidator__Group__0"
    // InternalJDL.g:2564:1: rule__JdlPatternValidator__Group__0 : rule__JdlPatternValidator__Group__0__Impl rule__JdlPatternValidator__Group__1 ;
    public final void rule__JdlPatternValidator__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2568:1: ( rule__JdlPatternValidator__Group__0__Impl rule__JdlPatternValidator__Group__1 )
            // InternalJDL.g:2569:2: rule__JdlPatternValidator__Group__0__Impl rule__JdlPatternValidator__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__JdlPatternValidator__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlPatternValidator__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlPatternValidator__Group__0"


    // $ANTLR start "rule__JdlPatternValidator__Group__0__Impl"
    // InternalJDL.g:2576:1: rule__JdlPatternValidator__Group__0__Impl : ( 'pattern' ) ;
    public final void rule__JdlPatternValidator__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2580:1: ( ( 'pattern' ) )
            // InternalJDL.g:2581:1: ( 'pattern' )
            {
            // InternalJDL.g:2581:1: ( 'pattern' )
            // InternalJDL.g:2582:2: 'pattern'
            {
             before(grammarAccess.getJdlPatternValidatorAccess().getPatternKeyword_0()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getJdlPatternValidatorAccess().getPatternKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlPatternValidator__Group__0__Impl"


    // $ANTLR start "rule__JdlPatternValidator__Group__1"
    // InternalJDL.g:2591:1: rule__JdlPatternValidator__Group__1 : rule__JdlPatternValidator__Group__1__Impl rule__JdlPatternValidator__Group__2 ;
    public final void rule__JdlPatternValidator__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2595:1: ( rule__JdlPatternValidator__Group__1__Impl rule__JdlPatternValidator__Group__2 )
            // InternalJDL.g:2596:2: rule__JdlPatternValidator__Group__1__Impl rule__JdlPatternValidator__Group__2
            {
            pushFollow(FOLLOW_17);
            rule__JdlPatternValidator__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlPatternValidator__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlPatternValidator__Group__1"


    // $ANTLR start "rule__JdlPatternValidator__Group__1__Impl"
    // InternalJDL.g:2603:1: rule__JdlPatternValidator__Group__1__Impl : ( '(' ) ;
    public final void rule__JdlPatternValidator__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2607:1: ( ( '(' ) )
            // InternalJDL.g:2608:1: ( '(' )
            {
            // InternalJDL.g:2608:1: ( '(' )
            // InternalJDL.g:2609:2: '('
            {
             before(grammarAccess.getJdlPatternValidatorAccess().getLeftParenthesisKeyword_1()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getJdlPatternValidatorAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlPatternValidator__Group__1__Impl"


    // $ANTLR start "rule__JdlPatternValidator__Group__2"
    // InternalJDL.g:2618:1: rule__JdlPatternValidator__Group__2 : rule__JdlPatternValidator__Group__2__Impl rule__JdlPatternValidator__Group__3 ;
    public final void rule__JdlPatternValidator__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2622:1: ( rule__JdlPatternValidator__Group__2__Impl rule__JdlPatternValidator__Group__3 )
            // InternalJDL.g:2623:2: rule__JdlPatternValidator__Group__2__Impl rule__JdlPatternValidator__Group__3
            {
            pushFollow(FOLLOW_16);
            rule__JdlPatternValidator__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlPatternValidator__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlPatternValidator__Group__2"


    // $ANTLR start "rule__JdlPatternValidator__Group__2__Impl"
    // InternalJDL.g:2630:1: rule__JdlPatternValidator__Group__2__Impl : ( ( rule__JdlPatternValidator__ValueAssignment_2 ) ) ;
    public final void rule__JdlPatternValidator__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2634:1: ( ( ( rule__JdlPatternValidator__ValueAssignment_2 ) ) )
            // InternalJDL.g:2635:1: ( ( rule__JdlPatternValidator__ValueAssignment_2 ) )
            {
            // InternalJDL.g:2635:1: ( ( rule__JdlPatternValidator__ValueAssignment_2 ) )
            // InternalJDL.g:2636:2: ( rule__JdlPatternValidator__ValueAssignment_2 )
            {
             before(grammarAccess.getJdlPatternValidatorAccess().getValueAssignment_2()); 
            // InternalJDL.g:2637:2: ( rule__JdlPatternValidator__ValueAssignment_2 )
            // InternalJDL.g:2637:3: rule__JdlPatternValidator__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__JdlPatternValidator__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getJdlPatternValidatorAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlPatternValidator__Group__2__Impl"


    // $ANTLR start "rule__JdlPatternValidator__Group__3"
    // InternalJDL.g:2645:1: rule__JdlPatternValidator__Group__3 : rule__JdlPatternValidator__Group__3__Impl ;
    public final void rule__JdlPatternValidator__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2649:1: ( rule__JdlPatternValidator__Group__3__Impl )
            // InternalJDL.g:2650:2: rule__JdlPatternValidator__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JdlPatternValidator__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlPatternValidator__Group__3"


    // $ANTLR start "rule__JdlPatternValidator__Group__3__Impl"
    // InternalJDL.g:2656:1: rule__JdlPatternValidator__Group__3__Impl : ( ')' ) ;
    public final void rule__JdlPatternValidator__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2660:1: ( ( ')' ) )
            // InternalJDL.g:2661:1: ( ')' )
            {
            // InternalJDL.g:2661:1: ( ')' )
            // InternalJDL.g:2662:2: ')'
            {
             before(grammarAccess.getJdlPatternValidatorAccess().getRightParenthesisKeyword_3()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getJdlPatternValidatorAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlPatternValidator__Group__3__Impl"


    // $ANTLR start "rule__JdlMinValidator__Group__0"
    // InternalJDL.g:2672:1: rule__JdlMinValidator__Group__0 : rule__JdlMinValidator__Group__0__Impl rule__JdlMinValidator__Group__1 ;
    public final void rule__JdlMinValidator__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2676:1: ( rule__JdlMinValidator__Group__0__Impl rule__JdlMinValidator__Group__1 )
            // InternalJDL.g:2677:2: rule__JdlMinValidator__Group__0__Impl rule__JdlMinValidator__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__JdlMinValidator__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlMinValidator__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMinValidator__Group__0"


    // $ANTLR start "rule__JdlMinValidator__Group__0__Impl"
    // InternalJDL.g:2684:1: rule__JdlMinValidator__Group__0__Impl : ( 'min' ) ;
    public final void rule__JdlMinValidator__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2688:1: ( ( 'min' ) )
            // InternalJDL.g:2689:1: ( 'min' )
            {
            // InternalJDL.g:2689:1: ( 'min' )
            // InternalJDL.g:2690:2: 'min'
            {
             before(grammarAccess.getJdlMinValidatorAccess().getMinKeyword_0()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getJdlMinValidatorAccess().getMinKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMinValidator__Group__0__Impl"


    // $ANTLR start "rule__JdlMinValidator__Group__1"
    // InternalJDL.g:2699:1: rule__JdlMinValidator__Group__1 : rule__JdlMinValidator__Group__1__Impl rule__JdlMinValidator__Group__2 ;
    public final void rule__JdlMinValidator__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2703:1: ( rule__JdlMinValidator__Group__1__Impl rule__JdlMinValidator__Group__2 )
            // InternalJDL.g:2704:2: rule__JdlMinValidator__Group__1__Impl rule__JdlMinValidator__Group__2
            {
            pushFollow(FOLLOW_15);
            rule__JdlMinValidator__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlMinValidator__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMinValidator__Group__1"


    // $ANTLR start "rule__JdlMinValidator__Group__1__Impl"
    // InternalJDL.g:2711:1: rule__JdlMinValidator__Group__1__Impl : ( '(' ) ;
    public final void rule__JdlMinValidator__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2715:1: ( ( '(' ) )
            // InternalJDL.g:2716:1: ( '(' )
            {
            // InternalJDL.g:2716:1: ( '(' )
            // InternalJDL.g:2717:2: '('
            {
             before(grammarAccess.getJdlMinValidatorAccess().getLeftParenthesisKeyword_1()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getJdlMinValidatorAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMinValidator__Group__1__Impl"


    // $ANTLR start "rule__JdlMinValidator__Group__2"
    // InternalJDL.g:2726:1: rule__JdlMinValidator__Group__2 : rule__JdlMinValidator__Group__2__Impl rule__JdlMinValidator__Group__3 ;
    public final void rule__JdlMinValidator__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2730:1: ( rule__JdlMinValidator__Group__2__Impl rule__JdlMinValidator__Group__3 )
            // InternalJDL.g:2731:2: rule__JdlMinValidator__Group__2__Impl rule__JdlMinValidator__Group__3
            {
            pushFollow(FOLLOW_16);
            rule__JdlMinValidator__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlMinValidator__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMinValidator__Group__2"


    // $ANTLR start "rule__JdlMinValidator__Group__2__Impl"
    // InternalJDL.g:2738:1: rule__JdlMinValidator__Group__2__Impl : ( ( rule__JdlMinValidator__ValueAssignment_2 ) ) ;
    public final void rule__JdlMinValidator__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2742:1: ( ( ( rule__JdlMinValidator__ValueAssignment_2 ) ) )
            // InternalJDL.g:2743:1: ( ( rule__JdlMinValidator__ValueAssignment_2 ) )
            {
            // InternalJDL.g:2743:1: ( ( rule__JdlMinValidator__ValueAssignment_2 ) )
            // InternalJDL.g:2744:2: ( rule__JdlMinValidator__ValueAssignment_2 )
            {
             before(grammarAccess.getJdlMinValidatorAccess().getValueAssignment_2()); 
            // InternalJDL.g:2745:2: ( rule__JdlMinValidator__ValueAssignment_2 )
            // InternalJDL.g:2745:3: rule__JdlMinValidator__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__JdlMinValidator__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getJdlMinValidatorAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMinValidator__Group__2__Impl"


    // $ANTLR start "rule__JdlMinValidator__Group__3"
    // InternalJDL.g:2753:1: rule__JdlMinValidator__Group__3 : rule__JdlMinValidator__Group__3__Impl ;
    public final void rule__JdlMinValidator__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2757:1: ( rule__JdlMinValidator__Group__3__Impl )
            // InternalJDL.g:2758:2: rule__JdlMinValidator__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JdlMinValidator__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMinValidator__Group__3"


    // $ANTLR start "rule__JdlMinValidator__Group__3__Impl"
    // InternalJDL.g:2764:1: rule__JdlMinValidator__Group__3__Impl : ( ')' ) ;
    public final void rule__JdlMinValidator__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2768:1: ( ( ')' ) )
            // InternalJDL.g:2769:1: ( ')' )
            {
            // InternalJDL.g:2769:1: ( ')' )
            // InternalJDL.g:2770:2: ')'
            {
             before(grammarAccess.getJdlMinValidatorAccess().getRightParenthesisKeyword_3()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getJdlMinValidatorAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMinValidator__Group__3__Impl"


    // $ANTLR start "rule__JdlMaxValidator__Group__0"
    // InternalJDL.g:2780:1: rule__JdlMaxValidator__Group__0 : rule__JdlMaxValidator__Group__0__Impl rule__JdlMaxValidator__Group__1 ;
    public final void rule__JdlMaxValidator__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2784:1: ( rule__JdlMaxValidator__Group__0__Impl rule__JdlMaxValidator__Group__1 )
            // InternalJDL.g:2785:2: rule__JdlMaxValidator__Group__0__Impl rule__JdlMaxValidator__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__JdlMaxValidator__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlMaxValidator__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMaxValidator__Group__0"


    // $ANTLR start "rule__JdlMaxValidator__Group__0__Impl"
    // InternalJDL.g:2792:1: rule__JdlMaxValidator__Group__0__Impl : ( 'max' ) ;
    public final void rule__JdlMaxValidator__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2796:1: ( ( 'max' ) )
            // InternalJDL.g:2797:1: ( 'max' )
            {
            // InternalJDL.g:2797:1: ( 'max' )
            // InternalJDL.g:2798:2: 'max'
            {
             before(grammarAccess.getJdlMaxValidatorAccess().getMaxKeyword_0()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getJdlMaxValidatorAccess().getMaxKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMaxValidator__Group__0__Impl"


    // $ANTLR start "rule__JdlMaxValidator__Group__1"
    // InternalJDL.g:2807:1: rule__JdlMaxValidator__Group__1 : rule__JdlMaxValidator__Group__1__Impl rule__JdlMaxValidator__Group__2 ;
    public final void rule__JdlMaxValidator__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2811:1: ( rule__JdlMaxValidator__Group__1__Impl rule__JdlMaxValidator__Group__2 )
            // InternalJDL.g:2812:2: rule__JdlMaxValidator__Group__1__Impl rule__JdlMaxValidator__Group__2
            {
            pushFollow(FOLLOW_15);
            rule__JdlMaxValidator__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlMaxValidator__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMaxValidator__Group__1"


    // $ANTLR start "rule__JdlMaxValidator__Group__1__Impl"
    // InternalJDL.g:2819:1: rule__JdlMaxValidator__Group__1__Impl : ( '(' ) ;
    public final void rule__JdlMaxValidator__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2823:1: ( ( '(' ) )
            // InternalJDL.g:2824:1: ( '(' )
            {
            // InternalJDL.g:2824:1: ( '(' )
            // InternalJDL.g:2825:2: '('
            {
             before(grammarAccess.getJdlMaxValidatorAccess().getLeftParenthesisKeyword_1()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getJdlMaxValidatorAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMaxValidator__Group__1__Impl"


    // $ANTLR start "rule__JdlMaxValidator__Group__2"
    // InternalJDL.g:2834:1: rule__JdlMaxValidator__Group__2 : rule__JdlMaxValidator__Group__2__Impl rule__JdlMaxValidator__Group__3 ;
    public final void rule__JdlMaxValidator__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2838:1: ( rule__JdlMaxValidator__Group__2__Impl rule__JdlMaxValidator__Group__3 )
            // InternalJDL.g:2839:2: rule__JdlMaxValidator__Group__2__Impl rule__JdlMaxValidator__Group__3
            {
            pushFollow(FOLLOW_16);
            rule__JdlMaxValidator__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlMaxValidator__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMaxValidator__Group__2"


    // $ANTLR start "rule__JdlMaxValidator__Group__2__Impl"
    // InternalJDL.g:2846:1: rule__JdlMaxValidator__Group__2__Impl : ( ( rule__JdlMaxValidator__ValueAssignment_2 ) ) ;
    public final void rule__JdlMaxValidator__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2850:1: ( ( ( rule__JdlMaxValidator__ValueAssignment_2 ) ) )
            // InternalJDL.g:2851:1: ( ( rule__JdlMaxValidator__ValueAssignment_2 ) )
            {
            // InternalJDL.g:2851:1: ( ( rule__JdlMaxValidator__ValueAssignment_2 ) )
            // InternalJDL.g:2852:2: ( rule__JdlMaxValidator__ValueAssignment_2 )
            {
             before(grammarAccess.getJdlMaxValidatorAccess().getValueAssignment_2()); 
            // InternalJDL.g:2853:2: ( rule__JdlMaxValidator__ValueAssignment_2 )
            // InternalJDL.g:2853:3: rule__JdlMaxValidator__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__JdlMaxValidator__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getJdlMaxValidatorAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMaxValidator__Group__2__Impl"


    // $ANTLR start "rule__JdlMaxValidator__Group__3"
    // InternalJDL.g:2861:1: rule__JdlMaxValidator__Group__3 : rule__JdlMaxValidator__Group__3__Impl ;
    public final void rule__JdlMaxValidator__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2865:1: ( rule__JdlMaxValidator__Group__3__Impl )
            // InternalJDL.g:2866:2: rule__JdlMaxValidator__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JdlMaxValidator__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMaxValidator__Group__3"


    // $ANTLR start "rule__JdlMaxValidator__Group__3__Impl"
    // InternalJDL.g:2872:1: rule__JdlMaxValidator__Group__3__Impl : ( ')' ) ;
    public final void rule__JdlMaxValidator__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2876:1: ( ( ')' ) )
            // InternalJDL.g:2877:1: ( ')' )
            {
            // InternalJDL.g:2877:1: ( ')' )
            // InternalJDL.g:2878:2: ')'
            {
             before(grammarAccess.getJdlMaxValidatorAccess().getRightParenthesisKeyword_3()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getJdlMaxValidatorAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMaxValidator__Group__3__Impl"


    // $ANTLR start "rule__JdlMinBytesValidator__Group__0"
    // InternalJDL.g:2888:1: rule__JdlMinBytesValidator__Group__0 : rule__JdlMinBytesValidator__Group__0__Impl rule__JdlMinBytesValidator__Group__1 ;
    public final void rule__JdlMinBytesValidator__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2892:1: ( rule__JdlMinBytesValidator__Group__0__Impl rule__JdlMinBytesValidator__Group__1 )
            // InternalJDL.g:2893:2: rule__JdlMinBytesValidator__Group__0__Impl rule__JdlMinBytesValidator__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__JdlMinBytesValidator__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlMinBytesValidator__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMinBytesValidator__Group__0"


    // $ANTLR start "rule__JdlMinBytesValidator__Group__0__Impl"
    // InternalJDL.g:2900:1: rule__JdlMinBytesValidator__Group__0__Impl : ( 'minbytes' ) ;
    public final void rule__JdlMinBytesValidator__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2904:1: ( ( 'minbytes' ) )
            // InternalJDL.g:2905:1: ( 'minbytes' )
            {
            // InternalJDL.g:2905:1: ( 'minbytes' )
            // InternalJDL.g:2906:2: 'minbytes'
            {
             before(grammarAccess.getJdlMinBytesValidatorAccess().getMinbytesKeyword_0()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getJdlMinBytesValidatorAccess().getMinbytesKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMinBytesValidator__Group__0__Impl"


    // $ANTLR start "rule__JdlMinBytesValidator__Group__1"
    // InternalJDL.g:2915:1: rule__JdlMinBytesValidator__Group__1 : rule__JdlMinBytesValidator__Group__1__Impl rule__JdlMinBytesValidator__Group__2 ;
    public final void rule__JdlMinBytesValidator__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2919:1: ( rule__JdlMinBytesValidator__Group__1__Impl rule__JdlMinBytesValidator__Group__2 )
            // InternalJDL.g:2920:2: rule__JdlMinBytesValidator__Group__1__Impl rule__JdlMinBytesValidator__Group__2
            {
            pushFollow(FOLLOW_15);
            rule__JdlMinBytesValidator__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlMinBytesValidator__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMinBytesValidator__Group__1"


    // $ANTLR start "rule__JdlMinBytesValidator__Group__1__Impl"
    // InternalJDL.g:2927:1: rule__JdlMinBytesValidator__Group__1__Impl : ( '(' ) ;
    public final void rule__JdlMinBytesValidator__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2931:1: ( ( '(' ) )
            // InternalJDL.g:2932:1: ( '(' )
            {
            // InternalJDL.g:2932:1: ( '(' )
            // InternalJDL.g:2933:2: '('
            {
             before(grammarAccess.getJdlMinBytesValidatorAccess().getLeftParenthesisKeyword_1()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getJdlMinBytesValidatorAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMinBytesValidator__Group__1__Impl"


    // $ANTLR start "rule__JdlMinBytesValidator__Group__2"
    // InternalJDL.g:2942:1: rule__JdlMinBytesValidator__Group__2 : rule__JdlMinBytesValidator__Group__2__Impl rule__JdlMinBytesValidator__Group__3 ;
    public final void rule__JdlMinBytesValidator__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2946:1: ( rule__JdlMinBytesValidator__Group__2__Impl rule__JdlMinBytesValidator__Group__3 )
            // InternalJDL.g:2947:2: rule__JdlMinBytesValidator__Group__2__Impl rule__JdlMinBytesValidator__Group__3
            {
            pushFollow(FOLLOW_16);
            rule__JdlMinBytesValidator__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlMinBytesValidator__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMinBytesValidator__Group__2"


    // $ANTLR start "rule__JdlMinBytesValidator__Group__2__Impl"
    // InternalJDL.g:2954:1: rule__JdlMinBytesValidator__Group__2__Impl : ( ( rule__JdlMinBytesValidator__ValueAssignment_2 ) ) ;
    public final void rule__JdlMinBytesValidator__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2958:1: ( ( ( rule__JdlMinBytesValidator__ValueAssignment_2 ) ) )
            // InternalJDL.g:2959:1: ( ( rule__JdlMinBytesValidator__ValueAssignment_2 ) )
            {
            // InternalJDL.g:2959:1: ( ( rule__JdlMinBytesValidator__ValueAssignment_2 ) )
            // InternalJDL.g:2960:2: ( rule__JdlMinBytesValidator__ValueAssignment_2 )
            {
             before(grammarAccess.getJdlMinBytesValidatorAccess().getValueAssignment_2()); 
            // InternalJDL.g:2961:2: ( rule__JdlMinBytesValidator__ValueAssignment_2 )
            // InternalJDL.g:2961:3: rule__JdlMinBytesValidator__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__JdlMinBytesValidator__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getJdlMinBytesValidatorAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMinBytesValidator__Group__2__Impl"


    // $ANTLR start "rule__JdlMinBytesValidator__Group__3"
    // InternalJDL.g:2969:1: rule__JdlMinBytesValidator__Group__3 : rule__JdlMinBytesValidator__Group__3__Impl ;
    public final void rule__JdlMinBytesValidator__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2973:1: ( rule__JdlMinBytesValidator__Group__3__Impl )
            // InternalJDL.g:2974:2: rule__JdlMinBytesValidator__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JdlMinBytesValidator__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMinBytesValidator__Group__3"


    // $ANTLR start "rule__JdlMinBytesValidator__Group__3__Impl"
    // InternalJDL.g:2980:1: rule__JdlMinBytesValidator__Group__3__Impl : ( ')' ) ;
    public final void rule__JdlMinBytesValidator__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:2984:1: ( ( ')' ) )
            // InternalJDL.g:2985:1: ( ')' )
            {
            // InternalJDL.g:2985:1: ( ')' )
            // InternalJDL.g:2986:2: ')'
            {
             before(grammarAccess.getJdlMinBytesValidatorAccess().getRightParenthesisKeyword_3()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getJdlMinBytesValidatorAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMinBytesValidator__Group__3__Impl"


    // $ANTLR start "rule__JdlMaxBytesValidator__Group__0"
    // InternalJDL.g:2996:1: rule__JdlMaxBytesValidator__Group__0 : rule__JdlMaxBytesValidator__Group__0__Impl rule__JdlMaxBytesValidator__Group__1 ;
    public final void rule__JdlMaxBytesValidator__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3000:1: ( rule__JdlMaxBytesValidator__Group__0__Impl rule__JdlMaxBytesValidator__Group__1 )
            // InternalJDL.g:3001:2: rule__JdlMaxBytesValidator__Group__0__Impl rule__JdlMaxBytesValidator__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__JdlMaxBytesValidator__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlMaxBytesValidator__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMaxBytesValidator__Group__0"


    // $ANTLR start "rule__JdlMaxBytesValidator__Group__0__Impl"
    // InternalJDL.g:3008:1: rule__JdlMaxBytesValidator__Group__0__Impl : ( 'maxbytes' ) ;
    public final void rule__JdlMaxBytesValidator__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3012:1: ( ( 'maxbytes' ) )
            // InternalJDL.g:3013:1: ( 'maxbytes' )
            {
            // InternalJDL.g:3013:1: ( 'maxbytes' )
            // InternalJDL.g:3014:2: 'maxbytes'
            {
             before(grammarAccess.getJdlMaxBytesValidatorAccess().getMaxbytesKeyword_0()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getJdlMaxBytesValidatorAccess().getMaxbytesKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMaxBytesValidator__Group__0__Impl"


    // $ANTLR start "rule__JdlMaxBytesValidator__Group__1"
    // InternalJDL.g:3023:1: rule__JdlMaxBytesValidator__Group__1 : rule__JdlMaxBytesValidator__Group__1__Impl rule__JdlMaxBytesValidator__Group__2 ;
    public final void rule__JdlMaxBytesValidator__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3027:1: ( rule__JdlMaxBytesValidator__Group__1__Impl rule__JdlMaxBytesValidator__Group__2 )
            // InternalJDL.g:3028:2: rule__JdlMaxBytesValidator__Group__1__Impl rule__JdlMaxBytesValidator__Group__2
            {
            pushFollow(FOLLOW_15);
            rule__JdlMaxBytesValidator__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlMaxBytesValidator__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMaxBytesValidator__Group__1"


    // $ANTLR start "rule__JdlMaxBytesValidator__Group__1__Impl"
    // InternalJDL.g:3035:1: rule__JdlMaxBytesValidator__Group__1__Impl : ( '(' ) ;
    public final void rule__JdlMaxBytesValidator__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3039:1: ( ( '(' ) )
            // InternalJDL.g:3040:1: ( '(' )
            {
            // InternalJDL.g:3040:1: ( '(' )
            // InternalJDL.g:3041:2: '('
            {
             before(grammarAccess.getJdlMaxBytesValidatorAccess().getLeftParenthesisKeyword_1()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getJdlMaxBytesValidatorAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMaxBytesValidator__Group__1__Impl"


    // $ANTLR start "rule__JdlMaxBytesValidator__Group__2"
    // InternalJDL.g:3050:1: rule__JdlMaxBytesValidator__Group__2 : rule__JdlMaxBytesValidator__Group__2__Impl rule__JdlMaxBytesValidator__Group__3 ;
    public final void rule__JdlMaxBytesValidator__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3054:1: ( rule__JdlMaxBytesValidator__Group__2__Impl rule__JdlMaxBytesValidator__Group__3 )
            // InternalJDL.g:3055:2: rule__JdlMaxBytesValidator__Group__2__Impl rule__JdlMaxBytesValidator__Group__3
            {
            pushFollow(FOLLOW_16);
            rule__JdlMaxBytesValidator__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlMaxBytesValidator__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMaxBytesValidator__Group__2"


    // $ANTLR start "rule__JdlMaxBytesValidator__Group__2__Impl"
    // InternalJDL.g:3062:1: rule__JdlMaxBytesValidator__Group__2__Impl : ( ( rule__JdlMaxBytesValidator__ValueAssignment_2 ) ) ;
    public final void rule__JdlMaxBytesValidator__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3066:1: ( ( ( rule__JdlMaxBytesValidator__ValueAssignment_2 ) ) )
            // InternalJDL.g:3067:1: ( ( rule__JdlMaxBytesValidator__ValueAssignment_2 ) )
            {
            // InternalJDL.g:3067:1: ( ( rule__JdlMaxBytesValidator__ValueAssignment_2 ) )
            // InternalJDL.g:3068:2: ( rule__JdlMaxBytesValidator__ValueAssignment_2 )
            {
             before(grammarAccess.getJdlMaxBytesValidatorAccess().getValueAssignment_2()); 
            // InternalJDL.g:3069:2: ( rule__JdlMaxBytesValidator__ValueAssignment_2 )
            // InternalJDL.g:3069:3: rule__JdlMaxBytesValidator__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__JdlMaxBytesValidator__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getJdlMaxBytesValidatorAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMaxBytesValidator__Group__2__Impl"


    // $ANTLR start "rule__JdlMaxBytesValidator__Group__3"
    // InternalJDL.g:3077:1: rule__JdlMaxBytesValidator__Group__3 : rule__JdlMaxBytesValidator__Group__3__Impl ;
    public final void rule__JdlMaxBytesValidator__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3081:1: ( rule__JdlMaxBytesValidator__Group__3__Impl )
            // InternalJDL.g:3082:2: rule__JdlMaxBytesValidator__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JdlMaxBytesValidator__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMaxBytesValidator__Group__3"


    // $ANTLR start "rule__JdlMaxBytesValidator__Group__3__Impl"
    // InternalJDL.g:3088:1: rule__JdlMaxBytesValidator__Group__3__Impl : ( ')' ) ;
    public final void rule__JdlMaxBytesValidator__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3092:1: ( ( ')' ) )
            // InternalJDL.g:3093:1: ( ')' )
            {
            // InternalJDL.g:3093:1: ( ')' )
            // InternalJDL.g:3094:2: ')'
            {
             before(grammarAccess.getJdlMaxBytesValidatorAccess().getRightParenthesisKeyword_3()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getJdlMaxBytesValidatorAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMaxBytesValidator__Group__3__Impl"


    // $ANTLR start "rule__JdlRelationships__Group__0"
    // InternalJDL.g:3104:1: rule__JdlRelationships__Group__0 : rule__JdlRelationships__Group__0__Impl rule__JdlRelationships__Group__1 ;
    public final void rule__JdlRelationships__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3108:1: ( rule__JdlRelationships__Group__0__Impl rule__JdlRelationships__Group__1 )
            // InternalJDL.g:3109:2: rule__JdlRelationships__Group__0__Impl rule__JdlRelationships__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__JdlRelationships__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlRelationships__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationships__Group__0"


    // $ANTLR start "rule__JdlRelationships__Group__0__Impl"
    // InternalJDL.g:3116:1: rule__JdlRelationships__Group__0__Impl : ( 'relationship' ) ;
    public final void rule__JdlRelationships__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3120:1: ( ( 'relationship' ) )
            // InternalJDL.g:3121:1: ( 'relationship' )
            {
            // InternalJDL.g:3121:1: ( 'relationship' )
            // InternalJDL.g:3122:2: 'relationship'
            {
             before(grammarAccess.getJdlRelationshipsAccess().getRelationshipKeyword_0()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getJdlRelationshipsAccess().getRelationshipKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationships__Group__0__Impl"


    // $ANTLR start "rule__JdlRelationships__Group__1"
    // InternalJDL.g:3131:1: rule__JdlRelationships__Group__1 : rule__JdlRelationships__Group__1__Impl rule__JdlRelationships__Group__2 ;
    public final void rule__JdlRelationships__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3135:1: ( rule__JdlRelationships__Group__1__Impl rule__JdlRelationships__Group__2 )
            // InternalJDL.g:3136:2: rule__JdlRelationships__Group__1__Impl rule__JdlRelationships__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__JdlRelationships__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlRelationships__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationships__Group__1"


    // $ANTLR start "rule__JdlRelationships__Group__1__Impl"
    // InternalJDL.g:3143:1: rule__JdlRelationships__Group__1__Impl : ( ( rule__JdlRelationships__CardinalityAssignment_1 ) ) ;
    public final void rule__JdlRelationships__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3147:1: ( ( ( rule__JdlRelationships__CardinalityAssignment_1 ) ) )
            // InternalJDL.g:3148:1: ( ( rule__JdlRelationships__CardinalityAssignment_1 ) )
            {
            // InternalJDL.g:3148:1: ( ( rule__JdlRelationships__CardinalityAssignment_1 ) )
            // InternalJDL.g:3149:2: ( rule__JdlRelationships__CardinalityAssignment_1 )
            {
             before(grammarAccess.getJdlRelationshipsAccess().getCardinalityAssignment_1()); 
            // InternalJDL.g:3150:2: ( rule__JdlRelationships__CardinalityAssignment_1 )
            // InternalJDL.g:3150:3: rule__JdlRelationships__CardinalityAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__JdlRelationships__CardinalityAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getJdlRelationshipsAccess().getCardinalityAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationships__Group__1__Impl"


    // $ANTLR start "rule__JdlRelationships__Group__2"
    // InternalJDL.g:3158:1: rule__JdlRelationships__Group__2 : rule__JdlRelationships__Group__2__Impl rule__JdlRelationships__Group__3 ;
    public final void rule__JdlRelationships__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3162:1: ( rule__JdlRelationships__Group__2__Impl rule__JdlRelationships__Group__3 )
            // InternalJDL.g:3163:2: rule__JdlRelationships__Group__2__Impl rule__JdlRelationships__Group__3
            {
            pushFollow(FOLLOW_19);
            rule__JdlRelationships__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlRelationships__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationships__Group__2"


    // $ANTLR start "rule__JdlRelationships__Group__2__Impl"
    // InternalJDL.g:3170:1: rule__JdlRelationships__Group__2__Impl : ( '{' ) ;
    public final void rule__JdlRelationships__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3174:1: ( ( '{' ) )
            // InternalJDL.g:3175:1: ( '{' )
            {
            // InternalJDL.g:3175:1: ( '{' )
            // InternalJDL.g:3176:2: '{'
            {
             before(grammarAccess.getJdlRelationshipsAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getJdlRelationshipsAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationships__Group__2__Impl"


    // $ANTLR start "rule__JdlRelationships__Group__3"
    // InternalJDL.g:3185:1: rule__JdlRelationships__Group__3 : rule__JdlRelationships__Group__3__Impl rule__JdlRelationships__Group__4 ;
    public final void rule__JdlRelationships__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3189:1: ( rule__JdlRelationships__Group__3__Impl rule__JdlRelationships__Group__4 )
            // InternalJDL.g:3190:2: rule__JdlRelationships__Group__3__Impl rule__JdlRelationships__Group__4
            {
            pushFollow(FOLLOW_19);
            rule__JdlRelationships__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlRelationships__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationships__Group__3"


    // $ANTLR start "rule__JdlRelationships__Group__3__Impl"
    // InternalJDL.g:3197:1: rule__JdlRelationships__Group__3__Impl : ( ( rule__JdlRelationships__RelationshipsAssignment_3 )* ) ;
    public final void rule__JdlRelationships__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3201:1: ( ( ( rule__JdlRelationships__RelationshipsAssignment_3 )* ) )
            // InternalJDL.g:3202:1: ( ( rule__JdlRelationships__RelationshipsAssignment_3 )* )
            {
            // InternalJDL.g:3202:1: ( ( rule__JdlRelationships__RelationshipsAssignment_3 )* )
            // InternalJDL.g:3203:2: ( rule__JdlRelationships__RelationshipsAssignment_3 )*
            {
             before(grammarAccess.getJdlRelationshipsAccess().getRelationshipsAssignment_3()); 
            // InternalJDL.g:3204:2: ( rule__JdlRelationships__RelationshipsAssignment_3 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_ID) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalJDL.g:3204:3: rule__JdlRelationships__RelationshipsAssignment_3
            	    {
            	    pushFollow(FOLLOW_20);
            	    rule__JdlRelationships__RelationshipsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

             after(grammarAccess.getJdlRelationshipsAccess().getRelationshipsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationships__Group__3__Impl"


    // $ANTLR start "rule__JdlRelationships__Group__4"
    // InternalJDL.g:3212:1: rule__JdlRelationships__Group__4 : rule__JdlRelationships__Group__4__Impl rule__JdlRelationships__Group__5 ;
    public final void rule__JdlRelationships__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3216:1: ( rule__JdlRelationships__Group__4__Impl rule__JdlRelationships__Group__5 )
            // InternalJDL.g:3217:2: rule__JdlRelationships__Group__4__Impl rule__JdlRelationships__Group__5
            {
            pushFollow(FOLLOW_19);
            rule__JdlRelationships__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlRelationships__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationships__Group__4"


    // $ANTLR start "rule__JdlRelationships__Group__4__Impl"
    // InternalJDL.g:3224:1: rule__JdlRelationships__Group__4__Impl : ( ( rule__JdlRelationships__Group_4__0 )* ) ;
    public final void rule__JdlRelationships__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3228:1: ( ( ( rule__JdlRelationships__Group_4__0 )* ) )
            // InternalJDL.g:3229:1: ( ( rule__JdlRelationships__Group_4__0 )* )
            {
            // InternalJDL.g:3229:1: ( ( rule__JdlRelationships__Group_4__0 )* )
            // InternalJDL.g:3230:2: ( rule__JdlRelationships__Group_4__0 )*
            {
             before(grammarAccess.getJdlRelationshipsAccess().getGroup_4()); 
            // InternalJDL.g:3231:2: ( rule__JdlRelationships__Group_4__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==31) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalJDL.g:3231:3: rule__JdlRelationships__Group_4__0
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__JdlRelationships__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

             after(grammarAccess.getJdlRelationshipsAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationships__Group__4__Impl"


    // $ANTLR start "rule__JdlRelationships__Group__5"
    // InternalJDL.g:3239:1: rule__JdlRelationships__Group__5 : rule__JdlRelationships__Group__5__Impl ;
    public final void rule__JdlRelationships__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3243:1: ( rule__JdlRelationships__Group__5__Impl )
            // InternalJDL.g:3244:2: rule__JdlRelationships__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JdlRelationships__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationships__Group__5"


    // $ANTLR start "rule__JdlRelationships__Group__5__Impl"
    // InternalJDL.g:3250:1: rule__JdlRelationships__Group__5__Impl : ( '}' ) ;
    public final void rule__JdlRelationships__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3254:1: ( ( '}' ) )
            // InternalJDL.g:3255:1: ( '}' )
            {
            // InternalJDL.g:3255:1: ( '}' )
            // InternalJDL.g:3256:2: '}'
            {
             before(grammarAccess.getJdlRelationshipsAccess().getRightCurlyBracketKeyword_5()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getJdlRelationshipsAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationships__Group__5__Impl"


    // $ANTLR start "rule__JdlRelationships__Group_4__0"
    // InternalJDL.g:3266:1: rule__JdlRelationships__Group_4__0 : rule__JdlRelationships__Group_4__0__Impl rule__JdlRelationships__Group_4__1 ;
    public final void rule__JdlRelationships__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3270:1: ( rule__JdlRelationships__Group_4__0__Impl rule__JdlRelationships__Group_4__1 )
            // InternalJDL.g:3271:2: rule__JdlRelationships__Group_4__0__Impl rule__JdlRelationships__Group_4__1
            {
            pushFollow(FOLLOW_4);
            rule__JdlRelationships__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlRelationships__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationships__Group_4__0"


    // $ANTLR start "rule__JdlRelationships__Group_4__0__Impl"
    // InternalJDL.g:3278:1: rule__JdlRelationships__Group_4__0__Impl : ( ',' ) ;
    public final void rule__JdlRelationships__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3282:1: ( ( ',' ) )
            // InternalJDL.g:3283:1: ( ',' )
            {
            // InternalJDL.g:3283:1: ( ',' )
            // InternalJDL.g:3284:2: ','
            {
             before(grammarAccess.getJdlRelationshipsAccess().getCommaKeyword_4_0()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getJdlRelationshipsAccess().getCommaKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationships__Group_4__0__Impl"


    // $ANTLR start "rule__JdlRelationships__Group_4__1"
    // InternalJDL.g:3293:1: rule__JdlRelationships__Group_4__1 : rule__JdlRelationships__Group_4__1__Impl ;
    public final void rule__JdlRelationships__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3297:1: ( rule__JdlRelationships__Group_4__1__Impl )
            // InternalJDL.g:3298:2: rule__JdlRelationships__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JdlRelationships__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationships__Group_4__1"


    // $ANTLR start "rule__JdlRelationships__Group_4__1__Impl"
    // InternalJDL.g:3304:1: rule__JdlRelationships__Group_4__1__Impl : ( ( rule__JdlRelationships__RelationshipsAssignment_4_1 ) ) ;
    public final void rule__JdlRelationships__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3308:1: ( ( ( rule__JdlRelationships__RelationshipsAssignment_4_1 ) ) )
            // InternalJDL.g:3309:1: ( ( rule__JdlRelationships__RelationshipsAssignment_4_1 ) )
            {
            // InternalJDL.g:3309:1: ( ( rule__JdlRelationships__RelationshipsAssignment_4_1 ) )
            // InternalJDL.g:3310:2: ( rule__JdlRelationships__RelationshipsAssignment_4_1 )
            {
             before(grammarAccess.getJdlRelationshipsAccess().getRelationshipsAssignment_4_1()); 
            // InternalJDL.g:3311:2: ( rule__JdlRelationships__RelationshipsAssignment_4_1 )
            // InternalJDL.g:3311:3: rule__JdlRelationships__RelationshipsAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__JdlRelationships__RelationshipsAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getJdlRelationshipsAccess().getRelationshipsAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationships__Group_4__1__Impl"


    // $ANTLR start "rule__JdlRelationship__Group__0"
    // InternalJDL.g:3320:1: rule__JdlRelationship__Group__0 : rule__JdlRelationship__Group__0__Impl rule__JdlRelationship__Group__1 ;
    public final void rule__JdlRelationship__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3324:1: ( rule__JdlRelationship__Group__0__Impl rule__JdlRelationship__Group__1 )
            // InternalJDL.g:3325:2: rule__JdlRelationship__Group__0__Impl rule__JdlRelationship__Group__1
            {
            pushFollow(FOLLOW_21);
            rule__JdlRelationship__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlRelationship__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationship__Group__0"


    // $ANTLR start "rule__JdlRelationship__Group__0__Impl"
    // InternalJDL.g:3332:1: rule__JdlRelationship__Group__0__Impl : ( ( rule__JdlRelationship__FromEntityAssignment_0 ) ) ;
    public final void rule__JdlRelationship__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3336:1: ( ( ( rule__JdlRelationship__FromEntityAssignment_0 ) ) )
            // InternalJDL.g:3337:1: ( ( rule__JdlRelationship__FromEntityAssignment_0 ) )
            {
            // InternalJDL.g:3337:1: ( ( rule__JdlRelationship__FromEntityAssignment_0 ) )
            // InternalJDL.g:3338:2: ( rule__JdlRelationship__FromEntityAssignment_0 )
            {
             before(grammarAccess.getJdlRelationshipAccess().getFromEntityAssignment_0()); 
            // InternalJDL.g:3339:2: ( rule__JdlRelationship__FromEntityAssignment_0 )
            // InternalJDL.g:3339:3: rule__JdlRelationship__FromEntityAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__JdlRelationship__FromEntityAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getJdlRelationshipAccess().getFromEntityAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationship__Group__0__Impl"


    // $ANTLR start "rule__JdlRelationship__Group__1"
    // InternalJDL.g:3347:1: rule__JdlRelationship__Group__1 : rule__JdlRelationship__Group__1__Impl rule__JdlRelationship__Group__2 ;
    public final void rule__JdlRelationship__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3351:1: ( rule__JdlRelationship__Group__1__Impl rule__JdlRelationship__Group__2 )
            // InternalJDL.g:3352:2: rule__JdlRelationship__Group__1__Impl rule__JdlRelationship__Group__2
            {
            pushFollow(FOLLOW_21);
            rule__JdlRelationship__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlRelationship__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationship__Group__1"


    // $ANTLR start "rule__JdlRelationship__Group__1__Impl"
    // InternalJDL.g:3359:1: rule__JdlRelationship__Group__1__Impl : ( ( rule__JdlRelationship__FromNameAssignment_1 )? ) ;
    public final void rule__JdlRelationship__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3363:1: ( ( ( rule__JdlRelationship__FromNameAssignment_1 )? ) )
            // InternalJDL.g:3364:1: ( ( rule__JdlRelationship__FromNameAssignment_1 )? )
            {
            // InternalJDL.g:3364:1: ( ( rule__JdlRelationship__FromNameAssignment_1 )? )
            // InternalJDL.g:3365:2: ( rule__JdlRelationship__FromNameAssignment_1 )?
            {
             before(grammarAccess.getJdlRelationshipAccess().getFromNameAssignment_1()); 
            // InternalJDL.g:3366:2: ( rule__JdlRelationship__FromNameAssignment_1 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==29) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalJDL.g:3366:3: rule__JdlRelationship__FromNameAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__JdlRelationship__FromNameAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getJdlRelationshipAccess().getFromNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationship__Group__1__Impl"


    // $ANTLR start "rule__JdlRelationship__Group__2"
    // InternalJDL.g:3374:1: rule__JdlRelationship__Group__2 : rule__JdlRelationship__Group__2__Impl rule__JdlRelationship__Group__3 ;
    public final void rule__JdlRelationship__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3378:1: ( rule__JdlRelationship__Group__2__Impl rule__JdlRelationship__Group__3 )
            // InternalJDL.g:3379:2: rule__JdlRelationship__Group__2__Impl rule__JdlRelationship__Group__3
            {
            pushFollow(FOLLOW_4);
            rule__JdlRelationship__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlRelationship__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationship__Group__2"


    // $ANTLR start "rule__JdlRelationship__Group__2__Impl"
    // InternalJDL.g:3386:1: rule__JdlRelationship__Group__2__Impl : ( 'to' ) ;
    public final void rule__JdlRelationship__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3390:1: ( ( 'to' ) )
            // InternalJDL.g:3391:1: ( 'to' )
            {
            // InternalJDL.g:3391:1: ( 'to' )
            // InternalJDL.g:3392:2: 'to'
            {
             before(grammarAccess.getJdlRelationshipAccess().getToKeyword_2()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getJdlRelationshipAccess().getToKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationship__Group__2__Impl"


    // $ANTLR start "rule__JdlRelationship__Group__3"
    // InternalJDL.g:3401:1: rule__JdlRelationship__Group__3 : rule__JdlRelationship__Group__3__Impl rule__JdlRelationship__Group__4 ;
    public final void rule__JdlRelationship__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3405:1: ( rule__JdlRelationship__Group__3__Impl rule__JdlRelationship__Group__4 )
            // InternalJDL.g:3406:2: rule__JdlRelationship__Group__3__Impl rule__JdlRelationship__Group__4
            {
            pushFollow(FOLLOW_5);
            rule__JdlRelationship__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlRelationship__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationship__Group__3"


    // $ANTLR start "rule__JdlRelationship__Group__3__Impl"
    // InternalJDL.g:3413:1: rule__JdlRelationship__Group__3__Impl : ( ( rule__JdlRelationship__ToEntityAssignment_3 ) ) ;
    public final void rule__JdlRelationship__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3417:1: ( ( ( rule__JdlRelationship__ToEntityAssignment_3 ) ) )
            // InternalJDL.g:3418:1: ( ( rule__JdlRelationship__ToEntityAssignment_3 ) )
            {
            // InternalJDL.g:3418:1: ( ( rule__JdlRelationship__ToEntityAssignment_3 ) )
            // InternalJDL.g:3419:2: ( rule__JdlRelationship__ToEntityAssignment_3 )
            {
             before(grammarAccess.getJdlRelationshipAccess().getToEntityAssignment_3()); 
            // InternalJDL.g:3420:2: ( rule__JdlRelationship__ToEntityAssignment_3 )
            // InternalJDL.g:3420:3: rule__JdlRelationship__ToEntityAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__JdlRelationship__ToEntityAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getJdlRelationshipAccess().getToEntityAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationship__Group__3__Impl"


    // $ANTLR start "rule__JdlRelationship__Group__4"
    // InternalJDL.g:3428:1: rule__JdlRelationship__Group__4 : rule__JdlRelationship__Group__4__Impl ;
    public final void rule__JdlRelationship__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3432:1: ( rule__JdlRelationship__Group__4__Impl )
            // InternalJDL.g:3433:2: rule__JdlRelationship__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JdlRelationship__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationship__Group__4"


    // $ANTLR start "rule__JdlRelationship__Group__4__Impl"
    // InternalJDL.g:3439:1: rule__JdlRelationship__Group__4__Impl : ( ( rule__JdlRelationship__ToNameAssignment_4 )? ) ;
    public final void rule__JdlRelationship__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3443:1: ( ( ( rule__JdlRelationship__ToNameAssignment_4 )? ) )
            // InternalJDL.g:3444:1: ( ( rule__JdlRelationship__ToNameAssignment_4 )? )
            {
            // InternalJDL.g:3444:1: ( ( rule__JdlRelationship__ToNameAssignment_4 )? )
            // InternalJDL.g:3445:2: ( rule__JdlRelationship__ToNameAssignment_4 )?
            {
             before(grammarAccess.getJdlRelationshipAccess().getToNameAssignment_4()); 
            // InternalJDL.g:3446:2: ( rule__JdlRelationship__ToNameAssignment_4 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==29) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalJDL.g:3446:3: rule__JdlRelationship__ToNameAssignment_4
                    {
                    pushFollow(FOLLOW_2);
                    rule__JdlRelationship__ToNameAssignment_4();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getJdlRelationshipAccess().getToNameAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationship__Group__4__Impl"


    // $ANTLR start "rule__JdlRelationshipName__Group__0"
    // InternalJDL.g:3455:1: rule__JdlRelationshipName__Group__0 : rule__JdlRelationshipName__Group__0__Impl rule__JdlRelationshipName__Group__1 ;
    public final void rule__JdlRelationshipName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3459:1: ( rule__JdlRelationshipName__Group__0__Impl rule__JdlRelationshipName__Group__1 )
            // InternalJDL.g:3460:2: rule__JdlRelationshipName__Group__0__Impl rule__JdlRelationshipName__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__JdlRelationshipName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlRelationshipName__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationshipName__Group__0"


    // $ANTLR start "rule__JdlRelationshipName__Group__0__Impl"
    // InternalJDL.g:3467:1: rule__JdlRelationshipName__Group__0__Impl : ( '{' ) ;
    public final void rule__JdlRelationshipName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3471:1: ( ( '{' ) )
            // InternalJDL.g:3472:1: ( '{' )
            {
            // InternalJDL.g:3472:1: ( '{' )
            // InternalJDL.g:3473:2: '{'
            {
             before(grammarAccess.getJdlRelationshipNameAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getJdlRelationshipNameAccess().getLeftCurlyBracketKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationshipName__Group__0__Impl"


    // $ANTLR start "rule__JdlRelationshipName__Group__1"
    // InternalJDL.g:3482:1: rule__JdlRelationshipName__Group__1 : rule__JdlRelationshipName__Group__1__Impl rule__JdlRelationshipName__Group__2 ;
    public final void rule__JdlRelationshipName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3486:1: ( rule__JdlRelationshipName__Group__1__Impl rule__JdlRelationshipName__Group__2 )
            // InternalJDL.g:3487:2: rule__JdlRelationshipName__Group__1__Impl rule__JdlRelationshipName__Group__2
            {
            pushFollow(FOLLOW_22);
            rule__JdlRelationshipName__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlRelationshipName__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationshipName__Group__1"


    // $ANTLR start "rule__JdlRelationshipName__Group__1__Impl"
    // InternalJDL.g:3494:1: rule__JdlRelationshipName__Group__1__Impl : ( ( rule__JdlRelationshipName__NameAssignment_1 ) ) ;
    public final void rule__JdlRelationshipName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3498:1: ( ( ( rule__JdlRelationshipName__NameAssignment_1 ) ) )
            // InternalJDL.g:3499:1: ( ( rule__JdlRelationshipName__NameAssignment_1 ) )
            {
            // InternalJDL.g:3499:1: ( ( rule__JdlRelationshipName__NameAssignment_1 ) )
            // InternalJDL.g:3500:2: ( rule__JdlRelationshipName__NameAssignment_1 )
            {
             before(grammarAccess.getJdlRelationshipNameAccess().getNameAssignment_1()); 
            // InternalJDL.g:3501:2: ( rule__JdlRelationshipName__NameAssignment_1 )
            // InternalJDL.g:3501:3: rule__JdlRelationshipName__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__JdlRelationshipName__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getJdlRelationshipNameAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationshipName__Group__1__Impl"


    // $ANTLR start "rule__JdlRelationshipName__Group__2"
    // InternalJDL.g:3509:1: rule__JdlRelationshipName__Group__2 : rule__JdlRelationshipName__Group__2__Impl rule__JdlRelationshipName__Group__3 ;
    public final void rule__JdlRelationshipName__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3513:1: ( rule__JdlRelationshipName__Group__2__Impl rule__JdlRelationshipName__Group__3 )
            // InternalJDL.g:3514:2: rule__JdlRelationshipName__Group__2__Impl rule__JdlRelationshipName__Group__3
            {
            pushFollow(FOLLOW_22);
            rule__JdlRelationshipName__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlRelationshipName__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationshipName__Group__2"


    // $ANTLR start "rule__JdlRelationshipName__Group__2__Impl"
    // InternalJDL.g:3521:1: rule__JdlRelationshipName__Group__2__Impl : ( ( rule__JdlRelationshipName__Group_2__0 )? ) ;
    public final void rule__JdlRelationshipName__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3525:1: ( ( ( rule__JdlRelationshipName__Group_2__0 )? ) )
            // InternalJDL.g:3526:1: ( ( rule__JdlRelationshipName__Group_2__0 )? )
            {
            // InternalJDL.g:3526:1: ( ( rule__JdlRelationshipName__Group_2__0 )? )
            // InternalJDL.g:3527:2: ( rule__JdlRelationshipName__Group_2__0 )?
            {
             before(grammarAccess.getJdlRelationshipNameAccess().getGroup_2()); 
            // InternalJDL.g:3528:2: ( rule__JdlRelationshipName__Group_2__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==33) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalJDL.g:3528:3: rule__JdlRelationshipName__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__JdlRelationshipName__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getJdlRelationshipNameAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationshipName__Group__2__Impl"


    // $ANTLR start "rule__JdlRelationshipName__Group__3"
    // InternalJDL.g:3536:1: rule__JdlRelationshipName__Group__3 : rule__JdlRelationshipName__Group__3__Impl ;
    public final void rule__JdlRelationshipName__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3540:1: ( rule__JdlRelationshipName__Group__3__Impl )
            // InternalJDL.g:3541:2: rule__JdlRelationshipName__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JdlRelationshipName__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationshipName__Group__3"


    // $ANTLR start "rule__JdlRelationshipName__Group__3__Impl"
    // InternalJDL.g:3547:1: rule__JdlRelationshipName__Group__3__Impl : ( '}' ) ;
    public final void rule__JdlRelationshipName__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3551:1: ( ( '}' ) )
            // InternalJDL.g:3552:1: ( '}' )
            {
            // InternalJDL.g:3552:1: ( '}' )
            // InternalJDL.g:3553:2: '}'
            {
             before(grammarAccess.getJdlRelationshipNameAccess().getRightCurlyBracketKeyword_3()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getJdlRelationshipNameAccess().getRightCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationshipName__Group__3__Impl"


    // $ANTLR start "rule__JdlRelationshipName__Group_2__0"
    // InternalJDL.g:3563:1: rule__JdlRelationshipName__Group_2__0 : rule__JdlRelationshipName__Group_2__0__Impl rule__JdlRelationshipName__Group_2__1 ;
    public final void rule__JdlRelationshipName__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3567:1: ( rule__JdlRelationshipName__Group_2__0__Impl rule__JdlRelationshipName__Group_2__1 )
            // InternalJDL.g:3568:2: rule__JdlRelationshipName__Group_2__0__Impl rule__JdlRelationshipName__Group_2__1
            {
            pushFollow(FOLLOW_4);
            rule__JdlRelationshipName__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlRelationshipName__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationshipName__Group_2__0"


    // $ANTLR start "rule__JdlRelationshipName__Group_2__0__Impl"
    // InternalJDL.g:3575:1: rule__JdlRelationshipName__Group_2__0__Impl : ( '(' ) ;
    public final void rule__JdlRelationshipName__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3579:1: ( ( '(' ) )
            // InternalJDL.g:3580:1: ( '(' )
            {
            // InternalJDL.g:3580:1: ( '(' )
            // InternalJDL.g:3581:2: '('
            {
             before(grammarAccess.getJdlRelationshipNameAccess().getLeftParenthesisKeyword_2_0()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getJdlRelationshipNameAccess().getLeftParenthesisKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationshipName__Group_2__0__Impl"


    // $ANTLR start "rule__JdlRelationshipName__Group_2__1"
    // InternalJDL.g:3590:1: rule__JdlRelationshipName__Group_2__1 : rule__JdlRelationshipName__Group_2__1__Impl rule__JdlRelationshipName__Group_2__2 ;
    public final void rule__JdlRelationshipName__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3594:1: ( rule__JdlRelationshipName__Group_2__1__Impl rule__JdlRelationshipName__Group_2__2 )
            // InternalJDL.g:3595:2: rule__JdlRelationshipName__Group_2__1__Impl rule__JdlRelationshipName__Group_2__2
            {
            pushFollow(FOLLOW_16);
            rule__JdlRelationshipName__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlRelationshipName__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationshipName__Group_2__1"


    // $ANTLR start "rule__JdlRelationshipName__Group_2__1__Impl"
    // InternalJDL.g:3602:1: rule__JdlRelationshipName__Group_2__1__Impl : ( ( rule__JdlRelationshipName__RoleAssignment_2_1 ) ) ;
    public final void rule__JdlRelationshipName__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3606:1: ( ( ( rule__JdlRelationshipName__RoleAssignment_2_1 ) ) )
            // InternalJDL.g:3607:1: ( ( rule__JdlRelationshipName__RoleAssignment_2_1 ) )
            {
            // InternalJDL.g:3607:1: ( ( rule__JdlRelationshipName__RoleAssignment_2_1 ) )
            // InternalJDL.g:3608:2: ( rule__JdlRelationshipName__RoleAssignment_2_1 )
            {
             before(grammarAccess.getJdlRelationshipNameAccess().getRoleAssignment_2_1()); 
            // InternalJDL.g:3609:2: ( rule__JdlRelationshipName__RoleAssignment_2_1 )
            // InternalJDL.g:3609:3: rule__JdlRelationshipName__RoleAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__JdlRelationshipName__RoleAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getJdlRelationshipNameAccess().getRoleAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationshipName__Group_2__1__Impl"


    // $ANTLR start "rule__JdlRelationshipName__Group_2__2"
    // InternalJDL.g:3617:1: rule__JdlRelationshipName__Group_2__2 : rule__JdlRelationshipName__Group_2__2__Impl ;
    public final void rule__JdlRelationshipName__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3621:1: ( rule__JdlRelationshipName__Group_2__2__Impl )
            // InternalJDL.g:3622:2: rule__JdlRelationshipName__Group_2__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JdlRelationshipName__Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationshipName__Group_2__2"


    // $ANTLR start "rule__JdlRelationshipName__Group_2__2__Impl"
    // InternalJDL.g:3628:1: rule__JdlRelationshipName__Group_2__2__Impl : ( ')' ) ;
    public final void rule__JdlRelationshipName__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3632:1: ( ( ')' ) )
            // InternalJDL.g:3633:1: ( ')' )
            {
            // InternalJDL.g:3633:1: ( ')' )
            // InternalJDL.g:3634:2: ')'
            {
             before(grammarAccess.getJdlRelationshipNameAccess().getRightParenthesisKeyword_2_2()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getJdlRelationshipNameAccess().getRightParenthesisKeyword_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationshipName__Group_2__2__Impl"


    // $ANTLR start "rule__JdlEnumType__Group__0"
    // InternalJDL.g:3644:1: rule__JdlEnumType__Group__0 : rule__JdlEnumType__Group__0__Impl rule__JdlEnumType__Group__1 ;
    public final void rule__JdlEnumType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3648:1: ( rule__JdlEnumType__Group__0__Impl rule__JdlEnumType__Group__1 )
            // InternalJDL.g:3649:2: rule__JdlEnumType__Group__0__Impl rule__JdlEnumType__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__JdlEnumType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlEnumType__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEnumType__Group__0"


    // $ANTLR start "rule__JdlEnumType__Group__0__Impl"
    // InternalJDL.g:3656:1: rule__JdlEnumType__Group__0__Impl : ( 'enum' ) ;
    public final void rule__JdlEnumType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3660:1: ( ( 'enum' ) )
            // InternalJDL.g:3661:1: ( 'enum' )
            {
            // InternalJDL.g:3661:1: ( 'enum' )
            // InternalJDL.g:3662:2: 'enum'
            {
             before(grammarAccess.getJdlEnumTypeAccess().getEnumKeyword_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getJdlEnumTypeAccess().getEnumKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEnumType__Group__0__Impl"


    // $ANTLR start "rule__JdlEnumType__Group__1"
    // InternalJDL.g:3671:1: rule__JdlEnumType__Group__1 : rule__JdlEnumType__Group__1__Impl rule__JdlEnumType__Group__2 ;
    public final void rule__JdlEnumType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3675:1: ( rule__JdlEnumType__Group__1__Impl rule__JdlEnumType__Group__2 )
            // InternalJDL.g:3676:2: rule__JdlEnumType__Group__1__Impl rule__JdlEnumType__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__JdlEnumType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlEnumType__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEnumType__Group__1"


    // $ANTLR start "rule__JdlEnumType__Group__1__Impl"
    // InternalJDL.g:3683:1: rule__JdlEnumType__Group__1__Impl : ( ( rule__JdlEnumType__NameAssignment_1 ) ) ;
    public final void rule__JdlEnumType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3687:1: ( ( ( rule__JdlEnumType__NameAssignment_1 ) ) )
            // InternalJDL.g:3688:1: ( ( rule__JdlEnumType__NameAssignment_1 ) )
            {
            // InternalJDL.g:3688:1: ( ( rule__JdlEnumType__NameAssignment_1 ) )
            // InternalJDL.g:3689:2: ( rule__JdlEnumType__NameAssignment_1 )
            {
             before(grammarAccess.getJdlEnumTypeAccess().getNameAssignment_1()); 
            // InternalJDL.g:3690:2: ( rule__JdlEnumType__NameAssignment_1 )
            // InternalJDL.g:3690:3: rule__JdlEnumType__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__JdlEnumType__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getJdlEnumTypeAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEnumType__Group__1__Impl"


    // $ANTLR start "rule__JdlEnumType__Group__2"
    // InternalJDL.g:3698:1: rule__JdlEnumType__Group__2 : rule__JdlEnumType__Group__2__Impl rule__JdlEnumType__Group__3 ;
    public final void rule__JdlEnumType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3702:1: ( rule__JdlEnumType__Group__2__Impl rule__JdlEnumType__Group__3 )
            // InternalJDL.g:3703:2: rule__JdlEnumType__Group__2__Impl rule__JdlEnumType__Group__3
            {
            pushFollow(FOLLOW_4);
            rule__JdlEnumType__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlEnumType__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEnumType__Group__2"


    // $ANTLR start "rule__JdlEnumType__Group__2__Impl"
    // InternalJDL.g:3710:1: rule__JdlEnumType__Group__2__Impl : ( '{' ) ;
    public final void rule__JdlEnumType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3714:1: ( ( '{' ) )
            // InternalJDL.g:3715:1: ( '{' )
            {
            // InternalJDL.g:3715:1: ( '{' )
            // InternalJDL.g:3716:2: '{'
            {
             before(grammarAccess.getJdlEnumTypeAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getJdlEnumTypeAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEnumType__Group__2__Impl"


    // $ANTLR start "rule__JdlEnumType__Group__3"
    // InternalJDL.g:3725:1: rule__JdlEnumType__Group__3 : rule__JdlEnumType__Group__3__Impl rule__JdlEnumType__Group__4 ;
    public final void rule__JdlEnumType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3729:1: ( rule__JdlEnumType__Group__3__Impl rule__JdlEnumType__Group__4 )
            // InternalJDL.g:3730:2: rule__JdlEnumType__Group__3__Impl rule__JdlEnumType__Group__4
            {
            pushFollow(FOLLOW_23);
            rule__JdlEnumType__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlEnumType__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEnumType__Group__3"


    // $ANTLR start "rule__JdlEnumType__Group__3__Impl"
    // InternalJDL.g:3737:1: rule__JdlEnumType__Group__3__Impl : ( ( rule__JdlEnumType__ValuesAssignment_3 ) ) ;
    public final void rule__JdlEnumType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3741:1: ( ( ( rule__JdlEnumType__ValuesAssignment_3 ) ) )
            // InternalJDL.g:3742:1: ( ( rule__JdlEnumType__ValuesAssignment_3 ) )
            {
            // InternalJDL.g:3742:1: ( ( rule__JdlEnumType__ValuesAssignment_3 ) )
            // InternalJDL.g:3743:2: ( rule__JdlEnumType__ValuesAssignment_3 )
            {
             before(grammarAccess.getJdlEnumTypeAccess().getValuesAssignment_3()); 
            // InternalJDL.g:3744:2: ( rule__JdlEnumType__ValuesAssignment_3 )
            // InternalJDL.g:3744:3: rule__JdlEnumType__ValuesAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__JdlEnumType__ValuesAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getJdlEnumTypeAccess().getValuesAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEnumType__Group__3__Impl"


    // $ANTLR start "rule__JdlEnumType__Group__4"
    // InternalJDL.g:3752:1: rule__JdlEnumType__Group__4 : rule__JdlEnumType__Group__4__Impl rule__JdlEnumType__Group__5 ;
    public final void rule__JdlEnumType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3756:1: ( rule__JdlEnumType__Group__4__Impl rule__JdlEnumType__Group__5 )
            // InternalJDL.g:3757:2: rule__JdlEnumType__Group__4__Impl rule__JdlEnumType__Group__5
            {
            pushFollow(FOLLOW_23);
            rule__JdlEnumType__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlEnumType__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEnumType__Group__4"


    // $ANTLR start "rule__JdlEnumType__Group__4__Impl"
    // InternalJDL.g:3764:1: rule__JdlEnumType__Group__4__Impl : ( ( rule__JdlEnumType__Group_4__0 )* ) ;
    public final void rule__JdlEnumType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3768:1: ( ( ( rule__JdlEnumType__Group_4__0 )* ) )
            // InternalJDL.g:3769:1: ( ( rule__JdlEnumType__Group_4__0 )* )
            {
            // InternalJDL.g:3769:1: ( ( rule__JdlEnumType__Group_4__0 )* )
            // InternalJDL.g:3770:2: ( rule__JdlEnumType__Group_4__0 )*
            {
             before(grammarAccess.getJdlEnumTypeAccess().getGroup_4()); 
            // InternalJDL.g:3771:2: ( rule__JdlEnumType__Group_4__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==31) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalJDL.g:3771:3: rule__JdlEnumType__Group_4__0
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__JdlEnumType__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

             after(grammarAccess.getJdlEnumTypeAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEnumType__Group__4__Impl"


    // $ANTLR start "rule__JdlEnumType__Group__5"
    // InternalJDL.g:3779:1: rule__JdlEnumType__Group__5 : rule__JdlEnumType__Group__5__Impl ;
    public final void rule__JdlEnumType__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3783:1: ( rule__JdlEnumType__Group__5__Impl )
            // InternalJDL.g:3784:2: rule__JdlEnumType__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JdlEnumType__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEnumType__Group__5"


    // $ANTLR start "rule__JdlEnumType__Group__5__Impl"
    // InternalJDL.g:3790:1: rule__JdlEnumType__Group__5__Impl : ( '}' ) ;
    public final void rule__JdlEnumType__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3794:1: ( ( '}' ) )
            // InternalJDL.g:3795:1: ( '}' )
            {
            // InternalJDL.g:3795:1: ( '}' )
            // InternalJDL.g:3796:2: '}'
            {
             before(grammarAccess.getJdlEnumTypeAccess().getRightCurlyBracketKeyword_5()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getJdlEnumTypeAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEnumType__Group__5__Impl"


    // $ANTLR start "rule__JdlEnumType__Group_4__0"
    // InternalJDL.g:3806:1: rule__JdlEnumType__Group_4__0 : rule__JdlEnumType__Group_4__0__Impl rule__JdlEnumType__Group_4__1 ;
    public final void rule__JdlEnumType__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3810:1: ( rule__JdlEnumType__Group_4__0__Impl rule__JdlEnumType__Group_4__1 )
            // InternalJDL.g:3811:2: rule__JdlEnumType__Group_4__0__Impl rule__JdlEnumType__Group_4__1
            {
            pushFollow(FOLLOW_4);
            rule__JdlEnumType__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlEnumType__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEnumType__Group_4__0"


    // $ANTLR start "rule__JdlEnumType__Group_4__0__Impl"
    // InternalJDL.g:3818:1: rule__JdlEnumType__Group_4__0__Impl : ( ',' ) ;
    public final void rule__JdlEnumType__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3822:1: ( ( ',' ) )
            // InternalJDL.g:3823:1: ( ',' )
            {
            // InternalJDL.g:3823:1: ( ',' )
            // InternalJDL.g:3824:2: ','
            {
             before(grammarAccess.getJdlEnumTypeAccess().getCommaKeyword_4_0()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getJdlEnumTypeAccess().getCommaKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEnumType__Group_4__0__Impl"


    // $ANTLR start "rule__JdlEnumType__Group_4__1"
    // InternalJDL.g:3833:1: rule__JdlEnumType__Group_4__1 : rule__JdlEnumType__Group_4__1__Impl ;
    public final void rule__JdlEnumType__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3837:1: ( rule__JdlEnumType__Group_4__1__Impl )
            // InternalJDL.g:3838:2: rule__JdlEnumType__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JdlEnumType__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEnumType__Group_4__1"


    // $ANTLR start "rule__JdlEnumType__Group_4__1__Impl"
    // InternalJDL.g:3844:1: rule__JdlEnumType__Group_4__1__Impl : ( ( rule__JdlEnumType__ValuesAssignment_4_1 ) ) ;
    public final void rule__JdlEnumType__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3848:1: ( ( ( rule__JdlEnumType__ValuesAssignment_4_1 ) ) )
            // InternalJDL.g:3849:1: ( ( rule__JdlEnumType__ValuesAssignment_4_1 ) )
            {
            // InternalJDL.g:3849:1: ( ( rule__JdlEnumType__ValuesAssignment_4_1 ) )
            // InternalJDL.g:3850:2: ( rule__JdlEnumType__ValuesAssignment_4_1 )
            {
             before(grammarAccess.getJdlEnumTypeAccess().getValuesAssignment_4_1()); 
            // InternalJDL.g:3851:2: ( rule__JdlEnumType__ValuesAssignment_4_1 )
            // InternalJDL.g:3851:3: rule__JdlEnumType__ValuesAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__JdlEnumType__ValuesAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getJdlEnumTypeAccess().getValuesAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEnumType__Group_4__1__Impl"


    // $ANTLR start "rule__JdlGenerationSetting__Group__0"
    // InternalJDL.g:3860:1: rule__JdlGenerationSetting__Group__0 : rule__JdlGenerationSetting__Group__0__Impl rule__JdlGenerationSetting__Group__1 ;
    public final void rule__JdlGenerationSetting__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3864:1: ( rule__JdlGenerationSetting__Group__0__Impl rule__JdlGenerationSetting__Group__1 )
            // InternalJDL.g:3865:2: rule__JdlGenerationSetting__Group__0__Impl rule__JdlGenerationSetting__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__JdlGenerationSetting__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlGenerationSetting__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlGenerationSetting__Group__0"


    // $ANTLR start "rule__JdlGenerationSetting__Group__0__Impl"
    // InternalJDL.g:3872:1: rule__JdlGenerationSetting__Group__0__Impl : ( ( rule__JdlGenerationSetting__SettingAssignment_0 ) ) ;
    public final void rule__JdlGenerationSetting__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3876:1: ( ( ( rule__JdlGenerationSetting__SettingAssignment_0 ) ) )
            // InternalJDL.g:3877:1: ( ( rule__JdlGenerationSetting__SettingAssignment_0 ) )
            {
            // InternalJDL.g:3877:1: ( ( rule__JdlGenerationSetting__SettingAssignment_0 ) )
            // InternalJDL.g:3878:2: ( rule__JdlGenerationSetting__SettingAssignment_0 )
            {
             before(grammarAccess.getJdlGenerationSettingAccess().getSettingAssignment_0()); 
            // InternalJDL.g:3879:2: ( rule__JdlGenerationSetting__SettingAssignment_0 )
            // InternalJDL.g:3879:3: rule__JdlGenerationSetting__SettingAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__JdlGenerationSetting__SettingAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getJdlGenerationSettingAccess().getSettingAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlGenerationSetting__Group__0__Impl"


    // $ANTLR start "rule__JdlGenerationSetting__Group__1"
    // InternalJDL.g:3887:1: rule__JdlGenerationSetting__Group__1 : rule__JdlGenerationSetting__Group__1__Impl ;
    public final void rule__JdlGenerationSetting__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3891:1: ( rule__JdlGenerationSetting__Group__1__Impl )
            // InternalJDL.g:3892:2: rule__JdlGenerationSetting__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JdlGenerationSetting__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlGenerationSetting__Group__1"


    // $ANTLR start "rule__JdlGenerationSetting__Group__1__Impl"
    // InternalJDL.g:3898:1: rule__JdlGenerationSetting__Group__1__Impl : ( ( rule__JdlGenerationSetting__ExcludesAssignment_1 )? ) ;
    public final void rule__JdlGenerationSetting__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3902:1: ( ( ( rule__JdlGenerationSetting__ExcludesAssignment_1 )? ) )
            // InternalJDL.g:3903:1: ( ( rule__JdlGenerationSetting__ExcludesAssignment_1 )? )
            {
            // InternalJDL.g:3903:1: ( ( rule__JdlGenerationSetting__ExcludesAssignment_1 )? )
            // InternalJDL.g:3904:2: ( rule__JdlGenerationSetting__ExcludesAssignment_1 )?
            {
             before(grammarAccess.getJdlGenerationSettingAccess().getExcludesAssignment_1()); 
            // InternalJDL.g:3905:2: ( rule__JdlGenerationSetting__ExcludesAssignment_1 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==45) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalJDL.g:3905:3: rule__JdlGenerationSetting__ExcludesAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__JdlGenerationSetting__ExcludesAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getJdlGenerationSettingAccess().getExcludesAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlGenerationSetting__Group__1__Impl"


    // $ANTLR start "rule__JdlServiceGenerationSetting__Group__0"
    // InternalJDL.g:3914:1: rule__JdlServiceGenerationSetting__Group__0 : rule__JdlServiceGenerationSetting__Group__0__Impl rule__JdlServiceGenerationSetting__Group__1 ;
    public final void rule__JdlServiceGenerationSetting__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3918:1: ( rule__JdlServiceGenerationSetting__Group__0__Impl rule__JdlServiceGenerationSetting__Group__1 )
            // InternalJDL.g:3919:2: rule__JdlServiceGenerationSetting__Group__0__Impl rule__JdlServiceGenerationSetting__Group__1
            {
            pushFollow(FOLLOW_25);
            rule__JdlServiceGenerationSetting__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlServiceGenerationSetting__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlServiceGenerationSetting__Group__0"


    // $ANTLR start "rule__JdlServiceGenerationSetting__Group__0__Impl"
    // InternalJDL.g:3926:1: rule__JdlServiceGenerationSetting__Group__0__Impl : ( ( rule__JdlServiceGenerationSetting__ServiceGenerationSettingAssignment_0 ) ) ;
    public final void rule__JdlServiceGenerationSetting__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3930:1: ( ( ( rule__JdlServiceGenerationSetting__ServiceGenerationSettingAssignment_0 ) ) )
            // InternalJDL.g:3931:1: ( ( rule__JdlServiceGenerationSetting__ServiceGenerationSettingAssignment_0 ) )
            {
            // InternalJDL.g:3931:1: ( ( rule__JdlServiceGenerationSetting__ServiceGenerationSettingAssignment_0 ) )
            // InternalJDL.g:3932:2: ( rule__JdlServiceGenerationSetting__ServiceGenerationSettingAssignment_0 )
            {
             before(grammarAccess.getJdlServiceGenerationSettingAccess().getServiceGenerationSettingAssignment_0()); 
            // InternalJDL.g:3933:2: ( rule__JdlServiceGenerationSetting__ServiceGenerationSettingAssignment_0 )
            // InternalJDL.g:3933:3: rule__JdlServiceGenerationSetting__ServiceGenerationSettingAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__JdlServiceGenerationSetting__ServiceGenerationSettingAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getJdlServiceGenerationSettingAccess().getServiceGenerationSettingAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlServiceGenerationSetting__Group__0__Impl"


    // $ANTLR start "rule__JdlServiceGenerationSetting__Group__1"
    // InternalJDL.g:3941:1: rule__JdlServiceGenerationSetting__Group__1 : rule__JdlServiceGenerationSetting__Group__1__Impl rule__JdlServiceGenerationSetting__Group__2 ;
    public final void rule__JdlServiceGenerationSetting__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3945:1: ( rule__JdlServiceGenerationSetting__Group__1__Impl rule__JdlServiceGenerationSetting__Group__2 )
            // InternalJDL.g:3946:2: rule__JdlServiceGenerationSetting__Group__1__Impl rule__JdlServiceGenerationSetting__Group__2
            {
            pushFollow(FOLLOW_26);
            rule__JdlServiceGenerationSetting__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlServiceGenerationSetting__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlServiceGenerationSetting__Group__1"


    // $ANTLR start "rule__JdlServiceGenerationSetting__Group__1__Impl"
    // InternalJDL.g:3953:1: rule__JdlServiceGenerationSetting__Group__1__Impl : ( ( rule__JdlServiceGenerationSetting__IncludesAssignment_1 ) ) ;
    public final void rule__JdlServiceGenerationSetting__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3957:1: ( ( ( rule__JdlServiceGenerationSetting__IncludesAssignment_1 ) ) )
            // InternalJDL.g:3958:1: ( ( rule__JdlServiceGenerationSetting__IncludesAssignment_1 ) )
            {
            // InternalJDL.g:3958:1: ( ( rule__JdlServiceGenerationSetting__IncludesAssignment_1 ) )
            // InternalJDL.g:3959:2: ( rule__JdlServiceGenerationSetting__IncludesAssignment_1 )
            {
             before(grammarAccess.getJdlServiceGenerationSettingAccess().getIncludesAssignment_1()); 
            // InternalJDL.g:3960:2: ( rule__JdlServiceGenerationSetting__IncludesAssignment_1 )
            // InternalJDL.g:3960:3: rule__JdlServiceGenerationSetting__IncludesAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__JdlServiceGenerationSetting__IncludesAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getJdlServiceGenerationSettingAccess().getIncludesAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlServiceGenerationSetting__Group__1__Impl"


    // $ANTLR start "rule__JdlServiceGenerationSetting__Group__2"
    // InternalJDL.g:3968:1: rule__JdlServiceGenerationSetting__Group__2 : rule__JdlServiceGenerationSetting__Group__2__Impl ;
    public final void rule__JdlServiceGenerationSetting__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3972:1: ( rule__JdlServiceGenerationSetting__Group__2__Impl )
            // InternalJDL.g:3973:2: rule__JdlServiceGenerationSetting__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JdlServiceGenerationSetting__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlServiceGenerationSetting__Group__2"


    // $ANTLR start "rule__JdlServiceGenerationSetting__Group__2__Impl"
    // InternalJDL.g:3979:1: rule__JdlServiceGenerationSetting__Group__2__Impl : ( ( rule__JdlServiceGenerationSetting__ServiceTypeAssignment_2 ) ) ;
    public final void rule__JdlServiceGenerationSetting__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3983:1: ( ( ( rule__JdlServiceGenerationSetting__ServiceTypeAssignment_2 ) ) )
            // InternalJDL.g:3984:1: ( ( rule__JdlServiceGenerationSetting__ServiceTypeAssignment_2 ) )
            {
            // InternalJDL.g:3984:1: ( ( rule__JdlServiceGenerationSetting__ServiceTypeAssignment_2 ) )
            // InternalJDL.g:3985:2: ( rule__JdlServiceGenerationSetting__ServiceTypeAssignment_2 )
            {
             before(grammarAccess.getJdlServiceGenerationSettingAccess().getServiceTypeAssignment_2()); 
            // InternalJDL.g:3986:2: ( rule__JdlServiceGenerationSetting__ServiceTypeAssignment_2 )
            // InternalJDL.g:3986:3: rule__JdlServiceGenerationSetting__ServiceTypeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__JdlServiceGenerationSetting__ServiceTypeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getJdlServiceGenerationSettingAccess().getServiceTypeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlServiceGenerationSetting__Group__2__Impl"


    // $ANTLR start "rule__JdlMicroserviceGenerationSetting__Group__0"
    // InternalJDL.g:3995:1: rule__JdlMicroserviceGenerationSetting__Group__0 : rule__JdlMicroserviceGenerationSetting__Group__0__Impl rule__JdlMicroserviceGenerationSetting__Group__1 ;
    public final void rule__JdlMicroserviceGenerationSetting__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:3999:1: ( rule__JdlMicroserviceGenerationSetting__Group__0__Impl rule__JdlMicroserviceGenerationSetting__Group__1 )
            // InternalJDL.g:4000:2: rule__JdlMicroserviceGenerationSetting__Group__0__Impl rule__JdlMicroserviceGenerationSetting__Group__1
            {
            pushFollow(FOLLOW_25);
            rule__JdlMicroserviceGenerationSetting__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlMicroserviceGenerationSetting__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMicroserviceGenerationSetting__Group__0"


    // $ANTLR start "rule__JdlMicroserviceGenerationSetting__Group__0__Impl"
    // InternalJDL.g:4007:1: rule__JdlMicroserviceGenerationSetting__Group__0__Impl : ( ( rule__JdlMicroserviceGenerationSetting__MicroserviceGenerationSettingAssignment_0 ) ) ;
    public final void rule__JdlMicroserviceGenerationSetting__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4011:1: ( ( ( rule__JdlMicroserviceGenerationSetting__MicroserviceGenerationSettingAssignment_0 ) ) )
            // InternalJDL.g:4012:1: ( ( rule__JdlMicroserviceGenerationSetting__MicroserviceGenerationSettingAssignment_0 ) )
            {
            // InternalJDL.g:4012:1: ( ( rule__JdlMicroserviceGenerationSetting__MicroserviceGenerationSettingAssignment_0 ) )
            // InternalJDL.g:4013:2: ( rule__JdlMicroserviceGenerationSetting__MicroserviceGenerationSettingAssignment_0 )
            {
             before(grammarAccess.getJdlMicroserviceGenerationSettingAccess().getMicroserviceGenerationSettingAssignment_0()); 
            // InternalJDL.g:4014:2: ( rule__JdlMicroserviceGenerationSetting__MicroserviceGenerationSettingAssignment_0 )
            // InternalJDL.g:4014:3: rule__JdlMicroserviceGenerationSetting__MicroserviceGenerationSettingAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__JdlMicroserviceGenerationSetting__MicroserviceGenerationSettingAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getJdlMicroserviceGenerationSettingAccess().getMicroserviceGenerationSettingAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMicroserviceGenerationSetting__Group__0__Impl"


    // $ANTLR start "rule__JdlMicroserviceGenerationSetting__Group__1"
    // InternalJDL.g:4022:1: rule__JdlMicroserviceGenerationSetting__Group__1 : rule__JdlMicroserviceGenerationSetting__Group__1__Impl rule__JdlMicroserviceGenerationSetting__Group__2 ;
    public final void rule__JdlMicroserviceGenerationSetting__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4026:1: ( rule__JdlMicroserviceGenerationSetting__Group__1__Impl rule__JdlMicroserviceGenerationSetting__Group__2 )
            // InternalJDL.g:4027:2: rule__JdlMicroserviceGenerationSetting__Group__1__Impl rule__JdlMicroserviceGenerationSetting__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__JdlMicroserviceGenerationSetting__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlMicroserviceGenerationSetting__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMicroserviceGenerationSetting__Group__1"


    // $ANTLR start "rule__JdlMicroserviceGenerationSetting__Group__1__Impl"
    // InternalJDL.g:4034:1: rule__JdlMicroserviceGenerationSetting__Group__1__Impl : ( ( rule__JdlMicroserviceGenerationSetting__IncludesAssignment_1 ) ) ;
    public final void rule__JdlMicroserviceGenerationSetting__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4038:1: ( ( ( rule__JdlMicroserviceGenerationSetting__IncludesAssignment_1 ) ) )
            // InternalJDL.g:4039:1: ( ( rule__JdlMicroserviceGenerationSetting__IncludesAssignment_1 ) )
            {
            // InternalJDL.g:4039:1: ( ( rule__JdlMicroserviceGenerationSetting__IncludesAssignment_1 ) )
            // InternalJDL.g:4040:2: ( rule__JdlMicroserviceGenerationSetting__IncludesAssignment_1 )
            {
             before(grammarAccess.getJdlMicroserviceGenerationSettingAccess().getIncludesAssignment_1()); 
            // InternalJDL.g:4041:2: ( rule__JdlMicroserviceGenerationSetting__IncludesAssignment_1 )
            // InternalJDL.g:4041:3: rule__JdlMicroserviceGenerationSetting__IncludesAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__JdlMicroserviceGenerationSetting__IncludesAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getJdlMicroserviceGenerationSettingAccess().getIncludesAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMicroserviceGenerationSetting__Group__1__Impl"


    // $ANTLR start "rule__JdlMicroserviceGenerationSetting__Group__2"
    // InternalJDL.g:4049:1: rule__JdlMicroserviceGenerationSetting__Group__2 : rule__JdlMicroserviceGenerationSetting__Group__2__Impl ;
    public final void rule__JdlMicroserviceGenerationSetting__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4053:1: ( rule__JdlMicroserviceGenerationSetting__Group__2__Impl )
            // InternalJDL.g:4054:2: rule__JdlMicroserviceGenerationSetting__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JdlMicroserviceGenerationSetting__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMicroserviceGenerationSetting__Group__2"


    // $ANTLR start "rule__JdlMicroserviceGenerationSetting__Group__2__Impl"
    // InternalJDL.g:4060:1: rule__JdlMicroserviceGenerationSetting__Group__2__Impl : ( ( rule__JdlMicroserviceGenerationSetting__AppnameAssignment_2 ) ) ;
    public final void rule__JdlMicroserviceGenerationSetting__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4064:1: ( ( ( rule__JdlMicroserviceGenerationSetting__AppnameAssignment_2 ) ) )
            // InternalJDL.g:4065:1: ( ( rule__JdlMicroserviceGenerationSetting__AppnameAssignment_2 ) )
            {
            // InternalJDL.g:4065:1: ( ( rule__JdlMicroserviceGenerationSetting__AppnameAssignment_2 ) )
            // InternalJDL.g:4066:2: ( rule__JdlMicroserviceGenerationSetting__AppnameAssignment_2 )
            {
             before(grammarAccess.getJdlMicroserviceGenerationSettingAccess().getAppnameAssignment_2()); 
            // InternalJDL.g:4067:2: ( rule__JdlMicroserviceGenerationSetting__AppnameAssignment_2 )
            // InternalJDL.g:4067:3: rule__JdlMicroserviceGenerationSetting__AppnameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__JdlMicroserviceGenerationSetting__AppnameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getJdlMicroserviceGenerationSettingAccess().getAppnameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMicroserviceGenerationSetting__Group__2__Impl"


    // $ANTLR start "rule__JdlSearchGenerationSetting__Group__0"
    // InternalJDL.g:4076:1: rule__JdlSearchGenerationSetting__Group__0 : rule__JdlSearchGenerationSetting__Group__0__Impl rule__JdlSearchGenerationSetting__Group__1 ;
    public final void rule__JdlSearchGenerationSetting__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4080:1: ( rule__JdlSearchGenerationSetting__Group__0__Impl rule__JdlSearchGenerationSetting__Group__1 )
            // InternalJDL.g:4081:2: rule__JdlSearchGenerationSetting__Group__0__Impl rule__JdlSearchGenerationSetting__Group__1
            {
            pushFollow(FOLLOW_25);
            rule__JdlSearchGenerationSetting__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlSearchGenerationSetting__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlSearchGenerationSetting__Group__0"


    // $ANTLR start "rule__JdlSearchGenerationSetting__Group__0__Impl"
    // InternalJDL.g:4088:1: rule__JdlSearchGenerationSetting__Group__0__Impl : ( ( rule__JdlSearchGenerationSetting__SearchGenerationSettingAssignment_0 ) ) ;
    public final void rule__JdlSearchGenerationSetting__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4092:1: ( ( ( rule__JdlSearchGenerationSetting__SearchGenerationSettingAssignment_0 ) ) )
            // InternalJDL.g:4093:1: ( ( rule__JdlSearchGenerationSetting__SearchGenerationSettingAssignment_0 ) )
            {
            // InternalJDL.g:4093:1: ( ( rule__JdlSearchGenerationSetting__SearchGenerationSettingAssignment_0 ) )
            // InternalJDL.g:4094:2: ( rule__JdlSearchGenerationSetting__SearchGenerationSettingAssignment_0 )
            {
             before(grammarAccess.getJdlSearchGenerationSettingAccess().getSearchGenerationSettingAssignment_0()); 
            // InternalJDL.g:4095:2: ( rule__JdlSearchGenerationSetting__SearchGenerationSettingAssignment_0 )
            // InternalJDL.g:4095:3: rule__JdlSearchGenerationSetting__SearchGenerationSettingAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__JdlSearchGenerationSetting__SearchGenerationSettingAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getJdlSearchGenerationSettingAccess().getSearchGenerationSettingAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlSearchGenerationSetting__Group__0__Impl"


    // $ANTLR start "rule__JdlSearchGenerationSetting__Group__1"
    // InternalJDL.g:4103:1: rule__JdlSearchGenerationSetting__Group__1 : rule__JdlSearchGenerationSetting__Group__1__Impl rule__JdlSearchGenerationSetting__Group__2 ;
    public final void rule__JdlSearchGenerationSetting__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4107:1: ( rule__JdlSearchGenerationSetting__Group__1__Impl rule__JdlSearchGenerationSetting__Group__2 )
            // InternalJDL.g:4108:2: rule__JdlSearchGenerationSetting__Group__1__Impl rule__JdlSearchGenerationSetting__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__JdlSearchGenerationSetting__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlSearchGenerationSetting__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlSearchGenerationSetting__Group__1"


    // $ANTLR start "rule__JdlSearchGenerationSetting__Group__1__Impl"
    // InternalJDL.g:4115:1: rule__JdlSearchGenerationSetting__Group__1__Impl : ( ( rule__JdlSearchGenerationSetting__IncludesAssignment_1 ) ) ;
    public final void rule__JdlSearchGenerationSetting__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4119:1: ( ( ( rule__JdlSearchGenerationSetting__IncludesAssignment_1 ) ) )
            // InternalJDL.g:4120:1: ( ( rule__JdlSearchGenerationSetting__IncludesAssignment_1 ) )
            {
            // InternalJDL.g:4120:1: ( ( rule__JdlSearchGenerationSetting__IncludesAssignment_1 ) )
            // InternalJDL.g:4121:2: ( rule__JdlSearchGenerationSetting__IncludesAssignment_1 )
            {
             before(grammarAccess.getJdlSearchGenerationSettingAccess().getIncludesAssignment_1()); 
            // InternalJDL.g:4122:2: ( rule__JdlSearchGenerationSetting__IncludesAssignment_1 )
            // InternalJDL.g:4122:3: rule__JdlSearchGenerationSetting__IncludesAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__JdlSearchGenerationSetting__IncludesAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getJdlSearchGenerationSettingAccess().getIncludesAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlSearchGenerationSetting__Group__1__Impl"


    // $ANTLR start "rule__JdlSearchGenerationSetting__Group__2"
    // InternalJDL.g:4130:1: rule__JdlSearchGenerationSetting__Group__2 : rule__JdlSearchGenerationSetting__Group__2__Impl ;
    public final void rule__JdlSearchGenerationSetting__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4134:1: ( rule__JdlSearchGenerationSetting__Group__2__Impl )
            // InternalJDL.g:4135:2: rule__JdlSearchGenerationSetting__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JdlSearchGenerationSetting__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlSearchGenerationSetting__Group__2"


    // $ANTLR start "rule__JdlSearchGenerationSetting__Group__2__Impl"
    // InternalJDL.g:4141:1: rule__JdlSearchGenerationSetting__Group__2__Impl : ( ( rule__JdlSearchGenerationSetting__ServiceAssignment_2 ) ) ;
    public final void rule__JdlSearchGenerationSetting__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4145:1: ( ( ( rule__JdlSearchGenerationSetting__ServiceAssignment_2 ) ) )
            // InternalJDL.g:4146:1: ( ( rule__JdlSearchGenerationSetting__ServiceAssignment_2 ) )
            {
            // InternalJDL.g:4146:1: ( ( rule__JdlSearchGenerationSetting__ServiceAssignment_2 ) )
            // InternalJDL.g:4147:2: ( rule__JdlSearchGenerationSetting__ServiceAssignment_2 )
            {
             before(grammarAccess.getJdlSearchGenerationSettingAccess().getServiceAssignment_2()); 
            // InternalJDL.g:4148:2: ( rule__JdlSearchGenerationSetting__ServiceAssignment_2 )
            // InternalJDL.g:4148:3: rule__JdlSearchGenerationSetting__ServiceAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__JdlSearchGenerationSetting__ServiceAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getJdlSearchGenerationSettingAccess().getServiceAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlSearchGenerationSetting__Group__2__Impl"


    // $ANTLR start "rule__JdlDtoGenerationSetting__Group__0"
    // InternalJDL.g:4157:1: rule__JdlDtoGenerationSetting__Group__0 : rule__JdlDtoGenerationSetting__Group__0__Impl rule__JdlDtoGenerationSetting__Group__1 ;
    public final void rule__JdlDtoGenerationSetting__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4161:1: ( rule__JdlDtoGenerationSetting__Group__0__Impl rule__JdlDtoGenerationSetting__Group__1 )
            // InternalJDL.g:4162:2: rule__JdlDtoGenerationSetting__Group__0__Impl rule__JdlDtoGenerationSetting__Group__1
            {
            pushFollow(FOLLOW_25);
            rule__JdlDtoGenerationSetting__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlDtoGenerationSetting__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlDtoGenerationSetting__Group__0"


    // $ANTLR start "rule__JdlDtoGenerationSetting__Group__0__Impl"
    // InternalJDL.g:4169:1: rule__JdlDtoGenerationSetting__Group__0__Impl : ( ( rule__JdlDtoGenerationSetting__DtoGenerationSettingAssignment_0 ) ) ;
    public final void rule__JdlDtoGenerationSetting__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4173:1: ( ( ( rule__JdlDtoGenerationSetting__DtoGenerationSettingAssignment_0 ) ) )
            // InternalJDL.g:4174:1: ( ( rule__JdlDtoGenerationSetting__DtoGenerationSettingAssignment_0 ) )
            {
            // InternalJDL.g:4174:1: ( ( rule__JdlDtoGenerationSetting__DtoGenerationSettingAssignment_0 ) )
            // InternalJDL.g:4175:2: ( rule__JdlDtoGenerationSetting__DtoGenerationSettingAssignment_0 )
            {
             before(grammarAccess.getJdlDtoGenerationSettingAccess().getDtoGenerationSettingAssignment_0()); 
            // InternalJDL.g:4176:2: ( rule__JdlDtoGenerationSetting__DtoGenerationSettingAssignment_0 )
            // InternalJDL.g:4176:3: rule__JdlDtoGenerationSetting__DtoGenerationSettingAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__JdlDtoGenerationSetting__DtoGenerationSettingAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getJdlDtoGenerationSettingAccess().getDtoGenerationSettingAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlDtoGenerationSetting__Group__0__Impl"


    // $ANTLR start "rule__JdlDtoGenerationSetting__Group__1"
    // InternalJDL.g:4184:1: rule__JdlDtoGenerationSetting__Group__1 : rule__JdlDtoGenerationSetting__Group__1__Impl rule__JdlDtoGenerationSetting__Group__2 ;
    public final void rule__JdlDtoGenerationSetting__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4188:1: ( rule__JdlDtoGenerationSetting__Group__1__Impl rule__JdlDtoGenerationSetting__Group__2 )
            // InternalJDL.g:4189:2: rule__JdlDtoGenerationSetting__Group__1__Impl rule__JdlDtoGenerationSetting__Group__2
            {
            pushFollow(FOLLOW_27);
            rule__JdlDtoGenerationSetting__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlDtoGenerationSetting__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlDtoGenerationSetting__Group__1"


    // $ANTLR start "rule__JdlDtoGenerationSetting__Group__1__Impl"
    // InternalJDL.g:4196:1: rule__JdlDtoGenerationSetting__Group__1__Impl : ( ( rule__JdlDtoGenerationSetting__IncludesAssignment_1 ) ) ;
    public final void rule__JdlDtoGenerationSetting__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4200:1: ( ( ( rule__JdlDtoGenerationSetting__IncludesAssignment_1 ) ) )
            // InternalJDL.g:4201:1: ( ( rule__JdlDtoGenerationSetting__IncludesAssignment_1 ) )
            {
            // InternalJDL.g:4201:1: ( ( rule__JdlDtoGenerationSetting__IncludesAssignment_1 ) )
            // InternalJDL.g:4202:2: ( rule__JdlDtoGenerationSetting__IncludesAssignment_1 )
            {
             before(grammarAccess.getJdlDtoGenerationSettingAccess().getIncludesAssignment_1()); 
            // InternalJDL.g:4203:2: ( rule__JdlDtoGenerationSetting__IncludesAssignment_1 )
            // InternalJDL.g:4203:3: rule__JdlDtoGenerationSetting__IncludesAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__JdlDtoGenerationSetting__IncludesAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getJdlDtoGenerationSettingAccess().getIncludesAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlDtoGenerationSetting__Group__1__Impl"


    // $ANTLR start "rule__JdlDtoGenerationSetting__Group__2"
    // InternalJDL.g:4211:1: rule__JdlDtoGenerationSetting__Group__2 : rule__JdlDtoGenerationSetting__Group__2__Impl ;
    public final void rule__JdlDtoGenerationSetting__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4215:1: ( rule__JdlDtoGenerationSetting__Group__2__Impl )
            // InternalJDL.g:4216:2: rule__JdlDtoGenerationSetting__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JdlDtoGenerationSetting__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlDtoGenerationSetting__Group__2"


    // $ANTLR start "rule__JdlDtoGenerationSetting__Group__2__Impl"
    // InternalJDL.g:4222:1: rule__JdlDtoGenerationSetting__Group__2__Impl : ( ( rule__JdlDtoGenerationSetting__DtoTypeAssignment_2 ) ) ;
    public final void rule__JdlDtoGenerationSetting__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4226:1: ( ( ( rule__JdlDtoGenerationSetting__DtoTypeAssignment_2 ) ) )
            // InternalJDL.g:4227:1: ( ( rule__JdlDtoGenerationSetting__DtoTypeAssignment_2 ) )
            {
            // InternalJDL.g:4227:1: ( ( rule__JdlDtoGenerationSetting__DtoTypeAssignment_2 ) )
            // InternalJDL.g:4228:2: ( rule__JdlDtoGenerationSetting__DtoTypeAssignment_2 )
            {
             before(grammarAccess.getJdlDtoGenerationSettingAccess().getDtoTypeAssignment_2()); 
            // InternalJDL.g:4229:2: ( rule__JdlDtoGenerationSetting__DtoTypeAssignment_2 )
            // InternalJDL.g:4229:3: rule__JdlDtoGenerationSetting__DtoTypeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__JdlDtoGenerationSetting__DtoTypeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getJdlDtoGenerationSettingAccess().getDtoTypeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlDtoGenerationSetting__Group__2__Impl"


    // $ANTLR start "rule__JdlPaginateGenerationSetting__Group__0"
    // InternalJDL.g:4238:1: rule__JdlPaginateGenerationSetting__Group__0 : rule__JdlPaginateGenerationSetting__Group__0__Impl rule__JdlPaginateGenerationSetting__Group__1 ;
    public final void rule__JdlPaginateGenerationSetting__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4242:1: ( rule__JdlPaginateGenerationSetting__Group__0__Impl rule__JdlPaginateGenerationSetting__Group__1 )
            // InternalJDL.g:4243:2: rule__JdlPaginateGenerationSetting__Group__0__Impl rule__JdlPaginateGenerationSetting__Group__1
            {
            pushFollow(FOLLOW_25);
            rule__JdlPaginateGenerationSetting__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlPaginateGenerationSetting__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlPaginateGenerationSetting__Group__0"


    // $ANTLR start "rule__JdlPaginateGenerationSetting__Group__0__Impl"
    // InternalJDL.g:4250:1: rule__JdlPaginateGenerationSetting__Group__0__Impl : ( ( rule__JdlPaginateGenerationSetting__PaginateGenerationSettingAssignment_0 ) ) ;
    public final void rule__JdlPaginateGenerationSetting__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4254:1: ( ( ( rule__JdlPaginateGenerationSetting__PaginateGenerationSettingAssignment_0 ) ) )
            // InternalJDL.g:4255:1: ( ( rule__JdlPaginateGenerationSetting__PaginateGenerationSettingAssignment_0 ) )
            {
            // InternalJDL.g:4255:1: ( ( rule__JdlPaginateGenerationSetting__PaginateGenerationSettingAssignment_0 ) )
            // InternalJDL.g:4256:2: ( rule__JdlPaginateGenerationSetting__PaginateGenerationSettingAssignment_0 )
            {
             before(grammarAccess.getJdlPaginateGenerationSettingAccess().getPaginateGenerationSettingAssignment_0()); 
            // InternalJDL.g:4257:2: ( rule__JdlPaginateGenerationSetting__PaginateGenerationSettingAssignment_0 )
            // InternalJDL.g:4257:3: rule__JdlPaginateGenerationSetting__PaginateGenerationSettingAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__JdlPaginateGenerationSetting__PaginateGenerationSettingAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getJdlPaginateGenerationSettingAccess().getPaginateGenerationSettingAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlPaginateGenerationSetting__Group__0__Impl"


    // $ANTLR start "rule__JdlPaginateGenerationSetting__Group__1"
    // InternalJDL.g:4265:1: rule__JdlPaginateGenerationSetting__Group__1 : rule__JdlPaginateGenerationSetting__Group__1__Impl rule__JdlPaginateGenerationSetting__Group__2 ;
    public final void rule__JdlPaginateGenerationSetting__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4269:1: ( rule__JdlPaginateGenerationSetting__Group__1__Impl rule__JdlPaginateGenerationSetting__Group__2 )
            // InternalJDL.g:4270:2: rule__JdlPaginateGenerationSetting__Group__1__Impl rule__JdlPaginateGenerationSetting__Group__2
            {
            pushFollow(FOLLOW_28);
            rule__JdlPaginateGenerationSetting__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlPaginateGenerationSetting__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlPaginateGenerationSetting__Group__1"


    // $ANTLR start "rule__JdlPaginateGenerationSetting__Group__1__Impl"
    // InternalJDL.g:4277:1: rule__JdlPaginateGenerationSetting__Group__1__Impl : ( ( rule__JdlPaginateGenerationSetting__IncludesAssignment_1 ) ) ;
    public final void rule__JdlPaginateGenerationSetting__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4281:1: ( ( ( rule__JdlPaginateGenerationSetting__IncludesAssignment_1 ) ) )
            // InternalJDL.g:4282:1: ( ( rule__JdlPaginateGenerationSetting__IncludesAssignment_1 ) )
            {
            // InternalJDL.g:4282:1: ( ( rule__JdlPaginateGenerationSetting__IncludesAssignment_1 ) )
            // InternalJDL.g:4283:2: ( rule__JdlPaginateGenerationSetting__IncludesAssignment_1 )
            {
             before(grammarAccess.getJdlPaginateGenerationSettingAccess().getIncludesAssignment_1()); 
            // InternalJDL.g:4284:2: ( rule__JdlPaginateGenerationSetting__IncludesAssignment_1 )
            // InternalJDL.g:4284:3: rule__JdlPaginateGenerationSetting__IncludesAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__JdlPaginateGenerationSetting__IncludesAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getJdlPaginateGenerationSettingAccess().getIncludesAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlPaginateGenerationSetting__Group__1__Impl"


    // $ANTLR start "rule__JdlPaginateGenerationSetting__Group__2"
    // InternalJDL.g:4292:1: rule__JdlPaginateGenerationSetting__Group__2 : rule__JdlPaginateGenerationSetting__Group__2__Impl ;
    public final void rule__JdlPaginateGenerationSetting__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4296:1: ( rule__JdlPaginateGenerationSetting__Group__2__Impl )
            // InternalJDL.g:4297:2: rule__JdlPaginateGenerationSetting__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JdlPaginateGenerationSetting__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlPaginateGenerationSetting__Group__2"


    // $ANTLR start "rule__JdlPaginateGenerationSetting__Group__2__Impl"
    // InternalJDL.g:4303:1: rule__JdlPaginateGenerationSetting__Group__2__Impl : ( ( rule__JdlPaginateGenerationSetting__PaginateTypeAssignment_2 ) ) ;
    public final void rule__JdlPaginateGenerationSetting__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4307:1: ( ( ( rule__JdlPaginateGenerationSetting__PaginateTypeAssignment_2 ) ) )
            // InternalJDL.g:4308:1: ( ( rule__JdlPaginateGenerationSetting__PaginateTypeAssignment_2 ) )
            {
            // InternalJDL.g:4308:1: ( ( rule__JdlPaginateGenerationSetting__PaginateTypeAssignment_2 ) )
            // InternalJDL.g:4309:2: ( rule__JdlPaginateGenerationSetting__PaginateTypeAssignment_2 )
            {
             before(grammarAccess.getJdlPaginateGenerationSettingAccess().getPaginateTypeAssignment_2()); 
            // InternalJDL.g:4310:2: ( rule__JdlPaginateGenerationSetting__PaginateTypeAssignment_2 )
            // InternalJDL.g:4310:3: rule__JdlPaginateGenerationSetting__PaginateTypeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__JdlPaginateGenerationSetting__PaginateTypeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getJdlPaginateGenerationSettingAccess().getPaginateTypeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlPaginateGenerationSetting__Group__2__Impl"


    // $ANTLR start "rule__JdlAngularSuffixGenerationSetting__Group__0"
    // InternalJDL.g:4319:1: rule__JdlAngularSuffixGenerationSetting__Group__0 : rule__JdlAngularSuffixGenerationSetting__Group__0__Impl rule__JdlAngularSuffixGenerationSetting__Group__1 ;
    public final void rule__JdlAngularSuffixGenerationSetting__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4323:1: ( rule__JdlAngularSuffixGenerationSetting__Group__0__Impl rule__JdlAngularSuffixGenerationSetting__Group__1 )
            // InternalJDL.g:4324:2: rule__JdlAngularSuffixGenerationSetting__Group__0__Impl rule__JdlAngularSuffixGenerationSetting__Group__1
            {
            pushFollow(FOLLOW_25);
            rule__JdlAngularSuffixGenerationSetting__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlAngularSuffixGenerationSetting__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlAngularSuffixGenerationSetting__Group__0"


    // $ANTLR start "rule__JdlAngularSuffixGenerationSetting__Group__0__Impl"
    // InternalJDL.g:4331:1: rule__JdlAngularSuffixGenerationSetting__Group__0__Impl : ( ( rule__JdlAngularSuffixGenerationSetting__AngularSuffixGenerationSettingAssignment_0 ) ) ;
    public final void rule__JdlAngularSuffixGenerationSetting__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4335:1: ( ( ( rule__JdlAngularSuffixGenerationSetting__AngularSuffixGenerationSettingAssignment_0 ) ) )
            // InternalJDL.g:4336:1: ( ( rule__JdlAngularSuffixGenerationSetting__AngularSuffixGenerationSettingAssignment_0 ) )
            {
            // InternalJDL.g:4336:1: ( ( rule__JdlAngularSuffixGenerationSetting__AngularSuffixGenerationSettingAssignment_0 ) )
            // InternalJDL.g:4337:2: ( rule__JdlAngularSuffixGenerationSetting__AngularSuffixGenerationSettingAssignment_0 )
            {
             before(grammarAccess.getJdlAngularSuffixGenerationSettingAccess().getAngularSuffixGenerationSettingAssignment_0()); 
            // InternalJDL.g:4338:2: ( rule__JdlAngularSuffixGenerationSetting__AngularSuffixGenerationSettingAssignment_0 )
            // InternalJDL.g:4338:3: rule__JdlAngularSuffixGenerationSetting__AngularSuffixGenerationSettingAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__JdlAngularSuffixGenerationSetting__AngularSuffixGenerationSettingAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getJdlAngularSuffixGenerationSettingAccess().getAngularSuffixGenerationSettingAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlAngularSuffixGenerationSetting__Group__0__Impl"


    // $ANTLR start "rule__JdlAngularSuffixGenerationSetting__Group__1"
    // InternalJDL.g:4346:1: rule__JdlAngularSuffixGenerationSetting__Group__1 : rule__JdlAngularSuffixGenerationSetting__Group__1__Impl rule__JdlAngularSuffixGenerationSetting__Group__2 ;
    public final void rule__JdlAngularSuffixGenerationSetting__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4350:1: ( rule__JdlAngularSuffixGenerationSetting__Group__1__Impl rule__JdlAngularSuffixGenerationSetting__Group__2 )
            // InternalJDL.g:4351:2: rule__JdlAngularSuffixGenerationSetting__Group__1__Impl rule__JdlAngularSuffixGenerationSetting__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__JdlAngularSuffixGenerationSetting__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlAngularSuffixGenerationSetting__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlAngularSuffixGenerationSetting__Group__1"


    // $ANTLR start "rule__JdlAngularSuffixGenerationSetting__Group__1__Impl"
    // InternalJDL.g:4358:1: rule__JdlAngularSuffixGenerationSetting__Group__1__Impl : ( ( rule__JdlAngularSuffixGenerationSetting__IncludesAssignment_1 ) ) ;
    public final void rule__JdlAngularSuffixGenerationSetting__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4362:1: ( ( ( rule__JdlAngularSuffixGenerationSetting__IncludesAssignment_1 ) ) )
            // InternalJDL.g:4363:1: ( ( rule__JdlAngularSuffixGenerationSetting__IncludesAssignment_1 ) )
            {
            // InternalJDL.g:4363:1: ( ( rule__JdlAngularSuffixGenerationSetting__IncludesAssignment_1 ) )
            // InternalJDL.g:4364:2: ( rule__JdlAngularSuffixGenerationSetting__IncludesAssignment_1 )
            {
             before(grammarAccess.getJdlAngularSuffixGenerationSettingAccess().getIncludesAssignment_1()); 
            // InternalJDL.g:4365:2: ( rule__JdlAngularSuffixGenerationSetting__IncludesAssignment_1 )
            // InternalJDL.g:4365:3: rule__JdlAngularSuffixGenerationSetting__IncludesAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__JdlAngularSuffixGenerationSetting__IncludesAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getJdlAngularSuffixGenerationSettingAccess().getIncludesAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlAngularSuffixGenerationSetting__Group__1__Impl"


    // $ANTLR start "rule__JdlAngularSuffixGenerationSetting__Group__2"
    // InternalJDL.g:4373:1: rule__JdlAngularSuffixGenerationSetting__Group__2 : rule__JdlAngularSuffixGenerationSetting__Group__2__Impl ;
    public final void rule__JdlAngularSuffixGenerationSetting__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4377:1: ( rule__JdlAngularSuffixGenerationSetting__Group__2__Impl )
            // InternalJDL.g:4378:2: rule__JdlAngularSuffixGenerationSetting__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JdlAngularSuffixGenerationSetting__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlAngularSuffixGenerationSetting__Group__2"


    // $ANTLR start "rule__JdlAngularSuffixGenerationSetting__Group__2__Impl"
    // InternalJDL.g:4384:1: rule__JdlAngularSuffixGenerationSetting__Group__2__Impl : ( ( rule__JdlAngularSuffixGenerationSetting__IdAssignment_2 ) ) ;
    public final void rule__JdlAngularSuffixGenerationSetting__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4388:1: ( ( ( rule__JdlAngularSuffixGenerationSetting__IdAssignment_2 ) ) )
            // InternalJDL.g:4389:1: ( ( rule__JdlAngularSuffixGenerationSetting__IdAssignment_2 ) )
            {
            // InternalJDL.g:4389:1: ( ( rule__JdlAngularSuffixGenerationSetting__IdAssignment_2 ) )
            // InternalJDL.g:4390:2: ( rule__JdlAngularSuffixGenerationSetting__IdAssignment_2 )
            {
             before(grammarAccess.getJdlAngularSuffixGenerationSettingAccess().getIdAssignment_2()); 
            // InternalJDL.g:4391:2: ( rule__JdlAngularSuffixGenerationSetting__IdAssignment_2 )
            // InternalJDL.g:4391:3: rule__JdlAngularSuffixGenerationSetting__IdAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__JdlAngularSuffixGenerationSetting__IdAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getJdlAngularSuffixGenerationSettingAccess().getIdAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlAngularSuffixGenerationSetting__Group__2__Impl"


    // $ANTLR start "rule__JdlEntityInclusion__Group__0"
    // InternalJDL.g:4400:1: rule__JdlEntityInclusion__Group__0 : rule__JdlEntityInclusion__Group__0__Impl rule__JdlEntityInclusion__Group__1 ;
    public final void rule__JdlEntityInclusion__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4404:1: ( rule__JdlEntityInclusion__Group__0__Impl rule__JdlEntityInclusion__Group__1 )
            // InternalJDL.g:4405:2: rule__JdlEntityInclusion__Group__0__Impl rule__JdlEntityInclusion__Group__1
            {
            pushFollow(FOLLOW_29);
            rule__JdlEntityInclusion__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlEntityInclusion__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntityInclusion__Group__0"


    // $ANTLR start "rule__JdlEntityInclusion__Group__0__Impl"
    // InternalJDL.g:4412:1: rule__JdlEntityInclusion__Group__0__Impl : ( ( rule__JdlEntityInclusion__Alternatives_0 ) ) ;
    public final void rule__JdlEntityInclusion__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4416:1: ( ( ( rule__JdlEntityInclusion__Alternatives_0 ) ) )
            // InternalJDL.g:4417:1: ( ( rule__JdlEntityInclusion__Alternatives_0 ) )
            {
            // InternalJDL.g:4417:1: ( ( rule__JdlEntityInclusion__Alternatives_0 ) )
            // InternalJDL.g:4418:2: ( rule__JdlEntityInclusion__Alternatives_0 )
            {
             before(grammarAccess.getJdlEntityInclusionAccess().getAlternatives_0()); 
            // InternalJDL.g:4419:2: ( rule__JdlEntityInclusion__Alternatives_0 )
            // InternalJDL.g:4419:3: rule__JdlEntityInclusion__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__JdlEntityInclusion__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getJdlEntityInclusionAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntityInclusion__Group__0__Impl"


    // $ANTLR start "rule__JdlEntityInclusion__Group__1"
    // InternalJDL.g:4427:1: rule__JdlEntityInclusion__Group__1 : rule__JdlEntityInclusion__Group__1__Impl ;
    public final void rule__JdlEntityInclusion__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4431:1: ( rule__JdlEntityInclusion__Group__1__Impl )
            // InternalJDL.g:4432:2: rule__JdlEntityInclusion__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JdlEntityInclusion__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntityInclusion__Group__1"


    // $ANTLR start "rule__JdlEntityInclusion__Group__1__Impl"
    // InternalJDL.g:4438:1: rule__JdlEntityInclusion__Group__1__Impl : ( 'with' ) ;
    public final void rule__JdlEntityInclusion__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4442:1: ( ( 'with' ) )
            // InternalJDL.g:4443:1: ( 'with' )
            {
            // InternalJDL.g:4443:1: ( 'with' )
            // InternalJDL.g:4444:2: 'with'
            {
             before(grammarAccess.getJdlEntityInclusionAccess().getWithKeyword_1()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getJdlEntityInclusionAccess().getWithKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntityInclusion__Group__1__Impl"


    // $ANTLR start "rule__JdlEntityInclusion__Group_0_1__0"
    // InternalJDL.g:4454:1: rule__JdlEntityInclusion__Group_0_1__0 : rule__JdlEntityInclusion__Group_0_1__0__Impl rule__JdlEntityInclusion__Group_0_1__1 ;
    public final void rule__JdlEntityInclusion__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4458:1: ( rule__JdlEntityInclusion__Group_0_1__0__Impl rule__JdlEntityInclusion__Group_0_1__1 )
            // InternalJDL.g:4459:2: rule__JdlEntityInclusion__Group_0_1__0__Impl rule__JdlEntityInclusion__Group_0_1__1
            {
            pushFollow(FOLLOW_7);
            rule__JdlEntityInclusion__Group_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlEntityInclusion__Group_0_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntityInclusion__Group_0_1__0"


    // $ANTLR start "rule__JdlEntityInclusion__Group_0_1__0__Impl"
    // InternalJDL.g:4466:1: rule__JdlEntityInclusion__Group_0_1__0__Impl : ( ( rule__JdlEntityInclusion__EntitiesAssignment_0_1_0 ) ) ;
    public final void rule__JdlEntityInclusion__Group_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4470:1: ( ( ( rule__JdlEntityInclusion__EntitiesAssignment_0_1_0 ) ) )
            // InternalJDL.g:4471:1: ( ( rule__JdlEntityInclusion__EntitiesAssignment_0_1_0 ) )
            {
            // InternalJDL.g:4471:1: ( ( rule__JdlEntityInclusion__EntitiesAssignment_0_1_0 ) )
            // InternalJDL.g:4472:2: ( rule__JdlEntityInclusion__EntitiesAssignment_0_1_0 )
            {
             before(grammarAccess.getJdlEntityInclusionAccess().getEntitiesAssignment_0_1_0()); 
            // InternalJDL.g:4473:2: ( rule__JdlEntityInclusion__EntitiesAssignment_0_1_0 )
            // InternalJDL.g:4473:3: rule__JdlEntityInclusion__EntitiesAssignment_0_1_0
            {
            pushFollow(FOLLOW_2);
            rule__JdlEntityInclusion__EntitiesAssignment_0_1_0();

            state._fsp--;


            }

             after(grammarAccess.getJdlEntityInclusionAccess().getEntitiesAssignment_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntityInclusion__Group_0_1__0__Impl"


    // $ANTLR start "rule__JdlEntityInclusion__Group_0_1__1"
    // InternalJDL.g:4481:1: rule__JdlEntityInclusion__Group_0_1__1 : rule__JdlEntityInclusion__Group_0_1__1__Impl ;
    public final void rule__JdlEntityInclusion__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4485:1: ( rule__JdlEntityInclusion__Group_0_1__1__Impl )
            // InternalJDL.g:4486:2: rule__JdlEntityInclusion__Group_0_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JdlEntityInclusion__Group_0_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntityInclusion__Group_0_1__1"


    // $ANTLR start "rule__JdlEntityInclusion__Group_0_1__1__Impl"
    // InternalJDL.g:4492:1: rule__JdlEntityInclusion__Group_0_1__1__Impl : ( ( rule__JdlEntityInclusion__Group_0_1_1__0 )* ) ;
    public final void rule__JdlEntityInclusion__Group_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4496:1: ( ( ( rule__JdlEntityInclusion__Group_0_1_1__0 )* ) )
            // InternalJDL.g:4497:1: ( ( rule__JdlEntityInclusion__Group_0_1_1__0 )* )
            {
            // InternalJDL.g:4497:1: ( ( rule__JdlEntityInclusion__Group_0_1_1__0 )* )
            // InternalJDL.g:4498:2: ( rule__JdlEntityInclusion__Group_0_1_1__0 )*
            {
             before(grammarAccess.getJdlEntityInclusionAccess().getGroup_0_1_1()); 
            // InternalJDL.g:4499:2: ( rule__JdlEntityInclusion__Group_0_1_1__0 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==31) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalJDL.g:4499:3: rule__JdlEntityInclusion__Group_0_1_1__0
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__JdlEntityInclusion__Group_0_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

             after(grammarAccess.getJdlEntityInclusionAccess().getGroup_0_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntityInclusion__Group_0_1__1__Impl"


    // $ANTLR start "rule__JdlEntityInclusion__Group_0_1_1__0"
    // InternalJDL.g:4508:1: rule__JdlEntityInclusion__Group_0_1_1__0 : rule__JdlEntityInclusion__Group_0_1_1__0__Impl rule__JdlEntityInclusion__Group_0_1_1__1 ;
    public final void rule__JdlEntityInclusion__Group_0_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4512:1: ( rule__JdlEntityInclusion__Group_0_1_1__0__Impl rule__JdlEntityInclusion__Group_0_1_1__1 )
            // InternalJDL.g:4513:2: rule__JdlEntityInclusion__Group_0_1_1__0__Impl rule__JdlEntityInclusion__Group_0_1_1__1
            {
            pushFollow(FOLLOW_4);
            rule__JdlEntityInclusion__Group_0_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlEntityInclusion__Group_0_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntityInclusion__Group_0_1_1__0"


    // $ANTLR start "rule__JdlEntityInclusion__Group_0_1_1__0__Impl"
    // InternalJDL.g:4520:1: rule__JdlEntityInclusion__Group_0_1_1__0__Impl : ( ',' ) ;
    public final void rule__JdlEntityInclusion__Group_0_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4524:1: ( ( ',' ) )
            // InternalJDL.g:4525:1: ( ',' )
            {
            // InternalJDL.g:4525:1: ( ',' )
            // InternalJDL.g:4526:2: ','
            {
             before(grammarAccess.getJdlEntityInclusionAccess().getCommaKeyword_0_1_1_0()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getJdlEntityInclusionAccess().getCommaKeyword_0_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntityInclusion__Group_0_1_1__0__Impl"


    // $ANTLR start "rule__JdlEntityInclusion__Group_0_1_1__1"
    // InternalJDL.g:4535:1: rule__JdlEntityInclusion__Group_0_1_1__1 : rule__JdlEntityInclusion__Group_0_1_1__1__Impl ;
    public final void rule__JdlEntityInclusion__Group_0_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4539:1: ( rule__JdlEntityInclusion__Group_0_1_1__1__Impl )
            // InternalJDL.g:4540:2: rule__JdlEntityInclusion__Group_0_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JdlEntityInclusion__Group_0_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntityInclusion__Group_0_1_1__1"


    // $ANTLR start "rule__JdlEntityInclusion__Group_0_1_1__1__Impl"
    // InternalJDL.g:4546:1: rule__JdlEntityInclusion__Group_0_1_1__1__Impl : ( ( rule__JdlEntityInclusion__EntitiesAssignment_0_1_1_1 ) ) ;
    public final void rule__JdlEntityInclusion__Group_0_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4550:1: ( ( ( rule__JdlEntityInclusion__EntitiesAssignment_0_1_1_1 ) ) )
            // InternalJDL.g:4551:1: ( ( rule__JdlEntityInclusion__EntitiesAssignment_0_1_1_1 ) )
            {
            // InternalJDL.g:4551:1: ( ( rule__JdlEntityInclusion__EntitiesAssignment_0_1_1_1 ) )
            // InternalJDL.g:4552:2: ( rule__JdlEntityInclusion__EntitiesAssignment_0_1_1_1 )
            {
             before(grammarAccess.getJdlEntityInclusionAccess().getEntitiesAssignment_0_1_1_1()); 
            // InternalJDL.g:4553:2: ( rule__JdlEntityInclusion__EntitiesAssignment_0_1_1_1 )
            // InternalJDL.g:4553:3: rule__JdlEntityInclusion__EntitiesAssignment_0_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__JdlEntityInclusion__EntitiesAssignment_0_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getJdlEntityInclusionAccess().getEntitiesAssignment_0_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntityInclusion__Group_0_1_1__1__Impl"


    // $ANTLR start "rule__JdlEntityExclusion__Group__0"
    // InternalJDL.g:4562:1: rule__JdlEntityExclusion__Group__0 : rule__JdlEntityExclusion__Group__0__Impl rule__JdlEntityExclusion__Group__1 ;
    public final void rule__JdlEntityExclusion__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4566:1: ( rule__JdlEntityExclusion__Group__0__Impl rule__JdlEntityExclusion__Group__1 )
            // InternalJDL.g:4567:2: rule__JdlEntityExclusion__Group__0__Impl rule__JdlEntityExclusion__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__JdlEntityExclusion__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlEntityExclusion__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntityExclusion__Group__0"


    // $ANTLR start "rule__JdlEntityExclusion__Group__0__Impl"
    // InternalJDL.g:4574:1: rule__JdlEntityExclusion__Group__0__Impl : ( 'except' ) ;
    public final void rule__JdlEntityExclusion__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4578:1: ( ( 'except' ) )
            // InternalJDL.g:4579:1: ( 'except' )
            {
            // InternalJDL.g:4579:1: ( 'except' )
            // InternalJDL.g:4580:2: 'except'
            {
             before(grammarAccess.getJdlEntityExclusionAccess().getExceptKeyword_0()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getJdlEntityExclusionAccess().getExceptKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntityExclusion__Group__0__Impl"


    // $ANTLR start "rule__JdlEntityExclusion__Group__1"
    // InternalJDL.g:4589:1: rule__JdlEntityExclusion__Group__1 : rule__JdlEntityExclusion__Group__1__Impl rule__JdlEntityExclusion__Group__2 ;
    public final void rule__JdlEntityExclusion__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4593:1: ( rule__JdlEntityExclusion__Group__1__Impl rule__JdlEntityExclusion__Group__2 )
            // InternalJDL.g:4594:2: rule__JdlEntityExclusion__Group__1__Impl rule__JdlEntityExclusion__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__JdlEntityExclusion__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlEntityExclusion__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntityExclusion__Group__1"


    // $ANTLR start "rule__JdlEntityExclusion__Group__1__Impl"
    // InternalJDL.g:4601:1: rule__JdlEntityExclusion__Group__1__Impl : ( ( rule__JdlEntityExclusion__EntitiesAssignment_1 ) ) ;
    public final void rule__JdlEntityExclusion__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4605:1: ( ( ( rule__JdlEntityExclusion__EntitiesAssignment_1 ) ) )
            // InternalJDL.g:4606:1: ( ( rule__JdlEntityExclusion__EntitiesAssignment_1 ) )
            {
            // InternalJDL.g:4606:1: ( ( rule__JdlEntityExclusion__EntitiesAssignment_1 ) )
            // InternalJDL.g:4607:2: ( rule__JdlEntityExclusion__EntitiesAssignment_1 )
            {
             before(grammarAccess.getJdlEntityExclusionAccess().getEntitiesAssignment_1()); 
            // InternalJDL.g:4608:2: ( rule__JdlEntityExclusion__EntitiesAssignment_1 )
            // InternalJDL.g:4608:3: rule__JdlEntityExclusion__EntitiesAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__JdlEntityExclusion__EntitiesAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getJdlEntityExclusionAccess().getEntitiesAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntityExclusion__Group__1__Impl"


    // $ANTLR start "rule__JdlEntityExclusion__Group__2"
    // InternalJDL.g:4616:1: rule__JdlEntityExclusion__Group__2 : rule__JdlEntityExclusion__Group__2__Impl ;
    public final void rule__JdlEntityExclusion__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4620:1: ( rule__JdlEntityExclusion__Group__2__Impl )
            // InternalJDL.g:4621:2: rule__JdlEntityExclusion__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JdlEntityExclusion__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntityExclusion__Group__2"


    // $ANTLR start "rule__JdlEntityExclusion__Group__2__Impl"
    // InternalJDL.g:4627:1: rule__JdlEntityExclusion__Group__2__Impl : ( ( rule__JdlEntityExclusion__Group_2__0 )* ) ;
    public final void rule__JdlEntityExclusion__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4631:1: ( ( ( rule__JdlEntityExclusion__Group_2__0 )* ) )
            // InternalJDL.g:4632:1: ( ( rule__JdlEntityExclusion__Group_2__0 )* )
            {
            // InternalJDL.g:4632:1: ( ( rule__JdlEntityExclusion__Group_2__0 )* )
            // InternalJDL.g:4633:2: ( rule__JdlEntityExclusion__Group_2__0 )*
            {
             before(grammarAccess.getJdlEntityExclusionAccess().getGroup_2()); 
            // InternalJDL.g:4634:2: ( rule__JdlEntityExclusion__Group_2__0 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==31) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalJDL.g:4634:3: rule__JdlEntityExclusion__Group_2__0
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__JdlEntityExclusion__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

             after(grammarAccess.getJdlEntityExclusionAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntityExclusion__Group__2__Impl"


    // $ANTLR start "rule__JdlEntityExclusion__Group_2__0"
    // InternalJDL.g:4643:1: rule__JdlEntityExclusion__Group_2__0 : rule__JdlEntityExclusion__Group_2__0__Impl rule__JdlEntityExclusion__Group_2__1 ;
    public final void rule__JdlEntityExclusion__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4647:1: ( rule__JdlEntityExclusion__Group_2__0__Impl rule__JdlEntityExclusion__Group_2__1 )
            // InternalJDL.g:4648:2: rule__JdlEntityExclusion__Group_2__0__Impl rule__JdlEntityExclusion__Group_2__1
            {
            pushFollow(FOLLOW_4);
            rule__JdlEntityExclusion__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JdlEntityExclusion__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntityExclusion__Group_2__0"


    // $ANTLR start "rule__JdlEntityExclusion__Group_2__0__Impl"
    // InternalJDL.g:4655:1: rule__JdlEntityExclusion__Group_2__0__Impl : ( ',' ) ;
    public final void rule__JdlEntityExclusion__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4659:1: ( ( ',' ) )
            // InternalJDL.g:4660:1: ( ',' )
            {
            // InternalJDL.g:4660:1: ( ',' )
            // InternalJDL.g:4661:2: ','
            {
             before(grammarAccess.getJdlEntityExclusionAccess().getCommaKeyword_2_0()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getJdlEntityExclusionAccess().getCommaKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntityExclusion__Group_2__0__Impl"


    // $ANTLR start "rule__JdlEntityExclusion__Group_2__1"
    // InternalJDL.g:4670:1: rule__JdlEntityExclusion__Group_2__1 : rule__JdlEntityExclusion__Group_2__1__Impl ;
    public final void rule__JdlEntityExclusion__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4674:1: ( rule__JdlEntityExclusion__Group_2__1__Impl )
            // InternalJDL.g:4675:2: rule__JdlEntityExclusion__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JdlEntityExclusion__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntityExclusion__Group_2__1"


    // $ANTLR start "rule__JdlEntityExclusion__Group_2__1__Impl"
    // InternalJDL.g:4681:1: rule__JdlEntityExclusion__Group_2__1__Impl : ( ( rule__JdlEntityExclusion__EntitiesAssignment_2_1 ) ) ;
    public final void rule__JdlEntityExclusion__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4685:1: ( ( ( rule__JdlEntityExclusion__EntitiesAssignment_2_1 ) ) )
            // InternalJDL.g:4686:1: ( ( rule__JdlEntityExclusion__EntitiesAssignment_2_1 ) )
            {
            // InternalJDL.g:4686:1: ( ( rule__JdlEntityExclusion__EntitiesAssignment_2_1 ) )
            // InternalJDL.g:4687:2: ( rule__JdlEntityExclusion__EntitiesAssignment_2_1 )
            {
             before(grammarAccess.getJdlEntityExclusionAccess().getEntitiesAssignment_2_1()); 
            // InternalJDL.g:4688:2: ( rule__JdlEntityExclusion__EntitiesAssignment_2_1 )
            // InternalJDL.g:4688:3: rule__JdlEntityExclusion__EntitiesAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__JdlEntityExclusion__EntitiesAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getJdlEntityExclusionAccess().getEntitiesAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntityExclusion__Group_2__1__Impl"


    // $ANTLR start "rule__JdlDomainModel__FeaturesAssignment"
    // InternalJDL.g:4697:1: rule__JdlDomainModel__FeaturesAssignment : ( ruleJdlFeature ) ;
    public final void rule__JdlDomainModel__FeaturesAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4701:1: ( ( ruleJdlFeature ) )
            // InternalJDL.g:4702:2: ( ruleJdlFeature )
            {
            // InternalJDL.g:4702:2: ( ruleJdlFeature )
            // InternalJDL.g:4703:3: ruleJdlFeature
            {
             before(grammarAccess.getJdlDomainModelAccess().getFeaturesJdlFeatureParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleJdlFeature();

            state._fsp--;

             after(grammarAccess.getJdlDomainModelAccess().getFeaturesJdlFeatureParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlDomainModel__FeaturesAssignment"


    // $ANTLR start "rule__JdlEntity__NameAssignment_1"
    // InternalJDL.g:4712:1: rule__JdlEntity__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__JdlEntity__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4716:1: ( ( RULE_ID ) )
            // InternalJDL.g:4717:2: ( RULE_ID )
            {
            // InternalJDL.g:4717:2: ( RULE_ID )
            // InternalJDL.g:4718:3: RULE_ID
            {
             before(grammarAccess.getJdlEntityAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getJdlEntityAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntity__NameAssignment_1"


    // $ANTLR start "rule__JdlEntity__FieldsAssignment_2_1_0"
    // InternalJDL.g:4727:1: rule__JdlEntity__FieldsAssignment_2_1_0 : ( ruleJdlEntityField ) ;
    public final void rule__JdlEntity__FieldsAssignment_2_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4731:1: ( ( ruleJdlEntityField ) )
            // InternalJDL.g:4732:2: ( ruleJdlEntityField )
            {
            // InternalJDL.g:4732:2: ( ruleJdlEntityField )
            // InternalJDL.g:4733:3: ruleJdlEntityField
            {
             before(grammarAccess.getJdlEntityAccess().getFieldsJdlEntityFieldParserRuleCall_2_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleJdlEntityField();

            state._fsp--;

             after(grammarAccess.getJdlEntityAccess().getFieldsJdlEntityFieldParserRuleCall_2_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntity__FieldsAssignment_2_1_0"


    // $ANTLR start "rule__JdlEntity__FieldsAssignment_2_1_1_1"
    // InternalJDL.g:4742:1: rule__JdlEntity__FieldsAssignment_2_1_1_1 : ( ruleJdlEntityField ) ;
    public final void rule__JdlEntity__FieldsAssignment_2_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4746:1: ( ( ruleJdlEntityField ) )
            // InternalJDL.g:4747:2: ( ruleJdlEntityField )
            {
            // InternalJDL.g:4747:2: ( ruleJdlEntityField )
            // InternalJDL.g:4748:3: ruleJdlEntityField
            {
             before(grammarAccess.getJdlEntityAccess().getFieldsJdlEntityFieldParserRuleCall_2_1_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleJdlEntityField();

            state._fsp--;

             after(grammarAccess.getJdlEntityAccess().getFieldsJdlEntityFieldParserRuleCall_2_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntity__FieldsAssignment_2_1_1_1"


    // $ANTLR start "rule__JdlEntityField__NameAssignment_0"
    // InternalJDL.g:4757:1: rule__JdlEntityField__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__JdlEntityField__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4761:1: ( ( RULE_ID ) )
            // InternalJDL.g:4762:2: ( RULE_ID )
            {
            // InternalJDL.g:4762:2: ( RULE_ID )
            // InternalJDL.g:4763:3: RULE_ID
            {
             before(grammarAccess.getJdlEntityFieldAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getJdlEntityFieldAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntityField__NameAssignment_0"


    // $ANTLR start "rule__JdlEntityField__TypeAssignment_1"
    // InternalJDL.g:4772:1: rule__JdlEntityField__TypeAssignment_1 : ( ruleJdlFieldType ) ;
    public final void rule__JdlEntityField__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4776:1: ( ( ruleJdlFieldType ) )
            // InternalJDL.g:4777:2: ( ruleJdlFieldType )
            {
            // InternalJDL.g:4777:2: ( ruleJdlFieldType )
            // InternalJDL.g:4778:3: ruleJdlFieldType
            {
             before(grammarAccess.getJdlEntityFieldAccess().getTypeJdlFieldTypeParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleJdlFieldType();

            state._fsp--;

             after(grammarAccess.getJdlEntityFieldAccess().getTypeJdlFieldTypeParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntityField__TypeAssignment_1"


    // $ANTLR start "rule__JdlEnumField__EnumTypeAssignment_0"
    // InternalJDL.g:4787:1: rule__JdlEnumField__EnumTypeAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__JdlEnumField__EnumTypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4791:1: ( ( ( RULE_ID ) ) )
            // InternalJDL.g:4792:2: ( ( RULE_ID ) )
            {
            // InternalJDL.g:4792:2: ( ( RULE_ID ) )
            // InternalJDL.g:4793:3: ( RULE_ID )
            {
             before(grammarAccess.getJdlEnumFieldAccess().getEnumTypeJdlEnumTypeCrossReference_0_0()); 
            // InternalJDL.g:4794:3: ( RULE_ID )
            // InternalJDL.g:4795:4: RULE_ID
            {
             before(grammarAccess.getJdlEnumFieldAccess().getEnumTypeJdlEnumTypeIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getJdlEnumFieldAccess().getEnumTypeJdlEnumTypeIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getJdlEnumFieldAccess().getEnumTypeJdlEnumTypeCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEnumField__EnumTypeAssignment_0"


    // $ANTLR start "rule__JdlEnumField__ValidatorsAssignment_1"
    // InternalJDL.g:4806:1: rule__JdlEnumField__ValidatorsAssignment_1 : ( ruleJdlRequiredValidator ) ;
    public final void rule__JdlEnumField__ValidatorsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4810:1: ( ( ruleJdlRequiredValidator ) )
            // InternalJDL.g:4811:2: ( ruleJdlRequiredValidator )
            {
            // InternalJDL.g:4811:2: ( ruleJdlRequiredValidator )
            // InternalJDL.g:4812:3: ruleJdlRequiredValidator
            {
             before(grammarAccess.getJdlEnumFieldAccess().getValidatorsJdlRequiredValidatorParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleJdlRequiredValidator();

            state._fsp--;

             after(grammarAccess.getJdlEnumFieldAccess().getValidatorsJdlRequiredValidatorParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEnumField__ValidatorsAssignment_1"


    // $ANTLR start "rule__JdlStringField__StringTypeAssignment_0"
    // InternalJDL.g:4821:1: rule__JdlStringField__StringTypeAssignment_0 : ( ( 'String' ) ) ;
    public final void rule__JdlStringField__StringTypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4825:1: ( ( ( 'String' ) ) )
            // InternalJDL.g:4826:2: ( ( 'String' ) )
            {
            // InternalJDL.g:4826:2: ( ( 'String' ) )
            // InternalJDL.g:4827:3: ( 'String' )
            {
             before(grammarAccess.getJdlStringFieldAccess().getStringTypeStringKeyword_0_0()); 
            // InternalJDL.g:4828:3: ( 'String' )
            // InternalJDL.g:4829:4: 'String'
            {
             before(grammarAccess.getJdlStringFieldAccess().getStringTypeStringKeyword_0_0()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getJdlStringFieldAccess().getStringTypeStringKeyword_0_0()); 

            }

             after(grammarAccess.getJdlStringFieldAccess().getStringTypeStringKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlStringField__StringTypeAssignment_0"


    // $ANTLR start "rule__JdlStringField__ValidatorsAssignment_1"
    // InternalJDL.g:4840:1: rule__JdlStringField__ValidatorsAssignment_1 : ( ruleJdlStringValidators ) ;
    public final void rule__JdlStringField__ValidatorsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4844:1: ( ( ruleJdlStringValidators ) )
            // InternalJDL.g:4845:2: ( ruleJdlStringValidators )
            {
            // InternalJDL.g:4845:2: ( ruleJdlStringValidators )
            // InternalJDL.g:4846:3: ruleJdlStringValidators
            {
             before(grammarAccess.getJdlStringFieldAccess().getValidatorsJdlStringValidatorsParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleJdlStringValidators();

            state._fsp--;

             after(grammarAccess.getJdlStringFieldAccess().getValidatorsJdlStringValidatorsParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlStringField__ValidatorsAssignment_1"


    // $ANTLR start "rule__JdlNumericField__NumericFieldTypeAssignment_0"
    // InternalJDL.g:4855:1: rule__JdlNumericField__NumericFieldTypeAssignment_0 : ( ruleJdlNumericFieldType ) ;
    public final void rule__JdlNumericField__NumericFieldTypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4859:1: ( ( ruleJdlNumericFieldType ) )
            // InternalJDL.g:4860:2: ( ruleJdlNumericFieldType )
            {
            // InternalJDL.g:4860:2: ( ruleJdlNumericFieldType )
            // InternalJDL.g:4861:3: ruleJdlNumericFieldType
            {
             before(grammarAccess.getJdlNumericFieldAccess().getNumericFieldTypeJdlNumericFieldTypeEnumRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleJdlNumericFieldType();

            state._fsp--;

             after(grammarAccess.getJdlNumericFieldAccess().getNumericFieldTypeJdlNumericFieldTypeEnumRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlNumericField__NumericFieldTypeAssignment_0"


    // $ANTLR start "rule__JdlNumericField__ValidatorsAssignment_1"
    // InternalJDL.g:4870:1: rule__JdlNumericField__ValidatorsAssignment_1 : ( ruleJdlNumericValidators ) ;
    public final void rule__JdlNumericField__ValidatorsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4874:1: ( ( ruleJdlNumericValidators ) )
            // InternalJDL.g:4875:2: ( ruleJdlNumericValidators )
            {
            // InternalJDL.g:4875:2: ( ruleJdlNumericValidators )
            // InternalJDL.g:4876:3: ruleJdlNumericValidators
            {
             before(grammarAccess.getJdlNumericFieldAccess().getValidatorsJdlNumericValidatorsParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleJdlNumericValidators();

            state._fsp--;

             after(grammarAccess.getJdlNumericFieldAccess().getValidatorsJdlNumericValidatorsParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlNumericField__ValidatorsAssignment_1"


    // $ANTLR start "rule__JdlBooleanField__BooleanTypeAssignment_0"
    // InternalJDL.g:4885:1: rule__JdlBooleanField__BooleanTypeAssignment_0 : ( ( 'Boolean' ) ) ;
    public final void rule__JdlBooleanField__BooleanTypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4889:1: ( ( ( 'Boolean' ) ) )
            // InternalJDL.g:4890:2: ( ( 'Boolean' ) )
            {
            // InternalJDL.g:4890:2: ( ( 'Boolean' ) )
            // InternalJDL.g:4891:3: ( 'Boolean' )
            {
             before(grammarAccess.getJdlBooleanFieldAccess().getBooleanTypeBooleanKeyword_0_0()); 
            // InternalJDL.g:4892:3: ( 'Boolean' )
            // InternalJDL.g:4893:4: 'Boolean'
            {
             before(grammarAccess.getJdlBooleanFieldAccess().getBooleanTypeBooleanKeyword_0_0()); 
            match(input,47,FOLLOW_2); 
             after(grammarAccess.getJdlBooleanFieldAccess().getBooleanTypeBooleanKeyword_0_0()); 

            }

             after(grammarAccess.getJdlBooleanFieldAccess().getBooleanTypeBooleanKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlBooleanField__BooleanTypeAssignment_0"


    // $ANTLR start "rule__JdlBooleanField__ValidatorsAssignment_1"
    // InternalJDL.g:4904:1: rule__JdlBooleanField__ValidatorsAssignment_1 : ( ruleJdlRequiredValidator ) ;
    public final void rule__JdlBooleanField__ValidatorsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4908:1: ( ( ruleJdlRequiredValidator ) )
            // InternalJDL.g:4909:2: ( ruleJdlRequiredValidator )
            {
            // InternalJDL.g:4909:2: ( ruleJdlRequiredValidator )
            // InternalJDL.g:4910:3: ruleJdlRequiredValidator
            {
             before(grammarAccess.getJdlBooleanFieldAccess().getValidatorsJdlRequiredValidatorParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleJdlRequiredValidator();

            state._fsp--;

             after(grammarAccess.getJdlBooleanFieldAccess().getValidatorsJdlRequiredValidatorParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlBooleanField__ValidatorsAssignment_1"


    // $ANTLR start "rule__JdlDateField__LocalDateTypeAssignment_0_0"
    // InternalJDL.g:4919:1: rule__JdlDateField__LocalDateTypeAssignment_0_0 : ( ( 'LocalDate' ) ) ;
    public final void rule__JdlDateField__LocalDateTypeAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4923:1: ( ( ( 'LocalDate' ) ) )
            // InternalJDL.g:4924:2: ( ( 'LocalDate' ) )
            {
            // InternalJDL.g:4924:2: ( ( 'LocalDate' ) )
            // InternalJDL.g:4925:3: ( 'LocalDate' )
            {
             before(grammarAccess.getJdlDateFieldAccess().getLocalDateTypeLocalDateKeyword_0_0_0()); 
            // InternalJDL.g:4926:3: ( 'LocalDate' )
            // InternalJDL.g:4927:4: 'LocalDate'
            {
             before(grammarAccess.getJdlDateFieldAccess().getLocalDateTypeLocalDateKeyword_0_0_0()); 
            match(input,48,FOLLOW_2); 
             after(grammarAccess.getJdlDateFieldAccess().getLocalDateTypeLocalDateKeyword_0_0_0()); 

            }

             after(grammarAccess.getJdlDateFieldAccess().getLocalDateTypeLocalDateKeyword_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlDateField__LocalDateTypeAssignment_0_0"


    // $ANTLR start "rule__JdlDateField__ZonedDateTimeTypeAssignment_0_1"
    // InternalJDL.g:4938:1: rule__JdlDateField__ZonedDateTimeTypeAssignment_0_1 : ( ( 'ZonedDateTime' ) ) ;
    public final void rule__JdlDateField__ZonedDateTimeTypeAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4942:1: ( ( ( 'ZonedDateTime' ) ) )
            // InternalJDL.g:4943:2: ( ( 'ZonedDateTime' ) )
            {
            // InternalJDL.g:4943:2: ( ( 'ZonedDateTime' ) )
            // InternalJDL.g:4944:3: ( 'ZonedDateTime' )
            {
             before(grammarAccess.getJdlDateFieldAccess().getZonedDateTimeTypeZonedDateTimeKeyword_0_1_0()); 
            // InternalJDL.g:4945:3: ( 'ZonedDateTime' )
            // InternalJDL.g:4946:4: 'ZonedDateTime'
            {
             before(grammarAccess.getJdlDateFieldAccess().getZonedDateTimeTypeZonedDateTimeKeyword_0_1_0()); 
            match(input,49,FOLLOW_2); 
             after(grammarAccess.getJdlDateFieldAccess().getZonedDateTimeTypeZonedDateTimeKeyword_0_1_0()); 

            }

             after(grammarAccess.getJdlDateFieldAccess().getZonedDateTimeTypeZonedDateTimeKeyword_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlDateField__ZonedDateTimeTypeAssignment_0_1"


    // $ANTLR start "rule__JdlDateField__ValidatorsAssignment_1"
    // InternalJDL.g:4957:1: rule__JdlDateField__ValidatorsAssignment_1 : ( ruleJdlRequiredValidator ) ;
    public final void rule__JdlDateField__ValidatorsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4961:1: ( ( ruleJdlRequiredValidator ) )
            // InternalJDL.g:4962:2: ( ruleJdlRequiredValidator )
            {
            // InternalJDL.g:4962:2: ( ruleJdlRequiredValidator )
            // InternalJDL.g:4963:3: ruleJdlRequiredValidator
            {
             before(grammarAccess.getJdlDateFieldAccess().getValidatorsJdlRequiredValidatorParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleJdlRequiredValidator();

            state._fsp--;

             after(grammarAccess.getJdlDateFieldAccess().getValidatorsJdlRequiredValidatorParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlDateField__ValidatorsAssignment_1"


    // $ANTLR start "rule__JdlBlobField__BlobFieldTypeAssignment_0"
    // InternalJDL.g:4972:1: rule__JdlBlobField__BlobFieldTypeAssignment_0 : ( ruleJdlBlobFieldType ) ;
    public final void rule__JdlBlobField__BlobFieldTypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4976:1: ( ( ruleJdlBlobFieldType ) )
            // InternalJDL.g:4977:2: ( ruleJdlBlobFieldType )
            {
            // InternalJDL.g:4977:2: ( ruleJdlBlobFieldType )
            // InternalJDL.g:4978:3: ruleJdlBlobFieldType
            {
             before(grammarAccess.getJdlBlobFieldAccess().getBlobFieldTypeJdlBlobFieldTypeEnumRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleJdlBlobFieldType();

            state._fsp--;

             after(grammarAccess.getJdlBlobFieldAccess().getBlobFieldTypeJdlBlobFieldTypeEnumRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlBlobField__BlobFieldTypeAssignment_0"


    // $ANTLR start "rule__JdlBlobField__ValidatorsAssignment_1"
    // InternalJDL.g:4987:1: rule__JdlBlobField__ValidatorsAssignment_1 : ( ruleJdlBlobValidators ) ;
    public final void rule__JdlBlobField__ValidatorsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:4991:1: ( ( ruleJdlBlobValidators ) )
            // InternalJDL.g:4992:2: ( ruleJdlBlobValidators )
            {
            // InternalJDL.g:4992:2: ( ruleJdlBlobValidators )
            // InternalJDL.g:4993:3: ruleJdlBlobValidators
            {
             before(grammarAccess.getJdlBlobFieldAccess().getValidatorsJdlBlobValidatorsParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleJdlBlobValidators();

            state._fsp--;

             after(grammarAccess.getJdlBlobFieldAccess().getValidatorsJdlBlobValidatorsParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlBlobField__ValidatorsAssignment_1"


    // $ANTLR start "rule__JdlStringValidators__RequiredAssignment_0"
    // InternalJDL.g:5002:1: rule__JdlStringValidators__RequiredAssignment_0 : ( ruleJdlRequiredValidator ) ;
    public final void rule__JdlStringValidators__RequiredAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5006:1: ( ( ruleJdlRequiredValidator ) )
            // InternalJDL.g:5007:2: ( ruleJdlRequiredValidator )
            {
            // InternalJDL.g:5007:2: ( ruleJdlRequiredValidator )
            // InternalJDL.g:5008:3: ruleJdlRequiredValidator
            {
             before(grammarAccess.getJdlStringValidatorsAccess().getRequiredJdlRequiredValidatorParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleJdlRequiredValidator();

            state._fsp--;

             after(grammarAccess.getJdlStringValidatorsAccess().getRequiredJdlRequiredValidatorParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlStringValidators__RequiredAssignment_0"


    // $ANTLR start "rule__JdlStringValidators__MinLengthAssignment_1"
    // InternalJDL.g:5017:1: rule__JdlStringValidators__MinLengthAssignment_1 : ( ruleJdlMinLengthValidator ) ;
    public final void rule__JdlStringValidators__MinLengthAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5021:1: ( ( ruleJdlMinLengthValidator ) )
            // InternalJDL.g:5022:2: ( ruleJdlMinLengthValidator )
            {
            // InternalJDL.g:5022:2: ( ruleJdlMinLengthValidator )
            // InternalJDL.g:5023:3: ruleJdlMinLengthValidator
            {
             before(grammarAccess.getJdlStringValidatorsAccess().getMinLengthJdlMinLengthValidatorParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleJdlMinLengthValidator();

            state._fsp--;

             after(grammarAccess.getJdlStringValidatorsAccess().getMinLengthJdlMinLengthValidatorParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlStringValidators__MinLengthAssignment_1"


    // $ANTLR start "rule__JdlStringValidators__MaxlengthAssignment_2"
    // InternalJDL.g:5032:1: rule__JdlStringValidators__MaxlengthAssignment_2 : ( ruleJdlMaxLengthValidator ) ;
    public final void rule__JdlStringValidators__MaxlengthAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5036:1: ( ( ruleJdlMaxLengthValidator ) )
            // InternalJDL.g:5037:2: ( ruleJdlMaxLengthValidator )
            {
            // InternalJDL.g:5037:2: ( ruleJdlMaxLengthValidator )
            // InternalJDL.g:5038:3: ruleJdlMaxLengthValidator
            {
             before(grammarAccess.getJdlStringValidatorsAccess().getMaxlengthJdlMaxLengthValidatorParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleJdlMaxLengthValidator();

            state._fsp--;

             after(grammarAccess.getJdlStringValidatorsAccess().getMaxlengthJdlMaxLengthValidatorParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlStringValidators__MaxlengthAssignment_2"


    // $ANTLR start "rule__JdlStringValidators__PatternAssignment_3"
    // InternalJDL.g:5047:1: rule__JdlStringValidators__PatternAssignment_3 : ( ruleJdlPatternValidator ) ;
    public final void rule__JdlStringValidators__PatternAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5051:1: ( ( ruleJdlPatternValidator ) )
            // InternalJDL.g:5052:2: ( ruleJdlPatternValidator )
            {
            // InternalJDL.g:5052:2: ( ruleJdlPatternValidator )
            // InternalJDL.g:5053:3: ruleJdlPatternValidator
            {
             before(grammarAccess.getJdlStringValidatorsAccess().getPatternJdlPatternValidatorParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleJdlPatternValidator();

            state._fsp--;

             after(grammarAccess.getJdlStringValidatorsAccess().getPatternJdlPatternValidatorParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlStringValidators__PatternAssignment_3"


    // $ANTLR start "rule__JdlNumericValidators__RequiredAssignment_0"
    // InternalJDL.g:5062:1: rule__JdlNumericValidators__RequiredAssignment_0 : ( ruleJdlRequiredValidator ) ;
    public final void rule__JdlNumericValidators__RequiredAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5066:1: ( ( ruleJdlRequiredValidator ) )
            // InternalJDL.g:5067:2: ( ruleJdlRequiredValidator )
            {
            // InternalJDL.g:5067:2: ( ruleJdlRequiredValidator )
            // InternalJDL.g:5068:3: ruleJdlRequiredValidator
            {
             before(grammarAccess.getJdlNumericValidatorsAccess().getRequiredJdlRequiredValidatorParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleJdlRequiredValidator();

            state._fsp--;

             after(grammarAccess.getJdlNumericValidatorsAccess().getRequiredJdlRequiredValidatorParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlNumericValidators__RequiredAssignment_0"


    // $ANTLR start "rule__JdlNumericValidators__MinlengthAssignment_1"
    // InternalJDL.g:5077:1: rule__JdlNumericValidators__MinlengthAssignment_1 : ( ruleJdlMinValidator ) ;
    public final void rule__JdlNumericValidators__MinlengthAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5081:1: ( ( ruleJdlMinValidator ) )
            // InternalJDL.g:5082:2: ( ruleJdlMinValidator )
            {
            // InternalJDL.g:5082:2: ( ruleJdlMinValidator )
            // InternalJDL.g:5083:3: ruleJdlMinValidator
            {
             before(grammarAccess.getJdlNumericValidatorsAccess().getMinlengthJdlMinValidatorParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleJdlMinValidator();

            state._fsp--;

             after(grammarAccess.getJdlNumericValidatorsAccess().getMinlengthJdlMinValidatorParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlNumericValidators__MinlengthAssignment_1"


    // $ANTLR start "rule__JdlNumericValidators__MaxlengthAssignment_2"
    // InternalJDL.g:5092:1: rule__JdlNumericValidators__MaxlengthAssignment_2 : ( ruleJdlMaxValidator ) ;
    public final void rule__JdlNumericValidators__MaxlengthAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5096:1: ( ( ruleJdlMaxValidator ) )
            // InternalJDL.g:5097:2: ( ruleJdlMaxValidator )
            {
            // InternalJDL.g:5097:2: ( ruleJdlMaxValidator )
            // InternalJDL.g:5098:3: ruleJdlMaxValidator
            {
             before(grammarAccess.getJdlNumericValidatorsAccess().getMaxlengthJdlMaxValidatorParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleJdlMaxValidator();

            state._fsp--;

             after(grammarAccess.getJdlNumericValidatorsAccess().getMaxlengthJdlMaxValidatorParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlNumericValidators__MaxlengthAssignment_2"


    // $ANTLR start "rule__JdlBlobValidators__RequiredAssignment_0"
    // InternalJDL.g:5107:1: rule__JdlBlobValidators__RequiredAssignment_0 : ( ruleJdlRequiredValidator ) ;
    public final void rule__JdlBlobValidators__RequiredAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5111:1: ( ( ruleJdlRequiredValidator ) )
            // InternalJDL.g:5112:2: ( ruleJdlRequiredValidator )
            {
            // InternalJDL.g:5112:2: ( ruleJdlRequiredValidator )
            // InternalJDL.g:5113:3: ruleJdlRequiredValidator
            {
             before(grammarAccess.getJdlBlobValidatorsAccess().getRequiredJdlRequiredValidatorParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleJdlRequiredValidator();

            state._fsp--;

             after(grammarAccess.getJdlBlobValidatorsAccess().getRequiredJdlRequiredValidatorParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlBlobValidators__RequiredAssignment_0"


    // $ANTLR start "rule__JdlBlobValidators__MinbytesAssignment_1"
    // InternalJDL.g:5122:1: rule__JdlBlobValidators__MinbytesAssignment_1 : ( ruleJdlMinBytesValidator ) ;
    public final void rule__JdlBlobValidators__MinbytesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5126:1: ( ( ruleJdlMinBytesValidator ) )
            // InternalJDL.g:5127:2: ( ruleJdlMinBytesValidator )
            {
            // InternalJDL.g:5127:2: ( ruleJdlMinBytesValidator )
            // InternalJDL.g:5128:3: ruleJdlMinBytesValidator
            {
             before(grammarAccess.getJdlBlobValidatorsAccess().getMinbytesJdlMinBytesValidatorParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleJdlMinBytesValidator();

            state._fsp--;

             after(grammarAccess.getJdlBlobValidatorsAccess().getMinbytesJdlMinBytesValidatorParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlBlobValidators__MinbytesAssignment_1"


    // $ANTLR start "rule__JdlBlobValidators__MaxbytesAssignment_2"
    // InternalJDL.g:5137:1: rule__JdlBlobValidators__MaxbytesAssignment_2 : ( ruleJdlMaxBytesValidator ) ;
    public final void rule__JdlBlobValidators__MaxbytesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5141:1: ( ( ruleJdlMaxBytesValidator ) )
            // InternalJDL.g:5142:2: ( ruleJdlMaxBytesValidator )
            {
            // InternalJDL.g:5142:2: ( ruleJdlMaxBytesValidator )
            // InternalJDL.g:5143:3: ruleJdlMaxBytesValidator
            {
             before(grammarAccess.getJdlBlobValidatorsAccess().getMaxbytesJdlMaxBytesValidatorParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleJdlMaxBytesValidator();

            state._fsp--;

             after(grammarAccess.getJdlBlobValidatorsAccess().getMaxbytesJdlMaxBytesValidatorParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlBlobValidators__MaxbytesAssignment_2"


    // $ANTLR start "rule__JdlRequiredValidator__RequiredAssignment"
    // InternalJDL.g:5152:1: rule__JdlRequiredValidator__RequiredAssignment : ( ( 'required' ) ) ;
    public final void rule__JdlRequiredValidator__RequiredAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5156:1: ( ( ( 'required' ) ) )
            // InternalJDL.g:5157:2: ( ( 'required' ) )
            {
            // InternalJDL.g:5157:2: ( ( 'required' ) )
            // InternalJDL.g:5158:3: ( 'required' )
            {
             before(grammarAccess.getJdlRequiredValidatorAccess().getRequiredRequiredKeyword_0()); 
            // InternalJDL.g:5159:3: ( 'required' )
            // InternalJDL.g:5160:4: 'required'
            {
             before(grammarAccess.getJdlRequiredValidatorAccess().getRequiredRequiredKeyword_0()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getJdlRequiredValidatorAccess().getRequiredRequiredKeyword_0()); 

            }

             after(grammarAccess.getJdlRequiredValidatorAccess().getRequiredRequiredKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRequiredValidator__RequiredAssignment"


    // $ANTLR start "rule__JdlMinLengthValidator__ValueAssignment_2"
    // InternalJDL.g:5171:1: rule__JdlMinLengthValidator__ValueAssignment_2 : ( RULE_INT ) ;
    public final void rule__JdlMinLengthValidator__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5175:1: ( ( RULE_INT ) )
            // InternalJDL.g:5176:2: ( RULE_INT )
            {
            // InternalJDL.g:5176:2: ( RULE_INT )
            // InternalJDL.g:5177:3: RULE_INT
            {
             before(grammarAccess.getJdlMinLengthValidatorAccess().getValueINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getJdlMinLengthValidatorAccess().getValueINTTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMinLengthValidator__ValueAssignment_2"


    // $ANTLR start "rule__JdlMaxLengthValidator__ValueAssignment_2"
    // InternalJDL.g:5186:1: rule__JdlMaxLengthValidator__ValueAssignment_2 : ( RULE_INT ) ;
    public final void rule__JdlMaxLengthValidator__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5190:1: ( ( RULE_INT ) )
            // InternalJDL.g:5191:2: ( RULE_INT )
            {
            // InternalJDL.g:5191:2: ( RULE_INT )
            // InternalJDL.g:5192:3: RULE_INT
            {
             before(grammarAccess.getJdlMaxLengthValidatorAccess().getValueINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getJdlMaxLengthValidatorAccess().getValueINTTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMaxLengthValidator__ValueAssignment_2"


    // $ANTLR start "rule__JdlPatternValidator__ValueAssignment_2"
    // InternalJDL.g:5201:1: rule__JdlPatternValidator__ValueAssignment_2 : ( RULE_STRING ) ;
    public final void rule__JdlPatternValidator__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5205:1: ( ( RULE_STRING ) )
            // InternalJDL.g:5206:2: ( RULE_STRING )
            {
            // InternalJDL.g:5206:2: ( RULE_STRING )
            // InternalJDL.g:5207:3: RULE_STRING
            {
             before(grammarAccess.getJdlPatternValidatorAccess().getValueSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getJdlPatternValidatorAccess().getValueSTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlPatternValidator__ValueAssignment_2"


    // $ANTLR start "rule__JdlMinValidator__ValueAssignment_2"
    // InternalJDL.g:5216:1: rule__JdlMinValidator__ValueAssignment_2 : ( RULE_INT ) ;
    public final void rule__JdlMinValidator__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5220:1: ( ( RULE_INT ) )
            // InternalJDL.g:5221:2: ( RULE_INT )
            {
            // InternalJDL.g:5221:2: ( RULE_INT )
            // InternalJDL.g:5222:3: RULE_INT
            {
             before(grammarAccess.getJdlMinValidatorAccess().getValueINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getJdlMinValidatorAccess().getValueINTTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMinValidator__ValueAssignment_2"


    // $ANTLR start "rule__JdlMaxValidator__ValueAssignment_2"
    // InternalJDL.g:5231:1: rule__JdlMaxValidator__ValueAssignment_2 : ( RULE_INT ) ;
    public final void rule__JdlMaxValidator__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5235:1: ( ( RULE_INT ) )
            // InternalJDL.g:5236:2: ( RULE_INT )
            {
            // InternalJDL.g:5236:2: ( RULE_INT )
            // InternalJDL.g:5237:3: RULE_INT
            {
             before(grammarAccess.getJdlMaxValidatorAccess().getValueINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getJdlMaxValidatorAccess().getValueINTTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMaxValidator__ValueAssignment_2"


    // $ANTLR start "rule__JdlMinBytesValidator__ValueAssignment_2"
    // InternalJDL.g:5246:1: rule__JdlMinBytesValidator__ValueAssignment_2 : ( RULE_INT ) ;
    public final void rule__JdlMinBytesValidator__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5250:1: ( ( RULE_INT ) )
            // InternalJDL.g:5251:2: ( RULE_INT )
            {
            // InternalJDL.g:5251:2: ( RULE_INT )
            // InternalJDL.g:5252:3: RULE_INT
            {
             before(grammarAccess.getJdlMinBytesValidatorAccess().getValueINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getJdlMinBytesValidatorAccess().getValueINTTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMinBytesValidator__ValueAssignment_2"


    // $ANTLR start "rule__JdlMaxBytesValidator__ValueAssignment_2"
    // InternalJDL.g:5261:1: rule__JdlMaxBytesValidator__ValueAssignment_2 : ( RULE_INT ) ;
    public final void rule__JdlMaxBytesValidator__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5265:1: ( ( RULE_INT ) )
            // InternalJDL.g:5266:2: ( RULE_INT )
            {
            // InternalJDL.g:5266:2: ( RULE_INT )
            // InternalJDL.g:5267:3: RULE_INT
            {
             before(grammarAccess.getJdlMaxBytesValidatorAccess().getValueINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getJdlMaxBytesValidatorAccess().getValueINTTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMaxBytesValidator__ValueAssignment_2"


    // $ANTLR start "rule__JdlRelationships__CardinalityAssignment_1"
    // InternalJDL.g:5276:1: rule__JdlRelationships__CardinalityAssignment_1 : ( ruleJdlCardinality ) ;
    public final void rule__JdlRelationships__CardinalityAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5280:1: ( ( ruleJdlCardinality ) )
            // InternalJDL.g:5281:2: ( ruleJdlCardinality )
            {
            // InternalJDL.g:5281:2: ( ruleJdlCardinality )
            // InternalJDL.g:5282:3: ruleJdlCardinality
            {
             before(grammarAccess.getJdlRelationshipsAccess().getCardinalityJdlCardinalityEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleJdlCardinality();

            state._fsp--;

             after(grammarAccess.getJdlRelationshipsAccess().getCardinalityJdlCardinalityEnumRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationships__CardinalityAssignment_1"


    // $ANTLR start "rule__JdlRelationships__RelationshipsAssignment_3"
    // InternalJDL.g:5291:1: rule__JdlRelationships__RelationshipsAssignment_3 : ( ruleJdlRelationship ) ;
    public final void rule__JdlRelationships__RelationshipsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5295:1: ( ( ruleJdlRelationship ) )
            // InternalJDL.g:5296:2: ( ruleJdlRelationship )
            {
            // InternalJDL.g:5296:2: ( ruleJdlRelationship )
            // InternalJDL.g:5297:3: ruleJdlRelationship
            {
             before(grammarAccess.getJdlRelationshipsAccess().getRelationshipsJdlRelationshipParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleJdlRelationship();

            state._fsp--;

             after(grammarAccess.getJdlRelationshipsAccess().getRelationshipsJdlRelationshipParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationships__RelationshipsAssignment_3"


    // $ANTLR start "rule__JdlRelationships__RelationshipsAssignment_4_1"
    // InternalJDL.g:5306:1: rule__JdlRelationships__RelationshipsAssignment_4_1 : ( ruleJdlRelationship ) ;
    public final void rule__JdlRelationships__RelationshipsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5310:1: ( ( ruleJdlRelationship ) )
            // InternalJDL.g:5311:2: ( ruleJdlRelationship )
            {
            // InternalJDL.g:5311:2: ( ruleJdlRelationship )
            // InternalJDL.g:5312:3: ruleJdlRelationship
            {
             before(grammarAccess.getJdlRelationshipsAccess().getRelationshipsJdlRelationshipParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleJdlRelationship();

            state._fsp--;

             after(grammarAccess.getJdlRelationshipsAccess().getRelationshipsJdlRelationshipParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationships__RelationshipsAssignment_4_1"


    // $ANTLR start "rule__JdlRelationship__FromEntityAssignment_0"
    // InternalJDL.g:5321:1: rule__JdlRelationship__FromEntityAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__JdlRelationship__FromEntityAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5325:1: ( ( ( RULE_ID ) ) )
            // InternalJDL.g:5326:2: ( ( RULE_ID ) )
            {
            // InternalJDL.g:5326:2: ( ( RULE_ID ) )
            // InternalJDL.g:5327:3: ( RULE_ID )
            {
             before(grammarAccess.getJdlRelationshipAccess().getFromEntityJdlEntityCrossReference_0_0()); 
            // InternalJDL.g:5328:3: ( RULE_ID )
            // InternalJDL.g:5329:4: RULE_ID
            {
             before(grammarAccess.getJdlRelationshipAccess().getFromEntityJdlEntityIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getJdlRelationshipAccess().getFromEntityJdlEntityIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getJdlRelationshipAccess().getFromEntityJdlEntityCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationship__FromEntityAssignment_0"


    // $ANTLR start "rule__JdlRelationship__FromNameAssignment_1"
    // InternalJDL.g:5340:1: rule__JdlRelationship__FromNameAssignment_1 : ( ruleJdlRelationshipName ) ;
    public final void rule__JdlRelationship__FromNameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5344:1: ( ( ruleJdlRelationshipName ) )
            // InternalJDL.g:5345:2: ( ruleJdlRelationshipName )
            {
            // InternalJDL.g:5345:2: ( ruleJdlRelationshipName )
            // InternalJDL.g:5346:3: ruleJdlRelationshipName
            {
             before(grammarAccess.getJdlRelationshipAccess().getFromNameJdlRelationshipNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleJdlRelationshipName();

            state._fsp--;

             after(grammarAccess.getJdlRelationshipAccess().getFromNameJdlRelationshipNameParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationship__FromNameAssignment_1"


    // $ANTLR start "rule__JdlRelationship__ToEntityAssignment_3"
    // InternalJDL.g:5355:1: rule__JdlRelationship__ToEntityAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__JdlRelationship__ToEntityAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5359:1: ( ( ( RULE_ID ) ) )
            // InternalJDL.g:5360:2: ( ( RULE_ID ) )
            {
            // InternalJDL.g:5360:2: ( ( RULE_ID ) )
            // InternalJDL.g:5361:3: ( RULE_ID )
            {
             before(grammarAccess.getJdlRelationshipAccess().getToEntityJdlEntityCrossReference_3_0()); 
            // InternalJDL.g:5362:3: ( RULE_ID )
            // InternalJDL.g:5363:4: RULE_ID
            {
             before(grammarAccess.getJdlRelationshipAccess().getToEntityJdlEntityIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getJdlRelationshipAccess().getToEntityJdlEntityIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getJdlRelationshipAccess().getToEntityJdlEntityCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationship__ToEntityAssignment_3"


    // $ANTLR start "rule__JdlRelationship__ToNameAssignment_4"
    // InternalJDL.g:5374:1: rule__JdlRelationship__ToNameAssignment_4 : ( ruleJdlRelationshipName ) ;
    public final void rule__JdlRelationship__ToNameAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5378:1: ( ( ruleJdlRelationshipName ) )
            // InternalJDL.g:5379:2: ( ruleJdlRelationshipName )
            {
            // InternalJDL.g:5379:2: ( ruleJdlRelationshipName )
            // InternalJDL.g:5380:3: ruleJdlRelationshipName
            {
             before(grammarAccess.getJdlRelationshipAccess().getToNameJdlRelationshipNameParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleJdlRelationshipName();

            state._fsp--;

             after(grammarAccess.getJdlRelationshipAccess().getToNameJdlRelationshipNameParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationship__ToNameAssignment_4"


    // $ANTLR start "rule__JdlRelationshipName__NameAssignment_1"
    // InternalJDL.g:5389:1: rule__JdlRelationshipName__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__JdlRelationshipName__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5393:1: ( ( RULE_ID ) )
            // InternalJDL.g:5394:2: ( RULE_ID )
            {
            // InternalJDL.g:5394:2: ( RULE_ID )
            // InternalJDL.g:5395:3: RULE_ID
            {
             before(grammarAccess.getJdlRelationshipNameAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getJdlRelationshipNameAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationshipName__NameAssignment_1"


    // $ANTLR start "rule__JdlRelationshipName__RoleAssignment_2_1"
    // InternalJDL.g:5404:1: rule__JdlRelationshipName__RoleAssignment_2_1 : ( RULE_ID ) ;
    public final void rule__JdlRelationshipName__RoleAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5408:1: ( ( RULE_ID ) )
            // InternalJDL.g:5409:2: ( RULE_ID )
            {
            // InternalJDL.g:5409:2: ( RULE_ID )
            // InternalJDL.g:5410:3: RULE_ID
            {
             before(grammarAccess.getJdlRelationshipNameAccess().getRoleIDTerminalRuleCall_2_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getJdlRelationshipNameAccess().getRoleIDTerminalRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlRelationshipName__RoleAssignment_2_1"


    // $ANTLR start "rule__JdlEnumType__NameAssignment_1"
    // InternalJDL.g:5419:1: rule__JdlEnumType__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__JdlEnumType__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5423:1: ( ( RULE_ID ) )
            // InternalJDL.g:5424:2: ( RULE_ID )
            {
            // InternalJDL.g:5424:2: ( RULE_ID )
            // InternalJDL.g:5425:3: RULE_ID
            {
             before(grammarAccess.getJdlEnumTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getJdlEnumTypeAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEnumType__NameAssignment_1"


    // $ANTLR start "rule__JdlEnumType__ValuesAssignment_3"
    // InternalJDL.g:5434:1: rule__JdlEnumType__ValuesAssignment_3 : ( RULE_ID ) ;
    public final void rule__JdlEnumType__ValuesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5438:1: ( ( RULE_ID ) )
            // InternalJDL.g:5439:2: ( RULE_ID )
            {
            // InternalJDL.g:5439:2: ( RULE_ID )
            // InternalJDL.g:5440:3: RULE_ID
            {
             before(grammarAccess.getJdlEnumTypeAccess().getValuesIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getJdlEnumTypeAccess().getValuesIDTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEnumType__ValuesAssignment_3"


    // $ANTLR start "rule__JdlEnumType__ValuesAssignment_4_1"
    // InternalJDL.g:5449:1: rule__JdlEnumType__ValuesAssignment_4_1 : ( RULE_ID ) ;
    public final void rule__JdlEnumType__ValuesAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5453:1: ( ( RULE_ID ) )
            // InternalJDL.g:5454:2: ( RULE_ID )
            {
            // InternalJDL.g:5454:2: ( RULE_ID )
            // InternalJDL.g:5455:3: RULE_ID
            {
             before(grammarAccess.getJdlEnumTypeAccess().getValuesIDTerminalRuleCall_4_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getJdlEnumTypeAccess().getValuesIDTerminalRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEnumType__ValuesAssignment_4_1"


    // $ANTLR start "rule__JdlGenerationSetting__SettingAssignment_0"
    // InternalJDL.g:5464:1: rule__JdlGenerationSetting__SettingAssignment_0 : ( ruleJdlGenerationSettingType ) ;
    public final void rule__JdlGenerationSetting__SettingAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5468:1: ( ( ruleJdlGenerationSettingType ) )
            // InternalJDL.g:5469:2: ( ruleJdlGenerationSettingType )
            {
            // InternalJDL.g:5469:2: ( ruleJdlGenerationSettingType )
            // InternalJDL.g:5470:3: ruleJdlGenerationSettingType
            {
             before(grammarAccess.getJdlGenerationSettingAccess().getSettingJdlGenerationSettingTypeParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleJdlGenerationSettingType();

            state._fsp--;

             after(grammarAccess.getJdlGenerationSettingAccess().getSettingJdlGenerationSettingTypeParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlGenerationSetting__SettingAssignment_0"


    // $ANTLR start "rule__JdlGenerationSetting__ExcludesAssignment_1"
    // InternalJDL.g:5479:1: rule__JdlGenerationSetting__ExcludesAssignment_1 : ( ruleJdlEntityExclusion ) ;
    public final void rule__JdlGenerationSetting__ExcludesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5483:1: ( ( ruleJdlEntityExclusion ) )
            // InternalJDL.g:5484:2: ( ruleJdlEntityExclusion )
            {
            // InternalJDL.g:5484:2: ( ruleJdlEntityExclusion )
            // InternalJDL.g:5485:3: ruleJdlEntityExclusion
            {
             before(grammarAccess.getJdlGenerationSettingAccess().getExcludesJdlEntityExclusionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleJdlEntityExclusion();

            state._fsp--;

             after(grammarAccess.getJdlGenerationSettingAccess().getExcludesJdlEntityExclusionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlGenerationSetting__ExcludesAssignment_1"


    // $ANTLR start "rule__JdlServiceGenerationSetting__ServiceGenerationSettingAssignment_0"
    // InternalJDL.g:5494:1: rule__JdlServiceGenerationSetting__ServiceGenerationSettingAssignment_0 : ( ( 'service' ) ) ;
    public final void rule__JdlServiceGenerationSetting__ServiceGenerationSettingAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5498:1: ( ( ( 'service' ) ) )
            // InternalJDL.g:5499:2: ( ( 'service' ) )
            {
            // InternalJDL.g:5499:2: ( ( 'service' ) )
            // InternalJDL.g:5500:3: ( 'service' )
            {
             before(grammarAccess.getJdlServiceGenerationSettingAccess().getServiceGenerationSettingServiceKeyword_0_0()); 
            // InternalJDL.g:5501:3: ( 'service' )
            // InternalJDL.g:5502:4: 'service'
            {
             before(grammarAccess.getJdlServiceGenerationSettingAccess().getServiceGenerationSettingServiceKeyword_0_0()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getJdlServiceGenerationSettingAccess().getServiceGenerationSettingServiceKeyword_0_0()); 

            }

             after(grammarAccess.getJdlServiceGenerationSettingAccess().getServiceGenerationSettingServiceKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlServiceGenerationSetting__ServiceGenerationSettingAssignment_0"


    // $ANTLR start "rule__JdlServiceGenerationSetting__IncludesAssignment_1"
    // InternalJDL.g:5513:1: rule__JdlServiceGenerationSetting__IncludesAssignment_1 : ( ruleJdlEntityInclusion ) ;
    public final void rule__JdlServiceGenerationSetting__IncludesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5517:1: ( ( ruleJdlEntityInclusion ) )
            // InternalJDL.g:5518:2: ( ruleJdlEntityInclusion )
            {
            // InternalJDL.g:5518:2: ( ruleJdlEntityInclusion )
            // InternalJDL.g:5519:3: ruleJdlEntityInclusion
            {
             before(grammarAccess.getJdlServiceGenerationSettingAccess().getIncludesJdlEntityInclusionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleJdlEntityInclusion();

            state._fsp--;

             after(grammarAccess.getJdlServiceGenerationSettingAccess().getIncludesJdlEntityInclusionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlServiceGenerationSetting__IncludesAssignment_1"


    // $ANTLR start "rule__JdlServiceGenerationSetting__ServiceTypeAssignment_2"
    // InternalJDL.g:5528:1: rule__JdlServiceGenerationSetting__ServiceTypeAssignment_2 : ( ruleJdlServiceType ) ;
    public final void rule__JdlServiceGenerationSetting__ServiceTypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5532:1: ( ( ruleJdlServiceType ) )
            // InternalJDL.g:5533:2: ( ruleJdlServiceType )
            {
            // InternalJDL.g:5533:2: ( ruleJdlServiceType )
            // InternalJDL.g:5534:3: ruleJdlServiceType
            {
             before(grammarAccess.getJdlServiceGenerationSettingAccess().getServiceTypeJdlServiceTypeEnumRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleJdlServiceType();

            state._fsp--;

             after(grammarAccess.getJdlServiceGenerationSettingAccess().getServiceTypeJdlServiceTypeEnumRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlServiceGenerationSetting__ServiceTypeAssignment_2"


    // $ANTLR start "rule__JdlMicroserviceGenerationSetting__MicroserviceGenerationSettingAssignment_0"
    // InternalJDL.g:5543:1: rule__JdlMicroserviceGenerationSetting__MicroserviceGenerationSettingAssignment_0 : ( ( 'microservice' ) ) ;
    public final void rule__JdlMicroserviceGenerationSetting__MicroserviceGenerationSettingAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5547:1: ( ( ( 'microservice' ) ) )
            // InternalJDL.g:5548:2: ( ( 'microservice' ) )
            {
            // InternalJDL.g:5548:2: ( ( 'microservice' ) )
            // InternalJDL.g:5549:3: ( 'microservice' )
            {
             before(grammarAccess.getJdlMicroserviceGenerationSettingAccess().getMicroserviceGenerationSettingMicroserviceKeyword_0_0()); 
            // InternalJDL.g:5550:3: ( 'microservice' )
            // InternalJDL.g:5551:4: 'microservice'
            {
             before(grammarAccess.getJdlMicroserviceGenerationSettingAccess().getMicroserviceGenerationSettingMicroserviceKeyword_0_0()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getJdlMicroserviceGenerationSettingAccess().getMicroserviceGenerationSettingMicroserviceKeyword_0_0()); 

            }

             after(grammarAccess.getJdlMicroserviceGenerationSettingAccess().getMicroserviceGenerationSettingMicroserviceKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMicroserviceGenerationSetting__MicroserviceGenerationSettingAssignment_0"


    // $ANTLR start "rule__JdlMicroserviceGenerationSetting__IncludesAssignment_1"
    // InternalJDL.g:5562:1: rule__JdlMicroserviceGenerationSetting__IncludesAssignment_1 : ( ruleJdlEntityInclusion ) ;
    public final void rule__JdlMicroserviceGenerationSetting__IncludesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5566:1: ( ( ruleJdlEntityInclusion ) )
            // InternalJDL.g:5567:2: ( ruleJdlEntityInclusion )
            {
            // InternalJDL.g:5567:2: ( ruleJdlEntityInclusion )
            // InternalJDL.g:5568:3: ruleJdlEntityInclusion
            {
             before(grammarAccess.getJdlMicroserviceGenerationSettingAccess().getIncludesJdlEntityInclusionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleJdlEntityInclusion();

            state._fsp--;

             after(grammarAccess.getJdlMicroserviceGenerationSettingAccess().getIncludesJdlEntityInclusionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMicroserviceGenerationSetting__IncludesAssignment_1"


    // $ANTLR start "rule__JdlMicroserviceGenerationSetting__AppnameAssignment_2"
    // InternalJDL.g:5577:1: rule__JdlMicroserviceGenerationSetting__AppnameAssignment_2 : ( RULE_ID ) ;
    public final void rule__JdlMicroserviceGenerationSetting__AppnameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5581:1: ( ( RULE_ID ) )
            // InternalJDL.g:5582:2: ( RULE_ID )
            {
            // InternalJDL.g:5582:2: ( RULE_ID )
            // InternalJDL.g:5583:3: RULE_ID
            {
             before(grammarAccess.getJdlMicroserviceGenerationSettingAccess().getAppnameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getJdlMicroserviceGenerationSettingAccess().getAppnameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlMicroserviceGenerationSetting__AppnameAssignment_2"


    // $ANTLR start "rule__JdlSearchGenerationSetting__SearchGenerationSettingAssignment_0"
    // InternalJDL.g:5592:1: rule__JdlSearchGenerationSetting__SearchGenerationSettingAssignment_0 : ( ( 'search' ) ) ;
    public final void rule__JdlSearchGenerationSetting__SearchGenerationSettingAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5596:1: ( ( ( 'search' ) ) )
            // InternalJDL.g:5597:2: ( ( 'search' ) )
            {
            // InternalJDL.g:5597:2: ( ( 'search' ) )
            // InternalJDL.g:5598:3: ( 'search' )
            {
             before(grammarAccess.getJdlSearchGenerationSettingAccess().getSearchGenerationSettingSearchKeyword_0_0()); 
            // InternalJDL.g:5599:3: ( 'search' )
            // InternalJDL.g:5600:4: 'search'
            {
             before(grammarAccess.getJdlSearchGenerationSettingAccess().getSearchGenerationSettingSearchKeyword_0_0()); 
            match(input,53,FOLLOW_2); 
             after(grammarAccess.getJdlSearchGenerationSettingAccess().getSearchGenerationSettingSearchKeyword_0_0()); 

            }

             after(grammarAccess.getJdlSearchGenerationSettingAccess().getSearchGenerationSettingSearchKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlSearchGenerationSetting__SearchGenerationSettingAssignment_0"


    // $ANTLR start "rule__JdlSearchGenerationSetting__IncludesAssignment_1"
    // InternalJDL.g:5611:1: rule__JdlSearchGenerationSetting__IncludesAssignment_1 : ( ruleJdlEntityInclusion ) ;
    public final void rule__JdlSearchGenerationSetting__IncludesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5615:1: ( ( ruleJdlEntityInclusion ) )
            // InternalJDL.g:5616:2: ( ruleJdlEntityInclusion )
            {
            // InternalJDL.g:5616:2: ( ruleJdlEntityInclusion )
            // InternalJDL.g:5617:3: ruleJdlEntityInclusion
            {
             before(grammarAccess.getJdlSearchGenerationSettingAccess().getIncludesJdlEntityInclusionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleJdlEntityInclusion();

            state._fsp--;

             after(grammarAccess.getJdlSearchGenerationSettingAccess().getIncludesJdlEntityInclusionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlSearchGenerationSetting__IncludesAssignment_1"


    // $ANTLR start "rule__JdlSearchGenerationSetting__ServiceAssignment_2"
    // InternalJDL.g:5626:1: rule__JdlSearchGenerationSetting__ServiceAssignment_2 : ( RULE_ID ) ;
    public final void rule__JdlSearchGenerationSetting__ServiceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5630:1: ( ( RULE_ID ) )
            // InternalJDL.g:5631:2: ( RULE_ID )
            {
            // InternalJDL.g:5631:2: ( RULE_ID )
            // InternalJDL.g:5632:3: RULE_ID
            {
             before(grammarAccess.getJdlSearchGenerationSettingAccess().getServiceIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getJdlSearchGenerationSettingAccess().getServiceIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlSearchGenerationSetting__ServiceAssignment_2"


    // $ANTLR start "rule__JdlDtoGenerationSetting__DtoGenerationSettingAssignment_0"
    // InternalJDL.g:5641:1: rule__JdlDtoGenerationSetting__DtoGenerationSettingAssignment_0 : ( ( 'dto' ) ) ;
    public final void rule__JdlDtoGenerationSetting__DtoGenerationSettingAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5645:1: ( ( ( 'dto' ) ) )
            // InternalJDL.g:5646:2: ( ( 'dto' ) )
            {
            // InternalJDL.g:5646:2: ( ( 'dto' ) )
            // InternalJDL.g:5647:3: ( 'dto' )
            {
             before(grammarAccess.getJdlDtoGenerationSettingAccess().getDtoGenerationSettingDtoKeyword_0_0()); 
            // InternalJDL.g:5648:3: ( 'dto' )
            // InternalJDL.g:5649:4: 'dto'
            {
             before(grammarAccess.getJdlDtoGenerationSettingAccess().getDtoGenerationSettingDtoKeyword_0_0()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getJdlDtoGenerationSettingAccess().getDtoGenerationSettingDtoKeyword_0_0()); 

            }

             after(grammarAccess.getJdlDtoGenerationSettingAccess().getDtoGenerationSettingDtoKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlDtoGenerationSetting__DtoGenerationSettingAssignment_0"


    // $ANTLR start "rule__JdlDtoGenerationSetting__IncludesAssignment_1"
    // InternalJDL.g:5660:1: rule__JdlDtoGenerationSetting__IncludesAssignment_1 : ( ruleJdlEntityInclusion ) ;
    public final void rule__JdlDtoGenerationSetting__IncludesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5664:1: ( ( ruleJdlEntityInclusion ) )
            // InternalJDL.g:5665:2: ( ruleJdlEntityInclusion )
            {
            // InternalJDL.g:5665:2: ( ruleJdlEntityInclusion )
            // InternalJDL.g:5666:3: ruleJdlEntityInclusion
            {
             before(grammarAccess.getJdlDtoGenerationSettingAccess().getIncludesJdlEntityInclusionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleJdlEntityInclusion();

            state._fsp--;

             after(grammarAccess.getJdlDtoGenerationSettingAccess().getIncludesJdlEntityInclusionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlDtoGenerationSetting__IncludesAssignment_1"


    // $ANTLR start "rule__JdlDtoGenerationSetting__DtoTypeAssignment_2"
    // InternalJDL.g:5675:1: rule__JdlDtoGenerationSetting__DtoTypeAssignment_2 : ( ruleJdlDtoType ) ;
    public final void rule__JdlDtoGenerationSetting__DtoTypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5679:1: ( ( ruleJdlDtoType ) )
            // InternalJDL.g:5680:2: ( ruleJdlDtoType )
            {
            // InternalJDL.g:5680:2: ( ruleJdlDtoType )
            // InternalJDL.g:5681:3: ruleJdlDtoType
            {
             before(grammarAccess.getJdlDtoGenerationSettingAccess().getDtoTypeJdlDtoTypeEnumRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleJdlDtoType();

            state._fsp--;

             after(grammarAccess.getJdlDtoGenerationSettingAccess().getDtoTypeJdlDtoTypeEnumRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlDtoGenerationSetting__DtoTypeAssignment_2"


    // $ANTLR start "rule__JdlPaginateGenerationSetting__PaginateGenerationSettingAssignment_0"
    // InternalJDL.g:5690:1: rule__JdlPaginateGenerationSetting__PaginateGenerationSettingAssignment_0 : ( ( 'paginate' ) ) ;
    public final void rule__JdlPaginateGenerationSetting__PaginateGenerationSettingAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5694:1: ( ( ( 'paginate' ) ) )
            // InternalJDL.g:5695:2: ( ( 'paginate' ) )
            {
            // InternalJDL.g:5695:2: ( ( 'paginate' ) )
            // InternalJDL.g:5696:3: ( 'paginate' )
            {
             before(grammarAccess.getJdlPaginateGenerationSettingAccess().getPaginateGenerationSettingPaginateKeyword_0_0()); 
            // InternalJDL.g:5697:3: ( 'paginate' )
            // InternalJDL.g:5698:4: 'paginate'
            {
             before(grammarAccess.getJdlPaginateGenerationSettingAccess().getPaginateGenerationSettingPaginateKeyword_0_0()); 
            match(input,55,FOLLOW_2); 
             after(grammarAccess.getJdlPaginateGenerationSettingAccess().getPaginateGenerationSettingPaginateKeyword_0_0()); 

            }

             after(grammarAccess.getJdlPaginateGenerationSettingAccess().getPaginateGenerationSettingPaginateKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlPaginateGenerationSetting__PaginateGenerationSettingAssignment_0"


    // $ANTLR start "rule__JdlPaginateGenerationSetting__IncludesAssignment_1"
    // InternalJDL.g:5709:1: rule__JdlPaginateGenerationSetting__IncludesAssignment_1 : ( ruleJdlEntityInclusion ) ;
    public final void rule__JdlPaginateGenerationSetting__IncludesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5713:1: ( ( ruleJdlEntityInclusion ) )
            // InternalJDL.g:5714:2: ( ruleJdlEntityInclusion )
            {
            // InternalJDL.g:5714:2: ( ruleJdlEntityInclusion )
            // InternalJDL.g:5715:3: ruleJdlEntityInclusion
            {
             before(grammarAccess.getJdlPaginateGenerationSettingAccess().getIncludesJdlEntityInclusionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleJdlEntityInclusion();

            state._fsp--;

             after(grammarAccess.getJdlPaginateGenerationSettingAccess().getIncludesJdlEntityInclusionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlPaginateGenerationSetting__IncludesAssignment_1"


    // $ANTLR start "rule__JdlPaginateGenerationSetting__PaginateTypeAssignment_2"
    // InternalJDL.g:5724:1: rule__JdlPaginateGenerationSetting__PaginateTypeAssignment_2 : ( ruleJdlPaginateType ) ;
    public final void rule__JdlPaginateGenerationSetting__PaginateTypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5728:1: ( ( ruleJdlPaginateType ) )
            // InternalJDL.g:5729:2: ( ruleJdlPaginateType )
            {
            // InternalJDL.g:5729:2: ( ruleJdlPaginateType )
            // InternalJDL.g:5730:3: ruleJdlPaginateType
            {
             before(grammarAccess.getJdlPaginateGenerationSettingAccess().getPaginateTypeJdlPaginateTypeParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleJdlPaginateType();

            state._fsp--;

             after(grammarAccess.getJdlPaginateGenerationSettingAccess().getPaginateTypeJdlPaginateTypeParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlPaginateGenerationSetting__PaginateTypeAssignment_2"


    // $ANTLR start "rule__JdlAngularSuffixGenerationSetting__AngularSuffixGenerationSettingAssignment_0"
    // InternalJDL.g:5739:1: rule__JdlAngularSuffixGenerationSetting__AngularSuffixGenerationSettingAssignment_0 : ( ( 'angularSuffix' ) ) ;
    public final void rule__JdlAngularSuffixGenerationSetting__AngularSuffixGenerationSettingAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5743:1: ( ( ( 'angularSuffix' ) ) )
            // InternalJDL.g:5744:2: ( ( 'angularSuffix' ) )
            {
            // InternalJDL.g:5744:2: ( ( 'angularSuffix' ) )
            // InternalJDL.g:5745:3: ( 'angularSuffix' )
            {
             before(grammarAccess.getJdlAngularSuffixGenerationSettingAccess().getAngularSuffixGenerationSettingAngularSuffixKeyword_0_0()); 
            // InternalJDL.g:5746:3: ( 'angularSuffix' )
            // InternalJDL.g:5747:4: 'angularSuffix'
            {
             before(grammarAccess.getJdlAngularSuffixGenerationSettingAccess().getAngularSuffixGenerationSettingAngularSuffixKeyword_0_0()); 
            match(input,56,FOLLOW_2); 
             after(grammarAccess.getJdlAngularSuffixGenerationSettingAccess().getAngularSuffixGenerationSettingAngularSuffixKeyword_0_0()); 

            }

             after(grammarAccess.getJdlAngularSuffixGenerationSettingAccess().getAngularSuffixGenerationSettingAngularSuffixKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlAngularSuffixGenerationSetting__AngularSuffixGenerationSettingAssignment_0"


    // $ANTLR start "rule__JdlAngularSuffixGenerationSetting__IncludesAssignment_1"
    // InternalJDL.g:5758:1: rule__JdlAngularSuffixGenerationSetting__IncludesAssignment_1 : ( ruleJdlEntityInclusion ) ;
    public final void rule__JdlAngularSuffixGenerationSetting__IncludesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5762:1: ( ( ruleJdlEntityInclusion ) )
            // InternalJDL.g:5763:2: ( ruleJdlEntityInclusion )
            {
            // InternalJDL.g:5763:2: ( ruleJdlEntityInclusion )
            // InternalJDL.g:5764:3: ruleJdlEntityInclusion
            {
             before(grammarAccess.getJdlAngularSuffixGenerationSettingAccess().getIncludesJdlEntityInclusionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleJdlEntityInclusion();

            state._fsp--;

             after(grammarAccess.getJdlAngularSuffixGenerationSettingAccess().getIncludesJdlEntityInclusionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlAngularSuffixGenerationSetting__IncludesAssignment_1"


    // $ANTLR start "rule__JdlAngularSuffixGenerationSetting__IdAssignment_2"
    // InternalJDL.g:5773:1: rule__JdlAngularSuffixGenerationSetting__IdAssignment_2 : ( RULE_ID ) ;
    public final void rule__JdlAngularSuffixGenerationSetting__IdAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5777:1: ( ( RULE_ID ) )
            // InternalJDL.g:5778:2: ( RULE_ID )
            {
            // InternalJDL.g:5778:2: ( RULE_ID )
            // InternalJDL.g:5779:3: RULE_ID
            {
             before(grammarAccess.getJdlAngularSuffixGenerationSettingAccess().getIdIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getJdlAngularSuffixGenerationSettingAccess().getIdIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlAngularSuffixGenerationSetting__IdAssignment_2"


    // $ANTLR start "rule__JdlEntityInclusion__PredicateAssignment_0_0"
    // InternalJDL.g:5788:1: rule__JdlEntityInclusion__PredicateAssignment_0_0 : ( ruleJdlWildcardPredicate ) ;
    public final void rule__JdlEntityInclusion__PredicateAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5792:1: ( ( ruleJdlWildcardPredicate ) )
            // InternalJDL.g:5793:2: ( ruleJdlWildcardPredicate )
            {
            // InternalJDL.g:5793:2: ( ruleJdlWildcardPredicate )
            // InternalJDL.g:5794:3: ruleJdlWildcardPredicate
            {
             before(grammarAccess.getJdlEntityInclusionAccess().getPredicateJdlWildcardPredicateParserRuleCall_0_0_0()); 
            pushFollow(FOLLOW_2);
            ruleJdlWildcardPredicate();

            state._fsp--;

             after(grammarAccess.getJdlEntityInclusionAccess().getPredicateJdlWildcardPredicateParserRuleCall_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntityInclusion__PredicateAssignment_0_0"


    // $ANTLR start "rule__JdlEntityInclusion__EntitiesAssignment_0_1_0"
    // InternalJDL.g:5803:1: rule__JdlEntityInclusion__EntitiesAssignment_0_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__JdlEntityInclusion__EntitiesAssignment_0_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5807:1: ( ( ( RULE_ID ) ) )
            // InternalJDL.g:5808:2: ( ( RULE_ID ) )
            {
            // InternalJDL.g:5808:2: ( ( RULE_ID ) )
            // InternalJDL.g:5809:3: ( RULE_ID )
            {
             before(grammarAccess.getJdlEntityInclusionAccess().getEntitiesJdlEntityCrossReference_0_1_0_0()); 
            // InternalJDL.g:5810:3: ( RULE_ID )
            // InternalJDL.g:5811:4: RULE_ID
            {
             before(grammarAccess.getJdlEntityInclusionAccess().getEntitiesJdlEntityIDTerminalRuleCall_0_1_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getJdlEntityInclusionAccess().getEntitiesJdlEntityIDTerminalRuleCall_0_1_0_0_1()); 

            }

             after(grammarAccess.getJdlEntityInclusionAccess().getEntitiesJdlEntityCrossReference_0_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntityInclusion__EntitiesAssignment_0_1_0"


    // $ANTLR start "rule__JdlEntityInclusion__EntitiesAssignment_0_1_1_1"
    // InternalJDL.g:5822:1: rule__JdlEntityInclusion__EntitiesAssignment_0_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__JdlEntityInclusion__EntitiesAssignment_0_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5826:1: ( ( ( RULE_ID ) ) )
            // InternalJDL.g:5827:2: ( ( RULE_ID ) )
            {
            // InternalJDL.g:5827:2: ( ( RULE_ID ) )
            // InternalJDL.g:5828:3: ( RULE_ID )
            {
             before(grammarAccess.getJdlEntityInclusionAccess().getEntitiesJdlEntityCrossReference_0_1_1_1_0()); 
            // InternalJDL.g:5829:3: ( RULE_ID )
            // InternalJDL.g:5830:4: RULE_ID
            {
             before(grammarAccess.getJdlEntityInclusionAccess().getEntitiesJdlEntityIDTerminalRuleCall_0_1_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getJdlEntityInclusionAccess().getEntitiesJdlEntityIDTerminalRuleCall_0_1_1_1_0_1()); 

            }

             after(grammarAccess.getJdlEntityInclusionAccess().getEntitiesJdlEntityCrossReference_0_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntityInclusion__EntitiesAssignment_0_1_1_1"


    // $ANTLR start "rule__JdlEntityExclusion__EntitiesAssignment_1"
    // InternalJDL.g:5841:1: rule__JdlEntityExclusion__EntitiesAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__JdlEntityExclusion__EntitiesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5845:1: ( ( ( RULE_ID ) ) )
            // InternalJDL.g:5846:2: ( ( RULE_ID ) )
            {
            // InternalJDL.g:5846:2: ( ( RULE_ID ) )
            // InternalJDL.g:5847:3: ( RULE_ID )
            {
             before(grammarAccess.getJdlEntityExclusionAccess().getEntitiesJdlEntityCrossReference_1_0()); 
            // InternalJDL.g:5848:3: ( RULE_ID )
            // InternalJDL.g:5849:4: RULE_ID
            {
             before(grammarAccess.getJdlEntityExclusionAccess().getEntitiesJdlEntityIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getJdlEntityExclusionAccess().getEntitiesJdlEntityIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getJdlEntityExclusionAccess().getEntitiesJdlEntityCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntityExclusion__EntitiesAssignment_1"


    // $ANTLR start "rule__JdlEntityExclusion__EntitiesAssignment_2_1"
    // InternalJDL.g:5860:1: rule__JdlEntityExclusion__EntitiesAssignment_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__JdlEntityExclusion__EntitiesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5864:1: ( ( ( RULE_ID ) ) )
            // InternalJDL.g:5865:2: ( ( RULE_ID ) )
            {
            // InternalJDL.g:5865:2: ( ( RULE_ID ) )
            // InternalJDL.g:5866:3: ( RULE_ID )
            {
             before(grammarAccess.getJdlEntityExclusionAccess().getEntitiesJdlEntityCrossReference_2_1_0()); 
            // InternalJDL.g:5867:3: ( RULE_ID )
            // InternalJDL.g:5868:4: RULE_ID
            {
             before(grammarAccess.getJdlEntityExclusionAccess().getEntitiesJdlEntityIDTerminalRuleCall_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getJdlEntityExclusionAccess().getEntitiesJdlEntityIDTerminalRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getJdlEntityExclusionAccess().getEntitiesJdlEntityCrossReference_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlEntityExclusion__EntitiesAssignment_2_1"


    // $ANTLR start "rule__JdlWildcardPredicate__WildcardAssignment_0"
    // InternalJDL.g:5879:1: rule__JdlWildcardPredicate__WildcardAssignment_0 : ( ( '*' ) ) ;
    public final void rule__JdlWildcardPredicate__WildcardAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5883:1: ( ( ( '*' ) ) )
            // InternalJDL.g:5884:2: ( ( '*' ) )
            {
            // InternalJDL.g:5884:2: ( ( '*' ) )
            // InternalJDL.g:5885:3: ( '*' )
            {
             before(grammarAccess.getJdlWildcardPredicateAccess().getWildcardAsteriskKeyword_0_0()); 
            // InternalJDL.g:5886:3: ( '*' )
            // InternalJDL.g:5887:4: '*'
            {
             before(grammarAccess.getJdlWildcardPredicateAccess().getWildcardAsteriskKeyword_0_0()); 
            match(input,57,FOLLOW_2); 
             after(grammarAccess.getJdlWildcardPredicateAccess().getWildcardAsteriskKeyword_0_0()); 

            }

             after(grammarAccess.getJdlWildcardPredicateAccess().getWildcardAsteriskKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlWildcardPredicate__WildcardAssignment_0"


    // $ANTLR start "rule__JdlWildcardPredicate__AllAssignment_1"
    // InternalJDL.g:5898:1: rule__JdlWildcardPredicate__AllAssignment_1 : ( ( 'all' ) ) ;
    public final void rule__JdlWildcardPredicate__AllAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5902:1: ( ( ( 'all' ) ) )
            // InternalJDL.g:5903:2: ( ( 'all' ) )
            {
            // InternalJDL.g:5903:2: ( ( 'all' ) )
            // InternalJDL.g:5904:3: ( 'all' )
            {
             before(grammarAccess.getJdlWildcardPredicateAccess().getAllAllKeyword_1_0()); 
            // InternalJDL.g:5905:3: ( 'all' )
            // InternalJDL.g:5906:4: 'all'
            {
             before(grammarAccess.getJdlWildcardPredicateAccess().getAllAllKeyword_1_0()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getJdlWildcardPredicateAccess().getAllAllKeyword_1_0()); 

            }

             after(grammarAccess.getJdlWildcardPredicateAccess().getAllAllKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlWildcardPredicate__AllAssignment_1"


    // $ANTLR start "rule__JdlPaginateType__PaginationAssignment_0"
    // InternalJDL.g:5917:1: rule__JdlPaginateType__PaginationAssignment_0 : ( ( rule__JdlPaginateType__PaginationAlternatives_0_0 ) ) ;
    public final void rule__JdlPaginateType__PaginationAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5921:1: ( ( ( rule__JdlPaginateType__PaginationAlternatives_0_0 ) ) )
            // InternalJDL.g:5922:2: ( ( rule__JdlPaginateType__PaginationAlternatives_0_0 ) )
            {
            // InternalJDL.g:5922:2: ( ( rule__JdlPaginateType__PaginationAlternatives_0_0 ) )
            // InternalJDL.g:5923:3: ( rule__JdlPaginateType__PaginationAlternatives_0_0 )
            {
             before(grammarAccess.getJdlPaginateTypeAccess().getPaginationAlternatives_0_0()); 
            // InternalJDL.g:5924:3: ( rule__JdlPaginateType__PaginationAlternatives_0_0 )
            // InternalJDL.g:5924:4: rule__JdlPaginateType__PaginationAlternatives_0_0
            {
            pushFollow(FOLLOW_2);
            rule__JdlPaginateType__PaginationAlternatives_0_0();

            state._fsp--;


            }

             after(grammarAccess.getJdlPaginateTypeAccess().getPaginationAlternatives_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlPaginateType__PaginationAssignment_0"


    // $ANTLR start "rule__JdlPaginateType__InfiniteScrollAssignment_1"
    // InternalJDL.g:5932:1: rule__JdlPaginateType__InfiniteScrollAssignment_1 : ( ( 'infinite-scroll' ) ) ;
    public final void rule__JdlPaginateType__InfiniteScrollAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalJDL.g:5936:1: ( ( ( 'infinite-scroll' ) ) )
            // InternalJDL.g:5937:2: ( ( 'infinite-scroll' ) )
            {
            // InternalJDL.g:5937:2: ( ( 'infinite-scroll' ) )
            // InternalJDL.g:5938:3: ( 'infinite-scroll' )
            {
             before(grammarAccess.getJdlPaginateTypeAccess().getInfiniteScrollInfiniteScrollKeyword_1_0()); 
            // InternalJDL.g:5939:3: ( 'infinite-scroll' )
            // InternalJDL.g:5940:4: 'infinite-scroll'
            {
             before(grammarAccess.getJdlPaginateTypeAccess().getInfiniteScrollInfiniteScrollKeyword_1_0()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getJdlPaginateTypeAccess().getInfiniteScrollInfiniteScrollKeyword_1_0()); 

            }

             after(grammarAccess.getJdlPaginateTypeAccess().getInfiniteScrollInfiniteScrollKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JdlPaginateType__InfiniteScrollAssignment_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x01F80A0010000002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0003C000003FC010L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000001900000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000006000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000018000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000003C00000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x00000000C0000010L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000040020000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000240000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0600000000000010L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0800000000003000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000100000000000L});

}