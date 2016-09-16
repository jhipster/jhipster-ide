package io.github.jhipster.jdl.dsl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import io.github.jhipster.jdl.dsl.services.JDLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalJDLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'entity'", "'{'", "','", "'}'", "'String'", "'Integer'", "'Long'", "'BigDecimal'", "'Float'", "'Double'", "'Boolean'", "'LocalDate'", "'ZonedDateTime'", "'Blob'", "'AnyBlob'", "'ImageBlob'", "'required'", "'minlength'", "'('", "')'", "'maxlength'", "'pattern'", "'min'", "'max'", "'minbytes'", "'maxbytes'", "'relationship'", "'to'", "'service'", "'with'", "'dto'", "'paginate'", "'angularSuffix'", "'OneToMany'", "'ManyToOne'", "'OneToOne'", "'ManyToMany'", "'serviceClass'", "'serviceImpl'", "'mapstruct'", "'pagination'", "'infiniteScroll'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__51=51;
    public static final int T__52=52;
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

        public InternalJDLParser(TokenStream input, JDLGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "DomainModel";
       	}

       	@Override
       	protected JDLGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleDomainModel"
    // InternalJDL.g:65:1: entryRuleDomainModel returns [EObject current=null] : iv_ruleDomainModel= ruleDomainModel EOF ;
    public final EObject entryRuleDomainModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDomainModel = null;


        try {
            // InternalJDL.g:65:52: (iv_ruleDomainModel= ruleDomainModel EOF )
            // InternalJDL.g:66:2: iv_ruleDomainModel= ruleDomainModel EOF
            {
             newCompositeNode(grammarAccess.getDomainModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDomainModel=ruleDomainModel();

            state._fsp--;

             current =iv_ruleDomainModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDomainModel"


    // $ANTLR start "ruleDomainModel"
    // InternalJDL.g:72:1: ruleDomainModel returns [EObject current=null] : ( (lv_elements_0_0= ruleElements ) )* ;
    public final EObject ruleDomainModel() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:78:2: ( ( (lv_elements_0_0= ruleElements ) )* )
            // InternalJDL.g:79:2: ( (lv_elements_0_0= ruleElements ) )*
            {
            // InternalJDL.g:79:2: ( (lv_elements_0_0= ruleElements ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11||LA1_0==37||LA1_0==39||(LA1_0>=41 && LA1_0<=43)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalJDL.g:80:3: (lv_elements_0_0= ruleElements )
            	    {
            	    // InternalJDL.g:80:3: (lv_elements_0_0= ruleElements )
            	    // InternalJDL.g:81:4: lv_elements_0_0= ruleElements
            	    {

            	    				newCompositeNode(grammarAccess.getDomainModelAccess().getElementsElementsParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_elements_0_0=ruleElements();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getDomainModelRule());
            	    				}
            	    				add(
            	    					current,
            	    					"elements",
            	    					lv_elements_0_0,
            	    					"io.github.jhipster.jdl.dsl.JDL.Elements");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDomainModel"


    // $ANTLR start "entryRuleElements"
    // InternalJDL.g:101:1: entryRuleElements returns [EObject current=null] : iv_ruleElements= ruleElements EOF ;
    public final EObject entryRuleElements() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElements = null;


        try {
            // InternalJDL.g:101:49: (iv_ruleElements= ruleElements EOF )
            // InternalJDL.g:102:2: iv_ruleElements= ruleElements EOF
            {
             newCompositeNode(grammarAccess.getElementsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleElements=ruleElements();

            state._fsp--;

             current =iv_ruleElements; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleElements"


    // $ANTLR start "ruleElements"
    // InternalJDL.g:108:1: ruleElements returns [EObject current=null] : (this_Entity_0= ruleEntity | this_Relationships_1= ruleRelationships | this_GenerationSetting_2= ruleGenerationSetting ) ;
    public final EObject ruleElements() throws RecognitionException {
        EObject current = null;

        EObject this_Entity_0 = null;

        EObject this_Relationships_1 = null;

        EObject this_GenerationSetting_2 = null;



        	enterRule();

        try {
            // InternalJDL.g:114:2: ( (this_Entity_0= ruleEntity | this_Relationships_1= ruleRelationships | this_GenerationSetting_2= ruleGenerationSetting ) )
            // InternalJDL.g:115:2: (this_Entity_0= ruleEntity | this_Relationships_1= ruleRelationships | this_GenerationSetting_2= ruleGenerationSetting )
            {
            // InternalJDL.g:115:2: (this_Entity_0= ruleEntity | this_Relationships_1= ruleRelationships | this_GenerationSetting_2= ruleGenerationSetting )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt2=1;
                }
                break;
            case 37:
                {
                alt2=2;
                }
                break;
            case 39:
            case 41:
            case 42:
            case 43:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalJDL.g:116:3: this_Entity_0= ruleEntity
                    {

                    			newCompositeNode(grammarAccess.getElementsAccess().getEntityParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Entity_0=ruleEntity();

                    state._fsp--;


                    			current = this_Entity_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalJDL.g:125:3: this_Relationships_1= ruleRelationships
                    {

                    			newCompositeNode(grammarAccess.getElementsAccess().getRelationshipsParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Relationships_1=ruleRelationships();

                    state._fsp--;


                    			current = this_Relationships_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalJDL.g:134:3: this_GenerationSetting_2= ruleGenerationSetting
                    {

                    			newCompositeNode(grammarAccess.getElementsAccess().getGenerationSettingParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_GenerationSetting_2=ruleGenerationSetting();

                    state._fsp--;


                    			current = this_GenerationSetting_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleElements"


    // $ANTLR start "entryRuleEntity"
    // InternalJDL.g:146:1: entryRuleEntity returns [EObject current=null] : iv_ruleEntity= ruleEntity EOF ;
    public final EObject entryRuleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntity = null;


        try {
            // InternalJDL.g:146:47: (iv_ruleEntity= ruleEntity EOF )
            // InternalJDL.g:147:2: iv_ruleEntity= ruleEntity EOF
            {
             newCompositeNode(grammarAccess.getEntityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntity=ruleEntity();

            state._fsp--;

             current =iv_ruleEntity; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntity"


    // $ANTLR start "ruleEntity"
    // InternalJDL.g:153:1: ruleEntity returns [EObject current=null] : (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleField ) ) )* otherlv_6= '}' ) ;
    public final EObject ruleEntity() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_fields_3_0 = null;

        EObject lv_fields_5_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:159:2: ( (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleField ) ) )* otherlv_6= '}' ) )
            // InternalJDL.g:160:2: (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleField ) ) )* otherlv_6= '}' )
            {
            // InternalJDL.g:160:2: (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleField ) ) )* otherlv_6= '}' )
            // InternalJDL.g:161:3: otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleField ) ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getEntityAccess().getEntityKeyword_0());
            		
            // InternalJDL.g:165:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalJDL.g:166:4: (lv_name_1_0= RULE_ID )
            {
            // InternalJDL.g:166:4: (lv_name_1_0= RULE_ID )
            // InternalJDL.g:167:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getEntityAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalJDL.g:187:3: ( (lv_fields_3_0= ruleField ) )
            // InternalJDL.g:188:4: (lv_fields_3_0= ruleField )
            {
            // InternalJDL.g:188:4: (lv_fields_3_0= ruleField )
            // InternalJDL.g:189:5: lv_fields_3_0= ruleField
            {

            					newCompositeNode(grammarAccess.getEntityAccess().getFieldsFieldParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_6);
            lv_fields_3_0=ruleField();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEntityRule());
            					}
            					add(
            						current,
            						"fields",
            						lv_fields_3_0,
            						"io.github.jhipster.jdl.dsl.JDL.Field");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalJDL.g:206:3: (otherlv_4= ',' ( (lv_fields_5_0= ruleField ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalJDL.g:207:4: otherlv_4= ',' ( (lv_fields_5_0= ruleField ) )
            	    {
            	    otherlv_4=(Token)match(input,13,FOLLOW_4); 

            	    				newLeafNode(otherlv_4, grammarAccess.getEntityAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalJDL.g:211:4: ( (lv_fields_5_0= ruleField ) )
            	    // InternalJDL.g:212:5: (lv_fields_5_0= ruleField )
            	    {
            	    // InternalJDL.g:212:5: (lv_fields_5_0= ruleField )
            	    // InternalJDL.g:213:6: lv_fields_5_0= ruleField
            	    {

            	    						newCompositeNode(grammarAccess.getEntityAccess().getFieldsFieldParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_6);
            	    lv_fields_5_0=ruleField();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getEntityRule());
            	    						}
            	    						add(
            	    							current,
            	    							"fields",
            	    							lv_fields_5_0,
            	    							"io.github.jhipster.jdl.dsl.JDL.Field");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_6=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getEntityAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntity"


    // $ANTLR start "entryRuleField"
    // InternalJDL.g:239:1: entryRuleField returns [EObject current=null] : iv_ruleField= ruleField EOF ;
    public final EObject entryRuleField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleField = null;


        try {
            // InternalJDL.g:239:46: (iv_ruleField= ruleField EOF )
            // InternalJDL.g:240:2: iv_ruleField= ruleField EOF
            {
             newCompositeNode(grammarAccess.getFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleField=ruleField();

            state._fsp--;

             current =iv_ruleField; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleField"


    // $ANTLR start "ruleField"
    // InternalJDL.g:246:1: ruleField returns [EObject current=null] : (this_StringField_0= ruleStringField | this_NumericField_1= ruleNumericField | this_BooleanField_2= ruleBooleanField | this_DateField_3= ruleDateField | this_BinaryLargeObjectField_4= ruleBinaryLargeObjectField | this_EnumField_5= ruleEnumField ) ;
    public final EObject ruleField() throws RecognitionException {
        EObject current = null;

        EObject this_StringField_0 = null;

        EObject this_NumericField_1 = null;

        EObject this_BooleanField_2 = null;

        EObject this_DateField_3 = null;

        EObject this_BinaryLargeObjectField_4 = null;

        EObject this_EnumField_5 = null;



        	enterRule();

        try {
            // InternalJDL.g:252:2: ( (this_StringField_0= ruleStringField | this_NumericField_1= ruleNumericField | this_BooleanField_2= ruleBooleanField | this_DateField_3= ruleDateField | this_BinaryLargeObjectField_4= ruleBinaryLargeObjectField | this_EnumField_5= ruleEnumField ) )
            // InternalJDL.g:253:2: (this_StringField_0= ruleStringField | this_NumericField_1= ruleNumericField | this_BooleanField_2= ruleBooleanField | this_DateField_3= ruleDateField | this_BinaryLargeObjectField_4= ruleBinaryLargeObjectField | this_EnumField_5= ruleEnumField )
            {
            // InternalJDL.g:253:2: (this_StringField_0= ruleStringField | this_NumericField_1= ruleNumericField | this_BooleanField_2= ruleBooleanField | this_DateField_3= ruleDateField | this_BinaryLargeObjectField_4= ruleBinaryLargeObjectField | this_EnumField_5= ruleEnumField )
            int alt4=6;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                switch ( input.LA(2) ) {
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                    {
                    alt4=2;
                    }
                    break;
                case 15:
                    {
                    alt4=1;
                    }
                    break;
                case 22:
                case 23:
                    {
                    alt4=4;
                    }
                    break;
                case 24:
                case 25:
                case 26:
                    {
                    alt4=5;
                    }
                    break;
                case 21:
                    {
                    alt4=3;
                    }
                    break;
                case EOF:
                case 13:
                case 14:
                    {
                    alt4=6;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalJDL.g:254:3: this_StringField_0= ruleStringField
                    {

                    			newCompositeNode(grammarAccess.getFieldAccess().getStringFieldParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_StringField_0=ruleStringField();

                    state._fsp--;


                    			current = this_StringField_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalJDL.g:263:3: this_NumericField_1= ruleNumericField
                    {

                    			newCompositeNode(grammarAccess.getFieldAccess().getNumericFieldParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_NumericField_1=ruleNumericField();

                    state._fsp--;


                    			current = this_NumericField_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalJDL.g:272:3: this_BooleanField_2= ruleBooleanField
                    {

                    			newCompositeNode(grammarAccess.getFieldAccess().getBooleanFieldParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_BooleanField_2=ruleBooleanField();

                    state._fsp--;


                    			current = this_BooleanField_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalJDL.g:281:3: this_DateField_3= ruleDateField
                    {

                    			newCompositeNode(grammarAccess.getFieldAccess().getDateFieldParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_DateField_3=ruleDateField();

                    state._fsp--;


                    			current = this_DateField_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalJDL.g:290:3: this_BinaryLargeObjectField_4= ruleBinaryLargeObjectField
                    {

                    			newCompositeNode(grammarAccess.getFieldAccess().getBinaryLargeObjectFieldParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_BinaryLargeObjectField_4=ruleBinaryLargeObjectField();

                    state._fsp--;


                    			current = this_BinaryLargeObjectField_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalJDL.g:299:3: this_EnumField_5= ruleEnumField
                    {

                    			newCompositeNode(grammarAccess.getFieldAccess().getEnumFieldParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_EnumField_5=ruleEnumField();

                    state._fsp--;


                    			current = this_EnumField_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleField"


    // $ANTLR start "entryRuleEnumField"
    // InternalJDL.g:311:1: entryRuleEnumField returns [EObject current=null] : iv_ruleEnumField= ruleEnumField EOF ;
    public final EObject entryRuleEnumField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumField = null;


        try {
            // InternalJDL.g:311:50: (iv_ruleEnumField= ruleEnumField EOF )
            // InternalJDL.g:312:2: iv_ruleEnumField= ruleEnumField EOF
            {
             newCompositeNode(grammarAccess.getEnumFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumField=ruleEnumField();

            state._fsp--;

             current =iv_ruleEnumField; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumField"


    // $ANTLR start "ruleEnumField"
    // InternalJDL.g:318:1: ruleEnumField returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleEnumField() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalJDL.g:324:2: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalJDL.g:325:2: ( (otherlv_0= RULE_ID ) )
            {
            // InternalJDL.g:325:2: ( (otherlv_0= RULE_ID ) )
            // InternalJDL.g:326:3: (otherlv_0= RULE_ID )
            {
            // InternalJDL.g:326:3: (otherlv_0= RULE_ID )
            // InternalJDL.g:327:4: otherlv_0= RULE_ID
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getEnumFieldRule());
            				}
            			
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(otherlv_0, grammarAccess.getEnumFieldAccess().getEnumTypeEnumTypeCrossReference_0());
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumField"


    // $ANTLR start "entryRuleStringField"
    // InternalJDL.g:341:1: entryRuleStringField returns [EObject current=null] : iv_ruleStringField= ruleStringField EOF ;
    public final EObject entryRuleStringField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringField = null;


        try {
            // InternalJDL.g:341:52: (iv_ruleStringField= ruleStringField EOF )
            // InternalJDL.g:342:2: iv_ruleStringField= ruleStringField EOF
            {
             newCompositeNode(grammarAccess.getStringFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStringField=ruleStringField();

            state._fsp--;

             current =iv_ruleStringField; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringField"


    // $ANTLR start "ruleStringField"
    // InternalJDL.g:348:1: ruleStringField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'String' ( (lv_validators_2_0= ruleStringValidators ) )? ) ;
    public final EObject ruleStringField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_validators_2_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:354:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'String' ( (lv_validators_2_0= ruleStringValidators ) )? ) )
            // InternalJDL.g:355:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'String' ( (lv_validators_2_0= ruleStringValidators ) )? )
            {
            // InternalJDL.g:355:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'String' ( (lv_validators_2_0= ruleStringValidators ) )? )
            // InternalJDL.g:356:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'String' ( (lv_validators_2_0= ruleStringValidators ) )?
            {
            // InternalJDL.g:356:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalJDL.g:357:4: (lv_name_0_0= RULE_ID )
            {
            // InternalJDL.g:357:4: (lv_name_0_0= RULE_ID )
            // InternalJDL.g:358:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(lv_name_0_0, grammarAccess.getStringFieldAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStringFieldRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,15,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getStringFieldAccess().getStringKeyword_1());
            		
            // InternalJDL.g:378:3: ( (lv_validators_2_0= ruleStringValidators ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==27) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalJDL.g:379:4: (lv_validators_2_0= ruleStringValidators )
                    {
                    // InternalJDL.g:379:4: (lv_validators_2_0= ruleStringValidators )
                    // InternalJDL.g:380:5: lv_validators_2_0= ruleStringValidators
                    {

                    					newCompositeNode(grammarAccess.getStringFieldAccess().getValidatorsStringValidatorsParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_2_0=ruleStringValidators();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getStringFieldRule());
                    					}
                    					set(
                    						current,
                    						"validators",
                    						lv_validators_2_0,
                    						"io.github.jhipster.jdl.dsl.JDL.StringValidators");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringField"


    // $ANTLR start "entryRuleNumericField"
    // InternalJDL.g:401:1: entryRuleNumericField returns [EObject current=null] : iv_ruleNumericField= ruleNumericField EOF ;
    public final EObject entryRuleNumericField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericField = null;


        try {
            // InternalJDL.g:401:53: (iv_ruleNumericField= ruleNumericField EOF )
            // InternalJDL.g:402:2: iv_ruleNumericField= ruleNumericField EOF
            {
             newCompositeNode(grammarAccess.getNumericFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumericField=ruleNumericField();

            state._fsp--;

             current =iv_ruleNumericField; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumericField"


    // $ANTLR start "ruleNumericField"
    // InternalJDL.g:408:1: ruleNumericField returns [EObject current=null] : (this_IntegerField_0= ruleIntegerField | this_LongField_1= ruleLongField | this_BigDecimalField_2= ruleBigDecimalField | this_FloatField_3= ruleFloatField | this_DoubleField_4= ruleDoubleField ) ;
    public final EObject ruleNumericField() throws RecognitionException {
        EObject current = null;

        EObject this_IntegerField_0 = null;

        EObject this_LongField_1 = null;

        EObject this_BigDecimalField_2 = null;

        EObject this_FloatField_3 = null;

        EObject this_DoubleField_4 = null;



        	enterRule();

        try {
            // InternalJDL.g:414:2: ( (this_IntegerField_0= ruleIntegerField | this_LongField_1= ruleLongField | this_BigDecimalField_2= ruleBigDecimalField | this_FloatField_3= ruleFloatField | this_DoubleField_4= ruleDoubleField ) )
            // InternalJDL.g:415:2: (this_IntegerField_0= ruleIntegerField | this_LongField_1= ruleLongField | this_BigDecimalField_2= ruleBigDecimalField | this_FloatField_3= ruleFloatField | this_DoubleField_4= ruleDoubleField )
            {
            // InternalJDL.g:415:2: (this_IntegerField_0= ruleIntegerField | this_LongField_1= ruleLongField | this_BigDecimalField_2= ruleBigDecimalField | this_FloatField_3= ruleFloatField | this_DoubleField_4= ruleDoubleField )
            int alt6=5;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                switch ( input.LA(2) ) {
                case 16:
                    {
                    alt6=1;
                    }
                    break;
                case 18:
                    {
                    alt6=3;
                    }
                    break;
                case 20:
                    {
                    alt6=5;
                    }
                    break;
                case 17:
                    {
                    alt6=2;
                    }
                    break;
                case 19:
                    {
                    alt6=4;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalJDL.g:416:3: this_IntegerField_0= ruleIntegerField
                    {

                    			newCompositeNode(grammarAccess.getNumericFieldAccess().getIntegerFieldParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_IntegerField_0=ruleIntegerField();

                    state._fsp--;


                    			current = this_IntegerField_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalJDL.g:425:3: this_LongField_1= ruleLongField
                    {

                    			newCompositeNode(grammarAccess.getNumericFieldAccess().getLongFieldParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_LongField_1=ruleLongField();

                    state._fsp--;


                    			current = this_LongField_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalJDL.g:434:3: this_BigDecimalField_2= ruleBigDecimalField
                    {

                    			newCompositeNode(grammarAccess.getNumericFieldAccess().getBigDecimalFieldParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_BigDecimalField_2=ruleBigDecimalField();

                    state._fsp--;


                    			current = this_BigDecimalField_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalJDL.g:443:3: this_FloatField_3= ruleFloatField
                    {

                    			newCompositeNode(grammarAccess.getNumericFieldAccess().getFloatFieldParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_FloatField_3=ruleFloatField();

                    state._fsp--;


                    			current = this_FloatField_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalJDL.g:452:3: this_DoubleField_4= ruleDoubleField
                    {

                    			newCompositeNode(grammarAccess.getNumericFieldAccess().getDoubleFieldParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_DoubleField_4=ruleDoubleField();

                    state._fsp--;


                    			current = this_DoubleField_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumericField"


    // $ANTLR start "entryRuleIntegerField"
    // InternalJDL.g:464:1: entryRuleIntegerField returns [EObject current=null] : iv_ruleIntegerField= ruleIntegerField EOF ;
    public final EObject entryRuleIntegerField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerField = null;


        try {
            // InternalJDL.g:464:53: (iv_ruleIntegerField= ruleIntegerField EOF )
            // InternalJDL.g:465:2: iv_ruleIntegerField= ruleIntegerField EOF
            {
             newCompositeNode(grammarAccess.getIntegerFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntegerField=ruleIntegerField();

            state._fsp--;

             current =iv_ruleIntegerField; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntegerField"


    // $ANTLR start "ruleIntegerField"
    // InternalJDL.g:471:1: ruleIntegerField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Integer' ( (lv_validators_2_0= ruleNumericValidators ) )? ) ;
    public final EObject ruleIntegerField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_validators_2_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:477:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Integer' ( (lv_validators_2_0= ruleNumericValidators ) )? ) )
            // InternalJDL.g:478:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Integer' ( (lv_validators_2_0= ruleNumericValidators ) )? )
            {
            // InternalJDL.g:478:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Integer' ( (lv_validators_2_0= ruleNumericValidators ) )? )
            // InternalJDL.g:479:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Integer' ( (lv_validators_2_0= ruleNumericValidators ) )?
            {
            // InternalJDL.g:479:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalJDL.g:480:4: (lv_name_0_0= RULE_ID )
            {
            // InternalJDL.g:480:4: (lv_name_0_0= RULE_ID )
            // InternalJDL.g:481:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(lv_name_0_0, grammarAccess.getIntegerFieldAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getIntegerFieldRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,16,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getIntegerFieldAccess().getIntegerKeyword_1());
            		
            // InternalJDL.g:501:3: ( (lv_validators_2_0= ruleNumericValidators ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==27) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalJDL.g:502:4: (lv_validators_2_0= ruleNumericValidators )
                    {
                    // InternalJDL.g:502:4: (lv_validators_2_0= ruleNumericValidators )
                    // InternalJDL.g:503:5: lv_validators_2_0= ruleNumericValidators
                    {

                    					newCompositeNode(grammarAccess.getIntegerFieldAccess().getValidatorsNumericValidatorsParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_2_0=ruleNumericValidators();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getIntegerFieldRule());
                    					}
                    					set(
                    						current,
                    						"validators",
                    						lv_validators_2_0,
                    						"io.github.jhipster.jdl.dsl.JDL.NumericValidators");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntegerField"


    // $ANTLR start "entryRuleLongField"
    // InternalJDL.g:524:1: entryRuleLongField returns [EObject current=null] : iv_ruleLongField= ruleLongField EOF ;
    public final EObject entryRuleLongField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLongField = null;


        try {
            // InternalJDL.g:524:50: (iv_ruleLongField= ruleLongField EOF )
            // InternalJDL.g:525:2: iv_ruleLongField= ruleLongField EOF
            {
             newCompositeNode(grammarAccess.getLongFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLongField=ruleLongField();

            state._fsp--;

             current =iv_ruleLongField; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLongField"


    // $ANTLR start "ruleLongField"
    // InternalJDL.g:531:1: ruleLongField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Long' ( (lv_validators_2_0= ruleNumericValidators ) )? ) ;
    public final EObject ruleLongField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_validators_2_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:537:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Long' ( (lv_validators_2_0= ruleNumericValidators ) )? ) )
            // InternalJDL.g:538:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Long' ( (lv_validators_2_0= ruleNumericValidators ) )? )
            {
            // InternalJDL.g:538:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Long' ( (lv_validators_2_0= ruleNumericValidators ) )? )
            // InternalJDL.g:539:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Long' ( (lv_validators_2_0= ruleNumericValidators ) )?
            {
            // InternalJDL.g:539:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalJDL.g:540:4: (lv_name_0_0= RULE_ID )
            {
            // InternalJDL.g:540:4: (lv_name_0_0= RULE_ID )
            // InternalJDL.g:541:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_0_0, grammarAccess.getLongFieldAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLongFieldRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getLongFieldAccess().getLongKeyword_1());
            		
            // InternalJDL.g:561:3: ( (lv_validators_2_0= ruleNumericValidators ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==27) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalJDL.g:562:4: (lv_validators_2_0= ruleNumericValidators )
                    {
                    // InternalJDL.g:562:4: (lv_validators_2_0= ruleNumericValidators )
                    // InternalJDL.g:563:5: lv_validators_2_0= ruleNumericValidators
                    {

                    					newCompositeNode(grammarAccess.getLongFieldAccess().getValidatorsNumericValidatorsParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_2_0=ruleNumericValidators();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getLongFieldRule());
                    					}
                    					set(
                    						current,
                    						"validators",
                    						lv_validators_2_0,
                    						"io.github.jhipster.jdl.dsl.JDL.NumericValidators");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLongField"


    // $ANTLR start "entryRuleBigDecimalField"
    // InternalJDL.g:584:1: entryRuleBigDecimalField returns [EObject current=null] : iv_ruleBigDecimalField= ruleBigDecimalField EOF ;
    public final EObject entryRuleBigDecimalField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBigDecimalField = null;


        try {
            // InternalJDL.g:584:56: (iv_ruleBigDecimalField= ruleBigDecimalField EOF )
            // InternalJDL.g:585:2: iv_ruleBigDecimalField= ruleBigDecimalField EOF
            {
             newCompositeNode(grammarAccess.getBigDecimalFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBigDecimalField=ruleBigDecimalField();

            state._fsp--;

             current =iv_ruleBigDecimalField; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBigDecimalField"


    // $ANTLR start "ruleBigDecimalField"
    // InternalJDL.g:591:1: ruleBigDecimalField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'BigDecimal' ( (lv_validators_2_0= ruleNumericValidators ) )? ) ;
    public final EObject ruleBigDecimalField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_validators_2_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:597:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'BigDecimal' ( (lv_validators_2_0= ruleNumericValidators ) )? ) )
            // InternalJDL.g:598:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'BigDecimal' ( (lv_validators_2_0= ruleNumericValidators ) )? )
            {
            // InternalJDL.g:598:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'BigDecimal' ( (lv_validators_2_0= ruleNumericValidators ) )? )
            // InternalJDL.g:599:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'BigDecimal' ( (lv_validators_2_0= ruleNumericValidators ) )?
            {
            // InternalJDL.g:599:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalJDL.g:600:4: (lv_name_0_0= RULE_ID )
            {
            // InternalJDL.g:600:4: (lv_name_0_0= RULE_ID )
            // InternalJDL.g:601:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_11); 

            					newLeafNode(lv_name_0_0, grammarAccess.getBigDecimalFieldAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBigDecimalFieldRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getBigDecimalFieldAccess().getBigDecimalKeyword_1());
            		
            // InternalJDL.g:621:3: ( (lv_validators_2_0= ruleNumericValidators ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==27) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalJDL.g:622:4: (lv_validators_2_0= ruleNumericValidators )
                    {
                    // InternalJDL.g:622:4: (lv_validators_2_0= ruleNumericValidators )
                    // InternalJDL.g:623:5: lv_validators_2_0= ruleNumericValidators
                    {

                    					newCompositeNode(grammarAccess.getBigDecimalFieldAccess().getValidatorsNumericValidatorsParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_2_0=ruleNumericValidators();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getBigDecimalFieldRule());
                    					}
                    					set(
                    						current,
                    						"validators",
                    						lv_validators_2_0,
                    						"io.github.jhipster.jdl.dsl.JDL.NumericValidators");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBigDecimalField"


    // $ANTLR start "entryRuleFloatField"
    // InternalJDL.g:644:1: entryRuleFloatField returns [EObject current=null] : iv_ruleFloatField= ruleFloatField EOF ;
    public final EObject entryRuleFloatField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFloatField = null;


        try {
            // InternalJDL.g:644:51: (iv_ruleFloatField= ruleFloatField EOF )
            // InternalJDL.g:645:2: iv_ruleFloatField= ruleFloatField EOF
            {
             newCompositeNode(grammarAccess.getFloatFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFloatField=ruleFloatField();

            state._fsp--;

             current =iv_ruleFloatField; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFloatField"


    // $ANTLR start "ruleFloatField"
    // InternalJDL.g:651:1: ruleFloatField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Float' ( (lv_validators_2_0= ruleNumericValidators ) )? ) ;
    public final EObject ruleFloatField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_validators_2_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:657:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Float' ( (lv_validators_2_0= ruleNumericValidators ) )? ) )
            // InternalJDL.g:658:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Float' ( (lv_validators_2_0= ruleNumericValidators ) )? )
            {
            // InternalJDL.g:658:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Float' ( (lv_validators_2_0= ruleNumericValidators ) )? )
            // InternalJDL.g:659:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Float' ( (lv_validators_2_0= ruleNumericValidators ) )?
            {
            // InternalJDL.g:659:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalJDL.g:660:4: (lv_name_0_0= RULE_ID )
            {
            // InternalJDL.g:660:4: (lv_name_0_0= RULE_ID )
            // InternalJDL.g:661:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_12); 

            					newLeafNode(lv_name_0_0, grammarAccess.getFloatFieldAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFloatFieldRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,19,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getFloatFieldAccess().getFloatKeyword_1());
            		
            // InternalJDL.g:681:3: ( (lv_validators_2_0= ruleNumericValidators ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==27) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalJDL.g:682:4: (lv_validators_2_0= ruleNumericValidators )
                    {
                    // InternalJDL.g:682:4: (lv_validators_2_0= ruleNumericValidators )
                    // InternalJDL.g:683:5: lv_validators_2_0= ruleNumericValidators
                    {

                    					newCompositeNode(grammarAccess.getFloatFieldAccess().getValidatorsNumericValidatorsParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_2_0=ruleNumericValidators();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getFloatFieldRule());
                    					}
                    					set(
                    						current,
                    						"validators",
                    						lv_validators_2_0,
                    						"io.github.jhipster.jdl.dsl.JDL.NumericValidators");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFloatField"


    // $ANTLR start "entryRuleDoubleField"
    // InternalJDL.g:704:1: entryRuleDoubleField returns [EObject current=null] : iv_ruleDoubleField= ruleDoubleField EOF ;
    public final EObject entryRuleDoubleField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoubleField = null;


        try {
            // InternalJDL.g:704:52: (iv_ruleDoubleField= ruleDoubleField EOF )
            // InternalJDL.g:705:2: iv_ruleDoubleField= ruleDoubleField EOF
            {
             newCompositeNode(grammarAccess.getDoubleFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDoubleField=ruleDoubleField();

            state._fsp--;

             current =iv_ruleDoubleField; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDoubleField"


    // $ANTLR start "ruleDoubleField"
    // InternalJDL.g:711:1: ruleDoubleField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Double' ( (lv_validators_2_0= ruleNumericValidators ) )? ) ;
    public final EObject ruleDoubleField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_validators_2_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:717:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Double' ( (lv_validators_2_0= ruleNumericValidators ) )? ) )
            // InternalJDL.g:718:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Double' ( (lv_validators_2_0= ruleNumericValidators ) )? )
            {
            // InternalJDL.g:718:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Double' ( (lv_validators_2_0= ruleNumericValidators ) )? )
            // InternalJDL.g:719:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Double' ( (lv_validators_2_0= ruleNumericValidators ) )?
            {
            // InternalJDL.g:719:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalJDL.g:720:4: (lv_name_0_0= RULE_ID )
            {
            // InternalJDL.g:720:4: (lv_name_0_0= RULE_ID )
            // InternalJDL.g:721:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(lv_name_0_0, grammarAccess.getDoubleFieldAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDoubleFieldRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,20,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getDoubleFieldAccess().getDoubleKeyword_1());
            		
            // InternalJDL.g:741:3: ( (lv_validators_2_0= ruleNumericValidators ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==27) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalJDL.g:742:4: (lv_validators_2_0= ruleNumericValidators )
                    {
                    // InternalJDL.g:742:4: (lv_validators_2_0= ruleNumericValidators )
                    // InternalJDL.g:743:5: lv_validators_2_0= ruleNumericValidators
                    {

                    					newCompositeNode(grammarAccess.getDoubleFieldAccess().getValidatorsNumericValidatorsParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_2_0=ruleNumericValidators();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getDoubleFieldRule());
                    					}
                    					set(
                    						current,
                    						"validators",
                    						lv_validators_2_0,
                    						"io.github.jhipster.jdl.dsl.JDL.NumericValidators");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDoubleField"


    // $ANTLR start "entryRuleBooleanField"
    // InternalJDL.g:764:1: entryRuleBooleanField returns [EObject current=null] : iv_ruleBooleanField= ruleBooleanField EOF ;
    public final EObject entryRuleBooleanField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanField = null;


        try {
            // InternalJDL.g:764:53: (iv_ruleBooleanField= ruleBooleanField EOF )
            // InternalJDL.g:765:2: iv_ruleBooleanField= ruleBooleanField EOF
            {
             newCompositeNode(grammarAccess.getBooleanFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBooleanField=ruleBooleanField();

            state._fsp--;

             current =iv_ruleBooleanField; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanField"


    // $ANTLR start "ruleBooleanField"
    // InternalJDL.g:771:1: ruleBooleanField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Boolean' ( (lv_validators_2_0= ruleRequiredValidator ) )? ) ;
    public final EObject ruleBooleanField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_validators_2_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:777:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Boolean' ( (lv_validators_2_0= ruleRequiredValidator ) )? ) )
            // InternalJDL.g:778:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Boolean' ( (lv_validators_2_0= ruleRequiredValidator ) )? )
            {
            // InternalJDL.g:778:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Boolean' ( (lv_validators_2_0= ruleRequiredValidator ) )? )
            // InternalJDL.g:779:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Boolean' ( (lv_validators_2_0= ruleRequiredValidator ) )?
            {
            // InternalJDL.g:779:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalJDL.g:780:4: (lv_name_0_0= RULE_ID )
            {
            // InternalJDL.g:780:4: (lv_name_0_0= RULE_ID )
            // InternalJDL.g:781:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_14); 

            					newLeafNode(lv_name_0_0, grammarAccess.getBooleanFieldAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBooleanFieldRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,21,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getBooleanFieldAccess().getBooleanKeyword_1());
            		
            // InternalJDL.g:801:3: ( (lv_validators_2_0= ruleRequiredValidator ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==27) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalJDL.g:802:4: (lv_validators_2_0= ruleRequiredValidator )
                    {
                    // InternalJDL.g:802:4: (lv_validators_2_0= ruleRequiredValidator )
                    // InternalJDL.g:803:5: lv_validators_2_0= ruleRequiredValidator
                    {

                    					newCompositeNode(grammarAccess.getBooleanFieldAccess().getValidatorsRequiredValidatorParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_2_0=ruleRequiredValidator();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getBooleanFieldRule());
                    					}
                    					set(
                    						current,
                    						"validators",
                    						lv_validators_2_0,
                    						"io.github.jhipster.jdl.dsl.JDL.RequiredValidator");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanField"


    // $ANTLR start "entryRuleDateField"
    // InternalJDL.g:824:1: entryRuleDateField returns [EObject current=null] : iv_ruleDateField= ruleDateField EOF ;
    public final EObject entryRuleDateField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDateField = null;


        try {
            // InternalJDL.g:824:50: (iv_ruleDateField= ruleDateField EOF )
            // InternalJDL.g:825:2: iv_ruleDateField= ruleDateField EOF
            {
             newCompositeNode(grammarAccess.getDateFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDateField=ruleDateField();

            state._fsp--;

             current =iv_ruleDateField; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDateField"


    // $ANTLR start "ruleDateField"
    // InternalJDL.g:831:1: ruleDateField returns [EObject current=null] : (this_LocalDateField_0= ruleLocalDateField | this_ZonedDateTimeField_1= ruleZonedDateTimeField ) ;
    public final EObject ruleDateField() throws RecognitionException {
        EObject current = null;

        EObject this_LocalDateField_0 = null;

        EObject this_ZonedDateTimeField_1 = null;



        	enterRule();

        try {
            // InternalJDL.g:837:2: ( (this_LocalDateField_0= ruleLocalDateField | this_ZonedDateTimeField_1= ruleZonedDateTimeField ) )
            // InternalJDL.g:838:2: (this_LocalDateField_0= ruleLocalDateField | this_ZonedDateTimeField_1= ruleZonedDateTimeField )
            {
            // InternalJDL.g:838:2: (this_LocalDateField_0= ruleLocalDateField | this_ZonedDateTimeField_1= ruleZonedDateTimeField )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==23) ) {
                    alt13=2;
                }
                else if ( (LA13_1==22) ) {
                    alt13=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalJDL.g:839:3: this_LocalDateField_0= ruleLocalDateField
                    {

                    			newCompositeNode(grammarAccess.getDateFieldAccess().getLocalDateFieldParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_LocalDateField_0=ruleLocalDateField();

                    state._fsp--;


                    			current = this_LocalDateField_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalJDL.g:848:3: this_ZonedDateTimeField_1= ruleZonedDateTimeField
                    {

                    			newCompositeNode(grammarAccess.getDateFieldAccess().getZonedDateTimeFieldParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ZonedDateTimeField_1=ruleZonedDateTimeField();

                    state._fsp--;


                    			current = this_ZonedDateTimeField_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDateField"


    // $ANTLR start "entryRuleLocalDateField"
    // InternalJDL.g:860:1: entryRuleLocalDateField returns [EObject current=null] : iv_ruleLocalDateField= ruleLocalDateField EOF ;
    public final EObject entryRuleLocalDateField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLocalDateField = null;


        try {
            // InternalJDL.g:860:55: (iv_ruleLocalDateField= ruleLocalDateField EOF )
            // InternalJDL.g:861:2: iv_ruleLocalDateField= ruleLocalDateField EOF
            {
             newCompositeNode(grammarAccess.getLocalDateFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLocalDateField=ruleLocalDateField();

            state._fsp--;

             current =iv_ruleLocalDateField; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLocalDateField"


    // $ANTLR start "ruleLocalDateField"
    // InternalJDL.g:867:1: ruleLocalDateField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'LocalDate' ( (lv_validators_2_0= ruleRequiredValidator ) )? ) ;
    public final EObject ruleLocalDateField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_validators_2_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:873:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'LocalDate' ( (lv_validators_2_0= ruleRequiredValidator ) )? ) )
            // InternalJDL.g:874:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'LocalDate' ( (lv_validators_2_0= ruleRequiredValidator ) )? )
            {
            // InternalJDL.g:874:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'LocalDate' ( (lv_validators_2_0= ruleRequiredValidator ) )? )
            // InternalJDL.g:875:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'LocalDate' ( (lv_validators_2_0= ruleRequiredValidator ) )?
            {
            // InternalJDL.g:875:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalJDL.g:876:4: (lv_name_0_0= RULE_ID )
            {
            // InternalJDL.g:876:4: (lv_name_0_0= RULE_ID )
            // InternalJDL.g:877:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_15); 

            					newLeafNode(lv_name_0_0, grammarAccess.getLocalDateFieldAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLocalDateFieldRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,22,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getLocalDateFieldAccess().getLocalDateKeyword_1());
            		
            // InternalJDL.g:897:3: ( (lv_validators_2_0= ruleRequiredValidator ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==27) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalJDL.g:898:4: (lv_validators_2_0= ruleRequiredValidator )
                    {
                    // InternalJDL.g:898:4: (lv_validators_2_0= ruleRequiredValidator )
                    // InternalJDL.g:899:5: lv_validators_2_0= ruleRequiredValidator
                    {

                    					newCompositeNode(grammarAccess.getLocalDateFieldAccess().getValidatorsRequiredValidatorParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_2_0=ruleRequiredValidator();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getLocalDateFieldRule());
                    					}
                    					set(
                    						current,
                    						"validators",
                    						lv_validators_2_0,
                    						"io.github.jhipster.jdl.dsl.JDL.RequiredValidator");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLocalDateField"


    // $ANTLR start "entryRuleZonedDateTimeField"
    // InternalJDL.g:920:1: entryRuleZonedDateTimeField returns [EObject current=null] : iv_ruleZonedDateTimeField= ruleZonedDateTimeField EOF ;
    public final EObject entryRuleZonedDateTimeField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleZonedDateTimeField = null;


        try {
            // InternalJDL.g:920:59: (iv_ruleZonedDateTimeField= ruleZonedDateTimeField EOF )
            // InternalJDL.g:921:2: iv_ruleZonedDateTimeField= ruleZonedDateTimeField EOF
            {
             newCompositeNode(grammarAccess.getZonedDateTimeFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleZonedDateTimeField=ruleZonedDateTimeField();

            state._fsp--;

             current =iv_ruleZonedDateTimeField; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleZonedDateTimeField"


    // $ANTLR start "ruleZonedDateTimeField"
    // InternalJDL.g:927:1: ruleZonedDateTimeField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'ZonedDateTime' ( (lv_validators_2_0= ruleRequiredValidator ) )? ) ;
    public final EObject ruleZonedDateTimeField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_validators_2_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:933:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'ZonedDateTime' ( (lv_validators_2_0= ruleRequiredValidator ) )? ) )
            // InternalJDL.g:934:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'ZonedDateTime' ( (lv_validators_2_0= ruleRequiredValidator ) )? )
            {
            // InternalJDL.g:934:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'ZonedDateTime' ( (lv_validators_2_0= ruleRequiredValidator ) )? )
            // InternalJDL.g:935:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'ZonedDateTime' ( (lv_validators_2_0= ruleRequiredValidator ) )?
            {
            // InternalJDL.g:935:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalJDL.g:936:4: (lv_name_0_0= RULE_ID )
            {
            // InternalJDL.g:936:4: (lv_name_0_0= RULE_ID )
            // InternalJDL.g:937:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_16); 

            					newLeafNode(lv_name_0_0, grammarAccess.getZonedDateTimeFieldAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getZonedDateTimeFieldRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,23,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getZonedDateTimeFieldAccess().getZonedDateTimeKeyword_1());
            		
            // InternalJDL.g:957:3: ( (lv_validators_2_0= ruleRequiredValidator ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==27) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalJDL.g:958:4: (lv_validators_2_0= ruleRequiredValidator )
                    {
                    // InternalJDL.g:958:4: (lv_validators_2_0= ruleRequiredValidator )
                    // InternalJDL.g:959:5: lv_validators_2_0= ruleRequiredValidator
                    {

                    					newCompositeNode(grammarAccess.getZonedDateTimeFieldAccess().getValidatorsRequiredValidatorParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_2_0=ruleRequiredValidator();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getZonedDateTimeFieldRule());
                    					}
                    					set(
                    						current,
                    						"validators",
                    						lv_validators_2_0,
                    						"io.github.jhipster.jdl.dsl.JDL.RequiredValidator");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleZonedDateTimeField"


    // $ANTLR start "entryRuleBinaryLargeObjectField"
    // InternalJDL.g:980:1: entryRuleBinaryLargeObjectField returns [EObject current=null] : iv_ruleBinaryLargeObjectField= ruleBinaryLargeObjectField EOF ;
    public final EObject entryRuleBinaryLargeObjectField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryLargeObjectField = null;


        try {
            // InternalJDL.g:980:63: (iv_ruleBinaryLargeObjectField= ruleBinaryLargeObjectField EOF )
            // InternalJDL.g:981:2: iv_ruleBinaryLargeObjectField= ruleBinaryLargeObjectField EOF
            {
             newCompositeNode(grammarAccess.getBinaryLargeObjectFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBinaryLargeObjectField=ruleBinaryLargeObjectField();

            state._fsp--;

             current =iv_ruleBinaryLargeObjectField; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBinaryLargeObjectField"


    // $ANTLR start "ruleBinaryLargeObjectField"
    // InternalJDL.g:987:1: ruleBinaryLargeObjectField returns [EObject current=null] : (this_BlobField_0= ruleBlobField | this_AnyBlobField_1= ruleAnyBlobField | this_ImageBlobField_2= ruleImageBlobField ) ;
    public final EObject ruleBinaryLargeObjectField() throws RecognitionException {
        EObject current = null;

        EObject this_BlobField_0 = null;

        EObject this_AnyBlobField_1 = null;

        EObject this_ImageBlobField_2 = null;



        	enterRule();

        try {
            // InternalJDL.g:993:2: ( (this_BlobField_0= ruleBlobField | this_AnyBlobField_1= ruleAnyBlobField | this_ImageBlobField_2= ruleImageBlobField ) )
            // InternalJDL.g:994:2: (this_BlobField_0= ruleBlobField | this_AnyBlobField_1= ruleAnyBlobField | this_ImageBlobField_2= ruleImageBlobField )
            {
            // InternalJDL.g:994:2: (this_BlobField_0= ruleBlobField | this_AnyBlobField_1= ruleAnyBlobField | this_ImageBlobField_2= ruleImageBlobField )
            int alt16=3;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID) ) {
                switch ( input.LA(2) ) {
                case 24:
                    {
                    alt16=1;
                    }
                    break;
                case 26:
                    {
                    alt16=3;
                    }
                    break;
                case 25:
                    {
                    alt16=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalJDL.g:995:3: this_BlobField_0= ruleBlobField
                    {

                    			newCompositeNode(grammarAccess.getBinaryLargeObjectFieldAccess().getBlobFieldParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_BlobField_0=ruleBlobField();

                    state._fsp--;


                    			current = this_BlobField_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalJDL.g:1004:3: this_AnyBlobField_1= ruleAnyBlobField
                    {

                    			newCompositeNode(grammarAccess.getBinaryLargeObjectFieldAccess().getAnyBlobFieldParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_AnyBlobField_1=ruleAnyBlobField();

                    state._fsp--;


                    			current = this_AnyBlobField_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalJDL.g:1013:3: this_ImageBlobField_2= ruleImageBlobField
                    {

                    			newCompositeNode(grammarAccess.getBinaryLargeObjectFieldAccess().getImageBlobFieldParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ImageBlobField_2=ruleImageBlobField();

                    state._fsp--;


                    			current = this_ImageBlobField_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBinaryLargeObjectField"


    // $ANTLR start "entryRuleBlobField"
    // InternalJDL.g:1025:1: entryRuleBlobField returns [EObject current=null] : iv_ruleBlobField= ruleBlobField EOF ;
    public final EObject entryRuleBlobField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlobField = null;


        try {
            // InternalJDL.g:1025:50: (iv_ruleBlobField= ruleBlobField EOF )
            // InternalJDL.g:1026:2: iv_ruleBlobField= ruleBlobField EOF
            {
             newCompositeNode(grammarAccess.getBlobFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBlobField=ruleBlobField();

            state._fsp--;

             current =iv_ruleBlobField; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBlobField"


    // $ANTLR start "ruleBlobField"
    // InternalJDL.g:1032:1: ruleBlobField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Blob' ( (lv_validators_2_0= ruleBlobValidators ) )? ) ;
    public final EObject ruleBlobField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_validators_2_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:1038:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Blob' ( (lv_validators_2_0= ruleBlobValidators ) )? ) )
            // InternalJDL.g:1039:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Blob' ( (lv_validators_2_0= ruleBlobValidators ) )? )
            {
            // InternalJDL.g:1039:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Blob' ( (lv_validators_2_0= ruleBlobValidators ) )? )
            // InternalJDL.g:1040:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Blob' ( (lv_validators_2_0= ruleBlobValidators ) )?
            {
            // InternalJDL.g:1040:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalJDL.g:1041:4: (lv_name_0_0= RULE_ID )
            {
            // InternalJDL.g:1041:4: (lv_name_0_0= RULE_ID )
            // InternalJDL.g:1042:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_17); 

            					newLeafNode(lv_name_0_0, grammarAccess.getBlobFieldAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBlobFieldRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,24,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getBlobFieldAccess().getBlobKeyword_1());
            		
            // InternalJDL.g:1062:3: ( (lv_validators_2_0= ruleBlobValidators ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==27) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalJDL.g:1063:4: (lv_validators_2_0= ruleBlobValidators )
                    {
                    // InternalJDL.g:1063:4: (lv_validators_2_0= ruleBlobValidators )
                    // InternalJDL.g:1064:5: lv_validators_2_0= ruleBlobValidators
                    {

                    					newCompositeNode(grammarAccess.getBlobFieldAccess().getValidatorsBlobValidatorsParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_2_0=ruleBlobValidators();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getBlobFieldRule());
                    					}
                    					set(
                    						current,
                    						"validators",
                    						lv_validators_2_0,
                    						"io.github.jhipster.jdl.dsl.JDL.BlobValidators");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBlobField"


    // $ANTLR start "entryRuleAnyBlobField"
    // InternalJDL.g:1085:1: entryRuleAnyBlobField returns [EObject current=null] : iv_ruleAnyBlobField= ruleAnyBlobField EOF ;
    public final EObject entryRuleAnyBlobField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnyBlobField = null;


        try {
            // InternalJDL.g:1085:53: (iv_ruleAnyBlobField= ruleAnyBlobField EOF )
            // InternalJDL.g:1086:2: iv_ruleAnyBlobField= ruleAnyBlobField EOF
            {
             newCompositeNode(grammarAccess.getAnyBlobFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAnyBlobField=ruleAnyBlobField();

            state._fsp--;

             current =iv_ruleAnyBlobField; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnyBlobField"


    // $ANTLR start "ruleAnyBlobField"
    // InternalJDL.g:1092:1: ruleAnyBlobField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'AnyBlob' ( (lv_validators_2_0= ruleBlobValidators ) )? ) ;
    public final EObject ruleAnyBlobField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_validators_2_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:1098:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'AnyBlob' ( (lv_validators_2_0= ruleBlobValidators ) )? ) )
            // InternalJDL.g:1099:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'AnyBlob' ( (lv_validators_2_0= ruleBlobValidators ) )? )
            {
            // InternalJDL.g:1099:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'AnyBlob' ( (lv_validators_2_0= ruleBlobValidators ) )? )
            // InternalJDL.g:1100:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'AnyBlob' ( (lv_validators_2_0= ruleBlobValidators ) )?
            {
            // InternalJDL.g:1100:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalJDL.g:1101:4: (lv_name_0_0= RULE_ID )
            {
            // InternalJDL.g:1101:4: (lv_name_0_0= RULE_ID )
            // InternalJDL.g:1102:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_18); 

            					newLeafNode(lv_name_0_0, grammarAccess.getAnyBlobFieldAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAnyBlobFieldRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,25,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getAnyBlobFieldAccess().getAnyBlobKeyword_1());
            		
            // InternalJDL.g:1122:3: ( (lv_validators_2_0= ruleBlobValidators ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==27) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalJDL.g:1123:4: (lv_validators_2_0= ruleBlobValidators )
                    {
                    // InternalJDL.g:1123:4: (lv_validators_2_0= ruleBlobValidators )
                    // InternalJDL.g:1124:5: lv_validators_2_0= ruleBlobValidators
                    {

                    					newCompositeNode(grammarAccess.getAnyBlobFieldAccess().getValidatorsBlobValidatorsParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_2_0=ruleBlobValidators();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getAnyBlobFieldRule());
                    					}
                    					set(
                    						current,
                    						"validators",
                    						lv_validators_2_0,
                    						"io.github.jhipster.jdl.dsl.JDL.BlobValidators");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnyBlobField"


    // $ANTLR start "entryRuleImageBlobField"
    // InternalJDL.g:1145:1: entryRuleImageBlobField returns [EObject current=null] : iv_ruleImageBlobField= ruleImageBlobField EOF ;
    public final EObject entryRuleImageBlobField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImageBlobField = null;


        try {
            // InternalJDL.g:1145:55: (iv_ruleImageBlobField= ruleImageBlobField EOF )
            // InternalJDL.g:1146:2: iv_ruleImageBlobField= ruleImageBlobField EOF
            {
             newCompositeNode(grammarAccess.getImageBlobFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImageBlobField=ruleImageBlobField();

            state._fsp--;

             current =iv_ruleImageBlobField; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImageBlobField"


    // $ANTLR start "ruleImageBlobField"
    // InternalJDL.g:1152:1: ruleImageBlobField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'ImageBlob' ( (lv_validators_2_0= ruleBlobValidators ) )? ) ;
    public final EObject ruleImageBlobField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_validators_2_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:1158:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'ImageBlob' ( (lv_validators_2_0= ruleBlobValidators ) )? ) )
            // InternalJDL.g:1159:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'ImageBlob' ( (lv_validators_2_0= ruleBlobValidators ) )? )
            {
            // InternalJDL.g:1159:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'ImageBlob' ( (lv_validators_2_0= ruleBlobValidators ) )? )
            // InternalJDL.g:1160:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'ImageBlob' ( (lv_validators_2_0= ruleBlobValidators ) )?
            {
            // InternalJDL.g:1160:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalJDL.g:1161:4: (lv_name_0_0= RULE_ID )
            {
            // InternalJDL.g:1161:4: (lv_name_0_0= RULE_ID )
            // InternalJDL.g:1162:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_19); 

            					newLeafNode(lv_name_0_0, grammarAccess.getImageBlobFieldAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImageBlobFieldRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,26,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getImageBlobFieldAccess().getImageBlobKeyword_1());
            		
            // InternalJDL.g:1182:3: ( (lv_validators_2_0= ruleBlobValidators ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==27) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalJDL.g:1183:4: (lv_validators_2_0= ruleBlobValidators )
                    {
                    // InternalJDL.g:1183:4: (lv_validators_2_0= ruleBlobValidators )
                    // InternalJDL.g:1184:5: lv_validators_2_0= ruleBlobValidators
                    {

                    					newCompositeNode(grammarAccess.getImageBlobFieldAccess().getValidatorsBlobValidatorsParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_2_0=ruleBlobValidators();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getImageBlobFieldRule());
                    					}
                    					set(
                    						current,
                    						"validators",
                    						lv_validators_2_0,
                    						"io.github.jhipster.jdl.dsl.JDL.BlobValidators");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImageBlobField"


    // $ANTLR start "entryRuleRequiredValidator"
    // InternalJDL.g:1205:1: entryRuleRequiredValidator returns [EObject current=null] : iv_ruleRequiredValidator= ruleRequiredValidator EOF ;
    public final EObject entryRuleRequiredValidator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequiredValidator = null;


        try {
            // InternalJDL.g:1205:58: (iv_ruleRequiredValidator= ruleRequiredValidator EOF )
            // InternalJDL.g:1206:2: iv_ruleRequiredValidator= ruleRequiredValidator EOF
            {
             newCompositeNode(grammarAccess.getRequiredValidatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRequiredValidator=ruleRequiredValidator();

            state._fsp--;

             current =iv_ruleRequiredValidator; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRequiredValidator"


    // $ANTLR start "ruleRequiredValidator"
    // InternalJDL.g:1212:1: ruleRequiredValidator returns [EObject current=null] : ( (lv_required_0_0= 'required' ) ) ;
    public final EObject ruleRequiredValidator() throws RecognitionException {
        EObject current = null;

        Token lv_required_0_0=null;


        	enterRule();

        try {
            // InternalJDL.g:1218:2: ( ( (lv_required_0_0= 'required' ) ) )
            // InternalJDL.g:1219:2: ( (lv_required_0_0= 'required' ) )
            {
            // InternalJDL.g:1219:2: ( (lv_required_0_0= 'required' ) )
            // InternalJDL.g:1220:3: (lv_required_0_0= 'required' )
            {
            // InternalJDL.g:1220:3: (lv_required_0_0= 'required' )
            // InternalJDL.g:1221:4: lv_required_0_0= 'required'
            {
            lv_required_0_0=(Token)match(input,27,FOLLOW_2); 

            				newLeafNode(lv_required_0_0, grammarAccess.getRequiredValidatorAccess().getRequiredRequiredKeyword_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getRequiredValidatorRule());
            				}
            				setWithLastConsumed(current, "required", true, "required");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRequiredValidator"


    // $ANTLR start "entryRuleMinLengthValidator"
    // InternalJDL.g:1236:1: entryRuleMinLengthValidator returns [EObject current=null] : iv_ruleMinLengthValidator= ruleMinLengthValidator EOF ;
    public final EObject entryRuleMinLengthValidator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMinLengthValidator = null;


        try {
            // InternalJDL.g:1236:59: (iv_ruleMinLengthValidator= ruleMinLengthValidator EOF )
            // InternalJDL.g:1237:2: iv_ruleMinLengthValidator= ruleMinLengthValidator EOF
            {
             newCompositeNode(grammarAccess.getMinLengthValidatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMinLengthValidator=ruleMinLengthValidator();

            state._fsp--;

             current =iv_ruleMinLengthValidator; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMinLengthValidator"


    // $ANTLR start "ruleMinLengthValidator"
    // InternalJDL.g:1243:1: ruleMinLengthValidator returns [EObject current=null] : (otherlv_0= 'minlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final EObject ruleMinLengthValidator() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalJDL.g:1249:2: ( (otherlv_0= 'minlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // InternalJDL.g:1250:2: (otherlv_0= 'minlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // InternalJDL.g:1250:2: (otherlv_0= 'minlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            // InternalJDL.g:1251:3: otherlv_0= 'minlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,28,FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getMinLengthValidatorAccess().getMinlengthKeyword_0());
            		
            otherlv_1=(Token)match(input,29,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getMinLengthValidatorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalJDL.g:1259:3: ( (lv_value_2_0= RULE_INT ) )
            // InternalJDL.g:1260:4: (lv_value_2_0= RULE_INT )
            {
            // InternalJDL.g:1260:4: (lv_value_2_0= RULE_INT )
            // InternalJDL.g:1261:5: lv_value_2_0= RULE_INT
            {
            lv_value_2_0=(Token)match(input,RULE_INT,FOLLOW_22); 

            					newLeafNode(lv_value_2_0, grammarAccess.getMinLengthValidatorAccess().getValueINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMinLengthValidatorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_3=(Token)match(input,30,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getMinLengthValidatorAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMinLengthValidator"


    // $ANTLR start "entryRuleMaxLengthValidator"
    // InternalJDL.g:1285:1: entryRuleMaxLengthValidator returns [EObject current=null] : iv_ruleMaxLengthValidator= ruleMaxLengthValidator EOF ;
    public final EObject entryRuleMaxLengthValidator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMaxLengthValidator = null;


        try {
            // InternalJDL.g:1285:59: (iv_ruleMaxLengthValidator= ruleMaxLengthValidator EOF )
            // InternalJDL.g:1286:2: iv_ruleMaxLengthValidator= ruleMaxLengthValidator EOF
            {
             newCompositeNode(grammarAccess.getMaxLengthValidatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMaxLengthValidator=ruleMaxLengthValidator();

            state._fsp--;

             current =iv_ruleMaxLengthValidator; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMaxLengthValidator"


    // $ANTLR start "ruleMaxLengthValidator"
    // InternalJDL.g:1292:1: ruleMaxLengthValidator returns [EObject current=null] : (otherlv_0= 'maxlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final EObject ruleMaxLengthValidator() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalJDL.g:1298:2: ( (otherlv_0= 'maxlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // InternalJDL.g:1299:2: (otherlv_0= 'maxlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // InternalJDL.g:1299:2: (otherlv_0= 'maxlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            // InternalJDL.g:1300:3: otherlv_0= 'maxlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,31,FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getMaxLengthValidatorAccess().getMaxlengthKeyword_0());
            		
            otherlv_1=(Token)match(input,29,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getMaxLengthValidatorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalJDL.g:1308:3: ( (lv_value_2_0= RULE_INT ) )
            // InternalJDL.g:1309:4: (lv_value_2_0= RULE_INT )
            {
            // InternalJDL.g:1309:4: (lv_value_2_0= RULE_INT )
            // InternalJDL.g:1310:5: lv_value_2_0= RULE_INT
            {
            lv_value_2_0=(Token)match(input,RULE_INT,FOLLOW_22); 

            					newLeafNode(lv_value_2_0, grammarAccess.getMaxLengthValidatorAccess().getValueINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMaxLengthValidatorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_3=(Token)match(input,30,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getMaxLengthValidatorAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMaxLengthValidator"


    // $ANTLR start "entryRulePatternValidator"
    // InternalJDL.g:1334:1: entryRulePatternValidator returns [EObject current=null] : iv_rulePatternValidator= rulePatternValidator EOF ;
    public final EObject entryRulePatternValidator() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePatternValidator = null;


        try {
            // InternalJDL.g:1334:57: (iv_rulePatternValidator= rulePatternValidator EOF )
            // InternalJDL.g:1335:2: iv_rulePatternValidator= rulePatternValidator EOF
            {
             newCompositeNode(grammarAccess.getPatternValidatorRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePatternValidator=rulePatternValidator();

            state._fsp--;

             current =iv_rulePatternValidator; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePatternValidator"


    // $ANTLR start "rulePatternValidator"
    // InternalJDL.g:1341:1: rulePatternValidator returns [EObject current=null] : (otherlv_0= 'pattern' otherlv_1= '(' ( (lv_value_2_0= RULE_STRING ) ) otherlv_3= ')' ) ;
    public final EObject rulePatternValidator() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalJDL.g:1347:2: ( (otherlv_0= 'pattern' otherlv_1= '(' ( (lv_value_2_0= RULE_STRING ) ) otherlv_3= ')' ) )
            // InternalJDL.g:1348:2: (otherlv_0= 'pattern' otherlv_1= '(' ( (lv_value_2_0= RULE_STRING ) ) otherlv_3= ')' )
            {
            // InternalJDL.g:1348:2: (otherlv_0= 'pattern' otherlv_1= '(' ( (lv_value_2_0= RULE_STRING ) ) otherlv_3= ')' )
            // InternalJDL.g:1349:3: otherlv_0= 'pattern' otherlv_1= '(' ( (lv_value_2_0= RULE_STRING ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getPatternValidatorAccess().getPatternKeyword_0());
            		
            otherlv_1=(Token)match(input,29,FOLLOW_23); 

            			newLeafNode(otherlv_1, grammarAccess.getPatternValidatorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalJDL.g:1357:3: ( (lv_value_2_0= RULE_STRING ) )
            // InternalJDL.g:1358:4: (lv_value_2_0= RULE_STRING )
            {
            // InternalJDL.g:1358:4: (lv_value_2_0= RULE_STRING )
            // InternalJDL.g:1359:5: lv_value_2_0= RULE_STRING
            {
            lv_value_2_0=(Token)match(input,RULE_STRING,FOLLOW_22); 

            					newLeafNode(lv_value_2_0, grammarAccess.getPatternValidatorAccess().getValueSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPatternValidatorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_3=(Token)match(input,30,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getPatternValidatorAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePatternValidator"


    // $ANTLR start "entryRuleMinValidator"
    // InternalJDL.g:1383:1: entryRuleMinValidator returns [EObject current=null] : iv_ruleMinValidator= ruleMinValidator EOF ;
    public final EObject entryRuleMinValidator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMinValidator = null;


        try {
            // InternalJDL.g:1383:53: (iv_ruleMinValidator= ruleMinValidator EOF )
            // InternalJDL.g:1384:2: iv_ruleMinValidator= ruleMinValidator EOF
            {
             newCompositeNode(grammarAccess.getMinValidatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMinValidator=ruleMinValidator();

            state._fsp--;

             current =iv_ruleMinValidator; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMinValidator"


    // $ANTLR start "ruleMinValidator"
    // InternalJDL.g:1390:1: ruleMinValidator returns [EObject current=null] : (otherlv_0= 'min' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final EObject ruleMinValidator() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalJDL.g:1396:2: ( (otherlv_0= 'min' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // InternalJDL.g:1397:2: (otherlv_0= 'min' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // InternalJDL.g:1397:2: (otherlv_0= 'min' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            // InternalJDL.g:1398:3: otherlv_0= 'min' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getMinValidatorAccess().getMinKeyword_0());
            		
            otherlv_1=(Token)match(input,29,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getMinValidatorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalJDL.g:1406:3: ( (lv_value_2_0= RULE_INT ) )
            // InternalJDL.g:1407:4: (lv_value_2_0= RULE_INT )
            {
            // InternalJDL.g:1407:4: (lv_value_2_0= RULE_INT )
            // InternalJDL.g:1408:5: lv_value_2_0= RULE_INT
            {
            lv_value_2_0=(Token)match(input,RULE_INT,FOLLOW_22); 

            					newLeafNode(lv_value_2_0, grammarAccess.getMinValidatorAccess().getValueINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMinValidatorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_3=(Token)match(input,30,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getMinValidatorAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMinValidator"


    // $ANTLR start "entryRuleMaxValidator"
    // InternalJDL.g:1432:1: entryRuleMaxValidator returns [EObject current=null] : iv_ruleMaxValidator= ruleMaxValidator EOF ;
    public final EObject entryRuleMaxValidator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMaxValidator = null;


        try {
            // InternalJDL.g:1432:53: (iv_ruleMaxValidator= ruleMaxValidator EOF )
            // InternalJDL.g:1433:2: iv_ruleMaxValidator= ruleMaxValidator EOF
            {
             newCompositeNode(grammarAccess.getMaxValidatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMaxValidator=ruleMaxValidator();

            state._fsp--;

             current =iv_ruleMaxValidator; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMaxValidator"


    // $ANTLR start "ruleMaxValidator"
    // InternalJDL.g:1439:1: ruleMaxValidator returns [EObject current=null] : (otherlv_0= 'max' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final EObject ruleMaxValidator() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalJDL.g:1445:2: ( (otherlv_0= 'max' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // InternalJDL.g:1446:2: (otherlv_0= 'max' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // InternalJDL.g:1446:2: (otherlv_0= 'max' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            // InternalJDL.g:1447:3: otherlv_0= 'max' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,34,FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getMaxValidatorAccess().getMaxKeyword_0());
            		
            otherlv_1=(Token)match(input,29,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getMaxValidatorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalJDL.g:1455:3: ( (lv_value_2_0= RULE_INT ) )
            // InternalJDL.g:1456:4: (lv_value_2_0= RULE_INT )
            {
            // InternalJDL.g:1456:4: (lv_value_2_0= RULE_INT )
            // InternalJDL.g:1457:5: lv_value_2_0= RULE_INT
            {
            lv_value_2_0=(Token)match(input,RULE_INT,FOLLOW_22); 

            					newLeafNode(lv_value_2_0, grammarAccess.getMaxValidatorAccess().getValueINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMaxValidatorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_3=(Token)match(input,30,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getMaxValidatorAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMaxValidator"


    // $ANTLR start "entryRuleMinBytesValidator"
    // InternalJDL.g:1481:1: entryRuleMinBytesValidator returns [EObject current=null] : iv_ruleMinBytesValidator= ruleMinBytesValidator EOF ;
    public final EObject entryRuleMinBytesValidator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMinBytesValidator = null;


        try {
            // InternalJDL.g:1481:58: (iv_ruleMinBytesValidator= ruleMinBytesValidator EOF )
            // InternalJDL.g:1482:2: iv_ruleMinBytesValidator= ruleMinBytesValidator EOF
            {
             newCompositeNode(grammarAccess.getMinBytesValidatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMinBytesValidator=ruleMinBytesValidator();

            state._fsp--;

             current =iv_ruleMinBytesValidator; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMinBytesValidator"


    // $ANTLR start "ruleMinBytesValidator"
    // InternalJDL.g:1488:1: ruleMinBytesValidator returns [EObject current=null] : (otherlv_0= 'minbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final EObject ruleMinBytesValidator() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalJDL.g:1494:2: ( (otherlv_0= 'minbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // InternalJDL.g:1495:2: (otherlv_0= 'minbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // InternalJDL.g:1495:2: (otherlv_0= 'minbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            // InternalJDL.g:1496:3: otherlv_0= 'minbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,35,FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getMinBytesValidatorAccess().getMinbytesKeyword_0());
            		
            otherlv_1=(Token)match(input,29,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getMinBytesValidatorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalJDL.g:1504:3: ( (lv_value_2_0= RULE_INT ) )
            // InternalJDL.g:1505:4: (lv_value_2_0= RULE_INT )
            {
            // InternalJDL.g:1505:4: (lv_value_2_0= RULE_INT )
            // InternalJDL.g:1506:5: lv_value_2_0= RULE_INT
            {
            lv_value_2_0=(Token)match(input,RULE_INT,FOLLOW_22); 

            					newLeafNode(lv_value_2_0, grammarAccess.getMinBytesValidatorAccess().getValueINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMinBytesValidatorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_3=(Token)match(input,30,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getMinBytesValidatorAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMinBytesValidator"


    // $ANTLR start "entryRuleMaxBytesValidator"
    // InternalJDL.g:1530:1: entryRuleMaxBytesValidator returns [EObject current=null] : iv_ruleMaxBytesValidator= ruleMaxBytesValidator EOF ;
    public final EObject entryRuleMaxBytesValidator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMaxBytesValidator = null;


        try {
            // InternalJDL.g:1530:58: (iv_ruleMaxBytesValidator= ruleMaxBytesValidator EOF )
            // InternalJDL.g:1531:2: iv_ruleMaxBytesValidator= ruleMaxBytesValidator EOF
            {
             newCompositeNode(grammarAccess.getMaxBytesValidatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMaxBytesValidator=ruleMaxBytesValidator();

            state._fsp--;

             current =iv_ruleMaxBytesValidator; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMaxBytesValidator"


    // $ANTLR start "ruleMaxBytesValidator"
    // InternalJDL.g:1537:1: ruleMaxBytesValidator returns [EObject current=null] : (otherlv_0= 'maxbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final EObject ruleMaxBytesValidator() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalJDL.g:1543:2: ( (otherlv_0= 'maxbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // InternalJDL.g:1544:2: (otherlv_0= 'maxbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // InternalJDL.g:1544:2: (otherlv_0= 'maxbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            // InternalJDL.g:1545:3: otherlv_0= 'maxbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,36,FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getMaxBytesValidatorAccess().getMaxbytesKeyword_0());
            		
            otherlv_1=(Token)match(input,29,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getMaxBytesValidatorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalJDL.g:1553:3: ( (lv_value_2_0= RULE_INT ) )
            // InternalJDL.g:1554:4: (lv_value_2_0= RULE_INT )
            {
            // InternalJDL.g:1554:4: (lv_value_2_0= RULE_INT )
            // InternalJDL.g:1555:5: lv_value_2_0= RULE_INT
            {
            lv_value_2_0=(Token)match(input,RULE_INT,FOLLOW_22); 

            					newLeafNode(lv_value_2_0, grammarAccess.getMaxBytesValidatorAccess().getValueINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMaxBytesValidatorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_3=(Token)match(input,30,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getMaxBytesValidatorAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMaxBytesValidator"


    // $ANTLR start "entryRuleStringValidators"
    // InternalJDL.g:1579:1: entryRuleStringValidators returns [EObject current=null] : iv_ruleStringValidators= ruleStringValidators EOF ;
    public final EObject entryRuleStringValidators() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringValidators = null;


        try {
            // InternalJDL.g:1579:57: (iv_ruleStringValidators= ruleStringValidators EOF )
            // InternalJDL.g:1580:2: iv_ruleStringValidators= ruleStringValidators EOF
            {
             newCompositeNode(grammarAccess.getStringValidatorsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStringValidators=ruleStringValidators();

            state._fsp--;

             current =iv_ruleStringValidators; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringValidators"


    // $ANTLR start "ruleStringValidators"
    // InternalJDL.g:1586:1: ruleStringValidators returns [EObject current=null] : ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minLength_1_0= ruleMinLengthValidator ) )? ( (lv_maxlength_2_0= ruleMaxLengthValidator ) )? ( (lv_pattern_3_0= rulePatternValidator ) )? ) ;
    public final EObject ruleStringValidators() throws RecognitionException {
        EObject current = null;

        EObject lv_required_0_0 = null;

        EObject lv_minLength_1_0 = null;

        EObject lv_maxlength_2_0 = null;

        EObject lv_pattern_3_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:1592:2: ( ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minLength_1_0= ruleMinLengthValidator ) )? ( (lv_maxlength_2_0= ruleMaxLengthValidator ) )? ( (lv_pattern_3_0= rulePatternValidator ) )? ) )
            // InternalJDL.g:1593:2: ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minLength_1_0= ruleMinLengthValidator ) )? ( (lv_maxlength_2_0= ruleMaxLengthValidator ) )? ( (lv_pattern_3_0= rulePatternValidator ) )? )
            {
            // InternalJDL.g:1593:2: ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minLength_1_0= ruleMinLengthValidator ) )? ( (lv_maxlength_2_0= ruleMaxLengthValidator ) )? ( (lv_pattern_3_0= rulePatternValidator ) )? )
            // InternalJDL.g:1594:3: ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minLength_1_0= ruleMinLengthValidator ) )? ( (lv_maxlength_2_0= ruleMaxLengthValidator ) )? ( (lv_pattern_3_0= rulePatternValidator ) )?
            {
            // InternalJDL.g:1594:3: ( (lv_required_0_0= ruleRequiredValidator ) )
            // InternalJDL.g:1595:4: (lv_required_0_0= ruleRequiredValidator )
            {
            // InternalJDL.g:1595:4: (lv_required_0_0= ruleRequiredValidator )
            // InternalJDL.g:1596:5: lv_required_0_0= ruleRequiredValidator
            {

            					newCompositeNode(grammarAccess.getStringValidatorsAccess().getRequiredRequiredValidatorParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_24);
            lv_required_0_0=ruleRequiredValidator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStringValidatorsRule());
            					}
            					set(
            						current,
            						"required",
            						lv_required_0_0,
            						"io.github.jhipster.jdl.dsl.JDL.RequiredValidator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalJDL.g:1613:3: ( (lv_minLength_1_0= ruleMinLengthValidator ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==28) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalJDL.g:1614:4: (lv_minLength_1_0= ruleMinLengthValidator )
                    {
                    // InternalJDL.g:1614:4: (lv_minLength_1_0= ruleMinLengthValidator )
                    // InternalJDL.g:1615:5: lv_minLength_1_0= ruleMinLengthValidator
                    {

                    					newCompositeNode(grammarAccess.getStringValidatorsAccess().getMinLengthMinLengthValidatorParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_25);
                    lv_minLength_1_0=ruleMinLengthValidator();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getStringValidatorsRule());
                    					}
                    					set(
                    						current,
                    						"minLength",
                    						lv_minLength_1_0,
                    						"io.github.jhipster.jdl.dsl.JDL.MinLengthValidator");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalJDL.g:1632:3: ( (lv_maxlength_2_0= ruleMaxLengthValidator ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==31) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalJDL.g:1633:4: (lv_maxlength_2_0= ruleMaxLengthValidator )
                    {
                    // InternalJDL.g:1633:4: (lv_maxlength_2_0= ruleMaxLengthValidator )
                    // InternalJDL.g:1634:5: lv_maxlength_2_0= ruleMaxLengthValidator
                    {

                    					newCompositeNode(grammarAccess.getStringValidatorsAccess().getMaxlengthMaxLengthValidatorParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_26);
                    lv_maxlength_2_0=ruleMaxLengthValidator();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getStringValidatorsRule());
                    					}
                    					set(
                    						current,
                    						"maxlength",
                    						lv_maxlength_2_0,
                    						"io.github.jhipster.jdl.dsl.JDL.MaxLengthValidator");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalJDL.g:1651:3: ( (lv_pattern_3_0= rulePatternValidator ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==32) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalJDL.g:1652:4: (lv_pattern_3_0= rulePatternValidator )
                    {
                    // InternalJDL.g:1652:4: (lv_pattern_3_0= rulePatternValidator )
                    // InternalJDL.g:1653:5: lv_pattern_3_0= rulePatternValidator
                    {

                    					newCompositeNode(grammarAccess.getStringValidatorsAccess().getPatternPatternValidatorParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_pattern_3_0=rulePatternValidator();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getStringValidatorsRule());
                    					}
                    					set(
                    						current,
                    						"pattern",
                    						lv_pattern_3_0,
                    						"io.github.jhipster.jdl.dsl.JDL.PatternValidator");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringValidators"


    // $ANTLR start "entryRuleNumericValidators"
    // InternalJDL.g:1674:1: entryRuleNumericValidators returns [EObject current=null] : iv_ruleNumericValidators= ruleNumericValidators EOF ;
    public final EObject entryRuleNumericValidators() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericValidators = null;


        try {
            // InternalJDL.g:1674:58: (iv_ruleNumericValidators= ruleNumericValidators EOF )
            // InternalJDL.g:1675:2: iv_ruleNumericValidators= ruleNumericValidators EOF
            {
             newCompositeNode(grammarAccess.getNumericValidatorsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumericValidators=ruleNumericValidators();

            state._fsp--;

             current =iv_ruleNumericValidators; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumericValidators"


    // $ANTLR start "ruleNumericValidators"
    // InternalJDL.g:1681:1: ruleNumericValidators returns [EObject current=null] : ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minlength_1_0= ruleMinValidator ) )? ( (lv_maxlength_2_0= ruleMaxValidator ) )? ) ;
    public final EObject ruleNumericValidators() throws RecognitionException {
        EObject current = null;

        EObject lv_required_0_0 = null;

        EObject lv_minlength_1_0 = null;

        EObject lv_maxlength_2_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:1687:2: ( ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minlength_1_0= ruleMinValidator ) )? ( (lv_maxlength_2_0= ruleMaxValidator ) )? ) )
            // InternalJDL.g:1688:2: ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minlength_1_0= ruleMinValidator ) )? ( (lv_maxlength_2_0= ruleMaxValidator ) )? )
            {
            // InternalJDL.g:1688:2: ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minlength_1_0= ruleMinValidator ) )? ( (lv_maxlength_2_0= ruleMaxValidator ) )? )
            // InternalJDL.g:1689:3: ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minlength_1_0= ruleMinValidator ) )? ( (lv_maxlength_2_0= ruleMaxValidator ) )?
            {
            // InternalJDL.g:1689:3: ( (lv_required_0_0= ruleRequiredValidator ) )
            // InternalJDL.g:1690:4: (lv_required_0_0= ruleRequiredValidator )
            {
            // InternalJDL.g:1690:4: (lv_required_0_0= ruleRequiredValidator )
            // InternalJDL.g:1691:5: lv_required_0_0= ruleRequiredValidator
            {

            					newCompositeNode(grammarAccess.getNumericValidatorsAccess().getRequiredRequiredValidatorParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_27);
            lv_required_0_0=ruleRequiredValidator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNumericValidatorsRule());
            					}
            					set(
            						current,
            						"required",
            						lv_required_0_0,
            						"io.github.jhipster.jdl.dsl.JDL.RequiredValidator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalJDL.g:1708:3: ( (lv_minlength_1_0= ruleMinValidator ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==33) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalJDL.g:1709:4: (lv_minlength_1_0= ruleMinValidator )
                    {
                    // InternalJDL.g:1709:4: (lv_minlength_1_0= ruleMinValidator )
                    // InternalJDL.g:1710:5: lv_minlength_1_0= ruleMinValidator
                    {

                    					newCompositeNode(grammarAccess.getNumericValidatorsAccess().getMinlengthMinValidatorParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_28);
                    lv_minlength_1_0=ruleMinValidator();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getNumericValidatorsRule());
                    					}
                    					set(
                    						current,
                    						"minlength",
                    						lv_minlength_1_0,
                    						"io.github.jhipster.jdl.dsl.JDL.MinValidator");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalJDL.g:1727:3: ( (lv_maxlength_2_0= ruleMaxValidator ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==34) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalJDL.g:1728:4: (lv_maxlength_2_0= ruleMaxValidator )
                    {
                    // InternalJDL.g:1728:4: (lv_maxlength_2_0= ruleMaxValidator )
                    // InternalJDL.g:1729:5: lv_maxlength_2_0= ruleMaxValidator
                    {

                    					newCompositeNode(grammarAccess.getNumericValidatorsAccess().getMaxlengthMaxValidatorParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_maxlength_2_0=ruleMaxValidator();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getNumericValidatorsRule());
                    					}
                    					set(
                    						current,
                    						"maxlength",
                    						lv_maxlength_2_0,
                    						"io.github.jhipster.jdl.dsl.JDL.MaxValidator");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumericValidators"


    // $ANTLR start "entryRuleBlobValidators"
    // InternalJDL.g:1750:1: entryRuleBlobValidators returns [EObject current=null] : iv_ruleBlobValidators= ruleBlobValidators EOF ;
    public final EObject entryRuleBlobValidators() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlobValidators = null;


        try {
            // InternalJDL.g:1750:55: (iv_ruleBlobValidators= ruleBlobValidators EOF )
            // InternalJDL.g:1751:2: iv_ruleBlobValidators= ruleBlobValidators EOF
            {
             newCompositeNode(grammarAccess.getBlobValidatorsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBlobValidators=ruleBlobValidators();

            state._fsp--;

             current =iv_ruleBlobValidators; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBlobValidators"


    // $ANTLR start "ruleBlobValidators"
    // InternalJDL.g:1757:1: ruleBlobValidators returns [EObject current=null] : ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minbytes_1_0= ruleMinBytesValidator ) )? ( (lv_maxbytes_2_0= ruleMaxBytesValidator ) )? ) ;
    public final EObject ruleBlobValidators() throws RecognitionException {
        EObject current = null;

        EObject lv_required_0_0 = null;

        EObject lv_minbytes_1_0 = null;

        EObject lv_maxbytes_2_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:1763:2: ( ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minbytes_1_0= ruleMinBytesValidator ) )? ( (lv_maxbytes_2_0= ruleMaxBytesValidator ) )? ) )
            // InternalJDL.g:1764:2: ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minbytes_1_0= ruleMinBytesValidator ) )? ( (lv_maxbytes_2_0= ruleMaxBytesValidator ) )? )
            {
            // InternalJDL.g:1764:2: ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minbytes_1_0= ruleMinBytesValidator ) )? ( (lv_maxbytes_2_0= ruleMaxBytesValidator ) )? )
            // InternalJDL.g:1765:3: ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minbytes_1_0= ruleMinBytesValidator ) )? ( (lv_maxbytes_2_0= ruleMaxBytesValidator ) )?
            {
            // InternalJDL.g:1765:3: ( (lv_required_0_0= ruleRequiredValidator ) )
            // InternalJDL.g:1766:4: (lv_required_0_0= ruleRequiredValidator )
            {
            // InternalJDL.g:1766:4: (lv_required_0_0= ruleRequiredValidator )
            // InternalJDL.g:1767:5: lv_required_0_0= ruleRequiredValidator
            {

            					newCompositeNode(grammarAccess.getBlobValidatorsAccess().getRequiredRequiredValidatorParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_29);
            lv_required_0_0=ruleRequiredValidator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBlobValidatorsRule());
            					}
            					set(
            						current,
            						"required",
            						lv_required_0_0,
            						"io.github.jhipster.jdl.dsl.JDL.RequiredValidator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalJDL.g:1784:3: ( (lv_minbytes_1_0= ruleMinBytesValidator ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==35) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalJDL.g:1785:4: (lv_minbytes_1_0= ruleMinBytesValidator )
                    {
                    // InternalJDL.g:1785:4: (lv_minbytes_1_0= ruleMinBytesValidator )
                    // InternalJDL.g:1786:5: lv_minbytes_1_0= ruleMinBytesValidator
                    {

                    					newCompositeNode(grammarAccess.getBlobValidatorsAccess().getMinbytesMinBytesValidatorParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_30);
                    lv_minbytes_1_0=ruleMinBytesValidator();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getBlobValidatorsRule());
                    					}
                    					set(
                    						current,
                    						"minbytes",
                    						lv_minbytes_1_0,
                    						"io.github.jhipster.jdl.dsl.JDL.MinBytesValidator");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalJDL.g:1803:3: ( (lv_maxbytes_2_0= ruleMaxBytesValidator ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==36) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalJDL.g:1804:4: (lv_maxbytes_2_0= ruleMaxBytesValidator )
                    {
                    // InternalJDL.g:1804:4: (lv_maxbytes_2_0= ruleMaxBytesValidator )
                    // InternalJDL.g:1805:5: lv_maxbytes_2_0= ruleMaxBytesValidator
                    {

                    					newCompositeNode(grammarAccess.getBlobValidatorsAccess().getMaxbytesMaxBytesValidatorParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_maxbytes_2_0=ruleMaxBytesValidator();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getBlobValidatorsRule());
                    					}
                    					set(
                    						current,
                    						"maxbytes",
                    						lv_maxbytes_2_0,
                    						"io.github.jhipster.jdl.dsl.JDL.MaxBytesValidator");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBlobValidators"


    // $ANTLR start "entryRuleRelationships"
    // InternalJDL.g:1826:1: entryRuleRelationships returns [EObject current=null] : iv_ruleRelationships= ruleRelationships EOF ;
    public final EObject entryRuleRelationships() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationships = null;


        try {
            // InternalJDL.g:1826:54: (iv_ruleRelationships= ruleRelationships EOF )
            // InternalJDL.g:1827:2: iv_ruleRelationships= ruleRelationships EOF
            {
             newCompositeNode(grammarAccess.getRelationshipsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRelationships=ruleRelationships();

            state._fsp--;

             current =iv_ruleRelationships; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationships"


    // $ANTLR start "ruleRelationships"
    // InternalJDL.g:1833:1: ruleRelationships returns [EObject current=null] : (otherlv_0= 'relationship' ( (lv_cardinality_1_0= ruleCardinality ) ) otherlv_2= '{' ( (lv_relationships_3_0= ruleRelationship ) )* otherlv_4= '}' ) ;
    public final EObject ruleRelationships() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Enumerator lv_cardinality_1_0 = null;

        EObject lv_relationships_3_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:1839:2: ( (otherlv_0= 'relationship' ( (lv_cardinality_1_0= ruleCardinality ) ) otherlv_2= '{' ( (lv_relationships_3_0= ruleRelationship ) )* otherlv_4= '}' ) )
            // InternalJDL.g:1840:2: (otherlv_0= 'relationship' ( (lv_cardinality_1_0= ruleCardinality ) ) otherlv_2= '{' ( (lv_relationships_3_0= ruleRelationship ) )* otherlv_4= '}' )
            {
            // InternalJDL.g:1840:2: (otherlv_0= 'relationship' ( (lv_cardinality_1_0= ruleCardinality ) ) otherlv_2= '{' ( (lv_relationships_3_0= ruleRelationship ) )* otherlv_4= '}' )
            // InternalJDL.g:1841:3: otherlv_0= 'relationship' ( (lv_cardinality_1_0= ruleCardinality ) ) otherlv_2= '{' ( (lv_relationships_3_0= ruleRelationship ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,37,FOLLOW_31); 

            			newLeafNode(otherlv_0, grammarAccess.getRelationshipsAccess().getRelationshipKeyword_0());
            		
            // InternalJDL.g:1845:3: ( (lv_cardinality_1_0= ruleCardinality ) )
            // InternalJDL.g:1846:4: (lv_cardinality_1_0= ruleCardinality )
            {
            // InternalJDL.g:1846:4: (lv_cardinality_1_0= ruleCardinality )
            // InternalJDL.g:1847:5: lv_cardinality_1_0= ruleCardinality
            {

            					newCompositeNode(grammarAccess.getRelationshipsAccess().getCardinalityCardinalityEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_5);
            lv_cardinality_1_0=ruleCardinality();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRelationshipsRule());
            					}
            					set(
            						current,
            						"cardinality",
            						lv_cardinality_1_0,
            						"io.github.jhipster.jdl.dsl.JDL.Cardinality");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_32); 

            			newLeafNode(otherlv_2, grammarAccess.getRelationshipsAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalJDL.g:1868:3: ( (lv_relationships_3_0= ruleRelationship ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==11) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalJDL.g:1869:4: (lv_relationships_3_0= ruleRelationship )
            	    {
            	    // InternalJDL.g:1869:4: (lv_relationships_3_0= ruleRelationship )
            	    // InternalJDL.g:1870:5: lv_relationships_3_0= ruleRelationship
            	    {

            	    					newCompositeNode(grammarAccess.getRelationshipsAccess().getRelationshipsRelationshipParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_32);
            	    lv_relationships_3_0=ruleRelationship();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRelationshipsRule());
            	    					}
            	    					add(
            	    						current,
            	    						"relationships",
            	    						lv_relationships_3_0,
            	    						"io.github.jhipster.jdl.dsl.JDL.Relationship");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            otherlv_4=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getRelationshipsAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationships"


    // $ANTLR start "entryRuleRelationship"
    // InternalJDL.g:1895:1: entryRuleRelationship returns [EObject current=null] : iv_ruleRelationship= ruleRelationship EOF ;
    public final EObject entryRuleRelationship() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationship = null;


        try {
            // InternalJDL.g:1895:53: (iv_ruleRelationship= ruleRelationship EOF )
            // InternalJDL.g:1896:2: iv_ruleRelationship= ruleRelationship EOF
            {
             newCompositeNode(grammarAccess.getRelationshipRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRelationship=ruleRelationship();

            state._fsp--;

             current =iv_ruleRelationship; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationship"


    // $ANTLR start "ruleRelationship"
    // InternalJDL.g:1902:1: ruleRelationship returns [EObject current=null] : ( ( (lv_fromEntity_0_0= ruleEntity ) ) ( (lv_fromName_1_0= ruleRelationshipName ) )? otherlv_2= 'to' ( (lv_toEntity_3_0= ruleEntity ) ) ( (lv_toName_4_0= ruleRelationshipName ) )? ) ;
    public final EObject ruleRelationship() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_fromEntity_0_0 = null;

        EObject lv_fromName_1_0 = null;

        EObject lv_toEntity_3_0 = null;

        EObject lv_toName_4_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:1908:2: ( ( ( (lv_fromEntity_0_0= ruleEntity ) ) ( (lv_fromName_1_0= ruleRelationshipName ) )? otherlv_2= 'to' ( (lv_toEntity_3_0= ruleEntity ) ) ( (lv_toName_4_0= ruleRelationshipName ) )? ) )
            // InternalJDL.g:1909:2: ( ( (lv_fromEntity_0_0= ruleEntity ) ) ( (lv_fromName_1_0= ruleRelationshipName ) )? otherlv_2= 'to' ( (lv_toEntity_3_0= ruleEntity ) ) ( (lv_toName_4_0= ruleRelationshipName ) )? )
            {
            // InternalJDL.g:1909:2: ( ( (lv_fromEntity_0_0= ruleEntity ) ) ( (lv_fromName_1_0= ruleRelationshipName ) )? otherlv_2= 'to' ( (lv_toEntity_3_0= ruleEntity ) ) ( (lv_toName_4_0= ruleRelationshipName ) )? )
            // InternalJDL.g:1910:3: ( (lv_fromEntity_0_0= ruleEntity ) ) ( (lv_fromName_1_0= ruleRelationshipName ) )? otherlv_2= 'to' ( (lv_toEntity_3_0= ruleEntity ) ) ( (lv_toName_4_0= ruleRelationshipName ) )?
            {
            // InternalJDL.g:1910:3: ( (lv_fromEntity_0_0= ruleEntity ) )
            // InternalJDL.g:1911:4: (lv_fromEntity_0_0= ruleEntity )
            {
            // InternalJDL.g:1911:4: (lv_fromEntity_0_0= ruleEntity )
            // InternalJDL.g:1912:5: lv_fromEntity_0_0= ruleEntity
            {

            					newCompositeNode(grammarAccess.getRelationshipAccess().getFromEntityEntityParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_33);
            lv_fromEntity_0_0=ruleEntity();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRelationshipRule());
            					}
            					set(
            						current,
            						"fromEntity",
            						lv_fromEntity_0_0,
            						"io.github.jhipster.jdl.dsl.JDL.Entity");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalJDL.g:1929:3: ( (lv_fromName_1_0= ruleRelationshipName ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==12) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalJDL.g:1930:4: (lv_fromName_1_0= ruleRelationshipName )
                    {
                    // InternalJDL.g:1930:4: (lv_fromName_1_0= ruleRelationshipName )
                    // InternalJDL.g:1931:5: lv_fromName_1_0= ruleRelationshipName
                    {

                    					newCompositeNode(grammarAccess.getRelationshipAccess().getFromNameRelationshipNameParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_34);
                    lv_fromName_1_0=ruleRelationshipName();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getRelationshipRule());
                    					}
                    					set(
                    						current,
                    						"fromName",
                    						lv_fromName_1_0,
                    						"io.github.jhipster.jdl.dsl.JDL.RelationshipName");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,38,FOLLOW_35); 

            			newLeafNode(otherlv_2, grammarAccess.getRelationshipAccess().getToKeyword_2());
            		
            // InternalJDL.g:1952:3: ( (lv_toEntity_3_0= ruleEntity ) )
            // InternalJDL.g:1953:4: (lv_toEntity_3_0= ruleEntity )
            {
            // InternalJDL.g:1953:4: (lv_toEntity_3_0= ruleEntity )
            // InternalJDL.g:1954:5: lv_toEntity_3_0= ruleEntity
            {

            					newCompositeNode(grammarAccess.getRelationshipAccess().getToEntityEntityParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_36);
            lv_toEntity_3_0=ruleEntity();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRelationshipRule());
            					}
            					set(
            						current,
            						"toEntity",
            						lv_toEntity_3_0,
            						"io.github.jhipster.jdl.dsl.JDL.Entity");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalJDL.g:1971:3: ( (lv_toName_4_0= ruleRelationshipName ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==12) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalJDL.g:1972:4: (lv_toName_4_0= ruleRelationshipName )
                    {
                    // InternalJDL.g:1972:4: (lv_toName_4_0= ruleRelationshipName )
                    // InternalJDL.g:1973:5: lv_toName_4_0= ruleRelationshipName
                    {

                    					newCompositeNode(grammarAccess.getRelationshipAccess().getToNameRelationshipNameParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_toName_4_0=ruleRelationshipName();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getRelationshipRule());
                    					}
                    					set(
                    						current,
                    						"toName",
                    						lv_toName_4_0,
                    						"io.github.jhipster.jdl.dsl.JDL.RelationshipName");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationship"


    // $ANTLR start "entryRuleRelationshipName"
    // InternalJDL.g:1994:1: entryRuleRelationshipName returns [EObject current=null] : iv_ruleRelationshipName= ruleRelationshipName EOF ;
    public final EObject entryRuleRelationshipName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationshipName = null;


        try {
            // InternalJDL.g:1994:57: (iv_ruleRelationshipName= ruleRelationshipName EOF )
            // InternalJDL.g:1995:2: iv_ruleRelationshipName= ruleRelationshipName EOF
            {
             newCompositeNode(grammarAccess.getRelationshipNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRelationshipName=ruleRelationshipName();

            state._fsp--;

             current =iv_ruleRelationshipName; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationshipName"


    // $ANTLR start "ruleRelationshipName"
    // InternalJDL.g:2001:1: ruleRelationshipName returns [EObject current=null] : (otherlv_0= '{' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '}' ) ;
    public final EObject ruleRelationshipName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalJDL.g:2007:2: ( (otherlv_0= '{' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '}' ) )
            // InternalJDL.g:2008:2: (otherlv_0= '{' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '}' )
            {
            // InternalJDL.g:2008:2: (otherlv_0= '{' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '}' )
            // InternalJDL.g:2009:3: otherlv_0= '{' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '}'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getRelationshipNameAccess().getLeftCurlyBracketKeyword_0());
            		
            // InternalJDL.g:2013:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalJDL.g:2014:4: (lv_name_1_0= RULE_ID )
            {
            // InternalJDL.g:2014:4: (lv_name_1_0= RULE_ID )
            // InternalJDL.g:2015:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_37); 

            					newLeafNode(lv_name_1_0, grammarAccess.getRelationshipNameAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRelationshipNameRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getRelationshipNameAccess().getRightCurlyBracketKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationshipName"


    // $ANTLR start "entryRuleGenerationSetting"
    // InternalJDL.g:2039:1: entryRuleGenerationSetting returns [EObject current=null] : iv_ruleGenerationSetting= ruleGenerationSetting EOF ;
    public final EObject entryRuleGenerationSetting() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGenerationSetting = null;


        try {
            // InternalJDL.g:2039:58: (iv_ruleGenerationSetting= ruleGenerationSetting EOF )
            // InternalJDL.g:2040:2: iv_ruleGenerationSetting= ruleGenerationSetting EOF
            {
             newCompositeNode(grammarAccess.getGenerationSettingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGenerationSetting=ruleGenerationSetting();

            state._fsp--;

             current =iv_ruleGenerationSetting; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGenerationSetting"


    // $ANTLR start "ruleGenerationSetting"
    // InternalJDL.g:2046:1: ruleGenerationSetting returns [EObject current=null] : (this_ServiceGenerationSetting_0= ruleServiceGenerationSetting | this_DTOGenerationSetting_1= ruleDTOGenerationSetting | this_PaginateGenerationSetting_2= rulePaginateGenerationSetting | this_AngularSuffixGenerationSetting_3= ruleAngularSuffixGenerationSetting ) ;
    public final EObject ruleGenerationSetting() throws RecognitionException {
        EObject current = null;

        EObject this_ServiceGenerationSetting_0 = null;

        EObject this_DTOGenerationSetting_1 = null;

        EObject this_PaginateGenerationSetting_2 = null;

        EObject this_AngularSuffixGenerationSetting_3 = null;



        	enterRule();

        try {
            // InternalJDL.g:2052:2: ( (this_ServiceGenerationSetting_0= ruleServiceGenerationSetting | this_DTOGenerationSetting_1= ruleDTOGenerationSetting | this_PaginateGenerationSetting_2= rulePaginateGenerationSetting | this_AngularSuffixGenerationSetting_3= ruleAngularSuffixGenerationSetting ) )
            // InternalJDL.g:2053:2: (this_ServiceGenerationSetting_0= ruleServiceGenerationSetting | this_DTOGenerationSetting_1= ruleDTOGenerationSetting | this_PaginateGenerationSetting_2= rulePaginateGenerationSetting | this_AngularSuffixGenerationSetting_3= ruleAngularSuffixGenerationSetting )
            {
            // InternalJDL.g:2053:2: (this_ServiceGenerationSetting_0= ruleServiceGenerationSetting | this_DTOGenerationSetting_1= ruleDTOGenerationSetting | this_PaginateGenerationSetting_2= rulePaginateGenerationSetting | this_AngularSuffixGenerationSetting_3= ruleAngularSuffixGenerationSetting )
            int alt30=4;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt30=1;
                }
                break;
            case 41:
                {
                alt30=2;
                }
                break;
            case 42:
                {
                alt30=3;
                }
                break;
            case 43:
                {
                alt30=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // InternalJDL.g:2054:3: this_ServiceGenerationSetting_0= ruleServiceGenerationSetting
                    {

                    			newCompositeNode(grammarAccess.getGenerationSettingAccess().getServiceGenerationSettingParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ServiceGenerationSetting_0=ruleServiceGenerationSetting();

                    state._fsp--;


                    			current = this_ServiceGenerationSetting_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalJDL.g:2063:3: this_DTOGenerationSetting_1= ruleDTOGenerationSetting
                    {

                    			newCompositeNode(grammarAccess.getGenerationSettingAccess().getDTOGenerationSettingParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_DTOGenerationSetting_1=ruleDTOGenerationSetting();

                    state._fsp--;


                    			current = this_DTOGenerationSetting_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalJDL.g:2072:3: this_PaginateGenerationSetting_2= rulePaginateGenerationSetting
                    {

                    			newCompositeNode(grammarAccess.getGenerationSettingAccess().getPaginateGenerationSettingParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_PaginateGenerationSetting_2=rulePaginateGenerationSetting();

                    state._fsp--;


                    			current = this_PaginateGenerationSetting_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalJDL.g:2081:3: this_AngularSuffixGenerationSetting_3= ruleAngularSuffixGenerationSetting
                    {

                    			newCompositeNode(grammarAccess.getGenerationSettingAccess().getAngularSuffixGenerationSettingParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_AngularSuffixGenerationSetting_3=ruleAngularSuffixGenerationSetting();

                    state._fsp--;


                    			current = this_AngularSuffixGenerationSetting_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGenerationSetting"


    // $ANTLR start "entryRuleServiceGenerationSetting"
    // InternalJDL.g:2093:1: entryRuleServiceGenerationSetting returns [EObject current=null] : iv_ruleServiceGenerationSetting= ruleServiceGenerationSetting EOF ;
    public final EObject entryRuleServiceGenerationSetting() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceGenerationSetting = null;


        try {
            // InternalJDL.g:2093:65: (iv_ruleServiceGenerationSetting= ruleServiceGenerationSetting EOF )
            // InternalJDL.g:2094:2: iv_ruleServiceGenerationSetting= ruleServiceGenerationSetting EOF
            {
             newCompositeNode(grammarAccess.getServiceGenerationSettingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleServiceGenerationSetting=ruleServiceGenerationSetting();

            state._fsp--;

             current =iv_ruleServiceGenerationSetting; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleServiceGenerationSetting"


    // $ANTLR start "ruleServiceGenerationSetting"
    // InternalJDL.g:2100:1: ruleServiceGenerationSetting returns [EObject current=null] : (otherlv_0= 'service' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_serviceType_5_0= ruleServiceType ) ) ) ;
    public final EObject ruleServiceGenerationSetting() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_entities_1_0=null;
        Token otherlv_2=null;
        Token lv_entities_3_0=null;
        Token otherlv_4=null;
        Enumerator lv_serviceType_5_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:2106:2: ( (otherlv_0= 'service' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_serviceType_5_0= ruleServiceType ) ) ) )
            // InternalJDL.g:2107:2: (otherlv_0= 'service' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_serviceType_5_0= ruleServiceType ) ) )
            {
            // InternalJDL.g:2107:2: (otherlv_0= 'service' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_serviceType_5_0= ruleServiceType ) ) )
            // InternalJDL.g:2108:3: otherlv_0= 'service' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_serviceType_5_0= ruleServiceType ) )
            {
            otherlv_0=(Token)match(input,39,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getServiceGenerationSettingAccess().getServiceKeyword_0());
            		
            // InternalJDL.g:2112:3: ( (lv_entities_1_0= RULE_ID ) )
            // InternalJDL.g:2113:4: (lv_entities_1_0= RULE_ID )
            {
            // InternalJDL.g:2113:4: (lv_entities_1_0= RULE_ID )
            // InternalJDL.g:2114:5: lv_entities_1_0= RULE_ID
            {
            lv_entities_1_0=(Token)match(input,RULE_ID,FOLLOW_38); 

            					newLeafNode(lv_entities_1_0, grammarAccess.getServiceGenerationSettingAccess().getEntitiesIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getServiceGenerationSettingRule());
            					}
            					addWithLastConsumed(
            						current,
            						"entities",
            						lv_entities_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalJDL.g:2130:3: (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==13) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalJDL.g:2131:4: otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) )
            	    {
            	    otherlv_2=(Token)match(input,13,FOLLOW_4); 

            	    				newLeafNode(otherlv_2, grammarAccess.getServiceGenerationSettingAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalJDL.g:2135:4: ( (lv_entities_3_0= RULE_ID ) )
            	    // InternalJDL.g:2136:5: (lv_entities_3_0= RULE_ID )
            	    {
            	    // InternalJDL.g:2136:5: (lv_entities_3_0= RULE_ID )
            	    // InternalJDL.g:2137:6: lv_entities_3_0= RULE_ID
            	    {
            	    lv_entities_3_0=(Token)match(input,RULE_ID,FOLLOW_38); 

            	    						newLeafNode(lv_entities_3_0, grammarAccess.getServiceGenerationSettingAccess().getEntitiesIDTerminalRuleCall_2_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getServiceGenerationSettingRule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"entities",
            	    							lv_entities_3_0,
            	    							"org.eclipse.xtext.common.Terminals.ID");
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            otherlv_4=(Token)match(input,40,FOLLOW_39); 

            			newLeafNode(otherlv_4, grammarAccess.getServiceGenerationSettingAccess().getWithKeyword_3());
            		
            // InternalJDL.g:2158:3: ( (lv_serviceType_5_0= ruleServiceType ) )
            // InternalJDL.g:2159:4: (lv_serviceType_5_0= ruleServiceType )
            {
            // InternalJDL.g:2159:4: (lv_serviceType_5_0= ruleServiceType )
            // InternalJDL.g:2160:5: lv_serviceType_5_0= ruleServiceType
            {

            					newCompositeNode(grammarAccess.getServiceGenerationSettingAccess().getServiceTypeServiceTypeEnumRuleCall_4_0());
            				
            pushFollow(FOLLOW_2);
            lv_serviceType_5_0=ruleServiceType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getServiceGenerationSettingRule());
            					}
            					set(
            						current,
            						"serviceType",
            						lv_serviceType_5_0,
            						"io.github.jhipster.jdl.dsl.JDL.ServiceType");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleServiceGenerationSetting"


    // $ANTLR start "entryRuleDTOGenerationSetting"
    // InternalJDL.g:2181:1: entryRuleDTOGenerationSetting returns [EObject current=null] : iv_ruleDTOGenerationSetting= ruleDTOGenerationSetting EOF ;
    public final EObject entryRuleDTOGenerationSetting() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDTOGenerationSetting = null;


        try {
            // InternalJDL.g:2181:61: (iv_ruleDTOGenerationSetting= ruleDTOGenerationSetting EOF )
            // InternalJDL.g:2182:2: iv_ruleDTOGenerationSetting= ruleDTOGenerationSetting EOF
            {
             newCompositeNode(grammarAccess.getDTOGenerationSettingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDTOGenerationSetting=ruleDTOGenerationSetting();

            state._fsp--;

             current =iv_ruleDTOGenerationSetting; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDTOGenerationSetting"


    // $ANTLR start "ruleDTOGenerationSetting"
    // InternalJDL.g:2188:1: ruleDTOGenerationSetting returns [EObject current=null] : (otherlv_0= 'dto' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_dtoType_5_0= ruleDTOType ) ) ) ;
    public final EObject ruleDTOGenerationSetting() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_entities_1_0=null;
        Token otherlv_2=null;
        Token lv_entities_3_0=null;
        Token otherlv_4=null;
        Enumerator lv_dtoType_5_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:2194:2: ( (otherlv_0= 'dto' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_dtoType_5_0= ruleDTOType ) ) ) )
            // InternalJDL.g:2195:2: (otherlv_0= 'dto' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_dtoType_5_0= ruleDTOType ) ) )
            {
            // InternalJDL.g:2195:2: (otherlv_0= 'dto' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_dtoType_5_0= ruleDTOType ) ) )
            // InternalJDL.g:2196:3: otherlv_0= 'dto' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_dtoType_5_0= ruleDTOType ) )
            {
            otherlv_0=(Token)match(input,41,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getDTOGenerationSettingAccess().getDtoKeyword_0());
            		
            // InternalJDL.g:2200:3: ( (lv_entities_1_0= RULE_ID ) )
            // InternalJDL.g:2201:4: (lv_entities_1_0= RULE_ID )
            {
            // InternalJDL.g:2201:4: (lv_entities_1_0= RULE_ID )
            // InternalJDL.g:2202:5: lv_entities_1_0= RULE_ID
            {
            lv_entities_1_0=(Token)match(input,RULE_ID,FOLLOW_38); 

            					newLeafNode(lv_entities_1_0, grammarAccess.getDTOGenerationSettingAccess().getEntitiesIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDTOGenerationSettingRule());
            					}
            					addWithLastConsumed(
            						current,
            						"entities",
            						lv_entities_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalJDL.g:2218:3: (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==13) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalJDL.g:2219:4: otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) )
            	    {
            	    otherlv_2=(Token)match(input,13,FOLLOW_4); 

            	    				newLeafNode(otherlv_2, grammarAccess.getDTOGenerationSettingAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalJDL.g:2223:4: ( (lv_entities_3_0= RULE_ID ) )
            	    // InternalJDL.g:2224:5: (lv_entities_3_0= RULE_ID )
            	    {
            	    // InternalJDL.g:2224:5: (lv_entities_3_0= RULE_ID )
            	    // InternalJDL.g:2225:6: lv_entities_3_0= RULE_ID
            	    {
            	    lv_entities_3_0=(Token)match(input,RULE_ID,FOLLOW_38); 

            	    						newLeafNode(lv_entities_3_0, grammarAccess.getDTOGenerationSettingAccess().getEntitiesIDTerminalRuleCall_2_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getDTOGenerationSettingRule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"entities",
            	    							lv_entities_3_0,
            	    							"org.eclipse.xtext.common.Terminals.ID");
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

            otherlv_4=(Token)match(input,40,FOLLOW_40); 

            			newLeafNode(otherlv_4, grammarAccess.getDTOGenerationSettingAccess().getWithKeyword_3());
            		
            // InternalJDL.g:2246:3: ( (lv_dtoType_5_0= ruleDTOType ) )
            // InternalJDL.g:2247:4: (lv_dtoType_5_0= ruleDTOType )
            {
            // InternalJDL.g:2247:4: (lv_dtoType_5_0= ruleDTOType )
            // InternalJDL.g:2248:5: lv_dtoType_5_0= ruleDTOType
            {

            					newCompositeNode(grammarAccess.getDTOGenerationSettingAccess().getDtoTypeDTOTypeEnumRuleCall_4_0());
            				
            pushFollow(FOLLOW_2);
            lv_dtoType_5_0=ruleDTOType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDTOGenerationSettingRule());
            					}
            					set(
            						current,
            						"dtoType",
            						lv_dtoType_5_0,
            						"io.github.jhipster.jdl.dsl.JDL.DTOType");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDTOGenerationSetting"


    // $ANTLR start "entryRulePaginateGenerationSetting"
    // InternalJDL.g:2269:1: entryRulePaginateGenerationSetting returns [EObject current=null] : iv_rulePaginateGenerationSetting= rulePaginateGenerationSetting EOF ;
    public final EObject entryRulePaginateGenerationSetting() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePaginateGenerationSetting = null;


        try {
            // InternalJDL.g:2269:66: (iv_rulePaginateGenerationSetting= rulePaginateGenerationSetting EOF )
            // InternalJDL.g:2270:2: iv_rulePaginateGenerationSetting= rulePaginateGenerationSetting EOF
            {
             newCompositeNode(grammarAccess.getPaginateGenerationSettingRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePaginateGenerationSetting=rulePaginateGenerationSetting();

            state._fsp--;

             current =iv_rulePaginateGenerationSetting; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePaginateGenerationSetting"


    // $ANTLR start "rulePaginateGenerationSetting"
    // InternalJDL.g:2276:1: rulePaginateGenerationSetting returns [EObject current=null] : (otherlv_0= 'paginate' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_paginateType_5_0= rulePaginateType ) ) ) ;
    public final EObject rulePaginateGenerationSetting() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_entities_1_0=null;
        Token otherlv_2=null;
        Token lv_entities_3_0=null;
        Token otherlv_4=null;
        Enumerator lv_paginateType_5_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:2282:2: ( (otherlv_0= 'paginate' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_paginateType_5_0= rulePaginateType ) ) ) )
            // InternalJDL.g:2283:2: (otherlv_0= 'paginate' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_paginateType_5_0= rulePaginateType ) ) )
            {
            // InternalJDL.g:2283:2: (otherlv_0= 'paginate' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_paginateType_5_0= rulePaginateType ) ) )
            // InternalJDL.g:2284:3: otherlv_0= 'paginate' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_paginateType_5_0= rulePaginateType ) )
            {
            otherlv_0=(Token)match(input,42,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getPaginateGenerationSettingAccess().getPaginateKeyword_0());
            		
            // InternalJDL.g:2288:3: ( (lv_entities_1_0= RULE_ID ) )
            // InternalJDL.g:2289:4: (lv_entities_1_0= RULE_ID )
            {
            // InternalJDL.g:2289:4: (lv_entities_1_0= RULE_ID )
            // InternalJDL.g:2290:5: lv_entities_1_0= RULE_ID
            {
            lv_entities_1_0=(Token)match(input,RULE_ID,FOLLOW_38); 

            					newLeafNode(lv_entities_1_0, grammarAccess.getPaginateGenerationSettingAccess().getEntitiesIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPaginateGenerationSettingRule());
            					}
            					addWithLastConsumed(
            						current,
            						"entities",
            						lv_entities_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalJDL.g:2306:3: (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==13) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalJDL.g:2307:4: otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) )
            	    {
            	    otherlv_2=(Token)match(input,13,FOLLOW_4); 

            	    				newLeafNode(otherlv_2, grammarAccess.getPaginateGenerationSettingAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalJDL.g:2311:4: ( (lv_entities_3_0= RULE_ID ) )
            	    // InternalJDL.g:2312:5: (lv_entities_3_0= RULE_ID )
            	    {
            	    // InternalJDL.g:2312:5: (lv_entities_3_0= RULE_ID )
            	    // InternalJDL.g:2313:6: lv_entities_3_0= RULE_ID
            	    {
            	    lv_entities_3_0=(Token)match(input,RULE_ID,FOLLOW_38); 

            	    						newLeafNode(lv_entities_3_0, grammarAccess.getPaginateGenerationSettingAccess().getEntitiesIDTerminalRuleCall_2_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getPaginateGenerationSettingRule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"entities",
            	    							lv_entities_3_0,
            	    							"org.eclipse.xtext.common.Terminals.ID");
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            otherlv_4=(Token)match(input,40,FOLLOW_41); 

            			newLeafNode(otherlv_4, grammarAccess.getPaginateGenerationSettingAccess().getWithKeyword_3());
            		
            // InternalJDL.g:2334:3: ( (lv_paginateType_5_0= rulePaginateType ) )
            // InternalJDL.g:2335:4: (lv_paginateType_5_0= rulePaginateType )
            {
            // InternalJDL.g:2335:4: (lv_paginateType_5_0= rulePaginateType )
            // InternalJDL.g:2336:5: lv_paginateType_5_0= rulePaginateType
            {

            					newCompositeNode(grammarAccess.getPaginateGenerationSettingAccess().getPaginateTypePaginateTypeEnumRuleCall_4_0());
            				
            pushFollow(FOLLOW_2);
            lv_paginateType_5_0=rulePaginateType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPaginateGenerationSettingRule());
            					}
            					set(
            						current,
            						"paginateType",
            						lv_paginateType_5_0,
            						"io.github.jhipster.jdl.dsl.JDL.PaginateType");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePaginateGenerationSetting"


    // $ANTLR start "entryRuleAngularSuffixGenerationSetting"
    // InternalJDL.g:2357:1: entryRuleAngularSuffixGenerationSetting returns [EObject current=null] : iv_ruleAngularSuffixGenerationSetting= ruleAngularSuffixGenerationSetting EOF ;
    public final EObject entryRuleAngularSuffixGenerationSetting() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAngularSuffixGenerationSetting = null;


        try {
            // InternalJDL.g:2357:71: (iv_ruleAngularSuffixGenerationSetting= ruleAngularSuffixGenerationSetting EOF )
            // InternalJDL.g:2358:2: iv_ruleAngularSuffixGenerationSetting= ruleAngularSuffixGenerationSetting EOF
            {
             newCompositeNode(grammarAccess.getAngularSuffixGenerationSettingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAngularSuffixGenerationSetting=ruleAngularSuffixGenerationSetting();

            state._fsp--;

             current =iv_ruleAngularSuffixGenerationSetting; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAngularSuffixGenerationSetting"


    // $ANTLR start "ruleAngularSuffixGenerationSetting"
    // InternalJDL.g:2364:1: ruleAngularSuffixGenerationSetting returns [EObject current=null] : (otherlv_0= 'angularSuffix' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_id_5_0= RULE_ID ) ) ) ;
    public final EObject ruleAngularSuffixGenerationSetting() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_entities_1_0=null;
        Token otherlv_2=null;
        Token lv_entities_3_0=null;
        Token otherlv_4=null;
        Token lv_id_5_0=null;


        	enterRule();

        try {
            // InternalJDL.g:2370:2: ( (otherlv_0= 'angularSuffix' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_id_5_0= RULE_ID ) ) ) )
            // InternalJDL.g:2371:2: (otherlv_0= 'angularSuffix' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_id_5_0= RULE_ID ) ) )
            {
            // InternalJDL.g:2371:2: (otherlv_0= 'angularSuffix' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_id_5_0= RULE_ID ) ) )
            // InternalJDL.g:2372:3: otherlv_0= 'angularSuffix' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_id_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,43,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getAngularSuffixGenerationSettingAccess().getAngularSuffixKeyword_0());
            		
            // InternalJDL.g:2376:3: ( (lv_entities_1_0= RULE_ID ) )
            // InternalJDL.g:2377:4: (lv_entities_1_0= RULE_ID )
            {
            // InternalJDL.g:2377:4: (lv_entities_1_0= RULE_ID )
            // InternalJDL.g:2378:5: lv_entities_1_0= RULE_ID
            {
            lv_entities_1_0=(Token)match(input,RULE_ID,FOLLOW_38); 

            					newLeafNode(lv_entities_1_0, grammarAccess.getAngularSuffixGenerationSettingAccess().getEntitiesIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAngularSuffixGenerationSettingRule());
            					}
            					addWithLastConsumed(
            						current,
            						"entities",
            						lv_entities_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalJDL.g:2394:3: (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==13) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalJDL.g:2395:4: otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) )
            	    {
            	    otherlv_2=(Token)match(input,13,FOLLOW_4); 

            	    				newLeafNode(otherlv_2, grammarAccess.getAngularSuffixGenerationSettingAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalJDL.g:2399:4: ( (lv_entities_3_0= RULE_ID ) )
            	    // InternalJDL.g:2400:5: (lv_entities_3_0= RULE_ID )
            	    {
            	    // InternalJDL.g:2400:5: (lv_entities_3_0= RULE_ID )
            	    // InternalJDL.g:2401:6: lv_entities_3_0= RULE_ID
            	    {
            	    lv_entities_3_0=(Token)match(input,RULE_ID,FOLLOW_38); 

            	    						newLeafNode(lv_entities_3_0, grammarAccess.getAngularSuffixGenerationSettingAccess().getEntitiesIDTerminalRuleCall_2_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getAngularSuffixGenerationSettingRule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"entities",
            	    							lv_entities_3_0,
            	    							"org.eclipse.xtext.common.Terminals.ID");
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            otherlv_4=(Token)match(input,40,FOLLOW_4); 

            			newLeafNode(otherlv_4, grammarAccess.getAngularSuffixGenerationSettingAccess().getWithKeyword_3());
            		
            // InternalJDL.g:2422:3: ( (lv_id_5_0= RULE_ID ) )
            // InternalJDL.g:2423:4: (lv_id_5_0= RULE_ID )
            {
            // InternalJDL.g:2423:4: (lv_id_5_0= RULE_ID )
            // InternalJDL.g:2424:5: lv_id_5_0= RULE_ID
            {
            lv_id_5_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_id_5_0, grammarAccess.getAngularSuffixGenerationSettingAccess().getIdIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAngularSuffixGenerationSettingRule());
            					}
            					setWithLastConsumed(
            						current,
            						"id",
            						lv_id_5_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAngularSuffixGenerationSetting"


    // $ANTLR start "ruleCardinality"
    // InternalJDL.g:2444:1: ruleCardinality returns [Enumerator current=null] : ( (enumLiteral_0= 'OneToMany' ) | (enumLiteral_1= 'ManyToOne' ) | (enumLiteral_2= 'OneToOne' ) | (enumLiteral_3= 'ManyToMany' ) ) ;
    public final Enumerator ruleCardinality() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalJDL.g:2450:2: ( ( (enumLiteral_0= 'OneToMany' ) | (enumLiteral_1= 'ManyToOne' ) | (enumLiteral_2= 'OneToOne' ) | (enumLiteral_3= 'ManyToMany' ) ) )
            // InternalJDL.g:2451:2: ( (enumLiteral_0= 'OneToMany' ) | (enumLiteral_1= 'ManyToOne' ) | (enumLiteral_2= 'OneToOne' ) | (enumLiteral_3= 'ManyToMany' ) )
            {
            // InternalJDL.g:2451:2: ( (enumLiteral_0= 'OneToMany' ) | (enumLiteral_1= 'ManyToOne' ) | (enumLiteral_2= 'OneToOne' ) | (enumLiteral_3= 'ManyToMany' ) )
            int alt35=4;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt35=1;
                }
                break;
            case 45:
                {
                alt35=2;
                }
                break;
            case 46:
                {
                alt35=3;
                }
                break;
            case 47:
                {
                alt35=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // InternalJDL.g:2452:3: (enumLiteral_0= 'OneToMany' )
                    {
                    // InternalJDL.g:2452:3: (enumLiteral_0= 'OneToMany' )
                    // InternalJDL.g:2453:4: enumLiteral_0= 'OneToMany'
                    {
                    enumLiteral_0=(Token)match(input,44,FOLLOW_2); 

                    				current = grammarAccess.getCardinalityAccess().getOneToManyEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCardinalityAccess().getOneToManyEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalJDL.g:2460:3: (enumLiteral_1= 'ManyToOne' )
                    {
                    // InternalJDL.g:2460:3: (enumLiteral_1= 'ManyToOne' )
                    // InternalJDL.g:2461:4: enumLiteral_1= 'ManyToOne'
                    {
                    enumLiteral_1=(Token)match(input,45,FOLLOW_2); 

                    				current = grammarAccess.getCardinalityAccess().getManyToOneEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getCardinalityAccess().getManyToOneEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalJDL.g:2468:3: (enumLiteral_2= 'OneToOne' )
                    {
                    // InternalJDL.g:2468:3: (enumLiteral_2= 'OneToOne' )
                    // InternalJDL.g:2469:4: enumLiteral_2= 'OneToOne'
                    {
                    enumLiteral_2=(Token)match(input,46,FOLLOW_2); 

                    				current = grammarAccess.getCardinalityAccess().getOneToOneEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getCardinalityAccess().getOneToOneEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalJDL.g:2476:3: (enumLiteral_3= 'ManyToMany' )
                    {
                    // InternalJDL.g:2476:3: (enumLiteral_3= 'ManyToMany' )
                    // InternalJDL.g:2477:4: enumLiteral_3= 'ManyToMany'
                    {
                    enumLiteral_3=(Token)match(input,47,FOLLOW_2); 

                    				current = grammarAccess.getCardinalityAccess().getManyToManyEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getCardinalityAccess().getManyToManyEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCardinality"


    // $ANTLR start "ruleServiceType"
    // InternalJDL.g:2487:1: ruleServiceType returns [Enumerator current=null] : ( (enumLiteral_0= 'serviceClass' ) | (enumLiteral_1= 'serviceImpl' ) ) ;
    public final Enumerator ruleServiceType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalJDL.g:2493:2: ( ( (enumLiteral_0= 'serviceClass' ) | (enumLiteral_1= 'serviceImpl' ) ) )
            // InternalJDL.g:2494:2: ( (enumLiteral_0= 'serviceClass' ) | (enumLiteral_1= 'serviceImpl' ) )
            {
            // InternalJDL.g:2494:2: ( (enumLiteral_0= 'serviceClass' ) | (enumLiteral_1= 'serviceImpl' ) )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==48) ) {
                alt36=1;
            }
            else if ( (LA36_0==49) ) {
                alt36=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // InternalJDL.g:2495:3: (enumLiteral_0= 'serviceClass' )
                    {
                    // InternalJDL.g:2495:3: (enumLiteral_0= 'serviceClass' )
                    // InternalJDL.g:2496:4: enumLiteral_0= 'serviceClass'
                    {
                    enumLiteral_0=(Token)match(input,48,FOLLOW_2); 

                    				current = grammarAccess.getServiceTypeAccess().getServiceClassEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getServiceTypeAccess().getServiceClassEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalJDL.g:2503:3: (enumLiteral_1= 'serviceImpl' )
                    {
                    // InternalJDL.g:2503:3: (enumLiteral_1= 'serviceImpl' )
                    // InternalJDL.g:2504:4: enumLiteral_1= 'serviceImpl'
                    {
                    enumLiteral_1=(Token)match(input,49,FOLLOW_2); 

                    				current = grammarAccess.getServiceTypeAccess().getServiceImplEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getServiceTypeAccess().getServiceImplEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleServiceType"


    // $ANTLR start "ruleDTOType"
    // InternalJDL.g:2514:1: ruleDTOType returns [Enumerator current=null] : (enumLiteral_0= 'mapstruct' ) ;
    public final Enumerator ruleDTOType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;


        	enterRule();

        try {
            // InternalJDL.g:2520:2: ( (enumLiteral_0= 'mapstruct' ) )
            // InternalJDL.g:2521:2: (enumLiteral_0= 'mapstruct' )
            {
            // InternalJDL.g:2521:2: (enumLiteral_0= 'mapstruct' )
            // InternalJDL.g:2522:3: enumLiteral_0= 'mapstruct'
            {
            enumLiteral_0=(Token)match(input,50,FOLLOW_2); 

            			current = grammarAccess.getDTOTypeAccess().getMapstructEnumLiteralDeclaration().getEnumLiteral().getInstance();
            			newLeafNode(enumLiteral_0, grammarAccess.getDTOTypeAccess().getMapstructEnumLiteralDeclaration());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDTOType"


    // $ANTLR start "rulePaginateType"
    // InternalJDL.g:2531:1: rulePaginateType returns [Enumerator current=null] : ( (enumLiteral_0= 'pagination' ) | (enumLiteral_1= 'infiniteScroll' ) ) ;
    public final Enumerator rulePaginateType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalJDL.g:2537:2: ( ( (enumLiteral_0= 'pagination' ) | (enumLiteral_1= 'infiniteScroll' ) ) )
            // InternalJDL.g:2538:2: ( (enumLiteral_0= 'pagination' ) | (enumLiteral_1= 'infiniteScroll' ) )
            {
            // InternalJDL.g:2538:2: ( (enumLiteral_0= 'pagination' ) | (enumLiteral_1= 'infiniteScroll' ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==51) ) {
                alt37=1;
            }
            else if ( (LA37_0==52) ) {
                alt37=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // InternalJDL.g:2539:3: (enumLiteral_0= 'pagination' )
                    {
                    // InternalJDL.g:2539:3: (enumLiteral_0= 'pagination' )
                    // InternalJDL.g:2540:4: enumLiteral_0= 'pagination'
                    {
                    enumLiteral_0=(Token)match(input,51,FOLLOW_2); 

                    				current = grammarAccess.getPaginateTypeAccess().getPaginationEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getPaginateTypeAccess().getPaginationEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalJDL.g:2547:3: (enumLiteral_1= 'infiniteScroll' )
                    {
                    // InternalJDL.g:2547:3: (enumLiteral_1= 'infiniteScroll' )
                    // InternalJDL.g:2548:4: enumLiteral_1= 'infiniteScroll'
                    {
                    enumLiteral_1=(Token)match(input,52,FOLLOW_2); 

                    				current = grammarAccess.getPaginateTypeAccess().getInfiniteScrollEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getPaginateTypeAccess().getInfiniteScrollEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePaginateType"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00000EA000000802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000190000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000180000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000600000002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000001800000002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000F00000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000004800L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000004000001000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000010000002000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0003000000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0018000000000000L});

}