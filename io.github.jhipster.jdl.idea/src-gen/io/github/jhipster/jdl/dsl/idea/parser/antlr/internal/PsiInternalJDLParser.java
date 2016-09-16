package io.github.jhipster.jdl.dsl.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import io.github.jhipster.jdl.dsl.idea.lang.JDLElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import io.github.jhipster.jdl.dsl.services.JDLGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalJDLParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'entity'", "'{'", "','", "'}'", "'String'", "'Integer'", "'Long'", "'BigDecimal'", "'Float'", "'Double'", "'Boolean'", "'LocalDate'", "'ZonedDateTime'", "'Blob'", "'AnyBlob'", "'ImageBlob'", "'required'", "'minlength'", "'('", "')'", "'maxlength'", "'pattern'", "'min'", "'max'", "'minbytes'", "'maxbytes'", "'relationship'", "'to'", "'enum'", "'service'", "'with'", "'dto'", "'paginate'", "'pagination'", "'infinite-scroll'", "'angularSuffix'", "'OneToMany'", "'ManyToOne'", "'OneToOne'", "'ManyToMany'", "'serviceClass'", "'serviceImpl'", "'mapstruct'"
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
    		return "DomainModel";
    	}




    // $ANTLR start "entryRuleDomainModel"
    // PsiInternalJDL.g:52:1: entryRuleDomainModel returns [Boolean current=false] : iv_ruleDomainModel= ruleDomainModel EOF ;
    public final Boolean entryRuleDomainModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDomainModel = null;


        try {
            // PsiInternalJDL.g:52:53: (iv_ruleDomainModel= ruleDomainModel EOF )
            // PsiInternalJDL.g:53:2: iv_ruleDomainModel= ruleDomainModel EOF
            {
             markComposite(elementTypeProvider.getDomainModelElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleDomainModel=ruleDomainModel();

            state._fsp--;

             current =iv_ruleDomainModel; 
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
    // $ANTLR end "entryRuleDomainModel"


    // $ANTLR start "ruleDomainModel"
    // PsiInternalJDL.g:59:1: ruleDomainModel returns [Boolean current=false] : ( (lv_elements_0_0= ruleElements ) )* ;
    public final Boolean ruleDomainModel() throws RecognitionException {
        Boolean current = false;

        Boolean lv_elements_0_0 = null;


        try {
            // PsiInternalJDL.g:60:1: ( ( (lv_elements_0_0= ruleElements ) )* )
            // PsiInternalJDL.g:61:2: ( (lv_elements_0_0= ruleElements ) )*
            {
            // PsiInternalJDL.g:61:2: ( (lv_elements_0_0= ruleElements ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11||LA1_0==37||(LA1_0>=39 && LA1_0<=40)||(LA1_0>=42 && LA1_0<=43)||LA1_0==46) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalJDL.g:62:3: (lv_elements_0_0= ruleElements )
            	    {
            	    // PsiInternalJDL.g:62:3: (lv_elements_0_0= ruleElements )
            	    // PsiInternalJDL.g:63:4: lv_elements_0_0= ruleElements
            	    {

            	    				markComposite(elementTypeProvider.getDomainModel_ElementsElementsParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_elements_0_0=ruleElements();

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
    // $ANTLR end "ruleDomainModel"


    // $ANTLR start "entryRuleElements"
    // PsiInternalJDL.g:79:1: entryRuleElements returns [Boolean current=false] : iv_ruleElements= ruleElements EOF ;
    public final Boolean entryRuleElements() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleElements = null;


        try {
            // PsiInternalJDL.g:79:50: (iv_ruleElements= ruleElements EOF )
            // PsiInternalJDL.g:80:2: iv_ruleElements= ruleElements EOF
            {
             markComposite(elementTypeProvider.getElementsElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleElements=ruleElements();

            state._fsp--;

             current =iv_ruleElements; 
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
    // $ANTLR end "entryRuleElements"


    // $ANTLR start "ruleElements"
    // PsiInternalJDL.g:86:1: ruleElements returns [Boolean current=false] : (this_Entity_0= ruleEntity | this_EnumType_1= ruleEnumType | this_Relationships_2= ruleRelationships | this_GenerationSetting_3= ruleGenerationSetting ) ;
    public final Boolean ruleElements() throws RecognitionException {
        Boolean current = false;

        Boolean this_Entity_0 = null;

        Boolean this_EnumType_1 = null;

        Boolean this_Relationships_2 = null;

        Boolean this_GenerationSetting_3 = null;


        try {
            // PsiInternalJDL.g:87:1: ( (this_Entity_0= ruleEntity | this_EnumType_1= ruleEnumType | this_Relationships_2= ruleRelationships | this_GenerationSetting_3= ruleGenerationSetting ) )
            // PsiInternalJDL.g:88:2: (this_Entity_0= ruleEntity | this_EnumType_1= ruleEnumType | this_Relationships_2= ruleRelationships | this_GenerationSetting_3= ruleGenerationSetting )
            {
            // PsiInternalJDL.g:88:2: (this_Entity_0= ruleEntity | this_EnumType_1= ruleEnumType | this_Relationships_2= ruleRelationships | this_GenerationSetting_3= ruleGenerationSetting )
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
            case 46:
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
                    // PsiInternalJDL.g:89:3: this_Entity_0= ruleEntity
                    {

                    			markComposite(elementTypeProvider.getElements_EntityParserRuleCall_0ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_Entity_0=ruleEntity();

                    state._fsp--;


                    			current = this_Entity_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalJDL.g:98:3: this_EnumType_1= ruleEnumType
                    {

                    			markComposite(elementTypeProvider.getElements_EnumTypeParserRuleCall_1ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_EnumType_1=ruleEnumType();

                    state._fsp--;


                    			current = this_EnumType_1;
                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalJDL.g:107:3: this_Relationships_2= ruleRelationships
                    {

                    			markComposite(elementTypeProvider.getElements_RelationshipsParserRuleCall_2ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_Relationships_2=ruleRelationships();

                    state._fsp--;


                    			current = this_Relationships_2;
                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // PsiInternalJDL.g:116:3: this_GenerationSetting_3= ruleGenerationSetting
                    {

                    			markComposite(elementTypeProvider.getElements_GenerationSettingParserRuleCall_3ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_GenerationSetting_3=ruleGenerationSetting();

                    state._fsp--;


                    			current = this_GenerationSetting_3;
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
    // $ANTLR end "ruleElements"


    // $ANTLR start "entryRuleEntity"
    // PsiInternalJDL.g:128:1: entryRuleEntity returns [Boolean current=false] : iv_ruleEntity= ruleEntity EOF ;
    public final Boolean entryRuleEntity() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleEntity = null;


        try {
            // PsiInternalJDL.g:128:48: (iv_ruleEntity= ruleEntity EOF )
            // PsiInternalJDL.g:129:2: iv_ruleEntity= ruleEntity EOF
            {
             markComposite(elementTypeProvider.getEntityElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntity=ruleEntity();

            state._fsp--;

             current =iv_ruleEntity; 
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
    // $ANTLR end "entryRuleEntity"


    // $ANTLR start "ruleEntity"
    // PsiInternalJDL.g:135:1: ruleEntity returns [Boolean current=false] : (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleField ) ) )* otherlv_6= '}' ) ;
    public final Boolean ruleEntity() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Boolean lv_fields_3_0 = null;

        Boolean lv_fields_5_0 = null;


        try {
            // PsiInternalJDL.g:136:1: ( (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleField ) ) )* otherlv_6= '}' ) )
            // PsiInternalJDL.g:137:2: (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleField ) ) )* otherlv_6= '}' )
            {
            // PsiInternalJDL.g:137:2: (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleField ) ) )* otherlv_6= '}' )
            // PsiInternalJDL.g:138:3: otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleField ) ) )* otherlv_6= '}'
            {

            			markLeaf(elementTypeProvider.getEntity_EntityKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalJDL.g:145:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalJDL.g:146:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalJDL.g:146:4: (lv_name_1_0= RULE_ID )
            // PsiInternalJDL.g:147:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getEntity_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getEntity_LeftCurlyBracketKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_4); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalJDL.g:169:3: ( (lv_fields_3_0= ruleField ) )
            // PsiInternalJDL.g:170:4: (lv_fields_3_0= ruleField )
            {
            // PsiInternalJDL.g:170:4: (lv_fields_3_0= ruleField )
            // PsiInternalJDL.g:171:5: lv_fields_3_0= ruleField
            {

            					markComposite(elementTypeProvider.getEntity_FieldsFieldParserRuleCall_3_0ElementType());
            				
            pushFollow(FOLLOW_6);
            lv_fields_3_0=ruleField();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalJDL.g:184:3: (otherlv_4= ',' ( (lv_fields_5_0= ruleField ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // PsiInternalJDL.g:185:4: otherlv_4= ',' ( (lv_fields_5_0= ruleField ) )
            	    {

            	    				markLeaf(elementTypeProvider.getEntity_CommaKeyword_4_0ElementType());
            	    			
            	    otherlv_4=(Token)match(input,13,FOLLOW_4); 

            	    				doneLeaf(otherlv_4);
            	    			
            	    // PsiInternalJDL.g:192:4: ( (lv_fields_5_0= ruleField ) )
            	    // PsiInternalJDL.g:193:5: (lv_fields_5_0= ruleField )
            	    {
            	    // PsiInternalJDL.g:193:5: (lv_fields_5_0= ruleField )
            	    // PsiInternalJDL.g:194:6: lv_fields_5_0= ruleField
            	    {

            	    						markComposite(elementTypeProvider.getEntity_FieldsFieldParserRuleCall_4_1_0ElementType());
            	    					
            	    pushFollow(FOLLOW_6);
            	    lv_fields_5_0=ruleField();

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


            			markLeaf(elementTypeProvider.getEntity_RightCurlyBracketKeyword_5ElementType());
            		
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
    // $ANTLR end "ruleEntity"


    // $ANTLR start "entryRuleField"
    // PsiInternalJDL.g:219:1: entryRuleField returns [Boolean current=false] : iv_ruleField= ruleField EOF ;
    public final Boolean entryRuleField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleField = null;


        try {
            // PsiInternalJDL.g:219:47: (iv_ruleField= ruleField EOF )
            // PsiInternalJDL.g:220:2: iv_ruleField= ruleField EOF
            {
             markComposite(elementTypeProvider.getFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleField=ruleField();

            state._fsp--;

             current =iv_ruleField; 
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
    // $ANTLR end "entryRuleField"


    // $ANTLR start "ruleField"
    // PsiInternalJDL.g:226:1: ruleField returns [Boolean current=false] : (this_StringField_0= ruleStringField | this_NumericField_1= ruleNumericField | this_BooleanField_2= ruleBooleanField | this_DateField_3= ruleDateField | this_BinaryLargeObjectField_4= ruleBinaryLargeObjectField | this_EnumField_5= ruleEnumField ) ;
    public final Boolean ruleField() throws RecognitionException {
        Boolean current = false;

        Boolean this_StringField_0 = null;

        Boolean this_NumericField_1 = null;

        Boolean this_BooleanField_2 = null;

        Boolean this_DateField_3 = null;

        Boolean this_BinaryLargeObjectField_4 = null;

        Boolean this_EnumField_5 = null;


        try {
            // PsiInternalJDL.g:227:1: ( (this_StringField_0= ruleStringField | this_NumericField_1= ruleNumericField | this_BooleanField_2= ruleBooleanField | this_DateField_3= ruleDateField | this_BinaryLargeObjectField_4= ruleBinaryLargeObjectField | this_EnumField_5= ruleEnumField ) )
            // PsiInternalJDL.g:228:2: (this_StringField_0= ruleStringField | this_NumericField_1= ruleNumericField | this_BooleanField_2= ruleBooleanField | this_DateField_3= ruleDateField | this_BinaryLargeObjectField_4= ruleBinaryLargeObjectField | this_EnumField_5= ruleEnumField )
            {
            // PsiInternalJDL.g:228:2: (this_StringField_0= ruleStringField | this_NumericField_1= ruleNumericField | this_BooleanField_2= ruleBooleanField | this_DateField_3= ruleDateField | this_BinaryLargeObjectField_4= ruleBinaryLargeObjectField | this_EnumField_5= ruleEnumField )
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
                case 24:
                case 25:
                case 26:
                    {
                    alt4=5;
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
                case 22:
                case 23:
                    {
                    alt4=4;
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
                    // PsiInternalJDL.g:229:3: this_StringField_0= ruleStringField
                    {

                    			markComposite(elementTypeProvider.getField_StringFieldParserRuleCall_0ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_StringField_0=ruleStringField();

                    state._fsp--;


                    			current = this_StringField_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalJDL.g:238:3: this_NumericField_1= ruleNumericField
                    {

                    			markComposite(elementTypeProvider.getField_NumericFieldParserRuleCall_1ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_NumericField_1=ruleNumericField();

                    state._fsp--;


                    			current = this_NumericField_1;
                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalJDL.g:247:3: this_BooleanField_2= ruleBooleanField
                    {

                    			markComposite(elementTypeProvider.getField_BooleanFieldParserRuleCall_2ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_BooleanField_2=ruleBooleanField();

                    state._fsp--;


                    			current = this_BooleanField_2;
                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // PsiInternalJDL.g:256:3: this_DateField_3= ruleDateField
                    {

                    			markComposite(elementTypeProvider.getField_DateFieldParserRuleCall_3ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_DateField_3=ruleDateField();

                    state._fsp--;


                    			current = this_DateField_3;
                    			doneComposite();
                    		

                    }
                    break;
                case 5 :
                    // PsiInternalJDL.g:265:3: this_BinaryLargeObjectField_4= ruleBinaryLargeObjectField
                    {

                    			markComposite(elementTypeProvider.getField_BinaryLargeObjectFieldParserRuleCall_4ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_BinaryLargeObjectField_4=ruleBinaryLargeObjectField();

                    state._fsp--;


                    			current = this_BinaryLargeObjectField_4;
                    			doneComposite();
                    		

                    }
                    break;
                case 6 :
                    // PsiInternalJDL.g:274:3: this_EnumField_5= ruleEnumField
                    {

                    			markComposite(elementTypeProvider.getField_EnumFieldParserRuleCall_5ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_EnumField_5=ruleEnumField();

                    state._fsp--;


                    			current = this_EnumField_5;
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
    // $ANTLR end "ruleField"


    // $ANTLR start "entryRuleEnumField"
    // PsiInternalJDL.g:286:1: entryRuleEnumField returns [Boolean current=false] : iv_ruleEnumField= ruleEnumField EOF ;
    public final Boolean entryRuleEnumField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleEnumField = null;


        try {
            // PsiInternalJDL.g:286:51: (iv_ruleEnumField= ruleEnumField EOF )
            // PsiInternalJDL.g:287:2: iv_ruleEnumField= ruleEnumField EOF
            {
             markComposite(elementTypeProvider.getEnumFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumField=ruleEnumField();

            state._fsp--;

             current =iv_ruleEnumField; 
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
    // $ANTLR end "entryRuleEnumField"


    // $ANTLR start "ruleEnumField"
    // PsiInternalJDL.g:293:1: ruleEnumField returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) ) ( (lv_validators_2_0= ruleRequiredValidator ) )? ) ;
    public final Boolean ruleEnumField() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Boolean lv_validators_2_0 = null;


        try {
            // PsiInternalJDL.g:294:1: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) ) ( (lv_validators_2_0= ruleRequiredValidator ) )? ) )
            // PsiInternalJDL.g:295:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) ) ( (lv_validators_2_0= ruleRequiredValidator ) )? )
            {
            // PsiInternalJDL.g:295:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) ) ( (lv_validators_2_0= ruleRequiredValidator ) )? )
            // PsiInternalJDL.g:296:3: ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) ) ( (lv_validators_2_0= ruleRequiredValidator ) )?
            {
            // PsiInternalJDL.g:296:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalJDL.g:297:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalJDL.g:297:4: (lv_name_0_0= RULE_ID )
            // PsiInternalJDL.g:298:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getEnumField_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_0_0);
            				

            }


            }

            // PsiInternalJDL.g:313:3: ( (otherlv_1= RULE_ID ) )
            // PsiInternalJDL.g:314:4: (otherlv_1= RULE_ID )
            {
            // PsiInternalJDL.g:314:4: (otherlv_1= RULE_ID )
            // PsiInternalJDL.g:315:5: otherlv_1= RULE_ID
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					markLeaf(elementTypeProvider.getEnumField_EnumTypeEnumTypeCrossReference_1_0ElementType());
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_7); 

            					doneLeaf(otherlv_1);
            				

            }


            }

            // PsiInternalJDL.g:330:3: ( (lv_validators_2_0= ruleRequiredValidator ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==27) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // PsiInternalJDL.g:331:4: (lv_validators_2_0= ruleRequiredValidator )
                    {
                    // PsiInternalJDL.g:331:4: (lv_validators_2_0= ruleRequiredValidator )
                    // PsiInternalJDL.g:332:5: lv_validators_2_0= ruleRequiredValidator
                    {

                    					markComposite(elementTypeProvider.getEnumField_ValidatorsRequiredValidatorParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_2_0=ruleRequiredValidator();

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
    // $ANTLR end "ruleEnumField"


    // $ANTLR start "entryRuleStringField"
    // PsiInternalJDL.g:349:1: entryRuleStringField returns [Boolean current=false] : iv_ruleStringField= ruleStringField EOF ;
    public final Boolean entryRuleStringField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleStringField = null;


        try {
            // PsiInternalJDL.g:349:53: (iv_ruleStringField= ruleStringField EOF )
            // PsiInternalJDL.g:350:2: iv_ruleStringField= ruleStringField EOF
            {
             markComposite(elementTypeProvider.getStringFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleStringField=ruleStringField();

            state._fsp--;

             current =iv_ruleStringField; 
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
    // $ANTLR end "entryRuleStringField"


    // $ANTLR start "ruleStringField"
    // PsiInternalJDL.g:356:1: ruleStringField returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'String' ( (lv_validators_2_0= ruleStringValidators ) )? ) ;
    public final Boolean ruleStringField() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Boolean lv_validators_2_0 = null;


        try {
            // PsiInternalJDL.g:357:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'String' ( (lv_validators_2_0= ruleStringValidators ) )? ) )
            // PsiInternalJDL.g:358:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'String' ( (lv_validators_2_0= ruleStringValidators ) )? )
            {
            // PsiInternalJDL.g:358:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'String' ( (lv_validators_2_0= ruleStringValidators ) )? )
            // PsiInternalJDL.g:359:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'String' ( (lv_validators_2_0= ruleStringValidators ) )?
            {
            // PsiInternalJDL.g:359:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalJDL.g:360:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalJDL.g:360:4: (lv_name_0_0= RULE_ID )
            // PsiInternalJDL.g:361:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getStringField_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getStringField_StringKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,15,FOLLOW_7); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:383:3: ( (lv_validators_2_0= ruleStringValidators ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==27) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // PsiInternalJDL.g:384:4: (lv_validators_2_0= ruleStringValidators )
                    {
                    // PsiInternalJDL.g:384:4: (lv_validators_2_0= ruleStringValidators )
                    // PsiInternalJDL.g:385:5: lv_validators_2_0= ruleStringValidators
                    {

                    					markComposite(elementTypeProvider.getStringField_ValidatorsStringValidatorsParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_2_0=ruleStringValidators();

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
    // $ANTLR end "ruleStringField"


    // $ANTLR start "entryRuleNumericField"
    // PsiInternalJDL.g:402:1: entryRuleNumericField returns [Boolean current=false] : iv_ruleNumericField= ruleNumericField EOF ;
    public final Boolean entryRuleNumericField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNumericField = null;


        try {
            // PsiInternalJDL.g:402:54: (iv_ruleNumericField= ruleNumericField EOF )
            // PsiInternalJDL.g:403:2: iv_ruleNumericField= ruleNumericField EOF
            {
             markComposite(elementTypeProvider.getNumericFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumericField=ruleNumericField();

            state._fsp--;

             current =iv_ruleNumericField; 
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
    // $ANTLR end "entryRuleNumericField"


    // $ANTLR start "ruleNumericField"
    // PsiInternalJDL.g:409:1: ruleNumericField returns [Boolean current=false] : (this_IntegerField_0= ruleIntegerField | this_LongField_1= ruleLongField | this_BigDecimalField_2= ruleBigDecimalField | this_FloatField_3= ruleFloatField | this_DoubleField_4= ruleDoubleField ) ;
    public final Boolean ruleNumericField() throws RecognitionException {
        Boolean current = false;

        Boolean this_IntegerField_0 = null;

        Boolean this_LongField_1 = null;

        Boolean this_BigDecimalField_2 = null;

        Boolean this_FloatField_3 = null;

        Boolean this_DoubleField_4 = null;


        try {
            // PsiInternalJDL.g:410:1: ( (this_IntegerField_0= ruleIntegerField | this_LongField_1= ruleLongField | this_BigDecimalField_2= ruleBigDecimalField | this_FloatField_3= ruleFloatField | this_DoubleField_4= ruleDoubleField ) )
            // PsiInternalJDL.g:411:2: (this_IntegerField_0= ruleIntegerField | this_LongField_1= ruleLongField | this_BigDecimalField_2= ruleBigDecimalField | this_FloatField_3= ruleFloatField | this_DoubleField_4= ruleDoubleField )
            {
            // PsiInternalJDL.g:411:2: (this_IntegerField_0= ruleIntegerField | this_LongField_1= ruleLongField | this_BigDecimalField_2= ruleBigDecimalField | this_FloatField_3= ruleFloatField | this_DoubleField_4= ruleDoubleField )
            int alt7=5;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                switch ( input.LA(2) ) {
                case 19:
                    {
                    alt7=4;
                    }
                    break;
                case 18:
                    {
                    alt7=3;
                    }
                    break;
                case 17:
                    {
                    alt7=2;
                    }
                    break;
                case 16:
                    {
                    alt7=1;
                    }
                    break;
                case 20:
                    {
                    alt7=5;
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
                    // PsiInternalJDL.g:412:3: this_IntegerField_0= ruleIntegerField
                    {

                    			markComposite(elementTypeProvider.getNumericField_IntegerFieldParserRuleCall_0ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_IntegerField_0=ruleIntegerField();

                    state._fsp--;


                    			current = this_IntegerField_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalJDL.g:421:3: this_LongField_1= ruleLongField
                    {

                    			markComposite(elementTypeProvider.getNumericField_LongFieldParserRuleCall_1ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_LongField_1=ruleLongField();

                    state._fsp--;


                    			current = this_LongField_1;
                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalJDL.g:430:3: this_BigDecimalField_2= ruleBigDecimalField
                    {

                    			markComposite(elementTypeProvider.getNumericField_BigDecimalFieldParserRuleCall_2ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_BigDecimalField_2=ruleBigDecimalField();

                    state._fsp--;


                    			current = this_BigDecimalField_2;
                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // PsiInternalJDL.g:439:3: this_FloatField_3= ruleFloatField
                    {

                    			markComposite(elementTypeProvider.getNumericField_FloatFieldParserRuleCall_3ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_FloatField_3=ruleFloatField();

                    state._fsp--;


                    			current = this_FloatField_3;
                    			doneComposite();
                    		

                    }
                    break;
                case 5 :
                    // PsiInternalJDL.g:448:3: this_DoubleField_4= ruleDoubleField
                    {

                    			markComposite(elementTypeProvider.getNumericField_DoubleFieldParserRuleCall_4ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_DoubleField_4=ruleDoubleField();

                    state._fsp--;


                    			current = this_DoubleField_4;
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
    // $ANTLR end "ruleNumericField"


    // $ANTLR start "entryRuleIntegerField"
    // PsiInternalJDL.g:460:1: entryRuleIntegerField returns [Boolean current=false] : iv_ruleIntegerField= ruleIntegerField EOF ;
    public final Boolean entryRuleIntegerField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleIntegerField = null;


        try {
            // PsiInternalJDL.g:460:54: (iv_ruleIntegerField= ruleIntegerField EOF )
            // PsiInternalJDL.g:461:2: iv_ruleIntegerField= ruleIntegerField EOF
            {
             markComposite(elementTypeProvider.getIntegerFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntegerField=ruleIntegerField();

            state._fsp--;

             current =iv_ruleIntegerField; 
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
    // $ANTLR end "entryRuleIntegerField"


    // $ANTLR start "ruleIntegerField"
    // PsiInternalJDL.g:467:1: ruleIntegerField returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Integer' ( (lv_validators_2_0= ruleNumericValidators ) )? ) ;
    public final Boolean ruleIntegerField() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Boolean lv_validators_2_0 = null;


        try {
            // PsiInternalJDL.g:468:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Integer' ( (lv_validators_2_0= ruleNumericValidators ) )? ) )
            // PsiInternalJDL.g:469:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Integer' ( (lv_validators_2_0= ruleNumericValidators ) )? )
            {
            // PsiInternalJDL.g:469:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Integer' ( (lv_validators_2_0= ruleNumericValidators ) )? )
            // PsiInternalJDL.g:470:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Integer' ( (lv_validators_2_0= ruleNumericValidators ) )?
            {
            // PsiInternalJDL.g:470:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalJDL.g:471:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalJDL.g:471:4: (lv_name_0_0= RULE_ID )
            // PsiInternalJDL.g:472:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getIntegerField_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getIntegerField_IntegerKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,16,FOLLOW_7); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:494:3: ( (lv_validators_2_0= ruleNumericValidators ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==27) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // PsiInternalJDL.g:495:4: (lv_validators_2_0= ruleNumericValidators )
                    {
                    // PsiInternalJDL.g:495:4: (lv_validators_2_0= ruleNumericValidators )
                    // PsiInternalJDL.g:496:5: lv_validators_2_0= ruleNumericValidators
                    {

                    					markComposite(elementTypeProvider.getIntegerField_ValidatorsNumericValidatorsParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_2_0=ruleNumericValidators();

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
    // $ANTLR end "ruleIntegerField"


    // $ANTLR start "entryRuleLongField"
    // PsiInternalJDL.g:513:1: entryRuleLongField returns [Boolean current=false] : iv_ruleLongField= ruleLongField EOF ;
    public final Boolean entryRuleLongField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleLongField = null;


        try {
            // PsiInternalJDL.g:513:51: (iv_ruleLongField= ruleLongField EOF )
            // PsiInternalJDL.g:514:2: iv_ruleLongField= ruleLongField EOF
            {
             markComposite(elementTypeProvider.getLongFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleLongField=ruleLongField();

            state._fsp--;

             current =iv_ruleLongField; 
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
    // $ANTLR end "entryRuleLongField"


    // $ANTLR start "ruleLongField"
    // PsiInternalJDL.g:520:1: ruleLongField returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Long' ( (lv_validators_2_0= ruleNumericValidators ) )? ) ;
    public final Boolean ruleLongField() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Boolean lv_validators_2_0 = null;


        try {
            // PsiInternalJDL.g:521:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Long' ( (lv_validators_2_0= ruleNumericValidators ) )? ) )
            // PsiInternalJDL.g:522:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Long' ( (lv_validators_2_0= ruleNumericValidators ) )? )
            {
            // PsiInternalJDL.g:522:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Long' ( (lv_validators_2_0= ruleNumericValidators ) )? )
            // PsiInternalJDL.g:523:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Long' ( (lv_validators_2_0= ruleNumericValidators ) )?
            {
            // PsiInternalJDL.g:523:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalJDL.g:524:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalJDL.g:524:4: (lv_name_0_0= RULE_ID )
            // PsiInternalJDL.g:525:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getLongField_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getLongField_LongKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,17,FOLLOW_7); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:547:3: ( (lv_validators_2_0= ruleNumericValidators ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==27) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // PsiInternalJDL.g:548:4: (lv_validators_2_0= ruleNumericValidators )
                    {
                    // PsiInternalJDL.g:548:4: (lv_validators_2_0= ruleNumericValidators )
                    // PsiInternalJDL.g:549:5: lv_validators_2_0= ruleNumericValidators
                    {

                    					markComposite(elementTypeProvider.getLongField_ValidatorsNumericValidatorsParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_2_0=ruleNumericValidators();

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
    // $ANTLR end "ruleLongField"


    // $ANTLR start "entryRuleBigDecimalField"
    // PsiInternalJDL.g:566:1: entryRuleBigDecimalField returns [Boolean current=false] : iv_ruleBigDecimalField= ruleBigDecimalField EOF ;
    public final Boolean entryRuleBigDecimalField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleBigDecimalField = null;


        try {
            // PsiInternalJDL.g:566:57: (iv_ruleBigDecimalField= ruleBigDecimalField EOF )
            // PsiInternalJDL.g:567:2: iv_ruleBigDecimalField= ruleBigDecimalField EOF
            {
             markComposite(elementTypeProvider.getBigDecimalFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleBigDecimalField=ruleBigDecimalField();

            state._fsp--;

             current =iv_ruleBigDecimalField; 
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
    // $ANTLR end "entryRuleBigDecimalField"


    // $ANTLR start "ruleBigDecimalField"
    // PsiInternalJDL.g:573:1: ruleBigDecimalField returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'BigDecimal' ( (lv_validators_2_0= ruleNumericValidators ) )? ) ;
    public final Boolean ruleBigDecimalField() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Boolean lv_validators_2_0 = null;


        try {
            // PsiInternalJDL.g:574:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'BigDecimal' ( (lv_validators_2_0= ruleNumericValidators ) )? ) )
            // PsiInternalJDL.g:575:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'BigDecimal' ( (lv_validators_2_0= ruleNumericValidators ) )? )
            {
            // PsiInternalJDL.g:575:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'BigDecimal' ( (lv_validators_2_0= ruleNumericValidators ) )? )
            // PsiInternalJDL.g:576:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'BigDecimal' ( (lv_validators_2_0= ruleNumericValidators ) )?
            {
            // PsiInternalJDL.g:576:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalJDL.g:577:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalJDL.g:577:4: (lv_name_0_0= RULE_ID )
            // PsiInternalJDL.g:578:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getBigDecimalField_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_11); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getBigDecimalField_BigDecimalKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_7); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:600:3: ( (lv_validators_2_0= ruleNumericValidators ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==27) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // PsiInternalJDL.g:601:4: (lv_validators_2_0= ruleNumericValidators )
                    {
                    // PsiInternalJDL.g:601:4: (lv_validators_2_0= ruleNumericValidators )
                    // PsiInternalJDL.g:602:5: lv_validators_2_0= ruleNumericValidators
                    {

                    					markComposite(elementTypeProvider.getBigDecimalField_ValidatorsNumericValidatorsParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_2_0=ruleNumericValidators();

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
    // $ANTLR end "ruleBigDecimalField"


    // $ANTLR start "entryRuleFloatField"
    // PsiInternalJDL.g:619:1: entryRuleFloatField returns [Boolean current=false] : iv_ruleFloatField= ruleFloatField EOF ;
    public final Boolean entryRuleFloatField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleFloatField = null;


        try {
            // PsiInternalJDL.g:619:52: (iv_ruleFloatField= ruleFloatField EOF )
            // PsiInternalJDL.g:620:2: iv_ruleFloatField= ruleFloatField EOF
            {
             markComposite(elementTypeProvider.getFloatFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleFloatField=ruleFloatField();

            state._fsp--;

             current =iv_ruleFloatField; 
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
    // $ANTLR end "entryRuleFloatField"


    // $ANTLR start "ruleFloatField"
    // PsiInternalJDL.g:626:1: ruleFloatField returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Float' ( (lv_validators_2_0= ruleNumericValidators ) )? ) ;
    public final Boolean ruleFloatField() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Boolean lv_validators_2_0 = null;


        try {
            // PsiInternalJDL.g:627:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Float' ( (lv_validators_2_0= ruleNumericValidators ) )? ) )
            // PsiInternalJDL.g:628:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Float' ( (lv_validators_2_0= ruleNumericValidators ) )? )
            {
            // PsiInternalJDL.g:628:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Float' ( (lv_validators_2_0= ruleNumericValidators ) )? )
            // PsiInternalJDL.g:629:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Float' ( (lv_validators_2_0= ruleNumericValidators ) )?
            {
            // PsiInternalJDL.g:629:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalJDL.g:630:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalJDL.g:630:4: (lv_name_0_0= RULE_ID )
            // PsiInternalJDL.g:631:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getFloatField_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_12); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getFloatField_FloatKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,19,FOLLOW_7); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:653:3: ( (lv_validators_2_0= ruleNumericValidators ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==27) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // PsiInternalJDL.g:654:4: (lv_validators_2_0= ruleNumericValidators )
                    {
                    // PsiInternalJDL.g:654:4: (lv_validators_2_0= ruleNumericValidators )
                    // PsiInternalJDL.g:655:5: lv_validators_2_0= ruleNumericValidators
                    {

                    					markComposite(elementTypeProvider.getFloatField_ValidatorsNumericValidatorsParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_2_0=ruleNumericValidators();

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
    // $ANTLR end "ruleFloatField"


    // $ANTLR start "entryRuleDoubleField"
    // PsiInternalJDL.g:672:1: entryRuleDoubleField returns [Boolean current=false] : iv_ruleDoubleField= ruleDoubleField EOF ;
    public final Boolean entryRuleDoubleField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDoubleField = null;


        try {
            // PsiInternalJDL.g:672:53: (iv_ruleDoubleField= ruleDoubleField EOF )
            // PsiInternalJDL.g:673:2: iv_ruleDoubleField= ruleDoubleField EOF
            {
             markComposite(elementTypeProvider.getDoubleFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleDoubleField=ruleDoubleField();

            state._fsp--;

             current =iv_ruleDoubleField; 
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
    // $ANTLR end "entryRuleDoubleField"


    // $ANTLR start "ruleDoubleField"
    // PsiInternalJDL.g:679:1: ruleDoubleField returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Double' ( (lv_validators_2_0= ruleNumericValidators ) )? ) ;
    public final Boolean ruleDoubleField() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Boolean lv_validators_2_0 = null;


        try {
            // PsiInternalJDL.g:680:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Double' ( (lv_validators_2_0= ruleNumericValidators ) )? ) )
            // PsiInternalJDL.g:681:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Double' ( (lv_validators_2_0= ruleNumericValidators ) )? )
            {
            // PsiInternalJDL.g:681:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Double' ( (lv_validators_2_0= ruleNumericValidators ) )? )
            // PsiInternalJDL.g:682:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Double' ( (lv_validators_2_0= ruleNumericValidators ) )?
            {
            // PsiInternalJDL.g:682:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalJDL.g:683:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalJDL.g:683:4: (lv_name_0_0= RULE_ID )
            // PsiInternalJDL.g:684:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getDoubleField_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getDoubleField_DoubleKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,20,FOLLOW_7); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:706:3: ( (lv_validators_2_0= ruleNumericValidators ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==27) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // PsiInternalJDL.g:707:4: (lv_validators_2_0= ruleNumericValidators )
                    {
                    // PsiInternalJDL.g:707:4: (lv_validators_2_0= ruleNumericValidators )
                    // PsiInternalJDL.g:708:5: lv_validators_2_0= ruleNumericValidators
                    {

                    					markComposite(elementTypeProvider.getDoubleField_ValidatorsNumericValidatorsParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_2_0=ruleNumericValidators();

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
    // $ANTLR end "ruleDoubleField"


    // $ANTLR start "entryRuleBooleanField"
    // PsiInternalJDL.g:725:1: entryRuleBooleanField returns [Boolean current=false] : iv_ruleBooleanField= ruleBooleanField EOF ;
    public final Boolean entryRuleBooleanField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleBooleanField = null;


        try {
            // PsiInternalJDL.g:725:54: (iv_ruleBooleanField= ruleBooleanField EOF )
            // PsiInternalJDL.g:726:2: iv_ruleBooleanField= ruleBooleanField EOF
            {
             markComposite(elementTypeProvider.getBooleanFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleBooleanField=ruleBooleanField();

            state._fsp--;

             current =iv_ruleBooleanField; 
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
    // $ANTLR end "entryRuleBooleanField"


    // $ANTLR start "ruleBooleanField"
    // PsiInternalJDL.g:732:1: ruleBooleanField returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Boolean' ( (lv_validators_2_0= ruleRequiredValidator ) )? ) ;
    public final Boolean ruleBooleanField() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Boolean lv_validators_2_0 = null;


        try {
            // PsiInternalJDL.g:733:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Boolean' ( (lv_validators_2_0= ruleRequiredValidator ) )? ) )
            // PsiInternalJDL.g:734:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Boolean' ( (lv_validators_2_0= ruleRequiredValidator ) )? )
            {
            // PsiInternalJDL.g:734:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Boolean' ( (lv_validators_2_0= ruleRequiredValidator ) )? )
            // PsiInternalJDL.g:735:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Boolean' ( (lv_validators_2_0= ruleRequiredValidator ) )?
            {
            // PsiInternalJDL.g:735:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalJDL.g:736:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalJDL.g:736:4: (lv_name_0_0= RULE_ID )
            // PsiInternalJDL.g:737:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getBooleanField_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_14); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getBooleanField_BooleanKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,21,FOLLOW_7); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:759:3: ( (lv_validators_2_0= ruleRequiredValidator ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==27) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // PsiInternalJDL.g:760:4: (lv_validators_2_0= ruleRequiredValidator )
                    {
                    // PsiInternalJDL.g:760:4: (lv_validators_2_0= ruleRequiredValidator )
                    // PsiInternalJDL.g:761:5: lv_validators_2_0= ruleRequiredValidator
                    {

                    					markComposite(elementTypeProvider.getBooleanField_ValidatorsRequiredValidatorParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_2_0=ruleRequiredValidator();

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
    // $ANTLR end "ruleBooleanField"


    // $ANTLR start "entryRuleDateField"
    // PsiInternalJDL.g:778:1: entryRuleDateField returns [Boolean current=false] : iv_ruleDateField= ruleDateField EOF ;
    public final Boolean entryRuleDateField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDateField = null;


        try {
            // PsiInternalJDL.g:778:51: (iv_ruleDateField= ruleDateField EOF )
            // PsiInternalJDL.g:779:2: iv_ruleDateField= ruleDateField EOF
            {
             markComposite(elementTypeProvider.getDateFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleDateField=ruleDateField();

            state._fsp--;

             current =iv_ruleDateField; 
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
    // $ANTLR end "entryRuleDateField"


    // $ANTLR start "ruleDateField"
    // PsiInternalJDL.g:785:1: ruleDateField returns [Boolean current=false] : (this_LocalDateField_0= ruleLocalDateField | this_ZonedDateTimeField_1= ruleZonedDateTimeField ) ;
    public final Boolean ruleDateField() throws RecognitionException {
        Boolean current = false;

        Boolean this_LocalDateField_0 = null;

        Boolean this_ZonedDateTimeField_1 = null;


        try {
            // PsiInternalJDL.g:786:1: ( (this_LocalDateField_0= ruleLocalDateField | this_ZonedDateTimeField_1= ruleZonedDateTimeField ) )
            // PsiInternalJDL.g:787:2: (this_LocalDateField_0= ruleLocalDateField | this_ZonedDateTimeField_1= ruleZonedDateTimeField )
            {
            // PsiInternalJDL.g:787:2: (this_LocalDateField_0= ruleLocalDateField | this_ZonedDateTimeField_1= ruleZonedDateTimeField )
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
                    // PsiInternalJDL.g:788:3: this_LocalDateField_0= ruleLocalDateField
                    {

                    			markComposite(elementTypeProvider.getDateField_LocalDateFieldParserRuleCall_0ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_LocalDateField_0=ruleLocalDateField();

                    state._fsp--;


                    			current = this_LocalDateField_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalJDL.g:797:3: this_ZonedDateTimeField_1= ruleZonedDateTimeField
                    {

                    			markComposite(elementTypeProvider.getDateField_ZonedDateTimeFieldParserRuleCall_1ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_ZonedDateTimeField_1=ruleZonedDateTimeField();

                    state._fsp--;


                    			current = this_ZonedDateTimeField_1;
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
    // $ANTLR end "ruleDateField"


    // $ANTLR start "entryRuleLocalDateField"
    // PsiInternalJDL.g:809:1: entryRuleLocalDateField returns [Boolean current=false] : iv_ruleLocalDateField= ruleLocalDateField EOF ;
    public final Boolean entryRuleLocalDateField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleLocalDateField = null;


        try {
            // PsiInternalJDL.g:809:56: (iv_ruleLocalDateField= ruleLocalDateField EOF )
            // PsiInternalJDL.g:810:2: iv_ruleLocalDateField= ruleLocalDateField EOF
            {
             markComposite(elementTypeProvider.getLocalDateFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleLocalDateField=ruleLocalDateField();

            state._fsp--;

             current =iv_ruleLocalDateField; 
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
    // $ANTLR end "entryRuleLocalDateField"


    // $ANTLR start "ruleLocalDateField"
    // PsiInternalJDL.g:816:1: ruleLocalDateField returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'LocalDate' ( (lv_validators_2_0= ruleRequiredValidator ) )? ) ;
    public final Boolean ruleLocalDateField() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Boolean lv_validators_2_0 = null;


        try {
            // PsiInternalJDL.g:817:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'LocalDate' ( (lv_validators_2_0= ruleRequiredValidator ) )? ) )
            // PsiInternalJDL.g:818:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'LocalDate' ( (lv_validators_2_0= ruleRequiredValidator ) )? )
            {
            // PsiInternalJDL.g:818:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'LocalDate' ( (lv_validators_2_0= ruleRequiredValidator ) )? )
            // PsiInternalJDL.g:819:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'LocalDate' ( (lv_validators_2_0= ruleRequiredValidator ) )?
            {
            // PsiInternalJDL.g:819:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalJDL.g:820:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalJDL.g:820:4: (lv_name_0_0= RULE_ID )
            // PsiInternalJDL.g:821:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getLocalDateField_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_15); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getLocalDateField_LocalDateKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,22,FOLLOW_7); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:843:3: ( (lv_validators_2_0= ruleRequiredValidator ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==27) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // PsiInternalJDL.g:844:4: (lv_validators_2_0= ruleRequiredValidator )
                    {
                    // PsiInternalJDL.g:844:4: (lv_validators_2_0= ruleRequiredValidator )
                    // PsiInternalJDL.g:845:5: lv_validators_2_0= ruleRequiredValidator
                    {

                    					markComposite(elementTypeProvider.getLocalDateField_ValidatorsRequiredValidatorParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_2_0=ruleRequiredValidator();

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
    // $ANTLR end "ruleLocalDateField"


    // $ANTLR start "entryRuleZonedDateTimeField"
    // PsiInternalJDL.g:862:1: entryRuleZonedDateTimeField returns [Boolean current=false] : iv_ruleZonedDateTimeField= ruleZonedDateTimeField EOF ;
    public final Boolean entryRuleZonedDateTimeField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleZonedDateTimeField = null;


        try {
            // PsiInternalJDL.g:862:60: (iv_ruleZonedDateTimeField= ruleZonedDateTimeField EOF )
            // PsiInternalJDL.g:863:2: iv_ruleZonedDateTimeField= ruleZonedDateTimeField EOF
            {
             markComposite(elementTypeProvider.getZonedDateTimeFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleZonedDateTimeField=ruleZonedDateTimeField();

            state._fsp--;

             current =iv_ruleZonedDateTimeField; 
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
    // $ANTLR end "entryRuleZonedDateTimeField"


    // $ANTLR start "ruleZonedDateTimeField"
    // PsiInternalJDL.g:869:1: ruleZonedDateTimeField returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'ZonedDateTime' ( (lv_validators_2_0= ruleRequiredValidator ) )? ) ;
    public final Boolean ruleZonedDateTimeField() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Boolean lv_validators_2_0 = null;


        try {
            // PsiInternalJDL.g:870:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'ZonedDateTime' ( (lv_validators_2_0= ruleRequiredValidator ) )? ) )
            // PsiInternalJDL.g:871:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'ZonedDateTime' ( (lv_validators_2_0= ruleRequiredValidator ) )? )
            {
            // PsiInternalJDL.g:871:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'ZonedDateTime' ( (lv_validators_2_0= ruleRequiredValidator ) )? )
            // PsiInternalJDL.g:872:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'ZonedDateTime' ( (lv_validators_2_0= ruleRequiredValidator ) )?
            {
            // PsiInternalJDL.g:872:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalJDL.g:873:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalJDL.g:873:4: (lv_name_0_0= RULE_ID )
            // PsiInternalJDL.g:874:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getZonedDateTimeField_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_16); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getZonedDateTimeField_ZonedDateTimeKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,23,FOLLOW_7); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:896:3: ( (lv_validators_2_0= ruleRequiredValidator ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==27) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // PsiInternalJDL.g:897:4: (lv_validators_2_0= ruleRequiredValidator )
                    {
                    // PsiInternalJDL.g:897:4: (lv_validators_2_0= ruleRequiredValidator )
                    // PsiInternalJDL.g:898:5: lv_validators_2_0= ruleRequiredValidator
                    {

                    					markComposite(elementTypeProvider.getZonedDateTimeField_ValidatorsRequiredValidatorParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_2_0=ruleRequiredValidator();

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
    // $ANTLR end "ruleZonedDateTimeField"


    // $ANTLR start "entryRuleBinaryLargeObjectField"
    // PsiInternalJDL.g:915:1: entryRuleBinaryLargeObjectField returns [Boolean current=false] : iv_ruleBinaryLargeObjectField= ruleBinaryLargeObjectField EOF ;
    public final Boolean entryRuleBinaryLargeObjectField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleBinaryLargeObjectField = null;


        try {
            // PsiInternalJDL.g:915:64: (iv_ruleBinaryLargeObjectField= ruleBinaryLargeObjectField EOF )
            // PsiInternalJDL.g:916:2: iv_ruleBinaryLargeObjectField= ruleBinaryLargeObjectField EOF
            {
             markComposite(elementTypeProvider.getBinaryLargeObjectFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleBinaryLargeObjectField=ruleBinaryLargeObjectField();

            state._fsp--;

             current =iv_ruleBinaryLargeObjectField; 
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
    // $ANTLR end "entryRuleBinaryLargeObjectField"


    // $ANTLR start "ruleBinaryLargeObjectField"
    // PsiInternalJDL.g:922:1: ruleBinaryLargeObjectField returns [Boolean current=false] : (this_BlobField_0= ruleBlobField | this_AnyBlobField_1= ruleAnyBlobField | this_ImageBlobField_2= ruleImageBlobField ) ;
    public final Boolean ruleBinaryLargeObjectField() throws RecognitionException {
        Boolean current = false;

        Boolean this_BlobField_0 = null;

        Boolean this_AnyBlobField_1 = null;

        Boolean this_ImageBlobField_2 = null;


        try {
            // PsiInternalJDL.g:923:1: ( (this_BlobField_0= ruleBlobField | this_AnyBlobField_1= ruleAnyBlobField | this_ImageBlobField_2= ruleImageBlobField ) )
            // PsiInternalJDL.g:924:2: (this_BlobField_0= ruleBlobField | this_AnyBlobField_1= ruleAnyBlobField | this_ImageBlobField_2= ruleImageBlobField )
            {
            // PsiInternalJDL.g:924:2: (this_BlobField_0= ruleBlobField | this_AnyBlobField_1= ruleAnyBlobField | this_ImageBlobField_2= ruleImageBlobField )
            int alt17=3;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                switch ( input.LA(2) ) {
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
                case 24:
                    {
                    alt17=1;
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
                    // PsiInternalJDL.g:925:3: this_BlobField_0= ruleBlobField
                    {

                    			markComposite(elementTypeProvider.getBinaryLargeObjectField_BlobFieldParserRuleCall_0ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_BlobField_0=ruleBlobField();

                    state._fsp--;


                    			current = this_BlobField_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalJDL.g:934:3: this_AnyBlobField_1= ruleAnyBlobField
                    {

                    			markComposite(elementTypeProvider.getBinaryLargeObjectField_AnyBlobFieldParserRuleCall_1ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_AnyBlobField_1=ruleAnyBlobField();

                    state._fsp--;


                    			current = this_AnyBlobField_1;
                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalJDL.g:943:3: this_ImageBlobField_2= ruleImageBlobField
                    {

                    			markComposite(elementTypeProvider.getBinaryLargeObjectField_ImageBlobFieldParserRuleCall_2ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_ImageBlobField_2=ruleImageBlobField();

                    state._fsp--;


                    			current = this_ImageBlobField_2;
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
    // $ANTLR end "ruleBinaryLargeObjectField"


    // $ANTLR start "entryRuleBlobField"
    // PsiInternalJDL.g:955:1: entryRuleBlobField returns [Boolean current=false] : iv_ruleBlobField= ruleBlobField EOF ;
    public final Boolean entryRuleBlobField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleBlobField = null;


        try {
            // PsiInternalJDL.g:955:51: (iv_ruleBlobField= ruleBlobField EOF )
            // PsiInternalJDL.g:956:2: iv_ruleBlobField= ruleBlobField EOF
            {
             markComposite(elementTypeProvider.getBlobFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleBlobField=ruleBlobField();

            state._fsp--;

             current =iv_ruleBlobField; 
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
    // $ANTLR end "entryRuleBlobField"


    // $ANTLR start "ruleBlobField"
    // PsiInternalJDL.g:962:1: ruleBlobField returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Blob' ( (lv_validators_2_0= ruleBlobValidators ) )? ) ;
    public final Boolean ruleBlobField() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Boolean lv_validators_2_0 = null;


        try {
            // PsiInternalJDL.g:963:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Blob' ( (lv_validators_2_0= ruleBlobValidators ) )? ) )
            // PsiInternalJDL.g:964:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Blob' ( (lv_validators_2_0= ruleBlobValidators ) )? )
            {
            // PsiInternalJDL.g:964:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Blob' ( (lv_validators_2_0= ruleBlobValidators ) )? )
            // PsiInternalJDL.g:965:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Blob' ( (lv_validators_2_0= ruleBlobValidators ) )?
            {
            // PsiInternalJDL.g:965:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalJDL.g:966:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalJDL.g:966:4: (lv_name_0_0= RULE_ID )
            // PsiInternalJDL.g:967:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getBlobField_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_17); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getBlobField_BlobKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,24,FOLLOW_7); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:989:3: ( (lv_validators_2_0= ruleBlobValidators ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==27) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // PsiInternalJDL.g:990:4: (lv_validators_2_0= ruleBlobValidators )
                    {
                    // PsiInternalJDL.g:990:4: (lv_validators_2_0= ruleBlobValidators )
                    // PsiInternalJDL.g:991:5: lv_validators_2_0= ruleBlobValidators
                    {

                    					markComposite(elementTypeProvider.getBlobField_ValidatorsBlobValidatorsParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_2_0=ruleBlobValidators();

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
    // $ANTLR end "ruleBlobField"


    // $ANTLR start "entryRuleAnyBlobField"
    // PsiInternalJDL.g:1008:1: entryRuleAnyBlobField returns [Boolean current=false] : iv_ruleAnyBlobField= ruleAnyBlobField EOF ;
    public final Boolean entryRuleAnyBlobField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAnyBlobField = null;


        try {
            // PsiInternalJDL.g:1008:54: (iv_ruleAnyBlobField= ruleAnyBlobField EOF )
            // PsiInternalJDL.g:1009:2: iv_ruleAnyBlobField= ruleAnyBlobField EOF
            {
             markComposite(elementTypeProvider.getAnyBlobFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleAnyBlobField=ruleAnyBlobField();

            state._fsp--;

             current =iv_ruleAnyBlobField; 
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
    // $ANTLR end "entryRuleAnyBlobField"


    // $ANTLR start "ruleAnyBlobField"
    // PsiInternalJDL.g:1015:1: ruleAnyBlobField returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'AnyBlob' ( (lv_validators_2_0= ruleBlobValidators ) )? ) ;
    public final Boolean ruleAnyBlobField() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Boolean lv_validators_2_0 = null;


        try {
            // PsiInternalJDL.g:1016:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'AnyBlob' ( (lv_validators_2_0= ruleBlobValidators ) )? ) )
            // PsiInternalJDL.g:1017:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'AnyBlob' ( (lv_validators_2_0= ruleBlobValidators ) )? )
            {
            // PsiInternalJDL.g:1017:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'AnyBlob' ( (lv_validators_2_0= ruleBlobValidators ) )? )
            // PsiInternalJDL.g:1018:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'AnyBlob' ( (lv_validators_2_0= ruleBlobValidators ) )?
            {
            // PsiInternalJDL.g:1018:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalJDL.g:1019:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalJDL.g:1019:4: (lv_name_0_0= RULE_ID )
            // PsiInternalJDL.g:1020:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getAnyBlobField_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_18); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getAnyBlobField_AnyBlobKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,25,FOLLOW_7); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:1042:3: ( (lv_validators_2_0= ruleBlobValidators ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==27) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // PsiInternalJDL.g:1043:4: (lv_validators_2_0= ruleBlobValidators )
                    {
                    // PsiInternalJDL.g:1043:4: (lv_validators_2_0= ruleBlobValidators )
                    // PsiInternalJDL.g:1044:5: lv_validators_2_0= ruleBlobValidators
                    {

                    					markComposite(elementTypeProvider.getAnyBlobField_ValidatorsBlobValidatorsParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_2_0=ruleBlobValidators();

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
    // $ANTLR end "ruleAnyBlobField"


    // $ANTLR start "entryRuleImageBlobField"
    // PsiInternalJDL.g:1061:1: entryRuleImageBlobField returns [Boolean current=false] : iv_ruleImageBlobField= ruleImageBlobField EOF ;
    public final Boolean entryRuleImageBlobField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleImageBlobField = null;


        try {
            // PsiInternalJDL.g:1061:56: (iv_ruleImageBlobField= ruleImageBlobField EOF )
            // PsiInternalJDL.g:1062:2: iv_ruleImageBlobField= ruleImageBlobField EOF
            {
             markComposite(elementTypeProvider.getImageBlobFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleImageBlobField=ruleImageBlobField();

            state._fsp--;

             current =iv_ruleImageBlobField; 
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
    // $ANTLR end "entryRuleImageBlobField"


    // $ANTLR start "ruleImageBlobField"
    // PsiInternalJDL.g:1068:1: ruleImageBlobField returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'ImageBlob' ( (lv_validators_2_0= ruleBlobValidators ) )? ) ;
    public final Boolean ruleImageBlobField() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Boolean lv_validators_2_0 = null;


        try {
            // PsiInternalJDL.g:1069:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'ImageBlob' ( (lv_validators_2_0= ruleBlobValidators ) )? ) )
            // PsiInternalJDL.g:1070:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'ImageBlob' ( (lv_validators_2_0= ruleBlobValidators ) )? )
            {
            // PsiInternalJDL.g:1070:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'ImageBlob' ( (lv_validators_2_0= ruleBlobValidators ) )? )
            // PsiInternalJDL.g:1071:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'ImageBlob' ( (lv_validators_2_0= ruleBlobValidators ) )?
            {
            // PsiInternalJDL.g:1071:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalJDL.g:1072:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalJDL.g:1072:4: (lv_name_0_0= RULE_ID )
            // PsiInternalJDL.g:1073:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getImageBlobField_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_19); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getImageBlobField_ImageBlobKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,26,FOLLOW_7); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:1095:3: ( (lv_validators_2_0= ruleBlobValidators ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==27) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // PsiInternalJDL.g:1096:4: (lv_validators_2_0= ruleBlobValidators )
                    {
                    // PsiInternalJDL.g:1096:4: (lv_validators_2_0= ruleBlobValidators )
                    // PsiInternalJDL.g:1097:5: lv_validators_2_0= ruleBlobValidators
                    {

                    					markComposite(elementTypeProvider.getImageBlobField_ValidatorsBlobValidatorsParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_2_0=ruleBlobValidators();

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
    // $ANTLR end "ruleImageBlobField"


    // $ANTLR start "entryRuleRequiredValidator"
    // PsiInternalJDL.g:1114:1: entryRuleRequiredValidator returns [Boolean current=false] : iv_ruleRequiredValidator= ruleRequiredValidator EOF ;
    public final Boolean entryRuleRequiredValidator() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleRequiredValidator = null;


        try {
            // PsiInternalJDL.g:1114:59: (iv_ruleRequiredValidator= ruleRequiredValidator EOF )
            // PsiInternalJDL.g:1115:2: iv_ruleRequiredValidator= ruleRequiredValidator EOF
            {
             markComposite(elementTypeProvider.getRequiredValidatorElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleRequiredValidator=ruleRequiredValidator();

            state._fsp--;

             current =iv_ruleRequiredValidator; 
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
    // $ANTLR end "entryRuleRequiredValidator"


    // $ANTLR start "ruleRequiredValidator"
    // PsiInternalJDL.g:1121:1: ruleRequiredValidator returns [Boolean current=false] : ( (lv_required_0_0= 'required' ) ) ;
    public final Boolean ruleRequiredValidator() throws RecognitionException {
        Boolean current = false;

        Token lv_required_0_0=null;

        try {
            // PsiInternalJDL.g:1122:1: ( ( (lv_required_0_0= 'required' ) ) )
            // PsiInternalJDL.g:1123:2: ( (lv_required_0_0= 'required' ) )
            {
            // PsiInternalJDL.g:1123:2: ( (lv_required_0_0= 'required' ) )
            // PsiInternalJDL.g:1124:3: (lv_required_0_0= 'required' )
            {
            // PsiInternalJDL.g:1124:3: (lv_required_0_0= 'required' )
            // PsiInternalJDL.g:1125:4: lv_required_0_0= 'required'
            {

            				markLeaf(elementTypeProvider.getRequiredValidator_RequiredRequiredKeyword_0ElementType());
            			
            lv_required_0_0=(Token)match(input,27,FOLLOW_2); 

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
    // $ANTLR end "ruleRequiredValidator"


    // $ANTLR start "entryRuleMinLengthValidator"
    // PsiInternalJDL.g:1143:1: entryRuleMinLengthValidator returns [Boolean current=false] : iv_ruleMinLengthValidator= ruleMinLengthValidator EOF ;
    public final Boolean entryRuleMinLengthValidator() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMinLengthValidator = null;


        try {
            // PsiInternalJDL.g:1143:60: (iv_ruleMinLengthValidator= ruleMinLengthValidator EOF )
            // PsiInternalJDL.g:1144:2: iv_ruleMinLengthValidator= ruleMinLengthValidator EOF
            {
             markComposite(elementTypeProvider.getMinLengthValidatorElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleMinLengthValidator=ruleMinLengthValidator();

            state._fsp--;

             current =iv_ruleMinLengthValidator; 
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
    // $ANTLR end "entryRuleMinLengthValidator"


    // $ANTLR start "ruleMinLengthValidator"
    // PsiInternalJDL.g:1150:1: ruleMinLengthValidator returns [Boolean current=false] : (otherlv_0= 'minlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final Boolean ruleMinLengthValidator() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;

        try {
            // PsiInternalJDL.g:1151:1: ( (otherlv_0= 'minlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // PsiInternalJDL.g:1152:2: (otherlv_0= 'minlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // PsiInternalJDL.g:1152:2: (otherlv_0= 'minlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            // PsiInternalJDL.g:1153:3: otherlv_0= 'minlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')'
            {

            			markLeaf(elementTypeProvider.getMinLengthValidator_MinlengthKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,28,FOLLOW_20); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getMinLengthValidator_LeftParenthesisKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,29,FOLLOW_21); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:1167:3: ( (lv_value_2_0= RULE_INT ) )
            // PsiInternalJDL.g:1168:4: (lv_value_2_0= RULE_INT )
            {
            // PsiInternalJDL.g:1168:4: (lv_value_2_0= RULE_INT )
            // PsiInternalJDL.g:1169:5: lv_value_2_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getMinLengthValidator_ValueINTTerminalRuleCall_2_0ElementType());
            				
            lv_value_2_0=(Token)match(input,RULE_INT,FOLLOW_22); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_value_2_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getMinLengthValidator_RightParenthesisKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,30,FOLLOW_2); 

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
    // $ANTLR end "ruleMinLengthValidator"


    // $ANTLR start "entryRuleMaxLengthValidator"
    // PsiInternalJDL.g:1195:1: entryRuleMaxLengthValidator returns [Boolean current=false] : iv_ruleMaxLengthValidator= ruleMaxLengthValidator EOF ;
    public final Boolean entryRuleMaxLengthValidator() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMaxLengthValidator = null;


        try {
            // PsiInternalJDL.g:1195:60: (iv_ruleMaxLengthValidator= ruleMaxLengthValidator EOF )
            // PsiInternalJDL.g:1196:2: iv_ruleMaxLengthValidator= ruleMaxLengthValidator EOF
            {
             markComposite(elementTypeProvider.getMaxLengthValidatorElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleMaxLengthValidator=ruleMaxLengthValidator();

            state._fsp--;

             current =iv_ruleMaxLengthValidator; 
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
    // $ANTLR end "entryRuleMaxLengthValidator"


    // $ANTLR start "ruleMaxLengthValidator"
    // PsiInternalJDL.g:1202:1: ruleMaxLengthValidator returns [Boolean current=false] : (otherlv_0= 'maxlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final Boolean ruleMaxLengthValidator() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;

        try {
            // PsiInternalJDL.g:1203:1: ( (otherlv_0= 'maxlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // PsiInternalJDL.g:1204:2: (otherlv_0= 'maxlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // PsiInternalJDL.g:1204:2: (otherlv_0= 'maxlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            // PsiInternalJDL.g:1205:3: otherlv_0= 'maxlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')'
            {

            			markLeaf(elementTypeProvider.getMaxLengthValidator_MaxlengthKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,31,FOLLOW_20); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getMaxLengthValidator_LeftParenthesisKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,29,FOLLOW_21); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:1219:3: ( (lv_value_2_0= RULE_INT ) )
            // PsiInternalJDL.g:1220:4: (lv_value_2_0= RULE_INT )
            {
            // PsiInternalJDL.g:1220:4: (lv_value_2_0= RULE_INT )
            // PsiInternalJDL.g:1221:5: lv_value_2_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getMaxLengthValidator_ValueINTTerminalRuleCall_2_0ElementType());
            				
            lv_value_2_0=(Token)match(input,RULE_INT,FOLLOW_22); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_value_2_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getMaxLengthValidator_RightParenthesisKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,30,FOLLOW_2); 

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
    // $ANTLR end "ruleMaxLengthValidator"


    // $ANTLR start "entryRulePatternValidator"
    // PsiInternalJDL.g:1247:1: entryRulePatternValidator returns [Boolean current=false] : iv_rulePatternValidator= rulePatternValidator EOF ;
    public final Boolean entryRulePatternValidator() throws RecognitionException {
        Boolean current = false;

        Boolean iv_rulePatternValidator = null;


        try {
            // PsiInternalJDL.g:1247:58: (iv_rulePatternValidator= rulePatternValidator EOF )
            // PsiInternalJDL.g:1248:2: iv_rulePatternValidator= rulePatternValidator EOF
            {
             markComposite(elementTypeProvider.getPatternValidatorElementType()); 
            pushFollow(FOLLOW_1);
            iv_rulePatternValidator=rulePatternValidator();

            state._fsp--;

             current =iv_rulePatternValidator; 
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
    // $ANTLR end "entryRulePatternValidator"


    // $ANTLR start "rulePatternValidator"
    // PsiInternalJDL.g:1254:1: rulePatternValidator returns [Boolean current=false] : (otherlv_0= 'pattern' otherlv_1= '(' ( (lv_value_2_0= RULE_STRING ) ) otherlv_3= ')' ) ;
    public final Boolean rulePatternValidator() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;

        try {
            // PsiInternalJDL.g:1255:1: ( (otherlv_0= 'pattern' otherlv_1= '(' ( (lv_value_2_0= RULE_STRING ) ) otherlv_3= ')' ) )
            // PsiInternalJDL.g:1256:2: (otherlv_0= 'pattern' otherlv_1= '(' ( (lv_value_2_0= RULE_STRING ) ) otherlv_3= ')' )
            {
            // PsiInternalJDL.g:1256:2: (otherlv_0= 'pattern' otherlv_1= '(' ( (lv_value_2_0= RULE_STRING ) ) otherlv_3= ')' )
            // PsiInternalJDL.g:1257:3: otherlv_0= 'pattern' otherlv_1= '(' ( (lv_value_2_0= RULE_STRING ) ) otherlv_3= ')'
            {

            			markLeaf(elementTypeProvider.getPatternValidator_PatternKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,32,FOLLOW_20); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getPatternValidator_LeftParenthesisKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,29,FOLLOW_23); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:1271:3: ( (lv_value_2_0= RULE_STRING ) )
            // PsiInternalJDL.g:1272:4: (lv_value_2_0= RULE_STRING )
            {
            // PsiInternalJDL.g:1272:4: (lv_value_2_0= RULE_STRING )
            // PsiInternalJDL.g:1273:5: lv_value_2_0= RULE_STRING
            {

            					markLeaf(elementTypeProvider.getPatternValidator_ValueSTRINGTerminalRuleCall_2_0ElementType());
            				
            lv_value_2_0=(Token)match(input,RULE_STRING,FOLLOW_22); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_value_2_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getPatternValidator_RightParenthesisKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,30,FOLLOW_2); 

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
    // $ANTLR end "rulePatternValidator"


    // $ANTLR start "entryRuleMinValidator"
    // PsiInternalJDL.g:1299:1: entryRuleMinValidator returns [Boolean current=false] : iv_ruleMinValidator= ruleMinValidator EOF ;
    public final Boolean entryRuleMinValidator() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMinValidator = null;


        try {
            // PsiInternalJDL.g:1299:54: (iv_ruleMinValidator= ruleMinValidator EOF )
            // PsiInternalJDL.g:1300:2: iv_ruleMinValidator= ruleMinValidator EOF
            {
             markComposite(elementTypeProvider.getMinValidatorElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleMinValidator=ruleMinValidator();

            state._fsp--;

             current =iv_ruleMinValidator; 
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
    // $ANTLR end "entryRuleMinValidator"


    // $ANTLR start "ruleMinValidator"
    // PsiInternalJDL.g:1306:1: ruleMinValidator returns [Boolean current=false] : (otherlv_0= 'min' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final Boolean ruleMinValidator() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;

        try {
            // PsiInternalJDL.g:1307:1: ( (otherlv_0= 'min' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // PsiInternalJDL.g:1308:2: (otherlv_0= 'min' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // PsiInternalJDL.g:1308:2: (otherlv_0= 'min' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            // PsiInternalJDL.g:1309:3: otherlv_0= 'min' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')'
            {

            			markLeaf(elementTypeProvider.getMinValidator_MinKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,33,FOLLOW_20); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getMinValidator_LeftParenthesisKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,29,FOLLOW_21); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:1323:3: ( (lv_value_2_0= RULE_INT ) )
            // PsiInternalJDL.g:1324:4: (lv_value_2_0= RULE_INT )
            {
            // PsiInternalJDL.g:1324:4: (lv_value_2_0= RULE_INT )
            // PsiInternalJDL.g:1325:5: lv_value_2_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getMinValidator_ValueINTTerminalRuleCall_2_0ElementType());
            				
            lv_value_2_0=(Token)match(input,RULE_INT,FOLLOW_22); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_value_2_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getMinValidator_RightParenthesisKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,30,FOLLOW_2); 

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
    // $ANTLR end "ruleMinValidator"


    // $ANTLR start "entryRuleMaxValidator"
    // PsiInternalJDL.g:1351:1: entryRuleMaxValidator returns [Boolean current=false] : iv_ruleMaxValidator= ruleMaxValidator EOF ;
    public final Boolean entryRuleMaxValidator() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMaxValidator = null;


        try {
            // PsiInternalJDL.g:1351:54: (iv_ruleMaxValidator= ruleMaxValidator EOF )
            // PsiInternalJDL.g:1352:2: iv_ruleMaxValidator= ruleMaxValidator EOF
            {
             markComposite(elementTypeProvider.getMaxValidatorElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleMaxValidator=ruleMaxValidator();

            state._fsp--;

             current =iv_ruleMaxValidator; 
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
    // $ANTLR end "entryRuleMaxValidator"


    // $ANTLR start "ruleMaxValidator"
    // PsiInternalJDL.g:1358:1: ruleMaxValidator returns [Boolean current=false] : (otherlv_0= 'max' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final Boolean ruleMaxValidator() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;

        try {
            // PsiInternalJDL.g:1359:1: ( (otherlv_0= 'max' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // PsiInternalJDL.g:1360:2: (otherlv_0= 'max' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // PsiInternalJDL.g:1360:2: (otherlv_0= 'max' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            // PsiInternalJDL.g:1361:3: otherlv_0= 'max' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')'
            {

            			markLeaf(elementTypeProvider.getMaxValidator_MaxKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,34,FOLLOW_20); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getMaxValidator_LeftParenthesisKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,29,FOLLOW_21); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:1375:3: ( (lv_value_2_0= RULE_INT ) )
            // PsiInternalJDL.g:1376:4: (lv_value_2_0= RULE_INT )
            {
            // PsiInternalJDL.g:1376:4: (lv_value_2_0= RULE_INT )
            // PsiInternalJDL.g:1377:5: lv_value_2_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getMaxValidator_ValueINTTerminalRuleCall_2_0ElementType());
            				
            lv_value_2_0=(Token)match(input,RULE_INT,FOLLOW_22); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_value_2_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getMaxValidator_RightParenthesisKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,30,FOLLOW_2); 

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
    // $ANTLR end "ruleMaxValidator"


    // $ANTLR start "entryRuleMinBytesValidator"
    // PsiInternalJDL.g:1403:1: entryRuleMinBytesValidator returns [Boolean current=false] : iv_ruleMinBytesValidator= ruleMinBytesValidator EOF ;
    public final Boolean entryRuleMinBytesValidator() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMinBytesValidator = null;


        try {
            // PsiInternalJDL.g:1403:59: (iv_ruleMinBytesValidator= ruleMinBytesValidator EOF )
            // PsiInternalJDL.g:1404:2: iv_ruleMinBytesValidator= ruleMinBytesValidator EOF
            {
             markComposite(elementTypeProvider.getMinBytesValidatorElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleMinBytesValidator=ruleMinBytesValidator();

            state._fsp--;

             current =iv_ruleMinBytesValidator; 
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
    // $ANTLR end "entryRuleMinBytesValidator"


    // $ANTLR start "ruleMinBytesValidator"
    // PsiInternalJDL.g:1410:1: ruleMinBytesValidator returns [Boolean current=false] : (otherlv_0= 'minbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final Boolean ruleMinBytesValidator() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;

        try {
            // PsiInternalJDL.g:1411:1: ( (otherlv_0= 'minbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // PsiInternalJDL.g:1412:2: (otherlv_0= 'minbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // PsiInternalJDL.g:1412:2: (otherlv_0= 'minbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            // PsiInternalJDL.g:1413:3: otherlv_0= 'minbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')'
            {

            			markLeaf(elementTypeProvider.getMinBytesValidator_MinbytesKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,35,FOLLOW_20); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getMinBytesValidator_LeftParenthesisKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,29,FOLLOW_21); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:1427:3: ( (lv_value_2_0= RULE_INT ) )
            // PsiInternalJDL.g:1428:4: (lv_value_2_0= RULE_INT )
            {
            // PsiInternalJDL.g:1428:4: (lv_value_2_0= RULE_INT )
            // PsiInternalJDL.g:1429:5: lv_value_2_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getMinBytesValidator_ValueINTTerminalRuleCall_2_0ElementType());
            				
            lv_value_2_0=(Token)match(input,RULE_INT,FOLLOW_22); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_value_2_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getMinBytesValidator_RightParenthesisKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,30,FOLLOW_2); 

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
    // $ANTLR end "ruleMinBytesValidator"


    // $ANTLR start "entryRuleMaxBytesValidator"
    // PsiInternalJDL.g:1455:1: entryRuleMaxBytesValidator returns [Boolean current=false] : iv_ruleMaxBytesValidator= ruleMaxBytesValidator EOF ;
    public final Boolean entryRuleMaxBytesValidator() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMaxBytesValidator = null;


        try {
            // PsiInternalJDL.g:1455:59: (iv_ruleMaxBytesValidator= ruleMaxBytesValidator EOF )
            // PsiInternalJDL.g:1456:2: iv_ruleMaxBytesValidator= ruleMaxBytesValidator EOF
            {
             markComposite(elementTypeProvider.getMaxBytesValidatorElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleMaxBytesValidator=ruleMaxBytesValidator();

            state._fsp--;

             current =iv_ruleMaxBytesValidator; 
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
    // $ANTLR end "entryRuleMaxBytesValidator"


    // $ANTLR start "ruleMaxBytesValidator"
    // PsiInternalJDL.g:1462:1: ruleMaxBytesValidator returns [Boolean current=false] : (otherlv_0= 'maxbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final Boolean ruleMaxBytesValidator() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;

        try {
            // PsiInternalJDL.g:1463:1: ( (otherlv_0= 'maxbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // PsiInternalJDL.g:1464:2: (otherlv_0= 'maxbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // PsiInternalJDL.g:1464:2: (otherlv_0= 'maxbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            // PsiInternalJDL.g:1465:3: otherlv_0= 'maxbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')'
            {

            			markLeaf(elementTypeProvider.getMaxBytesValidator_MaxbytesKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,36,FOLLOW_20); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getMaxBytesValidator_LeftParenthesisKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,29,FOLLOW_21); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:1479:3: ( (lv_value_2_0= RULE_INT ) )
            // PsiInternalJDL.g:1480:4: (lv_value_2_0= RULE_INT )
            {
            // PsiInternalJDL.g:1480:4: (lv_value_2_0= RULE_INT )
            // PsiInternalJDL.g:1481:5: lv_value_2_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getMaxBytesValidator_ValueINTTerminalRuleCall_2_0ElementType());
            				
            lv_value_2_0=(Token)match(input,RULE_INT,FOLLOW_22); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_value_2_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getMaxBytesValidator_RightParenthesisKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,30,FOLLOW_2); 

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
    // $ANTLR end "ruleMaxBytesValidator"


    // $ANTLR start "entryRuleStringValidators"
    // PsiInternalJDL.g:1507:1: entryRuleStringValidators returns [Boolean current=false] : iv_ruleStringValidators= ruleStringValidators EOF ;
    public final Boolean entryRuleStringValidators() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleStringValidators = null;


        try {
            // PsiInternalJDL.g:1507:58: (iv_ruleStringValidators= ruleStringValidators EOF )
            // PsiInternalJDL.g:1508:2: iv_ruleStringValidators= ruleStringValidators EOF
            {
             markComposite(elementTypeProvider.getStringValidatorsElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleStringValidators=ruleStringValidators();

            state._fsp--;

             current =iv_ruleStringValidators; 
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
    // $ANTLR end "entryRuleStringValidators"


    // $ANTLR start "ruleStringValidators"
    // PsiInternalJDL.g:1514:1: ruleStringValidators returns [Boolean current=false] : ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minLength_1_0= ruleMinLengthValidator ) )? ( (lv_maxlength_2_0= ruleMaxLengthValidator ) )? ( (lv_pattern_3_0= rulePatternValidator ) )? ) ;
    public final Boolean ruleStringValidators() throws RecognitionException {
        Boolean current = false;

        Boolean lv_required_0_0 = null;

        Boolean lv_minLength_1_0 = null;

        Boolean lv_maxlength_2_0 = null;

        Boolean lv_pattern_3_0 = null;


        try {
            // PsiInternalJDL.g:1515:1: ( ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minLength_1_0= ruleMinLengthValidator ) )? ( (lv_maxlength_2_0= ruleMaxLengthValidator ) )? ( (lv_pattern_3_0= rulePatternValidator ) )? ) )
            // PsiInternalJDL.g:1516:2: ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minLength_1_0= ruleMinLengthValidator ) )? ( (lv_maxlength_2_0= ruleMaxLengthValidator ) )? ( (lv_pattern_3_0= rulePatternValidator ) )? )
            {
            // PsiInternalJDL.g:1516:2: ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minLength_1_0= ruleMinLengthValidator ) )? ( (lv_maxlength_2_0= ruleMaxLengthValidator ) )? ( (lv_pattern_3_0= rulePatternValidator ) )? )
            // PsiInternalJDL.g:1517:3: ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minLength_1_0= ruleMinLengthValidator ) )? ( (lv_maxlength_2_0= ruleMaxLengthValidator ) )? ( (lv_pattern_3_0= rulePatternValidator ) )?
            {
            // PsiInternalJDL.g:1517:3: ( (lv_required_0_0= ruleRequiredValidator ) )
            // PsiInternalJDL.g:1518:4: (lv_required_0_0= ruleRequiredValidator )
            {
            // PsiInternalJDL.g:1518:4: (lv_required_0_0= ruleRequiredValidator )
            // PsiInternalJDL.g:1519:5: lv_required_0_0= ruleRequiredValidator
            {

            					markComposite(elementTypeProvider.getStringValidators_RequiredRequiredValidatorParserRuleCall_0_0ElementType());
            				
            pushFollow(FOLLOW_24);
            lv_required_0_0=ruleRequiredValidator();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalJDL.g:1532:3: ( (lv_minLength_1_0= ruleMinLengthValidator ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==28) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // PsiInternalJDL.g:1533:4: (lv_minLength_1_0= ruleMinLengthValidator )
                    {
                    // PsiInternalJDL.g:1533:4: (lv_minLength_1_0= ruleMinLengthValidator )
                    // PsiInternalJDL.g:1534:5: lv_minLength_1_0= ruleMinLengthValidator
                    {

                    					markComposite(elementTypeProvider.getStringValidators_MinLengthMinLengthValidatorParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FOLLOW_25);
                    lv_minLength_1_0=ruleMinLengthValidator();

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

            // PsiInternalJDL.g:1547:3: ( (lv_maxlength_2_0= ruleMaxLengthValidator ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==31) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // PsiInternalJDL.g:1548:4: (lv_maxlength_2_0= ruleMaxLengthValidator )
                    {
                    // PsiInternalJDL.g:1548:4: (lv_maxlength_2_0= ruleMaxLengthValidator )
                    // PsiInternalJDL.g:1549:5: lv_maxlength_2_0= ruleMaxLengthValidator
                    {

                    					markComposite(elementTypeProvider.getStringValidators_MaxlengthMaxLengthValidatorParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FOLLOW_26);
                    lv_maxlength_2_0=ruleMaxLengthValidator();

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

            // PsiInternalJDL.g:1562:3: ( (lv_pattern_3_0= rulePatternValidator ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==32) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // PsiInternalJDL.g:1563:4: (lv_pattern_3_0= rulePatternValidator )
                    {
                    // PsiInternalJDL.g:1563:4: (lv_pattern_3_0= rulePatternValidator )
                    // PsiInternalJDL.g:1564:5: lv_pattern_3_0= rulePatternValidator
                    {

                    					markComposite(elementTypeProvider.getStringValidators_PatternPatternValidatorParserRuleCall_3_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_pattern_3_0=rulePatternValidator();

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
    // $ANTLR end "ruleStringValidators"


    // $ANTLR start "entryRuleNumericValidators"
    // PsiInternalJDL.g:1581:1: entryRuleNumericValidators returns [Boolean current=false] : iv_ruleNumericValidators= ruleNumericValidators EOF ;
    public final Boolean entryRuleNumericValidators() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNumericValidators = null;


        try {
            // PsiInternalJDL.g:1581:59: (iv_ruleNumericValidators= ruleNumericValidators EOF )
            // PsiInternalJDL.g:1582:2: iv_ruleNumericValidators= ruleNumericValidators EOF
            {
             markComposite(elementTypeProvider.getNumericValidatorsElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumericValidators=ruleNumericValidators();

            state._fsp--;

             current =iv_ruleNumericValidators; 
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
    // $ANTLR end "entryRuleNumericValidators"


    // $ANTLR start "ruleNumericValidators"
    // PsiInternalJDL.g:1588:1: ruleNumericValidators returns [Boolean current=false] : ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minlength_1_0= ruleMinValidator ) )? ( (lv_maxlength_2_0= ruleMaxValidator ) )? ) ;
    public final Boolean ruleNumericValidators() throws RecognitionException {
        Boolean current = false;

        Boolean lv_required_0_0 = null;

        Boolean lv_minlength_1_0 = null;

        Boolean lv_maxlength_2_0 = null;


        try {
            // PsiInternalJDL.g:1589:1: ( ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minlength_1_0= ruleMinValidator ) )? ( (lv_maxlength_2_0= ruleMaxValidator ) )? ) )
            // PsiInternalJDL.g:1590:2: ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minlength_1_0= ruleMinValidator ) )? ( (lv_maxlength_2_0= ruleMaxValidator ) )? )
            {
            // PsiInternalJDL.g:1590:2: ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minlength_1_0= ruleMinValidator ) )? ( (lv_maxlength_2_0= ruleMaxValidator ) )? )
            // PsiInternalJDL.g:1591:3: ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minlength_1_0= ruleMinValidator ) )? ( (lv_maxlength_2_0= ruleMaxValidator ) )?
            {
            // PsiInternalJDL.g:1591:3: ( (lv_required_0_0= ruleRequiredValidator ) )
            // PsiInternalJDL.g:1592:4: (lv_required_0_0= ruleRequiredValidator )
            {
            // PsiInternalJDL.g:1592:4: (lv_required_0_0= ruleRequiredValidator )
            // PsiInternalJDL.g:1593:5: lv_required_0_0= ruleRequiredValidator
            {

            					markComposite(elementTypeProvider.getNumericValidators_RequiredRequiredValidatorParserRuleCall_0_0ElementType());
            				
            pushFollow(FOLLOW_27);
            lv_required_0_0=ruleRequiredValidator();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalJDL.g:1606:3: ( (lv_minlength_1_0= ruleMinValidator ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==33) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // PsiInternalJDL.g:1607:4: (lv_minlength_1_0= ruleMinValidator )
                    {
                    // PsiInternalJDL.g:1607:4: (lv_minlength_1_0= ruleMinValidator )
                    // PsiInternalJDL.g:1608:5: lv_minlength_1_0= ruleMinValidator
                    {

                    					markComposite(elementTypeProvider.getNumericValidators_MinlengthMinValidatorParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FOLLOW_28);
                    lv_minlength_1_0=ruleMinValidator();

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

            // PsiInternalJDL.g:1621:3: ( (lv_maxlength_2_0= ruleMaxValidator ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==34) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // PsiInternalJDL.g:1622:4: (lv_maxlength_2_0= ruleMaxValidator )
                    {
                    // PsiInternalJDL.g:1622:4: (lv_maxlength_2_0= ruleMaxValidator )
                    // PsiInternalJDL.g:1623:5: lv_maxlength_2_0= ruleMaxValidator
                    {

                    					markComposite(elementTypeProvider.getNumericValidators_MaxlengthMaxValidatorParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_maxlength_2_0=ruleMaxValidator();

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
    // $ANTLR end "ruleNumericValidators"


    // $ANTLR start "entryRuleBlobValidators"
    // PsiInternalJDL.g:1640:1: entryRuleBlobValidators returns [Boolean current=false] : iv_ruleBlobValidators= ruleBlobValidators EOF ;
    public final Boolean entryRuleBlobValidators() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleBlobValidators = null;


        try {
            // PsiInternalJDL.g:1640:56: (iv_ruleBlobValidators= ruleBlobValidators EOF )
            // PsiInternalJDL.g:1641:2: iv_ruleBlobValidators= ruleBlobValidators EOF
            {
             markComposite(elementTypeProvider.getBlobValidatorsElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleBlobValidators=ruleBlobValidators();

            state._fsp--;

             current =iv_ruleBlobValidators; 
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
    // $ANTLR end "entryRuleBlobValidators"


    // $ANTLR start "ruleBlobValidators"
    // PsiInternalJDL.g:1647:1: ruleBlobValidators returns [Boolean current=false] : ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minbytes_1_0= ruleMinBytesValidator ) )? ( (lv_maxbytes_2_0= ruleMaxBytesValidator ) )? ) ;
    public final Boolean ruleBlobValidators() throws RecognitionException {
        Boolean current = false;

        Boolean lv_required_0_0 = null;

        Boolean lv_minbytes_1_0 = null;

        Boolean lv_maxbytes_2_0 = null;


        try {
            // PsiInternalJDL.g:1648:1: ( ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minbytes_1_0= ruleMinBytesValidator ) )? ( (lv_maxbytes_2_0= ruleMaxBytesValidator ) )? ) )
            // PsiInternalJDL.g:1649:2: ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minbytes_1_0= ruleMinBytesValidator ) )? ( (lv_maxbytes_2_0= ruleMaxBytesValidator ) )? )
            {
            // PsiInternalJDL.g:1649:2: ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minbytes_1_0= ruleMinBytesValidator ) )? ( (lv_maxbytes_2_0= ruleMaxBytesValidator ) )? )
            // PsiInternalJDL.g:1650:3: ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minbytes_1_0= ruleMinBytesValidator ) )? ( (lv_maxbytes_2_0= ruleMaxBytesValidator ) )?
            {
            // PsiInternalJDL.g:1650:3: ( (lv_required_0_0= ruleRequiredValidator ) )
            // PsiInternalJDL.g:1651:4: (lv_required_0_0= ruleRequiredValidator )
            {
            // PsiInternalJDL.g:1651:4: (lv_required_0_0= ruleRequiredValidator )
            // PsiInternalJDL.g:1652:5: lv_required_0_0= ruleRequiredValidator
            {

            					markComposite(elementTypeProvider.getBlobValidators_RequiredRequiredValidatorParserRuleCall_0_0ElementType());
            				
            pushFollow(FOLLOW_29);
            lv_required_0_0=ruleRequiredValidator();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalJDL.g:1665:3: ( (lv_minbytes_1_0= ruleMinBytesValidator ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==35) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // PsiInternalJDL.g:1666:4: (lv_minbytes_1_0= ruleMinBytesValidator )
                    {
                    // PsiInternalJDL.g:1666:4: (lv_minbytes_1_0= ruleMinBytesValidator )
                    // PsiInternalJDL.g:1667:5: lv_minbytes_1_0= ruleMinBytesValidator
                    {

                    					markComposite(elementTypeProvider.getBlobValidators_MinbytesMinBytesValidatorParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FOLLOW_30);
                    lv_minbytes_1_0=ruleMinBytesValidator();

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

            // PsiInternalJDL.g:1680:3: ( (lv_maxbytes_2_0= ruleMaxBytesValidator ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==36) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // PsiInternalJDL.g:1681:4: (lv_maxbytes_2_0= ruleMaxBytesValidator )
                    {
                    // PsiInternalJDL.g:1681:4: (lv_maxbytes_2_0= ruleMaxBytesValidator )
                    // PsiInternalJDL.g:1682:5: lv_maxbytes_2_0= ruleMaxBytesValidator
                    {

                    					markComposite(elementTypeProvider.getBlobValidators_MaxbytesMaxBytesValidatorParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_maxbytes_2_0=ruleMaxBytesValidator();

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
    // $ANTLR end "ruleBlobValidators"


    // $ANTLR start "entryRuleRelationships"
    // PsiInternalJDL.g:1699:1: entryRuleRelationships returns [Boolean current=false] : iv_ruleRelationships= ruleRelationships EOF ;
    public final Boolean entryRuleRelationships() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleRelationships = null;


        try {
            // PsiInternalJDL.g:1699:55: (iv_ruleRelationships= ruleRelationships EOF )
            // PsiInternalJDL.g:1700:2: iv_ruleRelationships= ruleRelationships EOF
            {
             markComposite(elementTypeProvider.getRelationshipsElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleRelationships=ruleRelationships();

            state._fsp--;

             current =iv_ruleRelationships; 
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
    // $ANTLR end "entryRuleRelationships"


    // $ANTLR start "ruleRelationships"
    // PsiInternalJDL.g:1706:1: ruleRelationships returns [Boolean current=false] : (otherlv_0= 'relationship' ( (lv_cardinality_1_0= ruleCardinality ) ) otherlv_2= '{' ( (lv_relationships_3_0= ruleRelationship ) )* otherlv_4= '}' ) ;
    public final Boolean ruleRelationships() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Boolean lv_cardinality_1_0 = null;

        Boolean lv_relationships_3_0 = null;


        try {
            // PsiInternalJDL.g:1707:1: ( (otherlv_0= 'relationship' ( (lv_cardinality_1_0= ruleCardinality ) ) otherlv_2= '{' ( (lv_relationships_3_0= ruleRelationship ) )* otherlv_4= '}' ) )
            // PsiInternalJDL.g:1708:2: (otherlv_0= 'relationship' ( (lv_cardinality_1_0= ruleCardinality ) ) otherlv_2= '{' ( (lv_relationships_3_0= ruleRelationship ) )* otherlv_4= '}' )
            {
            // PsiInternalJDL.g:1708:2: (otherlv_0= 'relationship' ( (lv_cardinality_1_0= ruleCardinality ) ) otherlv_2= '{' ( (lv_relationships_3_0= ruleRelationship ) )* otherlv_4= '}' )
            // PsiInternalJDL.g:1709:3: otherlv_0= 'relationship' ( (lv_cardinality_1_0= ruleCardinality ) ) otherlv_2= '{' ( (lv_relationships_3_0= ruleRelationship ) )* otherlv_4= '}'
            {

            			markLeaf(elementTypeProvider.getRelationships_RelationshipKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,37,FOLLOW_31); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalJDL.g:1716:3: ( (lv_cardinality_1_0= ruleCardinality ) )
            // PsiInternalJDL.g:1717:4: (lv_cardinality_1_0= ruleCardinality )
            {
            // PsiInternalJDL.g:1717:4: (lv_cardinality_1_0= ruleCardinality )
            // PsiInternalJDL.g:1718:5: lv_cardinality_1_0= ruleCardinality
            {

            					markComposite(elementTypeProvider.getRelationships_CardinalityCardinalityEnumRuleCall_1_0ElementType());
            				
            pushFollow(FOLLOW_5);
            lv_cardinality_1_0=ruleCardinality();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }


            			markLeaf(elementTypeProvider.getRelationships_LeftCurlyBracketKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_32); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalJDL.g:1738:3: ( (lv_relationships_3_0= ruleRelationship ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_ID) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // PsiInternalJDL.g:1739:4: (lv_relationships_3_0= ruleRelationship )
            	    {
            	    // PsiInternalJDL.g:1739:4: (lv_relationships_3_0= ruleRelationship )
            	    // PsiInternalJDL.g:1740:5: lv_relationships_3_0= ruleRelationship
            	    {

            	    					markComposite(elementTypeProvider.getRelationships_RelationshipsRelationshipParserRuleCall_3_0ElementType());
            	    				
            	    pushFollow(FOLLOW_32);
            	    lv_relationships_3_0=ruleRelationship();

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
            	    break loop28;
                }
            } while (true);


            			markLeaf(elementTypeProvider.getRelationships_RightCurlyBracketKeyword_4ElementType());
            		
            otherlv_4=(Token)match(input,14,FOLLOW_2); 

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
    // $ANTLR end "ruleRelationships"


    // $ANTLR start "entryRuleRelationship"
    // PsiInternalJDL.g:1764:1: entryRuleRelationship returns [Boolean current=false] : iv_ruleRelationship= ruleRelationship EOF ;
    public final Boolean entryRuleRelationship() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleRelationship = null;


        try {
            // PsiInternalJDL.g:1764:54: (iv_ruleRelationship= ruleRelationship EOF )
            // PsiInternalJDL.g:1765:2: iv_ruleRelationship= ruleRelationship EOF
            {
             markComposite(elementTypeProvider.getRelationshipElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleRelationship=ruleRelationship();

            state._fsp--;

             current =iv_ruleRelationship; 
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
    // $ANTLR end "entryRuleRelationship"


    // $ANTLR start "ruleRelationship"
    // PsiInternalJDL.g:1771:1: ruleRelationship returns [Boolean current=false] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_fromName_1_0= ruleRelationshipName ) )? otherlv_2= 'to' ( (otherlv_3= RULE_ID ) ) ( (lv_toName_4_0= ruleRelationshipName ) )? ) ;
    public final Boolean ruleRelationship() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Boolean lv_fromName_1_0 = null;

        Boolean lv_toName_4_0 = null;


        try {
            // PsiInternalJDL.g:1772:1: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_fromName_1_0= ruleRelationshipName ) )? otherlv_2= 'to' ( (otherlv_3= RULE_ID ) ) ( (lv_toName_4_0= ruleRelationshipName ) )? ) )
            // PsiInternalJDL.g:1773:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_fromName_1_0= ruleRelationshipName ) )? otherlv_2= 'to' ( (otherlv_3= RULE_ID ) ) ( (lv_toName_4_0= ruleRelationshipName ) )? )
            {
            // PsiInternalJDL.g:1773:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_fromName_1_0= ruleRelationshipName ) )? otherlv_2= 'to' ( (otherlv_3= RULE_ID ) ) ( (lv_toName_4_0= ruleRelationshipName ) )? )
            // PsiInternalJDL.g:1774:3: ( (otherlv_0= RULE_ID ) ) ( (lv_fromName_1_0= ruleRelationshipName ) )? otherlv_2= 'to' ( (otherlv_3= RULE_ID ) ) ( (lv_toName_4_0= ruleRelationshipName ) )?
            {
            // PsiInternalJDL.g:1774:3: ( (otherlv_0= RULE_ID ) )
            // PsiInternalJDL.g:1775:4: (otherlv_0= RULE_ID )
            {
            // PsiInternalJDL.g:1775:4: (otherlv_0= RULE_ID )
            // PsiInternalJDL.g:1776:5: otherlv_0= RULE_ID
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					markLeaf(elementTypeProvider.getRelationship_FromEntityEntityCrossReference_0_0ElementType());
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_33); 

            					doneLeaf(otherlv_0);
            				

            }


            }

            // PsiInternalJDL.g:1791:3: ( (lv_fromName_1_0= ruleRelationshipName ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==12) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // PsiInternalJDL.g:1792:4: (lv_fromName_1_0= ruleRelationshipName )
                    {
                    // PsiInternalJDL.g:1792:4: (lv_fromName_1_0= ruleRelationshipName )
                    // PsiInternalJDL.g:1793:5: lv_fromName_1_0= ruleRelationshipName
                    {

                    					markComposite(elementTypeProvider.getRelationship_FromNameRelationshipNameParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FOLLOW_34);
                    lv_fromName_1_0=ruleRelationshipName();

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


            			markLeaf(elementTypeProvider.getRelationship_ToKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,38,FOLLOW_4); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalJDL.g:1813:3: ( (otherlv_3= RULE_ID ) )
            // PsiInternalJDL.g:1814:4: (otherlv_3= RULE_ID )
            {
            // PsiInternalJDL.g:1814:4: (otherlv_3= RULE_ID )
            // PsiInternalJDL.g:1815:5: otherlv_3= RULE_ID
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					markLeaf(elementTypeProvider.getRelationship_ToEntityEntityCrossReference_3_0ElementType());
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_35); 

            					doneLeaf(otherlv_3);
            				

            }


            }

            // PsiInternalJDL.g:1830:3: ( (lv_toName_4_0= ruleRelationshipName ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==12) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // PsiInternalJDL.g:1831:4: (lv_toName_4_0= ruleRelationshipName )
                    {
                    // PsiInternalJDL.g:1831:4: (lv_toName_4_0= ruleRelationshipName )
                    // PsiInternalJDL.g:1832:5: lv_toName_4_0= ruleRelationshipName
                    {

                    					markComposite(elementTypeProvider.getRelationship_ToNameRelationshipNameParserRuleCall_4_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_toName_4_0=ruleRelationshipName();

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
    // $ANTLR end "ruleRelationship"


    // $ANTLR start "entryRuleRelationshipName"
    // PsiInternalJDL.g:1849:1: entryRuleRelationshipName returns [Boolean current=false] : iv_ruleRelationshipName= ruleRelationshipName EOF ;
    public final Boolean entryRuleRelationshipName() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleRelationshipName = null;


        try {
            // PsiInternalJDL.g:1849:58: (iv_ruleRelationshipName= ruleRelationshipName EOF )
            // PsiInternalJDL.g:1850:2: iv_ruleRelationshipName= ruleRelationshipName EOF
            {
             markComposite(elementTypeProvider.getRelationshipNameElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleRelationshipName=ruleRelationshipName();

            state._fsp--;

             current =iv_ruleRelationshipName; 
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
    // $ANTLR end "entryRuleRelationshipName"


    // $ANTLR start "ruleRelationshipName"
    // PsiInternalJDL.g:1856:1: ruleRelationshipName returns [Boolean current=false] : (otherlv_0= '{' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_role_3_0= RULE_ID ) ) otherlv_4= ')' )? otherlv_5= '}' ) ;
    public final Boolean ruleRelationshipName() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_role_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;

        try {
            // PsiInternalJDL.g:1857:1: ( (otherlv_0= '{' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_role_3_0= RULE_ID ) ) otherlv_4= ')' )? otherlv_5= '}' ) )
            // PsiInternalJDL.g:1858:2: (otherlv_0= '{' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_role_3_0= RULE_ID ) ) otherlv_4= ')' )? otherlv_5= '}' )
            {
            // PsiInternalJDL.g:1858:2: (otherlv_0= '{' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_role_3_0= RULE_ID ) ) otherlv_4= ')' )? otherlv_5= '}' )
            // PsiInternalJDL.g:1859:3: otherlv_0= '{' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_role_3_0= RULE_ID ) ) otherlv_4= ')' )? otherlv_5= '}'
            {

            			markLeaf(elementTypeProvider.getRelationshipName_LeftCurlyBracketKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,12,FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalJDL.g:1866:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalJDL.g:1867:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalJDL.g:1867:4: (lv_name_1_0= RULE_ID )
            // PsiInternalJDL.g:1868:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getRelationshipName_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_36); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_1_0);
            				

            }


            }

            // PsiInternalJDL.g:1883:3: (otherlv_2= '(' ( (lv_role_3_0= RULE_ID ) ) otherlv_4= ')' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==29) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // PsiInternalJDL.g:1884:4: otherlv_2= '(' ( (lv_role_3_0= RULE_ID ) ) otherlv_4= ')'
                    {

                    				markLeaf(elementTypeProvider.getRelationshipName_LeftParenthesisKeyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,29,FOLLOW_4); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalJDL.g:1891:4: ( (lv_role_3_0= RULE_ID ) )
                    // PsiInternalJDL.g:1892:5: (lv_role_3_0= RULE_ID )
                    {
                    // PsiInternalJDL.g:1892:5: (lv_role_3_0= RULE_ID )
                    // PsiInternalJDL.g:1893:6: lv_role_3_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getRelationshipName_RoleIDTerminalRuleCall_2_1_0ElementType());
                    					
                    lv_role_3_0=(Token)match(input,RULE_ID,FOLLOW_22); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						doneLeaf(lv_role_3_0);
                    					

                    }


                    }


                    				markLeaf(elementTypeProvider.getRelationshipName_RightParenthesisKeyword_2_2ElementType());
                    			
                    otherlv_4=(Token)match(input,30,FOLLOW_37); 

                    				doneLeaf(otherlv_4);
                    			

                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getRelationshipName_RightCurlyBracketKeyword_3ElementType());
            		
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
    // $ANTLR end "ruleRelationshipName"


    // $ANTLR start "entryRuleEnumType"
    // PsiInternalJDL.g:1927:1: entryRuleEnumType returns [Boolean current=false] : iv_ruleEnumType= ruleEnumType EOF ;
    public final Boolean entryRuleEnumType() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleEnumType = null;


        try {
            // PsiInternalJDL.g:1927:50: (iv_ruleEnumType= ruleEnumType EOF )
            // PsiInternalJDL.g:1928:2: iv_ruleEnumType= ruleEnumType EOF
            {
             markComposite(elementTypeProvider.getEnumTypeElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumType=ruleEnumType();

            state._fsp--;

             current =iv_ruleEnumType; 
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
    // $ANTLR end "entryRuleEnumType"


    // $ANTLR start "ruleEnumType"
    // PsiInternalJDL.g:1934:1: ruleEnumType returns [Boolean current=false] : (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_values_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_values_5_0= RULE_ID ) ) )* otherlv_6= '}' ) ;
    public final Boolean ruleEnumType() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_values_3_0=null;
        Token otherlv_4=null;
        Token lv_values_5_0=null;
        Token otherlv_6=null;

        try {
            // PsiInternalJDL.g:1935:1: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_values_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_values_5_0= RULE_ID ) ) )* otherlv_6= '}' ) )
            // PsiInternalJDL.g:1936:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_values_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_values_5_0= RULE_ID ) ) )* otherlv_6= '}' )
            {
            // PsiInternalJDL.g:1936:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_values_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_values_5_0= RULE_ID ) ) )* otherlv_6= '}' )
            // PsiInternalJDL.g:1937:3: otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_values_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_values_5_0= RULE_ID ) ) )* otherlv_6= '}'
            {

            			markLeaf(elementTypeProvider.getEnumType_EnumKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,39,FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalJDL.g:1944:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalJDL.g:1945:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalJDL.g:1945:4: (lv_name_1_0= RULE_ID )
            // PsiInternalJDL.g:1946:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getEnumType_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getEnumType_LeftCurlyBracketKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_4); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalJDL.g:1968:3: ( (lv_values_3_0= RULE_ID ) )
            // PsiInternalJDL.g:1969:4: (lv_values_3_0= RULE_ID )
            {
            // PsiInternalJDL.g:1969:4: (lv_values_3_0= RULE_ID )
            // PsiInternalJDL.g:1970:5: lv_values_3_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getEnumType_ValuesIDTerminalRuleCall_3_0ElementType());
            				
            lv_values_3_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_values_3_0);
            				

            }


            }

            // PsiInternalJDL.g:1985:3: (otherlv_4= ',' ( (lv_values_5_0= RULE_ID ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==13) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // PsiInternalJDL.g:1986:4: otherlv_4= ',' ( (lv_values_5_0= RULE_ID ) )
            	    {

            	    				markLeaf(elementTypeProvider.getEnumType_CommaKeyword_4_0ElementType());
            	    			
            	    otherlv_4=(Token)match(input,13,FOLLOW_4); 

            	    				doneLeaf(otherlv_4);
            	    			
            	    // PsiInternalJDL.g:1993:4: ( (lv_values_5_0= RULE_ID ) )
            	    // PsiInternalJDL.g:1994:5: (lv_values_5_0= RULE_ID )
            	    {
            	    // PsiInternalJDL.g:1994:5: (lv_values_5_0= RULE_ID )
            	    // PsiInternalJDL.g:1995:6: lv_values_5_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getEnumType_ValuesIDTerminalRuleCall_4_1_0ElementType());
            	    					
            	    lv_values_5_0=(Token)match(input,RULE_ID,FOLLOW_6); 

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
            	    break loop32;
                }
            } while (true);


            			markLeaf(elementTypeProvider.getEnumType_RightCurlyBracketKeyword_5ElementType());
            		
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
    // $ANTLR end "ruleEnumType"


    // $ANTLR start "entryRuleGenerationSetting"
    // PsiInternalJDL.g:2022:1: entryRuleGenerationSetting returns [Boolean current=false] : iv_ruleGenerationSetting= ruleGenerationSetting EOF ;
    public final Boolean entryRuleGenerationSetting() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleGenerationSetting = null;


        try {
            // PsiInternalJDL.g:2022:59: (iv_ruleGenerationSetting= ruleGenerationSetting EOF )
            // PsiInternalJDL.g:2023:2: iv_ruleGenerationSetting= ruleGenerationSetting EOF
            {
             markComposite(elementTypeProvider.getGenerationSettingElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleGenerationSetting=ruleGenerationSetting();

            state._fsp--;

             current =iv_ruleGenerationSetting; 
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
    // $ANTLR end "entryRuleGenerationSetting"


    // $ANTLR start "ruleGenerationSetting"
    // PsiInternalJDL.g:2029:1: ruleGenerationSetting returns [Boolean current=false] : (this_ServiceGenerationSetting_0= ruleServiceGenerationSetting | this_DTOGenerationSetting_1= ruleDTOGenerationSetting | this_PaginateGenerationSetting_2= rulePaginateGenerationSetting | this_AngularSuffixGenerationSetting_3= ruleAngularSuffixGenerationSetting ) ;
    public final Boolean ruleGenerationSetting() throws RecognitionException {
        Boolean current = false;

        Boolean this_ServiceGenerationSetting_0 = null;

        Boolean this_DTOGenerationSetting_1 = null;

        Boolean this_PaginateGenerationSetting_2 = null;

        Boolean this_AngularSuffixGenerationSetting_3 = null;


        try {
            // PsiInternalJDL.g:2030:1: ( (this_ServiceGenerationSetting_0= ruleServiceGenerationSetting | this_DTOGenerationSetting_1= ruleDTOGenerationSetting | this_PaginateGenerationSetting_2= rulePaginateGenerationSetting | this_AngularSuffixGenerationSetting_3= ruleAngularSuffixGenerationSetting ) )
            // PsiInternalJDL.g:2031:2: (this_ServiceGenerationSetting_0= ruleServiceGenerationSetting | this_DTOGenerationSetting_1= ruleDTOGenerationSetting | this_PaginateGenerationSetting_2= rulePaginateGenerationSetting | this_AngularSuffixGenerationSetting_3= ruleAngularSuffixGenerationSetting )
            {
            // PsiInternalJDL.g:2031:2: (this_ServiceGenerationSetting_0= ruleServiceGenerationSetting | this_DTOGenerationSetting_1= ruleDTOGenerationSetting | this_PaginateGenerationSetting_2= rulePaginateGenerationSetting | this_AngularSuffixGenerationSetting_3= ruleAngularSuffixGenerationSetting )
            int alt33=4;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt33=1;
                }
                break;
            case 42:
                {
                alt33=2;
                }
                break;
            case 43:
                {
                alt33=3;
                }
                break;
            case 46:
                {
                alt33=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // PsiInternalJDL.g:2032:3: this_ServiceGenerationSetting_0= ruleServiceGenerationSetting
                    {

                    			markComposite(elementTypeProvider.getGenerationSetting_ServiceGenerationSettingParserRuleCall_0ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_ServiceGenerationSetting_0=ruleServiceGenerationSetting();

                    state._fsp--;


                    			current = this_ServiceGenerationSetting_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalJDL.g:2041:3: this_DTOGenerationSetting_1= ruleDTOGenerationSetting
                    {

                    			markComposite(elementTypeProvider.getGenerationSetting_DTOGenerationSettingParserRuleCall_1ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_DTOGenerationSetting_1=ruleDTOGenerationSetting();

                    state._fsp--;


                    			current = this_DTOGenerationSetting_1;
                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalJDL.g:2050:3: this_PaginateGenerationSetting_2= rulePaginateGenerationSetting
                    {

                    			markComposite(elementTypeProvider.getGenerationSetting_PaginateGenerationSettingParserRuleCall_2ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_PaginateGenerationSetting_2=rulePaginateGenerationSetting();

                    state._fsp--;


                    			current = this_PaginateGenerationSetting_2;
                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // PsiInternalJDL.g:2059:3: this_AngularSuffixGenerationSetting_3= ruleAngularSuffixGenerationSetting
                    {

                    			markComposite(elementTypeProvider.getGenerationSetting_AngularSuffixGenerationSettingParserRuleCall_3ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_AngularSuffixGenerationSetting_3=ruleAngularSuffixGenerationSetting();

                    state._fsp--;


                    			current = this_AngularSuffixGenerationSetting_3;
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
    // $ANTLR end "ruleGenerationSetting"


    // $ANTLR start "entryRuleServiceGenerationSetting"
    // PsiInternalJDL.g:2071:1: entryRuleServiceGenerationSetting returns [Boolean current=false] : iv_ruleServiceGenerationSetting= ruleServiceGenerationSetting EOF ;
    public final Boolean entryRuleServiceGenerationSetting() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleServiceGenerationSetting = null;


        try {
            // PsiInternalJDL.g:2071:66: (iv_ruleServiceGenerationSetting= ruleServiceGenerationSetting EOF )
            // PsiInternalJDL.g:2072:2: iv_ruleServiceGenerationSetting= ruleServiceGenerationSetting EOF
            {
             markComposite(elementTypeProvider.getServiceGenerationSettingElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleServiceGenerationSetting=ruleServiceGenerationSetting();

            state._fsp--;

             current =iv_ruleServiceGenerationSetting; 
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
    // $ANTLR end "entryRuleServiceGenerationSetting"


    // $ANTLR start "ruleServiceGenerationSetting"
    // PsiInternalJDL.g:2078:1: ruleServiceGenerationSetting returns [Boolean current=false] : (otherlv_0= 'service' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_serviceType_5_0= ruleServiceType ) ) ) ;
    public final Boolean ruleServiceGenerationSetting() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Boolean lv_serviceType_5_0 = null;


        try {
            // PsiInternalJDL.g:2079:1: ( (otherlv_0= 'service' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_serviceType_5_0= ruleServiceType ) ) ) )
            // PsiInternalJDL.g:2080:2: (otherlv_0= 'service' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_serviceType_5_0= ruleServiceType ) ) )
            {
            // PsiInternalJDL.g:2080:2: (otherlv_0= 'service' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_serviceType_5_0= ruleServiceType ) ) )
            // PsiInternalJDL.g:2081:3: otherlv_0= 'service' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_serviceType_5_0= ruleServiceType ) )
            {

            			markLeaf(elementTypeProvider.getServiceGenerationSetting_ServiceKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,40,FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalJDL.g:2088:3: ( (otherlv_1= RULE_ID ) )
            // PsiInternalJDL.g:2089:4: (otherlv_1= RULE_ID )
            {
            // PsiInternalJDL.g:2089:4: (otherlv_1= RULE_ID )
            // PsiInternalJDL.g:2090:5: otherlv_1= RULE_ID
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					markLeaf(elementTypeProvider.getServiceGenerationSetting_EntitiesEntityCrossReference_1_0ElementType());
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_38); 

            					doneLeaf(otherlv_1);
            				

            }


            }

            // PsiInternalJDL.g:2105:3: (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==13) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // PsiInternalJDL.g:2106:4: otherlv_2= ',' ( (otherlv_3= RULE_ID ) )
            	    {

            	    				markLeaf(elementTypeProvider.getServiceGenerationSetting_CommaKeyword_2_0ElementType());
            	    			
            	    otherlv_2=(Token)match(input,13,FOLLOW_4); 

            	    				doneLeaf(otherlv_2);
            	    			
            	    // PsiInternalJDL.g:2113:4: ( (otherlv_3= RULE_ID ) )
            	    // PsiInternalJDL.g:2114:5: (otherlv_3= RULE_ID )
            	    {
            	    // PsiInternalJDL.g:2114:5: (otherlv_3= RULE_ID )
            	    // PsiInternalJDL.g:2115:6: otherlv_3= RULE_ID
            	    {

            	    						if (!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

            	    						markLeaf(elementTypeProvider.getServiceGenerationSetting_EntitiesEntityCrossReference_2_1_0ElementType());
            	    					
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_38); 

            	    						doneLeaf(otherlv_3);
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


            			markLeaf(elementTypeProvider.getServiceGenerationSetting_WithKeyword_3ElementType());
            		
            otherlv_4=(Token)match(input,41,FOLLOW_39); 

            			doneLeaf(otherlv_4);
            		
            // PsiInternalJDL.g:2138:3: ( (lv_serviceType_5_0= ruleServiceType ) )
            // PsiInternalJDL.g:2139:4: (lv_serviceType_5_0= ruleServiceType )
            {
            // PsiInternalJDL.g:2139:4: (lv_serviceType_5_0= ruleServiceType )
            // PsiInternalJDL.g:2140:5: lv_serviceType_5_0= ruleServiceType
            {

            					markComposite(elementTypeProvider.getServiceGenerationSetting_ServiceTypeServiceTypeEnumRuleCall_4_0ElementType());
            				
            pushFollow(FOLLOW_2);
            lv_serviceType_5_0=ruleServiceType();

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
    // $ANTLR end "ruleServiceGenerationSetting"


    // $ANTLR start "entryRuleDTOGenerationSetting"
    // PsiInternalJDL.g:2157:1: entryRuleDTOGenerationSetting returns [Boolean current=false] : iv_ruleDTOGenerationSetting= ruleDTOGenerationSetting EOF ;
    public final Boolean entryRuleDTOGenerationSetting() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDTOGenerationSetting = null;


        try {
            // PsiInternalJDL.g:2157:62: (iv_ruleDTOGenerationSetting= ruleDTOGenerationSetting EOF )
            // PsiInternalJDL.g:2158:2: iv_ruleDTOGenerationSetting= ruleDTOGenerationSetting EOF
            {
             markComposite(elementTypeProvider.getDTOGenerationSettingElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleDTOGenerationSetting=ruleDTOGenerationSetting();

            state._fsp--;

             current =iv_ruleDTOGenerationSetting; 
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
    // $ANTLR end "entryRuleDTOGenerationSetting"


    // $ANTLR start "ruleDTOGenerationSetting"
    // PsiInternalJDL.g:2164:1: ruleDTOGenerationSetting returns [Boolean current=false] : (otherlv_0= 'dto' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_dtoType_5_0= ruleDTOType ) ) ) ;
    public final Boolean ruleDTOGenerationSetting() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Boolean lv_dtoType_5_0 = null;


        try {
            // PsiInternalJDL.g:2165:1: ( (otherlv_0= 'dto' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_dtoType_5_0= ruleDTOType ) ) ) )
            // PsiInternalJDL.g:2166:2: (otherlv_0= 'dto' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_dtoType_5_0= ruleDTOType ) ) )
            {
            // PsiInternalJDL.g:2166:2: (otherlv_0= 'dto' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_dtoType_5_0= ruleDTOType ) ) )
            // PsiInternalJDL.g:2167:3: otherlv_0= 'dto' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_dtoType_5_0= ruleDTOType ) )
            {

            			markLeaf(elementTypeProvider.getDTOGenerationSetting_DtoKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,42,FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalJDL.g:2174:3: ( (otherlv_1= RULE_ID ) )
            // PsiInternalJDL.g:2175:4: (otherlv_1= RULE_ID )
            {
            // PsiInternalJDL.g:2175:4: (otherlv_1= RULE_ID )
            // PsiInternalJDL.g:2176:5: otherlv_1= RULE_ID
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					markLeaf(elementTypeProvider.getDTOGenerationSetting_EntitiesEntityCrossReference_1_0ElementType());
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_38); 

            					doneLeaf(otherlv_1);
            				

            }


            }

            // PsiInternalJDL.g:2191:3: (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==13) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // PsiInternalJDL.g:2192:4: otherlv_2= ',' ( (otherlv_3= RULE_ID ) )
            	    {

            	    				markLeaf(elementTypeProvider.getDTOGenerationSetting_CommaKeyword_2_0ElementType());
            	    			
            	    otherlv_2=(Token)match(input,13,FOLLOW_4); 

            	    				doneLeaf(otherlv_2);
            	    			
            	    // PsiInternalJDL.g:2199:4: ( (otherlv_3= RULE_ID ) )
            	    // PsiInternalJDL.g:2200:5: (otherlv_3= RULE_ID )
            	    {
            	    // PsiInternalJDL.g:2200:5: (otherlv_3= RULE_ID )
            	    // PsiInternalJDL.g:2201:6: otherlv_3= RULE_ID
            	    {

            	    						if (!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

            	    						markLeaf(elementTypeProvider.getDTOGenerationSetting_EntitiesEntityCrossReference_2_1_0ElementType());
            	    					
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_38); 

            	    						doneLeaf(otherlv_3);
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            			markLeaf(elementTypeProvider.getDTOGenerationSetting_WithKeyword_3ElementType());
            		
            otherlv_4=(Token)match(input,41,FOLLOW_40); 

            			doneLeaf(otherlv_4);
            		
            // PsiInternalJDL.g:2224:3: ( (lv_dtoType_5_0= ruleDTOType ) )
            // PsiInternalJDL.g:2225:4: (lv_dtoType_5_0= ruleDTOType )
            {
            // PsiInternalJDL.g:2225:4: (lv_dtoType_5_0= ruleDTOType )
            // PsiInternalJDL.g:2226:5: lv_dtoType_5_0= ruleDTOType
            {

            					markComposite(elementTypeProvider.getDTOGenerationSetting_DtoTypeDTOTypeEnumRuleCall_4_0ElementType());
            				
            pushFollow(FOLLOW_2);
            lv_dtoType_5_0=ruleDTOType();

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
    // $ANTLR end "ruleDTOGenerationSetting"


    // $ANTLR start "entryRulePaginateGenerationSetting"
    // PsiInternalJDL.g:2243:1: entryRulePaginateGenerationSetting returns [Boolean current=false] : iv_rulePaginateGenerationSetting= rulePaginateGenerationSetting EOF ;
    public final Boolean entryRulePaginateGenerationSetting() throws RecognitionException {
        Boolean current = false;

        Boolean iv_rulePaginateGenerationSetting = null;


        try {
            // PsiInternalJDL.g:2243:67: (iv_rulePaginateGenerationSetting= rulePaginateGenerationSetting EOF )
            // PsiInternalJDL.g:2244:2: iv_rulePaginateGenerationSetting= rulePaginateGenerationSetting EOF
            {
             markComposite(elementTypeProvider.getPaginateGenerationSettingElementType()); 
            pushFollow(FOLLOW_1);
            iv_rulePaginateGenerationSetting=rulePaginateGenerationSetting();

            state._fsp--;

             current =iv_rulePaginateGenerationSetting; 
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
    // $ANTLR end "entryRulePaginateGenerationSetting"


    // $ANTLR start "rulePaginateGenerationSetting"
    // PsiInternalJDL.g:2250:1: rulePaginateGenerationSetting returns [Boolean current=false] : (otherlv_0= 'paginate' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_paginateType_5_0= rulePaginateType ) ) ) ;
    public final Boolean rulePaginateGenerationSetting() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Boolean lv_paginateType_5_0 = null;


        try {
            // PsiInternalJDL.g:2251:1: ( (otherlv_0= 'paginate' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_paginateType_5_0= rulePaginateType ) ) ) )
            // PsiInternalJDL.g:2252:2: (otherlv_0= 'paginate' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_paginateType_5_0= rulePaginateType ) ) )
            {
            // PsiInternalJDL.g:2252:2: (otherlv_0= 'paginate' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_paginateType_5_0= rulePaginateType ) ) )
            // PsiInternalJDL.g:2253:3: otherlv_0= 'paginate' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_paginateType_5_0= rulePaginateType ) )
            {

            			markLeaf(elementTypeProvider.getPaginateGenerationSetting_PaginateKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,43,FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalJDL.g:2260:3: ( (otherlv_1= RULE_ID ) )
            // PsiInternalJDL.g:2261:4: (otherlv_1= RULE_ID )
            {
            // PsiInternalJDL.g:2261:4: (otherlv_1= RULE_ID )
            // PsiInternalJDL.g:2262:5: otherlv_1= RULE_ID
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					markLeaf(elementTypeProvider.getPaginateGenerationSetting_EntitiesEntityCrossReference_1_0ElementType());
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_38); 

            					doneLeaf(otherlv_1);
            				

            }


            }

            // PsiInternalJDL.g:2277:3: (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==13) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // PsiInternalJDL.g:2278:4: otherlv_2= ',' ( (otherlv_3= RULE_ID ) )
            	    {

            	    				markLeaf(elementTypeProvider.getPaginateGenerationSetting_CommaKeyword_2_0ElementType());
            	    			
            	    otherlv_2=(Token)match(input,13,FOLLOW_4); 

            	    				doneLeaf(otherlv_2);
            	    			
            	    // PsiInternalJDL.g:2285:4: ( (otherlv_3= RULE_ID ) )
            	    // PsiInternalJDL.g:2286:5: (otherlv_3= RULE_ID )
            	    {
            	    // PsiInternalJDL.g:2286:5: (otherlv_3= RULE_ID )
            	    // PsiInternalJDL.g:2287:6: otherlv_3= RULE_ID
            	    {

            	    						if (!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

            	    						markLeaf(elementTypeProvider.getPaginateGenerationSetting_EntitiesEntityCrossReference_2_1_0ElementType());
            	    					
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_38); 

            	    						doneLeaf(otherlv_3);
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            			markLeaf(elementTypeProvider.getPaginateGenerationSetting_WithKeyword_3ElementType());
            		
            otherlv_4=(Token)match(input,41,FOLLOW_41); 

            			doneLeaf(otherlv_4);
            		
            // PsiInternalJDL.g:2310:3: ( (lv_paginateType_5_0= rulePaginateType ) )
            // PsiInternalJDL.g:2311:4: (lv_paginateType_5_0= rulePaginateType )
            {
            // PsiInternalJDL.g:2311:4: (lv_paginateType_5_0= rulePaginateType )
            // PsiInternalJDL.g:2312:5: lv_paginateType_5_0= rulePaginateType
            {

            					markComposite(elementTypeProvider.getPaginateGenerationSetting_PaginateTypePaginateTypeParserRuleCall_4_0ElementType());
            				
            pushFollow(FOLLOW_2);
            lv_paginateType_5_0=rulePaginateType();

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
    // $ANTLR end "rulePaginateGenerationSetting"


    // $ANTLR start "entryRulePaginateType"
    // PsiInternalJDL.g:2329:1: entryRulePaginateType returns [Boolean current=false] : iv_rulePaginateType= rulePaginateType EOF ;
    public final Boolean entryRulePaginateType() throws RecognitionException {
        Boolean current = false;

        Boolean iv_rulePaginateType = null;


        try {
            // PsiInternalJDL.g:2329:54: (iv_rulePaginateType= rulePaginateType EOF )
            // PsiInternalJDL.g:2330:2: iv_rulePaginateType= rulePaginateType EOF
            {
             markComposite(elementTypeProvider.getPaginateTypeElementType()); 
            pushFollow(FOLLOW_1);
            iv_rulePaginateType=rulePaginateType();

            state._fsp--;

             current =iv_rulePaginateType; 
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
    // $ANTLR end "entryRulePaginateType"


    // $ANTLR start "rulePaginateType"
    // PsiInternalJDL.g:2336:1: rulePaginateType returns [Boolean current=false] : ( ( (lv_pagination_0_0= 'pagination' ) ) | ( (lv_infiniteScroll_1_0= 'infinite-scroll' ) ) ) ;
    public final Boolean rulePaginateType() throws RecognitionException {
        Boolean current = false;

        Token lv_pagination_0_0=null;
        Token lv_infiniteScroll_1_0=null;

        try {
            // PsiInternalJDL.g:2337:1: ( ( ( (lv_pagination_0_0= 'pagination' ) ) | ( (lv_infiniteScroll_1_0= 'infinite-scroll' ) ) ) )
            // PsiInternalJDL.g:2338:2: ( ( (lv_pagination_0_0= 'pagination' ) ) | ( (lv_infiniteScroll_1_0= 'infinite-scroll' ) ) )
            {
            // PsiInternalJDL.g:2338:2: ( ( (lv_pagination_0_0= 'pagination' ) ) | ( (lv_infiniteScroll_1_0= 'infinite-scroll' ) ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==44) ) {
                alt37=1;
            }
            else if ( (LA37_0==45) ) {
                alt37=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // PsiInternalJDL.g:2339:3: ( (lv_pagination_0_0= 'pagination' ) )
                    {
                    // PsiInternalJDL.g:2339:3: ( (lv_pagination_0_0= 'pagination' ) )
                    // PsiInternalJDL.g:2340:4: (lv_pagination_0_0= 'pagination' )
                    {
                    // PsiInternalJDL.g:2340:4: (lv_pagination_0_0= 'pagination' )
                    // PsiInternalJDL.g:2341:5: lv_pagination_0_0= 'pagination'
                    {

                    					markLeaf(elementTypeProvider.getPaginateType_PaginationPaginationKeyword_0_0ElementType());
                    				
                    lv_pagination_0_0=(Token)match(input,44,FOLLOW_2); 

                    					doneLeaf(lv_pagination_0_0);
                    				

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalJDL.g:2357:3: ( (lv_infiniteScroll_1_0= 'infinite-scroll' ) )
                    {
                    // PsiInternalJDL.g:2357:3: ( (lv_infiniteScroll_1_0= 'infinite-scroll' ) )
                    // PsiInternalJDL.g:2358:4: (lv_infiniteScroll_1_0= 'infinite-scroll' )
                    {
                    // PsiInternalJDL.g:2358:4: (lv_infiniteScroll_1_0= 'infinite-scroll' )
                    // PsiInternalJDL.g:2359:5: lv_infiniteScroll_1_0= 'infinite-scroll'
                    {

                    					markLeaf(elementTypeProvider.getPaginateType_InfiniteScrollInfiniteScrollKeyword_1_0ElementType());
                    				
                    lv_infiniteScroll_1_0=(Token)match(input,45,FOLLOW_2); 

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
    // $ANTLR end "rulePaginateType"


    // $ANTLR start "entryRuleAngularSuffixGenerationSetting"
    // PsiInternalJDL.g:2378:1: entryRuleAngularSuffixGenerationSetting returns [Boolean current=false] : iv_ruleAngularSuffixGenerationSetting= ruleAngularSuffixGenerationSetting EOF ;
    public final Boolean entryRuleAngularSuffixGenerationSetting() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAngularSuffixGenerationSetting = null;


        try {
            // PsiInternalJDL.g:2378:72: (iv_ruleAngularSuffixGenerationSetting= ruleAngularSuffixGenerationSetting EOF )
            // PsiInternalJDL.g:2379:2: iv_ruleAngularSuffixGenerationSetting= ruleAngularSuffixGenerationSetting EOF
            {
             markComposite(elementTypeProvider.getAngularSuffixGenerationSettingElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleAngularSuffixGenerationSetting=ruleAngularSuffixGenerationSetting();

            state._fsp--;

             current =iv_ruleAngularSuffixGenerationSetting; 
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
    // $ANTLR end "entryRuleAngularSuffixGenerationSetting"


    // $ANTLR start "ruleAngularSuffixGenerationSetting"
    // PsiInternalJDL.g:2385:1: ruleAngularSuffixGenerationSetting returns [Boolean current=false] : (otherlv_0= 'angularSuffix' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_id_5_0= RULE_ID ) ) ) ;
    public final Boolean ruleAngularSuffixGenerationSetting() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_id_5_0=null;

        try {
            // PsiInternalJDL.g:2386:1: ( (otherlv_0= 'angularSuffix' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_id_5_0= RULE_ID ) ) ) )
            // PsiInternalJDL.g:2387:2: (otherlv_0= 'angularSuffix' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_id_5_0= RULE_ID ) ) )
            {
            // PsiInternalJDL.g:2387:2: (otherlv_0= 'angularSuffix' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_id_5_0= RULE_ID ) ) )
            // PsiInternalJDL.g:2388:3: otherlv_0= 'angularSuffix' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_id_5_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getAngularSuffixGenerationSetting_AngularSuffixKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,46,FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalJDL.g:2395:3: ( (otherlv_1= RULE_ID ) )
            // PsiInternalJDL.g:2396:4: (otherlv_1= RULE_ID )
            {
            // PsiInternalJDL.g:2396:4: (otherlv_1= RULE_ID )
            // PsiInternalJDL.g:2397:5: otherlv_1= RULE_ID
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					markLeaf(elementTypeProvider.getAngularSuffixGenerationSetting_EntitiesEntityCrossReference_1_0ElementType());
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_38); 

            					doneLeaf(otherlv_1);
            				

            }


            }

            // PsiInternalJDL.g:2412:3: (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==13) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // PsiInternalJDL.g:2413:4: otherlv_2= ',' ( (otherlv_3= RULE_ID ) )
            	    {

            	    				markLeaf(elementTypeProvider.getAngularSuffixGenerationSetting_CommaKeyword_2_0ElementType());
            	    			
            	    otherlv_2=(Token)match(input,13,FOLLOW_4); 

            	    				doneLeaf(otherlv_2);
            	    			
            	    // PsiInternalJDL.g:2420:4: ( (otherlv_3= RULE_ID ) )
            	    // PsiInternalJDL.g:2421:5: (otherlv_3= RULE_ID )
            	    {
            	    // PsiInternalJDL.g:2421:5: (otherlv_3= RULE_ID )
            	    // PsiInternalJDL.g:2422:6: otherlv_3= RULE_ID
            	    {

            	    						if (!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

            	    						markLeaf(elementTypeProvider.getAngularSuffixGenerationSetting_EntitiesEntityCrossReference_2_1_0ElementType());
            	    					
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_38); 

            	    						doneLeaf(otherlv_3);
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);


            			markLeaf(elementTypeProvider.getAngularSuffixGenerationSetting_WithKeyword_3ElementType());
            		
            otherlv_4=(Token)match(input,41,FOLLOW_4); 

            			doneLeaf(otherlv_4);
            		
            // PsiInternalJDL.g:2445:3: ( (lv_id_5_0= RULE_ID ) )
            // PsiInternalJDL.g:2446:4: (lv_id_5_0= RULE_ID )
            {
            // PsiInternalJDL.g:2446:4: (lv_id_5_0= RULE_ID )
            // PsiInternalJDL.g:2447:5: lv_id_5_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getAngularSuffixGenerationSetting_IdIDTerminalRuleCall_4_0ElementType());
            				
            lv_id_5_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_id_5_0);
            				

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
    // $ANTLR end "ruleAngularSuffixGenerationSetting"


    // $ANTLR start "ruleCardinality"
    // PsiInternalJDL.g:2466:1: ruleCardinality returns [Boolean current=false] : ( (enumLiteral_0= 'OneToMany' ) | (enumLiteral_1= 'ManyToOne' ) | (enumLiteral_2= 'OneToOne' ) | (enumLiteral_3= 'ManyToMany' ) ) ;
    public final Boolean ruleCardinality() throws RecognitionException {
        Boolean current = false;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

        try {
            // PsiInternalJDL.g:2467:1: ( ( (enumLiteral_0= 'OneToMany' ) | (enumLiteral_1= 'ManyToOne' ) | (enumLiteral_2= 'OneToOne' ) | (enumLiteral_3= 'ManyToMany' ) ) )
            // PsiInternalJDL.g:2468:2: ( (enumLiteral_0= 'OneToMany' ) | (enumLiteral_1= 'ManyToOne' ) | (enumLiteral_2= 'OneToOne' ) | (enumLiteral_3= 'ManyToMany' ) )
            {
            // PsiInternalJDL.g:2468:2: ( (enumLiteral_0= 'OneToMany' ) | (enumLiteral_1= 'ManyToOne' ) | (enumLiteral_2= 'OneToOne' ) | (enumLiteral_3= 'ManyToMany' ) )
            int alt39=4;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt39=1;
                }
                break;
            case 48:
                {
                alt39=2;
                }
                break;
            case 49:
                {
                alt39=3;
                }
                break;
            case 50:
                {
                alt39=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // PsiInternalJDL.g:2469:3: (enumLiteral_0= 'OneToMany' )
                    {
                    // PsiInternalJDL.g:2469:3: (enumLiteral_0= 'OneToMany' )
                    // PsiInternalJDL.g:2470:4: enumLiteral_0= 'OneToMany'
                    {

                    				markLeaf(elementTypeProvider.getCardinality_OneToManyEnumLiteralDeclaration_0ElementType());
                    			
                    enumLiteral_0=(Token)match(input,47,FOLLOW_2); 

                    				doneLeaf(enumLiteral_0);
                    			

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalJDL.g:2479:3: (enumLiteral_1= 'ManyToOne' )
                    {
                    // PsiInternalJDL.g:2479:3: (enumLiteral_1= 'ManyToOne' )
                    // PsiInternalJDL.g:2480:4: enumLiteral_1= 'ManyToOne'
                    {

                    				markLeaf(elementTypeProvider.getCardinality_ManyToOneEnumLiteralDeclaration_1ElementType());
                    			
                    enumLiteral_1=(Token)match(input,48,FOLLOW_2); 

                    				doneLeaf(enumLiteral_1);
                    			

                    }


                    }
                    break;
                case 3 :
                    // PsiInternalJDL.g:2489:3: (enumLiteral_2= 'OneToOne' )
                    {
                    // PsiInternalJDL.g:2489:3: (enumLiteral_2= 'OneToOne' )
                    // PsiInternalJDL.g:2490:4: enumLiteral_2= 'OneToOne'
                    {

                    				markLeaf(elementTypeProvider.getCardinality_OneToOneEnumLiteralDeclaration_2ElementType());
                    			
                    enumLiteral_2=(Token)match(input,49,FOLLOW_2); 

                    				doneLeaf(enumLiteral_2);
                    			

                    }


                    }
                    break;
                case 4 :
                    // PsiInternalJDL.g:2499:3: (enumLiteral_3= 'ManyToMany' )
                    {
                    // PsiInternalJDL.g:2499:3: (enumLiteral_3= 'ManyToMany' )
                    // PsiInternalJDL.g:2500:4: enumLiteral_3= 'ManyToMany'
                    {

                    				markLeaf(elementTypeProvider.getCardinality_ManyToManyEnumLiteralDeclaration_3ElementType());
                    			
                    enumLiteral_3=(Token)match(input,50,FOLLOW_2); 

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
    // $ANTLR end "ruleCardinality"


    // $ANTLR start "ruleServiceType"
    // PsiInternalJDL.g:2512:1: ruleServiceType returns [Boolean current=false] : ( (enumLiteral_0= 'serviceClass' ) | (enumLiteral_1= 'serviceImpl' ) ) ;
    public final Boolean ruleServiceType() throws RecognitionException {
        Boolean current = false;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

        try {
            // PsiInternalJDL.g:2513:1: ( ( (enumLiteral_0= 'serviceClass' ) | (enumLiteral_1= 'serviceImpl' ) ) )
            // PsiInternalJDL.g:2514:2: ( (enumLiteral_0= 'serviceClass' ) | (enumLiteral_1= 'serviceImpl' ) )
            {
            // PsiInternalJDL.g:2514:2: ( (enumLiteral_0= 'serviceClass' ) | (enumLiteral_1= 'serviceImpl' ) )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==51) ) {
                alt40=1;
            }
            else if ( (LA40_0==52) ) {
                alt40=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // PsiInternalJDL.g:2515:3: (enumLiteral_0= 'serviceClass' )
                    {
                    // PsiInternalJDL.g:2515:3: (enumLiteral_0= 'serviceClass' )
                    // PsiInternalJDL.g:2516:4: enumLiteral_0= 'serviceClass'
                    {

                    				markLeaf(elementTypeProvider.getServiceType_ServiceClassEnumLiteralDeclaration_0ElementType());
                    			
                    enumLiteral_0=(Token)match(input,51,FOLLOW_2); 

                    				doneLeaf(enumLiteral_0);
                    			

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalJDL.g:2525:3: (enumLiteral_1= 'serviceImpl' )
                    {
                    // PsiInternalJDL.g:2525:3: (enumLiteral_1= 'serviceImpl' )
                    // PsiInternalJDL.g:2526:4: enumLiteral_1= 'serviceImpl'
                    {

                    				markLeaf(elementTypeProvider.getServiceType_ServiceImplEnumLiteralDeclaration_1ElementType());
                    			
                    enumLiteral_1=(Token)match(input,52,FOLLOW_2); 

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
    // $ANTLR end "ruleServiceType"


    // $ANTLR start "ruleDTOType"
    // PsiInternalJDL.g:2538:1: ruleDTOType returns [Boolean current=false] : (enumLiteral_0= 'mapstruct' ) ;
    public final Boolean ruleDTOType() throws RecognitionException {
        Boolean current = false;

        Token enumLiteral_0=null;

        try {
            // PsiInternalJDL.g:2539:1: ( (enumLiteral_0= 'mapstruct' ) )
            // PsiInternalJDL.g:2540:2: (enumLiteral_0= 'mapstruct' )
            {
            // PsiInternalJDL.g:2540:2: (enumLiteral_0= 'mapstruct' )
            // PsiInternalJDL.g:2541:3: enumLiteral_0= 'mapstruct'
            {

            			markLeaf(elementTypeProvider.getDTOType_MapstructEnumLiteralDeclarationElementType());
            		
            enumLiteral_0=(Token)match(input,53,FOLLOW_2); 

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
    // $ANTLR end "ruleDTOType"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00004DA000000802L});
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
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0007800000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000004000001000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000020004000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000020000002000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0018000000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000300000000000L});

}