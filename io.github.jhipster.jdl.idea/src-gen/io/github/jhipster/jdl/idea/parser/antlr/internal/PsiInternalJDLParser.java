package io.github.jhipster.jdl.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import io.github.jhipster.jdl.idea.lang.JDLElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import io.github.jhipster.jdl.services.JDLGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalJDLParser extends AbstractPsiAntlrParser {
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


        public PsiInternalJDLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalJDLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalJDLParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalJDL.g"; }



    	protected JDLGrammarAccess grammarAccess;

    	protected JDLElementTypeProvider elementTypeProvider;

    	public PsiInternalJDLParser(PsiBuilder builder, TokenStream input, JDLElementTypeProvider elementTypeProvider, JDLGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
    		this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "JdlDomainModel";
    	}




    // $ANTLR start "entryRuleJdlDomainModel"
    // PsiInternalJDL.g:52:1: entryRuleJdlDomainModel returns [Boolean current=false] : iv_ruleJdlDomainModel= ruleJdlDomainModel EOF ;
    public final Boolean entryRuleJdlDomainModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJdlDomainModel = null;


        try {
            // PsiInternalJDL.g:52:56: (iv_ruleJdlDomainModel= ruleJdlDomainModel EOF )
            // PsiInternalJDL.g:53:2: iv_ruleJdlDomainModel= ruleJdlDomainModel EOF
            {
             markComposite(elementTypeProvider.getJdlDomainModelElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlDomainModel=ruleJdlDomainModel();

            state._fsp--;

             current =iv_ruleJdlDomainModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJdlDomainModel"


    // $ANTLR start "ruleJdlDomainModel"
    // PsiInternalJDL.g:59:1: ruleJdlDomainModel returns [Boolean current=false] : ( (lv_features_0_0= ruleJdlFeature ) )* ;
    public final Boolean ruleJdlDomainModel() throws RecognitionException {
        Boolean current = false;

        Boolean lv_features_0_0 = null;


        try {
            // PsiInternalJDL.g:60:1: ( ( (lv_features_0_0= ruleJdlFeature ) )* )
            // PsiInternalJDL.g:61:2: ( (lv_features_0_0= ruleJdlFeature ) )*
            {
            // PsiInternalJDL.g:61:2: ( (lv_features_0_0= ruleJdlFeature ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11||LA1_0==29||(LA1_0>=31 && LA1_0<=37)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalJDL.g:62:3: (lv_features_0_0= ruleJdlFeature )
            	    {
            	    // PsiInternalJDL.g:62:3: (lv_features_0_0= ruleJdlFeature )
            	    // PsiInternalJDL.g:63:4: lv_features_0_0= ruleJdlFeature
            	    {

            	    				markComposite(elementTypeProvider.getJdlDomainModel_FeaturesJdlFeatureParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_features_0_0=ruleJdlFeature();

            	    state._fsp--;


            	    				doneComposite();
            	    				if(!current) {
            	    					associateWithSemanticElement();
            	    					current = true;
            	    				}
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlDomainModel"


    // $ANTLR start "entryRuleJdlFeature"
    // PsiInternalJDL.g:79:1: entryRuleJdlFeature returns [Boolean current=false] : iv_ruleJdlFeature= ruleJdlFeature EOF ;
    public final Boolean entryRuleJdlFeature() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJdlFeature = null;


        try {
            // PsiInternalJDL.g:79:52: (iv_ruleJdlFeature= ruleJdlFeature EOF )
            // PsiInternalJDL.g:80:2: iv_ruleJdlFeature= ruleJdlFeature EOF
            {
             markComposite(elementTypeProvider.getJdlFeatureElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlFeature=ruleJdlFeature();

            state._fsp--;

             current =iv_ruleJdlFeature; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJdlFeature"


    // $ANTLR start "ruleJdlFeature"
    // PsiInternalJDL.g:86:1: ruleJdlFeature returns [Boolean current=false] : (this_JdlEntity_0= ruleJdlEntity | this_JdlEnumType_1= ruleJdlEnumType | this_JdlRelationships_2= ruleJdlRelationships | this_JdlGenerationSetting_3= ruleJdlGenerationSetting ) ;
    public final Boolean ruleJdlFeature() throws RecognitionException {
        Boolean current = false;

        Boolean this_JdlEntity_0 = null;

        Boolean this_JdlEnumType_1 = null;

        Boolean this_JdlRelationships_2 = null;

        Boolean this_JdlGenerationSetting_3 = null;


        try {
            // PsiInternalJDL.g:87:1: ( (this_JdlEntity_0= ruleJdlEntity | this_JdlEnumType_1= ruleJdlEnumType | this_JdlRelationships_2= ruleJdlRelationships | this_JdlGenerationSetting_3= ruleJdlGenerationSetting ) )
            // PsiInternalJDL.g:88:2: (this_JdlEntity_0= ruleJdlEntity | this_JdlEnumType_1= ruleJdlEnumType | this_JdlRelationships_2= ruleJdlRelationships | this_JdlGenerationSetting_3= ruleJdlGenerationSetting )
            {
            // PsiInternalJDL.g:88:2: (this_JdlEntity_0= ruleJdlEntity | this_JdlEnumType_1= ruleJdlEnumType | this_JdlRelationships_2= ruleJdlRelationships | this_JdlGenerationSetting_3= ruleJdlGenerationSetting )
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
                    // PsiInternalJDL.g:89:3: this_JdlEntity_0= ruleJdlEntity
                    {

                    			markComposite(elementTypeProvider.getJdlFeature_JdlEntityParserRuleCall_0ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_JdlEntity_0=ruleJdlEntity();

                    state._fsp--;


                    			current = this_JdlEntity_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalJDL.g:98:3: this_JdlEnumType_1= ruleJdlEnumType
                    {

                    			markComposite(elementTypeProvider.getJdlFeature_JdlEnumTypeParserRuleCall_1ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_JdlEnumType_1=ruleJdlEnumType();

                    state._fsp--;


                    			current = this_JdlEnumType_1;
                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalJDL.g:107:3: this_JdlRelationships_2= ruleJdlRelationships
                    {

                    			markComposite(elementTypeProvider.getJdlFeature_JdlRelationshipsParserRuleCall_2ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_JdlRelationships_2=ruleJdlRelationships();

                    state._fsp--;


                    			current = this_JdlRelationships_2;
                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // PsiInternalJDL.g:116:3: this_JdlGenerationSetting_3= ruleJdlGenerationSetting
                    {

                    			markComposite(elementTypeProvider.getJdlFeature_JdlGenerationSettingParserRuleCall_3ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_JdlGenerationSetting_3=ruleJdlGenerationSetting();

                    state._fsp--;


                    			current = this_JdlGenerationSetting_3;
                    			doneComposite();
                    		

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlFeature"


    // $ANTLR start "entryRuleJdlEntity"
    // PsiInternalJDL.g:128:1: entryRuleJdlEntity returns [Boolean current=false] : iv_ruleJdlEntity= ruleJdlEntity EOF ;
    public final Boolean entryRuleJdlEntity() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJdlEntity = null;


        try {
            // PsiInternalJDL.g:128:51: (iv_ruleJdlEntity= ruleJdlEntity EOF )
            // PsiInternalJDL.g:129:2: iv_ruleJdlEntity= ruleJdlEntity EOF
            {
             markComposite(elementTypeProvider.getJdlEntityElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlEntity=ruleJdlEntity();

            state._fsp--;

             current =iv_ruleJdlEntity; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJdlEntity"


    // $ANTLR start "ruleJdlEntity"
    // PsiInternalJDL.g:135:1: ruleJdlEntity returns [Boolean current=false] : (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( ( (lv_fields_3_0= ruleJdlEntityField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleJdlEntityField ) ) )* )? otherlv_6= '}' )? ) ;
    public final Boolean ruleJdlEntity() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Boolean lv_fields_3_0 = null;

        Boolean lv_fields_5_0 = null;


        try {
            // PsiInternalJDL.g:136:1: ( (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( ( (lv_fields_3_0= ruleJdlEntityField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleJdlEntityField ) ) )* )? otherlv_6= '}' )? ) )
            // PsiInternalJDL.g:137:2: (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( ( (lv_fields_3_0= ruleJdlEntityField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleJdlEntityField ) ) )* )? otherlv_6= '}' )? )
            {
            // PsiInternalJDL.g:137:2: (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( ( (lv_fields_3_0= ruleJdlEntityField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleJdlEntityField ) ) )* )? otherlv_6= '}' )? )
            // PsiInternalJDL.g:138:3: otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( ( (lv_fields_3_0= ruleJdlEntityField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleJdlEntityField ) ) )* )? otherlv_6= '}' )?
            {

            			markLeaf(elementTypeProvider.getJdlEntity_EntityKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalJDL.g:145:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalJDL.g:146:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalJDL.g:146:4: (lv_name_1_0= RULE_ID )
            // PsiInternalJDL.g:147:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getJdlEntity_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_1_0);
            				

            }


            }

            // PsiInternalJDL.g:162:3: (otherlv_2= '{' ( ( (lv_fields_3_0= ruleJdlEntityField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleJdlEntityField ) ) )* )? otherlv_6= '}' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==12) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // PsiInternalJDL.g:163:4: otherlv_2= '{' ( ( (lv_fields_3_0= ruleJdlEntityField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleJdlEntityField ) ) )* )? otherlv_6= '}'
                    {

                    				markLeaf(elementTypeProvider.getJdlEntity_LeftCurlyBracketKeyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,12,FOLLOW_6); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalJDL.g:170:4: ( ( (lv_fields_3_0= ruleJdlEntityField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleJdlEntityField ) ) )* )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==RULE_ID) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // PsiInternalJDL.g:171:5: ( (lv_fields_3_0= ruleJdlEntityField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleJdlEntityField ) ) )*
                            {
                            // PsiInternalJDL.g:171:5: ( (lv_fields_3_0= ruleJdlEntityField ) )
                            // PsiInternalJDL.g:172:6: (lv_fields_3_0= ruleJdlEntityField )
                            {
                            // PsiInternalJDL.g:172:6: (lv_fields_3_0= ruleJdlEntityField )
                            // PsiInternalJDL.g:173:7: lv_fields_3_0= ruleJdlEntityField
                            {

                            							markComposite(elementTypeProvider.getJdlEntity_FieldsJdlEntityFieldParserRuleCall_2_1_0_0ElementType());
                            						
                            pushFollow(FOLLOW_7);
                            lv_fields_3_0=ruleJdlEntityField();

                            state._fsp--;


                            							doneComposite();
                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            }


                            }

                            // PsiInternalJDL.g:186:5: (otherlv_4= ',' ( (lv_fields_5_0= ruleJdlEntityField ) ) )*
                            loop3:
                            do {
                                int alt3=2;
                                int LA3_0 = input.LA(1);

                                if ( (LA3_0==13) ) {
                                    alt3=1;
                                }


                                switch (alt3) {
                            	case 1 :
                            	    // PsiInternalJDL.g:187:6: otherlv_4= ',' ( (lv_fields_5_0= ruleJdlEntityField ) )
                            	    {

                            	    						markLeaf(elementTypeProvider.getJdlEntity_CommaKeyword_2_1_1_0ElementType());
                            	    					
                            	    otherlv_4=(Token)match(input,13,FOLLOW_4); 

                            	    						doneLeaf(otherlv_4);
                            	    					
                            	    // PsiInternalJDL.g:194:6: ( (lv_fields_5_0= ruleJdlEntityField ) )
                            	    // PsiInternalJDL.g:195:7: (lv_fields_5_0= ruleJdlEntityField )
                            	    {
                            	    // PsiInternalJDL.g:195:7: (lv_fields_5_0= ruleJdlEntityField )
                            	    // PsiInternalJDL.g:196:8: lv_fields_5_0= ruleJdlEntityField
                            	    {

                            	    								markComposite(elementTypeProvider.getJdlEntity_FieldsJdlEntityFieldParserRuleCall_2_1_1_1_0ElementType());
                            	    							
                            	    pushFollow(FOLLOW_7);
                            	    lv_fields_5_0=ruleJdlEntityField();

                            	    state._fsp--;


                            	    								doneComposite();
                            	    								if(!current) {
                            	    									associateWithSemanticElement();
                            	    									current = true;
                            	    								}
                            	    							

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


                    				markLeaf(elementTypeProvider.getJdlEntity_RightCurlyBracketKeyword_2_2ElementType());
                    			
                    otherlv_6=(Token)match(input,14,FOLLOW_2); 

                    				doneLeaf(otherlv_6);
                    			

                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlEntity"


    // $ANTLR start "entryRuleJdlEntityField"
    // PsiInternalJDL.g:223:1: entryRuleJdlEntityField returns [Boolean current=false] : iv_ruleJdlEntityField= ruleJdlEntityField EOF ;
    public final Boolean entryRuleJdlEntityField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJdlEntityField = null;


        try {
            // PsiInternalJDL.g:223:56: (iv_ruleJdlEntityField= ruleJdlEntityField EOF )
            // PsiInternalJDL.g:224:2: iv_ruleJdlEntityField= ruleJdlEntityField EOF
            {
             markComposite(elementTypeProvider.getJdlEntityFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlEntityField=ruleJdlEntityField();

            state._fsp--;

             current =iv_ruleJdlEntityField; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJdlEntityField"


    // $ANTLR start "ruleJdlEntityField"
    // PsiInternalJDL.g:230:1: ruleJdlEntityField returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleJdlFieldType ) ) ) ;
    public final Boolean ruleJdlEntityField() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Boolean lv_type_1_0 = null;


        try {
            // PsiInternalJDL.g:231:1: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleJdlFieldType ) ) ) )
            // PsiInternalJDL.g:232:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleJdlFieldType ) ) )
            {
            // PsiInternalJDL.g:232:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleJdlFieldType ) ) )
            // PsiInternalJDL.g:233:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleJdlFieldType ) )
            {
            // PsiInternalJDL.g:233:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalJDL.g:234:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalJDL.g:234:4: (lv_name_0_0= RULE_ID )
            // PsiInternalJDL.g:235:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getJdlEntityField_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_0_0);
            				

            }


            }

            // PsiInternalJDL.g:250:3: ( (lv_type_1_0= ruleJdlFieldType ) )
            // PsiInternalJDL.g:251:4: (lv_type_1_0= ruleJdlFieldType )
            {
            // PsiInternalJDL.g:251:4: (lv_type_1_0= ruleJdlFieldType )
            // PsiInternalJDL.g:252:5: lv_type_1_0= ruleJdlFieldType
            {

            					markComposite(elementTypeProvider.getJdlEntityField_TypeJdlFieldTypeParserRuleCall_1_0ElementType());
            				
            pushFollow(FOLLOW_2);
            lv_type_1_0=ruleJdlFieldType();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlEntityField"


    // $ANTLR start "entryRuleJdlFieldType"
    // PsiInternalJDL.g:269:1: entryRuleJdlFieldType returns [Boolean current=false] : iv_ruleJdlFieldType= ruleJdlFieldType EOF ;
    public final Boolean entryRuleJdlFieldType() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJdlFieldType = null;


        try {
            // PsiInternalJDL.g:269:54: (iv_ruleJdlFieldType= ruleJdlFieldType EOF )
            // PsiInternalJDL.g:270:2: iv_ruleJdlFieldType= ruleJdlFieldType EOF
            {
             markComposite(elementTypeProvider.getJdlFieldTypeElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlFieldType=ruleJdlFieldType();

            state._fsp--;

             current =iv_ruleJdlFieldType; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJdlFieldType"


    // $ANTLR start "ruleJdlFieldType"
    // PsiInternalJDL.g:276:1: ruleJdlFieldType returns [Boolean current=false] : (this_JdlEnumField_0= ruleJdlEnumField | this_JdlStringField_1= ruleJdlStringField | this_JdlNumericField_2= ruleJdlNumericField | this_JdlBooleanField_3= ruleJdlBooleanField | this_JdlDateField_4= ruleJdlDateField | this_JdlBlobField_5= ruleJdlBlobField ) ;
    public final Boolean ruleJdlFieldType() throws RecognitionException {
        Boolean current = false;

        Boolean this_JdlEnumField_0 = null;

        Boolean this_JdlStringField_1 = null;

        Boolean this_JdlNumericField_2 = null;

        Boolean this_JdlBooleanField_3 = null;

        Boolean this_JdlDateField_4 = null;

        Boolean this_JdlBlobField_5 = null;


        try {
            // PsiInternalJDL.g:277:1: ( (this_JdlEnumField_0= ruleJdlEnumField | this_JdlStringField_1= ruleJdlStringField | this_JdlNumericField_2= ruleJdlNumericField | this_JdlBooleanField_3= ruleJdlBooleanField | this_JdlDateField_4= ruleJdlDateField | this_JdlBlobField_5= ruleJdlBlobField ) )
            // PsiInternalJDL.g:278:2: (this_JdlEnumField_0= ruleJdlEnumField | this_JdlStringField_1= ruleJdlStringField | this_JdlNumericField_2= ruleJdlNumericField | this_JdlBooleanField_3= ruleJdlBooleanField | this_JdlDateField_4= ruleJdlDateField | this_JdlBlobField_5= ruleJdlBlobField )
            {
            // PsiInternalJDL.g:278:2: (this_JdlEnumField_0= ruleJdlEnumField | this_JdlStringField_1= ruleJdlStringField | this_JdlNumericField_2= ruleJdlNumericField | this_JdlBooleanField_3= ruleJdlBooleanField | this_JdlDateField_4= ruleJdlDateField | this_JdlBlobField_5= ruleJdlBlobField )
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
                    // PsiInternalJDL.g:279:3: this_JdlEnumField_0= ruleJdlEnumField
                    {

                    			markComposite(elementTypeProvider.getJdlFieldType_JdlEnumFieldParserRuleCall_0ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_JdlEnumField_0=ruleJdlEnumField();

                    state._fsp--;


                    			current = this_JdlEnumField_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalJDL.g:288:3: this_JdlStringField_1= ruleJdlStringField
                    {

                    			markComposite(elementTypeProvider.getJdlFieldType_JdlStringFieldParserRuleCall_1ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_JdlStringField_1=ruleJdlStringField();

                    state._fsp--;


                    			current = this_JdlStringField_1;
                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalJDL.g:297:3: this_JdlNumericField_2= ruleJdlNumericField
                    {

                    			markComposite(elementTypeProvider.getJdlFieldType_JdlNumericFieldParserRuleCall_2ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_JdlNumericField_2=ruleJdlNumericField();

                    state._fsp--;


                    			current = this_JdlNumericField_2;
                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // PsiInternalJDL.g:306:3: this_JdlBooleanField_3= ruleJdlBooleanField
                    {

                    			markComposite(elementTypeProvider.getJdlFieldType_JdlBooleanFieldParserRuleCall_3ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_JdlBooleanField_3=ruleJdlBooleanField();

                    state._fsp--;


                    			current = this_JdlBooleanField_3;
                    			doneComposite();
                    		

                    }
                    break;
                case 5 :
                    // PsiInternalJDL.g:315:3: this_JdlDateField_4= ruleJdlDateField
                    {

                    			markComposite(elementTypeProvider.getJdlFieldType_JdlDateFieldParserRuleCall_4ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_JdlDateField_4=ruleJdlDateField();

                    state._fsp--;


                    			current = this_JdlDateField_4;
                    			doneComposite();
                    		

                    }
                    break;
                case 6 :
                    // PsiInternalJDL.g:324:3: this_JdlBlobField_5= ruleJdlBlobField
                    {

                    			markComposite(elementTypeProvider.getJdlFieldType_JdlBlobFieldParserRuleCall_5ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_JdlBlobField_5=ruleJdlBlobField();

                    state._fsp--;


                    			current = this_JdlBlobField_5;
                    			doneComposite();
                    		

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlFieldType"


    // $ANTLR start "entryRuleJdlEnumField"
    // PsiInternalJDL.g:336:1: entryRuleJdlEnumField returns [Boolean current=false] : iv_ruleJdlEnumField= ruleJdlEnumField EOF ;
    public final Boolean entryRuleJdlEnumField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJdlEnumField = null;


        try {
            // PsiInternalJDL.g:336:54: (iv_ruleJdlEnumField= ruleJdlEnumField EOF )
            // PsiInternalJDL.g:337:2: iv_ruleJdlEnumField= ruleJdlEnumField EOF
            {
             markComposite(elementTypeProvider.getJdlEnumFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlEnumField=ruleJdlEnumField();

            state._fsp--;

             current =iv_ruleJdlEnumField; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJdlEnumField"


    // $ANTLR start "ruleJdlEnumField"
    // PsiInternalJDL.g:343:1: ruleJdlEnumField returns [Boolean current=false] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_validators_1_0= ruleJdlRequiredValidator ) )? ) ;
    public final Boolean ruleJdlEnumField() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_validators_1_0 = null;


        try {
            // PsiInternalJDL.g:344:1: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_validators_1_0= ruleJdlRequiredValidator ) )? ) )
            // PsiInternalJDL.g:345:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_validators_1_0= ruleJdlRequiredValidator ) )? )
            {
            // PsiInternalJDL.g:345:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_validators_1_0= ruleJdlRequiredValidator ) )? )
            // PsiInternalJDL.g:346:3: ( (otherlv_0= RULE_ID ) ) ( (lv_validators_1_0= ruleJdlRequiredValidator ) )?
            {
            // PsiInternalJDL.g:346:3: ( (otherlv_0= RULE_ID ) )
            // PsiInternalJDL.g:347:4: (otherlv_0= RULE_ID )
            {
            // PsiInternalJDL.g:347:4: (otherlv_0= RULE_ID )
            // PsiInternalJDL.g:348:5: otherlv_0= RULE_ID
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					markLeaf(elementTypeProvider.getJdlEnumField_EnumTypeJdlEnumTypeCrossReference_0_0ElementType());
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					doneLeaf(otherlv_0);
            				

            }


            }

            // PsiInternalJDL.g:363:3: ( (lv_validators_1_0= ruleJdlRequiredValidator ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==19) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // PsiInternalJDL.g:364:4: (lv_validators_1_0= ruleJdlRequiredValidator )
                    {
                    // PsiInternalJDL.g:364:4: (lv_validators_1_0= ruleJdlRequiredValidator )
                    // PsiInternalJDL.g:365:5: lv_validators_1_0= ruleJdlRequiredValidator
                    {

                    					markComposite(elementTypeProvider.getJdlEnumField_ValidatorsJdlRequiredValidatorParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_1_0=ruleJdlRequiredValidator();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlEnumField"


    // $ANTLR start "entryRuleJdlStringField"
    // PsiInternalJDL.g:382:1: entryRuleJdlStringField returns [Boolean current=false] : iv_ruleJdlStringField= ruleJdlStringField EOF ;
    public final Boolean entryRuleJdlStringField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJdlStringField = null;


        try {
            // PsiInternalJDL.g:382:56: (iv_ruleJdlStringField= ruleJdlStringField EOF )
            // PsiInternalJDL.g:383:2: iv_ruleJdlStringField= ruleJdlStringField EOF
            {
             markComposite(elementTypeProvider.getJdlStringFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlStringField=ruleJdlStringField();

            state._fsp--;

             current =iv_ruleJdlStringField; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJdlStringField"


    // $ANTLR start "ruleJdlStringField"
    // PsiInternalJDL.g:389:1: ruleJdlStringField returns [Boolean current=false] : ( ( (lv_stringType_0_0= 'String' ) ) ( (lv_validators_1_0= ruleJdlStringValidators ) )? ) ;
    public final Boolean ruleJdlStringField() throws RecognitionException {
        Boolean current = false;

        Token lv_stringType_0_0=null;
        Boolean lv_validators_1_0 = null;


        try {
            // PsiInternalJDL.g:390:1: ( ( ( (lv_stringType_0_0= 'String' ) ) ( (lv_validators_1_0= ruleJdlStringValidators ) )? ) )
            // PsiInternalJDL.g:391:2: ( ( (lv_stringType_0_0= 'String' ) ) ( (lv_validators_1_0= ruleJdlStringValidators ) )? )
            {
            // PsiInternalJDL.g:391:2: ( ( (lv_stringType_0_0= 'String' ) ) ( (lv_validators_1_0= ruleJdlStringValidators ) )? )
            // PsiInternalJDL.g:392:3: ( (lv_stringType_0_0= 'String' ) ) ( (lv_validators_1_0= ruleJdlStringValidators ) )?
            {
            // PsiInternalJDL.g:392:3: ( (lv_stringType_0_0= 'String' ) )
            // PsiInternalJDL.g:393:4: (lv_stringType_0_0= 'String' )
            {
            // PsiInternalJDL.g:393:4: (lv_stringType_0_0= 'String' )
            // PsiInternalJDL.g:394:5: lv_stringType_0_0= 'String'
            {

            					markLeaf(elementTypeProvider.getJdlStringField_StringTypeStringKeyword_0_0ElementType());
            				
            lv_stringType_0_0=(Token)match(input,15,FOLLOW_9); 

            					doneLeaf(lv_stringType_0_0);
            				

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalJDL.g:409:3: ( (lv_validators_1_0= ruleJdlStringValidators ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==19) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // PsiInternalJDL.g:410:4: (lv_validators_1_0= ruleJdlStringValidators )
                    {
                    // PsiInternalJDL.g:410:4: (lv_validators_1_0= ruleJdlStringValidators )
                    // PsiInternalJDL.g:411:5: lv_validators_1_0= ruleJdlStringValidators
                    {

                    					markComposite(elementTypeProvider.getJdlStringField_ValidatorsJdlStringValidatorsParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_1_0=ruleJdlStringValidators();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlStringField"


    // $ANTLR start "entryRuleJdlNumericField"
    // PsiInternalJDL.g:428:1: entryRuleJdlNumericField returns [Boolean current=false] : iv_ruleJdlNumericField= ruleJdlNumericField EOF ;
    public final Boolean entryRuleJdlNumericField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJdlNumericField = null;


        try {
            // PsiInternalJDL.g:428:57: (iv_ruleJdlNumericField= ruleJdlNumericField EOF )
            // PsiInternalJDL.g:429:2: iv_ruleJdlNumericField= ruleJdlNumericField EOF
            {
             markComposite(elementTypeProvider.getJdlNumericFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlNumericField=ruleJdlNumericField();

            state._fsp--;

             current =iv_ruleJdlNumericField; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJdlNumericField"


    // $ANTLR start "ruleJdlNumericField"
    // PsiInternalJDL.g:435:1: ruleJdlNumericField returns [Boolean current=false] : ( ( (lv_numericFieldType_0_0= ruleJdlNumericFieldType ) ) ( (lv_validators_1_0= ruleJdlNumericValidators ) )? ) ;
    public final Boolean ruleJdlNumericField() throws RecognitionException {
        Boolean current = false;

        Boolean lv_numericFieldType_0_0 = null;

        Boolean lv_validators_1_0 = null;


        try {
            // PsiInternalJDL.g:436:1: ( ( ( (lv_numericFieldType_0_0= ruleJdlNumericFieldType ) ) ( (lv_validators_1_0= ruleJdlNumericValidators ) )? ) )
            // PsiInternalJDL.g:437:2: ( ( (lv_numericFieldType_0_0= ruleJdlNumericFieldType ) ) ( (lv_validators_1_0= ruleJdlNumericValidators ) )? )
            {
            // PsiInternalJDL.g:437:2: ( ( (lv_numericFieldType_0_0= ruleJdlNumericFieldType ) ) ( (lv_validators_1_0= ruleJdlNumericValidators ) )? )
            // PsiInternalJDL.g:438:3: ( (lv_numericFieldType_0_0= ruleJdlNumericFieldType ) ) ( (lv_validators_1_0= ruleJdlNumericValidators ) )?
            {
            // PsiInternalJDL.g:438:3: ( (lv_numericFieldType_0_0= ruleJdlNumericFieldType ) )
            // PsiInternalJDL.g:439:4: (lv_numericFieldType_0_0= ruleJdlNumericFieldType )
            {
            // PsiInternalJDL.g:439:4: (lv_numericFieldType_0_0= ruleJdlNumericFieldType )
            // PsiInternalJDL.g:440:5: lv_numericFieldType_0_0= ruleJdlNumericFieldType
            {

            					markComposite(elementTypeProvider.getJdlNumericField_NumericFieldTypeJdlNumericFieldTypeEnumRuleCall_0_0ElementType());
            				
            pushFollow(FOLLOW_9);
            lv_numericFieldType_0_0=ruleJdlNumericFieldType();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalJDL.g:453:3: ( (lv_validators_1_0= ruleJdlNumericValidators ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==19) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // PsiInternalJDL.g:454:4: (lv_validators_1_0= ruleJdlNumericValidators )
                    {
                    // PsiInternalJDL.g:454:4: (lv_validators_1_0= ruleJdlNumericValidators )
                    // PsiInternalJDL.g:455:5: lv_validators_1_0= ruleJdlNumericValidators
                    {

                    					markComposite(elementTypeProvider.getJdlNumericField_ValidatorsJdlNumericValidatorsParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_1_0=ruleJdlNumericValidators();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlNumericField"


    // $ANTLR start "entryRuleJdlBooleanField"
    // PsiInternalJDL.g:472:1: entryRuleJdlBooleanField returns [Boolean current=false] : iv_ruleJdlBooleanField= ruleJdlBooleanField EOF ;
    public final Boolean entryRuleJdlBooleanField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJdlBooleanField = null;


        try {
            // PsiInternalJDL.g:472:57: (iv_ruleJdlBooleanField= ruleJdlBooleanField EOF )
            // PsiInternalJDL.g:473:2: iv_ruleJdlBooleanField= ruleJdlBooleanField EOF
            {
             markComposite(elementTypeProvider.getJdlBooleanFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlBooleanField=ruleJdlBooleanField();

            state._fsp--;

             current =iv_ruleJdlBooleanField; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJdlBooleanField"


    // $ANTLR start "ruleJdlBooleanField"
    // PsiInternalJDL.g:479:1: ruleJdlBooleanField returns [Boolean current=false] : ( ( (lv_booleanType_0_0= 'Boolean' ) ) ( (lv_validators_1_0= ruleJdlRequiredValidator ) )? ) ;
    public final Boolean ruleJdlBooleanField() throws RecognitionException {
        Boolean current = false;

        Token lv_booleanType_0_0=null;
        Boolean lv_validators_1_0 = null;


        try {
            // PsiInternalJDL.g:480:1: ( ( ( (lv_booleanType_0_0= 'Boolean' ) ) ( (lv_validators_1_0= ruleJdlRequiredValidator ) )? ) )
            // PsiInternalJDL.g:481:2: ( ( (lv_booleanType_0_0= 'Boolean' ) ) ( (lv_validators_1_0= ruleJdlRequiredValidator ) )? )
            {
            // PsiInternalJDL.g:481:2: ( ( (lv_booleanType_0_0= 'Boolean' ) ) ( (lv_validators_1_0= ruleJdlRequiredValidator ) )? )
            // PsiInternalJDL.g:482:3: ( (lv_booleanType_0_0= 'Boolean' ) ) ( (lv_validators_1_0= ruleJdlRequiredValidator ) )?
            {
            // PsiInternalJDL.g:482:3: ( (lv_booleanType_0_0= 'Boolean' ) )
            // PsiInternalJDL.g:483:4: (lv_booleanType_0_0= 'Boolean' )
            {
            // PsiInternalJDL.g:483:4: (lv_booleanType_0_0= 'Boolean' )
            // PsiInternalJDL.g:484:5: lv_booleanType_0_0= 'Boolean'
            {

            					markLeaf(elementTypeProvider.getJdlBooleanField_BooleanTypeBooleanKeyword_0_0ElementType());
            				
            lv_booleanType_0_0=(Token)match(input,16,FOLLOW_9); 

            					doneLeaf(lv_booleanType_0_0);
            				

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalJDL.g:499:3: ( (lv_validators_1_0= ruleJdlRequiredValidator ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==19) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // PsiInternalJDL.g:500:4: (lv_validators_1_0= ruleJdlRequiredValidator )
                    {
                    // PsiInternalJDL.g:500:4: (lv_validators_1_0= ruleJdlRequiredValidator )
                    // PsiInternalJDL.g:501:5: lv_validators_1_0= ruleJdlRequiredValidator
                    {

                    					markComposite(elementTypeProvider.getJdlBooleanField_ValidatorsJdlRequiredValidatorParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_1_0=ruleJdlRequiredValidator();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlBooleanField"


    // $ANTLR start "entryRuleJdlDateField"
    // PsiInternalJDL.g:518:1: entryRuleJdlDateField returns [Boolean current=false] : iv_ruleJdlDateField= ruleJdlDateField EOF ;
    public final Boolean entryRuleJdlDateField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJdlDateField = null;


        try {
            // PsiInternalJDL.g:518:54: (iv_ruleJdlDateField= ruleJdlDateField EOF )
            // PsiInternalJDL.g:519:2: iv_ruleJdlDateField= ruleJdlDateField EOF
            {
             markComposite(elementTypeProvider.getJdlDateFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlDateField=ruleJdlDateField();

            state._fsp--;

             current =iv_ruleJdlDateField; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJdlDateField"


    // $ANTLR start "ruleJdlDateField"
    // PsiInternalJDL.g:525:1: ruleJdlDateField returns [Boolean current=false] : ( ( ( (lv_localDateType_0_0= 'LocalDate' ) ) | ( (lv_zonedDateTimeType_1_0= 'ZonedDateTime' ) ) ) ( (lv_validators_2_0= ruleJdlRequiredValidator ) )? ) ;
    public final Boolean ruleJdlDateField() throws RecognitionException {
        Boolean current = false;

        Token lv_localDateType_0_0=null;
        Token lv_zonedDateTimeType_1_0=null;
        Boolean lv_validators_2_0 = null;


        try {
            // PsiInternalJDL.g:526:1: ( ( ( ( (lv_localDateType_0_0= 'LocalDate' ) ) | ( (lv_zonedDateTimeType_1_0= 'ZonedDateTime' ) ) ) ( (lv_validators_2_0= ruleJdlRequiredValidator ) )? ) )
            // PsiInternalJDL.g:527:2: ( ( ( (lv_localDateType_0_0= 'LocalDate' ) ) | ( (lv_zonedDateTimeType_1_0= 'ZonedDateTime' ) ) ) ( (lv_validators_2_0= ruleJdlRequiredValidator ) )? )
            {
            // PsiInternalJDL.g:527:2: ( ( ( (lv_localDateType_0_0= 'LocalDate' ) ) | ( (lv_zonedDateTimeType_1_0= 'ZonedDateTime' ) ) ) ( (lv_validators_2_0= ruleJdlRequiredValidator ) )? )
            // PsiInternalJDL.g:528:3: ( ( (lv_localDateType_0_0= 'LocalDate' ) ) | ( (lv_zonedDateTimeType_1_0= 'ZonedDateTime' ) ) ) ( (lv_validators_2_0= ruleJdlRequiredValidator ) )?
            {
            // PsiInternalJDL.g:528:3: ( ( (lv_localDateType_0_0= 'LocalDate' ) ) | ( (lv_zonedDateTimeType_1_0= 'ZonedDateTime' ) ) )
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
                    // PsiInternalJDL.g:529:4: ( (lv_localDateType_0_0= 'LocalDate' ) )
                    {
                    // PsiInternalJDL.g:529:4: ( (lv_localDateType_0_0= 'LocalDate' ) )
                    // PsiInternalJDL.g:530:5: (lv_localDateType_0_0= 'LocalDate' )
                    {
                    // PsiInternalJDL.g:530:5: (lv_localDateType_0_0= 'LocalDate' )
                    // PsiInternalJDL.g:531:6: lv_localDateType_0_0= 'LocalDate'
                    {

                    						markLeaf(elementTypeProvider.getJdlDateField_LocalDateTypeLocalDateKeyword_0_0_0ElementType());
                    					
                    lv_localDateType_0_0=(Token)match(input,17,FOLLOW_9); 

                    						doneLeaf(lv_localDateType_0_0);
                    					

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalJDL.g:547:4: ( (lv_zonedDateTimeType_1_0= 'ZonedDateTime' ) )
                    {
                    // PsiInternalJDL.g:547:4: ( (lv_zonedDateTimeType_1_0= 'ZonedDateTime' ) )
                    // PsiInternalJDL.g:548:5: (lv_zonedDateTimeType_1_0= 'ZonedDateTime' )
                    {
                    // PsiInternalJDL.g:548:5: (lv_zonedDateTimeType_1_0= 'ZonedDateTime' )
                    // PsiInternalJDL.g:549:6: lv_zonedDateTimeType_1_0= 'ZonedDateTime'
                    {

                    						markLeaf(elementTypeProvider.getJdlDateField_ZonedDateTimeTypeZonedDateTimeKeyword_0_1_0ElementType());
                    					
                    lv_zonedDateTimeType_1_0=(Token)match(input,18,FOLLOW_9); 

                    						doneLeaf(lv_zonedDateTimeType_1_0);
                    					

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }


                    }
                    break;

            }

            // PsiInternalJDL.g:565:3: ( (lv_validators_2_0= ruleJdlRequiredValidator ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==19) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // PsiInternalJDL.g:566:4: (lv_validators_2_0= ruleJdlRequiredValidator )
                    {
                    // PsiInternalJDL.g:566:4: (lv_validators_2_0= ruleJdlRequiredValidator )
                    // PsiInternalJDL.g:567:5: lv_validators_2_0= ruleJdlRequiredValidator
                    {

                    					markComposite(elementTypeProvider.getJdlDateField_ValidatorsJdlRequiredValidatorParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_2_0=ruleJdlRequiredValidator();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlDateField"


    // $ANTLR start "entryRuleJdlBlobField"
    // PsiInternalJDL.g:584:1: entryRuleJdlBlobField returns [Boolean current=false] : iv_ruleJdlBlobField= ruleJdlBlobField EOF ;
    public final Boolean entryRuleJdlBlobField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJdlBlobField = null;


        try {
            // PsiInternalJDL.g:584:54: (iv_ruleJdlBlobField= ruleJdlBlobField EOF )
            // PsiInternalJDL.g:585:2: iv_ruleJdlBlobField= ruleJdlBlobField EOF
            {
             markComposite(elementTypeProvider.getJdlBlobFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlBlobField=ruleJdlBlobField();

            state._fsp--;

             current =iv_ruleJdlBlobField; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJdlBlobField"


    // $ANTLR start "ruleJdlBlobField"
    // PsiInternalJDL.g:591:1: ruleJdlBlobField returns [Boolean current=false] : ( ( (lv_blobFieldType_0_0= ruleJdlBlobFieldType ) ) ( (lv_validators_1_0= ruleJdlBlobValidators ) )? ) ;
    public final Boolean ruleJdlBlobField() throws RecognitionException {
        Boolean current = false;

        Boolean lv_blobFieldType_0_0 = null;

        Boolean lv_validators_1_0 = null;


        try {
            // PsiInternalJDL.g:592:1: ( ( ( (lv_blobFieldType_0_0= ruleJdlBlobFieldType ) ) ( (lv_validators_1_0= ruleJdlBlobValidators ) )? ) )
            // PsiInternalJDL.g:593:2: ( ( (lv_blobFieldType_0_0= ruleJdlBlobFieldType ) ) ( (lv_validators_1_0= ruleJdlBlobValidators ) )? )
            {
            // PsiInternalJDL.g:593:2: ( ( (lv_blobFieldType_0_0= ruleJdlBlobFieldType ) ) ( (lv_validators_1_0= ruleJdlBlobValidators ) )? )
            // PsiInternalJDL.g:594:3: ( (lv_blobFieldType_0_0= ruleJdlBlobFieldType ) ) ( (lv_validators_1_0= ruleJdlBlobValidators ) )?
            {
            // PsiInternalJDL.g:594:3: ( (lv_blobFieldType_0_0= ruleJdlBlobFieldType ) )
            // PsiInternalJDL.g:595:4: (lv_blobFieldType_0_0= ruleJdlBlobFieldType )
            {
            // PsiInternalJDL.g:595:4: (lv_blobFieldType_0_0= ruleJdlBlobFieldType )
            // PsiInternalJDL.g:596:5: lv_blobFieldType_0_0= ruleJdlBlobFieldType
            {

            					markComposite(elementTypeProvider.getJdlBlobField_BlobFieldTypeJdlBlobFieldTypeEnumRuleCall_0_0ElementType());
            				
            pushFollow(FOLLOW_9);
            lv_blobFieldType_0_0=ruleJdlBlobFieldType();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalJDL.g:609:3: ( (lv_validators_1_0= ruleJdlBlobValidators ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==19) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // PsiInternalJDL.g:610:4: (lv_validators_1_0= ruleJdlBlobValidators )
                    {
                    // PsiInternalJDL.g:610:4: (lv_validators_1_0= ruleJdlBlobValidators )
                    // PsiInternalJDL.g:611:5: lv_validators_1_0= ruleJdlBlobValidators
                    {

                    					markComposite(elementTypeProvider.getJdlBlobField_ValidatorsJdlBlobValidatorsParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_1_0=ruleJdlBlobValidators();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlBlobField"


    // $ANTLR start "entryRuleJdlStringValidators"
    // PsiInternalJDL.g:628:1: entryRuleJdlStringValidators returns [Boolean current=false] : iv_ruleJdlStringValidators= ruleJdlStringValidators EOF ;
    public final Boolean entryRuleJdlStringValidators() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJdlStringValidators = null;


        try {
            // PsiInternalJDL.g:628:61: (iv_ruleJdlStringValidators= ruleJdlStringValidators EOF )
            // PsiInternalJDL.g:629:2: iv_ruleJdlStringValidators= ruleJdlStringValidators EOF
            {
             markComposite(elementTypeProvider.getJdlStringValidatorsElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlStringValidators=ruleJdlStringValidators();

            state._fsp--;

             current =iv_ruleJdlStringValidators; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJdlStringValidators"


    // $ANTLR start "ruleJdlStringValidators"
    // PsiInternalJDL.g:635:1: ruleJdlStringValidators returns [Boolean current=false] : ( ( (lv_required_0_0= ruleJdlRequiredValidator ) ) ( (lv_minLength_1_0= ruleJdlMinLengthValidator ) )? ( (lv_maxlength_2_0= ruleJdlMaxLengthValidator ) )? ( (lv_pattern_3_0= ruleJdlPatternValidator ) )? ) ;
    public final Boolean ruleJdlStringValidators() throws RecognitionException {
        Boolean current = false;

        Boolean lv_required_0_0 = null;

        Boolean lv_minLength_1_0 = null;

        Boolean lv_maxlength_2_0 = null;

        Boolean lv_pattern_3_0 = null;


        try {
            // PsiInternalJDL.g:636:1: ( ( ( (lv_required_0_0= ruleJdlRequiredValidator ) ) ( (lv_minLength_1_0= ruleJdlMinLengthValidator ) )? ( (lv_maxlength_2_0= ruleJdlMaxLengthValidator ) )? ( (lv_pattern_3_0= ruleJdlPatternValidator ) )? ) )
            // PsiInternalJDL.g:637:2: ( ( (lv_required_0_0= ruleJdlRequiredValidator ) ) ( (lv_minLength_1_0= ruleJdlMinLengthValidator ) )? ( (lv_maxlength_2_0= ruleJdlMaxLengthValidator ) )? ( (lv_pattern_3_0= ruleJdlPatternValidator ) )? )
            {
            // PsiInternalJDL.g:637:2: ( ( (lv_required_0_0= ruleJdlRequiredValidator ) ) ( (lv_minLength_1_0= ruleJdlMinLengthValidator ) )? ( (lv_maxlength_2_0= ruleJdlMaxLengthValidator ) )? ( (lv_pattern_3_0= ruleJdlPatternValidator ) )? )
            // PsiInternalJDL.g:638:3: ( (lv_required_0_0= ruleJdlRequiredValidator ) ) ( (lv_minLength_1_0= ruleJdlMinLengthValidator ) )? ( (lv_maxlength_2_0= ruleJdlMaxLengthValidator ) )? ( (lv_pattern_3_0= ruleJdlPatternValidator ) )?
            {
            // PsiInternalJDL.g:638:3: ( (lv_required_0_0= ruleJdlRequiredValidator ) )
            // PsiInternalJDL.g:639:4: (lv_required_0_0= ruleJdlRequiredValidator )
            {
            // PsiInternalJDL.g:639:4: (lv_required_0_0= ruleJdlRequiredValidator )
            // PsiInternalJDL.g:640:5: lv_required_0_0= ruleJdlRequiredValidator
            {

            					markComposite(elementTypeProvider.getJdlStringValidators_RequiredJdlRequiredValidatorParserRuleCall_0_0ElementType());
            				
            pushFollow(FOLLOW_10);
            lv_required_0_0=ruleJdlRequiredValidator();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalJDL.g:653:3: ( (lv_minLength_1_0= ruleJdlMinLengthValidator ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==20) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // PsiInternalJDL.g:654:4: (lv_minLength_1_0= ruleJdlMinLengthValidator )
                    {
                    // PsiInternalJDL.g:654:4: (lv_minLength_1_0= ruleJdlMinLengthValidator )
                    // PsiInternalJDL.g:655:5: lv_minLength_1_0= ruleJdlMinLengthValidator
                    {

                    					markComposite(elementTypeProvider.getJdlStringValidators_MinLengthJdlMinLengthValidatorParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FOLLOW_11);
                    lv_minLength_1_0=ruleJdlMinLengthValidator();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }

            // PsiInternalJDL.g:668:3: ( (lv_maxlength_2_0= ruleJdlMaxLengthValidator ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==23) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // PsiInternalJDL.g:669:4: (lv_maxlength_2_0= ruleJdlMaxLengthValidator )
                    {
                    // PsiInternalJDL.g:669:4: (lv_maxlength_2_0= ruleJdlMaxLengthValidator )
                    // PsiInternalJDL.g:670:5: lv_maxlength_2_0= ruleJdlMaxLengthValidator
                    {

                    					markComposite(elementTypeProvider.getJdlStringValidators_MaxlengthJdlMaxLengthValidatorParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FOLLOW_12);
                    lv_maxlength_2_0=ruleJdlMaxLengthValidator();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }

            // PsiInternalJDL.g:683:3: ( (lv_pattern_3_0= ruleJdlPatternValidator ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==24) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // PsiInternalJDL.g:684:4: (lv_pattern_3_0= ruleJdlPatternValidator )
                    {
                    // PsiInternalJDL.g:684:4: (lv_pattern_3_0= ruleJdlPatternValidator )
                    // PsiInternalJDL.g:685:5: lv_pattern_3_0= ruleJdlPatternValidator
                    {

                    					markComposite(elementTypeProvider.getJdlStringValidators_PatternJdlPatternValidatorParserRuleCall_3_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_pattern_3_0=ruleJdlPatternValidator();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlStringValidators"


    // $ANTLR start "entryRuleJdlNumericValidators"
    // PsiInternalJDL.g:702:1: entryRuleJdlNumericValidators returns [Boolean current=false] : iv_ruleJdlNumericValidators= ruleJdlNumericValidators EOF ;
    public final Boolean entryRuleJdlNumericValidators() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJdlNumericValidators = null;


        try {
            // PsiInternalJDL.g:702:62: (iv_ruleJdlNumericValidators= ruleJdlNumericValidators EOF )
            // PsiInternalJDL.g:703:2: iv_ruleJdlNumericValidators= ruleJdlNumericValidators EOF
            {
             markComposite(elementTypeProvider.getJdlNumericValidatorsElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlNumericValidators=ruleJdlNumericValidators();

            state._fsp--;

             current =iv_ruleJdlNumericValidators; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJdlNumericValidators"


    // $ANTLR start "ruleJdlNumericValidators"
    // PsiInternalJDL.g:709:1: ruleJdlNumericValidators returns [Boolean current=false] : ( ( (lv_required_0_0= ruleJdlRequiredValidator ) ) ( (lv_minlength_1_0= ruleJdlMinValidator ) )? ( (lv_maxlength_2_0= ruleJdlMaxValidator ) )? ) ;
    public final Boolean ruleJdlNumericValidators() throws RecognitionException {
        Boolean current = false;

        Boolean lv_required_0_0 = null;

        Boolean lv_minlength_1_0 = null;

        Boolean lv_maxlength_2_0 = null;


        try {
            // PsiInternalJDL.g:710:1: ( ( ( (lv_required_0_0= ruleJdlRequiredValidator ) ) ( (lv_minlength_1_0= ruleJdlMinValidator ) )? ( (lv_maxlength_2_0= ruleJdlMaxValidator ) )? ) )
            // PsiInternalJDL.g:711:2: ( ( (lv_required_0_0= ruleJdlRequiredValidator ) ) ( (lv_minlength_1_0= ruleJdlMinValidator ) )? ( (lv_maxlength_2_0= ruleJdlMaxValidator ) )? )
            {
            // PsiInternalJDL.g:711:2: ( ( (lv_required_0_0= ruleJdlRequiredValidator ) ) ( (lv_minlength_1_0= ruleJdlMinValidator ) )? ( (lv_maxlength_2_0= ruleJdlMaxValidator ) )? )
            // PsiInternalJDL.g:712:3: ( (lv_required_0_0= ruleJdlRequiredValidator ) ) ( (lv_minlength_1_0= ruleJdlMinValidator ) )? ( (lv_maxlength_2_0= ruleJdlMaxValidator ) )?
            {
            // PsiInternalJDL.g:712:3: ( (lv_required_0_0= ruleJdlRequiredValidator ) )
            // PsiInternalJDL.g:713:4: (lv_required_0_0= ruleJdlRequiredValidator )
            {
            // PsiInternalJDL.g:713:4: (lv_required_0_0= ruleJdlRequiredValidator )
            // PsiInternalJDL.g:714:5: lv_required_0_0= ruleJdlRequiredValidator
            {

            					markComposite(elementTypeProvider.getJdlNumericValidators_RequiredJdlRequiredValidatorParserRuleCall_0_0ElementType());
            				
            pushFollow(FOLLOW_13);
            lv_required_0_0=ruleJdlRequiredValidator();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalJDL.g:727:3: ( (lv_minlength_1_0= ruleJdlMinValidator ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==25) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // PsiInternalJDL.g:728:4: (lv_minlength_1_0= ruleJdlMinValidator )
                    {
                    // PsiInternalJDL.g:728:4: (lv_minlength_1_0= ruleJdlMinValidator )
                    // PsiInternalJDL.g:729:5: lv_minlength_1_0= ruleJdlMinValidator
                    {

                    					markComposite(elementTypeProvider.getJdlNumericValidators_MinlengthJdlMinValidatorParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FOLLOW_14);
                    lv_minlength_1_0=ruleJdlMinValidator();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }

            // PsiInternalJDL.g:742:3: ( (lv_maxlength_2_0= ruleJdlMaxValidator ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==26) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // PsiInternalJDL.g:743:4: (lv_maxlength_2_0= ruleJdlMaxValidator )
                    {
                    // PsiInternalJDL.g:743:4: (lv_maxlength_2_0= ruleJdlMaxValidator )
                    // PsiInternalJDL.g:744:5: lv_maxlength_2_0= ruleJdlMaxValidator
                    {

                    					markComposite(elementTypeProvider.getJdlNumericValidators_MaxlengthJdlMaxValidatorParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_maxlength_2_0=ruleJdlMaxValidator();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlNumericValidators"


    // $ANTLR start "entryRuleJdlBlobValidators"
    // PsiInternalJDL.g:761:1: entryRuleJdlBlobValidators returns [Boolean current=false] : iv_ruleJdlBlobValidators= ruleJdlBlobValidators EOF ;
    public final Boolean entryRuleJdlBlobValidators() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJdlBlobValidators = null;


        try {
            // PsiInternalJDL.g:761:59: (iv_ruleJdlBlobValidators= ruleJdlBlobValidators EOF )
            // PsiInternalJDL.g:762:2: iv_ruleJdlBlobValidators= ruleJdlBlobValidators EOF
            {
             markComposite(elementTypeProvider.getJdlBlobValidatorsElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlBlobValidators=ruleJdlBlobValidators();

            state._fsp--;

             current =iv_ruleJdlBlobValidators; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJdlBlobValidators"


    // $ANTLR start "ruleJdlBlobValidators"
    // PsiInternalJDL.g:768:1: ruleJdlBlobValidators returns [Boolean current=false] : ( ( (lv_required_0_0= ruleJdlRequiredValidator ) ) ( (lv_minbytes_1_0= ruleJdlMinBytesValidator ) )? ( (lv_maxbytes_2_0= ruleJdlMaxBytesValidator ) )? ) ;
    public final Boolean ruleJdlBlobValidators() throws RecognitionException {
        Boolean current = false;

        Boolean lv_required_0_0 = null;

        Boolean lv_minbytes_1_0 = null;

        Boolean lv_maxbytes_2_0 = null;


        try {
            // PsiInternalJDL.g:769:1: ( ( ( (lv_required_0_0= ruleJdlRequiredValidator ) ) ( (lv_minbytes_1_0= ruleJdlMinBytesValidator ) )? ( (lv_maxbytes_2_0= ruleJdlMaxBytesValidator ) )? ) )
            // PsiInternalJDL.g:770:2: ( ( (lv_required_0_0= ruleJdlRequiredValidator ) ) ( (lv_minbytes_1_0= ruleJdlMinBytesValidator ) )? ( (lv_maxbytes_2_0= ruleJdlMaxBytesValidator ) )? )
            {
            // PsiInternalJDL.g:770:2: ( ( (lv_required_0_0= ruleJdlRequiredValidator ) ) ( (lv_minbytes_1_0= ruleJdlMinBytesValidator ) )? ( (lv_maxbytes_2_0= ruleJdlMaxBytesValidator ) )? )
            // PsiInternalJDL.g:771:3: ( (lv_required_0_0= ruleJdlRequiredValidator ) ) ( (lv_minbytes_1_0= ruleJdlMinBytesValidator ) )? ( (lv_maxbytes_2_0= ruleJdlMaxBytesValidator ) )?
            {
            // PsiInternalJDL.g:771:3: ( (lv_required_0_0= ruleJdlRequiredValidator ) )
            // PsiInternalJDL.g:772:4: (lv_required_0_0= ruleJdlRequiredValidator )
            {
            // PsiInternalJDL.g:772:4: (lv_required_0_0= ruleJdlRequiredValidator )
            // PsiInternalJDL.g:773:5: lv_required_0_0= ruleJdlRequiredValidator
            {

            					markComposite(elementTypeProvider.getJdlBlobValidators_RequiredJdlRequiredValidatorParserRuleCall_0_0ElementType());
            				
            pushFollow(FOLLOW_15);
            lv_required_0_0=ruleJdlRequiredValidator();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalJDL.g:786:3: ( (lv_minbytes_1_0= ruleJdlMinBytesValidator ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==27) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // PsiInternalJDL.g:787:4: (lv_minbytes_1_0= ruleJdlMinBytesValidator )
                    {
                    // PsiInternalJDL.g:787:4: (lv_minbytes_1_0= ruleJdlMinBytesValidator )
                    // PsiInternalJDL.g:788:5: lv_minbytes_1_0= ruleJdlMinBytesValidator
                    {

                    					markComposite(elementTypeProvider.getJdlBlobValidators_MinbytesJdlMinBytesValidatorParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FOLLOW_16);
                    lv_minbytes_1_0=ruleJdlMinBytesValidator();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }

            // PsiInternalJDL.g:801:3: ( (lv_maxbytes_2_0= ruleJdlMaxBytesValidator ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==28) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // PsiInternalJDL.g:802:4: (lv_maxbytes_2_0= ruleJdlMaxBytesValidator )
                    {
                    // PsiInternalJDL.g:802:4: (lv_maxbytes_2_0= ruleJdlMaxBytesValidator )
                    // PsiInternalJDL.g:803:5: lv_maxbytes_2_0= ruleJdlMaxBytesValidator
                    {

                    					markComposite(elementTypeProvider.getJdlBlobValidators_MaxbytesJdlMaxBytesValidatorParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_maxbytes_2_0=ruleJdlMaxBytesValidator();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlBlobValidators"


    // $ANTLR start "entryRuleJdlRequiredValidator"
    // PsiInternalJDL.g:820:1: entryRuleJdlRequiredValidator returns [Boolean current=false] : iv_ruleJdlRequiredValidator= ruleJdlRequiredValidator EOF ;
    public final Boolean entryRuleJdlRequiredValidator() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJdlRequiredValidator = null;


        try {
            // PsiInternalJDL.g:820:62: (iv_ruleJdlRequiredValidator= ruleJdlRequiredValidator EOF )
            // PsiInternalJDL.g:821:2: iv_ruleJdlRequiredValidator= ruleJdlRequiredValidator EOF
            {
             markComposite(elementTypeProvider.getJdlRequiredValidatorElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlRequiredValidator=ruleJdlRequiredValidator();

            state._fsp--;

             current =iv_ruleJdlRequiredValidator; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJdlRequiredValidator"


    // $ANTLR start "ruleJdlRequiredValidator"
    // PsiInternalJDL.g:827:1: ruleJdlRequiredValidator returns [Boolean current=false] : ( (lv_required_0_0= 'required' ) ) ;
    public final Boolean ruleJdlRequiredValidator() throws RecognitionException {
        Boolean current = false;

        Token lv_required_0_0=null;

        try {
            // PsiInternalJDL.g:828:1: ( ( (lv_required_0_0= 'required' ) ) )
            // PsiInternalJDL.g:829:2: ( (lv_required_0_0= 'required' ) )
            {
            // PsiInternalJDL.g:829:2: ( (lv_required_0_0= 'required' ) )
            // PsiInternalJDL.g:830:3: (lv_required_0_0= 'required' )
            {
            // PsiInternalJDL.g:830:3: (lv_required_0_0= 'required' )
            // PsiInternalJDL.g:831:4: lv_required_0_0= 'required'
            {

            				markLeaf(elementTypeProvider.getJdlRequiredValidator_RequiredRequiredKeyword_0ElementType());
            			
            lv_required_0_0=(Token)match(input,19,FOLLOW_2); 

            				doneLeaf(lv_required_0_0);
            			

            				if (!current) {
            					associateWithSemanticElement();
            					current = true;
            				}
            			

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlRequiredValidator"


    // $ANTLR start "entryRuleJdlMinLengthValidator"
    // PsiInternalJDL.g:849:1: entryRuleJdlMinLengthValidator returns [Boolean current=false] : iv_ruleJdlMinLengthValidator= ruleJdlMinLengthValidator EOF ;
    public final Boolean entryRuleJdlMinLengthValidator() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJdlMinLengthValidator = null;


        try {
            // PsiInternalJDL.g:849:63: (iv_ruleJdlMinLengthValidator= ruleJdlMinLengthValidator EOF )
            // PsiInternalJDL.g:850:2: iv_ruleJdlMinLengthValidator= ruleJdlMinLengthValidator EOF
            {
             markComposite(elementTypeProvider.getJdlMinLengthValidatorElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlMinLengthValidator=ruleJdlMinLengthValidator();

            state._fsp--;

             current =iv_ruleJdlMinLengthValidator; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJdlMinLengthValidator"


    // $ANTLR start "ruleJdlMinLengthValidator"
    // PsiInternalJDL.g:856:1: ruleJdlMinLengthValidator returns [Boolean current=false] : (otherlv_0= 'minlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final Boolean ruleJdlMinLengthValidator() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;

        try {
            // PsiInternalJDL.g:857:1: ( (otherlv_0= 'minlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // PsiInternalJDL.g:858:2: (otherlv_0= 'minlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // PsiInternalJDL.g:858:2: (otherlv_0= 'minlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            // PsiInternalJDL.g:859:3: otherlv_0= 'minlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')'
            {

            			markLeaf(elementTypeProvider.getJdlMinLengthValidator_MinlengthKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,20,FOLLOW_17); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getJdlMinLengthValidator_LeftParenthesisKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,21,FOLLOW_18); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:873:3: ( (lv_value_2_0= RULE_INT ) )
            // PsiInternalJDL.g:874:4: (lv_value_2_0= RULE_INT )
            {
            // PsiInternalJDL.g:874:4: (lv_value_2_0= RULE_INT )
            // PsiInternalJDL.g:875:5: lv_value_2_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getJdlMinLengthValidator_ValueINTTerminalRuleCall_2_0ElementType());
            				
            lv_value_2_0=(Token)match(input,RULE_INT,FOLLOW_19); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_value_2_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getJdlMinLengthValidator_RightParenthesisKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,22,FOLLOW_2); 

            			doneLeaf(otherlv_3);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlMinLengthValidator"


    // $ANTLR start "entryRuleJdlMaxLengthValidator"
    // PsiInternalJDL.g:901:1: entryRuleJdlMaxLengthValidator returns [Boolean current=false] : iv_ruleJdlMaxLengthValidator= ruleJdlMaxLengthValidator EOF ;
    public final Boolean entryRuleJdlMaxLengthValidator() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJdlMaxLengthValidator = null;


        try {
            // PsiInternalJDL.g:901:63: (iv_ruleJdlMaxLengthValidator= ruleJdlMaxLengthValidator EOF )
            // PsiInternalJDL.g:902:2: iv_ruleJdlMaxLengthValidator= ruleJdlMaxLengthValidator EOF
            {
             markComposite(elementTypeProvider.getJdlMaxLengthValidatorElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlMaxLengthValidator=ruleJdlMaxLengthValidator();

            state._fsp--;

             current =iv_ruleJdlMaxLengthValidator; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJdlMaxLengthValidator"


    // $ANTLR start "ruleJdlMaxLengthValidator"
    // PsiInternalJDL.g:908:1: ruleJdlMaxLengthValidator returns [Boolean current=false] : (otherlv_0= 'maxlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final Boolean ruleJdlMaxLengthValidator() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;

        try {
            // PsiInternalJDL.g:909:1: ( (otherlv_0= 'maxlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // PsiInternalJDL.g:910:2: (otherlv_0= 'maxlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // PsiInternalJDL.g:910:2: (otherlv_0= 'maxlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            // PsiInternalJDL.g:911:3: otherlv_0= 'maxlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')'
            {

            			markLeaf(elementTypeProvider.getJdlMaxLengthValidator_MaxlengthKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,23,FOLLOW_17); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getJdlMaxLengthValidator_LeftParenthesisKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,21,FOLLOW_18); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:925:3: ( (lv_value_2_0= RULE_INT ) )
            // PsiInternalJDL.g:926:4: (lv_value_2_0= RULE_INT )
            {
            // PsiInternalJDL.g:926:4: (lv_value_2_0= RULE_INT )
            // PsiInternalJDL.g:927:5: lv_value_2_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getJdlMaxLengthValidator_ValueINTTerminalRuleCall_2_0ElementType());
            				
            lv_value_2_0=(Token)match(input,RULE_INT,FOLLOW_19); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_value_2_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getJdlMaxLengthValidator_RightParenthesisKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,22,FOLLOW_2); 

            			doneLeaf(otherlv_3);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlMaxLengthValidator"


    // $ANTLR start "entryRuleJdlPatternValidator"
    // PsiInternalJDL.g:953:1: entryRuleJdlPatternValidator returns [Boolean current=false] : iv_ruleJdlPatternValidator= ruleJdlPatternValidator EOF ;
    public final Boolean entryRuleJdlPatternValidator() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJdlPatternValidator = null;


        try {
            // PsiInternalJDL.g:953:61: (iv_ruleJdlPatternValidator= ruleJdlPatternValidator EOF )
            // PsiInternalJDL.g:954:2: iv_ruleJdlPatternValidator= ruleJdlPatternValidator EOF
            {
             markComposite(elementTypeProvider.getJdlPatternValidatorElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlPatternValidator=ruleJdlPatternValidator();

            state._fsp--;

             current =iv_ruleJdlPatternValidator; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJdlPatternValidator"


    // $ANTLR start "ruleJdlPatternValidator"
    // PsiInternalJDL.g:960:1: ruleJdlPatternValidator returns [Boolean current=false] : (otherlv_0= 'pattern' otherlv_1= '(' ( (lv_value_2_0= RULE_STRING ) ) otherlv_3= ')' ) ;
    public final Boolean ruleJdlPatternValidator() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;

        try {
            // PsiInternalJDL.g:961:1: ( (otherlv_0= 'pattern' otherlv_1= '(' ( (lv_value_2_0= RULE_STRING ) ) otherlv_3= ')' ) )
            // PsiInternalJDL.g:962:2: (otherlv_0= 'pattern' otherlv_1= '(' ( (lv_value_2_0= RULE_STRING ) ) otherlv_3= ')' )
            {
            // PsiInternalJDL.g:962:2: (otherlv_0= 'pattern' otherlv_1= '(' ( (lv_value_2_0= RULE_STRING ) ) otherlv_3= ')' )
            // PsiInternalJDL.g:963:3: otherlv_0= 'pattern' otherlv_1= '(' ( (lv_value_2_0= RULE_STRING ) ) otherlv_3= ')'
            {

            			markLeaf(elementTypeProvider.getJdlPatternValidator_PatternKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,24,FOLLOW_17); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getJdlPatternValidator_LeftParenthesisKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,21,FOLLOW_20); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:977:3: ( (lv_value_2_0= RULE_STRING ) )
            // PsiInternalJDL.g:978:4: (lv_value_2_0= RULE_STRING )
            {
            // PsiInternalJDL.g:978:4: (lv_value_2_0= RULE_STRING )
            // PsiInternalJDL.g:979:5: lv_value_2_0= RULE_STRING
            {

            					markLeaf(elementTypeProvider.getJdlPatternValidator_ValueSTRINGTerminalRuleCall_2_0ElementType());
            				
            lv_value_2_0=(Token)match(input,RULE_STRING,FOLLOW_19); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_value_2_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getJdlPatternValidator_RightParenthesisKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,22,FOLLOW_2); 

            			doneLeaf(otherlv_3);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlPatternValidator"


    // $ANTLR start "entryRuleJdlMinValidator"
    // PsiInternalJDL.g:1005:1: entryRuleJdlMinValidator returns [Boolean current=false] : iv_ruleJdlMinValidator= ruleJdlMinValidator EOF ;
    public final Boolean entryRuleJdlMinValidator() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJdlMinValidator = null;


        try {
            // PsiInternalJDL.g:1005:57: (iv_ruleJdlMinValidator= ruleJdlMinValidator EOF )
            // PsiInternalJDL.g:1006:2: iv_ruleJdlMinValidator= ruleJdlMinValidator EOF
            {
             markComposite(elementTypeProvider.getJdlMinValidatorElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlMinValidator=ruleJdlMinValidator();

            state._fsp--;

             current =iv_ruleJdlMinValidator; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJdlMinValidator"


    // $ANTLR start "ruleJdlMinValidator"
    // PsiInternalJDL.g:1012:1: ruleJdlMinValidator returns [Boolean current=false] : (otherlv_0= 'min' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final Boolean ruleJdlMinValidator() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;

        try {
            // PsiInternalJDL.g:1013:1: ( (otherlv_0= 'min' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // PsiInternalJDL.g:1014:2: (otherlv_0= 'min' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // PsiInternalJDL.g:1014:2: (otherlv_0= 'min' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            // PsiInternalJDL.g:1015:3: otherlv_0= 'min' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')'
            {

            			markLeaf(elementTypeProvider.getJdlMinValidator_MinKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,25,FOLLOW_17); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getJdlMinValidator_LeftParenthesisKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,21,FOLLOW_18); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:1029:3: ( (lv_value_2_0= RULE_INT ) )
            // PsiInternalJDL.g:1030:4: (lv_value_2_0= RULE_INT )
            {
            // PsiInternalJDL.g:1030:4: (lv_value_2_0= RULE_INT )
            // PsiInternalJDL.g:1031:5: lv_value_2_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getJdlMinValidator_ValueINTTerminalRuleCall_2_0ElementType());
            				
            lv_value_2_0=(Token)match(input,RULE_INT,FOLLOW_19); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_value_2_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getJdlMinValidator_RightParenthesisKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,22,FOLLOW_2); 

            			doneLeaf(otherlv_3);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlMinValidator"


    // $ANTLR start "entryRuleJdlMaxValidator"
    // PsiInternalJDL.g:1057:1: entryRuleJdlMaxValidator returns [Boolean current=false] : iv_ruleJdlMaxValidator= ruleJdlMaxValidator EOF ;
    public final Boolean entryRuleJdlMaxValidator() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJdlMaxValidator = null;


        try {
            // PsiInternalJDL.g:1057:57: (iv_ruleJdlMaxValidator= ruleJdlMaxValidator EOF )
            // PsiInternalJDL.g:1058:2: iv_ruleJdlMaxValidator= ruleJdlMaxValidator EOF
            {
             markComposite(elementTypeProvider.getJdlMaxValidatorElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlMaxValidator=ruleJdlMaxValidator();

            state._fsp--;

             current =iv_ruleJdlMaxValidator; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJdlMaxValidator"


    // $ANTLR start "ruleJdlMaxValidator"
    // PsiInternalJDL.g:1064:1: ruleJdlMaxValidator returns [Boolean current=false] : (otherlv_0= 'max' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final Boolean ruleJdlMaxValidator() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;

        try {
            // PsiInternalJDL.g:1065:1: ( (otherlv_0= 'max' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // PsiInternalJDL.g:1066:2: (otherlv_0= 'max' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // PsiInternalJDL.g:1066:2: (otherlv_0= 'max' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            // PsiInternalJDL.g:1067:3: otherlv_0= 'max' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')'
            {

            			markLeaf(elementTypeProvider.getJdlMaxValidator_MaxKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,26,FOLLOW_17); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getJdlMaxValidator_LeftParenthesisKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,21,FOLLOW_18); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:1081:3: ( (lv_value_2_0= RULE_INT ) )
            // PsiInternalJDL.g:1082:4: (lv_value_2_0= RULE_INT )
            {
            // PsiInternalJDL.g:1082:4: (lv_value_2_0= RULE_INT )
            // PsiInternalJDL.g:1083:5: lv_value_2_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getJdlMaxValidator_ValueINTTerminalRuleCall_2_0ElementType());
            				
            lv_value_2_0=(Token)match(input,RULE_INT,FOLLOW_19); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_value_2_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getJdlMaxValidator_RightParenthesisKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,22,FOLLOW_2); 

            			doneLeaf(otherlv_3);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlMaxValidator"


    // $ANTLR start "entryRuleJdlMinBytesValidator"
    // PsiInternalJDL.g:1109:1: entryRuleJdlMinBytesValidator returns [Boolean current=false] : iv_ruleJdlMinBytesValidator= ruleJdlMinBytesValidator EOF ;
    public final Boolean entryRuleJdlMinBytesValidator() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJdlMinBytesValidator = null;


        try {
            // PsiInternalJDL.g:1109:62: (iv_ruleJdlMinBytesValidator= ruleJdlMinBytesValidator EOF )
            // PsiInternalJDL.g:1110:2: iv_ruleJdlMinBytesValidator= ruleJdlMinBytesValidator EOF
            {
             markComposite(elementTypeProvider.getJdlMinBytesValidatorElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlMinBytesValidator=ruleJdlMinBytesValidator();

            state._fsp--;

             current =iv_ruleJdlMinBytesValidator; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJdlMinBytesValidator"


    // $ANTLR start "ruleJdlMinBytesValidator"
    // PsiInternalJDL.g:1116:1: ruleJdlMinBytesValidator returns [Boolean current=false] : (otherlv_0= 'minbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final Boolean ruleJdlMinBytesValidator() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;

        try {
            // PsiInternalJDL.g:1117:1: ( (otherlv_0= 'minbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // PsiInternalJDL.g:1118:2: (otherlv_0= 'minbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // PsiInternalJDL.g:1118:2: (otherlv_0= 'minbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            // PsiInternalJDL.g:1119:3: otherlv_0= 'minbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')'
            {

            			markLeaf(elementTypeProvider.getJdlMinBytesValidator_MinbytesKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,27,FOLLOW_17); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getJdlMinBytesValidator_LeftParenthesisKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,21,FOLLOW_18); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:1133:3: ( (lv_value_2_0= RULE_INT ) )
            // PsiInternalJDL.g:1134:4: (lv_value_2_0= RULE_INT )
            {
            // PsiInternalJDL.g:1134:4: (lv_value_2_0= RULE_INT )
            // PsiInternalJDL.g:1135:5: lv_value_2_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getJdlMinBytesValidator_ValueINTTerminalRuleCall_2_0ElementType());
            				
            lv_value_2_0=(Token)match(input,RULE_INT,FOLLOW_19); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_value_2_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getJdlMinBytesValidator_RightParenthesisKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,22,FOLLOW_2); 

            			doneLeaf(otherlv_3);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlMinBytesValidator"


    // $ANTLR start "entryRuleJdlMaxBytesValidator"
    // PsiInternalJDL.g:1161:1: entryRuleJdlMaxBytesValidator returns [Boolean current=false] : iv_ruleJdlMaxBytesValidator= ruleJdlMaxBytesValidator EOF ;
    public final Boolean entryRuleJdlMaxBytesValidator() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJdlMaxBytesValidator = null;


        try {
            // PsiInternalJDL.g:1161:62: (iv_ruleJdlMaxBytesValidator= ruleJdlMaxBytesValidator EOF )
            // PsiInternalJDL.g:1162:2: iv_ruleJdlMaxBytesValidator= ruleJdlMaxBytesValidator EOF
            {
             markComposite(elementTypeProvider.getJdlMaxBytesValidatorElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlMaxBytesValidator=ruleJdlMaxBytesValidator();

            state._fsp--;

             current =iv_ruleJdlMaxBytesValidator; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJdlMaxBytesValidator"


    // $ANTLR start "ruleJdlMaxBytesValidator"
    // PsiInternalJDL.g:1168:1: ruleJdlMaxBytesValidator returns [Boolean current=false] : (otherlv_0= 'maxbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final Boolean ruleJdlMaxBytesValidator() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;

        try {
            // PsiInternalJDL.g:1169:1: ( (otherlv_0= 'maxbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // PsiInternalJDL.g:1170:2: (otherlv_0= 'maxbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // PsiInternalJDL.g:1170:2: (otherlv_0= 'maxbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            // PsiInternalJDL.g:1171:3: otherlv_0= 'maxbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')'
            {

            			markLeaf(elementTypeProvider.getJdlMaxBytesValidator_MaxbytesKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,28,FOLLOW_17); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getJdlMaxBytesValidator_LeftParenthesisKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,21,FOLLOW_18); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:1185:3: ( (lv_value_2_0= RULE_INT ) )
            // PsiInternalJDL.g:1186:4: (lv_value_2_0= RULE_INT )
            {
            // PsiInternalJDL.g:1186:4: (lv_value_2_0= RULE_INT )
            // PsiInternalJDL.g:1187:5: lv_value_2_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getJdlMaxBytesValidator_ValueINTTerminalRuleCall_2_0ElementType());
            				
            lv_value_2_0=(Token)match(input,RULE_INT,FOLLOW_19); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_value_2_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getJdlMaxBytesValidator_RightParenthesisKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,22,FOLLOW_2); 

            			doneLeaf(otherlv_3);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlMaxBytesValidator"


    // $ANTLR start "entryRuleJdlRelationships"
    // PsiInternalJDL.g:1213:1: entryRuleJdlRelationships returns [Boolean current=false] : iv_ruleJdlRelationships= ruleJdlRelationships EOF ;
    public final Boolean entryRuleJdlRelationships() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJdlRelationships = null;


        try {
            // PsiInternalJDL.g:1213:58: (iv_ruleJdlRelationships= ruleJdlRelationships EOF )
            // PsiInternalJDL.g:1214:2: iv_ruleJdlRelationships= ruleJdlRelationships EOF
            {
             markComposite(elementTypeProvider.getJdlRelationshipsElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlRelationships=ruleJdlRelationships();

            state._fsp--;

             current =iv_ruleJdlRelationships; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJdlRelationships"


    // $ANTLR start "ruleJdlRelationships"
    // PsiInternalJDL.g:1220:1: ruleJdlRelationships returns [Boolean current=false] : (otherlv_0= 'relationship' ( (lv_cardinality_1_0= ruleJdlCardinality ) ) otherlv_2= '{' ( (lv_relationships_3_0= ruleJdlRelationship ) )* (otherlv_4= ',' ( (lv_relationships_5_0= ruleJdlRelationship ) ) )* otherlv_6= '}' ) ;
    public final Boolean ruleJdlRelationships() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Boolean lv_cardinality_1_0 = null;

        Boolean lv_relationships_3_0 = null;

        Boolean lv_relationships_5_0 = null;


        try {
            // PsiInternalJDL.g:1221:1: ( (otherlv_0= 'relationship' ( (lv_cardinality_1_0= ruleJdlCardinality ) ) otherlv_2= '{' ( (lv_relationships_3_0= ruleJdlRelationship ) )* (otherlv_4= ',' ( (lv_relationships_5_0= ruleJdlRelationship ) ) )* otherlv_6= '}' ) )
            // PsiInternalJDL.g:1222:2: (otherlv_0= 'relationship' ( (lv_cardinality_1_0= ruleJdlCardinality ) ) otherlv_2= '{' ( (lv_relationships_3_0= ruleJdlRelationship ) )* (otherlv_4= ',' ( (lv_relationships_5_0= ruleJdlRelationship ) ) )* otherlv_6= '}' )
            {
            // PsiInternalJDL.g:1222:2: (otherlv_0= 'relationship' ( (lv_cardinality_1_0= ruleJdlCardinality ) ) otherlv_2= '{' ( (lv_relationships_3_0= ruleJdlRelationship ) )* (otherlv_4= ',' ( (lv_relationships_5_0= ruleJdlRelationship ) ) )* otherlv_6= '}' )
            // PsiInternalJDL.g:1223:3: otherlv_0= 'relationship' ( (lv_cardinality_1_0= ruleJdlCardinality ) ) otherlv_2= '{' ( (lv_relationships_3_0= ruleJdlRelationship ) )* (otherlv_4= ',' ( (lv_relationships_5_0= ruleJdlRelationship ) ) )* otherlv_6= '}'
            {

            			markLeaf(elementTypeProvider.getJdlRelationships_RelationshipKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,29,FOLLOW_21); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalJDL.g:1230:3: ( (lv_cardinality_1_0= ruleJdlCardinality ) )
            // PsiInternalJDL.g:1231:4: (lv_cardinality_1_0= ruleJdlCardinality )
            {
            // PsiInternalJDL.g:1231:4: (lv_cardinality_1_0= ruleJdlCardinality )
            // PsiInternalJDL.g:1232:5: lv_cardinality_1_0= ruleJdlCardinality
            {

            					markComposite(elementTypeProvider.getJdlRelationships_CardinalityJdlCardinalityEnumRuleCall_1_0ElementType());
            				
            pushFollow(FOLLOW_22);
            lv_cardinality_1_0=ruleJdlCardinality();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }


            			markLeaf(elementTypeProvider.getJdlRelationships_LeftCurlyBracketKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_23); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalJDL.g:1252:3: ( (lv_relationships_3_0= ruleJdlRelationship ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_ID) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // PsiInternalJDL.g:1253:4: (lv_relationships_3_0= ruleJdlRelationship )
            	    {
            	    // PsiInternalJDL.g:1253:4: (lv_relationships_3_0= ruleJdlRelationship )
            	    // PsiInternalJDL.g:1254:5: lv_relationships_3_0= ruleJdlRelationship
            	    {

            	    					markComposite(elementTypeProvider.getJdlRelationships_RelationshipsJdlRelationshipParserRuleCall_3_0ElementType());
            	    				
            	    pushFollow(FOLLOW_23);
            	    lv_relationships_3_0=ruleJdlRelationship();

            	    state._fsp--;


            	    					doneComposite();
            	    					if(!current) {
            	    						associateWithSemanticElement();
            	    						current = true;
            	    					}
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            // PsiInternalJDL.g:1267:3: (otherlv_4= ',' ( (lv_relationships_5_0= ruleJdlRelationship ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==13) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // PsiInternalJDL.g:1268:4: otherlv_4= ',' ( (lv_relationships_5_0= ruleJdlRelationship ) )
            	    {

            	    				markLeaf(elementTypeProvider.getJdlRelationships_CommaKeyword_4_0ElementType());
            	    			
            	    otherlv_4=(Token)match(input,13,FOLLOW_4); 

            	    				doneLeaf(otherlv_4);
            	    			
            	    // PsiInternalJDL.g:1275:4: ( (lv_relationships_5_0= ruleJdlRelationship ) )
            	    // PsiInternalJDL.g:1276:5: (lv_relationships_5_0= ruleJdlRelationship )
            	    {
            	    // PsiInternalJDL.g:1276:5: (lv_relationships_5_0= ruleJdlRelationship )
            	    // PsiInternalJDL.g:1277:6: lv_relationships_5_0= ruleJdlRelationship
            	    {

            	    						markComposite(elementTypeProvider.getJdlRelationships_RelationshipsJdlRelationshipParserRuleCall_4_1_0ElementType());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_relationships_5_0=ruleJdlRelationship();

            	    state._fsp--;


            	    						doneComposite();
            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            			markLeaf(elementTypeProvider.getJdlRelationships_RightCurlyBracketKeyword_5ElementType());
            		
            otherlv_6=(Token)match(input,14,FOLLOW_2); 

            			doneLeaf(otherlv_6);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlRelationships"


    // $ANTLR start "entryRuleJdlRelationship"
    // PsiInternalJDL.g:1302:1: entryRuleJdlRelationship returns [Boolean current=false] : iv_ruleJdlRelationship= ruleJdlRelationship EOF ;
    public final Boolean entryRuleJdlRelationship() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJdlRelationship = null;


        try {
            // PsiInternalJDL.g:1302:57: (iv_ruleJdlRelationship= ruleJdlRelationship EOF )
            // PsiInternalJDL.g:1303:2: iv_ruleJdlRelationship= ruleJdlRelationship EOF
            {
             markComposite(elementTypeProvider.getJdlRelationshipElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlRelationship=ruleJdlRelationship();

            state._fsp--;

             current =iv_ruleJdlRelationship; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJdlRelationship"


    // $ANTLR start "ruleJdlRelationship"
    // PsiInternalJDL.g:1309:1: ruleJdlRelationship returns [Boolean current=false] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_fromName_1_0= ruleJdlRelationshipName ) )? otherlv_2= 'to' ( (otherlv_3= RULE_ID ) ) ( (lv_toName_4_0= ruleJdlRelationshipName ) )? ) ;
    public final Boolean ruleJdlRelationship() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Boolean lv_fromName_1_0 = null;

        Boolean lv_toName_4_0 = null;


        try {
            // PsiInternalJDL.g:1310:1: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_fromName_1_0= ruleJdlRelationshipName ) )? otherlv_2= 'to' ( (otherlv_3= RULE_ID ) ) ( (lv_toName_4_0= ruleJdlRelationshipName ) )? ) )
            // PsiInternalJDL.g:1311:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_fromName_1_0= ruleJdlRelationshipName ) )? otherlv_2= 'to' ( (otherlv_3= RULE_ID ) ) ( (lv_toName_4_0= ruleJdlRelationshipName ) )? )
            {
            // PsiInternalJDL.g:1311:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_fromName_1_0= ruleJdlRelationshipName ) )? otherlv_2= 'to' ( (otherlv_3= RULE_ID ) ) ( (lv_toName_4_0= ruleJdlRelationshipName ) )? )
            // PsiInternalJDL.g:1312:3: ( (otherlv_0= RULE_ID ) ) ( (lv_fromName_1_0= ruleJdlRelationshipName ) )? otherlv_2= 'to' ( (otherlv_3= RULE_ID ) ) ( (lv_toName_4_0= ruleJdlRelationshipName ) )?
            {
            // PsiInternalJDL.g:1312:3: ( (otherlv_0= RULE_ID ) )
            // PsiInternalJDL.g:1313:4: (otherlv_0= RULE_ID )
            {
            // PsiInternalJDL.g:1313:4: (otherlv_0= RULE_ID )
            // PsiInternalJDL.g:1314:5: otherlv_0= RULE_ID
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					markLeaf(elementTypeProvider.getJdlRelationship_FromEntityJdlEntityCrossReference_0_0ElementType());
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_24); 

            					doneLeaf(otherlv_0);
            				

            }


            }

            // PsiInternalJDL.g:1329:3: ( (lv_fromName_1_0= ruleJdlRelationshipName ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==12) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // PsiInternalJDL.g:1330:4: (lv_fromName_1_0= ruleJdlRelationshipName )
                    {
                    // PsiInternalJDL.g:1330:4: (lv_fromName_1_0= ruleJdlRelationshipName )
                    // PsiInternalJDL.g:1331:5: lv_fromName_1_0= ruleJdlRelationshipName
                    {

                    					markComposite(elementTypeProvider.getJdlRelationship_FromNameJdlRelationshipNameParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FOLLOW_25);
                    lv_fromName_1_0=ruleJdlRelationshipName();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getJdlRelationship_ToKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,30,FOLLOW_4); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalJDL.g:1351:3: ( (otherlv_3= RULE_ID ) )
            // PsiInternalJDL.g:1352:4: (otherlv_3= RULE_ID )
            {
            // PsiInternalJDL.g:1352:4: (otherlv_3= RULE_ID )
            // PsiInternalJDL.g:1353:5: otherlv_3= RULE_ID
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					markLeaf(elementTypeProvider.getJdlRelationship_ToEntityJdlEntityCrossReference_3_0ElementType());
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_5); 

            					doneLeaf(otherlv_3);
            				

            }


            }

            // PsiInternalJDL.g:1368:3: ( (lv_toName_4_0= ruleJdlRelationshipName ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==12) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // PsiInternalJDL.g:1369:4: (lv_toName_4_0= ruleJdlRelationshipName )
                    {
                    // PsiInternalJDL.g:1369:4: (lv_toName_4_0= ruleJdlRelationshipName )
                    // PsiInternalJDL.g:1370:5: lv_toName_4_0= ruleJdlRelationshipName
                    {

                    					markComposite(elementTypeProvider.getJdlRelationship_ToNameJdlRelationshipNameParserRuleCall_4_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_toName_4_0=ruleJdlRelationshipName();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlRelationship"


    // $ANTLR start "entryRuleJdlRelationshipName"
    // PsiInternalJDL.g:1387:1: entryRuleJdlRelationshipName returns [Boolean current=false] : iv_ruleJdlRelationshipName= ruleJdlRelationshipName EOF ;
    public final Boolean entryRuleJdlRelationshipName() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJdlRelationshipName = null;


        try {
            // PsiInternalJDL.g:1387:61: (iv_ruleJdlRelationshipName= ruleJdlRelationshipName EOF )
            // PsiInternalJDL.g:1388:2: iv_ruleJdlRelationshipName= ruleJdlRelationshipName EOF
            {
             markComposite(elementTypeProvider.getJdlRelationshipNameElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlRelationshipName=ruleJdlRelationshipName();

            state._fsp--;

             current =iv_ruleJdlRelationshipName; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJdlRelationshipName"


    // $ANTLR start "ruleJdlRelationshipName"
    // PsiInternalJDL.g:1394:1: ruleJdlRelationshipName returns [Boolean current=false] : (otherlv_0= '{' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_role_3_0= RULE_ID ) ) otherlv_4= ')' )? otherlv_5= '}' ) ;
    public final Boolean ruleJdlRelationshipName() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_role_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;

        try {
            // PsiInternalJDL.g:1395:1: ( (otherlv_0= '{' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_role_3_0= RULE_ID ) ) otherlv_4= ')' )? otherlv_5= '}' ) )
            // PsiInternalJDL.g:1396:2: (otherlv_0= '{' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_role_3_0= RULE_ID ) ) otherlv_4= ')' )? otherlv_5= '}' )
            {
            // PsiInternalJDL.g:1396:2: (otherlv_0= '{' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_role_3_0= RULE_ID ) ) otherlv_4= ')' )? otherlv_5= '}' )
            // PsiInternalJDL.g:1397:3: otherlv_0= '{' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_role_3_0= RULE_ID ) ) otherlv_4= ')' )? otherlv_5= '}'
            {

            			markLeaf(elementTypeProvider.getJdlRelationshipName_LeftCurlyBracketKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,12,FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalJDL.g:1404:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalJDL.g:1405:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalJDL.g:1405:4: (lv_name_1_0= RULE_ID )
            // PsiInternalJDL.g:1406:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getJdlRelationshipName_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_26); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_1_0);
            				

            }


            }

            // PsiInternalJDL.g:1421:3: (otherlv_2= '(' ( (lv_role_3_0= RULE_ID ) ) otherlv_4= ')' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==21) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // PsiInternalJDL.g:1422:4: otherlv_2= '(' ( (lv_role_3_0= RULE_ID ) ) otherlv_4= ')'
                    {

                    				markLeaf(elementTypeProvider.getJdlRelationshipName_LeftParenthesisKeyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,21,FOLLOW_4); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalJDL.g:1429:4: ( (lv_role_3_0= RULE_ID ) )
                    // PsiInternalJDL.g:1430:5: (lv_role_3_0= RULE_ID )
                    {
                    // PsiInternalJDL.g:1430:5: (lv_role_3_0= RULE_ID )
                    // PsiInternalJDL.g:1431:6: lv_role_3_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getJdlRelationshipName_RoleIDTerminalRuleCall_2_1_0ElementType());
                    					
                    lv_role_3_0=(Token)match(input,RULE_ID,FOLLOW_19); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						doneLeaf(lv_role_3_0);
                    					

                    }


                    }


                    				markLeaf(elementTypeProvider.getJdlRelationshipName_RightParenthesisKeyword_2_2ElementType());
                    			
                    otherlv_4=(Token)match(input,22,FOLLOW_27); 

                    				doneLeaf(otherlv_4);
                    			

                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getJdlRelationshipName_RightCurlyBracketKeyword_3ElementType());
            		
            otherlv_5=(Token)match(input,14,FOLLOW_2); 

            			doneLeaf(otherlv_5);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlRelationshipName"


    // $ANTLR start "entryRuleJdlEnumType"
    // PsiInternalJDL.g:1465:1: entryRuleJdlEnumType returns [Boolean current=false] : iv_ruleJdlEnumType= ruleJdlEnumType EOF ;
    public final Boolean entryRuleJdlEnumType() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJdlEnumType = null;


        try {
            // PsiInternalJDL.g:1465:53: (iv_ruleJdlEnumType= ruleJdlEnumType EOF )
            // PsiInternalJDL.g:1466:2: iv_ruleJdlEnumType= ruleJdlEnumType EOF
            {
             markComposite(elementTypeProvider.getJdlEnumTypeElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlEnumType=ruleJdlEnumType();

            state._fsp--;

             current =iv_ruleJdlEnumType; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJdlEnumType"


    // $ANTLR start "ruleJdlEnumType"
    // PsiInternalJDL.g:1472:1: ruleJdlEnumType returns [Boolean current=false] : (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_values_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_values_5_0= RULE_ID ) ) )* otherlv_6= '}' ) ;
    public final Boolean ruleJdlEnumType() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_values_3_0=null;
        Token otherlv_4=null;
        Token lv_values_5_0=null;
        Token otherlv_6=null;

        try {
            // PsiInternalJDL.g:1473:1: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_values_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_values_5_0= RULE_ID ) ) )* otherlv_6= '}' ) )
            // PsiInternalJDL.g:1474:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_values_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_values_5_0= RULE_ID ) ) )* otherlv_6= '}' )
            {
            // PsiInternalJDL.g:1474:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_values_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_values_5_0= RULE_ID ) ) )* otherlv_6= '}' )
            // PsiInternalJDL.g:1475:3: otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_values_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_values_5_0= RULE_ID ) ) )* otherlv_6= '}'
            {

            			markLeaf(elementTypeProvider.getJdlEnumType_EnumKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,31,FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalJDL.g:1482:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalJDL.g:1483:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalJDL.g:1483:4: (lv_name_1_0= RULE_ID )
            // PsiInternalJDL.g:1484:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getJdlEnumType_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_22); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getJdlEnumType_LeftCurlyBracketKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_4); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalJDL.g:1506:3: ( (lv_values_3_0= RULE_ID ) )
            // PsiInternalJDL.g:1507:4: (lv_values_3_0= RULE_ID )
            {
            // PsiInternalJDL.g:1507:4: (lv_values_3_0= RULE_ID )
            // PsiInternalJDL.g:1508:5: lv_values_3_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getJdlEnumType_ValuesIDTerminalRuleCall_3_0ElementType());
            				
            lv_values_3_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_values_3_0);
            				

            }


            }

            // PsiInternalJDL.g:1523:3: (otherlv_4= ',' ( (lv_values_5_0= RULE_ID ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==13) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // PsiInternalJDL.g:1524:4: otherlv_4= ',' ( (lv_values_5_0= RULE_ID ) )
            	    {

            	    				markLeaf(elementTypeProvider.getJdlEnumType_CommaKeyword_4_0ElementType());
            	    			
            	    otherlv_4=(Token)match(input,13,FOLLOW_4); 

            	    				doneLeaf(otherlv_4);
            	    			
            	    // PsiInternalJDL.g:1531:4: ( (lv_values_5_0= RULE_ID ) )
            	    // PsiInternalJDL.g:1532:5: (lv_values_5_0= RULE_ID )
            	    {
            	    // PsiInternalJDL.g:1532:5: (lv_values_5_0= RULE_ID )
            	    // PsiInternalJDL.g:1533:6: lv_values_5_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getJdlEnumType_ValuesIDTerminalRuleCall_4_1_0ElementType());
            	    					
            	    lv_values_5_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

            	    						doneLeaf(lv_values_5_0);
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            			markLeaf(elementTypeProvider.getJdlEnumType_RightCurlyBracketKeyword_5ElementType());
            		
            otherlv_6=(Token)match(input,14,FOLLOW_2); 

            			doneLeaf(otherlv_6);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlEnumType"


    // $ANTLR start "entryRuleJdlGenerationSetting"
    // PsiInternalJDL.g:1560:1: entryRuleJdlGenerationSetting returns [Boolean current=false] : iv_ruleJdlGenerationSetting= ruleJdlGenerationSetting EOF ;
    public final Boolean entryRuleJdlGenerationSetting() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJdlGenerationSetting = null;


        try {
            // PsiInternalJDL.g:1560:62: (iv_ruleJdlGenerationSetting= ruleJdlGenerationSetting EOF )
            // PsiInternalJDL.g:1561:2: iv_ruleJdlGenerationSetting= ruleJdlGenerationSetting EOF
            {
             markComposite(elementTypeProvider.getJdlGenerationSettingElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlGenerationSetting=ruleJdlGenerationSetting();

            state._fsp--;

             current =iv_ruleJdlGenerationSetting; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJdlGenerationSetting"


    // $ANTLR start "ruleJdlGenerationSetting"
    // PsiInternalJDL.g:1567:1: ruleJdlGenerationSetting returns [Boolean current=false] : ( ( (lv_setting_0_0= ruleJdlGenerationSettingType ) ) ( (lv_excludes_1_0= ruleJdlEntityExclusion ) )? ) ;
    public final Boolean ruleJdlGenerationSetting() throws RecognitionException {
        Boolean current = false;

        Boolean lv_setting_0_0 = null;

        Boolean lv_excludes_1_0 = null;


        try {
            // PsiInternalJDL.g:1568:1: ( ( ( (lv_setting_0_0= ruleJdlGenerationSettingType ) ) ( (lv_excludes_1_0= ruleJdlEntityExclusion ) )? ) )
            // PsiInternalJDL.g:1569:2: ( ( (lv_setting_0_0= ruleJdlGenerationSettingType ) ) ( (lv_excludes_1_0= ruleJdlEntityExclusion ) )? )
            {
            // PsiInternalJDL.g:1569:2: ( ( (lv_setting_0_0= ruleJdlGenerationSettingType ) ) ( (lv_excludes_1_0= ruleJdlEntityExclusion ) )? )
            // PsiInternalJDL.g:1570:3: ( (lv_setting_0_0= ruleJdlGenerationSettingType ) ) ( (lv_excludes_1_0= ruleJdlEntityExclusion ) )?
            {
            // PsiInternalJDL.g:1570:3: ( (lv_setting_0_0= ruleJdlGenerationSettingType ) )
            // PsiInternalJDL.g:1571:4: (lv_setting_0_0= ruleJdlGenerationSettingType )
            {
            // PsiInternalJDL.g:1571:4: (lv_setting_0_0= ruleJdlGenerationSettingType )
            // PsiInternalJDL.g:1572:5: lv_setting_0_0= ruleJdlGenerationSettingType
            {

            					markComposite(elementTypeProvider.getJdlGenerationSetting_SettingJdlGenerationSettingTypeParserRuleCall_0_0ElementType());
            				
            pushFollow(FOLLOW_28);
            lv_setting_0_0=ruleJdlGenerationSettingType();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalJDL.g:1585:3: ( (lv_excludes_1_0= ruleJdlEntityExclusion ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==39) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // PsiInternalJDL.g:1586:4: (lv_excludes_1_0= ruleJdlEntityExclusion )
                    {
                    // PsiInternalJDL.g:1586:4: (lv_excludes_1_0= ruleJdlEntityExclusion )
                    // PsiInternalJDL.g:1587:5: lv_excludes_1_0= ruleJdlEntityExclusion
                    {

                    					markComposite(elementTypeProvider.getJdlGenerationSetting_ExcludesJdlEntityExclusionParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_excludes_1_0=ruleJdlEntityExclusion();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlGenerationSetting"


    // $ANTLR start "entryRuleJdlGenerationSettingType"
    // PsiInternalJDL.g:1604:1: entryRuleJdlGenerationSettingType returns [Boolean current=false] : iv_ruleJdlGenerationSettingType= ruleJdlGenerationSettingType EOF ;
    public final Boolean entryRuleJdlGenerationSettingType() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJdlGenerationSettingType = null;


        try {
            // PsiInternalJDL.g:1604:66: (iv_ruleJdlGenerationSettingType= ruleJdlGenerationSettingType EOF )
            // PsiInternalJDL.g:1605:2: iv_ruleJdlGenerationSettingType= ruleJdlGenerationSettingType EOF
            {
             markComposite(elementTypeProvider.getJdlGenerationSettingTypeElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlGenerationSettingType=ruleJdlGenerationSettingType();

            state._fsp--;

             current =iv_ruleJdlGenerationSettingType; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJdlGenerationSettingType"


    // $ANTLR start "ruleJdlGenerationSettingType"
    // PsiInternalJDL.g:1611:1: ruleJdlGenerationSettingType returns [Boolean current=false] : (this_JdlServiceGenerationSetting_0= ruleJdlServiceGenerationSetting | this_JdlMicroserviceGenerationSetting_1= ruleJdlMicroserviceGenerationSetting | this_JdlSearchGenerationSetting_2= ruleJdlSearchGenerationSetting | this_JdlDtoGenerationSetting_3= ruleJdlDtoGenerationSetting | this_JdlPaginateGenerationSetting_4= ruleJdlPaginateGenerationSetting | this_JdlAngularSuffixGenerationSetting_5= ruleJdlAngularSuffixGenerationSetting ) ;
    public final Boolean ruleJdlGenerationSettingType() throws RecognitionException {
        Boolean current = false;

        Boolean this_JdlServiceGenerationSetting_0 = null;

        Boolean this_JdlMicroserviceGenerationSetting_1 = null;

        Boolean this_JdlSearchGenerationSetting_2 = null;

        Boolean this_JdlDtoGenerationSetting_3 = null;

        Boolean this_JdlPaginateGenerationSetting_4 = null;

        Boolean this_JdlAngularSuffixGenerationSetting_5 = null;


        try {
            // PsiInternalJDL.g:1612:1: ( (this_JdlServiceGenerationSetting_0= ruleJdlServiceGenerationSetting | this_JdlMicroserviceGenerationSetting_1= ruleJdlMicroserviceGenerationSetting | this_JdlSearchGenerationSetting_2= ruleJdlSearchGenerationSetting | this_JdlDtoGenerationSetting_3= ruleJdlDtoGenerationSetting | this_JdlPaginateGenerationSetting_4= ruleJdlPaginateGenerationSetting | this_JdlAngularSuffixGenerationSetting_5= ruleJdlAngularSuffixGenerationSetting ) )
            // PsiInternalJDL.g:1613:2: (this_JdlServiceGenerationSetting_0= ruleJdlServiceGenerationSetting | this_JdlMicroserviceGenerationSetting_1= ruleJdlMicroserviceGenerationSetting | this_JdlSearchGenerationSetting_2= ruleJdlSearchGenerationSetting | this_JdlDtoGenerationSetting_3= ruleJdlDtoGenerationSetting | this_JdlPaginateGenerationSetting_4= ruleJdlPaginateGenerationSetting | this_JdlAngularSuffixGenerationSetting_5= ruleJdlAngularSuffixGenerationSetting )
            {
            // PsiInternalJDL.g:1613:2: (this_JdlServiceGenerationSetting_0= ruleJdlServiceGenerationSetting | this_JdlMicroserviceGenerationSetting_1= ruleJdlMicroserviceGenerationSetting | this_JdlSearchGenerationSetting_2= ruleJdlSearchGenerationSetting | this_JdlDtoGenerationSetting_3= ruleJdlDtoGenerationSetting | this_JdlPaginateGenerationSetting_4= ruleJdlPaginateGenerationSetting | this_JdlAngularSuffixGenerationSetting_5= ruleJdlAngularSuffixGenerationSetting )
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
                    // PsiInternalJDL.g:1614:3: this_JdlServiceGenerationSetting_0= ruleJdlServiceGenerationSetting
                    {

                    			markComposite(elementTypeProvider.getJdlGenerationSettingType_JdlServiceGenerationSettingParserRuleCall_0ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_JdlServiceGenerationSetting_0=ruleJdlServiceGenerationSetting();

                    state._fsp--;


                    			current = this_JdlServiceGenerationSetting_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalJDL.g:1623:3: this_JdlMicroserviceGenerationSetting_1= ruleJdlMicroserviceGenerationSetting
                    {

                    			markComposite(elementTypeProvider.getJdlGenerationSettingType_JdlMicroserviceGenerationSettingParserRuleCall_1ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_JdlMicroserviceGenerationSetting_1=ruleJdlMicroserviceGenerationSetting();

                    state._fsp--;


                    			current = this_JdlMicroserviceGenerationSetting_1;
                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalJDL.g:1632:3: this_JdlSearchGenerationSetting_2= ruleJdlSearchGenerationSetting
                    {

                    			markComposite(elementTypeProvider.getJdlGenerationSettingType_JdlSearchGenerationSettingParserRuleCall_2ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_JdlSearchGenerationSetting_2=ruleJdlSearchGenerationSetting();

                    state._fsp--;


                    			current = this_JdlSearchGenerationSetting_2;
                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // PsiInternalJDL.g:1641:3: this_JdlDtoGenerationSetting_3= ruleJdlDtoGenerationSetting
                    {

                    			markComposite(elementTypeProvider.getJdlGenerationSettingType_JdlDtoGenerationSettingParserRuleCall_3ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_JdlDtoGenerationSetting_3=ruleJdlDtoGenerationSetting();

                    state._fsp--;


                    			current = this_JdlDtoGenerationSetting_3;
                    			doneComposite();
                    		

                    }
                    break;
                case 5 :
                    // PsiInternalJDL.g:1650:3: this_JdlPaginateGenerationSetting_4= ruleJdlPaginateGenerationSetting
                    {

                    			markComposite(elementTypeProvider.getJdlGenerationSettingType_JdlPaginateGenerationSettingParserRuleCall_4ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_JdlPaginateGenerationSetting_4=ruleJdlPaginateGenerationSetting();

                    state._fsp--;


                    			current = this_JdlPaginateGenerationSetting_4;
                    			doneComposite();
                    		

                    }
                    break;
                case 6 :
                    // PsiInternalJDL.g:1659:3: this_JdlAngularSuffixGenerationSetting_5= ruleJdlAngularSuffixGenerationSetting
                    {

                    			markComposite(elementTypeProvider.getJdlGenerationSettingType_JdlAngularSuffixGenerationSettingParserRuleCall_5ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_JdlAngularSuffixGenerationSetting_5=ruleJdlAngularSuffixGenerationSetting();

                    state._fsp--;


                    			current = this_JdlAngularSuffixGenerationSetting_5;
                    			doneComposite();
                    		

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlGenerationSettingType"


    // $ANTLR start "entryRuleJdlServiceGenerationSetting"
    // PsiInternalJDL.g:1671:1: entryRuleJdlServiceGenerationSetting returns [Boolean current=false] : iv_ruleJdlServiceGenerationSetting= ruleJdlServiceGenerationSetting EOF ;
    public final Boolean entryRuleJdlServiceGenerationSetting() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJdlServiceGenerationSetting = null;


        try {
            // PsiInternalJDL.g:1671:69: (iv_ruleJdlServiceGenerationSetting= ruleJdlServiceGenerationSetting EOF )
            // PsiInternalJDL.g:1672:2: iv_ruleJdlServiceGenerationSetting= ruleJdlServiceGenerationSetting EOF
            {
             markComposite(elementTypeProvider.getJdlServiceGenerationSettingElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlServiceGenerationSetting=ruleJdlServiceGenerationSetting();

            state._fsp--;

             current =iv_ruleJdlServiceGenerationSetting; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJdlServiceGenerationSetting"


    // $ANTLR start "ruleJdlServiceGenerationSetting"
    // PsiInternalJDL.g:1678:1: ruleJdlServiceGenerationSetting returns [Boolean current=false] : ( ( (lv_serviceGenerationSetting_0_0= 'service' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_serviceType_2_0= ruleJdlServiceType ) ) ) ;
    public final Boolean ruleJdlServiceGenerationSetting() throws RecognitionException {
        Boolean current = false;

        Token lv_serviceGenerationSetting_0_0=null;
        Boolean lv_includes_1_0 = null;

        Boolean lv_serviceType_2_0 = null;


        try {
            // PsiInternalJDL.g:1679:1: ( ( ( (lv_serviceGenerationSetting_0_0= 'service' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_serviceType_2_0= ruleJdlServiceType ) ) ) )
            // PsiInternalJDL.g:1680:2: ( ( (lv_serviceGenerationSetting_0_0= 'service' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_serviceType_2_0= ruleJdlServiceType ) ) )
            {
            // PsiInternalJDL.g:1680:2: ( ( (lv_serviceGenerationSetting_0_0= 'service' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_serviceType_2_0= ruleJdlServiceType ) ) )
            // PsiInternalJDL.g:1681:3: ( (lv_serviceGenerationSetting_0_0= 'service' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_serviceType_2_0= ruleJdlServiceType ) )
            {
            // PsiInternalJDL.g:1681:3: ( (lv_serviceGenerationSetting_0_0= 'service' ) )
            // PsiInternalJDL.g:1682:4: (lv_serviceGenerationSetting_0_0= 'service' )
            {
            // PsiInternalJDL.g:1682:4: (lv_serviceGenerationSetting_0_0= 'service' )
            // PsiInternalJDL.g:1683:5: lv_serviceGenerationSetting_0_0= 'service'
            {

            					markLeaf(elementTypeProvider.getJdlServiceGenerationSetting_ServiceGenerationSettingServiceKeyword_0_0ElementType());
            				
            lv_serviceGenerationSetting_0_0=(Token)match(input,32,FOLLOW_29); 

            					doneLeaf(lv_serviceGenerationSetting_0_0);
            				

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalJDL.g:1698:3: ( (lv_includes_1_0= ruleJdlEntityInclusion ) )
            // PsiInternalJDL.g:1699:4: (lv_includes_1_0= ruleJdlEntityInclusion )
            {
            // PsiInternalJDL.g:1699:4: (lv_includes_1_0= ruleJdlEntityInclusion )
            // PsiInternalJDL.g:1700:5: lv_includes_1_0= ruleJdlEntityInclusion
            {

            					markComposite(elementTypeProvider.getJdlServiceGenerationSetting_IncludesJdlEntityInclusionParserRuleCall_1_0ElementType());
            				
            pushFollow(FOLLOW_30);
            lv_includes_1_0=ruleJdlEntityInclusion();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalJDL.g:1713:3: ( (lv_serviceType_2_0= ruleJdlServiceType ) )
            // PsiInternalJDL.g:1714:4: (lv_serviceType_2_0= ruleJdlServiceType )
            {
            // PsiInternalJDL.g:1714:4: (lv_serviceType_2_0= ruleJdlServiceType )
            // PsiInternalJDL.g:1715:5: lv_serviceType_2_0= ruleJdlServiceType
            {

            					markComposite(elementTypeProvider.getJdlServiceGenerationSetting_ServiceTypeJdlServiceTypeEnumRuleCall_2_0ElementType());
            				
            pushFollow(FOLLOW_2);
            lv_serviceType_2_0=ruleJdlServiceType();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlServiceGenerationSetting"


    // $ANTLR start "entryRuleJdlMicroserviceGenerationSetting"
    // PsiInternalJDL.g:1732:1: entryRuleJdlMicroserviceGenerationSetting returns [Boolean current=false] : iv_ruleJdlMicroserviceGenerationSetting= ruleJdlMicroserviceGenerationSetting EOF ;
    public final Boolean entryRuleJdlMicroserviceGenerationSetting() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJdlMicroserviceGenerationSetting = null;


        try {
            // PsiInternalJDL.g:1732:74: (iv_ruleJdlMicroserviceGenerationSetting= ruleJdlMicroserviceGenerationSetting EOF )
            // PsiInternalJDL.g:1733:2: iv_ruleJdlMicroserviceGenerationSetting= ruleJdlMicroserviceGenerationSetting EOF
            {
             markComposite(elementTypeProvider.getJdlMicroserviceGenerationSettingElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlMicroserviceGenerationSetting=ruleJdlMicroserviceGenerationSetting();

            state._fsp--;

             current =iv_ruleJdlMicroserviceGenerationSetting; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJdlMicroserviceGenerationSetting"


    // $ANTLR start "ruleJdlMicroserviceGenerationSetting"
    // PsiInternalJDL.g:1739:1: ruleJdlMicroserviceGenerationSetting returns [Boolean current=false] : ( ( (lv_microserviceGenerationSetting_0_0= 'microservice' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_appname_2_0= RULE_ID ) ) ) ;
    public final Boolean ruleJdlMicroserviceGenerationSetting() throws RecognitionException {
        Boolean current = false;

        Token lv_microserviceGenerationSetting_0_0=null;
        Token lv_appname_2_0=null;
        Boolean lv_includes_1_0 = null;


        try {
            // PsiInternalJDL.g:1740:1: ( ( ( (lv_microserviceGenerationSetting_0_0= 'microservice' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_appname_2_0= RULE_ID ) ) ) )
            // PsiInternalJDL.g:1741:2: ( ( (lv_microserviceGenerationSetting_0_0= 'microservice' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_appname_2_0= RULE_ID ) ) )
            {
            // PsiInternalJDL.g:1741:2: ( ( (lv_microserviceGenerationSetting_0_0= 'microservice' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_appname_2_0= RULE_ID ) ) )
            // PsiInternalJDL.g:1742:3: ( (lv_microserviceGenerationSetting_0_0= 'microservice' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_appname_2_0= RULE_ID ) )
            {
            // PsiInternalJDL.g:1742:3: ( (lv_microserviceGenerationSetting_0_0= 'microservice' ) )
            // PsiInternalJDL.g:1743:4: (lv_microserviceGenerationSetting_0_0= 'microservice' )
            {
            // PsiInternalJDL.g:1743:4: (lv_microserviceGenerationSetting_0_0= 'microservice' )
            // PsiInternalJDL.g:1744:5: lv_microserviceGenerationSetting_0_0= 'microservice'
            {

            					markLeaf(elementTypeProvider.getJdlMicroserviceGenerationSetting_MicroserviceGenerationSettingMicroserviceKeyword_0_0ElementType());
            				
            lv_microserviceGenerationSetting_0_0=(Token)match(input,33,FOLLOW_29); 

            					doneLeaf(lv_microserviceGenerationSetting_0_0);
            				

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalJDL.g:1759:3: ( (lv_includes_1_0= ruleJdlEntityInclusion ) )
            // PsiInternalJDL.g:1760:4: (lv_includes_1_0= ruleJdlEntityInclusion )
            {
            // PsiInternalJDL.g:1760:4: (lv_includes_1_0= ruleJdlEntityInclusion )
            // PsiInternalJDL.g:1761:5: lv_includes_1_0= ruleJdlEntityInclusion
            {

            					markComposite(elementTypeProvider.getJdlMicroserviceGenerationSetting_IncludesJdlEntityInclusionParserRuleCall_1_0ElementType());
            				
            pushFollow(FOLLOW_4);
            lv_includes_1_0=ruleJdlEntityInclusion();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalJDL.g:1774:3: ( (lv_appname_2_0= RULE_ID ) )
            // PsiInternalJDL.g:1775:4: (lv_appname_2_0= RULE_ID )
            {
            // PsiInternalJDL.g:1775:4: (lv_appname_2_0= RULE_ID )
            // PsiInternalJDL.g:1776:5: lv_appname_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getJdlMicroserviceGenerationSetting_AppnameIDTerminalRuleCall_2_0ElementType());
            				
            lv_appname_2_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_appname_2_0);
            				

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlMicroserviceGenerationSetting"


    // $ANTLR start "entryRuleJdlSearchGenerationSetting"
    // PsiInternalJDL.g:1795:1: entryRuleJdlSearchGenerationSetting returns [Boolean current=false] : iv_ruleJdlSearchGenerationSetting= ruleJdlSearchGenerationSetting EOF ;
    public final Boolean entryRuleJdlSearchGenerationSetting() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJdlSearchGenerationSetting = null;


        try {
            // PsiInternalJDL.g:1795:68: (iv_ruleJdlSearchGenerationSetting= ruleJdlSearchGenerationSetting EOF )
            // PsiInternalJDL.g:1796:2: iv_ruleJdlSearchGenerationSetting= ruleJdlSearchGenerationSetting EOF
            {
             markComposite(elementTypeProvider.getJdlSearchGenerationSettingElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlSearchGenerationSetting=ruleJdlSearchGenerationSetting();

            state._fsp--;

             current =iv_ruleJdlSearchGenerationSetting; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJdlSearchGenerationSetting"


    // $ANTLR start "ruleJdlSearchGenerationSetting"
    // PsiInternalJDL.g:1802:1: ruleJdlSearchGenerationSetting returns [Boolean current=false] : ( ( (lv_searchGenerationSetting_0_0= 'search' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_service_2_0= RULE_ID ) ) ) ;
    public final Boolean ruleJdlSearchGenerationSetting() throws RecognitionException {
        Boolean current = false;

        Token lv_searchGenerationSetting_0_0=null;
        Token lv_service_2_0=null;
        Boolean lv_includes_1_0 = null;


        try {
            // PsiInternalJDL.g:1803:1: ( ( ( (lv_searchGenerationSetting_0_0= 'search' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_service_2_0= RULE_ID ) ) ) )
            // PsiInternalJDL.g:1804:2: ( ( (lv_searchGenerationSetting_0_0= 'search' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_service_2_0= RULE_ID ) ) )
            {
            // PsiInternalJDL.g:1804:2: ( ( (lv_searchGenerationSetting_0_0= 'search' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_service_2_0= RULE_ID ) ) )
            // PsiInternalJDL.g:1805:3: ( (lv_searchGenerationSetting_0_0= 'search' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_service_2_0= RULE_ID ) )
            {
            // PsiInternalJDL.g:1805:3: ( (lv_searchGenerationSetting_0_0= 'search' ) )
            // PsiInternalJDL.g:1806:4: (lv_searchGenerationSetting_0_0= 'search' )
            {
            // PsiInternalJDL.g:1806:4: (lv_searchGenerationSetting_0_0= 'search' )
            // PsiInternalJDL.g:1807:5: lv_searchGenerationSetting_0_0= 'search'
            {

            					markLeaf(elementTypeProvider.getJdlSearchGenerationSetting_SearchGenerationSettingSearchKeyword_0_0ElementType());
            				
            lv_searchGenerationSetting_0_0=(Token)match(input,34,FOLLOW_29); 

            					doneLeaf(lv_searchGenerationSetting_0_0);
            				

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalJDL.g:1822:3: ( (lv_includes_1_0= ruleJdlEntityInclusion ) )
            // PsiInternalJDL.g:1823:4: (lv_includes_1_0= ruleJdlEntityInclusion )
            {
            // PsiInternalJDL.g:1823:4: (lv_includes_1_0= ruleJdlEntityInclusion )
            // PsiInternalJDL.g:1824:5: lv_includes_1_0= ruleJdlEntityInclusion
            {

            					markComposite(elementTypeProvider.getJdlSearchGenerationSetting_IncludesJdlEntityInclusionParserRuleCall_1_0ElementType());
            				
            pushFollow(FOLLOW_4);
            lv_includes_1_0=ruleJdlEntityInclusion();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalJDL.g:1837:3: ( (lv_service_2_0= RULE_ID ) )
            // PsiInternalJDL.g:1838:4: (lv_service_2_0= RULE_ID )
            {
            // PsiInternalJDL.g:1838:4: (lv_service_2_0= RULE_ID )
            // PsiInternalJDL.g:1839:5: lv_service_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getJdlSearchGenerationSetting_ServiceIDTerminalRuleCall_2_0ElementType());
            				
            lv_service_2_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_service_2_0);
            				

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlSearchGenerationSetting"


    // $ANTLR start "entryRuleJdlDtoGenerationSetting"
    // PsiInternalJDL.g:1858:1: entryRuleJdlDtoGenerationSetting returns [Boolean current=false] : iv_ruleJdlDtoGenerationSetting= ruleJdlDtoGenerationSetting EOF ;
    public final Boolean entryRuleJdlDtoGenerationSetting() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJdlDtoGenerationSetting = null;


        try {
            // PsiInternalJDL.g:1858:65: (iv_ruleJdlDtoGenerationSetting= ruleJdlDtoGenerationSetting EOF )
            // PsiInternalJDL.g:1859:2: iv_ruleJdlDtoGenerationSetting= ruleJdlDtoGenerationSetting EOF
            {
             markComposite(elementTypeProvider.getJdlDtoGenerationSettingElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlDtoGenerationSetting=ruleJdlDtoGenerationSetting();

            state._fsp--;

             current =iv_ruleJdlDtoGenerationSetting; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJdlDtoGenerationSetting"


    // $ANTLR start "ruleJdlDtoGenerationSetting"
    // PsiInternalJDL.g:1865:1: ruleJdlDtoGenerationSetting returns [Boolean current=false] : ( ( (lv_dtoGenerationSetting_0_0= 'dto' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_dtoType_2_0= ruleJdlDtoType ) ) ) ;
    public final Boolean ruleJdlDtoGenerationSetting() throws RecognitionException {
        Boolean current = false;

        Token lv_dtoGenerationSetting_0_0=null;
        Boolean lv_includes_1_0 = null;

        Boolean lv_dtoType_2_0 = null;


        try {
            // PsiInternalJDL.g:1866:1: ( ( ( (lv_dtoGenerationSetting_0_0= 'dto' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_dtoType_2_0= ruleJdlDtoType ) ) ) )
            // PsiInternalJDL.g:1867:2: ( ( (lv_dtoGenerationSetting_0_0= 'dto' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_dtoType_2_0= ruleJdlDtoType ) ) )
            {
            // PsiInternalJDL.g:1867:2: ( ( (lv_dtoGenerationSetting_0_0= 'dto' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_dtoType_2_0= ruleJdlDtoType ) ) )
            // PsiInternalJDL.g:1868:3: ( (lv_dtoGenerationSetting_0_0= 'dto' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_dtoType_2_0= ruleJdlDtoType ) )
            {
            // PsiInternalJDL.g:1868:3: ( (lv_dtoGenerationSetting_0_0= 'dto' ) )
            // PsiInternalJDL.g:1869:4: (lv_dtoGenerationSetting_0_0= 'dto' )
            {
            // PsiInternalJDL.g:1869:4: (lv_dtoGenerationSetting_0_0= 'dto' )
            // PsiInternalJDL.g:1870:5: lv_dtoGenerationSetting_0_0= 'dto'
            {

            					markLeaf(elementTypeProvider.getJdlDtoGenerationSetting_DtoGenerationSettingDtoKeyword_0_0ElementType());
            				
            lv_dtoGenerationSetting_0_0=(Token)match(input,35,FOLLOW_29); 

            					doneLeaf(lv_dtoGenerationSetting_0_0);
            				

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalJDL.g:1885:3: ( (lv_includes_1_0= ruleJdlEntityInclusion ) )
            // PsiInternalJDL.g:1886:4: (lv_includes_1_0= ruleJdlEntityInclusion )
            {
            // PsiInternalJDL.g:1886:4: (lv_includes_1_0= ruleJdlEntityInclusion )
            // PsiInternalJDL.g:1887:5: lv_includes_1_0= ruleJdlEntityInclusion
            {

            					markComposite(elementTypeProvider.getJdlDtoGenerationSetting_IncludesJdlEntityInclusionParserRuleCall_1_0ElementType());
            				
            pushFollow(FOLLOW_31);
            lv_includes_1_0=ruleJdlEntityInclusion();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalJDL.g:1900:3: ( (lv_dtoType_2_0= ruleJdlDtoType ) )
            // PsiInternalJDL.g:1901:4: (lv_dtoType_2_0= ruleJdlDtoType )
            {
            // PsiInternalJDL.g:1901:4: (lv_dtoType_2_0= ruleJdlDtoType )
            // PsiInternalJDL.g:1902:5: lv_dtoType_2_0= ruleJdlDtoType
            {

            					markComposite(elementTypeProvider.getJdlDtoGenerationSetting_DtoTypeJdlDtoTypeEnumRuleCall_2_0ElementType());
            				
            pushFollow(FOLLOW_2);
            lv_dtoType_2_0=ruleJdlDtoType();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlDtoGenerationSetting"


    // $ANTLR start "entryRuleJdlPaginateGenerationSetting"
    // PsiInternalJDL.g:1919:1: entryRuleJdlPaginateGenerationSetting returns [Boolean current=false] : iv_ruleJdlPaginateGenerationSetting= ruleJdlPaginateGenerationSetting EOF ;
    public final Boolean entryRuleJdlPaginateGenerationSetting() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJdlPaginateGenerationSetting = null;


        try {
            // PsiInternalJDL.g:1919:70: (iv_ruleJdlPaginateGenerationSetting= ruleJdlPaginateGenerationSetting EOF )
            // PsiInternalJDL.g:1920:2: iv_ruleJdlPaginateGenerationSetting= ruleJdlPaginateGenerationSetting EOF
            {
             markComposite(elementTypeProvider.getJdlPaginateGenerationSettingElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlPaginateGenerationSetting=ruleJdlPaginateGenerationSetting();

            state._fsp--;

             current =iv_ruleJdlPaginateGenerationSetting; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJdlPaginateGenerationSetting"


    // $ANTLR start "ruleJdlPaginateGenerationSetting"
    // PsiInternalJDL.g:1926:1: ruleJdlPaginateGenerationSetting returns [Boolean current=false] : ( ( (lv_paginateGenerationSetting_0_0= 'paginate' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_paginateType_2_0= ruleJdlPaginateType ) ) ) ;
    public final Boolean ruleJdlPaginateGenerationSetting() throws RecognitionException {
        Boolean current = false;

        Token lv_paginateGenerationSetting_0_0=null;
        Boolean lv_includes_1_0 = null;

        Boolean lv_paginateType_2_0 = null;


        try {
            // PsiInternalJDL.g:1927:1: ( ( ( (lv_paginateGenerationSetting_0_0= 'paginate' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_paginateType_2_0= ruleJdlPaginateType ) ) ) )
            // PsiInternalJDL.g:1928:2: ( ( (lv_paginateGenerationSetting_0_0= 'paginate' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_paginateType_2_0= ruleJdlPaginateType ) ) )
            {
            // PsiInternalJDL.g:1928:2: ( ( (lv_paginateGenerationSetting_0_0= 'paginate' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_paginateType_2_0= ruleJdlPaginateType ) ) )
            // PsiInternalJDL.g:1929:3: ( (lv_paginateGenerationSetting_0_0= 'paginate' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_paginateType_2_0= ruleJdlPaginateType ) )
            {
            // PsiInternalJDL.g:1929:3: ( (lv_paginateGenerationSetting_0_0= 'paginate' ) )
            // PsiInternalJDL.g:1930:4: (lv_paginateGenerationSetting_0_0= 'paginate' )
            {
            // PsiInternalJDL.g:1930:4: (lv_paginateGenerationSetting_0_0= 'paginate' )
            // PsiInternalJDL.g:1931:5: lv_paginateGenerationSetting_0_0= 'paginate'
            {

            					markLeaf(elementTypeProvider.getJdlPaginateGenerationSetting_PaginateGenerationSettingPaginateKeyword_0_0ElementType());
            				
            lv_paginateGenerationSetting_0_0=(Token)match(input,36,FOLLOW_29); 

            					doneLeaf(lv_paginateGenerationSetting_0_0);
            				

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalJDL.g:1946:3: ( (lv_includes_1_0= ruleJdlEntityInclusion ) )
            // PsiInternalJDL.g:1947:4: (lv_includes_1_0= ruleJdlEntityInclusion )
            {
            // PsiInternalJDL.g:1947:4: (lv_includes_1_0= ruleJdlEntityInclusion )
            // PsiInternalJDL.g:1948:5: lv_includes_1_0= ruleJdlEntityInclusion
            {

            					markComposite(elementTypeProvider.getJdlPaginateGenerationSetting_IncludesJdlEntityInclusionParserRuleCall_1_0ElementType());
            				
            pushFollow(FOLLOW_32);
            lv_includes_1_0=ruleJdlEntityInclusion();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalJDL.g:1961:3: ( (lv_paginateType_2_0= ruleJdlPaginateType ) )
            // PsiInternalJDL.g:1962:4: (lv_paginateType_2_0= ruleJdlPaginateType )
            {
            // PsiInternalJDL.g:1962:4: (lv_paginateType_2_0= ruleJdlPaginateType )
            // PsiInternalJDL.g:1963:5: lv_paginateType_2_0= ruleJdlPaginateType
            {

            					markComposite(elementTypeProvider.getJdlPaginateGenerationSetting_PaginateTypeJdlPaginateTypeParserRuleCall_2_0ElementType());
            				
            pushFollow(FOLLOW_2);
            lv_paginateType_2_0=ruleJdlPaginateType();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlPaginateGenerationSetting"


    // $ANTLR start "entryRuleJdlAngularSuffixGenerationSetting"
    // PsiInternalJDL.g:1980:1: entryRuleJdlAngularSuffixGenerationSetting returns [Boolean current=false] : iv_ruleJdlAngularSuffixGenerationSetting= ruleJdlAngularSuffixGenerationSetting EOF ;
    public final Boolean entryRuleJdlAngularSuffixGenerationSetting() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJdlAngularSuffixGenerationSetting = null;


        try {
            // PsiInternalJDL.g:1980:75: (iv_ruleJdlAngularSuffixGenerationSetting= ruleJdlAngularSuffixGenerationSetting EOF )
            // PsiInternalJDL.g:1981:2: iv_ruleJdlAngularSuffixGenerationSetting= ruleJdlAngularSuffixGenerationSetting EOF
            {
             markComposite(elementTypeProvider.getJdlAngularSuffixGenerationSettingElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlAngularSuffixGenerationSetting=ruleJdlAngularSuffixGenerationSetting();

            state._fsp--;

             current =iv_ruleJdlAngularSuffixGenerationSetting; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJdlAngularSuffixGenerationSetting"


    // $ANTLR start "ruleJdlAngularSuffixGenerationSetting"
    // PsiInternalJDL.g:1987:1: ruleJdlAngularSuffixGenerationSetting returns [Boolean current=false] : ( ( (lv_angularSuffixGenerationSetting_0_0= 'angularSuffix' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_id_2_0= RULE_ID ) ) ) ;
    public final Boolean ruleJdlAngularSuffixGenerationSetting() throws RecognitionException {
        Boolean current = false;

        Token lv_angularSuffixGenerationSetting_0_0=null;
        Token lv_id_2_0=null;
        Boolean lv_includes_1_0 = null;


        try {
            // PsiInternalJDL.g:1988:1: ( ( ( (lv_angularSuffixGenerationSetting_0_0= 'angularSuffix' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_id_2_0= RULE_ID ) ) ) )
            // PsiInternalJDL.g:1989:2: ( ( (lv_angularSuffixGenerationSetting_0_0= 'angularSuffix' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_id_2_0= RULE_ID ) ) )
            {
            // PsiInternalJDL.g:1989:2: ( ( (lv_angularSuffixGenerationSetting_0_0= 'angularSuffix' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_id_2_0= RULE_ID ) ) )
            // PsiInternalJDL.g:1990:3: ( (lv_angularSuffixGenerationSetting_0_0= 'angularSuffix' ) ) ( (lv_includes_1_0= ruleJdlEntityInclusion ) ) ( (lv_id_2_0= RULE_ID ) )
            {
            // PsiInternalJDL.g:1990:3: ( (lv_angularSuffixGenerationSetting_0_0= 'angularSuffix' ) )
            // PsiInternalJDL.g:1991:4: (lv_angularSuffixGenerationSetting_0_0= 'angularSuffix' )
            {
            // PsiInternalJDL.g:1991:4: (lv_angularSuffixGenerationSetting_0_0= 'angularSuffix' )
            // PsiInternalJDL.g:1992:5: lv_angularSuffixGenerationSetting_0_0= 'angularSuffix'
            {

            					markLeaf(elementTypeProvider.getJdlAngularSuffixGenerationSetting_AngularSuffixGenerationSettingAngularSuffixKeyword_0_0ElementType());
            				
            lv_angularSuffixGenerationSetting_0_0=(Token)match(input,37,FOLLOW_29); 

            					doneLeaf(lv_angularSuffixGenerationSetting_0_0);
            				

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalJDL.g:2007:3: ( (lv_includes_1_0= ruleJdlEntityInclusion ) )
            // PsiInternalJDL.g:2008:4: (lv_includes_1_0= ruleJdlEntityInclusion )
            {
            // PsiInternalJDL.g:2008:4: (lv_includes_1_0= ruleJdlEntityInclusion )
            // PsiInternalJDL.g:2009:5: lv_includes_1_0= ruleJdlEntityInclusion
            {

            					markComposite(elementTypeProvider.getJdlAngularSuffixGenerationSetting_IncludesJdlEntityInclusionParserRuleCall_1_0ElementType());
            				
            pushFollow(FOLLOW_4);
            lv_includes_1_0=ruleJdlEntityInclusion();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalJDL.g:2022:3: ( (lv_id_2_0= RULE_ID ) )
            // PsiInternalJDL.g:2023:4: (lv_id_2_0= RULE_ID )
            {
            // PsiInternalJDL.g:2023:4: (lv_id_2_0= RULE_ID )
            // PsiInternalJDL.g:2024:5: lv_id_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getJdlAngularSuffixGenerationSetting_IdIDTerminalRuleCall_2_0ElementType());
            				
            lv_id_2_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_id_2_0);
            				

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlAngularSuffixGenerationSetting"


    // $ANTLR start "entryRuleJdlEntityInclusion"
    // PsiInternalJDL.g:2043:1: entryRuleJdlEntityInclusion returns [Boolean current=false] : iv_ruleJdlEntityInclusion= ruleJdlEntityInclusion EOF ;
    public final Boolean entryRuleJdlEntityInclusion() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJdlEntityInclusion = null;


        try {
            // PsiInternalJDL.g:2043:60: (iv_ruleJdlEntityInclusion= ruleJdlEntityInclusion EOF )
            // PsiInternalJDL.g:2044:2: iv_ruleJdlEntityInclusion= ruleJdlEntityInclusion EOF
            {
             markComposite(elementTypeProvider.getJdlEntityInclusionElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlEntityInclusion=ruleJdlEntityInclusion();

            state._fsp--;

             current =iv_ruleJdlEntityInclusion; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJdlEntityInclusion"


    // $ANTLR start "ruleJdlEntityInclusion"
    // PsiInternalJDL.g:2050:1: ruleJdlEntityInclusion returns [Boolean current=false] : ( ( ( (lv_predicate_0_0= ruleJdlWildcardPredicate ) ) | ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* ) ) otherlv_4= 'with' ) ;
    public final Boolean ruleJdlEntityInclusion() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Boolean lv_predicate_0_0 = null;


        try {
            // PsiInternalJDL.g:2051:1: ( ( ( ( (lv_predicate_0_0= ruleJdlWildcardPredicate ) ) | ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* ) ) otherlv_4= 'with' ) )
            // PsiInternalJDL.g:2052:2: ( ( ( (lv_predicate_0_0= ruleJdlWildcardPredicate ) ) | ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* ) ) otherlv_4= 'with' )
            {
            // PsiInternalJDL.g:2052:2: ( ( ( (lv_predicate_0_0= ruleJdlWildcardPredicate ) ) | ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* ) ) otherlv_4= 'with' )
            // PsiInternalJDL.g:2053:3: ( ( (lv_predicate_0_0= ruleJdlWildcardPredicate ) ) | ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* ) ) otherlv_4= 'with'
            {
            // PsiInternalJDL.g:2053:3: ( ( (lv_predicate_0_0= ruleJdlWildcardPredicate ) ) | ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* ) )
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
                    // PsiInternalJDL.g:2054:4: ( (lv_predicate_0_0= ruleJdlWildcardPredicate ) )
                    {
                    // PsiInternalJDL.g:2054:4: ( (lv_predicate_0_0= ruleJdlWildcardPredicate ) )
                    // PsiInternalJDL.g:2055:5: (lv_predicate_0_0= ruleJdlWildcardPredicate )
                    {
                    // PsiInternalJDL.g:2055:5: (lv_predicate_0_0= ruleJdlWildcardPredicate )
                    // PsiInternalJDL.g:2056:6: lv_predicate_0_0= ruleJdlWildcardPredicate
                    {

                    						markComposite(elementTypeProvider.getJdlEntityInclusion_PredicateJdlWildcardPredicateParserRuleCall_0_0_0ElementType());
                    					
                    pushFollow(FOLLOW_33);
                    lv_predicate_0_0=ruleJdlWildcardPredicate();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalJDL.g:2070:4: ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )
                    {
                    // PsiInternalJDL.g:2070:4: ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )
                    // PsiInternalJDL.g:2071:5: ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
                    {
                    // PsiInternalJDL.g:2071:5: ( (otherlv_1= RULE_ID ) )
                    // PsiInternalJDL.g:2072:6: (otherlv_1= RULE_ID )
                    {
                    // PsiInternalJDL.g:2072:6: (otherlv_1= RULE_ID )
                    // PsiInternalJDL.g:2073:7: otherlv_1= RULE_ID
                    {

                    							if (!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							markLeaf(elementTypeProvider.getJdlEntityInclusion_EntitiesJdlEntityCrossReference_0_1_0_0ElementType());
                    						
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_34); 

                    							doneLeaf(otherlv_1);
                    						

                    }


                    }

                    // PsiInternalJDL.g:2088:5: (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==13) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // PsiInternalJDL.g:2089:6: otherlv_2= ',' ( (otherlv_3= RULE_ID ) )
                    	    {

                    	    						markLeaf(elementTypeProvider.getJdlEntityInclusion_CommaKeyword_0_1_1_0ElementType());
                    	    					
                    	    otherlv_2=(Token)match(input,13,FOLLOW_4); 

                    	    						doneLeaf(otherlv_2);
                    	    					
                    	    // PsiInternalJDL.g:2096:6: ( (otherlv_3= RULE_ID ) )
                    	    // PsiInternalJDL.g:2097:7: (otherlv_3= RULE_ID )
                    	    {
                    	    // PsiInternalJDL.g:2097:7: (otherlv_3= RULE_ID )
                    	    // PsiInternalJDL.g:2098:8: otherlv_3= RULE_ID
                    	    {

                    	    								if (!current) {
                    	    									associateWithSemanticElement();
                    	    									current = true;
                    	    								}
                    	    							

                    	    								markLeaf(elementTypeProvider.getJdlEntityInclusion_EntitiesJdlEntityCrossReference_0_1_1_1_0ElementType());
                    	    							
                    	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_34); 

                    	    								doneLeaf(otherlv_3);
                    	    							

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


            			markLeaf(elementTypeProvider.getJdlEntityInclusion_WithKeyword_1ElementType());
            		
            otherlv_4=(Token)match(input,38,FOLLOW_2); 

            			doneLeaf(otherlv_4);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlEntityInclusion"


    // $ANTLR start "entryRuleJdlEntityExclusion"
    // PsiInternalJDL.g:2127:1: entryRuleJdlEntityExclusion returns [Boolean current=false] : iv_ruleJdlEntityExclusion= ruleJdlEntityExclusion EOF ;
    public final Boolean entryRuleJdlEntityExclusion() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJdlEntityExclusion = null;


        try {
            // PsiInternalJDL.g:2127:60: (iv_ruleJdlEntityExclusion= ruleJdlEntityExclusion EOF )
            // PsiInternalJDL.g:2128:2: iv_ruleJdlEntityExclusion= ruleJdlEntityExclusion EOF
            {
             markComposite(elementTypeProvider.getJdlEntityExclusionElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlEntityExclusion=ruleJdlEntityExclusion();

            state._fsp--;

             current =iv_ruleJdlEntityExclusion; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJdlEntityExclusion"


    // $ANTLR start "ruleJdlEntityExclusion"
    // PsiInternalJDL.g:2134:1: ruleJdlEntityExclusion returns [Boolean current=false] : (otherlv_0= 'except' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* ) ;
    public final Boolean ruleJdlEntityExclusion() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

        try {
            // PsiInternalJDL.g:2135:1: ( (otherlv_0= 'except' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* ) )
            // PsiInternalJDL.g:2136:2: (otherlv_0= 'except' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )
            {
            // PsiInternalJDL.g:2136:2: (otherlv_0= 'except' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )
            // PsiInternalJDL.g:2137:3: otherlv_0= 'except' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
            {

            			markLeaf(elementTypeProvider.getJdlEntityExclusion_ExceptKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,39,FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalJDL.g:2144:3: ( (otherlv_1= RULE_ID ) )
            // PsiInternalJDL.g:2145:4: (otherlv_1= RULE_ID )
            {
            // PsiInternalJDL.g:2145:4: (otherlv_1= RULE_ID )
            // PsiInternalJDL.g:2146:5: otherlv_1= RULE_ID
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					markLeaf(elementTypeProvider.getJdlEntityExclusion_EntitiesJdlEntityCrossReference_1_0ElementType());
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_35); 

            					doneLeaf(otherlv_1);
            				

            }


            }

            // PsiInternalJDL.g:2161:3: (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==13) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // PsiInternalJDL.g:2162:4: otherlv_2= ',' ( (otherlv_3= RULE_ID ) )
            	    {

            	    				markLeaf(elementTypeProvider.getJdlEntityExclusion_CommaKeyword_2_0ElementType());
            	    			
            	    otherlv_2=(Token)match(input,13,FOLLOW_4); 

            	    				doneLeaf(otherlv_2);
            	    			
            	    // PsiInternalJDL.g:2169:4: ( (otherlv_3= RULE_ID ) )
            	    // PsiInternalJDL.g:2170:5: (otherlv_3= RULE_ID )
            	    {
            	    // PsiInternalJDL.g:2170:5: (otherlv_3= RULE_ID )
            	    // PsiInternalJDL.g:2171:6: otherlv_3= RULE_ID
            	    {

            	    						if (!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

            	    						markLeaf(elementTypeProvider.getJdlEntityExclusion_EntitiesJdlEntityCrossReference_2_1_0ElementType());
            	    					
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_35); 

            	    						doneLeaf(otherlv_3);
            	    					

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlEntityExclusion"


    // $ANTLR start "entryRuleJdlWildcardPredicate"
    // PsiInternalJDL.g:2191:1: entryRuleJdlWildcardPredicate returns [Boolean current=false] : iv_ruleJdlWildcardPredicate= ruleJdlWildcardPredicate EOF ;
    public final Boolean entryRuleJdlWildcardPredicate() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJdlWildcardPredicate = null;


        try {
            // PsiInternalJDL.g:2191:62: (iv_ruleJdlWildcardPredicate= ruleJdlWildcardPredicate EOF )
            // PsiInternalJDL.g:2192:2: iv_ruleJdlWildcardPredicate= ruleJdlWildcardPredicate EOF
            {
             markComposite(elementTypeProvider.getJdlWildcardPredicateElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlWildcardPredicate=ruleJdlWildcardPredicate();

            state._fsp--;

             current =iv_ruleJdlWildcardPredicate; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJdlWildcardPredicate"


    // $ANTLR start "ruleJdlWildcardPredicate"
    // PsiInternalJDL.g:2198:1: ruleJdlWildcardPredicate returns [Boolean current=false] : ( ( (lv_wildcard_0_0= '*' ) ) | ( (lv_all_1_0= 'all' ) ) ) ;
    public final Boolean ruleJdlWildcardPredicate() throws RecognitionException {
        Boolean current = false;

        Token lv_wildcard_0_0=null;
        Token lv_all_1_0=null;

        try {
            // PsiInternalJDL.g:2199:1: ( ( ( (lv_wildcard_0_0= '*' ) ) | ( (lv_all_1_0= 'all' ) ) ) )
            // PsiInternalJDL.g:2200:2: ( ( (lv_wildcard_0_0= '*' ) ) | ( (lv_all_1_0= 'all' ) ) )
            {
            // PsiInternalJDL.g:2200:2: ( ( (lv_wildcard_0_0= '*' ) ) | ( (lv_all_1_0= 'all' ) ) )
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
                    // PsiInternalJDL.g:2201:3: ( (lv_wildcard_0_0= '*' ) )
                    {
                    // PsiInternalJDL.g:2201:3: ( (lv_wildcard_0_0= '*' ) )
                    // PsiInternalJDL.g:2202:4: (lv_wildcard_0_0= '*' )
                    {
                    // PsiInternalJDL.g:2202:4: (lv_wildcard_0_0= '*' )
                    // PsiInternalJDL.g:2203:5: lv_wildcard_0_0= '*'
                    {

                    					markLeaf(elementTypeProvider.getJdlWildcardPredicate_WildcardAsteriskKeyword_0_0ElementType());
                    				
                    lv_wildcard_0_0=(Token)match(input,40,FOLLOW_2); 

                    					doneLeaf(lv_wildcard_0_0);
                    				

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalJDL.g:2219:3: ( (lv_all_1_0= 'all' ) )
                    {
                    // PsiInternalJDL.g:2219:3: ( (lv_all_1_0= 'all' ) )
                    // PsiInternalJDL.g:2220:4: (lv_all_1_0= 'all' )
                    {
                    // PsiInternalJDL.g:2220:4: (lv_all_1_0= 'all' )
                    // PsiInternalJDL.g:2221:5: lv_all_1_0= 'all'
                    {

                    					markLeaf(elementTypeProvider.getJdlWildcardPredicate_AllAllKeyword_1_0ElementType());
                    				
                    lv_all_1_0=(Token)match(input,41,FOLLOW_2); 

                    					doneLeaf(lv_all_1_0);
                    				

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlWildcardPredicate"


    // $ANTLR start "entryRuleJdlPaginateType"
    // PsiInternalJDL.g:2240:1: entryRuleJdlPaginateType returns [Boolean current=false] : iv_ruleJdlPaginateType= ruleJdlPaginateType EOF ;
    public final Boolean entryRuleJdlPaginateType() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJdlPaginateType = null;


        try {
            // PsiInternalJDL.g:2240:57: (iv_ruleJdlPaginateType= ruleJdlPaginateType EOF )
            // PsiInternalJDL.g:2241:2: iv_ruleJdlPaginateType= ruleJdlPaginateType EOF
            {
             markComposite(elementTypeProvider.getJdlPaginateTypeElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleJdlPaginateType=ruleJdlPaginateType();

            state._fsp--;

             current =iv_ruleJdlPaginateType; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJdlPaginateType"


    // $ANTLR start "ruleJdlPaginateType"
    // PsiInternalJDL.g:2247:1: ruleJdlPaginateType returns [Boolean current=false] : ( ( ( (lv_pagination_0_1= 'pager' | lv_pagination_0_2= 'pagination' ) ) ) | ( (lv_infiniteScroll_1_0= 'infinite-scroll' ) ) ) ;
    public final Boolean ruleJdlPaginateType() throws RecognitionException {
        Boolean current = false;

        Token lv_pagination_0_1=null;
        Token lv_pagination_0_2=null;
        Token lv_infiniteScroll_1_0=null;

        try {
            // PsiInternalJDL.g:2248:1: ( ( ( ( (lv_pagination_0_1= 'pager' | lv_pagination_0_2= 'pagination' ) ) ) | ( (lv_infiniteScroll_1_0= 'infinite-scroll' ) ) ) )
            // PsiInternalJDL.g:2249:2: ( ( ( (lv_pagination_0_1= 'pager' | lv_pagination_0_2= 'pagination' ) ) ) | ( (lv_infiniteScroll_1_0= 'infinite-scroll' ) ) )
            {
            // PsiInternalJDL.g:2249:2: ( ( ( (lv_pagination_0_1= 'pager' | lv_pagination_0_2= 'pagination' ) ) ) | ( (lv_infiniteScroll_1_0= 'infinite-scroll' ) ) )
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
                    // PsiInternalJDL.g:2250:3: ( ( (lv_pagination_0_1= 'pager' | lv_pagination_0_2= 'pagination' ) ) )
                    {
                    // PsiInternalJDL.g:2250:3: ( ( (lv_pagination_0_1= 'pager' | lv_pagination_0_2= 'pagination' ) ) )
                    // PsiInternalJDL.g:2251:4: ( (lv_pagination_0_1= 'pager' | lv_pagination_0_2= 'pagination' ) )
                    {
                    // PsiInternalJDL.g:2251:4: ( (lv_pagination_0_1= 'pager' | lv_pagination_0_2= 'pagination' ) )
                    // PsiInternalJDL.g:2252:5: (lv_pagination_0_1= 'pager' | lv_pagination_0_2= 'pagination' )
                    {
                    // PsiInternalJDL.g:2252:5: (lv_pagination_0_1= 'pager' | lv_pagination_0_2= 'pagination' )
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
                            // PsiInternalJDL.g:2253:6: lv_pagination_0_1= 'pager'
                            {

                            						markLeaf(elementTypeProvider.getJdlPaginateType_PaginationPagerKeyword_0_0_0ElementType());
                            					
                            lv_pagination_0_1=(Token)match(input,42,FOLLOW_2); 

                            						doneLeaf(lv_pagination_0_1);
                            					

                            						if (!current) {
                            							associateWithSemanticElement();
                            							current = true;
                            						}
                            					

                            }
                            break;
                        case 2 :
                            // PsiInternalJDL.g:2267:6: lv_pagination_0_2= 'pagination'
                            {

                            						markLeaf(elementTypeProvider.getJdlPaginateType_PaginationPaginationKeyword_0_0_1ElementType());
                            					
                            lv_pagination_0_2=(Token)match(input,43,FOLLOW_2); 

                            						doneLeaf(lv_pagination_0_2);
                            					

                            						if (!current) {
                            							associateWithSemanticElement();
                            							current = true;
                            						}
                            					

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalJDL.g:2284:3: ( (lv_infiniteScroll_1_0= 'infinite-scroll' ) )
                    {
                    // PsiInternalJDL.g:2284:3: ( (lv_infiniteScroll_1_0= 'infinite-scroll' ) )
                    // PsiInternalJDL.g:2285:4: (lv_infiniteScroll_1_0= 'infinite-scroll' )
                    {
                    // PsiInternalJDL.g:2285:4: (lv_infiniteScroll_1_0= 'infinite-scroll' )
                    // PsiInternalJDL.g:2286:5: lv_infiniteScroll_1_0= 'infinite-scroll'
                    {

                    					markLeaf(elementTypeProvider.getJdlPaginateType_InfiniteScrollInfiniteScrollKeyword_1_0ElementType());
                    				
                    lv_infiniteScroll_1_0=(Token)match(input,44,FOLLOW_2); 

                    					doneLeaf(lv_infiniteScroll_1_0);
                    				

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlPaginateType"


    // $ANTLR start "ruleJdlNumericFieldType"
    // PsiInternalJDL.g:2305:1: ruleJdlNumericFieldType returns [Boolean current=false] : ( (enumLiteral_0= 'Integer' ) | (enumLiteral_1= 'Long' ) | (enumLiteral_2= 'BigDecimal' ) | (enumLiteral_3= 'Float' ) | (enumLiteral_4= 'Double' ) ) ;
    public final Boolean ruleJdlNumericFieldType() throws RecognitionException {
        Boolean current = false;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;

        try {
            // PsiInternalJDL.g:2306:1: ( ( (enumLiteral_0= 'Integer' ) | (enumLiteral_1= 'Long' ) | (enumLiteral_2= 'BigDecimal' ) | (enumLiteral_3= 'Float' ) | (enumLiteral_4= 'Double' ) ) )
            // PsiInternalJDL.g:2307:2: ( (enumLiteral_0= 'Integer' ) | (enumLiteral_1= 'Long' ) | (enumLiteral_2= 'BigDecimal' ) | (enumLiteral_3= 'Float' ) | (enumLiteral_4= 'Double' ) )
            {
            // PsiInternalJDL.g:2307:2: ( (enumLiteral_0= 'Integer' ) | (enumLiteral_1= 'Long' ) | (enumLiteral_2= 'BigDecimal' ) | (enumLiteral_3= 'Float' ) | (enumLiteral_4= 'Double' ) )
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
                    // PsiInternalJDL.g:2308:3: (enumLiteral_0= 'Integer' )
                    {
                    // PsiInternalJDL.g:2308:3: (enumLiteral_0= 'Integer' )
                    // PsiInternalJDL.g:2309:4: enumLiteral_0= 'Integer'
                    {

                    				markLeaf(elementTypeProvider.getJdlNumericFieldType_IntegerEnumLiteralDeclaration_0ElementType());
                    			
                    enumLiteral_0=(Token)match(input,45,FOLLOW_2); 

                    				doneLeaf(enumLiteral_0);
                    			

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalJDL.g:2318:3: (enumLiteral_1= 'Long' )
                    {
                    // PsiInternalJDL.g:2318:3: (enumLiteral_1= 'Long' )
                    // PsiInternalJDL.g:2319:4: enumLiteral_1= 'Long'
                    {

                    				markLeaf(elementTypeProvider.getJdlNumericFieldType_LongEnumLiteralDeclaration_1ElementType());
                    			
                    enumLiteral_1=(Token)match(input,46,FOLLOW_2); 

                    				doneLeaf(enumLiteral_1);
                    			

                    }


                    }
                    break;
                case 3 :
                    // PsiInternalJDL.g:2328:3: (enumLiteral_2= 'BigDecimal' )
                    {
                    // PsiInternalJDL.g:2328:3: (enumLiteral_2= 'BigDecimal' )
                    // PsiInternalJDL.g:2329:4: enumLiteral_2= 'BigDecimal'
                    {

                    				markLeaf(elementTypeProvider.getJdlNumericFieldType_BigDecimalEnumLiteralDeclaration_2ElementType());
                    			
                    enumLiteral_2=(Token)match(input,47,FOLLOW_2); 

                    				doneLeaf(enumLiteral_2);
                    			

                    }


                    }
                    break;
                case 4 :
                    // PsiInternalJDL.g:2338:3: (enumLiteral_3= 'Float' )
                    {
                    // PsiInternalJDL.g:2338:3: (enumLiteral_3= 'Float' )
                    // PsiInternalJDL.g:2339:4: enumLiteral_3= 'Float'
                    {

                    				markLeaf(elementTypeProvider.getJdlNumericFieldType_FloatEnumLiteralDeclaration_3ElementType());
                    			
                    enumLiteral_3=(Token)match(input,48,FOLLOW_2); 

                    				doneLeaf(enumLiteral_3);
                    			

                    }


                    }
                    break;
                case 5 :
                    // PsiInternalJDL.g:2348:3: (enumLiteral_4= 'Double' )
                    {
                    // PsiInternalJDL.g:2348:3: (enumLiteral_4= 'Double' )
                    // PsiInternalJDL.g:2349:4: enumLiteral_4= 'Double'
                    {

                    				markLeaf(elementTypeProvider.getJdlNumericFieldType_DoubleEnumLiteralDeclaration_4ElementType());
                    			
                    enumLiteral_4=(Token)match(input,49,FOLLOW_2); 

                    				doneLeaf(enumLiteral_4);
                    			

                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlNumericFieldType"


    // $ANTLR start "ruleJdlBlobFieldType"
    // PsiInternalJDL.g:2361:1: ruleJdlBlobFieldType returns [Boolean current=false] : ( (enumLiteral_0= 'Blob' ) | (enumLiteral_1= 'AnyBlob' ) | (enumLiteral_2= 'ImageBlob' ) ) ;
    public final Boolean ruleJdlBlobFieldType() throws RecognitionException {
        Boolean current = false;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

        try {
            // PsiInternalJDL.g:2362:1: ( ( (enumLiteral_0= 'Blob' ) | (enumLiteral_1= 'AnyBlob' ) | (enumLiteral_2= 'ImageBlob' ) ) )
            // PsiInternalJDL.g:2363:2: ( (enumLiteral_0= 'Blob' ) | (enumLiteral_1= 'AnyBlob' ) | (enumLiteral_2= 'ImageBlob' ) )
            {
            // PsiInternalJDL.g:2363:2: ( (enumLiteral_0= 'Blob' ) | (enumLiteral_1= 'AnyBlob' ) | (enumLiteral_2= 'ImageBlob' ) )
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
                    // PsiInternalJDL.g:2364:3: (enumLiteral_0= 'Blob' )
                    {
                    // PsiInternalJDL.g:2364:3: (enumLiteral_0= 'Blob' )
                    // PsiInternalJDL.g:2365:4: enumLiteral_0= 'Blob'
                    {

                    				markLeaf(elementTypeProvider.getJdlBlobFieldType_BlobEnumLiteralDeclaration_0ElementType());
                    			
                    enumLiteral_0=(Token)match(input,50,FOLLOW_2); 

                    				doneLeaf(enumLiteral_0);
                    			

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalJDL.g:2374:3: (enumLiteral_1= 'AnyBlob' )
                    {
                    // PsiInternalJDL.g:2374:3: (enumLiteral_1= 'AnyBlob' )
                    // PsiInternalJDL.g:2375:4: enumLiteral_1= 'AnyBlob'
                    {

                    				markLeaf(elementTypeProvider.getJdlBlobFieldType_AnyBlobEnumLiteralDeclaration_1ElementType());
                    			
                    enumLiteral_1=(Token)match(input,51,FOLLOW_2); 

                    				doneLeaf(enumLiteral_1);
                    			

                    }


                    }
                    break;
                case 3 :
                    // PsiInternalJDL.g:2384:3: (enumLiteral_2= 'ImageBlob' )
                    {
                    // PsiInternalJDL.g:2384:3: (enumLiteral_2= 'ImageBlob' )
                    // PsiInternalJDL.g:2385:4: enumLiteral_2= 'ImageBlob'
                    {

                    				markLeaf(elementTypeProvider.getJdlBlobFieldType_ImageBlobEnumLiteralDeclaration_2ElementType());
                    			
                    enumLiteral_2=(Token)match(input,52,FOLLOW_2); 

                    				doneLeaf(enumLiteral_2);
                    			

                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlBlobFieldType"


    // $ANTLR start "ruleJdlCardinality"
    // PsiInternalJDL.g:2397:1: ruleJdlCardinality returns [Boolean current=false] : ( (enumLiteral_0= 'OneToMany' ) | (enumLiteral_1= 'ManyToOne' ) | (enumLiteral_2= 'OneToOne' ) | (enumLiteral_3= 'ManyToMany' ) ) ;
    public final Boolean ruleJdlCardinality() throws RecognitionException {
        Boolean current = false;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

        try {
            // PsiInternalJDL.g:2398:1: ( ( (enumLiteral_0= 'OneToMany' ) | (enumLiteral_1= 'ManyToOne' ) | (enumLiteral_2= 'OneToOne' ) | (enumLiteral_3= 'ManyToMany' ) ) )
            // PsiInternalJDL.g:2399:2: ( (enumLiteral_0= 'OneToMany' ) | (enumLiteral_1= 'ManyToOne' ) | (enumLiteral_2= 'OneToOne' ) | (enumLiteral_3= 'ManyToMany' ) )
            {
            // PsiInternalJDL.g:2399:2: ( (enumLiteral_0= 'OneToMany' ) | (enumLiteral_1= 'ManyToOne' ) | (enumLiteral_2= 'OneToOne' ) | (enumLiteral_3= 'ManyToMany' ) )
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
                    // PsiInternalJDL.g:2400:3: (enumLiteral_0= 'OneToMany' )
                    {
                    // PsiInternalJDL.g:2400:3: (enumLiteral_0= 'OneToMany' )
                    // PsiInternalJDL.g:2401:4: enumLiteral_0= 'OneToMany'
                    {

                    				markLeaf(elementTypeProvider.getJdlCardinality_OneToManyEnumLiteralDeclaration_0ElementType());
                    			
                    enumLiteral_0=(Token)match(input,53,FOLLOW_2); 

                    				doneLeaf(enumLiteral_0);
                    			

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalJDL.g:2410:3: (enumLiteral_1= 'ManyToOne' )
                    {
                    // PsiInternalJDL.g:2410:3: (enumLiteral_1= 'ManyToOne' )
                    // PsiInternalJDL.g:2411:4: enumLiteral_1= 'ManyToOne'
                    {

                    				markLeaf(elementTypeProvider.getJdlCardinality_ManyToOneEnumLiteralDeclaration_1ElementType());
                    			
                    enumLiteral_1=(Token)match(input,54,FOLLOW_2); 

                    				doneLeaf(enumLiteral_1);
                    			

                    }


                    }
                    break;
                case 3 :
                    // PsiInternalJDL.g:2420:3: (enumLiteral_2= 'OneToOne' )
                    {
                    // PsiInternalJDL.g:2420:3: (enumLiteral_2= 'OneToOne' )
                    // PsiInternalJDL.g:2421:4: enumLiteral_2= 'OneToOne'
                    {

                    				markLeaf(elementTypeProvider.getJdlCardinality_OneToOneEnumLiteralDeclaration_2ElementType());
                    			
                    enumLiteral_2=(Token)match(input,55,FOLLOW_2); 

                    				doneLeaf(enumLiteral_2);
                    			

                    }


                    }
                    break;
                case 4 :
                    // PsiInternalJDL.g:2430:3: (enumLiteral_3= 'ManyToMany' )
                    {
                    // PsiInternalJDL.g:2430:3: (enumLiteral_3= 'ManyToMany' )
                    // PsiInternalJDL.g:2431:4: enumLiteral_3= 'ManyToMany'
                    {

                    				markLeaf(elementTypeProvider.getJdlCardinality_ManyToManyEnumLiteralDeclaration_3ElementType());
                    			
                    enumLiteral_3=(Token)match(input,56,FOLLOW_2); 

                    				doneLeaf(enumLiteral_3);
                    			

                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlCardinality"


    // $ANTLR start "ruleJdlServiceType"
    // PsiInternalJDL.g:2443:1: ruleJdlServiceType returns [Boolean current=false] : ( (enumLiteral_0= 'serviceClass' ) | (enumLiteral_1= 'serviceImpl' ) ) ;
    public final Boolean ruleJdlServiceType() throws RecognitionException {
        Boolean current = false;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

        try {
            // PsiInternalJDL.g:2444:1: ( ( (enumLiteral_0= 'serviceClass' ) | (enumLiteral_1= 'serviceImpl' ) ) )
            // PsiInternalJDL.g:2445:2: ( (enumLiteral_0= 'serviceClass' ) | (enumLiteral_1= 'serviceImpl' ) )
            {
            // PsiInternalJDL.g:2445:2: ( (enumLiteral_0= 'serviceClass' ) | (enumLiteral_1= 'serviceImpl' ) )
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
                    // PsiInternalJDL.g:2446:3: (enumLiteral_0= 'serviceClass' )
                    {
                    // PsiInternalJDL.g:2446:3: (enumLiteral_0= 'serviceClass' )
                    // PsiInternalJDL.g:2447:4: enumLiteral_0= 'serviceClass'
                    {

                    				markLeaf(elementTypeProvider.getJdlServiceType_ServiceClassEnumLiteralDeclaration_0ElementType());
                    			
                    enumLiteral_0=(Token)match(input,57,FOLLOW_2); 

                    				doneLeaf(enumLiteral_0);
                    			

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalJDL.g:2456:3: (enumLiteral_1= 'serviceImpl' )
                    {
                    // PsiInternalJDL.g:2456:3: (enumLiteral_1= 'serviceImpl' )
                    // PsiInternalJDL.g:2457:4: enumLiteral_1= 'serviceImpl'
                    {

                    				markLeaf(elementTypeProvider.getJdlServiceType_ServiceImplEnumLiteralDeclaration_1ElementType());
                    			
                    enumLiteral_1=(Token)match(input,58,FOLLOW_2); 

                    				doneLeaf(enumLiteral_1);
                    			

                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJdlServiceType"


    // $ANTLR start "ruleJdlDtoType"
    // PsiInternalJDL.g:2469:1: ruleJdlDtoType returns [Boolean current=false] : (enumLiteral_0= 'mapstruct' ) ;
    public final Boolean ruleJdlDtoType() throws RecognitionException {
        Boolean current = false;

        Token enumLiteral_0=null;

        try {
            // PsiInternalJDL.g:2470:1: ( (enumLiteral_0= 'mapstruct' ) )
            // PsiInternalJDL.g:2471:2: (enumLiteral_0= 'mapstruct' )
            {
            // PsiInternalJDL.g:2471:2: (enumLiteral_0= 'mapstruct' )
            // PsiInternalJDL.g:2472:3: enumLiteral_0= 'mapstruct'
            {

            			markLeaf(elementTypeProvider.getJdlDtoType_MapstructEnumLiteralDeclarationElementType());
            		
            enumLiteral_0=(Token)match(input,59,FOLLOW_2); 

            			doneLeaf(enumLiteral_0);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
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