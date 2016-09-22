package io.github.jhipster.jdl.parser.antlr.internal;

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
import io.github.jhipster.jdl.services.JDLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalJDLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'entity'", "'{'", "','", "'}'", "'String'", "'Boolean'", "'LocalDate'", "'ZonedDateTime'", "'required'", "'minlength'", "'('", "')'", "'maxlength'", "'pattern'", "'min'", "'max'", "'minbytes'", "'maxbytes'", "'relationship'", "'to'", "'enum'", "'service'", "'microservice'", "'search'", "'dto'", "'paginate'", "'angularSuffix'", "'with'", "'except'", "'*'", "'all'", "'pager'", "'pagination'", "'infinite-scroll'", "'Integer'", "'Long'", "'BigDecimal'", "'Float'", "'Double'", "'Blob'", "'AnyBlob'", "'ImageBlob'", "'OneToMany'", "'ManyToOne'", "'OneToOne'", "'ManyToMany'", "'serviceClass'", "'serviceImpl'", "'mapstruct'"
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

        public InternalJDLParser(TokenStream input, JDLGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "JdlDomainModel";
       	}

       	@Override
       	protected JDLGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleJdlDomainModel"
    // InternalJDL.g:65:1: entryRuleJdlDomainModel returns [EObject current=null] : iv_ruleJdlDomainModel= ruleJdlDomainModel EOF ;
    public final EObject entryRuleJdlDomainModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJdlDomainModel = null;


        try {
            // InternalJDL.g:65:55: (iv_ruleJdlDomainModel= ruleJdlDomainModel EOF )
            // InternalJDL.g:66:2: iv_ruleJdlDomainModel= ruleJdlDomainModel EOF
            {
             newCompositeNode(grammarAccess.getJdlDomainModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlDomainModel=ruleJdlDomainModel();

            state._fsp--;

             current =iv_ruleJdlDomainModel; 
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
    // $ANTLR end "entryRuleJdlDomainModel"


    // $ANTLR start "ruleJdlDomainModel"
    // InternalJDL.g:72:1: ruleJdlDomainModel returns [EObject current=null] : ( (lv_features_0_0= ruleJdlFeature ) )* ;
    public final EObject ruleJdlDomainModel() throws RecognitionException {
        EObject current = null;

        EObject lv_features_0_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:78:2: ( ( (lv_features_0_0= ruleJdlFeature ) )* )
            // InternalJDL.g:79:2: ( (lv_features_0_0= ruleJdlFeature ) )*
            {
            // InternalJDL.g:79:2: ( (lv_features_0_0= ruleJdlFeature ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11||LA1_0==29||(LA1_0>=31 && LA1_0<=37)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalJDL.g:80:3: (lv_features_0_0= ruleJdlFeature )
            	    {
            	    // InternalJDL.g:80:3: (lv_features_0_0= ruleJdlFeature )
            	    // InternalJDL.g:81:4: lv_features_0_0= ruleJdlFeature
            	    {

            	    				newCompositeNode(grammarAccess.getJdlDomainModelAccess().getFeaturesJdlFeatureParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_features_0_0=ruleJdlFeature();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getJdlDomainModelRule());
            	    				}
            	    				add(
            	    					current,
            	    					"features",
            	    					lv_features_0_0,
            	    					"io.github.jhipster.jdl.JDL.JdlFeature");
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
    // $ANTLR end "ruleJdlDomainModel"


    // $ANTLR start "entryRuleJdlFeature"
    // InternalJDL.g:101:1: entryRuleJdlFeature returns [EObject current=null] : iv_ruleJdlFeature= ruleJdlFeature EOF ;
    public final EObject entryRuleJdlFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJdlFeature = null;


        try {
            // InternalJDL.g:101:51: (iv_ruleJdlFeature= ruleJdlFeature EOF )
            // InternalJDL.g:102:2: iv_ruleJdlFeature= ruleJdlFeature EOF
            {
             newCompositeNode(grammarAccess.getJdlFeatureRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlFeature=ruleJdlFeature();

            state._fsp--;

             current =iv_ruleJdlFeature; 
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
    // $ANTLR end "entryRuleJdlFeature"


    // $ANTLR start "ruleJdlFeature"
    // InternalJDL.g:108:1: ruleJdlFeature returns [EObject current=null] : (this_JdlEntity_0= ruleJdlEntity | this_JdlEnumType_1= ruleJdlEnumType | this_JdlRelationships_2= ruleJdlRelationships | this_JdlGenerationSetting_3= ruleJdlGenerationSetting ) ;
    public final EObject ruleJdlFeature() throws RecognitionException {
        EObject current = null;

        EObject this_JdlEntity_0 = null;

        EObject this_JdlEnumType_1 = null;

        EObject this_JdlRelationships_2 = null;

        EObject this_JdlGenerationSetting_3 = null;



        	enterRule();

        try {
            // InternalJDL.g:114:2: ( (this_JdlEntity_0= ruleJdlEntity | this_JdlEnumType_1= ruleJdlEnumType | this_JdlRelationships_2= ruleJdlRelationships | this_JdlGenerationSetting_3= ruleJdlGenerationSetting ) )
            // InternalJDL.g:115:2: (this_JdlEntity_0= ruleJdlEntity | this_JdlEnumType_1= ruleJdlEnumType | this_JdlRelationships_2= ruleJdlRelationships | this_JdlGenerationSetting_3= ruleJdlGenerationSetting )
            {
            // InternalJDL.g:115:2: (this_JdlEntity_0= ruleJdlEntity | this_JdlEnumType_1= ruleJdlEnumType | this_JdlRelationships_2= ruleJdlRelationships | this_JdlGenerationSetting_3= ruleJdlGenerationSetting )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt2=1;
                }
                break;
            case 31:
                {
                alt2=2;
                }
                break;
            case 29:
                {
                alt2=3;
                }
                break;
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
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
                    // InternalJDL.g:116:3: this_JdlEntity_0= ruleJdlEntity
                    {

                    			newCompositeNode(grammarAccess.getJdlFeatureAccess().getJdlEntityParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_JdlEntity_0=ruleJdlEntity();

                    state._fsp--;


                    			current = this_JdlEntity_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalJDL.g:125:3: this_JdlEnumType_1= ruleJdlEnumType
                    {

                    			newCompositeNode(grammarAccess.getJdlFeatureAccess().getJdlEnumTypeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_JdlEnumType_1=ruleJdlEnumType();

                    state._fsp--;


                    			current = this_JdlEnumType_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalJDL.g:134:3: this_JdlRelationships_2= ruleJdlRelationships
                    {

                    			newCompositeNode(grammarAccess.getJdlFeatureAccess().getJdlRelationshipsParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_JdlRelationships_2=ruleJdlRelationships();

                    state._fsp--;


                    			current = this_JdlRelationships_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalJDL.g:143:3: this_JdlGenerationSetting_3= ruleJdlGenerationSetting
                    {

                    			newCompositeNode(grammarAccess.getJdlFeatureAccess().getJdlGenerationSettingParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_JdlGenerationSetting_3=ruleJdlGenerationSetting();

                    state._fsp--;


                    			current = this_JdlGenerationSetting_3;
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
    // $ANTLR end "ruleJdlFeature"


    // $ANTLR start "entryRuleJdlEntity"
    // InternalJDL.g:155:1: entryRuleJdlEntity returns [EObject current=null] : iv_ruleJdlEntity= ruleJdlEntity EOF ;
    public final EObject entryRuleJdlEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJdlEntity = null;


        try {
            // InternalJDL.g:155:50: (iv_ruleJdlEntity= ruleJdlEntity EOF )
            // InternalJDL.g:156:2: iv_ruleJdlEntity= ruleJdlEntity EOF
            {
             newCompositeNode(grammarAccess.getJdlEntityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlEntity=ruleJdlEntity();

            state._fsp--;

             current =iv_ruleJdlEntity; 
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
    // $ANTLR end "entryRuleJdlEntity"


    // $ANTLR start "ruleJdlEntity"
    // InternalJDL.g:162:1: ruleJdlEntity returns [EObject current=null] : (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( ( (lv_fields_3_0= ruleJdlEntityField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleJdlEntityField ) ) )* )? otherlv_6= '}' )? ) ;
    public final EObject ruleJdlEntity() throws RecognitionException {
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
            // InternalJDL.g:168:2: ( (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( ( (lv_fields_3_0= ruleJdlEntityField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleJdlEntityField ) ) )* )? otherlv_6= '}' )? ) )
            // InternalJDL.g:169:2: (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( ( (lv_fields_3_0= ruleJdlEntityField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleJdlEntityField ) ) )* )? otherlv_6= '}' )? )
            {
            // InternalJDL.g:169:2: (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( ( (lv_fields_3_0= ruleJdlEntityField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleJdlEntityField ) ) )* )? otherlv_6= '}' )? )
            // InternalJDL.g:170:3: otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( ( (lv_fields_3_0= ruleJdlEntityField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleJdlEntityField ) ) )* )? otherlv_6= '}' )?
            {
            otherlv_0=(Token)match(input,11,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getJdlEntityAccess().getEntityKeyword_0());
            		
            // InternalJDL.g:174:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalJDL.g:175:4: (lv_name_1_0= RULE_ID )
            {
            // InternalJDL.g:175:4: (lv_name_1_0= RULE_ID )
            // InternalJDL.g:176:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getJdlEntityAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJdlEntityRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalJDL.g:192:3: (otherlv_2= '{' ( ( (lv_fields_3_0= ruleJdlEntityField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleJdlEntityField ) ) )* )? otherlv_6= '}' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==12) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalJDL.g:193:4: otherlv_2= '{' ( ( (lv_fields_3_0= ruleJdlEntityField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleJdlEntityField ) ) )* )? otherlv_6= '}'
                    {
                    otherlv_2=(Token)match(input,12,FOLLOW_6); 

                    				newLeafNode(otherlv_2, grammarAccess.getJdlEntityAccess().getLeftCurlyBracketKeyword_2_0());
                    			
                    // InternalJDL.g:197:4: ( ( (lv_fields_3_0= ruleJdlEntityField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleJdlEntityField ) ) )* )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==RULE_ID) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // InternalJDL.g:198:5: ( (lv_fields_3_0= ruleJdlEntityField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleJdlEntityField ) ) )*
                            {
                            // InternalJDL.g:198:5: ( (lv_fields_3_0= ruleJdlEntityField ) )
                            // InternalJDL.g:199:6: (lv_fields_3_0= ruleJdlEntityField )
                            {
                            // InternalJDL.g:199:6: (lv_fields_3_0= ruleJdlEntityField )
                            // InternalJDL.g:200:7: lv_fields_3_0= ruleJdlEntityField
                            {

                            							newCompositeNode(grammarAccess.getJdlEntityAccess().getFieldsJdlEntityFieldParserRuleCall_2_1_0_0());
                            						
                            pushFollow(FOLLOW_7);
                            lv_fields_3_0=ruleJdlEntityField();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getJdlEntityRule());
                            							}
                            							add(
                            								current,
                            								"fields",
                            								lv_fields_3_0,
                            								"io.github.jhipster.jdl.JDL.JdlEntityField");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            // InternalJDL.g:217:5: (otherlv_4= ',' ( (lv_fields_5_0= ruleJdlEntityField ) ) )*
                            loop3:
                            do {
                                int alt3=2;
                                int LA3_0 = input.LA(1);

                                if ( (LA3_0==13) ) {
                                    alt3=1;
                                }


                                switch (alt3) {
                            	case 1 :
                            	    // InternalJDL.g:218:6: otherlv_4= ',' ( (lv_fields_5_0= ruleJdlEntityField ) )
                            	    {
                            	    otherlv_4=(Token)match(input,13,FOLLOW_4); 

                            	    						newLeafNode(otherlv_4, grammarAccess.getJdlEntityAccess().getCommaKeyword_2_1_1_0());
                            	    					
                            	    // InternalJDL.g:222:6: ( (lv_fields_5_0= ruleJdlEntityField ) )
                            	    // InternalJDL.g:223:7: (lv_fields_5_0= ruleJdlEntityField )
                            	    {
                            	    // InternalJDL.g:223:7: (lv_fields_5_0= ruleJdlEntityField )
                            	    // InternalJDL.g:224:8: lv_fields_5_0= ruleJdlEntityField
                            	    {

                            	    								newCompositeNode(grammarAccess.getJdlEntityAccess().getFieldsJdlEntityFieldParserRuleCall_2_1_1_1_0());
                            	    							
                            	    pushFollow(FOLLOW_7);
                            	    lv_fields_5_0=ruleJdlEntityField();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getJdlEntityRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"fields",
                            	    									lv_fields_5_0,
                            	    									"io.github.jhipster.jdl.JDL.JdlEntityField");
                            	    								afterParserOrEnumRuleCall();
                            	    							

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop3;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_6=(Token)match(input,14,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getJdlEntityAccess().getRightCurlyBracketKeyword_2_2());
                    			

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
    // $ANTLR end "ruleJdlEntity"


    // $ANTLR start "entryRuleJdlEntityField"
    // InternalJDL.g:252:1: entryRuleJdlEntityField returns [EObject current=null] : iv_ruleJdlEntityField= ruleJdlEntityField EOF ;
    public final EObject entryRuleJdlEntityField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJdlEntityField = null;


        try {
            // InternalJDL.g:252:55: (iv_ruleJdlEntityField= ruleJdlEntityField EOF )
            // InternalJDL.g:253:2: iv_ruleJdlEntityField= ruleJdlEntityField EOF
            {
             newCompositeNode(grammarAccess.getJdlEntityFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlEntityField=ruleJdlEntityField();

            state._fsp--;

             current =iv_ruleJdlEntityField; 
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
    // $ANTLR end "entryRuleJdlEntityField"


    // $ANTLR start "ruleJdlEntityField"
    // InternalJDL.g:259:1: ruleJdlEntityField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleJdlFieldType ) ) ) ;
    public final EObject ruleJdlEntityField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_type_1_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:265:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleJdlFieldType ) ) ) )
            // InternalJDL.g:266:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleJdlFieldType ) ) )
            {
            // InternalJDL.g:266:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleJdlFieldType ) ) )
            // InternalJDL.g:267:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleJdlFieldType ) )
            {
            // InternalJDL.g:267:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalJDL.g:268:4: (lv_name_0_0= RULE_ID )
            {
            // InternalJDL.g:268:4: (lv_name_0_0= RULE_ID )
            // InternalJDL.g:269:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            					newLeafNode(lv_name_0_0, grammarAccess.getJdlEntityFieldAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJdlEntityFieldRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalJDL.g:285:3: ( (lv_type_1_0= ruleJdlFieldType ) )
            // InternalJDL.g:286:4: (lv_type_1_0= ruleJdlFieldType )
            {
            // InternalJDL.g:286:4: (lv_type_1_0= ruleJdlFieldType )
            // InternalJDL.g:287:5: lv_type_1_0= ruleJdlFieldType
            {

            					newCompositeNode(grammarAccess.getJdlEntityFieldAccess().getTypeJdlFieldTypeParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_type_1_0=ruleJdlFieldType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJdlEntityFieldRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_1_0,
            						"io.github.jhipster.jdl.JDL.JdlFieldType");
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
    // $ANTLR end "ruleJdlEntityField"


    // $ANTLR start "entryRuleJdlFieldType"
    // InternalJDL.g:308:1: entryRuleJdlFieldType returns [EObject current=null] : iv_ruleJdlFieldType= ruleJdlFieldType EOF ;
    public final EObject entryRuleJdlFieldType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJdlFieldType = null;


        try {
            // InternalJDL.g:308:53: (iv_ruleJdlFieldType= ruleJdlFieldType EOF )
            // InternalJDL.g:309:2: iv_ruleJdlFieldType= ruleJdlFieldType EOF
            {
             newCompositeNode(grammarAccess.getJdlFieldTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlFieldType=ruleJdlFieldType();

            state._fsp--;

             current =iv_ruleJdlFieldType; 
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
    // $ANTLR end "entryRuleJdlFieldType"


    // $ANTLR start "ruleJdlFieldType"
    // InternalJDL.g:315:1: ruleJdlFieldType returns [EObject current=null] : (this_JdlEnumField_0= ruleJdlEnumField | this_JdlStringField_1= ruleJdlStringField | this_JdlNumericField_2= ruleJdlNumericField | this_JdlBooleanField_3= ruleJdlBooleanField | this_JdlDateField_4= ruleJdlDateField | this_JdlBlobField_5= ruleJdlBlobField ) ;
    public final EObject ruleJdlFieldType() throws RecognitionException {
        EObject current = null;

        EObject this_JdlEnumField_0 = null;

        EObject this_JdlStringField_1 = null;

        EObject this_JdlNumericField_2 = null;

        EObject this_JdlBooleanField_3 = null;

        EObject this_JdlDateField_4 = null;

        EObject this_JdlBlobField_5 = null;



        	enterRule();

        try {
            // InternalJDL.g:321:2: ( (this_JdlEnumField_0= ruleJdlEnumField | this_JdlStringField_1= ruleJdlStringField | this_JdlNumericField_2= ruleJdlNumericField | this_JdlBooleanField_3= ruleJdlBooleanField | this_JdlDateField_4= ruleJdlDateField | this_JdlBlobField_5= ruleJdlBlobField ) )
            // InternalJDL.g:322:2: (this_JdlEnumField_0= ruleJdlEnumField | this_JdlStringField_1= ruleJdlStringField | this_JdlNumericField_2= ruleJdlNumericField | this_JdlBooleanField_3= ruleJdlBooleanField | this_JdlDateField_4= ruleJdlDateField | this_JdlBlobField_5= ruleJdlBlobField )
            {
            // InternalJDL.g:322:2: (this_JdlEnumField_0= ruleJdlEnumField | this_JdlStringField_1= ruleJdlStringField | this_JdlNumericField_2= ruleJdlNumericField | this_JdlBooleanField_3= ruleJdlBooleanField | this_JdlDateField_4= ruleJdlDateField | this_JdlBlobField_5= ruleJdlBlobField )
            int alt6=6;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt6=1;
                }
                break;
            case 15:
                {
                alt6=2;
                }
                break;
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                {
                alt6=3;
                }
                break;
            case 16:
                {
                alt6=4;
                }
                break;
            case 17:
            case 18:
                {
                alt6=5;
                }
                break;
            case 50:
            case 51:
            case 52:
                {
                alt6=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalJDL.g:323:3: this_JdlEnumField_0= ruleJdlEnumField
                    {

                    			newCompositeNode(grammarAccess.getJdlFieldTypeAccess().getJdlEnumFieldParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_JdlEnumField_0=ruleJdlEnumField();

                    state._fsp--;


                    			current = this_JdlEnumField_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalJDL.g:332:3: this_JdlStringField_1= ruleJdlStringField
                    {

                    			newCompositeNode(grammarAccess.getJdlFieldTypeAccess().getJdlStringFieldParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_JdlStringField_1=ruleJdlStringField();

                    state._fsp--;


                    			current = this_JdlStringField_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalJDL.g:341:3: this_JdlNumericField_2= ruleJdlNumericField
                    {

                    			newCompositeNode(grammarAccess.getJdlFieldTypeAccess().getJdlNumericFieldParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_JdlNumericField_2=ruleJdlNumericField();

                    state._fsp--;


                    			current = this_JdlNumericField_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalJDL.g:350:3: this_JdlBooleanField_3= ruleJdlBooleanField
                    {

                    			newCompositeNode(grammarAccess.getJdlFieldTypeAccess().getJdlBooleanFieldParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_JdlBooleanField_3=ruleJdlBooleanField();

                    state._fsp--;


                    			current = this_JdlBooleanField_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalJDL.g:359:3: this_JdlDateField_4= ruleJdlDateField
                    {

                    			newCompositeNode(grammarAccess.getJdlFieldTypeAccess().getJdlDateFieldParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_JdlDateField_4=ruleJdlDateField();

                    state._fsp--;


                    			current = this_JdlDateField_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalJDL.g:368:3: this_JdlBlobField_5= ruleJdlBlobField
                    {

                    			newCompositeNode(grammarAccess.getJdlFieldTypeAccess().getJdlBlobFieldParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_JdlBlobField_5=ruleJdlBlobField();

                    state._fsp--;


                    			current = this_JdlBlobField_5;
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
    // $ANTLR end "ruleJdlFieldType"


    // $ANTLR start "entryRuleJdlEnumField"
    // InternalJDL.g:380:1: entryRuleJdlEnumField returns [EObject current=null] : iv_ruleJdlEnumField= ruleJdlEnumField EOF ;
    public final EObject entryRuleJdlEnumField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJdlEnumField = null;


        try {
            // InternalJDL.g:380:53: (iv_ruleJdlEnumField= ruleJdlEnumField EOF )
            // InternalJDL.g:381:2: iv_ruleJdlEnumField= ruleJdlEnumField EOF
            {
             newCompositeNode(grammarAccess.getJdlEnumFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlEnumField=ruleJdlEnumField();

            state._fsp--;

             current =iv_ruleJdlEnumField; 
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
    // $ANTLR end "entryRuleJdlEnumField"


    // $ANTLR start "ruleJdlEnumField"
    // InternalJDL.g:387:1: ruleJdlEnumField returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_validators_1_0= ruleJdlRequiredValidator ) )? ) ;
    public final EObject ruleJdlEnumField() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_validators_1_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:393:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_validators_1_0= ruleJdlRequiredValidator ) )? ) )
            // InternalJDL.g:394:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_validators_1_0= ruleJdlRequiredValidator ) )? )
            {
            // InternalJDL.g:394:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_validators_1_0= ruleJdlRequiredValidator ) )? )
            // InternalJDL.g:395:3: ( (otherlv_0= RULE_ID ) ) ( (lv_validators_1_0= ruleJdlRequiredValidator ) )?
            {
            // InternalJDL.g:395:3: ( (otherlv_0= RULE_ID ) )
            // InternalJDL.g:396:4: (otherlv_0= RULE_ID )
            {
            // InternalJDL.g:396:4: (otherlv_0= RULE_ID )
            // InternalJDL.g:397:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJdlEnumFieldRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(otherlv_0, grammarAccess.getJdlEnumFieldAccess().getEnumTypeJdlEnumTypeCrossReference_0_0());
            				

            }


            }

            // InternalJDL.g:408:3: ( (lv_validators_1_0= ruleJdlRequiredValidator ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==19) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalJDL.g:409:4: (lv_validators_1_0= ruleJdlRequiredValidator )
                    {
                    // InternalJDL.g:409:4: (lv_validators_1_0= ruleJdlRequiredValidator )
                    // InternalJDL.g:410:5: lv_validators_1_0= ruleJdlRequiredValidator
                    {

                    					newCompositeNode(grammarAccess.getJdlEnumFieldAccess().getValidatorsJdlRequiredValidatorParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_1_0=ruleJdlRequiredValidator();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getJdlEnumFieldRule());
                    					}
                    					set(
                    						current,
                    						"validators",
                    						lv_validators_1_0,
                    						"io.github.jhipster.jdl.JDL.JdlRequiredValidator");
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
    // $ANTLR end "ruleJdlEnumField"


    // $ANTLR start "entryRuleJdlStringField"
    // InternalJDL.g:431:1: entryRuleJdlStringField returns [EObject current=null] : iv_ruleJdlStringField= ruleJdlStringField EOF ;
    public final EObject entryRuleJdlStringField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJdlStringField = null;


        try {
            // InternalJDL.g:431:55: (iv_ruleJdlStringField= ruleJdlStringField EOF )
            // InternalJDL.g:432:2: iv_ruleJdlStringField= ruleJdlStringField EOF
            {
             newCompositeNode(grammarAccess.getJdlStringFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlStringField=ruleJdlStringField();

            state._fsp--;

             current =iv_ruleJdlStringField; 
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
    // $ANTLR end "entryRuleJdlStringField"


    // $ANTLR start "ruleJdlStringField"
    // InternalJDL.g:438:1: ruleJdlStringField returns [EObject current=null] : ( ( (lv_stringType_0_0= 'String' ) ) ( (lv_validators_1_0= ruleJdlStringValidators ) )? ) ;
    public final EObject ruleJdlStringField() throws RecognitionException {
        EObject current = null;

        Token lv_stringType_0_0=null;
        EObject lv_validators_1_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:444:2: ( ( ( (lv_stringType_0_0= 'String' ) ) ( (lv_validators_1_0= ruleJdlStringValidators ) )? ) )
            // InternalJDL.g:445:2: ( ( (lv_stringType_0_0= 'String' ) ) ( (lv_validators_1_0= ruleJdlStringValidators ) )? )
            {
            // InternalJDL.g:445:2: ( ( (lv_stringType_0_0= 'String' ) ) ( (lv_validators_1_0= ruleJdlStringValidators ) )? )
            // InternalJDL.g:446:3: ( (lv_stringType_0_0= 'String' ) ) ( (lv_validators_1_0= ruleJdlStringValidators ) )?
            {
            // InternalJDL.g:446:3: ( (lv_stringType_0_0= 'String' ) )
            // InternalJDL.g:447:4: (lv_stringType_0_0= 'String' )
            {
            // InternalJDL.g:447:4: (lv_stringType_0_0= 'String' )
            // InternalJDL.g:448:5: lv_stringType_0_0= 'String'
            {
            lv_stringType_0_0=(Token)match(input,15,FOLLOW_9); 

            					newLeafNode(lv_stringType_0_0, grammarAccess.getJdlStringFieldAccess().getStringTypeStringKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJdlStringFieldRule());
            					}
            					setWithLastConsumed(current, "stringType", true, "String");
            				

            }


            }

            // InternalJDL.g:460:3: ( (lv_validators_1_0= ruleJdlStringValidators ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==19) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalJDL.g:461:4: (lv_validators_1_0= ruleJdlStringValidators )
                    {
                    // InternalJDL.g:461:4: (lv_validators_1_0= ruleJdlStringValidators )
                    // InternalJDL.g:462:5: lv_validators_1_0= ruleJdlStringValidators
                    {

                    					newCompositeNode(grammarAccess.getJdlStringFieldAccess().getValidatorsJdlStringValidatorsParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_1_0=ruleJdlStringValidators();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getJdlStringFieldRule());
                    					}
                    					set(
                    						current,
                    						"validators",
                    						lv_validators_1_0,
                    						"io.github.jhipster.jdl.JDL.JdlStringValidators");
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
    // $ANTLR end "ruleJdlStringField"


    // $ANTLR start "entryRuleJdlNumericField"
    // InternalJDL.g:483:1: entryRuleJdlNumericField returns [EObject current=null] : iv_ruleJdlNumericField= ruleJdlNumericField EOF ;
    public final EObject entryRuleJdlNumericField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJdlNumericField = null;


        try {
            // InternalJDL.g:483:56: (iv_ruleJdlNumericField= ruleJdlNumericField EOF )
            // InternalJDL.g:484:2: iv_ruleJdlNumericField= ruleJdlNumericField EOF
            {
             newCompositeNode(grammarAccess.getJdlNumericFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlNumericField=ruleJdlNumericField();

            state._fsp--;

             current =iv_ruleJdlNumericField; 
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
    // $ANTLR end "entryRuleJdlNumericField"


    // $ANTLR start "ruleJdlNumericField"
    // InternalJDL.g:490:1: ruleJdlNumericField returns [EObject current=null] : ( ( (lv_numericFieldType_0_0= ruleJdlNumericFieldType ) ) ( (lv_validators_1_0= ruleJdlNumericValidators ) )? ) ;
    public final EObject ruleJdlNumericField() throws RecognitionException {
        EObject current = null;

        Enumerator lv_numericFieldType_0_0 = null;

        EObject lv_validators_1_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:496:2: ( ( ( (lv_numericFieldType_0_0= ruleJdlNumericFieldType ) ) ( (lv_validators_1_0= ruleJdlNumericValidators ) )? ) )
            // InternalJDL.g:497:2: ( ( (lv_numericFieldType_0_0= ruleJdlNumericFieldType ) ) ( (lv_validators_1_0= ruleJdlNumericValidators ) )? )
            {
            // InternalJDL.g:497:2: ( ( (lv_numericFieldType_0_0= ruleJdlNumericFieldType ) ) ( (lv_validators_1_0= ruleJdlNumericValidators ) )? )
            // InternalJDL.g:498:3: ( (lv_numericFieldType_0_0= ruleJdlNumericFieldType ) ) ( (lv_validators_1_0= ruleJdlNumericValidators ) )?
            {
            // InternalJDL.g:498:3: ( (lv_numericFieldType_0_0= ruleJdlNumericFieldType ) )
            // InternalJDL.g:499:4: (lv_numericFieldType_0_0= ruleJdlNumericFieldType )
            {
            // InternalJDL.g:499:4: (lv_numericFieldType_0_0= ruleJdlNumericFieldType )
            // InternalJDL.g:500:5: lv_numericFieldType_0_0= ruleJdlNumericFieldType
            {

            					newCompositeNode(grammarAccess.getJdlNumericFieldAccess().getNumericFieldTypeJdlNumericFieldTypeEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_9);
            lv_numericFieldType_0_0=ruleJdlNumericFieldType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJdlNumericFieldRule());
            					}
            					set(
            						current,
            						"numericFieldType",
            						lv_numericFieldType_0_0,
            						"io.github.jhipster.jdl.JDL.JdlNumericFieldType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalJDL.g:517:3: ( (lv_validators_1_0= ruleJdlNumericValidators ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==19) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalJDL.g:518:4: (lv_validators_1_0= ruleJdlNumericValidators )
                    {
                    // InternalJDL.g:518:4: (lv_validators_1_0= ruleJdlNumericValidators )
                    // InternalJDL.g:519:5: lv_validators_1_0= ruleJdlNumericValidators
                    {

                    					newCompositeNode(grammarAccess.getJdlNumericFieldAccess().getValidatorsJdlNumericValidatorsParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_1_0=ruleJdlNumericValidators();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getJdlNumericFieldRule());
                    					}
                    					set(
                    						current,
                    						"validators",
                    						lv_validators_1_0,
                    						"io.github.jhipster.jdl.JDL.JdlNumericValidators");
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
    // $ANTLR end "ruleJdlNumericField"


    // $ANTLR start "entryRuleJdlBooleanField"
    // InternalJDL.g:540:1: entryRuleJdlBooleanField returns [EObject current=null] : iv_ruleJdlBooleanField= ruleJdlBooleanField EOF ;
    public final EObject entryRuleJdlBooleanField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJdlBooleanField = null;


        try {
            // InternalJDL.g:540:56: (iv_ruleJdlBooleanField= ruleJdlBooleanField EOF )
            // InternalJDL.g:541:2: iv_ruleJdlBooleanField= ruleJdlBooleanField EOF
            {
             newCompositeNode(grammarAccess.getJdlBooleanFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlBooleanField=ruleJdlBooleanField();

            state._fsp--;

             current =iv_ruleJdlBooleanField; 
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
    // $ANTLR end "entryRuleJdlBooleanField"


    // $ANTLR start "ruleJdlBooleanField"
    // InternalJDL.g:547:1: ruleJdlBooleanField returns [EObject current=null] : ( ( (lv_booleanType_0_0= 'Boolean' ) ) ( (lv_validators_1_0= ruleJdlRequiredValidator ) )? ) ;
    public final EObject ruleJdlBooleanField() throws RecognitionException {
        EObject current = null;

        Token lv_booleanType_0_0=null;
        EObject lv_validators_1_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:553:2: ( ( ( (lv_booleanType_0_0= 'Boolean' ) ) ( (lv_validators_1_0= ruleJdlRequiredValidator ) )? ) )
            // InternalJDL.g:554:2: ( ( (lv_booleanType_0_0= 'Boolean' ) ) ( (lv_validators_1_0= ruleJdlRequiredValidator ) )? )
            {
            // InternalJDL.g:554:2: ( ( (lv_booleanType_0_0= 'Boolean' ) ) ( (lv_validators_1_0= ruleJdlRequiredValidator ) )? )
            // InternalJDL.g:555:3: ( (lv_booleanType_0_0= 'Boolean' ) ) ( (lv_validators_1_0= ruleJdlRequiredValidator ) )?
            {
            // InternalJDL.g:555:3: ( (lv_booleanType_0_0= 'Boolean' ) )
            // InternalJDL.g:556:4: (lv_booleanType_0_0= 'Boolean' )
            {
            // InternalJDL.g:556:4: (lv_booleanType_0_0= 'Boolean' )
            // InternalJDL.g:557:5: lv_booleanType_0_0= 'Boolean'
            {
            lv_booleanType_0_0=(Token)match(input,16,FOLLOW_9); 

            					newLeafNode(lv_booleanType_0_0, grammarAccess.getJdlBooleanFieldAccess().getBooleanTypeBooleanKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJdlBooleanFieldRule());
            					}
            					setWithLastConsumed(current, "booleanType", true, "Boolean");
            				

            }


            }

            // InternalJDL.g:569:3: ( (lv_validators_1_0= ruleJdlRequiredValidator ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==19) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalJDL.g:570:4: (lv_validators_1_0= ruleJdlRequiredValidator )
                    {
                    // InternalJDL.g:570:4: (lv_validators_1_0= ruleJdlRequiredValidator )
                    // InternalJDL.g:571:5: lv_validators_1_0= ruleJdlRequiredValidator
                    {

                    					newCompositeNode(grammarAccess.getJdlBooleanFieldAccess().getValidatorsJdlRequiredValidatorParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_1_0=ruleJdlRequiredValidator();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getJdlBooleanFieldRule());
                    					}
                    					set(
                    						current,
                    						"validators",
                    						lv_validators_1_0,
                    						"io.github.jhipster.jdl.JDL.JdlRequiredValidator");
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
    // $ANTLR end "ruleJdlBooleanField"


    // $ANTLR start "entryRuleJdlDateField"
    // InternalJDL.g:592:1: entryRuleJdlDateField returns [EObject current=null] : iv_ruleJdlDateField= ruleJdlDateField EOF ;
    public final EObject entryRuleJdlDateField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJdlDateField = null;


        try {
            // InternalJDL.g:592:53: (iv_ruleJdlDateField= ruleJdlDateField EOF )
            // InternalJDL.g:593:2: iv_ruleJdlDateField= ruleJdlDateField EOF
            {
             newCompositeNode(grammarAccess.getJdlDateFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlDateField=ruleJdlDateField();

            state._fsp--;

             current =iv_ruleJdlDateField; 
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
    // $ANTLR end "entryRuleJdlDateField"


    // $ANTLR start "ruleJdlDateField"
    // InternalJDL.g:599:1: ruleJdlDateField returns [EObject current=null] : ( ( ( (lv_localDateType_0_0= 'LocalDate' ) ) | ( (lv_zonedDateTimeType_1_0= 'ZonedDateTime' ) ) ) ( (lv_validators_2_0= ruleJdlRequiredValidator ) )? ) ;
    public final EObject ruleJdlDateField() throws RecognitionException {
        EObject current = null;

        Token lv_localDateType_0_0=null;
        Token lv_zonedDateTimeType_1_0=null;
        EObject lv_validators_2_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:605:2: ( ( ( ( (lv_localDateType_0_0= 'LocalDate' ) ) | ( (lv_zonedDateTimeType_1_0= 'ZonedDateTime' ) ) ) ( (lv_validators_2_0= ruleJdlRequiredValidator ) )? ) )
            // InternalJDL.g:606:2: ( ( ( (lv_localDateType_0_0= 'LocalDate' ) ) | ( (lv_zonedDateTimeType_1_0= 'ZonedDateTime' ) ) ) ( (lv_validators_2_0= ruleJdlRequiredValidator ) )? )
            {
            // InternalJDL.g:606:2: ( ( ( (lv_localDateType_0_0= 'LocalDate' ) ) | ( (lv_zonedDateTimeType_1_0= 'ZonedDateTime' ) ) ) ( (lv_validators_2_0= ruleJdlRequiredValidator ) )? )
            // InternalJDL.g:607:3: ( ( (lv_localDateType_0_0= 'LocalDate' ) ) | ( (lv_zonedDateTimeType_1_0= 'ZonedDateTime' ) ) ) ( (lv_validators_2_0= ruleJdlRequiredValidator ) )?
            {
            // InternalJDL.g:607:3: ( ( (lv_localDateType_0_0= 'LocalDate' ) ) | ( (lv_zonedDateTimeType_1_0= 'ZonedDateTime' ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==17) ) {
                alt11=1;
            }
            else if ( (LA11_0==18) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalJDL.g:608:4: ( (lv_localDateType_0_0= 'LocalDate' ) )
                    {
                    // InternalJDL.g:608:4: ( (lv_localDateType_0_0= 'LocalDate' ) )
                    // InternalJDL.g:609:5: (lv_localDateType_0_0= 'LocalDate' )
                    {
                    // InternalJDL.g:609:5: (lv_localDateType_0_0= 'LocalDate' )
                    // InternalJDL.g:610:6: lv_localDateType_0_0= 'LocalDate'
                    {
                    lv_localDateType_0_0=(Token)match(input,17,FOLLOW_9); 

                    						newLeafNode(lv_localDateType_0_0, grammarAccess.getJdlDateFieldAccess().getLocalDateTypeLocalDateKeyword_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getJdlDateFieldRule());
                    						}
                    						setWithLastConsumed(current, "localDateType", true, "LocalDate");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalJDL.g:623:4: ( (lv_zonedDateTimeType_1_0= 'ZonedDateTime' ) )
                    {
                    // InternalJDL.g:623:4: ( (lv_zonedDateTimeType_1_0= 'ZonedDateTime' ) )
                    // InternalJDL.g:624:5: (lv_zonedDateTimeType_1_0= 'ZonedDateTime' )
                    {
                    // InternalJDL.g:624:5: (lv_zonedDateTimeType_1_0= 'ZonedDateTime' )
                    // InternalJDL.g:625:6: lv_zonedDateTimeType_1_0= 'ZonedDateTime'
                    {
                    lv_zonedDateTimeType_1_0=(Token)match(input,18,FOLLOW_9); 

                    						newLeafNode(lv_zonedDateTimeType_1_0, grammarAccess.getJdlDateFieldAccess().getZonedDateTimeTypeZonedDateTimeKeyword_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getJdlDateFieldRule());
                    						}
                    						setWithLastConsumed(current, "zonedDateTimeType", true, "ZonedDateTime");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalJDL.g:638:3: ( (lv_validators_2_0= ruleJdlRequiredValidator ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==19) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalJDL.g:639:4: (lv_validators_2_0= ruleJdlRequiredValidator )
                    {
                    // InternalJDL.g:639:4: (lv_validators_2_0= ruleJdlRequiredValidator )
                    // InternalJDL.g:640:5: lv_validators_2_0= ruleJdlRequiredValidator
                    {

                    					newCompositeNode(grammarAccess.getJdlDateFieldAccess().getValidatorsJdlRequiredValidatorParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_2_0=ruleJdlRequiredValidator();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getJdlDateFieldRule());
                    					}
                    					set(
                    						current,
                    						"validators",
                    						lv_validators_2_0,
                    						"io.github.jhipster.jdl.JDL.JdlRequiredValidator");
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
    // $ANTLR end "ruleJdlDateField"


    // $ANTLR start "entryRuleJdlBlobField"
    // InternalJDL.g:661:1: entryRuleJdlBlobField returns [EObject current=null] : iv_ruleJdlBlobField= ruleJdlBlobField EOF ;
    public final EObject entryRuleJdlBlobField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJdlBlobField = null;


        try {
            // InternalJDL.g:661:53: (iv_ruleJdlBlobField= ruleJdlBlobField EOF )
            // InternalJDL.g:662:2: iv_ruleJdlBlobField= ruleJdlBlobField EOF
            {
             newCompositeNode(grammarAccess.getJdlBlobFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlBlobField=ruleJdlBlobField();

            state._fsp--;

             current =iv_ruleJdlBlobField; 
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
    // $ANTLR end "entryRuleJdlBlobField"


    // $ANTLR start "ruleJdlBlobField"
    // InternalJDL.g:668:1: ruleJdlBlobField returns [EObject current=null] : ( ( (lv_blobFieldType_0_0= ruleJdlBlobFieldType ) ) ( (lv_validators_1_0= ruleJdlBlobValidators ) )? ) ;
    public final EObject ruleJdlBlobField() throws RecognitionException {
        EObject current = null;

        Enumerator lv_blobFieldType_0_0 = null;

        EObject lv_validators_1_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:674:2: ( ( ( (lv_blobFieldType_0_0= ruleJdlBlobFieldType ) ) ( (lv_validators_1_0= ruleJdlBlobValidators ) )? ) )
            // InternalJDL.g:675:2: ( ( (lv_blobFieldType_0_0= ruleJdlBlobFieldType ) ) ( (lv_validators_1_0= ruleJdlBlobValidators ) )? )
            {
            // InternalJDL.g:675:2: ( ( (lv_blobFieldType_0_0= ruleJdlBlobFieldType ) ) ( (lv_validators_1_0= ruleJdlBlobValidators ) )? )
            // InternalJDL.g:676:3: ( (lv_blobFieldType_0_0= ruleJdlBlobFieldType ) ) ( (lv_validators_1_0= ruleJdlBlobValidators ) )?
            {
            // InternalJDL.g:676:3: ( (lv_blobFieldType_0_0= ruleJdlBlobFieldType ) )
            // InternalJDL.g:677:4: (lv_blobFieldType_0_0= ruleJdlBlobFieldType )
            {
            // InternalJDL.g:677:4: (lv_blobFieldType_0_0= ruleJdlBlobFieldType )
            // InternalJDL.g:678:5: lv_blobFieldType_0_0= ruleJdlBlobFieldType
            {

            					newCompositeNode(grammarAccess.getJdlBlobFieldAccess().getBlobFieldTypeJdlBlobFieldTypeEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_9);
            lv_blobFieldType_0_0=ruleJdlBlobFieldType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJdlBlobFieldRule());
            					}
            					set(
            						current,
            						"blobFieldType",
            						lv_blobFieldType_0_0,
            						"io.github.jhipster.jdl.JDL.JdlBlobFieldType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalJDL.g:695:3: ( (lv_validators_1_0= ruleJdlBlobValidators ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==19) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalJDL.g:696:4: (lv_validators_1_0= ruleJdlBlobValidators )
                    {
                    // InternalJDL.g:696:4: (lv_validators_1_0= ruleJdlBlobValidators )
                    // InternalJDL.g:697:5: lv_validators_1_0= ruleJdlBlobValidators
                    {

                    					newCompositeNode(grammarAccess.getJdlBlobFieldAccess().getValidatorsJdlBlobValidatorsParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_1_0=ruleJdlBlobValidators();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getJdlBlobFieldRule());
                    					}
                    					set(
                    						current,
                    						"validators",
                    						lv_validators_1_0,
                    						"io.github.jhipster.jdl.JDL.JdlBlobValidators");
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
    // $ANTLR end "ruleJdlBlobField"


    // $ANTLR start "entryRuleJdlStringValidators"
    // InternalJDL.g:718:1: entryRuleJdlStringValidators returns [EObject current=null] : iv_ruleJdlStringValidators= ruleJdlStringValidators EOF ;
    public final EObject entryRuleJdlStringValidators() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJdlStringValidators = null;


        try {
            // InternalJDL.g:718:60: (iv_ruleJdlStringValidators= ruleJdlStringValidators EOF )
            // InternalJDL.g:719:2: iv_ruleJdlStringValidators= ruleJdlStringValidators EOF
            {
             newCompositeNode(grammarAccess.getJdlStringValidatorsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlStringValidators=ruleJdlStringValidators();

            state._fsp--;

             current =iv_ruleJdlStringValidators; 
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
    // $ANTLR end "entryRuleJdlStringValidators"


    // $ANTLR start "ruleJdlStringValidators"
    // InternalJDL.g:725:1: ruleJdlStringValidators returns [EObject current=null] : ( ( (lv_required_0_0= ruleJdlRequiredValidator ) ) ( (lv_minLength_1_0= ruleJdlMinLengthValidator ) )? ( (lv_maxlength_2_0= ruleJdlMaxLengthValidator ) )? ( (lv_pattern_3_0= ruleJdlPatternValidator ) )? ) ;
    public final EObject ruleJdlStringValidators() throws RecognitionException {
        EObject current = null;

        EObject lv_required_0_0 = null;

        EObject lv_minLength_1_0 = null;

        EObject lv_maxlength_2_0 = null;

        EObject lv_pattern_3_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:731:2: ( ( ( (lv_required_0_0= ruleJdlRequiredValidator ) ) ( (lv_minLength_1_0= ruleJdlMinLengthValidator ) )? ( (lv_maxlength_2_0= ruleJdlMaxLengthValidator ) )? ( (lv_pattern_3_0= ruleJdlPatternValidator ) )? ) )
            // InternalJDL.g:732:2: ( ( (lv_required_0_0= ruleJdlRequiredValidator ) ) ( (lv_minLength_1_0= ruleJdlMinLengthValidator ) )? ( (lv_maxlength_2_0= ruleJdlMaxLengthValidator ) )? ( (lv_pattern_3_0= ruleJdlPatternValidator ) )? )
            {
            // InternalJDL.g:732:2: ( ( (lv_required_0_0= ruleJdlRequiredValidator ) ) ( (lv_minLength_1_0= ruleJdlMinLengthValidator ) )? ( (lv_maxlength_2_0= ruleJdlMaxLengthValidator ) )? ( (lv_pattern_3_0= ruleJdlPatternValidator ) )? )
            // InternalJDL.g:733:3: ( (lv_required_0_0= ruleJdlRequiredValidator ) ) ( (lv_minLength_1_0= ruleJdlMinLengthValidator ) )? ( (lv_maxlength_2_0= ruleJdlMaxLengthValidator ) )? ( (lv_pattern_3_0= ruleJdlPatternValidator ) )?
            {
            // InternalJDL.g:733:3: ( (lv_required_0_0= ruleJdlRequiredValidator ) )
            // InternalJDL.g:734:4: (lv_required_0_0= ruleJdlRequiredValidator )
            {
            // InternalJDL.g:734:4: (lv_required_0_0= ruleJdlRequiredValidator )
            // InternalJDL.g:735:5: lv_required_0_0= ruleJdlRequiredValidator
            {

            					newCompositeNode(grammarAccess.getJdlStringValidatorsAccess().getRequiredJdlRequiredValidatorParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_10);
            lv_required_0_0=ruleJdlRequiredValidator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJdlStringValidatorsRule());
            					}
            					set(
            						current,
            						"required",
            						true,
            						"io.github.jhipster.jdl.JDL.JdlRequiredValidator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalJDL.g:752:3: ( (lv_minLength_1_0= ruleJdlMinLengthValidator ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==20) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalJDL.g:753:4: (lv_minLength_1_0= ruleJdlMinLengthValidator )
                    {
                    // InternalJDL.g:753:4: (lv_minLength_1_0= ruleJdlMinLengthValidator )
                    // InternalJDL.g:754:5: lv_minLength_1_0= ruleJdlMinLengthValidator
                    {

                    					newCompositeNode(grammarAccess.getJdlStringValidatorsAccess().getMinLengthJdlMinLengthValidatorParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_11);
                    lv_minLength_1_0=ruleJdlMinLengthValidator();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getJdlStringValidatorsRule());
                    					}
                    					set(
                    						current,
                    						"minLength",
                    						lv_minLength_1_0,
                    						"io.github.jhipster.jdl.JDL.JdlMinLengthValidator");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalJDL.g:771:3: ( (lv_maxlength_2_0= ruleJdlMaxLengthValidator ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==23) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalJDL.g:772:4: (lv_maxlength_2_0= ruleJdlMaxLengthValidator )
                    {
                    // InternalJDL.g:772:4: (lv_maxlength_2_0= ruleJdlMaxLengthValidator )
                    // InternalJDL.g:773:5: lv_maxlength_2_0= ruleJdlMaxLengthValidator
                    {

                    					newCompositeNode(grammarAccess.getJdlStringValidatorsAccess().getMaxlengthJdlMaxLengthValidatorParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_12);
                    lv_maxlength_2_0=ruleJdlMaxLengthValidator();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getJdlStringValidatorsRule());
                    					}
                    					set(
                    						current,
                    						"maxlength",
                    						lv_maxlength_2_0,
                    						"io.github.jhipster.jdl.JDL.JdlMaxLengthValidator");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalJDL.g:790:3: ( (lv_pattern_3_0= ruleJdlPatternValidator ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==24) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalJDL.g:791:4: (lv_pattern_3_0= ruleJdlPatternValidator )
                    {
                    // InternalJDL.g:791:4: (lv_pattern_3_0= ruleJdlPatternValidator )
                    // InternalJDL.g:792:5: lv_pattern_3_0= ruleJdlPatternValidator
                    {

                    					newCompositeNode(grammarAccess.getJdlStringValidatorsAccess().getPatternJdlPatternValidatorParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_pattern_3_0=ruleJdlPatternValidator();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getJdlStringValidatorsRule());
                    					}
                    					set(
                    						current,
                    						"pattern",
                    						lv_pattern_3_0,
                    						"io.github.jhipster.jdl.JDL.JdlPatternValidator");
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
    // $ANTLR end "ruleJdlStringValidators"


    // $ANTLR start "entryRuleJdlNumericValidators"
    // InternalJDL.g:813:1: entryRuleJdlNumericValidators returns [EObject current=null] : iv_ruleJdlNumericValidators= ruleJdlNumericValidators EOF ;
    public final EObject entryRuleJdlNumericValidators() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJdlNumericValidators = null;


        try {
            // InternalJDL.g:813:61: (iv_ruleJdlNumericValidators= ruleJdlNumericValidators EOF )
            // InternalJDL.g:814:2: iv_ruleJdlNumericValidators= ruleJdlNumericValidators EOF
            {
             newCompositeNode(grammarAccess.getJdlNumericValidatorsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlNumericValidators=ruleJdlNumericValidators();

            state._fsp--;

             current =iv_ruleJdlNumericValidators; 
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
    // $ANTLR end "entryRuleJdlNumericValidators"


    // $ANTLR start "ruleJdlNumericValidators"
    // InternalJDL.g:820:1: ruleJdlNumericValidators returns [EObject current=null] : ( ( (lv_required_0_0= ruleJdlRequiredValidator ) ) ( (lv_minlength_1_0= ruleJdlMinValidator ) )? ( (lv_maxlength_2_0= ruleJdlMaxValidator ) )? ) ;
    public final EObject ruleJdlNumericValidators() throws RecognitionException {
        EObject current = null;

        EObject lv_required_0_0 = null;

        EObject lv_minlength_1_0 = null;

        EObject lv_maxlength_2_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:826:2: ( ( ( (lv_required_0_0= ruleJdlRequiredValidator ) ) ( (lv_minlength_1_0= ruleJdlMinValidator ) )? ( (lv_maxlength_2_0= ruleJdlMaxValidator ) )? ) )
            // InternalJDL.g:827:2: ( ( (lv_required_0_0= ruleJdlRequiredValidator ) ) ( (lv_minlength_1_0= ruleJdlMinValidator ) )? ( (lv_maxlength_2_0= ruleJdlMaxValidator ) )? )
            {
            // InternalJDL.g:827:2: ( ( (lv_required_0_0= ruleJdlRequiredValidator ) ) ( (lv_minlength_1_0= ruleJdlMinValidator ) )? ( (lv_maxlength_2_0= ruleJdlMaxValidator ) )? )
            // InternalJDL.g:828:3: ( (lv_required_0_0= ruleJdlRequiredValidator ) ) ( (lv_minlength_1_0= ruleJdlMinValidator ) )? ( (lv_maxlength_2_0= ruleJdlMaxValidator ) )?
            {
            // InternalJDL.g:828:3: ( (lv_required_0_0= ruleJdlRequiredValidator ) )
            // InternalJDL.g:829:4: (lv_required_0_0= ruleJdlRequiredValidator )
            {
            // InternalJDL.g:829:4: (lv_required_0_0= ruleJdlRequiredValidator )
            // InternalJDL.g:830:5: lv_required_0_0= ruleJdlRequiredValidator
            {

            					newCompositeNode(grammarAccess.getJdlNumericValidatorsAccess().getRequiredJdlRequiredValidatorParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_13);
            lv_required_0_0=ruleJdlRequiredValidator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJdlNumericValidatorsRule());
            					}
            					set(
            						current,
            						"required",
            						lv_required_0_0,
            						"io.github.jhipster.jdl.JDL.JdlRequiredValidator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalJDL.g:847:3: ( (lv_minlength_1_0= ruleJdlMinValidator ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==25) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalJDL.g:848:4: (lv_minlength_1_0= ruleJdlMinValidator )
                    {
                    // InternalJDL.g:848:4: (lv_minlength_1_0= ruleJdlMinValidator )
                    // InternalJDL.g:849:5: lv_minlength_1_0= ruleJdlMinValidator
                    {

                    					newCompositeNode(grammarAccess.getJdlNumericValidatorsAccess().getMinlengthJdlMinValidatorParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_14);
                    lv_minlength_1_0=ruleJdlMinValidator();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getJdlNumericValidatorsRule());
                    					}
                    					set(
                    						current,
                    						"minlength",
                    						lv_minlength_1_0,
                    						"io.github.jhipster.jdl.JDL.JdlMinValidator");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalJDL.g:866:3: ( (lv_maxlength_2_0= ruleJdlMaxValidator ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==26) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalJDL.g:867:4: (lv_maxlength_2_0= ruleJdlMaxValidator )
                    {
                    // InternalJDL.g:867:4: (lv_maxlength_2_0= ruleJdlMaxValidator )
                    // InternalJDL.g:868:5: lv_maxlength_2_0= ruleJdlMaxValidator
                    {

                    					newCompositeNode(grammarAccess.getJdlNumericValidatorsAccess().getMaxlengthJdlMaxValidatorParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_maxlength_2_0=ruleJdlMaxValidator();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getJdlNumericValidatorsRule());
                    					}
                    					set(
                    						current,
                    						"maxlength",
                    						lv_maxlength_2_0,
                    						"io.github.jhipster.jdl.JDL.JdlMaxValidator");
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
    // $ANTLR end "ruleJdlNumericValidators"


    // $ANTLR start "entryRuleJdlBlobValidators"
    // InternalJDL.g:889:1: entryRuleJdlBlobValidators returns [EObject current=null] : iv_ruleJdlBlobValidators= ruleJdlBlobValidators EOF ;
    public final EObject entryRuleJdlBlobValidators() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJdlBlobValidators = null;


        try {
            // InternalJDL.g:889:58: (iv_ruleJdlBlobValidators= ruleJdlBlobValidators EOF )
            // InternalJDL.g:890:2: iv_ruleJdlBlobValidators= ruleJdlBlobValidators EOF
            {
             newCompositeNode(grammarAccess.getJdlBlobValidatorsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlBlobValidators=ruleJdlBlobValidators();

            state._fsp--;

             current =iv_ruleJdlBlobValidators; 
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
    // $ANTLR end "entryRuleJdlBlobValidators"


    // $ANTLR start "ruleJdlBlobValidators"
    // InternalJDL.g:896:1: ruleJdlBlobValidators returns [EObject current=null] : ( ( (lv_required_0_0= ruleJdlRequiredValidator ) ) ( (lv_minbytes_1_0= ruleJdlMinBytesValidator ) )? ( (lv_maxbytes_2_0= ruleJdlMaxBytesValidator ) )? ) ;
    public final EObject ruleJdlBlobValidators() throws RecognitionException {
        EObject current = null;

        EObject lv_required_0_0 = null;

        EObject lv_minbytes_1_0 = null;

        EObject lv_maxbytes_2_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:902:2: ( ( ( (lv_required_0_0= ruleJdlRequiredValidator ) ) ( (lv_minbytes_1_0= ruleJdlMinBytesValidator ) )? ( (lv_maxbytes_2_0= ruleJdlMaxBytesValidator ) )? ) )
            // InternalJDL.g:903:2: ( ( (lv_required_0_0= ruleJdlRequiredValidator ) ) ( (lv_minbytes_1_0= ruleJdlMinBytesValidator ) )? ( (lv_maxbytes_2_0= ruleJdlMaxBytesValidator ) )? )
            {
            // InternalJDL.g:903:2: ( ( (lv_required_0_0= ruleJdlRequiredValidator ) ) ( (lv_minbytes_1_0= ruleJdlMinBytesValidator ) )? ( (lv_maxbytes_2_0= ruleJdlMaxBytesValidator ) )? )
            // InternalJDL.g:904:3: ( (lv_required_0_0= ruleJdlRequiredValidator ) ) ( (lv_minbytes_1_0= ruleJdlMinBytesValidator ) )? ( (lv_maxbytes_2_0= ruleJdlMaxBytesValidator ) )?
            {
            // InternalJDL.g:904:3: ( (lv_required_0_0= ruleJdlRequiredValidator ) )
            // InternalJDL.g:905:4: (lv_required_0_0= ruleJdlRequiredValidator )
            {
            // InternalJDL.g:905:4: (lv_required_0_0= ruleJdlRequiredValidator )
            // InternalJDL.g:906:5: lv_required_0_0= ruleJdlRequiredValidator
            {

            					newCompositeNode(grammarAccess.getJdlBlobValidatorsAccess().getRequiredJdlRequiredValidatorParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_15);
            lv_required_0_0=ruleJdlRequiredValidator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJdlBlobValidatorsRule());
            					}
            					set(
            						current,
            						"required",
            						lv_required_0_0,
            						"io.github.jhipster.jdl.JDL.JdlRequiredValidator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalJDL.g:923:3: ( (lv_minbytes_1_0= ruleJdlMinBytesValidator ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==27) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalJDL.g:924:4: (lv_minbytes_1_0= ruleJdlMinBytesValidator )
                    {
                    // InternalJDL.g:924:4: (lv_minbytes_1_0= ruleJdlMinBytesValidator )
                    // InternalJDL.g:925:5: lv_minbytes_1_0= ruleJdlMinBytesValidator
                    {

                    					newCompositeNode(grammarAccess.getJdlBlobValidatorsAccess().getMinbytesJdlMinBytesValidatorParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_16);
                    lv_minbytes_1_0=ruleJdlMinBytesValidator();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getJdlBlobValidatorsRule());
                    					}
                    					set(
                    						current,
                    						"minbytes",
                    						lv_minbytes_1_0,
                    						"io.github.jhipster.jdl.JDL.JdlMinBytesValidator");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalJDL.g:942:3: ( (lv_maxbytes_2_0= ruleJdlMaxBytesValidator ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==28) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalJDL.g:943:4: (lv_maxbytes_2_0= ruleJdlMaxBytesValidator )
                    {
                    // InternalJDL.g:943:4: (lv_maxbytes_2_0= ruleJdlMaxBytesValidator )
                    // InternalJDL.g:944:5: lv_maxbytes_2_0= ruleJdlMaxBytesValidator
                    {

                    					newCompositeNode(grammarAccess.getJdlBlobValidatorsAccess().getMaxbytesJdlMaxBytesValidatorParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_maxbytes_2_0=ruleJdlMaxBytesValidator();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getJdlBlobValidatorsRule());
                    					}
                    					set(
                    						current,
                    						"maxbytes",
                    						lv_maxbytes_2_0,
                    						"io.github.jhipster.jdl.JDL.JdlMaxBytesValidator");
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
    // $ANTLR end "ruleJdlBlobValidators"


    // $ANTLR start "entryRuleJdlRequiredValidator"
    // InternalJDL.g:965:1: entryRuleJdlRequiredValidator returns [EObject current=null] : iv_ruleJdlRequiredValidator= ruleJdlRequiredValidator EOF ;
    public final EObject entryRuleJdlRequiredValidator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJdlRequiredValidator = null;


        try {
            // InternalJDL.g:965:61: (iv_ruleJdlRequiredValidator= ruleJdlRequiredValidator EOF )
            // InternalJDL.g:966:2: iv_ruleJdlRequiredValidator= ruleJdlRequiredValidator EOF
            {
             newCompositeNode(grammarAccess.getJdlRequiredValidatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlRequiredValidator=ruleJdlRequiredValidator();

            state._fsp--;

             current =iv_ruleJdlRequiredValidator; 
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
    // $ANTLR end "entryRuleJdlRequiredValidator"


    // $ANTLR start "ruleJdlRequiredValidator"
    // InternalJDL.g:972:1: ruleJdlRequiredValidator returns [EObject current=null] : ( (lv_required_0_0= 'required' ) ) ;
    public final EObject ruleJdlRequiredValidator() throws RecognitionException {
        EObject current = null;

        Token lv_required_0_0=null;


        	enterRule();

        try {
            // InternalJDL.g:978:2: ( ( (lv_required_0_0= 'required' ) ) )
            // InternalJDL.g:979:2: ( (lv_required_0_0= 'required' ) )
            {
            // InternalJDL.g:979:2: ( (lv_required_0_0= 'required' ) )
            // InternalJDL.g:980:3: (lv_required_0_0= 'required' )
            {
            // InternalJDL.g:980:3: (lv_required_0_0= 'required' )
            // InternalJDL.g:981:4: lv_required_0_0= 'required'
            {
            lv_required_0_0=(Token)match(input,19,FOLLOW_2); 

            				newLeafNode(lv_required_0_0, grammarAccess.getJdlRequiredValidatorAccess().getRequiredRequiredKeyword_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getJdlRequiredValidatorRule());
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
    // $ANTLR end "ruleJdlRequiredValidator"


    // $ANTLR start "entryRuleJdlMinLengthValidator"
    // InternalJDL.g:996:1: entryRuleJdlMinLengthValidator returns [EObject current=null] : iv_ruleJdlMinLengthValidator= ruleJdlMinLengthValidator EOF ;
    public final EObject entryRuleJdlMinLengthValidator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJdlMinLengthValidator = null;


        try {
            // InternalJDL.g:996:62: (iv_ruleJdlMinLengthValidator= ruleJdlMinLengthValidator EOF )
            // InternalJDL.g:997:2: iv_ruleJdlMinLengthValidator= ruleJdlMinLengthValidator EOF
            {
             newCompositeNode(grammarAccess.getJdlMinLengthValidatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlMinLengthValidator=ruleJdlMinLengthValidator();

            state._fsp--;

             current =iv_ruleJdlMinLengthValidator; 
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
    // $ANTLR end "entryRuleJdlMinLengthValidator"


    // $ANTLR start "ruleJdlMinLengthValidator"
    // InternalJDL.g:1003:1: ruleJdlMinLengthValidator returns [EObject current=null] : (otherlv_0= 'minlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final EObject ruleJdlMinLengthValidator() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalJDL.g:1009:2: ( (otherlv_0= 'minlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // InternalJDL.g:1010:2: (otherlv_0= 'minlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // InternalJDL.g:1010:2: (otherlv_0= 'minlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            // InternalJDL.g:1011:3: otherlv_0= 'minlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,20,FOLLOW_17); 

            			newLeafNode(otherlv_0, grammarAccess.getJdlMinLengthValidatorAccess().getMinlengthKeyword_0());
            		
            otherlv_1=(Token)match(input,21,FOLLOW_18); 

            			newLeafNode(otherlv_1, grammarAccess.getJdlMinLengthValidatorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalJDL.g:1019:3: ( (lv_value_2_0= RULE_INT ) )
            // InternalJDL.g:1020:4: (lv_value_2_0= RULE_INT )
            {
            // InternalJDL.g:1020:4: (lv_value_2_0= RULE_INT )
            // InternalJDL.g:1021:5: lv_value_2_0= RULE_INT
            {
            lv_value_2_0=(Token)match(input,RULE_INT,FOLLOW_19); 

            					newLeafNode(lv_value_2_0, grammarAccess.getJdlMinLengthValidatorAccess().getValueINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJdlMinLengthValidatorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_3=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getJdlMinLengthValidatorAccess().getRightParenthesisKeyword_3());
            		

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
    // $ANTLR end "ruleJdlMinLengthValidator"


    // $ANTLR start "entryRuleJdlMaxLengthValidator"
    // InternalJDL.g:1045:1: entryRuleJdlMaxLengthValidator returns [EObject current=null] : iv_ruleJdlMaxLengthValidator= ruleJdlMaxLengthValidator EOF ;
    public final EObject entryRuleJdlMaxLengthValidator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJdlMaxLengthValidator = null;


        try {
            // InternalJDL.g:1045:62: (iv_ruleJdlMaxLengthValidator= ruleJdlMaxLengthValidator EOF )
            // InternalJDL.g:1046:2: iv_ruleJdlMaxLengthValidator= ruleJdlMaxLengthValidator EOF
            {
             newCompositeNode(grammarAccess.getJdlMaxLengthValidatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlMaxLengthValidator=ruleJdlMaxLengthValidator();

            state._fsp--;

             current =iv_ruleJdlMaxLengthValidator; 
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
    // $ANTLR end "entryRuleJdlMaxLengthValidator"


    // $ANTLR start "ruleJdlMaxLengthValidator"
    // InternalJDL.g:1052:1: ruleJdlMaxLengthValidator returns [EObject current=null] : (otherlv_0= 'maxlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final EObject ruleJdlMaxLengthValidator() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalJDL.g:1058:2: ( (otherlv_0= 'maxlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // InternalJDL.g:1059:2: (otherlv_0= 'maxlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // InternalJDL.g:1059:2: (otherlv_0= 'maxlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            // InternalJDL.g:1060:3: otherlv_0= 'maxlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_17); 

            			newLeafNode(otherlv_0, grammarAccess.getJdlMaxLengthValidatorAccess().getMaxlengthKeyword_0());
            		
            otherlv_1=(Token)match(input,21,FOLLOW_18); 

            			newLeafNode(otherlv_1, grammarAccess.getJdlMaxLengthValidatorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalJDL.g:1068:3: ( (lv_value_2_0= RULE_INT ) )
            // InternalJDL.g:1069:4: (lv_value_2_0= RULE_INT )
            {
            // InternalJDL.g:1069:4: (lv_value_2_0= RULE_INT )
            // InternalJDL.g:1070:5: lv_value_2_0= RULE_INT
            {
            lv_value_2_0=(Token)match(input,RULE_INT,FOLLOW_19); 

            					newLeafNode(lv_value_2_0, grammarAccess.getJdlMaxLengthValidatorAccess().getValueINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJdlMaxLengthValidatorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_3=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getJdlMaxLengthValidatorAccess().getRightParenthesisKeyword_3());
            		

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
    // $ANTLR end "ruleJdlMaxLengthValidator"


    // $ANTLR start "entryRuleJdlPatternValidator"
    // InternalJDL.g:1094:1: entryRuleJdlPatternValidator returns [EObject current=null] : iv_ruleJdlPatternValidator= ruleJdlPatternValidator EOF ;
    public final EObject entryRuleJdlPatternValidator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJdlPatternValidator = null;


        try {
            // InternalJDL.g:1094:60: (iv_ruleJdlPatternValidator= ruleJdlPatternValidator EOF )
            // InternalJDL.g:1095:2: iv_ruleJdlPatternValidator= ruleJdlPatternValidator EOF
            {
             newCompositeNode(grammarAccess.getJdlPatternValidatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlPatternValidator=ruleJdlPatternValidator();

            state._fsp--;

             current =iv_ruleJdlPatternValidator; 
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
    // $ANTLR end "entryRuleJdlPatternValidator"


    // $ANTLR start "ruleJdlPatternValidator"
    // InternalJDL.g:1101:1: ruleJdlPatternValidator returns [EObject current=null] : (otherlv_0= 'pattern' otherlv_1= '(' ( (lv_value_2_0= RULE_STRING ) ) otherlv_3= ')' ) ;
    public final EObject ruleJdlPatternValidator() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalJDL.g:1107:2: ( (otherlv_0= 'pattern' otherlv_1= '(' ( (lv_value_2_0= RULE_STRING ) ) otherlv_3= ')' ) )
            // InternalJDL.g:1108:2: (otherlv_0= 'pattern' otherlv_1= '(' ( (lv_value_2_0= RULE_STRING ) ) otherlv_3= ')' )
            {
            // InternalJDL.g:1108:2: (otherlv_0= 'pattern' otherlv_1= '(' ( (lv_value_2_0= RULE_STRING ) ) otherlv_3= ')' )
            // InternalJDL.g:1109:3: otherlv_0= 'pattern' otherlv_1= '(' ( (lv_value_2_0= RULE_STRING ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_17); 

            			newLeafNode(otherlv_0, grammarAccess.getJdlPatternValidatorAccess().getPatternKeyword_0());
            		
            otherlv_1=(Token)match(input,21,FOLLOW_20); 

            			newLeafNode(otherlv_1, grammarAccess.getJdlPatternValidatorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalJDL.g:1117:3: ( (lv_value_2_0= RULE_STRING ) )
            // InternalJDL.g:1118:4: (lv_value_2_0= RULE_STRING )
            {
            // InternalJDL.g:1118:4: (lv_value_2_0= RULE_STRING )
            // InternalJDL.g:1119:5: lv_value_2_0= RULE_STRING
            {
            lv_value_2_0=(Token)match(input,RULE_STRING,FOLLOW_19); 

            					newLeafNode(lv_value_2_0, grammarAccess.getJdlPatternValidatorAccess().getValueSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJdlPatternValidatorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_3=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getJdlPatternValidatorAccess().getRightParenthesisKeyword_3());
            		

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
    // $ANTLR end "ruleJdlPatternValidator"


    // $ANTLR start "entryRuleJdlMinValidator"
    // InternalJDL.g:1143:1: entryRuleJdlMinValidator returns [EObject current=null] : iv_ruleJdlMinValidator= ruleJdlMinValidator EOF ;
    public final EObject entryRuleJdlMinValidator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJdlMinValidator = null;


        try {
            // InternalJDL.g:1143:56: (iv_ruleJdlMinValidator= ruleJdlMinValidator EOF )
            // InternalJDL.g:1144:2: iv_ruleJdlMinValidator= ruleJdlMinValidator EOF
            {
             newCompositeNode(grammarAccess.getJdlMinValidatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlMinValidator=ruleJdlMinValidator();

            state._fsp--;

             current =iv_ruleJdlMinValidator; 
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
    // $ANTLR end "entryRuleJdlMinValidator"


    // $ANTLR start "ruleJdlMinValidator"
    // InternalJDL.g:1150:1: ruleJdlMinValidator returns [EObject current=null] : (otherlv_0= 'min' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final EObject ruleJdlMinValidator() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalJDL.g:1156:2: ( (otherlv_0= 'min' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // InternalJDL.g:1157:2: (otherlv_0= 'min' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // InternalJDL.g:1157:2: (otherlv_0= 'min' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            // InternalJDL.g:1158:3: otherlv_0= 'min' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_17); 

            			newLeafNode(otherlv_0, grammarAccess.getJdlMinValidatorAccess().getMinKeyword_0());
            		
            otherlv_1=(Token)match(input,21,FOLLOW_18); 

            			newLeafNode(otherlv_1, grammarAccess.getJdlMinValidatorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalJDL.g:1166:3: ( (lv_value_2_0= RULE_INT ) )
            // InternalJDL.g:1167:4: (lv_value_2_0= RULE_INT )
            {
            // InternalJDL.g:1167:4: (lv_value_2_0= RULE_INT )
            // InternalJDL.g:1168:5: lv_value_2_0= RULE_INT
            {
            lv_value_2_0=(Token)match(input,RULE_INT,FOLLOW_19); 

            					newLeafNode(lv_value_2_0, grammarAccess.getJdlMinValidatorAccess().getValueINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJdlMinValidatorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_3=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getJdlMinValidatorAccess().getRightParenthesisKeyword_3());
            		

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
    // $ANTLR end "ruleJdlMinValidator"


    // $ANTLR start "entryRuleJdlMaxValidator"
    // InternalJDL.g:1192:1: entryRuleJdlMaxValidator returns [EObject current=null] : iv_ruleJdlMaxValidator= ruleJdlMaxValidator EOF ;
    public final EObject entryRuleJdlMaxValidator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJdlMaxValidator = null;


        try {
            // InternalJDL.g:1192:56: (iv_ruleJdlMaxValidator= ruleJdlMaxValidator EOF )
            // InternalJDL.g:1193:2: iv_ruleJdlMaxValidator= ruleJdlMaxValidator EOF
            {
             newCompositeNode(grammarAccess.getJdlMaxValidatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlMaxValidator=ruleJdlMaxValidator();

            state._fsp--;

             current =iv_ruleJdlMaxValidator; 
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
    // $ANTLR end "entryRuleJdlMaxValidator"


    // $ANTLR start "ruleJdlMaxValidator"
    // InternalJDL.g:1199:1: ruleJdlMaxValidator returns [EObject current=null] : (otherlv_0= 'max' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final EObject ruleJdlMaxValidator() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalJDL.g:1205:2: ( (otherlv_0= 'max' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // InternalJDL.g:1206:2: (otherlv_0= 'max' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // InternalJDL.g:1206:2: (otherlv_0= 'max' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            // InternalJDL.g:1207:3: otherlv_0= 'max' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,26,FOLLOW_17); 

            			newLeafNode(otherlv_0, grammarAccess.getJdlMaxValidatorAccess().getMaxKeyword_0());
            		
            otherlv_1=(Token)match(input,21,FOLLOW_18); 

            			newLeafNode(otherlv_1, grammarAccess.getJdlMaxValidatorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalJDL.g:1215:3: ( (lv_value_2_0= RULE_INT ) )
            // InternalJDL.g:1216:4: (lv_value_2_0= RULE_INT )
            {
            // InternalJDL.g:1216:4: (lv_value_2_0= RULE_INT )
            // InternalJDL.g:1217:5: lv_value_2_0= RULE_INT
            {
            lv_value_2_0=(Token)match(input,RULE_INT,FOLLOW_19); 

            					newLeafNode(lv_value_2_0, grammarAccess.getJdlMaxValidatorAccess().getValueINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJdlMaxValidatorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_3=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getJdlMaxValidatorAccess().getRightParenthesisKeyword_3());
            		

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
    // $ANTLR end "ruleJdlMaxValidator"


    // $ANTLR start "entryRuleJdlMinBytesValidator"
    // InternalJDL.g:1241:1: entryRuleJdlMinBytesValidator returns [EObject current=null] : iv_ruleJdlMinBytesValidator= ruleJdlMinBytesValidator EOF ;
    public final EObject entryRuleJdlMinBytesValidator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJdlMinBytesValidator = null;


        try {
            // InternalJDL.g:1241:61: (iv_ruleJdlMinBytesValidator= ruleJdlMinBytesValidator EOF )
            // InternalJDL.g:1242:2: iv_ruleJdlMinBytesValidator= ruleJdlMinBytesValidator EOF
            {
             newCompositeNode(grammarAccess.getJdlMinBytesValidatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlMinBytesValidator=ruleJdlMinBytesValidator();

            state._fsp--;

             current =iv_ruleJdlMinBytesValidator; 
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
    // $ANTLR end "entryRuleJdlMinBytesValidator"


    // $ANTLR start "ruleJdlMinBytesValidator"
    // InternalJDL.g:1248:1: ruleJdlMinBytesValidator returns [EObject current=null] : (otherlv_0= 'minbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final EObject ruleJdlMinBytesValidator() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalJDL.g:1254:2: ( (otherlv_0= 'minbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // InternalJDL.g:1255:2: (otherlv_0= 'minbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // InternalJDL.g:1255:2: (otherlv_0= 'minbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            // InternalJDL.g:1256:3: otherlv_0= 'minbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,27,FOLLOW_17); 

            			newLeafNode(otherlv_0, grammarAccess.getJdlMinBytesValidatorAccess().getMinbytesKeyword_0());
            		
            otherlv_1=(Token)match(input,21,FOLLOW_18); 

            			newLeafNode(otherlv_1, grammarAccess.getJdlMinBytesValidatorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalJDL.g:1264:3: ( (lv_value_2_0= RULE_INT ) )
            // InternalJDL.g:1265:4: (lv_value_2_0= RULE_INT )
            {
            // InternalJDL.g:1265:4: (lv_value_2_0= RULE_INT )
            // InternalJDL.g:1266:5: lv_value_2_0= RULE_INT
            {
            lv_value_2_0=(Token)match(input,RULE_INT,FOLLOW_19); 

            					newLeafNode(lv_value_2_0, grammarAccess.getJdlMinBytesValidatorAccess().getValueINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJdlMinBytesValidatorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_3=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getJdlMinBytesValidatorAccess().getRightParenthesisKeyword_3());
            		

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
    // $ANTLR end "ruleJdlMinBytesValidator"


    // $ANTLR start "entryRuleJdlMaxBytesValidator"
    // InternalJDL.g:1290:1: entryRuleJdlMaxBytesValidator returns [EObject current=null] : iv_ruleJdlMaxBytesValidator= ruleJdlMaxBytesValidator EOF ;
    public final EObject entryRuleJdlMaxBytesValidator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJdlMaxBytesValidator = null;


        try {
            // InternalJDL.g:1290:61: (iv_ruleJdlMaxBytesValidator= ruleJdlMaxBytesValidator EOF )
            // InternalJDL.g:1291:2: iv_ruleJdlMaxBytesValidator= ruleJdlMaxBytesValidator EOF
            {
             newCompositeNode(grammarAccess.getJdlMaxBytesValidatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlMaxBytesValidator=ruleJdlMaxBytesValidator();

            state._fsp--;

             current =iv_ruleJdlMaxBytesValidator; 
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
    // $ANTLR end "entryRuleJdlMaxBytesValidator"


    // $ANTLR start "ruleJdlMaxBytesValidator"
    // InternalJDL.g:1297:1: ruleJdlMaxBytesValidator returns [EObject current=null] : (otherlv_0= 'maxbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final EObject ruleJdlMaxBytesValidator() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalJDL.g:1303:2: ( (otherlv_0= 'maxbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // InternalJDL.g:1304:2: (otherlv_0= 'maxbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // InternalJDL.g:1304:2: (otherlv_0= 'maxbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            // InternalJDL.g:1305:3: otherlv_0= 'maxbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,28,FOLLOW_17); 

            			newLeafNode(otherlv_0, grammarAccess.getJdlMaxBytesValidatorAccess().getMaxbytesKeyword_0());
            		
            otherlv_1=(Token)match(input,21,FOLLOW_18); 

            			newLeafNode(otherlv_1, grammarAccess.getJdlMaxBytesValidatorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalJDL.g:1313:3: ( (lv_value_2_0= RULE_INT ) )
            // InternalJDL.g:1314:4: (lv_value_2_0= RULE_INT )
            {
            // InternalJDL.g:1314:4: (lv_value_2_0= RULE_INT )
            // InternalJDL.g:1315:5: lv_value_2_0= RULE_INT
            {
            lv_value_2_0=(Token)match(input,RULE_INT,FOLLOW_19); 

            					newLeafNode(lv_value_2_0, grammarAccess.getJdlMaxBytesValidatorAccess().getValueINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJdlMaxBytesValidatorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_3=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getJdlMaxBytesValidatorAccess().getRightParenthesisKeyword_3());
            		

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
    // $ANTLR end "ruleJdlMaxBytesValidator"


    // $ANTLR start "entryRuleJdlRelationships"
    // InternalJDL.g:1339:1: entryRuleJdlRelationships returns [EObject current=null] : iv_ruleJdlRelationships= ruleJdlRelationships EOF ;
    public final EObject entryRuleJdlRelationships() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJdlRelationships = null;


        try {
            // InternalJDL.g:1339:57: (iv_ruleJdlRelationships= ruleJdlRelationships EOF )
            // InternalJDL.g:1340:2: iv_ruleJdlRelationships= ruleJdlRelationships EOF
            {
             newCompositeNode(grammarAccess.getJdlRelationshipsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlRelationships=ruleJdlRelationships();

            state._fsp--;

             current =iv_ruleJdlRelationships; 
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
    // $ANTLR end "entryRuleJdlRelationships"


    // $ANTLR start "ruleJdlRelationships"
    // InternalJDL.g:1346:1: ruleJdlRelationships returns [EObject current=null] : (otherlv_0= 'relationship' ( (lv_cardinality_1_0= ruleJdlCardinality ) ) otherlv_2= '{' ( (lv_relationships_3_0= ruleJdlRelationship ) )* (otherlv_4= ',' ( (lv_relationships_5_0= ruleJdlRelationship ) ) )* otherlv_6= '}' ) ;
    public final EObject ruleJdlRelationships() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Enumerator lv_cardinality_1_0 = null;

        EObject lv_relationships_3_0 = null;

        EObject lv_relationships_5_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:1352:2: ( (otherlv_0= 'relationship' ( (lv_cardinality_1_0= ruleJdlCardinality ) ) otherlv_2= '{' ( (lv_relationships_3_0= ruleJdlRelationship ) )* (otherlv_4= ',' ( (lv_relationships_5_0= ruleJdlRelationship ) ) )* otherlv_6= '}' ) )
            // InternalJDL.g:1353:2: (otherlv_0= 'relationship' ( (lv_cardinality_1_0= ruleJdlCardinality ) ) otherlv_2= '{' ( (lv_relationships_3_0= ruleJdlRelationship ) )* (otherlv_4= ',' ( (lv_relationships_5_0= ruleJdlRelationship ) ) )* otherlv_6= '}' )
            {
            // InternalJDL.g:1353:2: (otherlv_0= 'relationship' ( (lv_cardinality_1_0= ruleJdlCardinality ) ) otherlv_2= '{' ( (lv_relationships_3_0= ruleJdlRelationship ) )* (otherlv_4= ',' ( (lv_relationships_5_0= ruleJdlRelationship ) ) )* otherlv_6= '}' )
            // InternalJDL.g:1354:3: otherlv_0= 'relationship' ( (lv_cardinality_1_0= ruleJdlCardinality ) ) otherlv_2= '{' ( (lv_relationships_3_0= ruleJdlRelationship ) )* (otherlv_4= ',' ( (lv_relationships_5_0= ruleJdlRelationship ) ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_21); 

            			newLeafNode(otherlv_0, grammarAccess.getJdlRelationshipsAccess().getRelationshipKeyword_0());
            		
            // InternalJDL.g:1358:3: ( (lv_cardinality_1_0= ruleJdlCardinality ) )
            // InternalJDL.g:1359:4: (lv_cardinality_1_0= ruleJdlCardinality )
            {
            // InternalJDL.g:1359:4: (lv_cardinality_1_0= ruleJdlCardinality )
            // InternalJDL.g:1360:5: lv_cardinality_1_0= ruleJdlCardinality
            {

            					newCompositeNode(grammarAccess.getJdlRelationshipsAccess().getCardinalityJdlCardinalityEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_22);
            lv_cardinality_1_0=ruleJdlCardinality();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJdlRelationshipsRule());
            					}
            					set(
            						current,
            						"cardinality",
            						lv_cardinality_1_0,
            						"io.github.jhipster.jdl.JDL.JdlCardinality");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_23); 

            			newLeafNode(otherlv_2, grammarAccess.getJdlRelationshipsAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalJDL.g:1381:3: ( (lv_relationships_3_0= ruleJdlRelationship ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_ID) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalJDL.g:1382:4: (lv_relationships_3_0= ruleJdlRelationship )
            	    {
            	    // InternalJDL.g:1382:4: (lv_relationships_3_0= ruleJdlRelationship )
            	    // InternalJDL.g:1383:5: lv_relationships_3_0= ruleJdlRelationship
            	    {

            	    					newCompositeNode(grammarAccess.getJdlRelationshipsAccess().getRelationshipsJdlRelationshipParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_23);
            	    lv_relationships_3_0=ruleJdlRelationship();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getJdlRelationshipsRule());
            	    					}
            	    					add(
            	    						current,
            	    						"relationships",
            	    						lv_relationships_3_0,
            	    						"io.github.jhipster.jdl.JDL.JdlRelationship");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            // InternalJDL.g:1400:3: (otherlv_4= ',' ( (lv_relationships_5_0= ruleJdlRelationship ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==13) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalJDL.g:1401:4: otherlv_4= ',' ( (lv_relationships_5_0= ruleJdlRelationship ) )
            	    {
            	    otherlv_4=(Token)match(input,13,FOLLOW_4); 

            	    				newLeafNode(otherlv_4, grammarAccess.getJdlRelationshipsAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalJDL.g:1405:4: ( (lv_relationships_5_0= ruleJdlRelationship ) )
            	    // InternalJDL.g:1406:5: (lv_relationships_5_0= ruleJdlRelationship )
            	    {
            	    // InternalJDL.g:1406:5: (lv_relationships_5_0= ruleJdlRelationship )
            	    // InternalJDL.g:1407:6: lv_relationships_5_0= ruleJdlRelationship
            	    {

            	    						newCompositeNode(grammarAccess.getJdlRelationshipsAccess().getRelationshipsJdlRelationshipParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_relationships_5_0=ruleJdlRelationship();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getJdlRelationshipsRule());
            	    						}
            	    						add(
            	    							current,
            	    							"relationships",
            	    							lv_relationships_5_0,
            	    							"io.github.jhipster.jdl.JDL.JdlRelationship");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            otherlv_6=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getJdlRelationshipsAccess().getRightCurlyBracketKeyword_5());
            		

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
    // $ANTLR end "ruleJdlRelationships"


    // $ANTLR start "entryRuleJdlRelationship"
    // InternalJDL.g:1433:1: entryRuleJdlRelationship returns [EObject current=null] : iv_ruleJdlRelationship= ruleJdlRelationship EOF ;
    public final EObject entryRuleJdlRelationship() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJdlRelationship = null;


        try {
            // InternalJDL.g:1433:56: (iv_ruleJdlRelationship= ruleJdlRelationship EOF )
            // InternalJDL.g:1434:2: iv_ruleJdlRelationship= ruleJdlRelationship EOF
            {
             newCompositeNode(grammarAccess.getJdlRelationshipRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlRelationship=ruleJdlRelationship();

            state._fsp--;

             current =iv_ruleJdlRelationship; 
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
    // $ANTLR end "entryRuleJdlRelationship"


    // $ANTLR start "ruleJdlRelationship"
    // InternalJDL.g:1440:1: ruleJdlRelationship returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_fromName_1_0= ruleJdlRelationshipName ) )? otherlv_2= 'to' ( (otherlv_3= RULE_ID ) ) ( (lv_toName_4_0= ruleJdlRelationshipName ) )? ) ;
    public final EObject ruleJdlRelationship() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_fromName_1_0 = null;

        EObject lv_toName_4_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:1446:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_fromName_1_0= ruleJdlRelationshipName ) )? otherlv_2= 'to' ( (otherlv_3= RULE_ID ) ) ( (lv_toName_4_0= ruleJdlRelationshipName ) )? ) )
            // InternalJDL.g:1447:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_fromName_1_0= ruleJdlRelationshipName ) )? otherlv_2= 'to' ( (otherlv_3= RULE_ID ) ) ( (lv_toName_4_0= ruleJdlRelationshipName ) )? )
            {
            // InternalJDL.g:1447:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_fromName_1_0= ruleJdlRelationshipName ) )? otherlv_2= 'to' ( (otherlv_3= RULE_ID ) ) ( (lv_toName_4_0= ruleJdlRelationshipName ) )? )
            // InternalJDL.g:1448:3: ( (otherlv_0= RULE_ID ) ) ( (lv_fromName_1_0= ruleJdlRelationshipName ) )? otherlv_2= 'to' ( (otherlv_3= RULE_ID ) ) ( (lv_toName_4_0= ruleJdlRelationshipName ) )?
            {
            // InternalJDL.g:1448:3: ( (otherlv_0= RULE_ID ) )
            // InternalJDL.g:1449:4: (otherlv_0= RULE_ID )
            {
            // InternalJDL.g:1449:4: (otherlv_0= RULE_ID )
            // InternalJDL.g:1450:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJdlRelationshipRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_24); 

            					newLeafNode(otherlv_0, grammarAccess.getJdlRelationshipAccess().getFromEntityJdlEntityCrossReference_0_0());
            				

            }


            }

            // InternalJDL.g:1461:3: ( (lv_fromName_1_0= ruleJdlRelationshipName ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==12) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalJDL.g:1462:4: (lv_fromName_1_0= ruleJdlRelationshipName )
                    {
                    // InternalJDL.g:1462:4: (lv_fromName_1_0= ruleJdlRelationshipName )
                    // InternalJDL.g:1463:5: lv_fromName_1_0= ruleJdlRelationshipName
                    {

                    					newCompositeNode(grammarAccess.getJdlRelationshipAccess().getFromNameJdlRelationshipNameParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_25);
                    lv_fromName_1_0=ruleJdlRelationshipName();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getJdlRelationshipRule());
                    					}
                    					set(
                    						current,
                    						"fromName",
                    						lv_fromName_1_0,
                    						"io.github.jhipster.jdl.JDL.JdlRelationshipName");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,30,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getJdlRelationshipAccess().getToKeyword_2());
            		
            // InternalJDL.g:1484:3: ( (otherlv_3= RULE_ID ) )
            // InternalJDL.g:1485:4: (otherlv_3= RULE_ID )
            {
            // InternalJDL.g:1485:4: (otherlv_3= RULE_ID )
            // InternalJDL.g:1486:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJdlRelationshipRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(otherlv_3, grammarAccess.getJdlRelationshipAccess().getToEntityJdlEntityCrossReference_3_0());
            				

            }


            }

            // InternalJDL.g:1497:3: ( (lv_toName_4_0= ruleJdlRelationshipName ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==12) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalJDL.g:1498:4: (lv_toName_4_0= ruleJdlRelationshipName )
                    {
                    // InternalJDL.g:1498:4: (lv_toName_4_0= ruleJdlRelationshipName )
                    // InternalJDL.g:1499:5: lv_toName_4_0= ruleJdlRelationshipName
                    {

                    					newCompositeNode(grammarAccess.getJdlRelationshipAccess().getToNameJdlRelationshipNameParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_toName_4_0=ruleJdlRelationshipName();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getJdlRelationshipRule());
                    					}
                    					set(
                    						current,
                    						"toName",
                    						lv_toName_4_0,
                    						"io.github.jhipster.jdl.JDL.JdlRelationshipName");
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
    // $ANTLR end "ruleJdlRelationship"


    // $ANTLR start "entryRuleJdlRelationshipName"
    // InternalJDL.g:1520:1: entryRuleJdlRelationshipName returns [EObject current=null] : iv_ruleJdlRelationshipName= ruleJdlRelationshipName EOF ;
    public final EObject entryRuleJdlRelationshipName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJdlRelationshipName = null;


        try {
            // InternalJDL.g:1520:60: (iv_ruleJdlRelationshipName= ruleJdlRelationshipName EOF )
            // InternalJDL.g:1521:2: iv_ruleJdlRelationshipName= ruleJdlRelationshipName EOF
            {
             newCompositeNode(grammarAccess.getJdlRelationshipNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlRelationshipName=ruleJdlRelationshipName();

            state._fsp--;

             current =iv_ruleJdlRelationshipName; 
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
    // $ANTLR end "entryRuleJdlRelationshipName"


    // $ANTLR start "ruleJdlRelationshipName"
    // InternalJDL.g:1527:1: ruleJdlRelationshipName returns [EObject current=null] : (otherlv_0= '{' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_role_3_0= RULE_ID ) ) otherlv_4= ')' )? otherlv_5= '}' ) ;
    public final EObject ruleJdlRelationshipName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_role_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalJDL.g:1533:2: ( (otherlv_0= '{' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_role_3_0= RULE_ID ) ) otherlv_4= ')' )? otherlv_5= '}' ) )
            // InternalJDL.g:1534:2: (otherlv_0= '{' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_role_3_0= RULE_ID ) ) otherlv_4= ')' )? otherlv_5= '}' )
            {
            // InternalJDL.g:1534:2: (otherlv_0= '{' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_role_3_0= RULE_ID ) ) otherlv_4= ')' )? otherlv_5= '}' )
            // InternalJDL.g:1535:3: otherlv_0= '{' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_role_3_0= RULE_ID ) ) otherlv_4= ')' )? otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getJdlRelationshipNameAccess().getLeftCurlyBracketKeyword_0());
            		
            // InternalJDL.g:1539:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalJDL.g:1540:4: (lv_name_1_0= RULE_ID )
            {
            // InternalJDL.g:1540:4: (lv_name_1_0= RULE_ID )
            // InternalJDL.g:1541:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_26); 

            					newLeafNode(lv_name_1_0, grammarAccess.getJdlRelationshipNameAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJdlRelationshipNameRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalJDL.g:1557:3: (otherlv_2= '(' ( (lv_role_3_0= RULE_ID ) ) otherlv_4= ')' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==21) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalJDL.g:1558:4: otherlv_2= '(' ( (lv_role_3_0= RULE_ID ) ) otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,21,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getJdlRelationshipNameAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalJDL.g:1562:4: ( (lv_role_3_0= RULE_ID ) )
                    // InternalJDL.g:1563:5: (lv_role_3_0= RULE_ID )
                    {
                    // InternalJDL.g:1563:5: (lv_role_3_0= RULE_ID )
                    // InternalJDL.g:1564:6: lv_role_3_0= RULE_ID
                    {
                    lv_role_3_0=(Token)match(input,RULE_ID,FOLLOW_19); 

                    						newLeafNode(lv_role_3_0, grammarAccess.getJdlRelationshipNameAccess().getRoleIDTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getJdlRelationshipNameRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"role",
                    							lv_role_3_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,22,FOLLOW_27); 

                    				newLeafNode(otherlv_4, grammarAccess.getJdlRelationshipNameAccess().getRightParenthesisKeyword_2_2());
                    			

                    }
                    break;

            }

            otherlv_5=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getJdlRelationshipNameAccess().getRightCurlyBracketKeyword_3());
            		

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
    // $ANTLR end "ruleJdlRelationshipName"


    // $ANTLR start "entryRuleJdlEnumType"
    // InternalJDL.g:1593:1: entryRuleJdlEnumType returns [EObject current=null] : iv_ruleJdlEnumType= ruleJdlEnumType EOF ;
    public final EObject entryRuleJdlEnumType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJdlEnumType = null;


        try {
            // InternalJDL.g:1593:52: (iv_ruleJdlEnumType= ruleJdlEnumType EOF )
            // InternalJDL.g:1594:2: iv_ruleJdlEnumType= ruleJdlEnumType EOF
            {
             newCompositeNode(grammarAccess.getJdlEnumTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlEnumType=ruleJdlEnumType();

            state._fsp--;

             current =iv_ruleJdlEnumType; 
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
    // $ANTLR end "entryRuleJdlEnumType"


    // $ANTLR start "ruleJdlEnumType"
    // InternalJDL.g:1600:1: ruleJdlEnumType returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_values_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_values_5_0= RULE_ID ) ) )* otherlv_6= '}' ) ;
    public final EObject ruleJdlEnumType() throws RecognitionException {
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
            // InternalJDL.g:1606:2: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_values_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_values_5_0= RULE_ID ) ) )* otherlv_6= '}' ) )
            // InternalJDL.g:1607:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_values_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_values_5_0= RULE_ID ) ) )* otherlv_6= '}' )
            {
            // InternalJDL.g:1607:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_values_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_values_5_0= RULE_ID ) ) )* otherlv_6= '}' )
            // InternalJDL.g:1608:3: otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_values_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_values_5_0= RULE_ID ) ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,31,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getJdlEnumTypeAccess().getEnumKeyword_0());
            		
            // InternalJDL.g:1612:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalJDL.g:1613:4: (lv_name_1_0= RULE_ID )
            {
            // InternalJDL.g:1613:4: (lv_name_1_0= RULE_ID )
            // InternalJDL.g:1614:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_22); 

            					newLeafNode(lv_name_1_0, grammarAccess.getJdlEnumTypeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJdlEnumTypeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getJdlEnumTypeAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalJDL.g:1634:3: ( (lv_values_3_0= RULE_ID ) )
            // InternalJDL.g:1635:4: (lv_values_3_0= RULE_ID )
            {
            // InternalJDL.g:1635:4: (lv_values_3_0= RULE_ID )
            // InternalJDL.g:1636:5: lv_values_3_0= RULE_ID
            {
            lv_values_3_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(lv_values_3_0, grammarAccess.getJdlEnumTypeAccess().getValuesIDTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJdlEnumTypeRule());
            					}
            					addWithLastConsumed(
            						current,
            						"values",
            						lv_values_3_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalJDL.g:1652:3: (otherlv_4= ',' ( (lv_values_5_0= RULE_ID ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==13) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalJDL.g:1653:4: otherlv_4= ',' ( (lv_values_5_0= RULE_ID ) )
            	    {
            	    otherlv_4=(Token)match(input,13,FOLLOW_4); 

            	    				newLeafNode(otherlv_4, grammarAccess.getJdlEnumTypeAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalJDL.g:1657:4: ( (lv_values_5_0= RULE_ID ) )
            	    // InternalJDL.g:1658:5: (lv_values_5_0= RULE_ID )
            	    {
            	    // InternalJDL.g:1658:5: (lv_values_5_0= RULE_ID )
            	    // InternalJDL.g:1659:6: lv_values_5_0= RULE_ID
            	    {
            	    lv_values_5_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            	    						newLeafNode(lv_values_5_0, grammarAccess.getJdlEnumTypeAccess().getValuesIDTerminalRuleCall_4_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getJdlEnumTypeRule());
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
            	    break loop26;
                }
            } while (true);

            otherlv_6=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getJdlEnumTypeAccess().getRightCurlyBracketKeyword_5());
            		

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
    // $ANTLR end "ruleJdlEnumType"


    // $ANTLR start "entryRuleJdlGenerationSetting"
    // InternalJDL.g:1684:1: entryRuleJdlGenerationSetting returns [EObject current=null] : iv_ruleJdlGenerationSetting= ruleJdlGenerationSetting EOF ;
    public final EObject entryRuleJdlGenerationSetting() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJdlGenerationSetting = null;


        try {
            // InternalJDL.g:1684:61: (iv_ruleJdlGenerationSetting= ruleJdlGenerationSetting EOF )
            // InternalJDL.g:1685:2: iv_ruleJdlGenerationSetting= ruleJdlGenerationSetting EOF
            {
             newCompositeNode(grammarAccess.getJdlGenerationSettingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlGenerationSetting=ruleJdlGenerationSetting();

            state._fsp--;

             current =iv_ruleJdlGenerationSetting; 
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
    // $ANTLR end "entryRuleJdlGenerationSetting"


    // $ANTLR start "ruleJdlGenerationSetting"
    // InternalJDL.g:1691:1: ruleJdlGenerationSetting returns [EObject current=null] : ( ( (lv_setting_0_0= ruleJdlGenerationSettingType ) ) ( (lv_excludes_1_0= ruleJdlEntityExclusion ) )? ) ;
    public final EObject ruleJdlGenerationSetting() throws RecognitionException {
        EObject current = null;

        EObject lv_setting_0_0 = null;

        EObject lv_excludes_1_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:1697:2: ( ( ( (lv_setting_0_0= ruleJdlGenerationSettingType ) ) ( (lv_excludes_1_0= ruleJdlEntityExclusion ) )? ) )
            // InternalJDL.g:1698:2: ( ( (lv_setting_0_0= ruleJdlGenerationSettingType ) ) ( (lv_excludes_1_0= ruleJdlEntityExclusion ) )? )
            {
            // InternalJDL.g:1698:2: ( ( (lv_setting_0_0= ruleJdlGenerationSettingType ) ) ( (lv_excludes_1_0= ruleJdlEntityExclusion ) )? )
            // InternalJDL.g:1699:3: ( (lv_setting_0_0= ruleJdlGenerationSettingType ) ) ( (lv_excludes_1_0= ruleJdlEntityExclusion ) )?
            {
            // InternalJDL.g:1699:3: ( (lv_setting_0_0= ruleJdlGenerationSettingType ) )
            // InternalJDL.g:1700:4: (lv_setting_0_0= ruleJdlGenerationSettingType )
            {
            // InternalJDL.g:1700:4: (lv_setting_0_0= ruleJdlGenerationSettingType )
            // InternalJDL.g:1701:5: lv_setting_0_0= ruleJdlGenerationSettingType
            {

            					newCompositeNode(grammarAccess.getJdlGenerationSettingAccess().getSettingJdlGenerationSettingTypeParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_28);
            lv_setting_0_0=ruleJdlGenerationSettingType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJdlGenerationSettingRule());
            					}
            					set(
            						current,
            						"setting",
            						lv_setting_0_0,
            						"io.github.jhipster.jdl.JDL.JdlGenerationSettingType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalJDL.g:1718:3: ( (lv_excludes_1_0= ruleJdlEntityExclusion ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==39) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalJDL.g:1719:4: (lv_excludes_1_0= ruleJdlEntityExclusion )
                    {
                    // InternalJDL.g:1719:4: (lv_excludes_1_0= ruleJdlEntityExclusion )
                    // InternalJDL.g:1720:5: lv_excludes_1_0= ruleJdlEntityExclusion
                    {

                    					newCompositeNode(grammarAccess.getJdlGenerationSettingAccess().getExcludesJdlEntityExclusionParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_excludes_1_0=ruleJdlEntityExclusion();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getJdlGenerationSettingRule());
                    					}
                    					set(
                    						current,
                    						"excludes",
                    						lv_excludes_1_0,
                    						"io.github.jhipster.jdl.JDL.JdlEntityExclusion");
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
    // $ANTLR end "ruleJdlGenerationSetting"


    // $ANTLR start "entryRuleJdlGenerationSettingType"
    // InternalJDL.g:1741:1: entryRuleJdlGenerationSettingType returns [EObject current=null] : iv_ruleJdlGenerationSettingType= ruleJdlGenerationSettingType EOF ;
    public final EObject entryRuleJdlGenerationSettingType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJdlGenerationSettingType = null;


        try {
            // InternalJDL.g:1741:65: (iv_ruleJdlGenerationSettingType= ruleJdlGenerationSettingType EOF )
            // InternalJDL.g:1742:2: iv_ruleJdlGenerationSettingType= ruleJdlGenerationSettingType EOF
            {
             newCompositeNode(grammarAccess.getJdlGenerationSettingTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlGenerationSettingType=ruleJdlGenerationSettingType();

            state._fsp--;

             current =iv_ruleJdlGenerationSettingType; 
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
    // $ANTLR end "entryRuleJdlGenerationSettingType"


    // $ANTLR start "ruleJdlGenerationSettingType"
    // InternalJDL.g:1748:1: ruleJdlGenerationSettingType returns [EObject current=null] : (this_JdlServiceGenerationSetting_0= ruleJdlServiceGenerationSetting | this_JdlMicroserviceGenerationSetting_1= ruleJdlMicroserviceGenerationSetting | this_JdlSearchGenerationSetting_2= ruleJdlSearchGenerationSetting | this_JdlDtoGenerationSetting_3= ruleJdlDtoGenerationSetting | this_JdlPaginateGenerationSetting_4= ruleJdlPaginateGenerationSetting | this_JdlAngularSuffixGenerationSetting_5= ruleJdlAngularSuffixGenerationSetting ) ;
    public final EObject ruleJdlGenerationSettingType() throws RecognitionException {
        EObject current = null;

        EObject this_JdlServiceGenerationSetting_0 = null;

        EObject this_JdlMicroserviceGenerationSetting_1 = null;

        EObject this_JdlSearchGenerationSetting_2 = null;

        EObject this_JdlDtoGenerationSetting_3 = null;

        EObject this_JdlPaginateGenerationSetting_4 = null;

        EObject this_JdlAngularSuffixGenerationSetting_5 = null;



        	enterRule();

        try {
            // InternalJDL.g:1754:2: ( (this_JdlServiceGenerationSetting_0= ruleJdlServiceGenerationSetting | this_JdlMicroserviceGenerationSetting_1= ruleJdlMicroserviceGenerationSetting | this_JdlSearchGenerationSetting_2= ruleJdlSearchGenerationSetting | this_JdlDtoGenerationSetting_3= ruleJdlDtoGenerationSetting | this_JdlPaginateGenerationSetting_4= ruleJdlPaginateGenerationSetting | this_JdlAngularSuffixGenerationSetting_5= ruleJdlAngularSuffixGenerationSetting ) )
            // InternalJDL.g:1755:2: (this_JdlServiceGenerationSetting_0= ruleJdlServiceGenerationSetting | this_JdlMicroserviceGenerationSetting_1= ruleJdlMicroserviceGenerationSetting | this_JdlSearchGenerationSetting_2= ruleJdlSearchGenerationSetting | this_JdlDtoGenerationSetting_3= ruleJdlDtoGenerationSetting | this_JdlPaginateGenerationSetting_4= ruleJdlPaginateGenerationSetting | this_JdlAngularSuffixGenerationSetting_5= ruleJdlAngularSuffixGenerationSetting )
            {
            // InternalJDL.g:1755:2: (this_JdlServiceGenerationSetting_0= ruleJdlServiceGenerationSetting | this_JdlMicroserviceGenerationSetting_1= ruleJdlMicroserviceGenerationSetting | this_JdlSearchGenerationSetting_2= ruleJdlSearchGenerationSetting | this_JdlDtoGenerationSetting_3= ruleJdlDtoGenerationSetting | this_JdlPaginateGenerationSetting_4= ruleJdlPaginateGenerationSetting | this_JdlAngularSuffixGenerationSetting_5= ruleJdlAngularSuffixGenerationSetting )
            int alt28=6;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt28=1;
                }
                break;
            case 33:
                {
                alt28=2;
                }
                break;
            case 34:
                {
                alt28=3;
                }
                break;
            case 35:
                {
                alt28=4;
                }
                break;
            case 36:
                {
                alt28=5;
                }
                break;
            case 37:
                {
                alt28=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // InternalJDL.g:1756:3: this_JdlServiceGenerationSetting_0= ruleJdlServiceGenerationSetting
                    {

                    			newCompositeNode(grammarAccess.getJdlGenerationSettingTypeAccess().getJdlServiceGenerationSettingParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_JdlServiceGenerationSetting_0=ruleJdlServiceGenerationSetting();

                    state._fsp--;


                    			current = this_JdlServiceGenerationSetting_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalJDL.g:1765:3: this_JdlMicroserviceGenerationSetting_1= ruleJdlMicroserviceGenerationSetting
                    {

                    			newCompositeNode(grammarAccess.getJdlGenerationSettingTypeAccess().getJdlMicroserviceGenerationSettingParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_JdlMicroserviceGenerationSetting_1=ruleJdlMicroserviceGenerationSetting();

                    state._fsp--;


                    			current = this_JdlMicroserviceGenerationSetting_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalJDL.g:1774:3: this_JdlSearchGenerationSetting_2= ruleJdlSearchGenerationSetting
                    {

                    			newCompositeNode(grammarAccess.getJdlGenerationSettingTypeAccess().getJdlSearchGenerationSettingParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_JdlSearchGenerationSetting_2=ruleJdlSearchGenerationSetting();

                    state._fsp--;


                    			current = this_JdlSearchGenerationSetting_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalJDL.g:1783:3: this_JdlDtoGenerationSetting_3= ruleJdlDtoGenerationSetting
                    {

                    			newCompositeNode(grammarAccess.getJdlGenerationSettingTypeAccess().getJdlDtoGenerationSettingParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_JdlDtoGenerationSetting_3=ruleJdlDtoGenerationSetting();

                    state._fsp--;


                    			current = this_JdlDtoGenerationSetting_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalJDL.g:1792:3: this_JdlPaginateGenerationSetting_4= ruleJdlPaginateGenerationSetting
                    {

                    			newCompositeNode(grammarAccess.getJdlGenerationSettingTypeAccess().getJdlPaginateGenerationSettingParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_JdlPaginateGenerationSetting_4=ruleJdlPaginateGenerationSetting();

                    state._fsp--;


                    			current = this_JdlPaginateGenerationSetting_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalJDL.g:1801:3: this_JdlAngularSuffixGenerationSetting_5= ruleJdlAngularSuffixGenerationSetting
                    {

                    			newCompositeNode(grammarAccess.getJdlGenerationSettingTypeAccess().getJdlAngularSuffixGenerationSettingParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_JdlAngularSuffixGenerationSetting_5=ruleJdlAngularSuffixGenerationSetting();

                    state._fsp--;


                    			current = this_JdlAngularSuffixGenerationSetting_5;
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
    // $ANTLR end "ruleJdlGenerationSettingType"


    // $ANTLR start "entryRuleJdlServiceGenerationSetting"
    // InternalJDL.g:1813:1: entryRuleJdlServiceGenerationSetting returns [EObject current=null] : iv_ruleJdlServiceGenerationSetting= ruleJdlServiceGenerationSetting EOF ;
    public final EObject entryRuleJdlServiceGenerationSetting() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJdlServiceGenerationSetting = null;


        try {
            // InternalJDL.g:1813:68: (iv_ruleJdlServiceGenerationSetting= ruleJdlServiceGenerationSetting EOF )
            // InternalJDL.g:1814:2: iv_ruleJdlServiceGenerationSetting= ruleJdlServiceGenerationSetting EOF
            {
             newCompositeNode(grammarAccess.getJdlServiceGenerationSettingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlServiceGenerationSetting=ruleJdlServiceGenerationSetting();

            state._fsp--;

             current =iv_ruleJdlServiceGenerationSetting; 
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
    // $ANTLR end "entryRuleJdlServiceGenerationSetting"


    // $ANTLR start "ruleJdlServiceGenerationSetting"
    // InternalJDL.g:1820:1: ruleJdlServiceGenerationSetting returns [EObject current=null] : ( ( (lv_serviceGenerationSetting_0_0= 'service' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_serviceType_2_0= ruleJdlServiceType ) ) ) ;
    public final EObject ruleJdlServiceGenerationSetting() throws RecognitionException {
        EObject current = null;

        Token lv_serviceGenerationSetting_0_0=null;
        EObject lv_includes_1_0 = null;

        Enumerator lv_serviceType_2_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:1826:2: ( ( ( (lv_serviceGenerationSetting_0_0= 'service' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_serviceType_2_0= ruleJdlServiceType ) ) ) )
            // InternalJDL.g:1827:2: ( ( (lv_serviceGenerationSetting_0_0= 'service' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_serviceType_2_0= ruleJdlServiceType ) ) )
            {
            // InternalJDL.g:1827:2: ( ( (lv_serviceGenerationSetting_0_0= 'service' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_serviceType_2_0= ruleJdlServiceType ) ) )
            // InternalJDL.g:1828:3: ( (lv_serviceGenerationSetting_0_0= 'service' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_serviceType_2_0= ruleJdlServiceType ) )
            {
            // InternalJDL.g:1828:3: ( (lv_serviceGenerationSetting_0_0= 'service' ) )
            // InternalJDL.g:1829:4: (lv_serviceGenerationSetting_0_0= 'service' )
            {
            // InternalJDL.g:1829:4: (lv_serviceGenerationSetting_0_0= 'service' )
            // InternalJDL.g:1830:5: lv_serviceGenerationSetting_0_0= 'service'
            {
            lv_serviceGenerationSetting_0_0=(Token)match(input,32,FOLLOW_29); 

            					newLeafNode(lv_serviceGenerationSetting_0_0, grammarAccess.getJdlServiceGenerationSettingAccess().getServiceGenerationSettingServiceKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJdlServiceGenerationSettingRule());
            					}
            					setWithLastConsumed(current, "serviceGenerationSetting", true, "service");
            				

            }


            }

            // InternalJDL.g:1842:3: ( (lv_includes_1_0= ruleJdlEntityInclusion ) )
            // InternalJDL.g:1843:4: (lv_includes_1_0= ruleJdlEntityInclusion )
            {
            // InternalJDL.g:1843:4: (lv_includes_1_0= ruleJdlEntityInclusion )
            // InternalJDL.g:1844:5: lv_includes_1_0= ruleJdlEntityInclusion
            {

            					newCompositeNode(grammarAccess.getJdlServiceGenerationSettingAccess().getIncludesJdlEntityInclusionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_30);
            lv_includes_1_0=ruleJdlEntityInclusion();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJdlServiceGenerationSettingRule());
            					}
            					set(
            						current,
            						"includes",
            						lv_includes_1_0,
            						"io.github.jhipster.jdl.JDL.JdlEntityInclusion");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalJDL.g:1861:3: ( (lv_serviceType_2_0= ruleJdlServiceType ) )
            // InternalJDL.g:1862:4: (lv_serviceType_2_0= ruleJdlServiceType )
            {
            // InternalJDL.g:1862:4: (lv_serviceType_2_0= ruleJdlServiceType )
            // InternalJDL.g:1863:5: lv_serviceType_2_0= ruleJdlServiceType
            {

            					newCompositeNode(grammarAccess.getJdlServiceGenerationSettingAccess().getServiceTypeJdlServiceTypeEnumRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_serviceType_2_0=ruleJdlServiceType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJdlServiceGenerationSettingRule());
            					}
            					set(
            						current,
            						"serviceType",
            						lv_serviceType_2_0,
            						"io.github.jhipster.jdl.JDL.JdlServiceType");
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
    // $ANTLR end "ruleJdlServiceGenerationSetting"


    // $ANTLR start "entryRuleJdlMicroserviceGenerationSetting"
    // InternalJDL.g:1884:1: entryRuleJdlMicroserviceGenerationSetting returns [EObject current=null] : iv_ruleJdlMicroserviceGenerationSetting= ruleJdlMicroserviceGenerationSetting EOF ;
    public final EObject entryRuleJdlMicroserviceGenerationSetting() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJdlMicroserviceGenerationSetting = null;


        try {
            // InternalJDL.g:1884:73: (iv_ruleJdlMicroserviceGenerationSetting= ruleJdlMicroserviceGenerationSetting EOF )
            // InternalJDL.g:1885:2: iv_ruleJdlMicroserviceGenerationSetting= ruleJdlMicroserviceGenerationSetting EOF
            {
             newCompositeNode(grammarAccess.getJdlMicroserviceGenerationSettingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlMicroserviceGenerationSetting=ruleJdlMicroserviceGenerationSetting();

            state._fsp--;

             current =iv_ruleJdlMicroserviceGenerationSetting; 
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
    // $ANTLR end "entryRuleJdlMicroserviceGenerationSetting"


    // $ANTLR start "ruleJdlMicroserviceGenerationSetting"
    // InternalJDL.g:1891:1: ruleJdlMicroserviceGenerationSetting returns [EObject current=null] : ( ( (lv_microserviceGenerationSetting_0_0= 'microservice' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_appname_2_0= RULE_ID ) ) ) ;
    public final EObject ruleJdlMicroserviceGenerationSetting() throws RecognitionException {
        EObject current = null;

        Token lv_microserviceGenerationSetting_0_0=null;
        Token lv_appname_2_0=null;
        EObject lv_includes_1_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:1897:2: ( ( ( (lv_microserviceGenerationSetting_0_0= 'microservice' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_appname_2_0= RULE_ID ) ) ) )
            // InternalJDL.g:1898:2: ( ( (lv_microserviceGenerationSetting_0_0= 'microservice' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_appname_2_0= RULE_ID ) ) )
            {
            // InternalJDL.g:1898:2: ( ( (lv_microserviceGenerationSetting_0_0= 'microservice' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_appname_2_0= RULE_ID ) ) )
            // InternalJDL.g:1899:3: ( (lv_microserviceGenerationSetting_0_0= 'microservice' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_appname_2_0= RULE_ID ) )
            {
            // InternalJDL.g:1899:3: ( (lv_microserviceGenerationSetting_0_0= 'microservice' ) )
            // InternalJDL.g:1900:4: (lv_microserviceGenerationSetting_0_0= 'microservice' )
            {
            // InternalJDL.g:1900:4: (lv_microserviceGenerationSetting_0_0= 'microservice' )
            // InternalJDL.g:1901:5: lv_microserviceGenerationSetting_0_0= 'microservice'
            {
            lv_microserviceGenerationSetting_0_0=(Token)match(input,33,FOLLOW_29); 

            					newLeafNode(lv_microserviceGenerationSetting_0_0, grammarAccess.getJdlMicroserviceGenerationSettingAccess().getMicroserviceGenerationSettingMicroserviceKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJdlMicroserviceGenerationSettingRule());
            					}
            					setWithLastConsumed(current, "microserviceGenerationSetting", true, "microservice");
            				

            }


            }

            // InternalJDL.g:1913:3: ( (lv_includes_1_0= ruleJdlEntityInclusion ) )
            // InternalJDL.g:1914:4: (lv_includes_1_0= ruleJdlEntityInclusion )
            {
            // InternalJDL.g:1914:4: (lv_includes_1_0= ruleJdlEntityInclusion )
            // InternalJDL.g:1915:5: lv_includes_1_0= ruleJdlEntityInclusion
            {

            					newCompositeNode(grammarAccess.getJdlMicroserviceGenerationSettingAccess().getIncludesJdlEntityInclusionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_includes_1_0=ruleJdlEntityInclusion();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJdlMicroserviceGenerationSettingRule());
            					}
            					set(
            						current,
            						"includes",
            						lv_includes_1_0,
            						"io.github.jhipster.jdl.JDL.JdlEntityInclusion");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalJDL.g:1932:3: ( (lv_appname_2_0= RULE_ID ) )
            // InternalJDL.g:1933:4: (lv_appname_2_0= RULE_ID )
            {
            // InternalJDL.g:1933:4: (lv_appname_2_0= RULE_ID )
            // InternalJDL.g:1934:5: lv_appname_2_0= RULE_ID
            {
            lv_appname_2_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_appname_2_0, grammarAccess.getJdlMicroserviceGenerationSettingAccess().getAppnameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJdlMicroserviceGenerationSettingRule());
            					}
            					setWithLastConsumed(
            						current,
            						"appname",
            						lv_appname_2_0,
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
    // $ANTLR end "ruleJdlMicroserviceGenerationSetting"


    // $ANTLR start "entryRuleJdlSearchGenerationSetting"
    // InternalJDL.g:1954:1: entryRuleJdlSearchGenerationSetting returns [EObject current=null] : iv_ruleJdlSearchGenerationSetting= ruleJdlSearchGenerationSetting EOF ;
    public final EObject entryRuleJdlSearchGenerationSetting() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJdlSearchGenerationSetting = null;


        try {
            // InternalJDL.g:1954:67: (iv_ruleJdlSearchGenerationSetting= ruleJdlSearchGenerationSetting EOF )
            // InternalJDL.g:1955:2: iv_ruleJdlSearchGenerationSetting= ruleJdlSearchGenerationSetting EOF
            {
             newCompositeNode(grammarAccess.getJdlSearchGenerationSettingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlSearchGenerationSetting=ruleJdlSearchGenerationSetting();

            state._fsp--;

             current =iv_ruleJdlSearchGenerationSetting; 
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
    // $ANTLR end "entryRuleJdlSearchGenerationSetting"


    // $ANTLR start "ruleJdlSearchGenerationSetting"
    // InternalJDL.g:1961:1: ruleJdlSearchGenerationSetting returns [EObject current=null] : ( ( (lv_searchGenerationSetting_0_0= 'search' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_service_2_0= RULE_ID ) ) ) ;
    public final EObject ruleJdlSearchGenerationSetting() throws RecognitionException {
        EObject current = null;

        Token lv_searchGenerationSetting_0_0=null;
        Token lv_service_2_0=null;
        EObject lv_includes_1_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:1967:2: ( ( ( (lv_searchGenerationSetting_0_0= 'search' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_service_2_0= RULE_ID ) ) ) )
            // InternalJDL.g:1968:2: ( ( (lv_searchGenerationSetting_0_0= 'search' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_service_2_0= RULE_ID ) ) )
            {
            // InternalJDL.g:1968:2: ( ( (lv_searchGenerationSetting_0_0= 'search' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_service_2_0= RULE_ID ) ) )
            // InternalJDL.g:1969:3: ( (lv_searchGenerationSetting_0_0= 'search' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_service_2_0= RULE_ID ) )
            {
            // InternalJDL.g:1969:3: ( (lv_searchGenerationSetting_0_0= 'search' ) )
            // InternalJDL.g:1970:4: (lv_searchGenerationSetting_0_0= 'search' )
            {
            // InternalJDL.g:1970:4: (lv_searchGenerationSetting_0_0= 'search' )
            // InternalJDL.g:1971:5: lv_searchGenerationSetting_0_0= 'search'
            {
            lv_searchGenerationSetting_0_0=(Token)match(input,34,FOLLOW_29); 

            					newLeafNode(lv_searchGenerationSetting_0_0, grammarAccess.getJdlSearchGenerationSettingAccess().getSearchGenerationSettingSearchKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJdlSearchGenerationSettingRule());
            					}
            					setWithLastConsumed(current, "searchGenerationSetting", true, "search");
            				

            }


            }

            // InternalJDL.g:1983:3: ( (lv_includes_1_0= ruleJdlEntityInclusion ) )
            // InternalJDL.g:1984:4: (lv_includes_1_0= ruleJdlEntityInclusion )
            {
            // InternalJDL.g:1984:4: (lv_includes_1_0= ruleJdlEntityInclusion )
            // InternalJDL.g:1985:5: lv_includes_1_0= ruleJdlEntityInclusion
            {

            					newCompositeNode(grammarAccess.getJdlSearchGenerationSettingAccess().getIncludesJdlEntityInclusionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_includes_1_0=ruleJdlEntityInclusion();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJdlSearchGenerationSettingRule());
            					}
            					set(
            						current,
            						"includes",
            						lv_includes_1_0,
            						"io.github.jhipster.jdl.JDL.JdlEntityInclusion");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalJDL.g:2002:3: ( (lv_service_2_0= RULE_ID ) )
            // InternalJDL.g:2003:4: (lv_service_2_0= RULE_ID )
            {
            // InternalJDL.g:2003:4: (lv_service_2_0= RULE_ID )
            // InternalJDL.g:2004:5: lv_service_2_0= RULE_ID
            {
            lv_service_2_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_service_2_0, grammarAccess.getJdlSearchGenerationSettingAccess().getServiceIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJdlSearchGenerationSettingRule());
            					}
            					setWithLastConsumed(
            						current,
            						"service",
            						lv_service_2_0,
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
    // $ANTLR end "ruleJdlSearchGenerationSetting"


    // $ANTLR start "entryRuleJdlDtoGenerationSetting"
    // InternalJDL.g:2024:1: entryRuleJdlDtoGenerationSetting returns [EObject current=null] : iv_ruleJdlDtoGenerationSetting= ruleJdlDtoGenerationSetting EOF ;
    public final EObject entryRuleJdlDtoGenerationSetting() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJdlDtoGenerationSetting = null;


        try {
            // InternalJDL.g:2024:64: (iv_ruleJdlDtoGenerationSetting= ruleJdlDtoGenerationSetting EOF )
            // InternalJDL.g:2025:2: iv_ruleJdlDtoGenerationSetting= ruleJdlDtoGenerationSetting EOF
            {
             newCompositeNode(grammarAccess.getJdlDtoGenerationSettingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlDtoGenerationSetting=ruleJdlDtoGenerationSetting();

            state._fsp--;

             current =iv_ruleJdlDtoGenerationSetting; 
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
    // $ANTLR end "entryRuleJdlDtoGenerationSetting"


    // $ANTLR start "ruleJdlDtoGenerationSetting"
    // InternalJDL.g:2031:1: ruleJdlDtoGenerationSetting returns [EObject current=null] : ( ( (lv_dtoGenerationSetting_0_0= 'dto' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_dtoType_2_0= ruleJdlDtoType ) ) ) ;
    public final EObject ruleJdlDtoGenerationSetting() throws RecognitionException {
        EObject current = null;

        Token lv_dtoGenerationSetting_0_0=null;
        EObject lv_includes_1_0 = null;

        Enumerator lv_dtoType_2_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:2037:2: ( ( ( (lv_dtoGenerationSetting_0_0= 'dto' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_dtoType_2_0= ruleJdlDtoType ) ) ) )
            // InternalJDL.g:2038:2: ( ( (lv_dtoGenerationSetting_0_0= 'dto' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_dtoType_2_0= ruleJdlDtoType ) ) )
            {
            // InternalJDL.g:2038:2: ( ( (lv_dtoGenerationSetting_0_0= 'dto' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_dtoType_2_0= ruleJdlDtoType ) ) )
            // InternalJDL.g:2039:3: ( (lv_dtoGenerationSetting_0_0= 'dto' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_dtoType_2_0= ruleJdlDtoType ) )
            {
            // InternalJDL.g:2039:3: ( (lv_dtoGenerationSetting_0_0= 'dto' ) )
            // InternalJDL.g:2040:4: (lv_dtoGenerationSetting_0_0= 'dto' )
            {
            // InternalJDL.g:2040:4: (lv_dtoGenerationSetting_0_0= 'dto' )
            // InternalJDL.g:2041:5: lv_dtoGenerationSetting_0_0= 'dto'
            {
            lv_dtoGenerationSetting_0_0=(Token)match(input,35,FOLLOW_29); 

            					newLeafNode(lv_dtoGenerationSetting_0_0, grammarAccess.getJdlDtoGenerationSettingAccess().getDtoGenerationSettingDtoKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJdlDtoGenerationSettingRule());
            					}
            					setWithLastConsumed(current, "dtoGenerationSetting", true, "dto");
            				

            }


            }

            // InternalJDL.g:2053:3: ( (lv_includes_1_0= ruleJdlEntityInclusion ) )
            // InternalJDL.g:2054:4: (lv_includes_1_0= ruleJdlEntityInclusion )
            {
            // InternalJDL.g:2054:4: (lv_includes_1_0= ruleJdlEntityInclusion )
            // InternalJDL.g:2055:5: lv_includes_1_0= ruleJdlEntityInclusion
            {

            					newCompositeNode(grammarAccess.getJdlDtoGenerationSettingAccess().getIncludesJdlEntityInclusionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_31);
            lv_includes_1_0=ruleJdlEntityInclusion();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJdlDtoGenerationSettingRule());
            					}
            					set(
            						current,
            						"includes",
            						lv_includes_1_0,
            						"io.github.jhipster.jdl.JDL.JdlEntityInclusion");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalJDL.g:2072:3: ( (lv_dtoType_2_0= ruleJdlDtoType ) )
            // InternalJDL.g:2073:4: (lv_dtoType_2_0= ruleJdlDtoType )
            {
            // InternalJDL.g:2073:4: (lv_dtoType_2_0= ruleJdlDtoType )
            // InternalJDL.g:2074:5: lv_dtoType_2_0= ruleJdlDtoType
            {

            					newCompositeNode(grammarAccess.getJdlDtoGenerationSettingAccess().getDtoTypeJdlDtoTypeEnumRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_dtoType_2_0=ruleJdlDtoType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJdlDtoGenerationSettingRule());
            					}
            					set(
            						current,
            						"dtoType",
            						lv_dtoType_2_0,
            						"io.github.jhipster.jdl.JDL.JdlDtoType");
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
    // $ANTLR end "ruleJdlDtoGenerationSetting"


    // $ANTLR start "entryRuleJdlPaginateGenerationSetting"
    // InternalJDL.g:2095:1: entryRuleJdlPaginateGenerationSetting returns [EObject current=null] : iv_ruleJdlPaginateGenerationSetting= ruleJdlPaginateGenerationSetting EOF ;
    public final EObject entryRuleJdlPaginateGenerationSetting() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJdlPaginateGenerationSetting = null;


        try {
            // InternalJDL.g:2095:69: (iv_ruleJdlPaginateGenerationSetting= ruleJdlPaginateGenerationSetting EOF )
            // InternalJDL.g:2096:2: iv_ruleJdlPaginateGenerationSetting= ruleJdlPaginateGenerationSetting EOF
            {
             newCompositeNode(grammarAccess.getJdlPaginateGenerationSettingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlPaginateGenerationSetting=ruleJdlPaginateGenerationSetting();

            state._fsp--;

             current =iv_ruleJdlPaginateGenerationSetting; 
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
    // $ANTLR end "entryRuleJdlPaginateGenerationSetting"


    // $ANTLR start "ruleJdlPaginateGenerationSetting"
    // InternalJDL.g:2102:1: ruleJdlPaginateGenerationSetting returns [EObject current=null] : ( ( (lv_paginateGenerationSetting_0_0= 'paginate' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_paginateType_2_0= ruleJdlPaginateType ) ) ) ;
    public final EObject ruleJdlPaginateGenerationSetting() throws RecognitionException {
        EObject current = null;

        Token lv_paginateGenerationSetting_0_0=null;
        EObject lv_includes_1_0 = null;

        EObject lv_paginateType_2_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:2108:2: ( ( ( (lv_paginateGenerationSetting_0_0= 'paginate' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_paginateType_2_0= ruleJdlPaginateType ) ) ) )
            // InternalJDL.g:2109:2: ( ( (lv_paginateGenerationSetting_0_0= 'paginate' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_paginateType_2_0= ruleJdlPaginateType ) ) )
            {
            // InternalJDL.g:2109:2: ( ( (lv_paginateGenerationSetting_0_0= 'paginate' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_paginateType_2_0= ruleJdlPaginateType ) ) )
            // InternalJDL.g:2110:3: ( (lv_paginateGenerationSetting_0_0= 'paginate' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_paginateType_2_0= ruleJdlPaginateType ) )
            {
            // InternalJDL.g:2110:3: ( (lv_paginateGenerationSetting_0_0= 'paginate' ) )
            // InternalJDL.g:2111:4: (lv_paginateGenerationSetting_0_0= 'paginate' )
            {
            // InternalJDL.g:2111:4: (lv_paginateGenerationSetting_0_0= 'paginate' )
            // InternalJDL.g:2112:5: lv_paginateGenerationSetting_0_0= 'paginate'
            {
            lv_paginateGenerationSetting_0_0=(Token)match(input,36,FOLLOW_29); 

            					newLeafNode(lv_paginateGenerationSetting_0_0, grammarAccess.getJdlPaginateGenerationSettingAccess().getPaginateGenerationSettingPaginateKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJdlPaginateGenerationSettingRule());
            					}
            					setWithLastConsumed(current, "paginateGenerationSetting", true, "paginate");
            				

            }


            }

            // InternalJDL.g:2124:3: ( (lv_includes_1_0= ruleJdlEntityInclusion ) )
            // InternalJDL.g:2125:4: (lv_includes_1_0= ruleJdlEntityInclusion )
            {
            // InternalJDL.g:2125:4: (lv_includes_1_0= ruleJdlEntityInclusion )
            // InternalJDL.g:2126:5: lv_includes_1_0= ruleJdlEntityInclusion
            {

            					newCompositeNode(grammarAccess.getJdlPaginateGenerationSettingAccess().getIncludesJdlEntityInclusionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_32);
            lv_includes_1_0=ruleJdlEntityInclusion();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJdlPaginateGenerationSettingRule());
            					}
            					set(
            						current,
            						"includes",
            						lv_includes_1_0,
            						"io.github.jhipster.jdl.JDL.JdlEntityInclusion");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalJDL.g:2143:3: ( (lv_paginateType_2_0= ruleJdlPaginateType ) )
            // InternalJDL.g:2144:4: (lv_paginateType_2_0= ruleJdlPaginateType )
            {
            // InternalJDL.g:2144:4: (lv_paginateType_2_0= ruleJdlPaginateType )
            // InternalJDL.g:2145:5: lv_paginateType_2_0= ruleJdlPaginateType
            {

            					newCompositeNode(grammarAccess.getJdlPaginateGenerationSettingAccess().getPaginateTypeJdlPaginateTypeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_paginateType_2_0=ruleJdlPaginateType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJdlPaginateGenerationSettingRule());
            					}
            					set(
            						current,
            						"paginateType",
            						lv_paginateType_2_0,
            						"io.github.jhipster.jdl.JDL.JdlPaginateType");
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
    // $ANTLR end "ruleJdlPaginateGenerationSetting"


    // $ANTLR start "entryRuleJdlAngularSuffixGenerationSetting"
    // InternalJDL.g:2166:1: entryRuleJdlAngularSuffixGenerationSetting returns [EObject current=null] : iv_ruleJdlAngularSuffixGenerationSetting= ruleJdlAngularSuffixGenerationSetting EOF ;
    public final EObject entryRuleJdlAngularSuffixGenerationSetting() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJdlAngularSuffixGenerationSetting = null;


        try {
            // InternalJDL.g:2166:74: (iv_ruleJdlAngularSuffixGenerationSetting= ruleJdlAngularSuffixGenerationSetting EOF )
            // InternalJDL.g:2167:2: iv_ruleJdlAngularSuffixGenerationSetting= ruleJdlAngularSuffixGenerationSetting EOF
            {
             newCompositeNode(grammarAccess.getJdlAngularSuffixGenerationSettingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlAngularSuffixGenerationSetting=ruleJdlAngularSuffixGenerationSetting();

            state._fsp--;

             current =iv_ruleJdlAngularSuffixGenerationSetting; 
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
    // $ANTLR end "entryRuleJdlAngularSuffixGenerationSetting"


    // $ANTLR start "ruleJdlAngularSuffixGenerationSetting"
    // InternalJDL.g:2173:1: ruleJdlAngularSuffixGenerationSetting returns [EObject current=null] : ( ( (lv_angularSuffixGenerationSetting_0_0= 'angularSuffix' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_id_2_0= RULE_ID ) ) ) ;
    public final EObject ruleJdlAngularSuffixGenerationSetting() throws RecognitionException {
        EObject current = null;

        Token lv_angularSuffixGenerationSetting_0_0=null;
        Token lv_id_2_0=null;
        EObject lv_includes_1_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:2179:2: ( ( ( (lv_angularSuffixGenerationSetting_0_0= 'angularSuffix' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_id_2_0= RULE_ID ) ) ) )
            // InternalJDL.g:2180:2: ( ( (lv_angularSuffixGenerationSetting_0_0= 'angularSuffix' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_id_2_0= RULE_ID ) ) )
            {
            // InternalJDL.g:2180:2: ( ( (lv_angularSuffixGenerationSetting_0_0= 'angularSuffix' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_id_2_0= RULE_ID ) ) )
            // InternalJDL.g:2181:3: ( (lv_angularSuffixGenerationSetting_0_0= 'angularSuffix' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_id_2_0= RULE_ID ) )
            {
            // InternalJDL.g:2181:3: ( (lv_angularSuffixGenerationSetting_0_0= 'angularSuffix' ) )
            // InternalJDL.g:2182:4: (lv_angularSuffixGenerationSetting_0_0= 'angularSuffix' )
            {
            // InternalJDL.g:2182:4: (lv_angularSuffixGenerationSetting_0_0= 'angularSuffix' )
            // InternalJDL.g:2183:5: lv_angularSuffixGenerationSetting_0_0= 'angularSuffix'
            {
            lv_angularSuffixGenerationSetting_0_0=(Token)match(input,37,FOLLOW_29); 

            					newLeafNode(lv_angularSuffixGenerationSetting_0_0, grammarAccess.getJdlAngularSuffixGenerationSettingAccess().getAngularSuffixGenerationSettingAngularSuffixKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJdlAngularSuffixGenerationSettingRule());
            					}
            					setWithLastConsumed(current, "angularSuffixGenerationSetting", true, "angularSuffix");
            				

            }


            }

            // InternalJDL.g:2195:3: ( (lv_includes_1_0= ruleJdlEntityInclusion ) )
            // InternalJDL.g:2196:4: (lv_includes_1_0= ruleJdlEntityInclusion )
            {
            // InternalJDL.g:2196:4: (lv_includes_1_0= ruleJdlEntityInclusion )
            // InternalJDL.g:2197:5: lv_includes_1_0= ruleJdlEntityInclusion
            {

            					newCompositeNode(grammarAccess.getJdlAngularSuffixGenerationSettingAccess().getIncludesJdlEntityInclusionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_includes_1_0=ruleJdlEntityInclusion();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJdlAngularSuffixGenerationSettingRule());
            					}
            					set(
            						current,
            						"includes",
            						lv_includes_1_0,
            						"io.github.jhipster.jdl.JDL.JdlEntityInclusion");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalJDL.g:2214:3: ( (lv_id_2_0= RULE_ID ) )
            // InternalJDL.g:2215:4: (lv_id_2_0= RULE_ID )
            {
            // InternalJDL.g:2215:4: (lv_id_2_0= RULE_ID )
            // InternalJDL.g:2216:5: lv_id_2_0= RULE_ID
            {
            lv_id_2_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_id_2_0, grammarAccess.getJdlAngularSuffixGenerationSettingAccess().getIdIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJdlAngularSuffixGenerationSettingRule());
            					}
            					setWithLastConsumed(
            						current,
            						"id",
            						lv_id_2_0,
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
    // $ANTLR end "ruleJdlAngularSuffixGenerationSetting"


    // $ANTLR start "entryRuleJdlEntityInclusion"
    // InternalJDL.g:2236:1: entryRuleJdlEntityInclusion returns [EObject current=null] : iv_ruleJdlEntityInclusion= ruleJdlEntityInclusion EOF ;
    public final EObject entryRuleJdlEntityInclusion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJdlEntityInclusion = null;


        try {
            // InternalJDL.g:2236:59: (iv_ruleJdlEntityInclusion= ruleJdlEntityInclusion EOF )
            // InternalJDL.g:2237:2: iv_ruleJdlEntityInclusion= ruleJdlEntityInclusion EOF
            {
             newCompositeNode(grammarAccess.getJdlEntityInclusionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlEntityInclusion=ruleJdlEntityInclusion();

            state._fsp--;

             current =iv_ruleJdlEntityInclusion; 
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
    // $ANTLR end "entryRuleJdlEntityInclusion"


    // $ANTLR start "ruleJdlEntityInclusion"
    // InternalJDL.g:2243:1: ruleJdlEntityInclusion returns [EObject current=null] : ( ( ( (lv_predicate_0_0= ruleJdlWildcardPredicate ) ) | ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* ) ) otherlv_4= 'with' ) ;
    public final EObject ruleJdlEntityInclusion() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_predicate_0_0 = null;



        	enterRule();

        try {
            // InternalJDL.g:2249:2: ( ( ( ( (lv_predicate_0_0= ruleJdlWildcardPredicate ) ) | ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* ) ) otherlv_4= 'with' ) )
            // InternalJDL.g:2250:2: ( ( ( (lv_predicate_0_0= ruleJdlWildcardPredicate ) ) | ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* ) ) otherlv_4= 'with' )
            {
            // InternalJDL.g:2250:2: ( ( ( (lv_predicate_0_0= ruleJdlWildcardPredicate ) ) | ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* ) ) otherlv_4= 'with' )
            // InternalJDL.g:2251:3: ( ( (lv_predicate_0_0= ruleJdlWildcardPredicate ) ) | ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* ) ) otherlv_4= 'with'
            {
            // InternalJDL.g:2251:3: ( ( (lv_predicate_0_0= ruleJdlWildcardPredicate ) ) | ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* ) )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=40 && LA30_0<=41)) ) {
                alt30=1;
            }
            else if ( (LA30_0==RULE_ID) ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // InternalJDL.g:2252:4: ( (lv_predicate_0_0= ruleJdlWildcardPredicate ) )
                    {
                    // InternalJDL.g:2252:4: ( (lv_predicate_0_0= ruleJdlWildcardPredicate ) )
                    // InternalJDL.g:2253:5: (lv_predicate_0_0= ruleJdlWildcardPredicate )
                    {
                    // InternalJDL.g:2253:5: (lv_predicate_0_0= ruleJdlWildcardPredicate )
                    // InternalJDL.g:2254:6: lv_predicate_0_0= ruleJdlWildcardPredicate
                    {

                    						newCompositeNode(grammarAccess.getJdlEntityInclusionAccess().getPredicateJdlWildcardPredicateParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_33);
                    lv_predicate_0_0=ruleJdlWildcardPredicate();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getJdlEntityInclusionRule());
                    						}
                    						set(
                    							current,
                    							"predicate",
                    							lv_predicate_0_0,
                    							"io.github.jhipster.jdl.JDL.JdlWildcardPredicate");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalJDL.g:2272:4: ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )
                    {
                    // InternalJDL.g:2272:4: ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )
                    // InternalJDL.g:2273:5: ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
                    {
                    // InternalJDL.g:2273:5: ( (otherlv_1= RULE_ID ) )
                    // InternalJDL.g:2274:6: (otherlv_1= RULE_ID )
                    {
                    // InternalJDL.g:2274:6: (otherlv_1= RULE_ID )
                    // InternalJDL.g:2275:7: otherlv_1= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getJdlEntityInclusionRule());
                    							}
                    						
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_34); 

                    							newLeafNode(otherlv_1, grammarAccess.getJdlEntityInclusionAccess().getEntitiesJdlEntityCrossReference_0_1_0_0());
                    						

                    }


                    }

                    // InternalJDL.g:2286:5: (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==13) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // InternalJDL.g:2287:6: otherlv_2= ',' ( (otherlv_3= RULE_ID ) )
                    	    {
                    	    otherlv_2=(Token)match(input,13,FOLLOW_4); 

                    	    						newLeafNode(otherlv_2, grammarAccess.getJdlEntityInclusionAccess().getCommaKeyword_0_1_1_0());
                    	    					
                    	    // InternalJDL.g:2291:6: ( (otherlv_3= RULE_ID ) )
                    	    // InternalJDL.g:2292:7: (otherlv_3= RULE_ID )
                    	    {
                    	    // InternalJDL.g:2292:7: (otherlv_3= RULE_ID )
                    	    // InternalJDL.g:2293:8: otherlv_3= RULE_ID
                    	    {

                    	    								if (current==null) {
                    	    									current = createModelElement(grammarAccess.getJdlEntityInclusionRule());
                    	    								}
                    	    							
                    	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_34); 

                    	    								newLeafNode(otherlv_3, grammarAccess.getJdlEntityInclusionAccess().getEntitiesJdlEntityCrossReference_0_1_1_1_0());
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,38,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getJdlEntityInclusionAccess().getWithKeyword_1());
            		

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
    // $ANTLR end "ruleJdlEntityInclusion"


    // $ANTLR start "entryRuleJdlEntityExclusion"
    // InternalJDL.g:2315:1: entryRuleJdlEntityExclusion returns [EObject current=null] : iv_ruleJdlEntityExclusion= ruleJdlEntityExclusion EOF ;
    public final EObject entryRuleJdlEntityExclusion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJdlEntityExclusion = null;


        try {
            // InternalJDL.g:2315:59: (iv_ruleJdlEntityExclusion= ruleJdlEntityExclusion EOF )
            // InternalJDL.g:2316:2: iv_ruleJdlEntityExclusion= ruleJdlEntityExclusion EOF
            {
             newCompositeNode(grammarAccess.getJdlEntityExclusionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlEntityExclusion=ruleJdlEntityExclusion();

            state._fsp--;

             current =iv_ruleJdlEntityExclusion; 
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
    // $ANTLR end "entryRuleJdlEntityExclusion"


    // $ANTLR start "ruleJdlEntityExclusion"
    // InternalJDL.g:2322:1: ruleJdlEntityExclusion returns [EObject current=null] : (otherlv_0= 'except' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* ) ;
    public final EObject ruleJdlEntityExclusion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalJDL.g:2328:2: ( (otherlv_0= 'except' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* ) )
            // InternalJDL.g:2329:2: (otherlv_0= 'except' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )
            {
            // InternalJDL.g:2329:2: (otherlv_0= 'except' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )
            // InternalJDL.g:2330:3: otherlv_0= 'except' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
            {
            otherlv_0=(Token)match(input,39,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getJdlEntityExclusionAccess().getExceptKeyword_0());
            		
            // InternalJDL.g:2334:3: ( (otherlv_1= RULE_ID ) )
            // InternalJDL.g:2335:4: (otherlv_1= RULE_ID )
            {
            // InternalJDL.g:2335:4: (otherlv_1= RULE_ID )
            // InternalJDL.g:2336:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJdlEntityExclusionRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_35); 

            					newLeafNode(otherlv_1, grammarAccess.getJdlEntityExclusionAccess().getEntitiesJdlEntityCrossReference_1_0());
            				

            }


            }

            // InternalJDL.g:2347:3: (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==13) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalJDL.g:2348:4: otherlv_2= ',' ( (otherlv_3= RULE_ID ) )
            	    {
            	    otherlv_2=(Token)match(input,13,FOLLOW_4); 

            	    				newLeafNode(otherlv_2, grammarAccess.getJdlEntityExclusionAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalJDL.g:2352:4: ( (otherlv_3= RULE_ID ) )
            	    // InternalJDL.g:2353:5: (otherlv_3= RULE_ID )
            	    {
            	    // InternalJDL.g:2353:5: (otherlv_3= RULE_ID )
            	    // InternalJDL.g:2354:6: otherlv_3= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getJdlEntityExclusionRule());
            	    						}
            	    					
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_35); 

            	    						newLeafNode(otherlv_3, grammarAccess.getJdlEntityExclusionAccess().getEntitiesJdlEntityCrossReference_2_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);


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
    // $ANTLR end "ruleJdlEntityExclusion"


    // $ANTLR start "entryRuleJdlWildcardPredicate"
    // InternalJDL.g:2370:1: entryRuleJdlWildcardPredicate returns [EObject current=null] : iv_ruleJdlWildcardPredicate= ruleJdlWildcardPredicate EOF ;
    public final EObject entryRuleJdlWildcardPredicate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJdlWildcardPredicate = null;


        try {
            // InternalJDL.g:2370:61: (iv_ruleJdlWildcardPredicate= ruleJdlWildcardPredicate EOF )
            // InternalJDL.g:2371:2: iv_ruleJdlWildcardPredicate= ruleJdlWildcardPredicate EOF
            {
             newCompositeNode(grammarAccess.getJdlWildcardPredicateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlWildcardPredicate=ruleJdlWildcardPredicate();

            state._fsp--;

             current =iv_ruleJdlWildcardPredicate; 
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
    // $ANTLR end "entryRuleJdlWildcardPredicate"


    // $ANTLR start "ruleJdlWildcardPredicate"
    // InternalJDL.g:2377:1: ruleJdlWildcardPredicate returns [EObject current=null] : ( ( (lv_wildcard_0_0= '*' ) ) | ( (lv_all_1_0= 'all' ) ) ) ;
    public final EObject ruleJdlWildcardPredicate() throws RecognitionException {
        EObject current = null;

        Token lv_wildcard_0_0=null;
        Token lv_all_1_0=null;


        	enterRule();

        try {
            // InternalJDL.g:2383:2: ( ( ( (lv_wildcard_0_0= '*' ) ) | ( (lv_all_1_0= 'all' ) ) ) )
            // InternalJDL.g:2384:2: ( ( (lv_wildcard_0_0= '*' ) ) | ( (lv_all_1_0= 'all' ) ) )
            {
            // InternalJDL.g:2384:2: ( ( (lv_wildcard_0_0= '*' ) ) | ( (lv_all_1_0= 'all' ) ) )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==40) ) {
                alt32=1;
            }
            else if ( (LA32_0==41) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // InternalJDL.g:2385:3: ( (lv_wildcard_0_0= '*' ) )
                    {
                    // InternalJDL.g:2385:3: ( (lv_wildcard_0_0= '*' ) )
                    // InternalJDL.g:2386:4: (lv_wildcard_0_0= '*' )
                    {
                    // InternalJDL.g:2386:4: (lv_wildcard_0_0= '*' )
                    // InternalJDL.g:2387:5: lv_wildcard_0_0= '*'
                    {
                    lv_wildcard_0_0=(Token)match(input,40,FOLLOW_2); 

                    					newLeafNode(lv_wildcard_0_0, grammarAccess.getJdlWildcardPredicateAccess().getWildcardAsteriskKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getJdlWildcardPredicateRule());
                    					}
                    					setWithLastConsumed(current, "wildcard", true, "*");
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalJDL.g:2400:3: ( (lv_all_1_0= 'all' ) )
                    {
                    // InternalJDL.g:2400:3: ( (lv_all_1_0= 'all' ) )
                    // InternalJDL.g:2401:4: (lv_all_1_0= 'all' )
                    {
                    // InternalJDL.g:2401:4: (lv_all_1_0= 'all' )
                    // InternalJDL.g:2402:5: lv_all_1_0= 'all'
                    {
                    lv_all_1_0=(Token)match(input,41,FOLLOW_2); 

                    					newLeafNode(lv_all_1_0, grammarAccess.getJdlWildcardPredicateAccess().getAllAllKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getJdlWildcardPredicateRule());
                    					}
                    					setWithLastConsumed(current, "all", true, "all");
                    				

                    }


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
    // $ANTLR end "ruleJdlWildcardPredicate"


    // $ANTLR start "entryRuleJdlPaginateType"
    // InternalJDL.g:2418:1: entryRuleJdlPaginateType returns [EObject current=null] : iv_ruleJdlPaginateType= ruleJdlPaginateType EOF ;
    public final EObject entryRuleJdlPaginateType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJdlPaginateType = null;


        try {
            // InternalJDL.g:2418:56: (iv_ruleJdlPaginateType= ruleJdlPaginateType EOF )
            // InternalJDL.g:2419:2: iv_ruleJdlPaginateType= ruleJdlPaginateType EOF
            {
             newCompositeNode(grammarAccess.getJdlPaginateTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlPaginateType=ruleJdlPaginateType();

            state._fsp--;

             current =iv_ruleJdlPaginateType; 
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
    // $ANTLR end "entryRuleJdlPaginateType"


    // $ANTLR start "ruleJdlPaginateType"
    // InternalJDL.g:2425:1: ruleJdlPaginateType returns [EObject current=null] : ( ( ( (lv_pagination_0_1= 'pager' | lv_pagination_0_2= 'pagination' ) ) ) | ( (lv_infiniteScroll_1_0= 'infinite-scroll' ) ) ) ;
    public final EObject ruleJdlPaginateType() throws RecognitionException {
        EObject current = null;

        Token lv_pagination_0_1=null;
        Token lv_pagination_0_2=null;
        Token lv_infiniteScroll_1_0=null;


        	enterRule();

        try {
            // InternalJDL.g:2431:2: ( ( ( ( (lv_pagination_0_1= 'pager' | lv_pagination_0_2= 'pagination' ) ) ) | ( (lv_infiniteScroll_1_0= 'infinite-scroll' ) ) ) )
            // InternalJDL.g:2432:2: ( ( ( (lv_pagination_0_1= 'pager' | lv_pagination_0_2= 'pagination' ) ) ) | ( (lv_infiniteScroll_1_0= 'infinite-scroll' ) ) )
            {
            // InternalJDL.g:2432:2: ( ( ( (lv_pagination_0_1= 'pager' | lv_pagination_0_2= 'pagination' ) ) ) | ( (lv_infiniteScroll_1_0= 'infinite-scroll' ) ) )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( ((LA34_0>=42 && LA34_0<=43)) ) {
                alt34=1;
            }
            else if ( (LA34_0==44) ) {
                alt34=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // InternalJDL.g:2433:3: ( ( (lv_pagination_0_1= 'pager' | lv_pagination_0_2= 'pagination' ) ) )
                    {
                    // InternalJDL.g:2433:3: ( ( (lv_pagination_0_1= 'pager' | lv_pagination_0_2= 'pagination' ) ) )
                    // InternalJDL.g:2434:4: ( (lv_pagination_0_1= 'pager' | lv_pagination_0_2= 'pagination' ) )
                    {
                    // InternalJDL.g:2434:4: ( (lv_pagination_0_1= 'pager' | lv_pagination_0_2= 'pagination' ) )
                    // InternalJDL.g:2435:5: (lv_pagination_0_1= 'pager' | lv_pagination_0_2= 'pagination' )
                    {
                    // InternalJDL.g:2435:5: (lv_pagination_0_1= 'pager' | lv_pagination_0_2= 'pagination' )
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==42) ) {
                        alt33=1;
                    }
                    else if ( (LA33_0==43) ) {
                        alt33=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 33, 0, input);

                        throw nvae;
                    }
                    switch (alt33) {
                        case 1 :
                            // InternalJDL.g:2436:6: lv_pagination_0_1= 'pager'
                            {
                            lv_pagination_0_1=(Token)match(input,42,FOLLOW_2); 

                            						newLeafNode(lv_pagination_0_1, grammarAccess.getJdlPaginateTypeAccess().getPaginationPagerKeyword_0_0_0());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getJdlPaginateTypeRule());
                            						}
                            						setWithLastConsumed(current, "pagination", true, null);
                            					

                            }
                            break;
                        case 2 :
                            // InternalJDL.g:2447:6: lv_pagination_0_2= 'pagination'
                            {
                            lv_pagination_0_2=(Token)match(input,43,FOLLOW_2); 

                            						newLeafNode(lv_pagination_0_2, grammarAccess.getJdlPaginateTypeAccess().getPaginationPaginationKeyword_0_0_1());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getJdlPaginateTypeRule());
                            						}
                            						setWithLastConsumed(current, "pagination", true, null);
                            					

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalJDL.g:2461:3: ( (lv_infiniteScroll_1_0= 'infinite-scroll' ) )
                    {
                    // InternalJDL.g:2461:3: ( (lv_infiniteScroll_1_0= 'infinite-scroll' ) )
                    // InternalJDL.g:2462:4: (lv_infiniteScroll_1_0= 'infinite-scroll' )
                    {
                    // InternalJDL.g:2462:4: (lv_infiniteScroll_1_0= 'infinite-scroll' )
                    // InternalJDL.g:2463:5: lv_infiniteScroll_1_0= 'infinite-scroll'
                    {
                    lv_infiniteScroll_1_0=(Token)match(input,44,FOLLOW_2); 

                    					newLeafNode(lv_infiniteScroll_1_0, grammarAccess.getJdlPaginateTypeAccess().getInfiniteScrollInfiniteScrollKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getJdlPaginateTypeRule());
                    					}
                    					setWithLastConsumed(current, "infiniteScroll", true, "infinite-scroll");
                    				

                    }


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
    // $ANTLR end "ruleJdlPaginateType"


    // $ANTLR start "ruleJdlNumericFieldType"
    // InternalJDL.g:2479:1: ruleJdlNumericFieldType returns [Enumerator current=null] : ( (enumLiteral_0= 'Integer' ) | (enumLiteral_1= 'Long' ) | (enumLiteral_2= 'BigDecimal' ) | (enumLiteral_3= 'Float' ) | (enumLiteral_4= 'Double' ) ) ;
    public final Enumerator ruleJdlNumericFieldType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalJDL.g:2485:2: ( ( (enumLiteral_0= 'Integer' ) | (enumLiteral_1= 'Long' ) | (enumLiteral_2= 'BigDecimal' ) | (enumLiteral_3= 'Float' ) | (enumLiteral_4= 'Double' ) ) )
            // InternalJDL.g:2486:2: ( (enumLiteral_0= 'Integer' ) | (enumLiteral_1= 'Long' ) | (enumLiteral_2= 'BigDecimal' ) | (enumLiteral_3= 'Float' ) | (enumLiteral_4= 'Double' ) )
            {
            // InternalJDL.g:2486:2: ( (enumLiteral_0= 'Integer' ) | (enumLiteral_1= 'Long' ) | (enumLiteral_2= 'BigDecimal' ) | (enumLiteral_3= 'Float' ) | (enumLiteral_4= 'Double' ) )
            int alt35=5;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt35=1;
                }
                break;
            case 46:
                {
                alt35=2;
                }
                break;
            case 47:
                {
                alt35=3;
                }
                break;
            case 48:
                {
                alt35=4;
                }
                break;
            case 49:
                {
                alt35=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // InternalJDL.g:2487:3: (enumLiteral_0= 'Integer' )
                    {
                    // InternalJDL.g:2487:3: (enumLiteral_0= 'Integer' )
                    // InternalJDL.g:2488:4: enumLiteral_0= 'Integer'
                    {
                    enumLiteral_0=(Token)match(input,45,FOLLOW_2); 

                    				current = grammarAccess.getJdlNumericFieldTypeAccess().getIntegerEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getJdlNumericFieldTypeAccess().getIntegerEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalJDL.g:2495:3: (enumLiteral_1= 'Long' )
                    {
                    // InternalJDL.g:2495:3: (enumLiteral_1= 'Long' )
                    // InternalJDL.g:2496:4: enumLiteral_1= 'Long'
                    {
                    enumLiteral_1=(Token)match(input,46,FOLLOW_2); 

                    				current = grammarAccess.getJdlNumericFieldTypeAccess().getLongEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getJdlNumericFieldTypeAccess().getLongEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalJDL.g:2503:3: (enumLiteral_2= 'BigDecimal' )
                    {
                    // InternalJDL.g:2503:3: (enumLiteral_2= 'BigDecimal' )
                    // InternalJDL.g:2504:4: enumLiteral_2= 'BigDecimal'
                    {
                    enumLiteral_2=(Token)match(input,47,FOLLOW_2); 

                    				current = grammarAccess.getJdlNumericFieldTypeAccess().getBigDecimalEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getJdlNumericFieldTypeAccess().getBigDecimalEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalJDL.g:2511:3: (enumLiteral_3= 'Float' )
                    {
                    // InternalJDL.g:2511:3: (enumLiteral_3= 'Float' )
                    // InternalJDL.g:2512:4: enumLiteral_3= 'Float'
                    {
                    enumLiteral_3=(Token)match(input,48,FOLLOW_2); 

                    				current = grammarAccess.getJdlNumericFieldTypeAccess().getFloatEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getJdlNumericFieldTypeAccess().getFloatEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalJDL.g:2519:3: (enumLiteral_4= 'Double' )
                    {
                    // InternalJDL.g:2519:3: (enumLiteral_4= 'Double' )
                    // InternalJDL.g:2520:4: enumLiteral_4= 'Double'
                    {
                    enumLiteral_4=(Token)match(input,49,FOLLOW_2); 

                    				current = grammarAccess.getJdlNumericFieldTypeAccess().getDoubleEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getJdlNumericFieldTypeAccess().getDoubleEnumLiteralDeclaration_4());
                    			

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
    // $ANTLR end "ruleJdlNumericFieldType"


    // $ANTLR start "ruleJdlBlobFieldType"
    // InternalJDL.g:2530:1: ruleJdlBlobFieldType returns [Enumerator current=null] : ( (enumLiteral_0= 'Blob' ) | (enumLiteral_1= 'AnyBlob' ) | (enumLiteral_2= 'ImageBlob' ) ) ;
    public final Enumerator ruleJdlBlobFieldType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalJDL.g:2536:2: ( ( (enumLiteral_0= 'Blob' ) | (enumLiteral_1= 'AnyBlob' ) | (enumLiteral_2= 'ImageBlob' ) ) )
            // InternalJDL.g:2537:2: ( (enumLiteral_0= 'Blob' ) | (enumLiteral_1= 'AnyBlob' ) | (enumLiteral_2= 'ImageBlob' ) )
            {
            // InternalJDL.g:2537:2: ( (enumLiteral_0= 'Blob' ) | (enumLiteral_1= 'AnyBlob' ) | (enumLiteral_2= 'ImageBlob' ) )
            int alt36=3;
            switch ( input.LA(1) ) {
            case 50:
                {
                alt36=1;
                }
                break;
            case 51:
                {
                alt36=2;
                }
                break;
            case 52:
                {
                alt36=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // InternalJDL.g:2538:3: (enumLiteral_0= 'Blob' )
                    {
                    // InternalJDL.g:2538:3: (enumLiteral_0= 'Blob' )
                    // InternalJDL.g:2539:4: enumLiteral_0= 'Blob'
                    {
                    enumLiteral_0=(Token)match(input,50,FOLLOW_2); 

                    				current = grammarAccess.getJdlBlobFieldTypeAccess().getBlobEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getJdlBlobFieldTypeAccess().getBlobEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalJDL.g:2546:3: (enumLiteral_1= 'AnyBlob' )
                    {
                    // InternalJDL.g:2546:3: (enumLiteral_1= 'AnyBlob' )
                    // InternalJDL.g:2547:4: enumLiteral_1= 'AnyBlob'
                    {
                    enumLiteral_1=(Token)match(input,51,FOLLOW_2); 

                    				current = grammarAccess.getJdlBlobFieldTypeAccess().getAnyBlobEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getJdlBlobFieldTypeAccess().getAnyBlobEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalJDL.g:2554:3: (enumLiteral_2= 'ImageBlob' )
                    {
                    // InternalJDL.g:2554:3: (enumLiteral_2= 'ImageBlob' )
                    // InternalJDL.g:2555:4: enumLiteral_2= 'ImageBlob'
                    {
                    enumLiteral_2=(Token)match(input,52,FOLLOW_2); 

                    				current = grammarAccess.getJdlBlobFieldTypeAccess().getImageBlobEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getJdlBlobFieldTypeAccess().getImageBlobEnumLiteralDeclaration_2());
                    			

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
    // $ANTLR end "ruleJdlBlobFieldType"


    // $ANTLR start "ruleJdlCardinality"
    // InternalJDL.g:2565:1: ruleJdlCardinality returns [Enumerator current=null] : ( (enumLiteral_0= 'OneToMany' ) | (enumLiteral_1= 'ManyToOne' ) | (enumLiteral_2= 'OneToOne' ) | (enumLiteral_3= 'ManyToMany' ) ) ;
    public final Enumerator ruleJdlCardinality() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalJDL.g:2571:2: ( ( (enumLiteral_0= 'OneToMany' ) | (enumLiteral_1= 'ManyToOne' ) | (enumLiteral_2= 'OneToOne' ) | (enumLiteral_3= 'ManyToMany' ) ) )
            // InternalJDL.g:2572:2: ( (enumLiteral_0= 'OneToMany' ) | (enumLiteral_1= 'ManyToOne' ) | (enumLiteral_2= 'OneToOne' ) | (enumLiteral_3= 'ManyToMany' ) )
            {
            // InternalJDL.g:2572:2: ( (enumLiteral_0= 'OneToMany' ) | (enumLiteral_1= 'ManyToOne' ) | (enumLiteral_2= 'OneToOne' ) | (enumLiteral_3= 'ManyToMany' ) )
            int alt37=4;
            switch ( input.LA(1) ) {
            case 53:
                {
                alt37=1;
                }
                break;
            case 54:
                {
                alt37=2;
                }
                break;
            case 55:
                {
                alt37=3;
                }
                break;
            case 56:
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
                    // InternalJDL.g:2573:3: (enumLiteral_0= 'OneToMany' )
                    {
                    // InternalJDL.g:2573:3: (enumLiteral_0= 'OneToMany' )
                    // InternalJDL.g:2574:4: enumLiteral_0= 'OneToMany'
                    {
                    enumLiteral_0=(Token)match(input,53,FOLLOW_2); 

                    				current = grammarAccess.getJdlCardinalityAccess().getOneToManyEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getJdlCardinalityAccess().getOneToManyEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalJDL.g:2581:3: (enumLiteral_1= 'ManyToOne' )
                    {
                    // InternalJDL.g:2581:3: (enumLiteral_1= 'ManyToOne' )
                    // InternalJDL.g:2582:4: enumLiteral_1= 'ManyToOne'
                    {
                    enumLiteral_1=(Token)match(input,54,FOLLOW_2); 

                    				current = grammarAccess.getJdlCardinalityAccess().getManyToOneEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getJdlCardinalityAccess().getManyToOneEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalJDL.g:2589:3: (enumLiteral_2= 'OneToOne' )
                    {
                    // InternalJDL.g:2589:3: (enumLiteral_2= 'OneToOne' )
                    // InternalJDL.g:2590:4: enumLiteral_2= 'OneToOne'
                    {
                    enumLiteral_2=(Token)match(input,55,FOLLOW_2); 

                    				current = grammarAccess.getJdlCardinalityAccess().getOneToOneEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getJdlCardinalityAccess().getOneToOneEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalJDL.g:2597:3: (enumLiteral_3= 'ManyToMany' )
                    {
                    // InternalJDL.g:2597:3: (enumLiteral_3= 'ManyToMany' )
                    // InternalJDL.g:2598:4: enumLiteral_3= 'ManyToMany'
                    {
                    enumLiteral_3=(Token)match(input,56,FOLLOW_2); 

                    				current = grammarAccess.getJdlCardinalityAccess().getManyToManyEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getJdlCardinalityAccess().getManyToManyEnumLiteralDeclaration_3());
                    			

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
    // $ANTLR end "ruleJdlCardinality"


    // $ANTLR start "ruleJdlServiceType"
    // InternalJDL.g:2608:1: ruleJdlServiceType returns [Enumerator current=null] : ( (enumLiteral_0= 'serviceClass' ) | (enumLiteral_1= 'serviceImpl' ) ) ;
    public final Enumerator ruleJdlServiceType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalJDL.g:2614:2: ( ( (enumLiteral_0= 'serviceClass' ) | (enumLiteral_1= 'serviceImpl' ) ) )
            // InternalJDL.g:2615:2: ( (enumLiteral_0= 'serviceClass' ) | (enumLiteral_1= 'serviceImpl' ) )
            {
            // InternalJDL.g:2615:2: ( (enumLiteral_0= 'serviceClass' ) | (enumLiteral_1= 'serviceImpl' ) )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==57) ) {
                alt38=1;
            }
            else if ( (LA38_0==58) ) {
                alt38=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // InternalJDL.g:2616:3: (enumLiteral_0= 'serviceClass' )
                    {
                    // InternalJDL.g:2616:3: (enumLiteral_0= 'serviceClass' )
                    // InternalJDL.g:2617:4: enumLiteral_0= 'serviceClass'
                    {
                    enumLiteral_0=(Token)match(input,57,FOLLOW_2); 

                    				current = grammarAccess.getJdlServiceTypeAccess().getServiceClassEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getJdlServiceTypeAccess().getServiceClassEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalJDL.g:2624:3: (enumLiteral_1= 'serviceImpl' )
                    {
                    // InternalJDL.g:2624:3: (enumLiteral_1= 'serviceImpl' )
                    // InternalJDL.g:2625:4: enumLiteral_1= 'serviceImpl'
                    {
                    enumLiteral_1=(Token)match(input,58,FOLLOW_2); 

                    				current = grammarAccess.getJdlServiceTypeAccess().getServiceImplEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getJdlServiceTypeAccess().getServiceImplEnumLiteralDeclaration_1());
                    			

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
    // $ANTLR end "ruleJdlServiceType"


    // $ANTLR start "ruleJdlDtoType"
    // InternalJDL.g:2635:1: ruleJdlDtoType returns [Enumerator current=null] : (enumLiteral_0= 'mapstruct' ) ;
    public final Enumerator ruleJdlDtoType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;


        	enterRule();

        try {
            // InternalJDL.g:2641:2: ( (enumLiteral_0= 'mapstruct' ) )
            // InternalJDL.g:2642:2: (enumLiteral_0= 'mapstruct' )
            {
            // InternalJDL.g:2642:2: (enumLiteral_0= 'mapstruct' )
            // InternalJDL.g:2643:3: enumLiteral_0= 'mapstruct'
            {
            enumLiteral_0=(Token)match(input,59,FOLLOW_2); 

            			current = grammarAccess.getJdlDtoTypeAccess().getMapstructEnumLiteralDeclaration().getEnumLiteral().getInstance();
            			newLeafNode(enumLiteral_0, grammarAccess.getJdlDtoTypeAccess().getMapstructEnumLiteralDeclaration());
            		

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
    // $ANTLR end "ruleJdlDtoType"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000003FA0000802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x001FE00000078010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000001900002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000001800002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000006000002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x01E0000000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000006010L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000040001000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000204000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000030000000010L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0600000000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x00001C0000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000004000002000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000002002L});

}