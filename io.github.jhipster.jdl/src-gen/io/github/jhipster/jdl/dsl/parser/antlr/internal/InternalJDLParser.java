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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'entity'", "'{'", "','", "'}'", "'String'", "'Integer'", "'Long'", "'BigDecimal'", "'Float'", "'Double'", "'Boolean'", "'LocalDate'", "'ZonedDateTime'", "'Blob'", "'AnyBlob'", "'ImageBlob'", "'required'", "'minlength'", "'('", "')'", "'maxlength'", "'pattern'", "'min'", "'max'", "'minbytes'", "'maxbytes'", "'relationship'", "'to'", "'enum'", "'service'", "'with'", "'dto'", "'paginate'", "'angularSuffix'", "'OneToMany'", "'ManyToOne'", "'OneToOne'", "'ManyToMany'", "'serviceClass'", "'serviceImpl'", "'mapstruct'", "'pagination'", "'infiniteScroll'"
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
    public static final int T__53=53;
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

                if ( (LA1_0==11||LA1_0==37||(LA1_0>=39 && LA1_0<=40)||(LA1_0>=42 && LA1_0<=44)) ) {
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
    // InternalJDL.g:108:1: ruleElements returns [EObject current=null] : (this_Entity_0= ruleEntity | this_EnumType_1= ruleEnumType | this_Relationships_2= ruleRelationships | this_GenerationSetting_3= ruleGenerationSetting ) ;
    public final EObject ruleElements() throws RecognitionException {
        EObject current = null;

        EObject this_Entity_0 = null;

        EObject this_EnumType_1 = null;

        EObject this_Relationships_2 = null;

        EObject this_GenerationSetting_3 = null;



        	enterRule();

        try {
            // InternalJDL.g:114:2: ( (this_Entity_0= ruleEntity | this_EnumType_1= ruleEnumType | this_Relationships_2= ruleRelationships | this_GenerationSetting_3= ruleGenerationSetting ) )
            // InternalJDL.g:115:2: (this_Entity_0= ruleEntity | this_EnumType_1= ruleEnumType | this_Relationships_2= ruleRelationships | this_GenerationSetting_3= ruleGenerationSetting )
            {
            // InternalJDL.g:115:2: (this_Entity_0= ruleEntity | this_EnumType_1= ruleEnumType | this_Relationships_2= ruleRelationships | this_GenerationSetting_3= ruleGenerationSetting )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt2=1;
                }
                break;
            case 39:
                {
                alt2=2;
                }
                break;
            case 37:
                {
                alt2=3;
                }
                break;
            case 40:
            case 42:
            case 43:
            case 44:
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
                    // InternalJDL.g:125:3: this_EnumType_1= ruleEnumType
                    {

                    			newCompositeNode(grammarAccess.getElementsAccess().getEnumTypeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_EnumType_1=ruleEnumType();

                    state._fsp--;


                    			current = this_EnumType_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalJDL.g:134:3: this_Relationships_2= ruleRelationships
                    {

                    			newCompositeNode(grammarAccess.getElementsAccess().getRelationshipsParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Relationships_2=ruleRelationships();

                    state._fsp--;


                    			current = this_Relationships_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalJDL.g:143:3: this_GenerationSetting_3= ruleGenerationSetting
                    {

                    			newCompositeNode(grammarAccess.getElementsAccess().getGenerationSettingParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_GenerationSetting_3=ruleGenerationSetting();

                    state._fsp--;


                    			current = this_GenerationSetting_3;
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
    // InternalJDL.g:155:1: entryRuleEntity returns [EObject current=null] : iv_ruleEntity= ruleEntity EOF ;
    public final EObject entryRuleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntity = null;


        try {
            // InternalJDL.g:155:47: (iv_ruleEntity= ruleEntity EOF )
            // InternalJDL.g:156:2: iv_ruleEntity= ruleEntity EOF
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
    // InternalJDL.g:162:1: ruleEntity returns [EObject current=null] : (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleField ) ) )* otherlv_6= '}' ) ;
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
            // InternalJDL.g:168:2: ( (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleField ) ) )* otherlv_6= '}' ) )
            // InternalJDL.g:169:2: (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleField ) ) )* otherlv_6= '}' )
            {
            // InternalJDL.g:169:2: (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleField ) ) )* otherlv_6= '}' )
            // InternalJDL.g:170:3: otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleField ) ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getEntityAccess().getEntityKeyword_0());
            		
            // InternalJDL.g:174:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalJDL.g:175:4: (lv_name_1_0= RULE_ID )
            {
            // InternalJDL.g:175:4: (lv_name_1_0= RULE_ID )
            // InternalJDL.g:176:5: lv_name_1_0= RULE_ID
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
            		
            // InternalJDL.g:196:3: ( (lv_fields_3_0= ruleField ) )
            // InternalJDL.g:197:4: (lv_fields_3_0= ruleField )
            {
            // InternalJDL.g:197:4: (lv_fields_3_0= ruleField )
            // InternalJDL.g:198:5: lv_fields_3_0= ruleField
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

            // InternalJDL.g:215:3: (otherlv_4= ',' ( (lv_fields_5_0= ruleField ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalJDL.g:216:4: otherlv_4= ',' ( (lv_fields_5_0= ruleField ) )
            	    {
            	    otherlv_4=(Token)match(input,13,FOLLOW_4); 

            	    				newLeafNode(otherlv_4, grammarAccess.getEntityAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalJDL.g:220:4: ( (lv_fields_5_0= ruleField ) )
            	    // InternalJDL.g:221:5: (lv_fields_5_0= ruleField )
            	    {
            	    // InternalJDL.g:221:5: (lv_fields_5_0= ruleField )
            	    // InternalJDL.g:222:6: lv_fields_5_0= ruleField
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
    // InternalJDL.g:248:1: entryRuleField returns [EObject current=null] : iv_ruleField= ruleField EOF ;
    public final EObject entryRuleField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleField = null;


        try {
            // InternalJDL.g:248:46: (iv_ruleField= ruleField EOF )
            // InternalJDL.g:249:2: iv_ruleField= ruleField EOF
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
    // InternalJDL.g:255:1: ruleField returns [EObject current=null] : (this_StringField_0= ruleStringField | this_NumericField_1= ruleNumericField | this_BooleanField_2= ruleBooleanField | this_DateField_3= ruleDateField | this_BinaryLargeObjectField_4= ruleBinaryLargeObjectField | this_EnumField_5= ruleEnumField ) ;
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
            // InternalJDL.g:261:2: ( (this_StringField_0= ruleStringField | this_NumericField_1= ruleNumericField | this_BooleanField_2= ruleBooleanField | this_DateField_3= ruleDateField | this_BinaryLargeObjectField_4= ruleBinaryLargeObjectField | this_EnumField_5= ruleEnumField ) )
            // InternalJDL.g:262:2: (this_StringField_0= ruleStringField | this_NumericField_1= ruleNumericField | this_BooleanField_2= ruleBooleanField | this_DateField_3= ruleDateField | this_BinaryLargeObjectField_4= ruleBinaryLargeObjectField | this_EnumField_5= ruleEnumField )
            {
            // InternalJDL.g:262:2: (this_StringField_0= ruleStringField | this_NumericField_1= ruleNumericField | this_BooleanField_2= ruleBooleanField | this_DateField_3= ruleDateField | this_BinaryLargeObjectField_4= ruleBinaryLargeObjectField | this_EnumField_5= ruleEnumField )
            int alt4=6;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                switch ( input.LA(2) ) {
                case 24:
                case 25:
                case 26:
                    {
                    alt4=5;
                    }
                    break;
                case 22:
                case 23:
                    {
                    alt4=4;
                    }
                    break;
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                    {
                    alt4=2;
                    }
                    break;
                case RULE_ID:
                    {
                    alt4=6;
                    }
                    break;
                case 15:
                    {
                    alt4=1;
                    }
                    break;
                case 21:
                    {
                    alt4=3;
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
                    // InternalJDL.g:263:3: this_StringField_0= ruleStringField
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
                    // InternalJDL.g:272:3: this_NumericField_1= ruleNumericField
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
                    // InternalJDL.g:281:3: this_BooleanField_2= ruleBooleanField
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
                    // InternalJDL.g:290:3: this_DateField_3= ruleDateField
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
                    // InternalJDL.g:299:3: this_BinaryLargeObjectField_4= ruleBinaryLargeObjectField
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
                    // InternalJDL.g:308:3: this_EnumField_5= ruleEnumField
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
    // InternalJDL.g:320:1: entryRuleEnumField returns [EObject current=null] : iv_ruleEnumField= ruleEnumField EOF ;
    public final EObject entryRuleEnumField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumField = null;


        try {
            // InternalJDL.g:320:50: (iv_ruleEnumField= ruleEnumField EOF )
            // InternalJDL.g:321:2: iv_ruleEnumField= ruleEnumField EOF
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
    // InternalJDL.g:327:1: ruleEnumField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) ) ( (lv_validators_2_0= ruleRequiredValidator ) )? ) ;
    public final EObject ruleEnumField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_validators_2_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:333:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) ) ( (lv_validators_2_0= ruleRequiredValidator ) )? ) )
            // InternalJDL.g:334:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) ) ( (lv_validators_2_0= ruleRequiredValidator ) )? )
            {
            // InternalJDL.g:334:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) ) ( (lv_validators_2_0= ruleRequiredValidator ) )? )
            // InternalJDL.g:335:3: ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) ) ( (lv_validators_2_0= ruleRequiredValidator ) )?
            {
            // InternalJDL.g:335:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalJDL.g:336:4: (lv_name_0_0= RULE_ID )
            {
            // InternalJDL.g:336:4: (lv_name_0_0= RULE_ID )
            // InternalJDL.g:337:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_0_0, grammarAccess.getEnumFieldAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEnumFieldRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalJDL.g:353:3: ( (otherlv_1= RULE_ID ) )
            // InternalJDL.g:354:4: (otherlv_1= RULE_ID )
            {
            // InternalJDL.g:354:4: (otherlv_1= RULE_ID )
            // InternalJDL.g:355:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEnumFieldRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(otherlv_1, grammarAccess.getEnumFieldAccess().getEnumTypeEnumTypeCrossReference_1_0());
            				

            }


            }

            // InternalJDL.g:366:3: ( (lv_validators_2_0= ruleRequiredValidator ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==27) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalJDL.g:367:4: (lv_validators_2_0= ruleRequiredValidator )
                    {
                    // InternalJDL.g:367:4: (lv_validators_2_0= ruleRequiredValidator )
                    // InternalJDL.g:368:5: lv_validators_2_0= ruleRequiredValidator
                    {

                    					newCompositeNode(grammarAccess.getEnumFieldAccess().getValidatorsRequiredValidatorParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_2_0=ruleRequiredValidator();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getEnumFieldRule());
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
    // $ANTLR end "ruleEnumField"


    // $ANTLR start "entryRuleStringField"
    // InternalJDL.g:389:1: entryRuleStringField returns [EObject current=null] : iv_ruleStringField= ruleStringField EOF ;
    public final EObject entryRuleStringField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringField = null;


        try {
            // InternalJDL.g:389:52: (iv_ruleStringField= ruleStringField EOF )
            // InternalJDL.g:390:2: iv_ruleStringField= ruleStringField EOF
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
    // InternalJDL.g:396:1: ruleStringField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'String' ( (lv_validators_2_0= ruleStringValidators ) )? ) ;
    public final EObject ruleStringField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_validators_2_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:402:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'String' ( (lv_validators_2_0= ruleStringValidators ) )? ) )
            // InternalJDL.g:403:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'String' ( (lv_validators_2_0= ruleStringValidators ) )? )
            {
            // InternalJDL.g:403:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'String' ( (lv_validators_2_0= ruleStringValidators ) )? )
            // InternalJDL.g:404:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'String' ( (lv_validators_2_0= ruleStringValidators ) )?
            {
            // InternalJDL.g:404:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalJDL.g:405:4: (lv_name_0_0= RULE_ID )
            {
            // InternalJDL.g:405:4: (lv_name_0_0= RULE_ID )
            // InternalJDL.g:406:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_8); 

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

            otherlv_1=(Token)match(input,15,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getStringFieldAccess().getStringKeyword_1());
            		
            // InternalJDL.g:426:3: ( (lv_validators_2_0= ruleStringValidators ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==27) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalJDL.g:427:4: (lv_validators_2_0= ruleStringValidators )
                    {
                    // InternalJDL.g:427:4: (lv_validators_2_0= ruleStringValidators )
                    // InternalJDL.g:428:5: lv_validators_2_0= ruleStringValidators
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
    // InternalJDL.g:449:1: entryRuleNumericField returns [EObject current=null] : iv_ruleNumericField= ruleNumericField EOF ;
    public final EObject entryRuleNumericField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericField = null;


        try {
            // InternalJDL.g:449:53: (iv_ruleNumericField= ruleNumericField EOF )
            // InternalJDL.g:450:2: iv_ruleNumericField= ruleNumericField EOF
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
    // InternalJDL.g:456:1: ruleNumericField returns [EObject current=null] : (this_IntegerField_0= ruleIntegerField | this_LongField_1= ruleLongField | this_BigDecimalField_2= ruleBigDecimalField | this_FloatField_3= ruleFloatField | this_DoubleField_4= ruleDoubleField ) ;
    public final EObject ruleNumericField() throws RecognitionException {
        EObject current = null;

        EObject this_IntegerField_0 = null;

        EObject this_LongField_1 = null;

        EObject this_BigDecimalField_2 = null;

        EObject this_FloatField_3 = null;

        EObject this_DoubleField_4 = null;



        	enterRule();

        try {
            // InternalJDL.g:462:2: ( (this_IntegerField_0= ruleIntegerField | this_LongField_1= ruleLongField | this_BigDecimalField_2= ruleBigDecimalField | this_FloatField_3= ruleFloatField | this_DoubleField_4= ruleDoubleField ) )
            // InternalJDL.g:463:2: (this_IntegerField_0= ruleIntegerField | this_LongField_1= ruleLongField | this_BigDecimalField_2= ruleBigDecimalField | this_FloatField_3= ruleFloatField | this_DoubleField_4= ruleDoubleField )
            {
            // InternalJDL.g:463:2: (this_IntegerField_0= ruleIntegerField | this_LongField_1= ruleLongField | this_BigDecimalField_2= ruleBigDecimalField | this_FloatField_3= ruleFloatField | this_DoubleField_4= ruleDoubleField )
            int alt7=5;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                switch ( input.LA(2) ) {
                case 18:
                    {
                    alt7=3;
                    }
                    break;
                case 20:
                    {
                    alt7=5;
                    }
                    break;
                case 17:
                    {
                    alt7=2;
                    }
                    break;
                case 19:
                    {
                    alt7=4;
                    }
                    break;
                case 16:
                    {
                    alt7=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalJDL.g:464:3: this_IntegerField_0= ruleIntegerField
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
                    // InternalJDL.g:473:3: this_LongField_1= ruleLongField
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
                    // InternalJDL.g:482:3: this_BigDecimalField_2= ruleBigDecimalField
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
                    // InternalJDL.g:491:3: this_FloatField_3= ruleFloatField
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
                    // InternalJDL.g:500:3: this_DoubleField_4= ruleDoubleField
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
    // InternalJDL.g:512:1: entryRuleIntegerField returns [EObject current=null] : iv_ruleIntegerField= ruleIntegerField EOF ;
    public final EObject entryRuleIntegerField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerField = null;


        try {
            // InternalJDL.g:512:53: (iv_ruleIntegerField= ruleIntegerField EOF )
            // InternalJDL.g:513:2: iv_ruleIntegerField= ruleIntegerField EOF
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
    // InternalJDL.g:519:1: ruleIntegerField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Integer' ( (lv_validators_2_0= ruleNumericValidators ) )? ) ;
    public final EObject ruleIntegerField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_validators_2_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:525:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Integer' ( (lv_validators_2_0= ruleNumericValidators ) )? ) )
            // InternalJDL.g:526:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Integer' ( (lv_validators_2_0= ruleNumericValidators ) )? )
            {
            // InternalJDL.g:526:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Integer' ( (lv_validators_2_0= ruleNumericValidators ) )? )
            // InternalJDL.g:527:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Integer' ( (lv_validators_2_0= ruleNumericValidators ) )?
            {
            // InternalJDL.g:527:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalJDL.g:528:4: (lv_name_0_0= RULE_ID )
            {
            // InternalJDL.g:528:4: (lv_name_0_0= RULE_ID )
            // InternalJDL.g:529:5: lv_name_0_0= RULE_ID
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

            otherlv_1=(Token)match(input,16,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getIntegerFieldAccess().getIntegerKeyword_1());
            		
            // InternalJDL.g:549:3: ( (lv_validators_2_0= ruleNumericValidators ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==27) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalJDL.g:550:4: (lv_validators_2_0= ruleNumericValidators )
                    {
                    // InternalJDL.g:550:4: (lv_validators_2_0= ruleNumericValidators )
                    // InternalJDL.g:551:5: lv_validators_2_0= ruleNumericValidators
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
    // InternalJDL.g:572:1: entryRuleLongField returns [EObject current=null] : iv_ruleLongField= ruleLongField EOF ;
    public final EObject entryRuleLongField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLongField = null;


        try {
            // InternalJDL.g:572:50: (iv_ruleLongField= ruleLongField EOF )
            // InternalJDL.g:573:2: iv_ruleLongField= ruleLongField EOF
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
    // InternalJDL.g:579:1: ruleLongField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Long' ( (lv_validators_2_0= ruleNumericValidators ) )? ) ;
    public final EObject ruleLongField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_validators_2_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:585:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Long' ( (lv_validators_2_0= ruleNumericValidators ) )? ) )
            // InternalJDL.g:586:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Long' ( (lv_validators_2_0= ruleNumericValidators ) )? )
            {
            // InternalJDL.g:586:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Long' ( (lv_validators_2_0= ruleNumericValidators ) )? )
            // InternalJDL.g:587:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Long' ( (lv_validators_2_0= ruleNumericValidators ) )?
            {
            // InternalJDL.g:587:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalJDL.g:588:4: (lv_name_0_0= RULE_ID )
            {
            // InternalJDL.g:588:4: (lv_name_0_0= RULE_ID )
            // InternalJDL.g:589:5: lv_name_0_0= RULE_ID
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

            otherlv_1=(Token)match(input,17,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getLongFieldAccess().getLongKeyword_1());
            		
            // InternalJDL.g:609:3: ( (lv_validators_2_0= ruleNumericValidators ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==27) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalJDL.g:610:4: (lv_validators_2_0= ruleNumericValidators )
                    {
                    // InternalJDL.g:610:4: (lv_validators_2_0= ruleNumericValidators )
                    // InternalJDL.g:611:5: lv_validators_2_0= ruleNumericValidators
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
    // InternalJDL.g:632:1: entryRuleBigDecimalField returns [EObject current=null] : iv_ruleBigDecimalField= ruleBigDecimalField EOF ;
    public final EObject entryRuleBigDecimalField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBigDecimalField = null;


        try {
            // InternalJDL.g:632:56: (iv_ruleBigDecimalField= ruleBigDecimalField EOF )
            // InternalJDL.g:633:2: iv_ruleBigDecimalField= ruleBigDecimalField EOF
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
    // InternalJDL.g:639:1: ruleBigDecimalField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'BigDecimal' ( (lv_validators_2_0= ruleNumericValidators ) )? ) ;
    public final EObject ruleBigDecimalField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_validators_2_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:645:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'BigDecimal' ( (lv_validators_2_0= ruleNumericValidators ) )? ) )
            // InternalJDL.g:646:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'BigDecimal' ( (lv_validators_2_0= ruleNumericValidators ) )? )
            {
            // InternalJDL.g:646:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'BigDecimal' ( (lv_validators_2_0= ruleNumericValidators ) )? )
            // InternalJDL.g:647:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'BigDecimal' ( (lv_validators_2_0= ruleNumericValidators ) )?
            {
            // InternalJDL.g:647:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalJDL.g:648:4: (lv_name_0_0= RULE_ID )
            {
            // InternalJDL.g:648:4: (lv_name_0_0= RULE_ID )
            // InternalJDL.g:649:5: lv_name_0_0= RULE_ID
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

            otherlv_1=(Token)match(input,18,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getBigDecimalFieldAccess().getBigDecimalKeyword_1());
            		
            // InternalJDL.g:669:3: ( (lv_validators_2_0= ruleNumericValidators ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==27) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalJDL.g:670:4: (lv_validators_2_0= ruleNumericValidators )
                    {
                    // InternalJDL.g:670:4: (lv_validators_2_0= ruleNumericValidators )
                    // InternalJDL.g:671:5: lv_validators_2_0= ruleNumericValidators
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
    // InternalJDL.g:692:1: entryRuleFloatField returns [EObject current=null] : iv_ruleFloatField= ruleFloatField EOF ;
    public final EObject entryRuleFloatField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFloatField = null;


        try {
            // InternalJDL.g:692:51: (iv_ruleFloatField= ruleFloatField EOF )
            // InternalJDL.g:693:2: iv_ruleFloatField= ruleFloatField EOF
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
    // InternalJDL.g:699:1: ruleFloatField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Float' ( (lv_validators_2_0= ruleNumericValidators ) )? ) ;
    public final EObject ruleFloatField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_validators_2_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:705:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Float' ( (lv_validators_2_0= ruleNumericValidators ) )? ) )
            // InternalJDL.g:706:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Float' ( (lv_validators_2_0= ruleNumericValidators ) )? )
            {
            // InternalJDL.g:706:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Float' ( (lv_validators_2_0= ruleNumericValidators ) )? )
            // InternalJDL.g:707:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Float' ( (lv_validators_2_0= ruleNumericValidators ) )?
            {
            // InternalJDL.g:707:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalJDL.g:708:4: (lv_name_0_0= RULE_ID )
            {
            // InternalJDL.g:708:4: (lv_name_0_0= RULE_ID )
            // InternalJDL.g:709:5: lv_name_0_0= RULE_ID
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

            otherlv_1=(Token)match(input,19,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getFloatFieldAccess().getFloatKeyword_1());
            		
            // InternalJDL.g:729:3: ( (lv_validators_2_0= ruleNumericValidators ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==27) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalJDL.g:730:4: (lv_validators_2_0= ruleNumericValidators )
                    {
                    // InternalJDL.g:730:4: (lv_validators_2_0= ruleNumericValidators )
                    // InternalJDL.g:731:5: lv_validators_2_0= ruleNumericValidators
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
    // InternalJDL.g:752:1: entryRuleDoubleField returns [EObject current=null] : iv_ruleDoubleField= ruleDoubleField EOF ;
    public final EObject entryRuleDoubleField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoubleField = null;


        try {
            // InternalJDL.g:752:52: (iv_ruleDoubleField= ruleDoubleField EOF )
            // InternalJDL.g:753:2: iv_ruleDoubleField= ruleDoubleField EOF
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
    // InternalJDL.g:759:1: ruleDoubleField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Double' ( (lv_validators_2_0= ruleNumericValidators ) )? ) ;
    public final EObject ruleDoubleField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_validators_2_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:765:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Double' ( (lv_validators_2_0= ruleNumericValidators ) )? ) )
            // InternalJDL.g:766:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Double' ( (lv_validators_2_0= ruleNumericValidators ) )? )
            {
            // InternalJDL.g:766:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Double' ( (lv_validators_2_0= ruleNumericValidators ) )? )
            // InternalJDL.g:767:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Double' ( (lv_validators_2_0= ruleNumericValidators ) )?
            {
            // InternalJDL.g:767:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalJDL.g:768:4: (lv_name_0_0= RULE_ID )
            {
            // InternalJDL.g:768:4: (lv_name_0_0= RULE_ID )
            // InternalJDL.g:769:5: lv_name_0_0= RULE_ID
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

            otherlv_1=(Token)match(input,20,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getDoubleFieldAccess().getDoubleKeyword_1());
            		
            // InternalJDL.g:789:3: ( (lv_validators_2_0= ruleNumericValidators ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==27) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalJDL.g:790:4: (lv_validators_2_0= ruleNumericValidators )
                    {
                    // InternalJDL.g:790:4: (lv_validators_2_0= ruleNumericValidators )
                    // InternalJDL.g:791:5: lv_validators_2_0= ruleNumericValidators
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
    // InternalJDL.g:812:1: entryRuleBooleanField returns [EObject current=null] : iv_ruleBooleanField= ruleBooleanField EOF ;
    public final EObject entryRuleBooleanField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanField = null;


        try {
            // InternalJDL.g:812:53: (iv_ruleBooleanField= ruleBooleanField EOF )
            // InternalJDL.g:813:2: iv_ruleBooleanField= ruleBooleanField EOF
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
    // InternalJDL.g:819:1: ruleBooleanField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Boolean' ( (lv_validators_2_0= ruleRequiredValidator ) )? ) ;
    public final EObject ruleBooleanField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_validators_2_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:825:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Boolean' ( (lv_validators_2_0= ruleRequiredValidator ) )? ) )
            // InternalJDL.g:826:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Boolean' ( (lv_validators_2_0= ruleRequiredValidator ) )? )
            {
            // InternalJDL.g:826:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Boolean' ( (lv_validators_2_0= ruleRequiredValidator ) )? )
            // InternalJDL.g:827:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Boolean' ( (lv_validators_2_0= ruleRequiredValidator ) )?
            {
            // InternalJDL.g:827:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalJDL.g:828:4: (lv_name_0_0= RULE_ID )
            {
            // InternalJDL.g:828:4: (lv_name_0_0= RULE_ID )
            // InternalJDL.g:829:5: lv_name_0_0= RULE_ID
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

            otherlv_1=(Token)match(input,21,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getBooleanFieldAccess().getBooleanKeyword_1());
            		
            // InternalJDL.g:849:3: ( (lv_validators_2_0= ruleRequiredValidator ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==27) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalJDL.g:850:4: (lv_validators_2_0= ruleRequiredValidator )
                    {
                    // InternalJDL.g:850:4: (lv_validators_2_0= ruleRequiredValidator )
                    // InternalJDL.g:851:5: lv_validators_2_0= ruleRequiredValidator
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
    // InternalJDL.g:872:1: entryRuleDateField returns [EObject current=null] : iv_ruleDateField= ruleDateField EOF ;
    public final EObject entryRuleDateField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDateField = null;


        try {
            // InternalJDL.g:872:50: (iv_ruleDateField= ruleDateField EOF )
            // InternalJDL.g:873:2: iv_ruleDateField= ruleDateField EOF
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
    // InternalJDL.g:879:1: ruleDateField returns [EObject current=null] : (this_LocalDateField_0= ruleLocalDateField | this_ZonedDateTimeField_1= ruleZonedDateTimeField ) ;
    public final EObject ruleDateField() throws RecognitionException {
        EObject current = null;

        EObject this_LocalDateField_0 = null;

        EObject this_ZonedDateTimeField_1 = null;



        	enterRule();

        try {
            // InternalJDL.g:885:2: ( (this_LocalDateField_0= ruleLocalDateField | this_ZonedDateTimeField_1= ruleZonedDateTimeField ) )
            // InternalJDL.g:886:2: (this_LocalDateField_0= ruleLocalDateField | this_ZonedDateTimeField_1= ruleZonedDateTimeField )
            {
            // InternalJDL.g:886:2: (this_LocalDateField_0= ruleLocalDateField | this_ZonedDateTimeField_1= ruleZonedDateTimeField )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==23) ) {
                    alt14=2;
                }
                else if ( (LA14_1==22) ) {
                    alt14=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalJDL.g:887:3: this_LocalDateField_0= ruleLocalDateField
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
                    // InternalJDL.g:896:3: this_ZonedDateTimeField_1= ruleZonedDateTimeField
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
    // InternalJDL.g:908:1: entryRuleLocalDateField returns [EObject current=null] : iv_ruleLocalDateField= ruleLocalDateField EOF ;
    public final EObject entryRuleLocalDateField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLocalDateField = null;


        try {
            // InternalJDL.g:908:55: (iv_ruleLocalDateField= ruleLocalDateField EOF )
            // InternalJDL.g:909:2: iv_ruleLocalDateField= ruleLocalDateField EOF
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
    // InternalJDL.g:915:1: ruleLocalDateField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'LocalDate' ( (lv_validators_2_0= ruleRequiredValidator ) )? ) ;
    public final EObject ruleLocalDateField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_validators_2_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:921:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'LocalDate' ( (lv_validators_2_0= ruleRequiredValidator ) )? ) )
            // InternalJDL.g:922:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'LocalDate' ( (lv_validators_2_0= ruleRequiredValidator ) )? )
            {
            // InternalJDL.g:922:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'LocalDate' ( (lv_validators_2_0= ruleRequiredValidator ) )? )
            // InternalJDL.g:923:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'LocalDate' ( (lv_validators_2_0= ruleRequiredValidator ) )?
            {
            // InternalJDL.g:923:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalJDL.g:924:4: (lv_name_0_0= RULE_ID )
            {
            // InternalJDL.g:924:4: (lv_name_0_0= RULE_ID )
            // InternalJDL.g:925:5: lv_name_0_0= RULE_ID
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

            otherlv_1=(Token)match(input,22,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getLocalDateFieldAccess().getLocalDateKeyword_1());
            		
            // InternalJDL.g:945:3: ( (lv_validators_2_0= ruleRequiredValidator ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==27) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalJDL.g:946:4: (lv_validators_2_0= ruleRequiredValidator )
                    {
                    // InternalJDL.g:946:4: (lv_validators_2_0= ruleRequiredValidator )
                    // InternalJDL.g:947:5: lv_validators_2_0= ruleRequiredValidator
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
    // InternalJDL.g:968:1: entryRuleZonedDateTimeField returns [EObject current=null] : iv_ruleZonedDateTimeField= ruleZonedDateTimeField EOF ;
    public final EObject entryRuleZonedDateTimeField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleZonedDateTimeField = null;


        try {
            // InternalJDL.g:968:59: (iv_ruleZonedDateTimeField= ruleZonedDateTimeField EOF )
            // InternalJDL.g:969:2: iv_ruleZonedDateTimeField= ruleZonedDateTimeField EOF
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
    // InternalJDL.g:975:1: ruleZonedDateTimeField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'ZonedDateTime' ( (lv_validators_2_0= ruleRequiredValidator ) )? ) ;
    public final EObject ruleZonedDateTimeField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_validators_2_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:981:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'ZonedDateTime' ( (lv_validators_2_0= ruleRequiredValidator ) )? ) )
            // InternalJDL.g:982:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'ZonedDateTime' ( (lv_validators_2_0= ruleRequiredValidator ) )? )
            {
            // InternalJDL.g:982:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'ZonedDateTime' ( (lv_validators_2_0= ruleRequiredValidator ) )? )
            // InternalJDL.g:983:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'ZonedDateTime' ( (lv_validators_2_0= ruleRequiredValidator ) )?
            {
            // InternalJDL.g:983:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalJDL.g:984:4: (lv_name_0_0= RULE_ID )
            {
            // InternalJDL.g:984:4: (lv_name_0_0= RULE_ID )
            // InternalJDL.g:985:5: lv_name_0_0= RULE_ID
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

            otherlv_1=(Token)match(input,23,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getZonedDateTimeFieldAccess().getZonedDateTimeKeyword_1());
            		
            // InternalJDL.g:1005:3: ( (lv_validators_2_0= ruleRequiredValidator ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==27) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalJDL.g:1006:4: (lv_validators_2_0= ruleRequiredValidator )
                    {
                    // InternalJDL.g:1006:4: (lv_validators_2_0= ruleRequiredValidator )
                    // InternalJDL.g:1007:5: lv_validators_2_0= ruleRequiredValidator
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
    // InternalJDL.g:1028:1: entryRuleBinaryLargeObjectField returns [EObject current=null] : iv_ruleBinaryLargeObjectField= ruleBinaryLargeObjectField EOF ;
    public final EObject entryRuleBinaryLargeObjectField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryLargeObjectField = null;


        try {
            // InternalJDL.g:1028:63: (iv_ruleBinaryLargeObjectField= ruleBinaryLargeObjectField EOF )
            // InternalJDL.g:1029:2: iv_ruleBinaryLargeObjectField= ruleBinaryLargeObjectField EOF
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
    // InternalJDL.g:1035:1: ruleBinaryLargeObjectField returns [EObject current=null] : (this_BlobField_0= ruleBlobField | this_AnyBlobField_1= ruleAnyBlobField | this_ImageBlobField_2= ruleImageBlobField ) ;
    public final EObject ruleBinaryLargeObjectField() throws RecognitionException {
        EObject current = null;

        EObject this_BlobField_0 = null;

        EObject this_AnyBlobField_1 = null;

        EObject this_ImageBlobField_2 = null;



        	enterRule();

        try {
            // InternalJDL.g:1041:2: ( (this_BlobField_0= ruleBlobField | this_AnyBlobField_1= ruleAnyBlobField | this_ImageBlobField_2= ruleImageBlobField ) )
            // InternalJDL.g:1042:2: (this_BlobField_0= ruleBlobField | this_AnyBlobField_1= ruleAnyBlobField | this_ImageBlobField_2= ruleImageBlobField )
            {
            // InternalJDL.g:1042:2: (this_BlobField_0= ruleBlobField | this_AnyBlobField_1= ruleAnyBlobField | this_ImageBlobField_2= ruleImageBlobField )
            int alt17=3;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                switch ( input.LA(2) ) {
                case 24:
                    {
                    alt17=1;
                    }
                    break;
                case 26:
                    {
                    alt17=3;
                    }
                    break;
                case 25:
                    {
                    alt17=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalJDL.g:1043:3: this_BlobField_0= ruleBlobField
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
                    // InternalJDL.g:1052:3: this_AnyBlobField_1= ruleAnyBlobField
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
                    // InternalJDL.g:1061:3: this_ImageBlobField_2= ruleImageBlobField
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
    // InternalJDL.g:1073:1: entryRuleBlobField returns [EObject current=null] : iv_ruleBlobField= ruleBlobField EOF ;
    public final EObject entryRuleBlobField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlobField = null;


        try {
            // InternalJDL.g:1073:50: (iv_ruleBlobField= ruleBlobField EOF )
            // InternalJDL.g:1074:2: iv_ruleBlobField= ruleBlobField EOF
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
    // InternalJDL.g:1080:1: ruleBlobField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Blob' ( (lv_validators_2_0= ruleBlobValidators ) )? ) ;
    public final EObject ruleBlobField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_validators_2_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:1086:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Blob' ( (lv_validators_2_0= ruleBlobValidators ) )? ) )
            // InternalJDL.g:1087:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Blob' ( (lv_validators_2_0= ruleBlobValidators ) )? )
            {
            // InternalJDL.g:1087:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Blob' ( (lv_validators_2_0= ruleBlobValidators ) )? )
            // InternalJDL.g:1088:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Blob' ( (lv_validators_2_0= ruleBlobValidators ) )?
            {
            // InternalJDL.g:1088:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalJDL.g:1089:4: (lv_name_0_0= RULE_ID )
            {
            // InternalJDL.g:1089:4: (lv_name_0_0= RULE_ID )
            // InternalJDL.g:1090:5: lv_name_0_0= RULE_ID
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

            otherlv_1=(Token)match(input,24,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getBlobFieldAccess().getBlobKeyword_1());
            		
            // InternalJDL.g:1110:3: ( (lv_validators_2_0= ruleBlobValidators ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==27) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalJDL.g:1111:4: (lv_validators_2_0= ruleBlobValidators )
                    {
                    // InternalJDL.g:1111:4: (lv_validators_2_0= ruleBlobValidators )
                    // InternalJDL.g:1112:5: lv_validators_2_0= ruleBlobValidators
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
    // InternalJDL.g:1133:1: entryRuleAnyBlobField returns [EObject current=null] : iv_ruleAnyBlobField= ruleAnyBlobField EOF ;
    public final EObject entryRuleAnyBlobField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnyBlobField = null;


        try {
            // InternalJDL.g:1133:53: (iv_ruleAnyBlobField= ruleAnyBlobField EOF )
            // InternalJDL.g:1134:2: iv_ruleAnyBlobField= ruleAnyBlobField EOF
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
    // InternalJDL.g:1140:1: ruleAnyBlobField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'AnyBlob' ( (lv_validators_2_0= ruleBlobValidators ) )? ) ;
    public final EObject ruleAnyBlobField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_validators_2_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:1146:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'AnyBlob' ( (lv_validators_2_0= ruleBlobValidators ) )? ) )
            // InternalJDL.g:1147:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'AnyBlob' ( (lv_validators_2_0= ruleBlobValidators ) )? )
            {
            // InternalJDL.g:1147:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'AnyBlob' ( (lv_validators_2_0= ruleBlobValidators ) )? )
            // InternalJDL.g:1148:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'AnyBlob' ( (lv_validators_2_0= ruleBlobValidators ) )?
            {
            // InternalJDL.g:1148:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalJDL.g:1149:4: (lv_name_0_0= RULE_ID )
            {
            // InternalJDL.g:1149:4: (lv_name_0_0= RULE_ID )
            // InternalJDL.g:1150:5: lv_name_0_0= RULE_ID
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

            otherlv_1=(Token)match(input,25,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getAnyBlobFieldAccess().getAnyBlobKeyword_1());
            		
            // InternalJDL.g:1170:3: ( (lv_validators_2_0= ruleBlobValidators ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==27) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalJDL.g:1171:4: (lv_validators_2_0= ruleBlobValidators )
                    {
                    // InternalJDL.g:1171:4: (lv_validators_2_0= ruleBlobValidators )
                    // InternalJDL.g:1172:5: lv_validators_2_0= ruleBlobValidators
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
    // InternalJDL.g:1193:1: entryRuleImageBlobField returns [EObject current=null] : iv_ruleImageBlobField= ruleImageBlobField EOF ;
    public final EObject entryRuleImageBlobField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImageBlobField = null;


        try {
            // InternalJDL.g:1193:55: (iv_ruleImageBlobField= ruleImageBlobField EOF )
            // InternalJDL.g:1194:2: iv_ruleImageBlobField= ruleImageBlobField EOF
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
    // InternalJDL.g:1200:1: ruleImageBlobField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'ImageBlob' ( (lv_validators_2_0= ruleBlobValidators ) )? ) ;
    public final EObject ruleImageBlobField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_validators_2_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:1206:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'ImageBlob' ( (lv_validators_2_0= ruleBlobValidators ) )? ) )
            // InternalJDL.g:1207:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'ImageBlob' ( (lv_validators_2_0= ruleBlobValidators ) )? )
            {
            // InternalJDL.g:1207:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'ImageBlob' ( (lv_validators_2_0= ruleBlobValidators ) )? )
            // InternalJDL.g:1208:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'ImageBlob' ( (lv_validators_2_0= ruleBlobValidators ) )?
            {
            // InternalJDL.g:1208:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalJDL.g:1209:4: (lv_name_0_0= RULE_ID )
            {
            // InternalJDL.g:1209:4: (lv_name_0_0= RULE_ID )
            // InternalJDL.g:1210:5: lv_name_0_0= RULE_ID
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

            otherlv_1=(Token)match(input,26,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getImageBlobFieldAccess().getImageBlobKeyword_1());
            		
            // InternalJDL.g:1230:3: ( (lv_validators_2_0= ruleBlobValidators ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==27) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalJDL.g:1231:4: (lv_validators_2_0= ruleBlobValidators )
                    {
                    // InternalJDL.g:1231:4: (lv_validators_2_0= ruleBlobValidators )
                    // InternalJDL.g:1232:5: lv_validators_2_0= ruleBlobValidators
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
    // InternalJDL.g:1253:1: entryRuleRequiredValidator returns [EObject current=null] : iv_ruleRequiredValidator= ruleRequiredValidator EOF ;
    public final EObject entryRuleRequiredValidator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequiredValidator = null;


        try {
            // InternalJDL.g:1253:58: (iv_ruleRequiredValidator= ruleRequiredValidator EOF )
            // InternalJDL.g:1254:2: iv_ruleRequiredValidator= ruleRequiredValidator EOF
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
    // InternalJDL.g:1260:1: ruleRequiredValidator returns [EObject current=null] : ( (lv_required_0_0= 'required' ) ) ;
    public final EObject ruleRequiredValidator() throws RecognitionException {
        EObject current = null;

        Token lv_required_0_0=null;


        	enterRule();

        try {
            // InternalJDL.g:1266:2: ( ( (lv_required_0_0= 'required' ) ) )
            // InternalJDL.g:1267:2: ( (lv_required_0_0= 'required' ) )
            {
            // InternalJDL.g:1267:2: ( (lv_required_0_0= 'required' ) )
            // InternalJDL.g:1268:3: (lv_required_0_0= 'required' )
            {
            // InternalJDL.g:1268:3: (lv_required_0_0= 'required' )
            // InternalJDL.g:1269:4: lv_required_0_0= 'required'
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
    // InternalJDL.g:1284:1: entryRuleMinLengthValidator returns [EObject current=null] : iv_ruleMinLengthValidator= ruleMinLengthValidator EOF ;
    public final EObject entryRuleMinLengthValidator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMinLengthValidator = null;


        try {
            // InternalJDL.g:1284:59: (iv_ruleMinLengthValidator= ruleMinLengthValidator EOF )
            // InternalJDL.g:1285:2: iv_ruleMinLengthValidator= ruleMinLengthValidator EOF
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
    // InternalJDL.g:1291:1: ruleMinLengthValidator returns [EObject current=null] : (otherlv_0= 'minlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final EObject ruleMinLengthValidator() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalJDL.g:1297:2: ( (otherlv_0= 'minlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // InternalJDL.g:1298:2: (otherlv_0= 'minlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // InternalJDL.g:1298:2: (otherlv_0= 'minlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            // InternalJDL.g:1299:3: otherlv_0= 'minlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,28,FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getMinLengthValidatorAccess().getMinlengthKeyword_0());
            		
            otherlv_1=(Token)match(input,29,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getMinLengthValidatorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalJDL.g:1307:3: ( (lv_value_2_0= RULE_INT ) )
            // InternalJDL.g:1308:4: (lv_value_2_0= RULE_INT )
            {
            // InternalJDL.g:1308:4: (lv_value_2_0= RULE_INT )
            // InternalJDL.g:1309:5: lv_value_2_0= RULE_INT
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
    // InternalJDL.g:1333:1: entryRuleMaxLengthValidator returns [EObject current=null] : iv_ruleMaxLengthValidator= ruleMaxLengthValidator EOF ;
    public final EObject entryRuleMaxLengthValidator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMaxLengthValidator = null;


        try {
            // InternalJDL.g:1333:59: (iv_ruleMaxLengthValidator= ruleMaxLengthValidator EOF )
            // InternalJDL.g:1334:2: iv_ruleMaxLengthValidator= ruleMaxLengthValidator EOF
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
    // InternalJDL.g:1340:1: ruleMaxLengthValidator returns [EObject current=null] : (otherlv_0= 'maxlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final EObject ruleMaxLengthValidator() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalJDL.g:1346:2: ( (otherlv_0= 'maxlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // InternalJDL.g:1347:2: (otherlv_0= 'maxlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // InternalJDL.g:1347:2: (otherlv_0= 'maxlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            // InternalJDL.g:1348:3: otherlv_0= 'maxlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,31,FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getMaxLengthValidatorAccess().getMaxlengthKeyword_0());
            		
            otherlv_1=(Token)match(input,29,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getMaxLengthValidatorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalJDL.g:1356:3: ( (lv_value_2_0= RULE_INT ) )
            // InternalJDL.g:1357:4: (lv_value_2_0= RULE_INT )
            {
            // InternalJDL.g:1357:4: (lv_value_2_0= RULE_INT )
            // InternalJDL.g:1358:5: lv_value_2_0= RULE_INT
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
    // InternalJDL.g:1382:1: entryRulePatternValidator returns [EObject current=null] : iv_rulePatternValidator= rulePatternValidator EOF ;
    public final EObject entryRulePatternValidator() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePatternValidator = null;


        try {
            // InternalJDL.g:1382:57: (iv_rulePatternValidator= rulePatternValidator EOF )
            // InternalJDL.g:1383:2: iv_rulePatternValidator= rulePatternValidator EOF
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
    // InternalJDL.g:1389:1: rulePatternValidator returns [EObject current=null] : (otherlv_0= 'pattern' otherlv_1= '(' ( (lv_value_2_0= RULE_STRING ) ) otherlv_3= ')' ) ;
    public final EObject rulePatternValidator() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalJDL.g:1395:2: ( (otherlv_0= 'pattern' otherlv_1= '(' ( (lv_value_2_0= RULE_STRING ) ) otherlv_3= ')' ) )
            // InternalJDL.g:1396:2: (otherlv_0= 'pattern' otherlv_1= '(' ( (lv_value_2_0= RULE_STRING ) ) otherlv_3= ')' )
            {
            // InternalJDL.g:1396:2: (otherlv_0= 'pattern' otherlv_1= '(' ( (lv_value_2_0= RULE_STRING ) ) otherlv_3= ')' )
            // InternalJDL.g:1397:3: otherlv_0= 'pattern' otherlv_1= '(' ( (lv_value_2_0= RULE_STRING ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getPatternValidatorAccess().getPatternKeyword_0());
            		
            otherlv_1=(Token)match(input,29,FOLLOW_23); 

            			newLeafNode(otherlv_1, grammarAccess.getPatternValidatorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalJDL.g:1405:3: ( (lv_value_2_0= RULE_STRING ) )
            // InternalJDL.g:1406:4: (lv_value_2_0= RULE_STRING )
            {
            // InternalJDL.g:1406:4: (lv_value_2_0= RULE_STRING )
            // InternalJDL.g:1407:5: lv_value_2_0= RULE_STRING
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
    // InternalJDL.g:1431:1: entryRuleMinValidator returns [EObject current=null] : iv_ruleMinValidator= ruleMinValidator EOF ;
    public final EObject entryRuleMinValidator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMinValidator = null;


        try {
            // InternalJDL.g:1431:53: (iv_ruleMinValidator= ruleMinValidator EOF )
            // InternalJDL.g:1432:2: iv_ruleMinValidator= ruleMinValidator EOF
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
    // InternalJDL.g:1438:1: ruleMinValidator returns [EObject current=null] : (otherlv_0= 'min' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final EObject ruleMinValidator() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalJDL.g:1444:2: ( (otherlv_0= 'min' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // InternalJDL.g:1445:2: (otherlv_0= 'min' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // InternalJDL.g:1445:2: (otherlv_0= 'min' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            // InternalJDL.g:1446:3: otherlv_0= 'min' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getMinValidatorAccess().getMinKeyword_0());
            		
            otherlv_1=(Token)match(input,29,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getMinValidatorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalJDL.g:1454:3: ( (lv_value_2_0= RULE_INT ) )
            // InternalJDL.g:1455:4: (lv_value_2_0= RULE_INT )
            {
            // InternalJDL.g:1455:4: (lv_value_2_0= RULE_INT )
            // InternalJDL.g:1456:5: lv_value_2_0= RULE_INT
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
    // InternalJDL.g:1480:1: entryRuleMaxValidator returns [EObject current=null] : iv_ruleMaxValidator= ruleMaxValidator EOF ;
    public final EObject entryRuleMaxValidator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMaxValidator = null;


        try {
            // InternalJDL.g:1480:53: (iv_ruleMaxValidator= ruleMaxValidator EOF )
            // InternalJDL.g:1481:2: iv_ruleMaxValidator= ruleMaxValidator EOF
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
    // InternalJDL.g:1487:1: ruleMaxValidator returns [EObject current=null] : (otherlv_0= 'max' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final EObject ruleMaxValidator() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalJDL.g:1493:2: ( (otherlv_0= 'max' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // InternalJDL.g:1494:2: (otherlv_0= 'max' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // InternalJDL.g:1494:2: (otherlv_0= 'max' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            // InternalJDL.g:1495:3: otherlv_0= 'max' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,34,FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getMaxValidatorAccess().getMaxKeyword_0());
            		
            otherlv_1=(Token)match(input,29,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getMaxValidatorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalJDL.g:1503:3: ( (lv_value_2_0= RULE_INT ) )
            // InternalJDL.g:1504:4: (lv_value_2_0= RULE_INT )
            {
            // InternalJDL.g:1504:4: (lv_value_2_0= RULE_INT )
            // InternalJDL.g:1505:5: lv_value_2_0= RULE_INT
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
    // InternalJDL.g:1529:1: entryRuleMinBytesValidator returns [EObject current=null] : iv_ruleMinBytesValidator= ruleMinBytesValidator EOF ;
    public final EObject entryRuleMinBytesValidator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMinBytesValidator = null;


        try {
            // InternalJDL.g:1529:58: (iv_ruleMinBytesValidator= ruleMinBytesValidator EOF )
            // InternalJDL.g:1530:2: iv_ruleMinBytesValidator= ruleMinBytesValidator EOF
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
    // InternalJDL.g:1536:1: ruleMinBytesValidator returns [EObject current=null] : (otherlv_0= 'minbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final EObject ruleMinBytesValidator() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalJDL.g:1542:2: ( (otherlv_0= 'minbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // InternalJDL.g:1543:2: (otherlv_0= 'minbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // InternalJDL.g:1543:2: (otherlv_0= 'minbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            // InternalJDL.g:1544:3: otherlv_0= 'minbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,35,FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getMinBytesValidatorAccess().getMinbytesKeyword_0());
            		
            otherlv_1=(Token)match(input,29,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getMinBytesValidatorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalJDL.g:1552:3: ( (lv_value_2_0= RULE_INT ) )
            // InternalJDL.g:1553:4: (lv_value_2_0= RULE_INT )
            {
            // InternalJDL.g:1553:4: (lv_value_2_0= RULE_INT )
            // InternalJDL.g:1554:5: lv_value_2_0= RULE_INT
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
    // InternalJDL.g:1578:1: entryRuleMaxBytesValidator returns [EObject current=null] : iv_ruleMaxBytesValidator= ruleMaxBytesValidator EOF ;
    public final EObject entryRuleMaxBytesValidator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMaxBytesValidator = null;


        try {
            // InternalJDL.g:1578:58: (iv_ruleMaxBytesValidator= ruleMaxBytesValidator EOF )
            // InternalJDL.g:1579:2: iv_ruleMaxBytesValidator= ruleMaxBytesValidator EOF
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
    // InternalJDL.g:1585:1: ruleMaxBytesValidator returns [EObject current=null] : (otherlv_0= 'maxbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final EObject ruleMaxBytesValidator() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalJDL.g:1591:2: ( (otherlv_0= 'maxbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // InternalJDL.g:1592:2: (otherlv_0= 'maxbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // InternalJDL.g:1592:2: (otherlv_0= 'maxbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            // InternalJDL.g:1593:3: otherlv_0= 'maxbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,36,FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getMaxBytesValidatorAccess().getMaxbytesKeyword_0());
            		
            otherlv_1=(Token)match(input,29,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getMaxBytesValidatorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalJDL.g:1601:3: ( (lv_value_2_0= RULE_INT ) )
            // InternalJDL.g:1602:4: (lv_value_2_0= RULE_INT )
            {
            // InternalJDL.g:1602:4: (lv_value_2_0= RULE_INT )
            // InternalJDL.g:1603:5: lv_value_2_0= RULE_INT
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
    // InternalJDL.g:1627:1: entryRuleStringValidators returns [EObject current=null] : iv_ruleStringValidators= ruleStringValidators EOF ;
    public final EObject entryRuleStringValidators() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringValidators = null;


        try {
            // InternalJDL.g:1627:57: (iv_ruleStringValidators= ruleStringValidators EOF )
            // InternalJDL.g:1628:2: iv_ruleStringValidators= ruleStringValidators EOF
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
    // InternalJDL.g:1634:1: ruleStringValidators returns [EObject current=null] : ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minLength_1_0= ruleMinLengthValidator ) )? ( (lv_maxlength_2_0= ruleMaxLengthValidator ) )? ( (lv_pattern_3_0= rulePatternValidator ) )? ) ;
    public final EObject ruleStringValidators() throws RecognitionException {
        EObject current = null;

        EObject lv_required_0_0 = null;

        EObject lv_minLength_1_0 = null;

        EObject lv_maxlength_2_0 = null;

        EObject lv_pattern_3_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:1640:2: ( ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minLength_1_0= ruleMinLengthValidator ) )? ( (lv_maxlength_2_0= ruleMaxLengthValidator ) )? ( (lv_pattern_3_0= rulePatternValidator ) )? ) )
            // InternalJDL.g:1641:2: ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minLength_1_0= ruleMinLengthValidator ) )? ( (lv_maxlength_2_0= ruleMaxLengthValidator ) )? ( (lv_pattern_3_0= rulePatternValidator ) )? )
            {
            // InternalJDL.g:1641:2: ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minLength_1_0= ruleMinLengthValidator ) )? ( (lv_maxlength_2_0= ruleMaxLengthValidator ) )? ( (lv_pattern_3_0= rulePatternValidator ) )? )
            // InternalJDL.g:1642:3: ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minLength_1_0= ruleMinLengthValidator ) )? ( (lv_maxlength_2_0= ruleMaxLengthValidator ) )? ( (lv_pattern_3_0= rulePatternValidator ) )?
            {
            // InternalJDL.g:1642:3: ( (lv_required_0_0= ruleRequiredValidator ) )
            // InternalJDL.g:1643:4: (lv_required_0_0= ruleRequiredValidator )
            {
            // InternalJDL.g:1643:4: (lv_required_0_0= ruleRequiredValidator )
            // InternalJDL.g:1644:5: lv_required_0_0= ruleRequiredValidator
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

            // InternalJDL.g:1661:3: ( (lv_minLength_1_0= ruleMinLengthValidator ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==28) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalJDL.g:1662:4: (lv_minLength_1_0= ruleMinLengthValidator )
                    {
                    // InternalJDL.g:1662:4: (lv_minLength_1_0= ruleMinLengthValidator )
                    // InternalJDL.g:1663:5: lv_minLength_1_0= ruleMinLengthValidator
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

            // InternalJDL.g:1680:3: ( (lv_maxlength_2_0= ruleMaxLengthValidator ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==31) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalJDL.g:1681:4: (lv_maxlength_2_0= ruleMaxLengthValidator )
                    {
                    // InternalJDL.g:1681:4: (lv_maxlength_2_0= ruleMaxLengthValidator )
                    // InternalJDL.g:1682:5: lv_maxlength_2_0= ruleMaxLengthValidator
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

            // InternalJDL.g:1699:3: ( (lv_pattern_3_0= rulePatternValidator ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==32) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalJDL.g:1700:4: (lv_pattern_3_0= rulePatternValidator )
                    {
                    // InternalJDL.g:1700:4: (lv_pattern_3_0= rulePatternValidator )
                    // InternalJDL.g:1701:5: lv_pattern_3_0= rulePatternValidator
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
    // InternalJDL.g:1722:1: entryRuleNumericValidators returns [EObject current=null] : iv_ruleNumericValidators= ruleNumericValidators EOF ;
    public final EObject entryRuleNumericValidators() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericValidators = null;


        try {
            // InternalJDL.g:1722:58: (iv_ruleNumericValidators= ruleNumericValidators EOF )
            // InternalJDL.g:1723:2: iv_ruleNumericValidators= ruleNumericValidators EOF
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
    // InternalJDL.g:1729:1: ruleNumericValidators returns [EObject current=null] : ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minlength_1_0= ruleMinValidator ) )? ( (lv_maxlength_2_0= ruleMaxValidator ) )? ) ;
    public final EObject ruleNumericValidators() throws RecognitionException {
        EObject current = null;

        EObject lv_required_0_0 = null;

        EObject lv_minlength_1_0 = null;

        EObject lv_maxlength_2_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:1735:2: ( ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minlength_1_0= ruleMinValidator ) )? ( (lv_maxlength_2_0= ruleMaxValidator ) )? ) )
            // InternalJDL.g:1736:2: ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minlength_1_0= ruleMinValidator ) )? ( (lv_maxlength_2_0= ruleMaxValidator ) )? )
            {
            // InternalJDL.g:1736:2: ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minlength_1_0= ruleMinValidator ) )? ( (lv_maxlength_2_0= ruleMaxValidator ) )? )
            // InternalJDL.g:1737:3: ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minlength_1_0= ruleMinValidator ) )? ( (lv_maxlength_2_0= ruleMaxValidator ) )?
            {
            // InternalJDL.g:1737:3: ( (lv_required_0_0= ruleRequiredValidator ) )
            // InternalJDL.g:1738:4: (lv_required_0_0= ruleRequiredValidator )
            {
            // InternalJDL.g:1738:4: (lv_required_0_0= ruleRequiredValidator )
            // InternalJDL.g:1739:5: lv_required_0_0= ruleRequiredValidator
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

            // InternalJDL.g:1756:3: ( (lv_minlength_1_0= ruleMinValidator ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==33) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalJDL.g:1757:4: (lv_minlength_1_0= ruleMinValidator )
                    {
                    // InternalJDL.g:1757:4: (lv_minlength_1_0= ruleMinValidator )
                    // InternalJDL.g:1758:5: lv_minlength_1_0= ruleMinValidator
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

            // InternalJDL.g:1775:3: ( (lv_maxlength_2_0= ruleMaxValidator ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==34) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalJDL.g:1776:4: (lv_maxlength_2_0= ruleMaxValidator )
                    {
                    // InternalJDL.g:1776:4: (lv_maxlength_2_0= ruleMaxValidator )
                    // InternalJDL.g:1777:5: lv_maxlength_2_0= ruleMaxValidator
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
    // InternalJDL.g:1798:1: entryRuleBlobValidators returns [EObject current=null] : iv_ruleBlobValidators= ruleBlobValidators EOF ;
    public final EObject entryRuleBlobValidators() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlobValidators = null;


        try {
            // InternalJDL.g:1798:55: (iv_ruleBlobValidators= ruleBlobValidators EOF )
            // InternalJDL.g:1799:2: iv_ruleBlobValidators= ruleBlobValidators EOF
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
    // InternalJDL.g:1805:1: ruleBlobValidators returns [EObject current=null] : ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minbytes_1_0= ruleMinBytesValidator ) )? ( (lv_maxbytes_2_0= ruleMaxBytesValidator ) )? ) ;
    public final EObject ruleBlobValidators() throws RecognitionException {
        EObject current = null;

        EObject lv_required_0_0 = null;

        EObject lv_minbytes_1_0 = null;

        EObject lv_maxbytes_2_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:1811:2: ( ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minbytes_1_0= ruleMinBytesValidator ) )? ( (lv_maxbytes_2_0= ruleMaxBytesValidator ) )? ) )
            // InternalJDL.g:1812:2: ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minbytes_1_0= ruleMinBytesValidator ) )? ( (lv_maxbytes_2_0= ruleMaxBytesValidator ) )? )
            {
            // InternalJDL.g:1812:2: ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minbytes_1_0= ruleMinBytesValidator ) )? ( (lv_maxbytes_2_0= ruleMaxBytesValidator ) )? )
            // InternalJDL.g:1813:3: ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minbytes_1_0= ruleMinBytesValidator ) )? ( (lv_maxbytes_2_0= ruleMaxBytesValidator ) )?
            {
            // InternalJDL.g:1813:3: ( (lv_required_0_0= ruleRequiredValidator ) )
            // InternalJDL.g:1814:4: (lv_required_0_0= ruleRequiredValidator )
            {
            // InternalJDL.g:1814:4: (lv_required_0_0= ruleRequiredValidator )
            // InternalJDL.g:1815:5: lv_required_0_0= ruleRequiredValidator
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

            // InternalJDL.g:1832:3: ( (lv_minbytes_1_0= ruleMinBytesValidator ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==35) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalJDL.g:1833:4: (lv_minbytes_1_0= ruleMinBytesValidator )
                    {
                    // InternalJDL.g:1833:4: (lv_minbytes_1_0= ruleMinBytesValidator )
                    // InternalJDL.g:1834:5: lv_minbytes_1_0= ruleMinBytesValidator
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

            // InternalJDL.g:1851:3: ( (lv_maxbytes_2_0= ruleMaxBytesValidator ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==36) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalJDL.g:1852:4: (lv_maxbytes_2_0= ruleMaxBytesValidator )
                    {
                    // InternalJDL.g:1852:4: (lv_maxbytes_2_0= ruleMaxBytesValidator )
                    // InternalJDL.g:1853:5: lv_maxbytes_2_0= ruleMaxBytesValidator
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
    // InternalJDL.g:1874:1: entryRuleRelationships returns [EObject current=null] : iv_ruleRelationships= ruleRelationships EOF ;
    public final EObject entryRuleRelationships() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationships = null;


        try {
            // InternalJDL.g:1874:54: (iv_ruleRelationships= ruleRelationships EOF )
            // InternalJDL.g:1875:2: iv_ruleRelationships= ruleRelationships EOF
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
    // InternalJDL.g:1881:1: ruleRelationships returns [EObject current=null] : (otherlv_0= 'relationship' ( (lv_cardinality_1_0= ruleCardinality ) ) otherlv_2= '{' ( (lv_relationships_3_0= ruleRelationship ) )* otherlv_4= '}' ) ;
    public final EObject ruleRelationships() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Enumerator lv_cardinality_1_0 = null;

        EObject lv_relationships_3_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:1887:2: ( (otherlv_0= 'relationship' ( (lv_cardinality_1_0= ruleCardinality ) ) otherlv_2= '{' ( (lv_relationships_3_0= ruleRelationship ) )* otherlv_4= '}' ) )
            // InternalJDL.g:1888:2: (otherlv_0= 'relationship' ( (lv_cardinality_1_0= ruleCardinality ) ) otherlv_2= '{' ( (lv_relationships_3_0= ruleRelationship ) )* otherlv_4= '}' )
            {
            // InternalJDL.g:1888:2: (otherlv_0= 'relationship' ( (lv_cardinality_1_0= ruleCardinality ) ) otherlv_2= '{' ( (lv_relationships_3_0= ruleRelationship ) )* otherlv_4= '}' )
            // InternalJDL.g:1889:3: otherlv_0= 'relationship' ( (lv_cardinality_1_0= ruleCardinality ) ) otherlv_2= '{' ( (lv_relationships_3_0= ruleRelationship ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,37,FOLLOW_31); 

            			newLeafNode(otherlv_0, grammarAccess.getRelationshipsAccess().getRelationshipKeyword_0());
            		
            // InternalJDL.g:1893:3: ( (lv_cardinality_1_0= ruleCardinality ) )
            // InternalJDL.g:1894:4: (lv_cardinality_1_0= ruleCardinality )
            {
            // InternalJDL.g:1894:4: (lv_cardinality_1_0= ruleCardinality )
            // InternalJDL.g:1895:5: lv_cardinality_1_0= ruleCardinality
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
            		
            // InternalJDL.g:1916:3: ( (lv_relationships_3_0= ruleRelationship ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==11) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalJDL.g:1917:4: (lv_relationships_3_0= ruleRelationship )
            	    {
            	    // InternalJDL.g:1917:4: (lv_relationships_3_0= ruleRelationship )
            	    // InternalJDL.g:1918:5: lv_relationships_3_0= ruleRelationship
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
            	    break loop28;
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
    // InternalJDL.g:1943:1: entryRuleRelationship returns [EObject current=null] : iv_ruleRelationship= ruleRelationship EOF ;
    public final EObject entryRuleRelationship() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationship = null;


        try {
            // InternalJDL.g:1943:53: (iv_ruleRelationship= ruleRelationship EOF )
            // InternalJDL.g:1944:2: iv_ruleRelationship= ruleRelationship EOF
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
    // InternalJDL.g:1950:1: ruleRelationship returns [EObject current=null] : ( ( (lv_fromEntity_0_0= ruleEntity ) ) ( (lv_fromName_1_0= ruleRelationshipName ) )? otherlv_2= 'to' ( (lv_toEntity_3_0= ruleEntity ) ) ( (lv_toName_4_0= ruleRelationshipName ) )? ) ;
    public final EObject ruleRelationship() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_fromEntity_0_0 = null;

        EObject lv_fromName_1_0 = null;

        EObject lv_toEntity_3_0 = null;

        EObject lv_toName_4_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:1956:2: ( ( ( (lv_fromEntity_0_0= ruleEntity ) ) ( (lv_fromName_1_0= ruleRelationshipName ) )? otherlv_2= 'to' ( (lv_toEntity_3_0= ruleEntity ) ) ( (lv_toName_4_0= ruleRelationshipName ) )? ) )
            // InternalJDL.g:1957:2: ( ( (lv_fromEntity_0_0= ruleEntity ) ) ( (lv_fromName_1_0= ruleRelationshipName ) )? otherlv_2= 'to' ( (lv_toEntity_3_0= ruleEntity ) ) ( (lv_toName_4_0= ruleRelationshipName ) )? )
            {
            // InternalJDL.g:1957:2: ( ( (lv_fromEntity_0_0= ruleEntity ) ) ( (lv_fromName_1_0= ruleRelationshipName ) )? otherlv_2= 'to' ( (lv_toEntity_3_0= ruleEntity ) ) ( (lv_toName_4_0= ruleRelationshipName ) )? )
            // InternalJDL.g:1958:3: ( (lv_fromEntity_0_0= ruleEntity ) ) ( (lv_fromName_1_0= ruleRelationshipName ) )? otherlv_2= 'to' ( (lv_toEntity_3_0= ruleEntity ) ) ( (lv_toName_4_0= ruleRelationshipName ) )?
            {
            // InternalJDL.g:1958:3: ( (lv_fromEntity_0_0= ruleEntity ) )
            // InternalJDL.g:1959:4: (lv_fromEntity_0_0= ruleEntity )
            {
            // InternalJDL.g:1959:4: (lv_fromEntity_0_0= ruleEntity )
            // InternalJDL.g:1960:5: lv_fromEntity_0_0= ruleEntity
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

            // InternalJDL.g:1977:3: ( (lv_fromName_1_0= ruleRelationshipName ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==12) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalJDL.g:1978:4: (lv_fromName_1_0= ruleRelationshipName )
                    {
                    // InternalJDL.g:1978:4: (lv_fromName_1_0= ruleRelationshipName )
                    // InternalJDL.g:1979:5: lv_fromName_1_0= ruleRelationshipName
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
            		
            // InternalJDL.g:2000:3: ( (lv_toEntity_3_0= ruleEntity ) )
            // InternalJDL.g:2001:4: (lv_toEntity_3_0= ruleEntity )
            {
            // InternalJDL.g:2001:4: (lv_toEntity_3_0= ruleEntity )
            // InternalJDL.g:2002:5: lv_toEntity_3_0= ruleEntity
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

            // InternalJDL.g:2019:3: ( (lv_toName_4_0= ruleRelationshipName ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==12) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalJDL.g:2020:4: (lv_toName_4_0= ruleRelationshipName )
                    {
                    // InternalJDL.g:2020:4: (lv_toName_4_0= ruleRelationshipName )
                    // InternalJDL.g:2021:5: lv_toName_4_0= ruleRelationshipName
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
    // InternalJDL.g:2042:1: entryRuleRelationshipName returns [EObject current=null] : iv_ruleRelationshipName= ruleRelationshipName EOF ;
    public final EObject entryRuleRelationshipName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationshipName = null;


        try {
            // InternalJDL.g:2042:57: (iv_ruleRelationshipName= ruleRelationshipName EOF )
            // InternalJDL.g:2043:2: iv_ruleRelationshipName= ruleRelationshipName EOF
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
    // InternalJDL.g:2049:1: ruleRelationshipName returns [EObject current=null] : (otherlv_0= '{' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '}' ) ;
    public final EObject ruleRelationshipName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalJDL.g:2055:2: ( (otherlv_0= '{' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '}' ) )
            // InternalJDL.g:2056:2: (otherlv_0= '{' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '}' )
            {
            // InternalJDL.g:2056:2: (otherlv_0= '{' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '}' )
            // InternalJDL.g:2057:3: otherlv_0= '{' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '}'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getRelationshipNameAccess().getLeftCurlyBracketKeyword_0());
            		
            // InternalJDL.g:2061:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalJDL.g:2062:4: (lv_name_1_0= RULE_ID )
            {
            // InternalJDL.g:2062:4: (lv_name_1_0= RULE_ID )
            // InternalJDL.g:2063:5: lv_name_1_0= RULE_ID
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


    // $ANTLR start "entryRuleEnumType"
    // InternalJDL.g:2087:1: entryRuleEnumType returns [EObject current=null] : iv_ruleEnumType= ruleEnumType EOF ;
    public final EObject entryRuleEnumType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumType = null;


        try {
            // InternalJDL.g:2087:49: (iv_ruleEnumType= ruleEnumType EOF )
            // InternalJDL.g:2088:2: iv_ruleEnumType= ruleEnumType EOF
            {
             newCompositeNode(grammarAccess.getEnumTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumType=ruleEnumType();

            state._fsp--;

             current =iv_ruleEnumType; 
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
    // $ANTLR end "entryRuleEnumType"


    // $ANTLR start "ruleEnumType"
    // InternalJDL.g:2094:1: ruleEnumType returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_values_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_values_5_0= RULE_ID ) ) )* otherlv_6= '}' ) ;
    public final EObject ruleEnumType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_values_3_0=null;
        Token otherlv_4=null;
        Token lv_values_5_0=null;
        Token otherlv_6=null;


        	enterRule();

        try {
            // InternalJDL.g:2100:2: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_values_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_values_5_0= RULE_ID ) ) )* otherlv_6= '}' ) )
            // InternalJDL.g:2101:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_values_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_values_5_0= RULE_ID ) ) )* otherlv_6= '}' )
            {
            // InternalJDL.g:2101:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_values_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_values_5_0= RULE_ID ) ) )* otherlv_6= '}' )
            // InternalJDL.g:2102:3: otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_values_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_values_5_0= RULE_ID ) ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,39,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getEnumTypeAccess().getEnumKeyword_0());
            		
            // InternalJDL.g:2106:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalJDL.g:2107:4: (lv_name_1_0= RULE_ID )
            {
            // InternalJDL.g:2107:4: (lv_name_1_0= RULE_ID )
            // InternalJDL.g:2108:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getEnumTypeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEnumTypeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getEnumTypeAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalJDL.g:2128:3: ( (lv_values_3_0= RULE_ID ) )
            // InternalJDL.g:2129:4: (lv_values_3_0= RULE_ID )
            {
            // InternalJDL.g:2129:4: (lv_values_3_0= RULE_ID )
            // InternalJDL.g:2130:5: lv_values_3_0= RULE_ID
            {
            lv_values_3_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(lv_values_3_0, grammarAccess.getEnumTypeAccess().getValuesIDTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEnumTypeRule());
            					}
            					addWithLastConsumed(
            						current,
            						"values",
            						lv_values_3_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalJDL.g:2146:3: (otherlv_4= ',' ( (lv_values_5_0= RULE_ID ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==13) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalJDL.g:2147:4: otherlv_4= ',' ( (lv_values_5_0= RULE_ID ) )
            	    {
            	    otherlv_4=(Token)match(input,13,FOLLOW_4); 

            	    				newLeafNode(otherlv_4, grammarAccess.getEnumTypeAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalJDL.g:2151:4: ( (lv_values_5_0= RULE_ID ) )
            	    // InternalJDL.g:2152:5: (lv_values_5_0= RULE_ID )
            	    {
            	    // InternalJDL.g:2152:5: (lv_values_5_0= RULE_ID )
            	    // InternalJDL.g:2153:6: lv_values_5_0= RULE_ID
            	    {
            	    lv_values_5_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            	    						newLeafNode(lv_values_5_0, grammarAccess.getEnumTypeAccess().getValuesIDTerminalRuleCall_4_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getEnumTypeRule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"values",
            	    							lv_values_5_0,
            	    							"org.eclipse.xtext.common.Terminals.ID");
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            otherlv_6=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getEnumTypeAccess().getRightCurlyBracketKeyword_5());
            		

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
    // $ANTLR end "ruleEnumType"


    // $ANTLR start "entryRuleGenerationSetting"
    // InternalJDL.g:2178:1: entryRuleGenerationSetting returns [EObject current=null] : iv_ruleGenerationSetting= ruleGenerationSetting EOF ;
    public final EObject entryRuleGenerationSetting() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGenerationSetting = null;


        try {
            // InternalJDL.g:2178:58: (iv_ruleGenerationSetting= ruleGenerationSetting EOF )
            // InternalJDL.g:2179:2: iv_ruleGenerationSetting= ruleGenerationSetting EOF
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
    // InternalJDL.g:2185:1: ruleGenerationSetting returns [EObject current=null] : (this_ServiceGenerationSetting_0= ruleServiceGenerationSetting | this_DTOGenerationSetting_1= ruleDTOGenerationSetting | this_PaginateGenerationSetting_2= rulePaginateGenerationSetting | this_AngularSuffixGenerationSetting_3= ruleAngularSuffixGenerationSetting ) ;
    public final EObject ruleGenerationSetting() throws RecognitionException {
        EObject current = null;

        EObject this_ServiceGenerationSetting_0 = null;

        EObject this_DTOGenerationSetting_1 = null;

        EObject this_PaginateGenerationSetting_2 = null;

        EObject this_AngularSuffixGenerationSetting_3 = null;



        	enterRule();

        try {
            // InternalJDL.g:2191:2: ( (this_ServiceGenerationSetting_0= ruleServiceGenerationSetting | this_DTOGenerationSetting_1= ruleDTOGenerationSetting | this_PaginateGenerationSetting_2= rulePaginateGenerationSetting | this_AngularSuffixGenerationSetting_3= ruleAngularSuffixGenerationSetting ) )
            // InternalJDL.g:2192:2: (this_ServiceGenerationSetting_0= ruleServiceGenerationSetting | this_DTOGenerationSetting_1= ruleDTOGenerationSetting | this_PaginateGenerationSetting_2= rulePaginateGenerationSetting | this_AngularSuffixGenerationSetting_3= ruleAngularSuffixGenerationSetting )
            {
            // InternalJDL.g:2192:2: (this_ServiceGenerationSetting_0= ruleServiceGenerationSetting | this_DTOGenerationSetting_1= ruleDTOGenerationSetting | this_PaginateGenerationSetting_2= rulePaginateGenerationSetting | this_AngularSuffixGenerationSetting_3= ruleAngularSuffixGenerationSetting )
            int alt32=4;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt32=1;
                }
                break;
            case 42:
                {
                alt32=2;
                }
                break;
            case 43:
                {
                alt32=3;
                }
                break;
            case 44:
                {
                alt32=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // InternalJDL.g:2193:3: this_ServiceGenerationSetting_0= ruleServiceGenerationSetting
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
                    // InternalJDL.g:2202:3: this_DTOGenerationSetting_1= ruleDTOGenerationSetting
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
                    // InternalJDL.g:2211:3: this_PaginateGenerationSetting_2= rulePaginateGenerationSetting
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
                    // InternalJDL.g:2220:3: this_AngularSuffixGenerationSetting_3= ruleAngularSuffixGenerationSetting
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
    // InternalJDL.g:2232:1: entryRuleServiceGenerationSetting returns [EObject current=null] : iv_ruleServiceGenerationSetting= ruleServiceGenerationSetting EOF ;
    public final EObject entryRuleServiceGenerationSetting() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceGenerationSetting = null;


        try {
            // InternalJDL.g:2232:65: (iv_ruleServiceGenerationSetting= ruleServiceGenerationSetting EOF )
            // InternalJDL.g:2233:2: iv_ruleServiceGenerationSetting= ruleServiceGenerationSetting EOF
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
    // InternalJDL.g:2239:1: ruleServiceGenerationSetting returns [EObject current=null] : (otherlv_0= 'service' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_serviceType_5_0= ruleServiceType ) ) ) ;
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
            // InternalJDL.g:2245:2: ( (otherlv_0= 'service' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_serviceType_5_0= ruleServiceType ) ) ) )
            // InternalJDL.g:2246:2: (otherlv_0= 'service' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_serviceType_5_0= ruleServiceType ) ) )
            {
            // InternalJDL.g:2246:2: (otherlv_0= 'service' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_serviceType_5_0= ruleServiceType ) ) )
            // InternalJDL.g:2247:3: otherlv_0= 'service' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_serviceType_5_0= ruleServiceType ) )
            {
            otherlv_0=(Token)match(input,40,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getServiceGenerationSettingAccess().getServiceKeyword_0());
            		
            // InternalJDL.g:2251:3: ( (lv_entities_1_0= RULE_ID ) )
            // InternalJDL.g:2252:4: (lv_entities_1_0= RULE_ID )
            {
            // InternalJDL.g:2252:4: (lv_entities_1_0= RULE_ID )
            // InternalJDL.g:2253:5: lv_entities_1_0= RULE_ID
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

            // InternalJDL.g:2269:3: (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==13) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalJDL.g:2270:4: otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) )
            	    {
            	    otherlv_2=(Token)match(input,13,FOLLOW_4); 

            	    				newLeafNode(otherlv_2, grammarAccess.getServiceGenerationSettingAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalJDL.g:2274:4: ( (lv_entities_3_0= RULE_ID ) )
            	    // InternalJDL.g:2275:5: (lv_entities_3_0= RULE_ID )
            	    {
            	    // InternalJDL.g:2275:5: (lv_entities_3_0= RULE_ID )
            	    // InternalJDL.g:2276:6: lv_entities_3_0= RULE_ID
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
            	    break loop33;
                }
            } while (true);

            otherlv_4=(Token)match(input,41,FOLLOW_39); 

            			newLeafNode(otherlv_4, grammarAccess.getServiceGenerationSettingAccess().getWithKeyword_3());
            		
            // InternalJDL.g:2297:3: ( (lv_serviceType_5_0= ruleServiceType ) )
            // InternalJDL.g:2298:4: (lv_serviceType_5_0= ruleServiceType )
            {
            // InternalJDL.g:2298:4: (lv_serviceType_5_0= ruleServiceType )
            // InternalJDL.g:2299:5: lv_serviceType_5_0= ruleServiceType
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
    // InternalJDL.g:2320:1: entryRuleDTOGenerationSetting returns [EObject current=null] : iv_ruleDTOGenerationSetting= ruleDTOGenerationSetting EOF ;
    public final EObject entryRuleDTOGenerationSetting() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDTOGenerationSetting = null;


        try {
            // InternalJDL.g:2320:61: (iv_ruleDTOGenerationSetting= ruleDTOGenerationSetting EOF )
            // InternalJDL.g:2321:2: iv_ruleDTOGenerationSetting= ruleDTOGenerationSetting EOF
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
    // InternalJDL.g:2327:1: ruleDTOGenerationSetting returns [EObject current=null] : (otherlv_0= 'dto' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_dtoType_5_0= ruleDTOType ) ) ) ;
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
            // InternalJDL.g:2333:2: ( (otherlv_0= 'dto' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_dtoType_5_0= ruleDTOType ) ) ) )
            // InternalJDL.g:2334:2: (otherlv_0= 'dto' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_dtoType_5_0= ruleDTOType ) ) )
            {
            // InternalJDL.g:2334:2: (otherlv_0= 'dto' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_dtoType_5_0= ruleDTOType ) ) )
            // InternalJDL.g:2335:3: otherlv_0= 'dto' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_dtoType_5_0= ruleDTOType ) )
            {
            otherlv_0=(Token)match(input,42,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getDTOGenerationSettingAccess().getDtoKeyword_0());
            		
            // InternalJDL.g:2339:3: ( (lv_entities_1_0= RULE_ID ) )
            // InternalJDL.g:2340:4: (lv_entities_1_0= RULE_ID )
            {
            // InternalJDL.g:2340:4: (lv_entities_1_0= RULE_ID )
            // InternalJDL.g:2341:5: lv_entities_1_0= RULE_ID
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

            // InternalJDL.g:2357:3: (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==13) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalJDL.g:2358:4: otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) )
            	    {
            	    otherlv_2=(Token)match(input,13,FOLLOW_4); 

            	    				newLeafNode(otherlv_2, grammarAccess.getDTOGenerationSettingAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalJDL.g:2362:4: ( (lv_entities_3_0= RULE_ID ) )
            	    // InternalJDL.g:2363:5: (lv_entities_3_0= RULE_ID )
            	    {
            	    // InternalJDL.g:2363:5: (lv_entities_3_0= RULE_ID )
            	    // InternalJDL.g:2364:6: lv_entities_3_0= RULE_ID
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
            	    break loop34;
                }
            } while (true);

            otherlv_4=(Token)match(input,41,FOLLOW_40); 

            			newLeafNode(otherlv_4, grammarAccess.getDTOGenerationSettingAccess().getWithKeyword_3());
            		
            // InternalJDL.g:2385:3: ( (lv_dtoType_5_0= ruleDTOType ) )
            // InternalJDL.g:2386:4: (lv_dtoType_5_0= ruleDTOType )
            {
            // InternalJDL.g:2386:4: (lv_dtoType_5_0= ruleDTOType )
            // InternalJDL.g:2387:5: lv_dtoType_5_0= ruleDTOType
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
    // InternalJDL.g:2408:1: entryRulePaginateGenerationSetting returns [EObject current=null] : iv_rulePaginateGenerationSetting= rulePaginateGenerationSetting EOF ;
    public final EObject entryRulePaginateGenerationSetting() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePaginateGenerationSetting = null;


        try {
            // InternalJDL.g:2408:66: (iv_rulePaginateGenerationSetting= rulePaginateGenerationSetting EOF )
            // InternalJDL.g:2409:2: iv_rulePaginateGenerationSetting= rulePaginateGenerationSetting EOF
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
    // InternalJDL.g:2415:1: rulePaginateGenerationSetting returns [EObject current=null] : (otherlv_0= 'paginate' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_paginateType_5_0= rulePaginateType ) ) ) ;
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
            // InternalJDL.g:2421:2: ( (otherlv_0= 'paginate' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_paginateType_5_0= rulePaginateType ) ) ) )
            // InternalJDL.g:2422:2: (otherlv_0= 'paginate' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_paginateType_5_0= rulePaginateType ) ) )
            {
            // InternalJDL.g:2422:2: (otherlv_0= 'paginate' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_paginateType_5_0= rulePaginateType ) ) )
            // InternalJDL.g:2423:3: otherlv_0= 'paginate' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_paginateType_5_0= rulePaginateType ) )
            {
            otherlv_0=(Token)match(input,43,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getPaginateGenerationSettingAccess().getPaginateKeyword_0());
            		
            // InternalJDL.g:2427:3: ( (lv_entities_1_0= RULE_ID ) )
            // InternalJDL.g:2428:4: (lv_entities_1_0= RULE_ID )
            {
            // InternalJDL.g:2428:4: (lv_entities_1_0= RULE_ID )
            // InternalJDL.g:2429:5: lv_entities_1_0= RULE_ID
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

            // InternalJDL.g:2445:3: (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==13) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalJDL.g:2446:4: otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) )
            	    {
            	    otherlv_2=(Token)match(input,13,FOLLOW_4); 

            	    				newLeafNode(otherlv_2, grammarAccess.getPaginateGenerationSettingAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalJDL.g:2450:4: ( (lv_entities_3_0= RULE_ID ) )
            	    // InternalJDL.g:2451:5: (lv_entities_3_0= RULE_ID )
            	    {
            	    // InternalJDL.g:2451:5: (lv_entities_3_0= RULE_ID )
            	    // InternalJDL.g:2452:6: lv_entities_3_0= RULE_ID
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
            	    break loop35;
                }
            } while (true);

            otherlv_4=(Token)match(input,41,FOLLOW_41); 

            			newLeafNode(otherlv_4, grammarAccess.getPaginateGenerationSettingAccess().getWithKeyword_3());
            		
            // InternalJDL.g:2473:3: ( (lv_paginateType_5_0= rulePaginateType ) )
            // InternalJDL.g:2474:4: (lv_paginateType_5_0= rulePaginateType )
            {
            // InternalJDL.g:2474:4: (lv_paginateType_5_0= rulePaginateType )
            // InternalJDL.g:2475:5: lv_paginateType_5_0= rulePaginateType
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
    // InternalJDL.g:2496:1: entryRuleAngularSuffixGenerationSetting returns [EObject current=null] : iv_ruleAngularSuffixGenerationSetting= ruleAngularSuffixGenerationSetting EOF ;
    public final EObject entryRuleAngularSuffixGenerationSetting() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAngularSuffixGenerationSetting = null;


        try {
            // InternalJDL.g:2496:71: (iv_ruleAngularSuffixGenerationSetting= ruleAngularSuffixGenerationSetting EOF )
            // InternalJDL.g:2497:2: iv_ruleAngularSuffixGenerationSetting= ruleAngularSuffixGenerationSetting EOF
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
    // InternalJDL.g:2503:1: ruleAngularSuffixGenerationSetting returns [EObject current=null] : (otherlv_0= 'angularSuffix' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_id_5_0= RULE_ID ) ) ) ;
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
            // InternalJDL.g:2509:2: ( (otherlv_0= 'angularSuffix' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_id_5_0= RULE_ID ) ) ) )
            // InternalJDL.g:2510:2: (otherlv_0= 'angularSuffix' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_id_5_0= RULE_ID ) ) )
            {
            // InternalJDL.g:2510:2: (otherlv_0= 'angularSuffix' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_id_5_0= RULE_ID ) ) )
            // InternalJDL.g:2511:3: otherlv_0= 'angularSuffix' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_id_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,44,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getAngularSuffixGenerationSettingAccess().getAngularSuffixKeyword_0());
            		
            // InternalJDL.g:2515:3: ( (lv_entities_1_0= RULE_ID ) )
            // InternalJDL.g:2516:4: (lv_entities_1_0= RULE_ID )
            {
            // InternalJDL.g:2516:4: (lv_entities_1_0= RULE_ID )
            // InternalJDL.g:2517:5: lv_entities_1_0= RULE_ID
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

            // InternalJDL.g:2533:3: (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==13) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalJDL.g:2534:4: otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) )
            	    {
            	    otherlv_2=(Token)match(input,13,FOLLOW_4); 

            	    				newLeafNode(otherlv_2, grammarAccess.getAngularSuffixGenerationSettingAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalJDL.g:2538:4: ( (lv_entities_3_0= RULE_ID ) )
            	    // InternalJDL.g:2539:5: (lv_entities_3_0= RULE_ID )
            	    {
            	    // InternalJDL.g:2539:5: (lv_entities_3_0= RULE_ID )
            	    // InternalJDL.g:2540:6: lv_entities_3_0= RULE_ID
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
            	    break loop36;
                }
            } while (true);

            otherlv_4=(Token)match(input,41,FOLLOW_4); 

            			newLeafNode(otherlv_4, grammarAccess.getAngularSuffixGenerationSettingAccess().getWithKeyword_3());
            		
            // InternalJDL.g:2561:3: ( (lv_id_5_0= RULE_ID ) )
            // InternalJDL.g:2562:4: (lv_id_5_0= RULE_ID )
            {
            // InternalJDL.g:2562:4: (lv_id_5_0= RULE_ID )
            // InternalJDL.g:2563:5: lv_id_5_0= RULE_ID
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
    // InternalJDL.g:2583:1: ruleCardinality returns [Enumerator current=null] : ( (enumLiteral_0= 'OneToMany' ) | (enumLiteral_1= 'ManyToOne' ) | (enumLiteral_2= 'OneToOne' ) | (enumLiteral_3= 'ManyToMany' ) ) ;
    public final Enumerator ruleCardinality() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalJDL.g:2589:2: ( ( (enumLiteral_0= 'OneToMany' ) | (enumLiteral_1= 'ManyToOne' ) | (enumLiteral_2= 'OneToOne' ) | (enumLiteral_3= 'ManyToMany' ) ) )
            // InternalJDL.g:2590:2: ( (enumLiteral_0= 'OneToMany' ) | (enumLiteral_1= 'ManyToOne' ) | (enumLiteral_2= 'OneToOne' ) | (enumLiteral_3= 'ManyToMany' ) )
            {
            // InternalJDL.g:2590:2: ( (enumLiteral_0= 'OneToMany' ) | (enumLiteral_1= 'ManyToOne' ) | (enumLiteral_2= 'OneToOne' ) | (enumLiteral_3= 'ManyToMany' ) )
            int alt37=4;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt37=1;
                }
                break;
            case 46:
                {
                alt37=2;
                }
                break;
            case 47:
                {
                alt37=3;
                }
                break;
            case 48:
                {
                alt37=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // InternalJDL.g:2591:3: (enumLiteral_0= 'OneToMany' )
                    {
                    // InternalJDL.g:2591:3: (enumLiteral_0= 'OneToMany' )
                    // InternalJDL.g:2592:4: enumLiteral_0= 'OneToMany'
                    {
                    enumLiteral_0=(Token)match(input,45,FOLLOW_2); 

                    				current = grammarAccess.getCardinalityAccess().getOneToManyEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCardinalityAccess().getOneToManyEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalJDL.g:2599:3: (enumLiteral_1= 'ManyToOne' )
                    {
                    // InternalJDL.g:2599:3: (enumLiteral_1= 'ManyToOne' )
                    // InternalJDL.g:2600:4: enumLiteral_1= 'ManyToOne'
                    {
                    enumLiteral_1=(Token)match(input,46,FOLLOW_2); 

                    				current = grammarAccess.getCardinalityAccess().getManyToOneEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getCardinalityAccess().getManyToOneEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalJDL.g:2607:3: (enumLiteral_2= 'OneToOne' )
                    {
                    // InternalJDL.g:2607:3: (enumLiteral_2= 'OneToOne' )
                    // InternalJDL.g:2608:4: enumLiteral_2= 'OneToOne'
                    {
                    enumLiteral_2=(Token)match(input,47,FOLLOW_2); 

                    				current = grammarAccess.getCardinalityAccess().getOneToOneEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getCardinalityAccess().getOneToOneEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalJDL.g:2615:3: (enumLiteral_3= 'ManyToMany' )
                    {
                    // InternalJDL.g:2615:3: (enumLiteral_3= 'ManyToMany' )
                    // InternalJDL.g:2616:4: enumLiteral_3= 'ManyToMany'
                    {
                    enumLiteral_3=(Token)match(input,48,FOLLOW_2); 

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
    // InternalJDL.g:2626:1: ruleServiceType returns [Enumerator current=null] : ( (enumLiteral_0= 'serviceClass' ) | (enumLiteral_1= 'serviceImpl' ) ) ;
    public final Enumerator ruleServiceType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalJDL.g:2632:2: ( ( (enumLiteral_0= 'serviceClass' ) | (enumLiteral_1= 'serviceImpl' ) ) )
            // InternalJDL.g:2633:2: ( (enumLiteral_0= 'serviceClass' ) | (enumLiteral_1= 'serviceImpl' ) )
            {
            // InternalJDL.g:2633:2: ( (enumLiteral_0= 'serviceClass' ) | (enumLiteral_1= 'serviceImpl' ) )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==49) ) {
                alt38=1;
            }
            else if ( (LA38_0==50) ) {
                alt38=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // InternalJDL.g:2634:3: (enumLiteral_0= 'serviceClass' )
                    {
                    // InternalJDL.g:2634:3: (enumLiteral_0= 'serviceClass' )
                    // InternalJDL.g:2635:4: enumLiteral_0= 'serviceClass'
                    {
                    enumLiteral_0=(Token)match(input,49,FOLLOW_2); 

                    				current = grammarAccess.getServiceTypeAccess().getServiceClassEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getServiceTypeAccess().getServiceClassEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalJDL.g:2642:3: (enumLiteral_1= 'serviceImpl' )
                    {
                    // InternalJDL.g:2642:3: (enumLiteral_1= 'serviceImpl' )
                    // InternalJDL.g:2643:4: enumLiteral_1= 'serviceImpl'
                    {
                    enumLiteral_1=(Token)match(input,50,FOLLOW_2); 

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
    // InternalJDL.g:2653:1: ruleDTOType returns [Enumerator current=null] : (enumLiteral_0= 'mapstruct' ) ;
    public final Enumerator ruleDTOType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;


        	enterRule();

        try {
            // InternalJDL.g:2659:2: ( (enumLiteral_0= 'mapstruct' ) )
            // InternalJDL.g:2660:2: (enumLiteral_0= 'mapstruct' )
            {
            // InternalJDL.g:2660:2: (enumLiteral_0= 'mapstruct' )
            // InternalJDL.g:2661:3: enumLiteral_0= 'mapstruct'
            {
            enumLiteral_0=(Token)match(input,51,FOLLOW_2); 

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
    // InternalJDL.g:2670:1: rulePaginateType returns [Enumerator current=null] : ( (enumLiteral_0= 'pagination' ) | (enumLiteral_1= 'infiniteScroll' ) ) ;
    public final Enumerator rulePaginateType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalJDL.g:2676:2: ( ( (enumLiteral_0= 'pagination' ) | (enumLiteral_1= 'infiniteScroll' ) ) )
            // InternalJDL.g:2677:2: ( (enumLiteral_0= 'pagination' ) | (enumLiteral_1= 'infiniteScroll' ) )
            {
            // InternalJDL.g:2677:2: ( (enumLiteral_0= 'pagination' ) | (enumLiteral_1= 'infiniteScroll' ) )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==52) ) {
                alt39=1;
            }
            else if ( (LA39_0==53) ) {
                alt39=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // InternalJDL.g:2678:3: (enumLiteral_0= 'pagination' )
                    {
                    // InternalJDL.g:2678:3: (enumLiteral_0= 'pagination' )
                    // InternalJDL.g:2679:4: enumLiteral_0= 'pagination'
                    {
                    enumLiteral_0=(Token)match(input,52,FOLLOW_2); 

                    				current = grammarAccess.getPaginateTypeAccess().getPaginationEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getPaginateTypeAccess().getPaginationEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalJDL.g:2686:3: (enumLiteral_1= 'infiniteScroll' )
                    {
                    // InternalJDL.g:2686:3: (enumLiteral_1= 'infiniteScroll' )
                    // InternalJDL.g:2687:4: enumLiteral_1= 'infiniteScroll'
                    {
                    enumLiteral_1=(Token)match(input,53,FOLLOW_2); 

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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00001DA000000802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008000L});
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
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0001E00000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000004800L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000004000001000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000020000002000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0006000000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0030000000000000L});

}